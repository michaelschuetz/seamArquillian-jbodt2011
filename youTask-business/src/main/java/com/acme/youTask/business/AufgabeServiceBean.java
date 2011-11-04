package com.acme.youTask.business;

import com.acme.youTask.dao.AufgabeDao;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Stateless
public class AufgabeServiceBean implements AufgabeService {
  
  @EJB
  private AufgabeDao aufgabeDao;

  @Override
  public void saveAufgabe(final Aufgabe aufgabe) {
    aufgabeDao.persist(aufgabe);
  }

  @Override
  public void removeAufgabe(final Aufgabe aufgabe) {
    aufgabeDao.delete(aufgabe);
  }

  @Override
  public List<Aufgabe> loadAll() {
    return aufgabeDao.loadAll();
  }

  @Override
  public List<Aufgabe> loadForKategorie(Kategorie kategorie) {
    return aufgabeDao.ladeZurKategorie(kategorie);
  }

}
