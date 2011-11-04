package com.acme.youTask.web.controller;

import com.acme.youTask.business.AufgabeService;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mdahm
 * @author miwaszkiewicz
 */
@Named
@ConversationScoped
public class AufgabeController implements Serializable {

    private Kategorie kategorieFilter;

    private Aufgabe aufgabe;

    @Inject
    private Logger _log;

    @Inject
    private AufgabeService aufgabeService;

    public List<Aufgabe> getAufgaben() {
        List<Aufgabe> aufgaben = new ArrayList<Aufgabe>();
        List<Aufgabe> all = aufgabeService.loadAll();

        if (kategorieFilter != null) {
            for (Aufgabe aufgabe : all) {
                if (aufgabe.getKategorie() == kategorieFilter) {
                    aufgaben.add(aufgabe);
                }
            }
        } else {
            aufgaben = all;
        }

        return aufgaben;
    }

    @PostConstruct
    public void init() {
        aufgabe = new Aufgabe();
    }

    /**
     * Speichert 'aufgabe'
     */
    public void saveAufgabe() {
        // neue Aufgabe sind immer initial nicht erledigt
        aufgabe.setErledigt(false);
        aufgabeService.saveAufgabe(aufgabe);
    }

    public Kategorie getKategorieFilter() {
        return kategorieFilter;
    }

    public void setKategorieFilter(Kategorie kategorieFilter) {
        this.kategorieFilter = kategorieFilter;
    }

    public void filterChanged(ValueChangeEvent event) {
        kategorieFilter = (Kategorie) event.getNewValue();
        _log.debugv("category filter changed to", kategorieFilter);
    }

    public Aufgabe getAufgabe() {
        return aufgabe;
    }
}
