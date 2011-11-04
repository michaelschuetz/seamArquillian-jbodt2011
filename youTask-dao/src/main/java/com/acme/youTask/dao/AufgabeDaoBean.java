package com.acme.youTask.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.acme.youTask.dao.common.JpaGenericDao;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Stateless
public class AufgabeDaoBean extends JpaGenericDao<Aufgabe> implements AufgabeDao {
  
  public List<Aufgabe> ladeZurKategorie(Kategorie kategorie){

    final Map<String, Object> paramMap = createParameterMap(Aufgabe.PARAM_KATEGORIE, kategorie);
    
    return findByNamedQuery(Aufgabe.QUERY_LADE_ZUR_KATEGORIE, paramMap);
  }
}
