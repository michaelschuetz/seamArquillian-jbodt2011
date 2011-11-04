package com.acme.youTask.domain.enums;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
public enum Kategorie implements I18nEnum {

  TODO("com.acme.youTask.kategorie.todo"),     // (rot), 
  WARTEND("com.acme.youTask.kategorie.wartend"),  // (blau)
  IDEEN("com.acme.youTask.kategorie.ideen"),    // (grün)
  LESEN("com.acme.youTask.kategorie.lesen"),    // (gelb)
  PRIVAT("com.acme.youTask.kategorie.privat");   // (rosa)

  private final String _i18nDescriptionId;

  private Kategorie(final String i18nDescriptionId) {
    _i18nDescriptionId = i18nDescriptionId;
  }

  @Override
  public String getI18nDescriptionId() {
    return _i18nDescriptionId;
  }
  
}
