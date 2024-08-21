package com.freelanxer.androidunittestsample

import android.widget.Button
import android.widget.EditText
import io.mockk.MockKAnnotations
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowDialog

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    private lateinit var activity: MainActivity

    @Before
    fun setUpActivity() {
//        MockKAnnotations.init(activity)
        activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun registerSuccessShouldDirectToResult() {
        val  shadowActivity = Shadows.shadowOf(activity)
        val userId = "A123456789"
        val userPassword = "a123456789"
        activity.findViewById<EditText>(R.id.loginId).setText(userId)
        activity.findViewById<EditText>(R.id.password).setText(userPassword)
        activity.findViewById<Button>(R.id.send).performClick()

        val nextIntent = shadowActivity.nextStartedActivity

        assertEquals(nextIntent.component!!.className, ResultActivity::class.java.name)
        assertEquals(1, nextIntent.extras!!.size())
        assertEquals(userId, nextIntent.extras!!.getString("ID"))
    }

    @Test
    fun registerFailShouldAlert() {
        val userId = "A1234"
        val userPassword = "a123456789"
        activity.findViewById<EditText>(R.id.loginId).setText(userId)
        activity.findViewById<EditText>(R.id.password).setText(userPassword)
        activity.findViewById<Button>(R.id.send).performClick()

        val dialog = ShadowDialog.getLatestDialog()
        assertNotNull(dialog)
        assertTrue(dialog.isShowing)
    }
}