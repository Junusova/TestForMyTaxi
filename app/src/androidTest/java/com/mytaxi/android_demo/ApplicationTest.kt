package com.mytaxi.android_demo


import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mytaxi.android_demo.activities.MainActivity
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.equalTo
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
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"))
        onView(withId(R.id.edt_password)).perform(typeText("venture"))
        onView(withId(R.id.btn_login)).perform(click())
        onView(withId(R.id.textSearch)).perform(typeText("sa"))
        onData(anything())
                .atPosition(1)
                .perform(click())
    }

//    @Test
//    fun test_01_user_can_enter_username() {
//    onView(withId(R.id.edt_username)).perform(typeText("crazydog335"))
//    }
//
//    @Test
//    fun test_02_user_can_enter_password() {
//        onView(withId(R.id.edt_password)).perform(typeText("venture"))
//    }
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
