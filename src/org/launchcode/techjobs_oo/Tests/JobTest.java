package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.launchcode.techjobs_oo.*;

public class JobTest {

    private Job test_job;
    private Job second_job;
    private Job full_job;
    private Job partial_job;


    @Before
    public void createJobs() {
       test_job = new Job();
       second_job = new Job();
       partial_job = new Job("Coder", null, null, null, null);
       full_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void emptyJobConstructorTest() {
        assertEquals(1, test_job.getId(), .001);
        assertEquals(2, second_job.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", full_job.getName());
        assertTrue(full_job.getEmployer() instanceof Employer);
        assertEquals("ACME", full_job.getEmployer().toString());
        assertTrue(full_job.getLocation() instanceof  Location);
        assertEquals("Desert", full_job.getLocation().toString());
        assertTrue(full_job.getPositionType() instanceof  PositionType);
        assertEquals("Quality control", full_job.getPositionType().toString());
        assertTrue(full_job.getCoreCompetency() instanceof  CoreCompetency);
        assertEquals("Persistence", full_job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job.equals(second_job));
    }

    @Test
    public void testJobToStringBlankLines() {
       assertEquals('\n', test_job.toString().charAt(0));
       assertEquals('\n', test_job.toString().charAt(test_job.toString().length()-1));
    }

    @Test
    public void testJobDisplayInfo() {
        assertEquals(
                "\nID: 4\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", full_job.toString()
        );
    }

    @Test
    public void testEmptyJobInfoDisplay() {
        assertEquals(
                "\nOOPS! This job does not seem to exist.\n", test_job.toString()
        );
    }

    @Test
    public void testIndividualEmptyField() {
        assertEquals("\nID: 3\nName: Coder\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", partial_job.toString());
    }
}
