package com.acme.youTask.dao;

import java.util.List;

import com.acme.youTask.dao.common.GenericDao;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;

import javax.ejb.Local;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Local
public interface AufgabeDao extends GenericDao<Aufgabe>{
  
  List<Aufgabe> ladeZurKategorie(Kategorie kategorie);
  
}
