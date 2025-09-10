package br.com.movieflix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@Schema(type = "string", description = "Movie title", example = "Inception")
                           @NotEmpty(message = "Movie title is required.") String title,
                           @Schema(type = "string", description = "Movie description", example = "A mind-bending thriller about dreams within dreams.")
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "date", description = "Release date of the movie", example = "16/07/2010")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Movie rating", example = "8.8")
                           double rating,
                           @Schema(type = "array", description = "List of category IDs associated with the movie", example = "[1, 2, 3]")
                           List<Long> categories,
                           @Schema(type = "array", description = "List of streaming service IDs where the movie is available", example = "[1, 2]")
                           List<Long> streamings) {
}
