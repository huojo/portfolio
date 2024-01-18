/* eslint-disable prettier/prettier */
import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {
  SafeAreaView,
  StatusBar,
  StyleSheet,
  Text,
  ScrollView,
  View,
  Image,
  TouchableHighlight,
} from 'react-native';



const MovieListItem = (props) => {
  let IMAGEPATH = 'http://image.tmdb.org/t/p/w500';
  let imageurl = IMAGEPATH + props.movie.poster_path;
  return (
    <View style={styles.movieItem}>
      <View style={styles.movieItemImage}>
        <Image source={{uri: imageurl}} style={{width: 99, height: 146}} />
      </View>
      <View style={{marginRight: 50}}>
        <Text style={styles.movieItemTitle}>{props.movie.title}</Text>
        <Text style={styles.movieItemText}>{props.movie.release_date}</Text>
        <Text numberOfLines={6} ellipsizeMode="tail" style={styles.movieItemText}>{props.movie.overview}</Text>
      </View>
    </View>
  );
};

const MoviesList = (props) => {
  const [movies, setMovies] = useState([]);
  const API_KEY = "MY API KEY";
  const itemPressed = (index) => {
    props.navigation.navigate(
      'MovieDetails',
      { movie: movies[index] });
  };

  useEffect(() => {
    axios
      .get(`https://api.themoviedb.org/3/movie/now_playing?api_key=${API_KEY}&append_to_response=videos`)
      .then(response => {
        // check console - a movie data should be visible there
        console.log(response.data.results);
        setMovies(response.data.results);
      });
  }, []);

  if (movies.length === 0) {
    return (
      <View style={{flex: 1, padding: 20}}>
        <Text>Loading, please wait...</Text>
      </View>
    );
  }
  let movieItems = movies.map(function(movie,index){
    return (
      <TouchableHighlight onPress={_ => itemPressed(index)}
                  underlayColor="lightgray" key={index}>
      <MovieListItem movie={movie} key={index}/>
    </TouchableHighlight>
    );
  });

  return (
    <ScrollView>
      {movieItems}
    </ScrollView>
  );
};

const MovieListScreen = ({ navigation }) => {

  return (
    <SafeAreaView>
      <StatusBar/>
      <ScrollView style={styles.sectionContainer}>
      <MoviesList navigation={ navigation }/>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  movieItem: {
    margin: 5,
    flex: 1,
    flexDirection: 'row',
  },
  movieItemImage: {
    marginRight: 5,
  },
  movieItemTitle: {
    fontWeight: 'bold',
  },
  movieItemText: {
    flexWrap: 'wrap',
  },
});

export default MovieListScreen;
