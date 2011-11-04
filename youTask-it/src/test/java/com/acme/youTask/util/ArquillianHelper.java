package com.acme.youTask.util;

import com.acme.youTask.business.AufgabeService;
import com.acme.youTask.business.AufgabeServiceBean;
import com.acme.youTask.dao.AufgabeDao;
import com.acme.youTask.dao.AufgabeDaoBean;
import com.acme.youTask.dao.common.GenericDao;
import com.acme.youTask.dao.common.JpaGenericDao;
import com.acme.youTask.domain.Aufgabe;
import com.acme.youTask.domain.enums.Kategorie;
import com.acme.youTask.util.MavenArtifactResolver;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * @author <a href="mailto:michaelschuetz83@gmail.com">Michael Schuetz</a>
 */
public final class ArquillianHelper {

    private ArquillianHelper(){}

    public static final WebArchive aufgabeWebArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Aufgabe.class.getPackage())
                .addPackage(Kategorie.class.getPackage())
                .addClasses(AufgabeServiceBean.class, AufgabeService.class).addClasses(AufgabeDaoBean.class)
                .addClasses(JpaGenericDao.class, GenericDao.class, AufgabeDao.class, AufgabeDaoBean.class)
                .addAsLibraries(MavenArtifactResolver.resolve("org.jboss.seam.solder:seam-solder:3.0.0.Final"))
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");


}
