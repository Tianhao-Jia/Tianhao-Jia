package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import androidx.annotation.NonNull;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class JobSearchEspressoTest {

    @Rule
    public ActivityScenarioRule myRule =
            new ActivityScenarioRule(JobSearch.class);

    @BeforeClass
    public static void setup() {
        Intents.init();
    }

    @AfterClass
    public static void tearDown() {
        Intents.release();
        FirebaseDatabase.getInstance().getReference("jobs").setValue(null);
    }

    @Test
    public void searchNoJobsExist(){


        onView(withId(R.id.searchJobButton)).perform(click());

    }

    @Test
    public void searchJobsExistNoJobsInfoProvided(){



        onView(withId(R.id.searchJobButton)).perform(click());



    }

    @Test
    public void searchJobsExistJobsInfoProvided(){


        onView(withId(R.id.searchJobButton)).perform(click());

    }

}