package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//Code for result file
public class MCQ extends AppCompatActivity {

    //Declaring and initializing all the variables
    private List<model> questions = new ArrayList<>();

    private TextView questionTV;
    private TextView progressTV;
    private AppCompatButton option1, option2, option3, option4;
    private int progress = 0;
    private int score1 = 0;

    private SoundPool soundpool;
    private SoundPool failSound;
    private int sound_1=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        failSound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        //Giving the sound files here
        soundpool.load(this,R.raw.correct,1);
        failSound.load(this,R.raw.incorrect,1);
        questionTV = findViewById(R.id.question);
        progressTV = findViewById(R.id.progress);
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);

        //Q&A 1
        List<String> answer0 = new ArrayList<>();
        answer0.add("RCB");
        answer0.add("SRH");
        answer0.add("CSK");
        answer0.add("MI");


        questions.add(new model("Which franchise bought Virat Kohli?", answer0, 0));

        //Q&A 2
        List<String> answer1 = new ArrayList<>();
        answer1.add("RCB");
        answer1.add("SRH");
        answer1.add("CSK");
        answer1.add("MI");


        questions.add(new model("Which franchise bought Bhuvaneshwar Kumar?", answer1, 1));

        //Q&A 3
        List<String> answer2 = new ArrayList<>();
        answer2.add("RCB");
        answer2.add("SRH");
        answer2.add("CSK");
        answer2.add("MI");

        questions.add(new model("Which franchise bought M.S.Dhoni?", answer2, 2));

        //Q&A 4
        List<String> answer3 = new ArrayList<>();
        answer3.add("RCB");
        answer3.add("SRH");
        answer3.add("CSK");
        answer3.add("MI");
        questions.add(new model("Which franchise bought Suresh Raina?", answer3, 2));

        //Q&A 5
        List<String> answer4 = new ArrayList<>();
        answer4.add("RCB");
        answer4.add("SRH");
        answer4.add("CSK");
        answer4.add("MI");

        //Q&A 6
        questions.add(new model("Which franchise bought Rohit Sharma?", answer4, 3));

        List<String> answer5 = new ArrayList<>();
        answer5.add("RCB");
        answer5.add("SRH");
        answer5.add("CSK");
        answer5.add("MI");

        //Q&A 7
        questions.add(new model("Which franchise bought Hardik Pandya?", answer5, 3));

        List<String> answer6 = new ArrayList<>();
        answer6.add("RCB");
        answer6.add("SRH");
        answer6.add("CSK");
        answer6.add("MI");
        //Q&A 8
        questions.add(new model("Which franchise bought Rashid Khan ?", answer6, 1));

        List<String> answer7 = new ArrayList<>();
        answer7.add("RCB");
        answer7.add("SRH");
        answer7.add("CSK");
        answer7.add("MI");

        //Q&A 9
        questions.add(new model("Which franchise bought Krunal Pandya?", answer7, 3));

        List<String> answer8 = new ArrayList<>();
        answer8.add("RCB");
        answer8.add("SRH");
        answer8.add("CSK");
        answer8.add("NONE");
        questions.add(new model("Which franchise bought Pavan Sai Vuppala?", answer8, 3));

        //Q&A 10
        List<String> answer9 = new ArrayList<>();
        answer9.add("RCB");
        answer9.add("SRH");
        answer9.add("CSK");
        answer9.add("MI");

        questions.add(new model("Which franchise bought Sachin Tendulkar?", answer9, 3));


        showQuestion(0);
    }


    //will display question and options based on given number
    private void showQuestion(int questionNumber) {
        option1.setBackground(getResources().getDrawable(R.drawable.round_pink));
        option2.setBackground(getResources().getDrawable(R.drawable.round_pink));
        option3.setBackground(getResources().getDrawable(R.drawable.round_pink));
        option4.setBackground(getResources().getDrawable(R.drawable.round_pink));

        questionTV.setText(questions.get(questionNumber).getQuestion());
        progressTV.setText("Question " + (questionNumber + 1));

        option1.setText(questions.get(questionNumber).getAnswers().get(0));
        option2.setText(questions.get(questionNumber).getAnswers().get(1));
        option3.setText(questions.get(questionNumber).getAnswers().get(2));
        option4.setText(questions.get(questionNumber).getAnswers().get(3));

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAnswer(questionNumber, 0,option1);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAnswer(questionNumber, 1,option2);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAnswer(questionNumber, 2,option3);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateAnswer(questionNumber, 3,option4);
            }
        });
    }
    private void validateAnswer(int questionNumber, int answerPosition,AppCompatButton button) {
        if(progress<10) {
            if(questions.get(questionNumber).getCorrectAnswer() == answerPosition) {
                //correct answer
                score1 = score1+1;
                button.setBackgroundResource(R.drawable.round_green);
                Toast.makeText(this, "SIX!!", Toast.LENGTH_LONG).show();
                // go to next answer
                playSuccessSound();
            } else {
                //incorrect
                button.setBackgroundResource(R.drawable.round_red);
                Toast.makeText(this, "OUT ", Toast.LENGTH_LONG).show();
                playFailuresSound();
            }

            if (progress<10)
                showQuestion(progress);
            progress++;
        }
        //Return UI of result with score
        else if (progress == 10){
            setContentView(R.layout.activity_res);
            TextView score2 = findViewById(R.id.score);
            score2.setText(String.valueOf(score1));
        }
    }
    //play correct sound
    private void playSuccessSound(){
        soundpool.play(sound_1,1,1,0,0,1);
    }
    //play incorrect sound
    private void playFailuresSound(){
        failSound.play(sound_1,1,1,0,0,1);
    }
}