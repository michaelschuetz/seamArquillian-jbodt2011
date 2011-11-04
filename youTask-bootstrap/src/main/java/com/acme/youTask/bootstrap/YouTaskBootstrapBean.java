package com.acme.youTask.bootstrap;

import com.acme.youTask.dao.AufgabeDao;
import com.acme.youTask.dao.common.GenericDao;
import com.acme.youTask.domain.AbstractEntity;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;

import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@Singleton
@Startup
public class YouTaskBootstrapBean {
  @Inject
  private Logger log;

  // @Inject geht hier nicht wegen der Vererbung (GenericDao<E,ID>)!!! ->
  // Weld/CDI-Bug
  @EJB
  private AufgabeDao aufgabeDao;

  @PostConstruct
  public void insert() {
    log.debug("Setup data in data base...");

    setupAufgabe();

    log.debug("Test data has been successfully set up");
  }

  private void setupAufgabe() {

    final Aufgabe aufgabe1 = new Aufgabe("call my wife", Kategorie.TODO, true);
    final Aufgabe aufgabe2 = new Aufgabe("rearrange office", Kategorie.IDEEN, false);
    final Aufgabe aufgabe3 = new Aufgabe("task management", Kategorie.IDEEN, false);
    final Aufgabe aufgabe4 = new Aufgabe("send offer", Kategorie.TODO, false);
    final Aufgabe aufgabe5 = new Aufgabe("TaskForce", Kategorie.LESEN, false);

    save(aufgabeDao, aufgabe1, aufgabe2, aufgabe3, aufgabe4, aufgabe5);
  }

  private <T extends AbstractEntity> void save(final GenericDao<T> dao, final T... entities) {
    for (final T entity : entities) {
      dao.persist(entity);
    }
  }
}
