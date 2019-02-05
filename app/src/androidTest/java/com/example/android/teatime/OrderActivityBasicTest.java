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

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * This test demos a user clicking the decrement button and verifying that it properly decreases
 * the quantity the total cost.
 */

// TODO (1) Add annotation to specify AndroidJUnitRunner class as the default test runner

@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {

    // TODO (2) Add the rule that provides functional testing of a single activity

    @Rule
    public ActivityTestRule<OrderActivity> mActivityTestRule =
            new ActivityTestRule(OrderActivity.class);

    public void clickDecrementButton_ChangesQuantityAndCost() {

        // TODO (3) Finish writing this test which will:
        //          - Check that the initial quantity is zero
        //          - Click on the decrement button
        //          - Verify that the decrement button won't decrease the quantity 0 and cost below $0.00

        // check initial quantity is zero
        onView((withId(R.id.quantity_test_view))).check(matches(withText("0")));

        // click decrement button
        onView((withId(R.id.decrement_button))).perform(click());

        // verify quantity has decreased by 1
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        // verify cost is still $0.00
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));
    }
}