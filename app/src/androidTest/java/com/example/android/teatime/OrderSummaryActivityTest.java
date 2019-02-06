/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

// TODO (1) Add annotation to specify AndroidJUnitRunner class as the default test runner

@RunWith(AndroidJUnit4.class)
public class OrderSummaryActivityTest {

    private static final String emailMessage =
            "I just ordered a delicious tea from TeaTime. Next time you are craving a tea, check them out!";

    // TODO (2) Add the rule that indicates we want to use Espresso-Intents APIs in functional UI tests

    @Rule
    public IntentsTestRule<OrderSummaryActivity> mActivityRule =
            new IntentsTestRule<>(OrderSummaryActivity.class);

    // TODO (3) Finish this method which runs before each test and will stub all external
    // intents so all external intents will be blocked

    @Before
    public void stubAllExternalIntents() {
        intending(not(isInternal())).respondWith(
                new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    // TODO (4) Finish this method which verifies that the intent sent by clicking the send email
    // button matches the intent sent by the application

    @Test
    public void clickSendEmailButton_SendsEmail() {

        // perform click on "send email" button
        onView(withId(R.id.send_email_button)).perform(click());

        // assert the intent actually contains the intended data
        intended(allOf(hasAction(Intent.ACTION_SENDTO), hasExtra(Intent.EXTRA_TEXT, emailMessage)));

    }

}