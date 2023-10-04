package org.java.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.java.app.model.Movie;
import org.java.app.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

//	@GetMapping("/")
//	@ResponseBody
//	public String test() {
//		return "Hello world";
//	}
	
	@GetMapping("/")
	public String test1(Model model) {
		
		final String name = "Andrea";
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	public List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "Ritorno al futuro"));
		movies.add(new Movie(2, "Sherlock Holmes"));
		movies.add(new Movie(3, "Inside Man"));

		return movies;
	}

	public List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "With Or Without You"));
		songs.add(new Song(2, "Ruby"));
		songs.add(new Song(3, "Narcotic"));

		return songs;
	}
	
	@GetMapping("/movies")
    public String movies(Model model) {
		
		//travaso l'array list da moives a movieList
		List<Movie> moviesList = getBestMovies();

		//movieList può essere sostituito con getBestMovies() perché ritorna già una lista
		model.addAttribute("moviesList", moviesList);
		
        return "movies";
    }
	
	@GetMapping("/songs")
	public String songs(Model model) {
		
		List<Song> songsList = getBestSongs();
		model.addAttribute("songsList", songsList);
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieDetails(@PathVariable int id, Model model) {
		
		Movie movie = getBestMovies().stream()
							.filter(m -> m.getId() == id)
						.findFirst().get();
		
//		String movieTitle = movie.getTitolo();
		
		model.addAttribute("movie", movie);
		
		return "movie-details";
	}
	
	@GetMapping("/songs/{id}")
	public String getSongDetails(@PathVariable int id, Model model) {
		
		Song song = getBestSongs().stream()
				.filter(s -> s.getId() == id)
				.findFirst().get();
		
//		String songTitle = song.getTitolo();
		
		model.addAttribute("song", song);
		
		return "song-details";
	}
}
