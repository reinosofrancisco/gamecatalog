package com.repositories.gamescatalog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "genre")
	private String genre;
	@Column(name = "platform")
	private String platform;
	@Column(name = "release_date")
	private String releaseDate;
	@Column(name = "img_url")
	private String imgUrl;
	@Column(name = "developer")
	private String developer;
	@Column(name = "publisher")
	private String publisher;



}
