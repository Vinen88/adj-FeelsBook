/*
    FeelsBook: Allows recording of feelings to analyze these feelings over time

    Copyright (C) 2018 Anders Johnson adj@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.


 */

package ca.ualberta.cs.adj_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//Main activity, presents the user with emotions to record and a comment field
public class MainActivity extends AppCompatActivity {
    EmotionRecordListController listController;
    EmotionRecordListManager listManager;
    EditText commentField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listController = new EmotionRecordListController();
        listManager = new EmotionRecordListManager();
        EmotionRecordListManager.loadFile(this);
        commentField = findViewById(R.id.addCommentEditText);
    }

    public void saveComment(EmotionRecord emotionRecord) {
        //Gets text user has inputted into comment field and sets comment in record
        try {
            emotionRecord.setComment(commentField.getText().toString());
        } catch (CommentTooLongException e) {
            Toast.makeText(this, "Comment too long!", Toast.LENGTH_SHORT).show();
        }
        commentField.setText("");
    }

    public void viewLog(View v) {
        //Launches the EmotionRecordListActivity to see past emotional records
        Intent intent = new Intent(MainActivity.this, EmotionRecordListActivity.class);
        startActivity(intent);
    }


    //These all add an emotion record of their respective classes
    public void addNewLove(View v) {
        EmotionRecord newLove = new LoveRecord();
        EmotionRecordListController.addRecord(newLove);
        Toast.makeText(this, "Love emotion saved!", Toast.LENGTH_SHORT).show();
        saveComment(newLove);
        EmotionRecordListManager.saveFile(this);
    }

    public void addNewJoy(View v) {
        EmotionRecord newJoy = new JoyRecord();
        EmotionRecordListController.addRecord(newJoy);
        Toast.makeText(this, "Joy emotion saved!", Toast.LENGTH_SHORT).show();
        saveComment(newJoy);
        EmotionRecordListManager.saveFile(this);
    }

    public void addNewSurprise(View v) {
        EmotionRecord newSurprise = new SurpriseRecord();
        EmotionRecordListController.addRecord(newSurprise);
        Toast.makeText(this, "Surprise emotion saved!", Toast.LENGTH_SHORT).show();
        saveComment(newSurprise);
        EmotionRecordListManager.saveFile(this);
    }

    public void addNewAnger(View v) {
        EmotionRecord newAnger = new AngerRecord();
        EmotionRecordListController.addRecord(newAnger);
        Toast.makeText(this, "Anger emotion saved!", Toast.LENGTH_SHORT).show();
        saveComment(newAnger);
        EmotionRecordListManager.saveFile(this);
    }

    public void addNewSadness(View v) {
        EmotionRecord newSadness = new SadnessRecord();
        EmotionRecordListController.addRecord(newSadness);
        Toast.makeText(this, "Sadness emotion saved!", Toast.LENGTH_SHORT).show();
        saveComment(newSadness);
        EmotionRecordListManager.saveFile(this);
    }

    public void addNewFear(View v) {
        EmotionRecord newFear = new FearRecord();
        EmotionRecordListController.addRecord(newFear);
        Toast.makeText(this, "Fear emotion saved!", Toast.LENGTH_SHORT).show();
        saveComment(newFear);
        EmotionRecordListManager.saveFile(this);
    }

}
