package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {

    private final List<Song> list = new ArrayList<>();

    public SongRepository() {
        list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream()
                   .filter(song -> song.getId().equals(id))
                   .findFirst()
                   .orElse(null);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        Song existingSong = getSongById(s.getId());
        if (existingSong != null) {
            existingSong.setNome(s.getNome());
            existingSong.setArtista(s.getArtista());
            existingSong.setAlbum(s.getAlbum());
            existingSong.setAnoLancamento(s.getAnoLancamento());
        }
    }

    public void removeSong(Song s) {
        list.removeIf(song -> song.getId().equals(s.getId()));
    }
}