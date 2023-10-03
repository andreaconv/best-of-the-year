package org.java.app.controller;

import java.util.ArrayList;
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
		List<Movie> Movies = new ArrayList<>();
		Movies.add(new Movie("Ritorno al futuro", 1));
		Movies.add(new Movie("Sherlock Holmes", 2));
		Movies.add(new Movie("Inside Man", 3));

		return Movies;
	}

	public List<Song> getBestSongs() {
		List<Song> Songs = new ArrayList<>();
		Songs.add(new Song("With Or Without You", 1));
		Songs.add(new Song("Ruby", 2));
		Songs.add(new Song("Narcotic", 3));

		return Songs;
	}
	
	@GetMapping("/movies")
    public String movies(Model model) {
        String moviesList = getBestMovies().stream()
        		.map(m -> m.getTitolo())
        		.collect(Collectors.joining(", "));
        model.addAttribute("movies", moviesList);
        return "movies";
    }
	
	@GetMapping("/songs")
	public String songs(Model model) {
		String songsList = getBestSongs().stream()
				.map(s -> s.getTitolo())
				.collect(Collectors.joining(", "));
		model.addAttribute("songs", songsList);
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieDetails(@PathVariable int id, Model model) {
		
		Movie movie = getBestMovies().stream()
							.filter(m -> m.getId() == id)
						.findFirst().get();
		String movieTitle = movie.getTitolo();
		
		model.addAttribute("movieTitle", movieTitle);
		
		return "movie-details";
	}
	
	@GetMapping("/songs/{id}")
	public String getSongDetails(@PathVariable int id, Model model) {
		
		Song song = getBestSongs().stream()
				.filter(s -> s.getId() == id)
				.findFirst().get();
		String songTitle = song.getTitolo();
		
		model.addAttribute("songTitle", songTitle);
		
		return "song-details";
	}
}
