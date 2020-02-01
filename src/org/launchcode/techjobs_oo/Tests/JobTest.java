package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import javax.swing.text.Position;

import static org.junit.Assert.*;

//@RunWith(JUnit4.class)
public class JobTest {

    Job test_job;
    Job test_job2;

    @Before
    public void createJobObjects() {


        test_job = new Job();
        test_job2 = new Job();
    }

    @Test
    public void testSettingJobId() {

        assertFalse(test_job.getId() == test_job2.getId());
        assertTrue(test_job.getId() == test_job2.getId() - 1);

    }

    @Test
    public void testJobConstructorSetsAllFields() {

        test_job = new Job("Product tester",
                            new Employer("ACME"),
                            new Location("Desert"),
                            new PositionType("Quality control"),
                            new CoreCompetency("Persistence"));

        assertEquals(test_job.getName(), "Product tester");

        assertEquals(test_job.getEmployer().toString(), "ACME");
        assertTrue(test_job.getEmployer() instanceof Employer);


        assertEquals(test_job.getLocation().toString(), "Desert");
        assertTrue(test_job.getLocation() instanceof Location);

        assertEquals(test_job.getPositionType().toString(), "Quality control");
        assertTrue(test_job.getPositionType() instanceof PositionType);

        assertEquals(test_job.getCoreCompetency().toString(), "Persistence");
        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
    }

    public void testJobsForEquality() {
        test_job = new Job("Accountant",
                    new Employer("Sears"),
                    new Location("Cuba"),
                    new PositionType("Entry"),
                    new CoreCompetency("Strategy"));
        test_job2 = new Job("Accountant",
                    new Employer("Sears"),
                    new Location("Cuba"),
                    new PositionType("Entry"),
                    new CoreCompetency("Strategy"));

        assertFalse(test_job.equals(test_job2));
    }
}
