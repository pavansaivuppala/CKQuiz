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

public class TF extends AppCompatActivity {
    //Declaring and initializing all the variables
    private List<model> questions = new ArrayList<>();
    private TextView questionTV;
    private TextView progressTV;
    private AppCompatButton option1, option2;
    private int progress = 0;

    private SoundPool soundpool;
    private SoundPool failSound;
    private int sound_1=1;

    private int score1 = 0;

    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tf);
        soundpool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        failSound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        //Playing sounds for incorrect and correct
        soundpool.load(this,R.raw.correct,1);
        failSound.load(this,R.raw.incorrect,1);
        questionTV = findViewById(R.id.question);
        progressTV = findViewById(R.id.progress);
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);


        //Q&A 1
        List<String> answer0 = new ArrayList<>();
        answer0.add("True");
        answer0.add("False");

        questions.add(new model("Did India won 2011 world cup?", answer0, 0));

        //Q&A 2
        List<String> answer1 = new ArrayList<>();
        answer1.add("True");
        answer1.add("False");

        questions.add(new model("India has won two world cups till date?", answer1, 0));

        //Q&A 3
        List<String> answer2 = new ArrayList<>();
        answer2.add("True");
        answer2.add("False");

        questions.add(new model("Jos buttler is player of new zealand.", answer2, 1));

        //Q&A 4
        List<String> answer3 = new ArrayList<>();
        answer3.add("True");
        answer3.add("False");

        questions.add(new model("BCCI is known as cricket board of Afganisthan. ", answer3, 1));

        //Q&A 5
        List<String> answer4 = new ArrayList<>();
        answer4.add("True");
        answer4.add("False");

        //Q&A 6
        questions.add(new model("ICC is head of all cricket boards.", answer4, 0));
        List<String> answer5 = new ArrayList<>();
        answer5.add("True");
        answer5.add("False");

        questions.add(new model("Sachin tendulkar is known as God of Cricket.", answer5, 0));

        //Q&A 7
        List<String> answer6 = new ArrayList<>();
        answer6.add("True");
        answer6.add("False");

        questions.add(new model("Stuart binny took a 7 wicket haul in his career.", answer6, 0));

        //Q&A 8
        List<String> answer7 = new ArrayList<>();
        answer7.add("True");
        answer7.add("False");

        questions.add(new model("Rohit sharma is known as king of cricket.", answer7, 1));

        //Q&A 9
        List<String> answer8 = new ArrayList<>();
        answer8.add("True");
        answer8.add("False");
        questions.add(new model("Hardik pandya and krunal pandya are not brothers", answer8, 1));

        //Q&A 10
        List<String> answer9 = new ArrayList<>();
        answer9.add("True");
        answer9.add("False");

        questions.add(new model("Kapil dev won the first world cup for india", answer9, 0));


        showQuestion(0);
    }


    //will display Q&A based on given number
    private void showQuestion(int questionNumber) {
        option1.setBackground(getResources().getDrawable(R.drawable.round_pink));
        option2.setBackground(getResources().getDrawable(R.drawable.round_pink));

        questionTV.setText(questions.get(questionNumber).getQuestion());
        progressTV.setText("Question " + (questionNumber + 1));

        option1.setText(questions.get(questionNumber).getAnswers().get(0));
        option2.setText(questions.get(questionNumber).getAnswers().get(1));

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
    }
    private void validateAnswer(int questionNumber, int answerPosition, AppCompatButton button) {

        if(progress<10)  {
            if (questions.get(questionNumber).getCorrectAnswer() == answerPosition) {
                //correct answer
                button.setBackgroundResource(R.drawable.round_green);
                Toast.makeText(this, "SIX!!", Toast.LENGTH_LONG).show();
                // go to next answer
                score1 = score1+1;
                playSuccessSound();
            } else {
                button.setBackgroundResource(R.drawable.round_red);
                //incorrect
                Toast.makeText(this, "OUT", Toast.LENGTH_LONG).show();
                playFailuresSound();
            }
            if(progress<10)
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