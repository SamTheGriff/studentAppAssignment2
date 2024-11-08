package com.example.studentapp
import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObjectNotFoundException
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertTrue
@RunWith(AndroidJUnit4::class)
class UITest {

    private lateinit var device: UiDevice
    private val packageName = "com.example.studentapp"

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        device.pressHome()

        //Launch the app
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        device.wait(Until.hasObject(By.pkg(packageName).depth(0)), 5000)
    }

    @Test
    @Throws(UiObjectNotFoundException::class)
    fun testStartActivityAndCheckChallenge() {
        //Click on the start activity explicitly button
        val startActivityButton = device.findObject(UiSelector().text("Start Activity Explicitly"))
        startActivityButton.click()

        //Check to see if the mobile software development challenge of Compatability is present
        val challengeText = device.findObject(UiSelector().textContains("Compatability"))
        assertTrue("Challenge not found in second activity", challengeText.exists())
    }
}
