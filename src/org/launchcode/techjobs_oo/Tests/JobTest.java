package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.launchcode.techjobs_oo.*;

public class JobTest {

//    @Before
//    public void createJob() {
//       Job test_job = new Job();
//       Job second_job = new Job();
//    }

    @Test
    public void emptyJobConstructorTest() {
        Job test_job = new Job();
        Job second_job = new Job();
        assertEquals(1, test_job.getId(), .001);
        assertEquals(2, second_job.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job full_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        Job test_job = new Job();
        Job second_job = new Job();
        assertFalse(test_job.equals(second_job));
    }
}
