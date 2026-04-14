package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_different_class() {
        assertFalse(team.equals("non team"));
    }

    @Test
    public void equals_returns_true_same_name_and_members() {
        Team other_team = new Team("test-team");
        team.addMember("John");
        other_team.addMember("John");

        assertTrue(team.equals(other_team));
    }

    @Test
    public void equals_returns_false_same_name_different_members() {
        Team other_team = new Team("test-team");
        team.addMember("John");

        assertFalse(team.equals(other_team));
    }

    @Test
    public void equals_returns_false_different_name_same_members() {
        Team other_team = new Team("different-team");
        team.addMember("John");
        other_team.addMember("John");

        assertFalse(team.equals(other_team));
    }

    @Test
    public void hashCode_returns_expected_value() {
        Team t = new Team();
        t.setName("test-team");
        t.addMember("John");

        int result = t.hashCode();
        int expectedResult = -1226081286;

        assertEquals(expectedResult, result);
    }
}
