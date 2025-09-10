package br.com.movieflix.controller;

import br.com.movieflix.controller.request.MovieRequest;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.mapper.MovieMapper;
import br.com.movieflix.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
@Tag(name = "Movie", description = "Endpoints for managing movies")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "save a new movie", description = "Saves a new movie with the provided details",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Movie created successfully",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PostMapping
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request){
       Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
       return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));

    }

    @Operation(summary = "get all movies", description = "Retrieves a list of all movies",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "List of movies retrieved successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());

    }

    @Operation(summary = "get movie by id", description = "Retrieves a movie by its ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Movie retrieved successfully",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id){
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());

    }

    @Operation(summary = "update movie by id", description = "Updates an existing movie with the provided details",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Movie updated successfully",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content())
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request){
        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());

    }

    @Operation(summary = "get movies by category", description = "Retrieves a list of movies filtered by category ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "List of movies retrieved successfully",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category){
        return ResponseEntity.ok(movieService.findByCategory(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());

    }

    @Operation(summary = "delete movie by id", description = "Deletes a movie by its ID",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Movie deleted successfully", content = @Content())
    @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content())
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        Optional<Movie> optMovie = movieService.findById(id);
        if (optMovie.isPresent()) {
            movieService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
