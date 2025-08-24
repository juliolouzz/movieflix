package br.com.movieflix.controller.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record MovieResponse(Long id, String title, String description, LocalDate releaseDate, double rating, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
