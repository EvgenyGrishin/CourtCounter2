/**
 * App is used for counting stats fir team vs. team battles in FPS games like Quake Champions.
 * It counts the number of frags and deaths of the team's players and displays Frag / death ratio for the current score of each team
 */

package com.example.devsdk.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int fragBlue = 0;
    int fragRed = 0;
    int deathBlue = 0;
    int deathRed = 0;

    /**
     * Increase Blue team frags by one
     */
    public void addFragForBlue(View v) {
        fragBlue = fragBlue + 1;
        displayFragsForBlue(fragBlue);
        BlueRatioCount();
    }

    /**
     * Increase Red team frags by one
     */
    public void addFragForRed(View v) {
        fragRed = fragRed + 1;
        displayFragsForRed(fragRed);
        RedRatioCount();
    }

    /**
     * Increase Blue team deaths by one
     */
    public void addDeathForBlue(View v) {
        deathBlue = deathBlue + 1;
        displayDeathsForBlue(deathBlue);
        BlueRatioCount();
    }

    /**
     * Increase Red team deaths by one
     */
    public void addDeathForRed(View v) {
        deathRed = deathRed + 1;
        displayDeathsForRed(deathRed);
        RedRatioCount();
    }
    /**
     * Displays the number of frags for Blue team
     */
    public void displayFragsForBlue(int score) {
        TextView scoreView = findViewById(R.id.team_blue_frags);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of frags for Red team
     */
    public void displayFragsForRed(int score) {
        TextView scoreView = findViewById(R.id.team_red_frags);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of deaths for Blue team
     */
    public void displayDeathsForBlue(int score) {
        TextView scoreView = findViewById(R.id.team_blue_deaths);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of deaths for Red team
     */
    public void displayDeathsForRed(int score) {
        TextView scoreView = findViewById(R.id.team_red_deaths);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays Ratio for Blue team
     */
    public void BlueRatioCount() {
        float fFragBlue = (float) (fragBlue);

        float fDeathBlue = (float) (deathBlue);

        float ratio;
        if (deathBlue == 0)
            ratio = fragBlue;
        else
        ratio = fFragBlue/fDeathBlue;

        TextView ratioView = findViewById(R.id.team_blue_ratio);
        String visualRatio = String.format("%.02f", ratio);
        ratioView.setText(visualRatio);
    }

    /**
     * Displays Ratio for Red team
     */
    public void RedRatioCount() {
        float fFragRed = (float) (fragRed);

        float fDeathRed = (float) (deathRed);

        float ratio;
        if (deathRed == 0)
                ratio = fragRed;
        else
            ratio = fFragRed/fDeathRed;

        TextView ratioView = findViewById(R.id.team_red_ratio);
        String visualRatio = String.format("%.02f", ratio);
        ratioView.setText(visualRatio);
    }

    /**
     * Resets the score for Team A.
     */
    public void resetForAll (View v) {
        fragBlue = 0;
        fragRed = 0;
        deathBlue = 0;
        deathRed = 0;
        displayFragsForBlue(fragBlue);
        displayFragsForRed(fragRed);
        displayDeathsForBlue(deathBlue);
        displayDeathsForRed(deathRed);
        RedRatioCount();
        BlueRatioCount();
    }


}
