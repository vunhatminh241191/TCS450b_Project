package minvu.uw.tacoma.edu.webservicelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import minvu.uw.tacoma.edu.webservicelab.course.Course;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, CourseActivity.class);
        startActivity(intent);
    }
}
