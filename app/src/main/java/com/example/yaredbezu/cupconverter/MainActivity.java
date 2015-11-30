package com.example.yaredbezu.cupconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    LinearLayout layout1;
    LinearLayout buttonLayout;
    EditText 	 cupsText;
    Button       teaspoonButton;
    Button       tablespoonButton;
    TextView 	 answerteaspoon;
    TextView 	 answertablespoon;
    TextView	 bannerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        layout1 = new LinearLayout(this);
        buttonLayout = new LinearLayout(this);
        cupsText = new EditText(this);
        teaspoonButton = new Button(this);
        tablespoonButton = new Button(this);
        answerteaspoon = new TextView(this);
        answertablespoon = new TextView(this);
        bannerText = new TextView(this);


        layout1.setOrientation(LinearLayout.VERTICAL);
        layout1.setGravity(Gravity.CENTER_HORIZONTAL);
        layout1.setBackgroundColor(Color.YELLOW);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        bannerText.setWidth(300);
        bannerText.setGravity(Gravity.CENTER_HORIZONTAL);
        bannerText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        bannerText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        bannerText.setText("Cups to TeaSpoon and TableSpoon Convertor");
        bannerText.setTextColor(Color.BLACK);
        bannerText.setPadding(0, 0, 0, 10);


        cupsText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);

        teaspoonButton.setText("toTeaSpoon");
        tablespoonButton.setText("toTableSpoon");


        answerteaspoon.setText("0");
        answertablespoon.setText("0");

        answerteaspoon.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        answerteaspoon.setPadding(0, 20, 0, 20);
        answerteaspoon.setWidth(150);
        answerteaspoon.setGravity(Gravity.CENTER_HORIZONTAL);
        answerteaspoon.setTextColor(Color.BLUE);

        answertablespoon.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        answertablespoon.setPadding(0, 20, 0, 20);
        answertablespoon.setWidth(150);
        answertablespoon.setGravity(Gravity.CENTER_HORIZONTAL);
        answertablespoon.setTextColor(Color.RED);

        teaspoonButton.setOnClickListener(teaspoonClicked);
        tablespoonButton.setOnClickListener(tablespoonClicked);
        teaspoonButton.setWidth(150);

        teaspoonButton.setTextColor(Color.BLUE);
        tablespoonButton.setTextColor(Color.RED);

        buttonLayout.addView(teaspoonButton);
        buttonLayout.addView(tablespoonButton);
        layout1.addView(bannerText);
        layout1.addView(cupsText);
        layout1.addView(buttonLayout);
        layout1.addView(answerteaspoon);
        layout1.addView(answertablespoon);

        setContentView(layout1);

        cupsText.setLayoutParams(new LinearLayout.LayoutParams(150,50));
        teaspoonButton.setLayoutParams(new LinearLayout.LayoutParams(150,50));
        tablespoonButton.setLayoutParams(new LinearLayout.LayoutParams(150,50));


    }
    private OnClickListener teaspoonClicked = new OnClickListener()
    {
        @Override
        public void onClick(View v) {
            String cupsString = cupsText.getText().toString();
            double cup = Double.parseDouble(cupsString);
            double result = cup * 48;
            String resultString = String.valueOf(result);
            answerteaspoon.setText(resultString);
        }
    };

    private OnClickListener tablespoonClicked = new OnClickListener()
    {
        @Override
        public void onClick(View v) {
            String cupsString = cupsText.getText().toString();
            double cup = Double.parseDouble(cupsString);
            double result = cup * 16;
            String resultString = String.valueOf(result);
            answertablespoon.setText(resultString);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
