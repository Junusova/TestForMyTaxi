package com.mytaxi.android_demo


import android.os.SystemClock
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mytaxi.android_demo.activities.MainActivity
import com.mytaxi.android_demo.fixtures.LoginVariables
import org.hamcrest.Matchers.equalTo
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import android.support.test.espresso.matcher.ViewMatchers.withParent
import android.support.v7.widget.AppCompatImageButton
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.v7.widget.Toolbar
import org.hamcrest.Matchers.allOf


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class ApplicationTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_00_userAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        equalTo(listOf("mytaxi.android_demo", appContext.packageName))
    }

    @Test
    fun test_01_Authorization() {
        onView(withId(R.id.edt_username))
                 .check(matches(isDisplayed()))
                 .perform(clearText())
                 .perform(typeText(LoginVariables.username))
        onView(withId(R.id.edt_password))
                .check(matches(isDisplayed()))
                .perform(clearText())
                .perform(typeText(LoginVariables.password))
        onView(withId(R.id.btn_login))
                .check(matches(isDisplayed()))
                .perform(click())
    }

    @Test
    fun test_02_SearchByNameAndSelectSecondNameFromDropDownThenClickCallButton() {
        SystemClock.sleep(600)
        onView(withId(R.id.textSearch))
                .perform(clearText())
                .perform(typeText("sa"))
                .check(matches(isDisplayed()))
        SystemClock.sleep(600)
        onView(withText("Sarah Scott"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click())
        SystemClock.sleep(600)
        onView(withId(R.id.imageViewDriverAvatar))
                .check(matches(isDisplayed()))
        SystemClock.sleep(600)
        onView(withId(R.id.textViewDriverName))
                .check(matches(withText("Sarah Scott")))
        SystemClock.sleep(600)
        onView(withId(R.id.imageViewDriverLocation))
                .check(matches(isDisplayed()))
        onView(withId(R.id.textViewDriverLocation))
                .check(matches(withText("6834 charles st")))
        SystemClock.sleep(600)
        onView(withId(R.id.imageViewDriverDate))
        SystemClock.sleep(600)
        onView(withId(R.id.textViewDriverDate))
                .check(matches(withText("2002-10-18")))
        SystemClock.sleep(600)
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()))
                .perform(click())
    }
}