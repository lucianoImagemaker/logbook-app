package com.rgfp.psd.logbook.domain;

import org.junit.Test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class NoteTest {

    @Test
    public void validadQueLosAtributosEnNoteExistan() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Note note= new Note();
        note.setId(1L);
        note.setTitle("Titulo Prueba");
        note.setTimestamp(LocalDateTime.parse("2018-06-12 00:00",formatter));
        note.setContent("Esto es una prueba de testo largo. Esto es una prueba de testo largo");
        assertEquals(1L,note.getId());
        assertEquals("Titulo Prueba",note.getTitle());
        assertEquals(LocalDateTime.parse("2018-06-12 00:00",formatter),note.getTimestamp());
        assertEquals("Esto es una prueba de testo largo. Esto es una prueba de testo largo" , note.getContent());
        assertEquals("Esto es un" , note.getSummary());
    }

    @Test
    public void validaQueGetSummaryFuncioneCorrectamente() {
        Note note= new Note();
        note.setContent("Texto de prueba 2");
        assertEquals("Texto de p" , note.getSummary());
    }

    @Test
    public void validaQueGetSummaryMuestreUnTextoConMenosDe10Caracteres() {
        Note note= new Note();
        note.setContent("Nada");
        assertEquals("Nada" , note.getSummary());
    }
}