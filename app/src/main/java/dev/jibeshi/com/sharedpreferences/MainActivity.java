package dev.jibeshi.com.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3;
    Button b1, b2;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

        b1 = (Button) findViewById(R.id.button);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Name, n).commit();
                editor.putString(Phone, ph).commit();
                editor.putString(Email, e).commit();
//                editor.apply();
//                editor.commit();

                Toast.makeText(MainActivity.this, "Thanks ", Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.shared_preferences_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_container));

                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Shared Preferences Details \n\n");

                TextView textSPName = (TextView) layout.findViewById(R.id.textViewSPName);
                textSPName.setText(sharedPreferences.getString(Name, "") + "\n");

                TextView textSPPhone = (TextView) layout.findViewById(R.id.textViewSPPhone);
                textSPPhone.setText(sharedPreferences.getString(Phone, "") + "\n");

                TextView textSPEmail = (TextView) layout.findViewById(R.id.textViewSPEmail);
                textSPEmail.setText(sharedPreferences.getString(Email, "") + "\n");


                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();


            }
        });
    }
}
