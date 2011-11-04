package com.acme.youTask.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.acme.youTask.domain.enums.Kategorie;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Entity
@Table
@NamedQuery(name = Aufgabe.QUERY_LADE_ZUR_KATEGORIE, query="FROM Aufgabe a WHERE a.kategorie = :" + Aufgabe.PARAM_KATEGORIE)
public class Aufgabe extends AbstractEntity {

  public static final String QUERY_LADE_ZUR_KATEGORIE = "ladeZurKategorie";
  public static final String PARAM_KATEGORIE = "kategorie";

  @Column
  private String bezeichnung;

  @Column
  @Enumerated(EnumType.STRING)
  private Kategorie kategorie;

  @Column
  private boolean erledigt;

  // --------------- Konstruktoren ------------------------------------------

  public Aufgabe() {
    // NOP
  }

  public Aufgabe(String bezeichnung, Kategorie kategorie, boolean erledigt) {
    this.bezeichnung = bezeichnung;
    this.kategorie = kategorie;
    this.erledigt = erledigt;
  }

  // ---------------- Getter / Setter ---------------------------------------

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public Kategorie getKategorie() {
    return kategorie;
  }

  public void setKategorie(Kategorie kategorie) {
    this.kategorie = kategorie;
  }

  public boolean isErledigt() {
    return erledigt;
  }

  public void setErledigt(boolean erledigt) {
    this.erledigt = erledigt;
  }

}
