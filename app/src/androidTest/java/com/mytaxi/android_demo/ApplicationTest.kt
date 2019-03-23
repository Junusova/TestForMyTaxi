package com.mytaxi.android_demo


import android.os.SystemClock
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mytaxi.android_demo.activities.MainActivity
import com.mytaxi.android_demo.fixtures.LoginVariables
import org.hamcrest.Matchers.*
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

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
        onView(withId(R.id.edt_username)).perform(typeText(LoginVariables.username))
        onView(withId(R.id.edt_password)).perform(typeText(LoginVariables.password))
        onView(withId(R.id.btn_login)).perform(click())

    }

    @Test
    fun test_02_SearchByNameAndSelectSecondNameFromDropDown() {
        SystemClock.sleep(600)
        onView(withId(R.id.textSearch)).perform(typeText("sa"))
        SystemClock.sleep(6000)
        onData(anything()).inAdapterView(withId(R.id.place_autocomplete_powered_by_google)).atPosition(1).perform(click())
        SystemClock.sleep(6000)
    }
//
//    @Test
//    fun test_03_user_can_click_login_button() {
//        onView(withId(R.id.btn_login)).perform(click())
//    }
//
//    @Test
//    fun test_04_user_can_enter_text_for_search() {
//        onView(withId(R.id.search_bar)).perform(typeText("sa"))
//    }
}
