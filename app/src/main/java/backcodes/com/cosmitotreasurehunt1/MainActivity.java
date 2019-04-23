package backcodes.com.cosmitotreasurehunt1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import in.codeshuffle.typewriterview.TypeWriterListener;
import in.codeshuffle.typewriterview.TypeWriterView;


public class MainActivity extends AppCompatActivity {
Button btcheck;
TextView tvtime,tvtimehead;
TypeWriterView tvques;
EditText etans;
    String formattedDate;
    String enddate;
    DateFormat dateFormat;
    Date date;
    int hours,min,secc;
    String finished;
    String fakeclue[]={"USZ010DC","96VJRMBH","USR1UTKU","SUS023KT","G74GGERI","KAR98Z4Y","Z422N60A","Z93KN51B","NAPKPDOH","QCD234S0","F32K15BS","Ram Bhai"};
    String fakecluemsg[]={"Apke Sath Ek Prank hua hai","Better Luck Next Time","Try Another","khoj basanti khoj","Code ne bewafayi ki hai","chal jhutta","ab tera kya hoga kaliya","Better Luck Next Time","Apke Sath Ek Prank hua hai","HaHa Dusra Daalo","Chal Jhutta","Chutiya hai kya?"};
//    KonfettiView konfettiView;




    String que[]={"Let The Hunt Begin.","Clue 1: Caution is needed going this way;\n" +
        "A tarmac place of bay bay bay,\n" +
        "Now is the time to leave the car; \n" +
        "If you leave from here you will go far.","Clue 2: I’m full of pins & interesting stuff;\n" +
        "\tPeople stare & can’t get enough,\n" +
        "Paper & invites hang around;\n" +
        "Up on the way I can be found.","Clue 3: You enter the area of circle;\n" +
        "\tBut you ignore the centre,\n" +
        "\tHave you ever imagined what it feels;\n" +
        "\tLike if I chop off your head.","Clue 4: Am there for collecting energy;\n" +
        " but now am of no use due to \n" +
        "ignorance.","Clue 5: When my owner is closed, I’m open;\n" +
        "\tMy owner never cleans me out,\n" +
        "\tOnly few can afford to keep me fed;\n"+
        "Because people always take my food.\t","Clue 6:  Am not a square but lovable as a square;\n" +
        "On one side I have a place named after fire, \n" +
        "Other side I have a study temple;\n" +
        "Another side I have a place where people come for  recreation.     ","Clue 7: I ‘m 7 feet tall and powered by 7 animals;\n" +
        "Most of the times people ignore me,\n" +
        "But sometimes respect me;  ","Clue 8: A pile of words; jacket of hordes,\n" +
        "\tTake a quick look; On the pile of book.\t","Clue 9: Walk or run but just don’t stumble;\n" +
        "\tTo where we cure our belly’s rumble.","Finished"};
String ans[]={"APNA TIME AAGAYA","23ENUKBC","JA2608UO","IE7G195XS","KRVLUCSM","XV650BTI","GA262JAQT","BT9SQU74T","ZA12X6BQO","BA99JMLR2","Finished"};
//String ans[]={"APNA TIME AAGAYA","1","2","3","4","5","6","7","8","9","Finished"};
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int state=0,not=0;
    String ggg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        editor=preferences.edit();
        btcheck=(Button)findViewById(R.id.btcheck);
//       konfettiView = findViewById(R.id.viewKonfetti);
        tvtime=(TextView)findViewById(R.id.textView3);
        tvtimehead=(TextView)findViewById(R.id.tvtimehead);
        tvques=(TypeWriterView) findViewById(R.id.tvques);
        tvques.setDelay(200);
        tvques.setWithMusic(true);
        etans=(EditText)findViewById(R.id.etans);
        tvques.setText(que[state]);
        date= new Date();

