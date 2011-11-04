package com.acme.youTask.business;

import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;

import javax.ejb.Local;
import java.util.List;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Local
public interface AufgabeService {

    void saveAufgabe(final Aufgabe aufgabe);

    void removeAufgabe(final Aufgabe aufgabe);

    List<Aufgabe> loadAll();

    List<Aufgabe> loadForKategorie(Kategorie kategorie);
}
