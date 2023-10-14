package com.example.colors;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.colors.ui.ColorActivity;
import com.example.colors.ui.MainActivity;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void init() {
        Intents.init();
    }

    @Test
    public void checkButton() {
        onView(withId(R.id.button_open_activity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_open_activity)).check(matches(withText("Open activity")));
    }

    @Test
    public void checkEditText() {
        onView(withId(R.id.edit_text_enter_color)).check(matches(isDisplayed()));
        onView(withId(R.id.edit_text_enter_color)).check(matches(withHint("Enter one color: red, green or blue")));
    }

    @Test
    public void checkErrorAfterWrongText() {
        onView(withId(R.id.edit_text_enter_color)).check(matches(isDisplayed()));
        onView(withId(R.id.edit_text_enter_color)).perform(replaceText("lorem ipsum"));

        onView(withId(R.id.button_open_activity)).perform(click());
        onView(withId(R.id.edit_text_enter_color)).check(matches(hasErrorText("Entered text is not a valid color!")));
    }

    @Test
    public void happyPath() {
        onView(withId(R.id.edit_text_enter_color)).check(matches(isDisplayed()));
        onView(withId(R.id.button_open_activity)).check(matches(isDisplayed()));

        onView(withId(R.id.edit_text_enter_color)).perform(replaceText("green"));
        onView(withId(R.id.button_open_activity)).perform(click());

        intended(hasComponent(ColorActivity.class.getName()));
    }

    @After
    public void cleanUp() {
        Intents.release();
    }
}