        final Animation fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
       // String strDateFormat = "hh:mm";
        tvques.setTypeWriterListener(new TypeWriterListener() {
            @Override
            public void onTypingStart(String text) {
                btcheck.setVisibility(View.INVISIBLE);
                etans.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onTypingEnd(String text) {
                //btcheck.setAnimation(fadeOutAnimation);

                btcheck.setVisibility(View.VISIBLE);
                etans.setVisibility(View.VISIBLE);
                if(state==10)
                {
                    btcheck.setVisibility(View.INVISIBLE);
                    etans.setVisibility(View.INVISIBLE);
                }
                //btcheck.startAnimation(fadeOutAnimation);

            }

            @Override
            public void onCharacterTyped(String text, int position) {

            }

            @Override
            public void onTypingRemoved(String text) {

            }
        });


        btcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                not=0;
                ggg=etans.getText().toString();
                for (int jj=0;jj<fakeclue.length;jj++)
                {
                    if(ggg.equalsIgnoreCase(fakeclue[jj]))
                    {
                        Toast.makeText(MainActivity.this, fakecluemsg[jj], Toast.LENGTH_SHORT).show();
                        not=1;
                        break;
                    }
                }

                if (not != 1) {
                    if (etans.getText().toString().equalsIgnoreCase(ans[0]) && state == 0) {
                        state = 1;
                        tvques.animateText(que[1]);
                        editor.putInt("state", 1);
                        formattedDate = DateFormat.getTimeInstance().format(date);
                        editor.putString("starttime", formattedDate);
                        editor.apply();
                        etans.getText().clear();

                    } else if (etans.getText().toString().equalsIgnoreCase(ans[1]) && state == 1) {
                        state = 2;
                        tvques.animateText(que[2]);
                        editor.putInt("state", 2);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[2]) && state == 2) {
                        state = 3;
                        tvques.animateText(que[3]);
                        editor.putInt("state", 3);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[3]) && state == 3) {
                        state = 4;
                        tvques.animateText(que[4]);
                        editor.putInt("state", 4);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[4]) && state == 4) {
                        state = 5;
                        tvques.animateText(que[5]);
                        editor.putInt("state", 5);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[5]) && state == 5) {
                        state = 6;
                        tvques.animateText(que[6]);
                        editor.putInt("state", 6);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[6]) && state == 6) {
                        state = 7;
                        tvques.animateText(que[7]);
                        editor.putInt("state", 7);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[7]) && state == 7) {
                        state = 8;
                        tvques.animateText(que[8]);
                        editor.putInt("state", 8);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[8]) && state == 8) {
                        state = 9;
                        tvques.animateText(que[9]);
                        editor.putInt("state", 9);
                        editor.apply();
                        etans.getText().clear();
                    } else if (etans.getText().toString().equalsIgnoreCase(ans[9]) && state == 9) {
                        state = 10;
                        tvques.animateText("Finished");
                        etans.setVisibility(View.INVISIBLE);
                        btcheck.setVisibility(View.INVISIBLE);
                        date = new Date();
                        dateFormat = new SimpleDateFormat("hh:mm");
                        enddate = DateFormat.getTimeInstance().format(date);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
                        Date startDate = null;
                        try {
                            startDate = simpleDateFormat.parse(formattedDate);

                            Date endDate = simpleDateFormat.parse(enddate);

                            long difference = endDate.getTime() - startDate.getTime();
                            if (difference < 0) {
                                Date dateMax = simpleDateFormat.parse("24:00");
                                Date dateMin = simpleDateFormat.parse("00:00");
                                difference = (dateMax.getTime() - startDate.getTime()) + (endDate.getTime() - dateMin.getTime());
                            }
                            int days = (int) (difference / (1000 * 60 * 60 * 24));
                            hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                            min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
//                            hours=(int) (difference / (1000 * 60 * 60));
//                            min=(int) (difference / (1000 * 60));
//                            secc=(int) (difference / (1000));
                            tvtime.setText("Finished \n" +
                                    hours + ":" + min);
                            finished = hours + ":" + min;

                            editor.putInt("state", 10);
                            editor.putString("endtime", finished);
                            editor.apply();
                            etans.setVisibility(View.INVISIBLE);
                            btcheck.setVisibility(View.INVISIBLE);
                            tvtimehead.setVisibility(View.VISIBLE);
                            tvtime.setVisibility(View.VISIBLE);
                            tvtime.setText(finished);
                            etans.getText().clear();
//
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else if (state == 10) {
                        tvques.animateText("Finished");
                        etans.setVisibility(View.INVISIBLE);
                        btcheck.setVisibility(View.INVISIBLE);
                        tvtimehead.setVisibility(View.VISIBLE);
                        tvtime.setVisibility(View.VISIBLE);
                        tvtime.setText(finished);

                    } else {
                        Toast.makeText(getApplicationContext(), "That's not the answer.Think harder", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        tvques.removeAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
       // preferences = PreferenceManager.getDefaultSharedPreferences(this);
        state=preferences.getInt("state",0 );
        tvques.setText(que[state]);
        finished=preferences.getString("endtime","00:00" );
        formattedDate=preferences.getString("starttime","00:00" );
        if (state==10)
        {
            etans.setVisibility(View.INVISIBLE);
            btcheck.setVisibility(View.INVISIBLE);
            tvtimehead.setVisibility(View.VISIBLE);
            tvtime.setVisibility(View.VISIBLE);
            tvtime.setText(finished);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        state=preferences.getInt("state",0 );
        tvques.setText(que[state]);
        finished=preferences.getString("endtime","00:00" );
        formattedDate=preferences.getString("starttime","00:00" );
        if (state==10)
        {
            etans.setVisibility(View.INVISIBLE);
            btcheck.setVisibility(View.INVISIBLE);
            tvtimehead.setVisibility(View.VISIBLE);
            tvtime.setVisibility(View.VISIBLE);
            tvtime.setText(finished);
        }
    }
}
