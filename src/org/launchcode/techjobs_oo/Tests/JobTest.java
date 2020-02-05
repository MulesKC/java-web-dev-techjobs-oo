package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import javax.swing.text.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

//@RunWith(JUnit4.class)
public class JobTest {

    Job test_job1;
    //2 and 3 used in testSettingJobId()
    Job test_job2;
    Job test_job3;
    //4 used in testJobsForEquality(),
    Job test_job4;

    @Before
    public void createJobObjects() {


        test_job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId() {

        test_job2 = new Job();
        test_job3 = new Job();

        assertFalse(test_job2.getId() == test_job3.getId());
        assertTrue(test_job2.getId() == test_job3.getId() - 1);

    }

    @Test
    public void testJobConstructorSetsAllFields() {


        assertEquals(test_job1.getName(), "Product tester");

        assertEquals(test_job1.getEmployer().toString(), "ACME");
        assertTrue(test_job1.getEmployer() instanceof Employer);


        assertEquals(test_job1.getLocation().toString(), "Desert");
        assertTrue(test_job1.getLocation() instanceof Location);

        assertEquals(test_job1.getPositionType().toString(), "Quality control");
        assertTrue(test_job1.getPositionType() instanceof PositionType);

        assertEquals(test_job1.getCoreCompetency().toString(), "Persistence");
        assertTrue(test_job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {

        test_job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        test_job3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(test_job2.equals(test_job3));

    }

    @Test
    public void testToStringHasTwoBlankLineBorders() {


        assertTrue(test_job1.toString().startsWith("\n"));
        assertTrue(test_job1.toString().endsWith("\n"));

    }

    @Test
    public void testToStringFieldsFormatted() {

        assertTrue(test_job1.toString().contains("ID: " + test_job1.getId()));
        assertTrue(test_job1.toString().contains("Name: " + test_job1.getName()));
        assertTrue(test_job1.toString().contains("Employer: " + test_job1.getEmployer()));
        assertTrue(test_job1.toString().contains("Location: " + test_job1.getLocation()));
        assertTrue(test_job1.toString().contains("Position Type: " + test_job1.getPositionType()));
        assertTrue(test_job1.toString().contains("Core Competency: " + test_job1.getCoreCompetency()));

    }

    @Test
    public void testToStringEmptyField() {
        test_job2 = new Job();

        test_job2.toString();

        assertTrue(test_job2.toString().contains("ID: " + test_job2.getId()));
        assertTrue(test_job2.toString().contains("Name: " + "Data not available"));
        assertTrue(test_job2.toString().contains("Employer: " + "Data not available"));
        assertTrue(test_job2.toString().contains("Location: " + "Data not available"));
        assertTrue(test_job2.toString().contains("Position Type: " + "Data not available"));
        assertTrue(test_job2.toString().contains("Core Competency: " + "Data not available"));

    }

}
