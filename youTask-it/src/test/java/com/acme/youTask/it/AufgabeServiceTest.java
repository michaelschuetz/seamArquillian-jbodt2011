package com.acme.youTask.it;

import com.acme.youTask.business.AufgabeService;
import com.acme.youTask.business.AufgabeServiceBean;
import com.acme.youTask.dao.AufgabeDao;
import com.acme.youTask.dao.AufgabeDaoBean;
import com.acme.youTask.dao.common.GenericDao;
import com.acme.youTask.dao.common.JpaGenericDao;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;
import com.acme.youTask.util.ArquillianHelper;
import com.acme.youTask.util.MavenArtifactResolver;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
@RunWith(Arquillian.class)
public class AufgabeServiceTest {

    @Inject
    private Logger log;

    @Inject
    private AufgabeService aufgabeService;

    @Deployment
    public static WebArchive createWebArchive() {

        final WebArchive webArchive = ArquillianHelper.aufgabeWebArchive;
        return webArchive;
    }

    @Test
    public void testPersist() throws Exception {
        log.info("testPersist");

        final Aufgabe aufgabe1 = new Aufgabe("call my wife", Kategorie.TODO, false);
        final Aufgabe aufgabe2 = new Aufgabe("call my wife twice", Kategorie.TODO, false);
        final Aufgabe aufgabe3 = new Aufgabe("rearrange office", Kategorie.IDEEN, false);

        aufgabeService.saveAufgabe(aufgabe1);
        aufgabeService.saveAufgabe(aufgabe2);
        aufgabeService.saveAufgabe(aufgabe3);

        Assert.assertNotNull(aufgabe1.getId());

        Assert.assertEquals(3, aufgabeService.loadAll().size());
        Assert.assertEquals(2, aufgabeService.loadForKategorie(Kategorie.TODO).size());

        log.info("testPersist succeeded");
    }
}
