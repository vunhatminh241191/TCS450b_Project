package minvu.uw.tacoma.edu.lookandfeel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StylesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);
    }

    public void TransferToAnimation(View view) {
        Intent intent = new Intent(this, AnimationActivity.class);
        startActivity(intent);
    }
}
