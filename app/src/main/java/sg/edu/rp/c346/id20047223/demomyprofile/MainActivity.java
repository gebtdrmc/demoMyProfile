package sg.edu.rp.c346.id20047223.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float fGPA = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdits = prefs.edit();
        prefEdits.putString("username", strName);
        prefEdits.commit();

        SharedPreferences prefsgpa = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefgpaEdits = prefs.edit();
        prefgpaEdits.putFloat("gpa",fGPA);
        prefEdits.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences prefgpa = getPreferences(MODE_PRIVATE);

        String strName = pref.getString("name", "John");
        String fgpa = prefgpa.getString("gpa", "1.0");

        etName.setText(strName);
        etGPA.setText(fgpa + "");

    }
}