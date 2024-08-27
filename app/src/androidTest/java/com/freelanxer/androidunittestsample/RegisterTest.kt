package com.freelanxer.androidunittestsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test

@LargeTest
class RegisterTest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity() {
        inputRightRegisterData()
        onView(withId(R.id.send)).perform(click())
        onView(withText("註冊成功")).check(matches(isDisplayed()))
    }

    @Test
    fun wrongPassword_should_startActivity() {
        inputWrongRegisterData()
        onView(withId(R.id.send)).perform(click())
        onView(withText("註冊成功錯誤")).check(matches(isDisplayed()))
    }

    private fun inputRightRegisterData() {
        onView(withId(R.id.loginId)).perform(
            typeText("a123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.password)).perform(
            typeText("a111111111"),
            ViewActions.closeSoftKeyboard()
        )
    }

    private fun inputWrongRegisterData() {
        onView(withId(R.id.loginId)).perform(
            typeText("a123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.password)).perform(
            typeText("1234"),
            ViewActions.closeSoftKeyboard()
        )
    }
}