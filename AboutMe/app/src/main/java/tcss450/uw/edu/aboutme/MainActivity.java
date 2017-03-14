package tcss450.uw.edu.aboutme;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final String webPage = "http://developer.android.com/index.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openingTextActivity(View view) {
        //TODO: opening new Text Activity
        Intent intent = new Intent(this, TextViewActivity.class);
        startActivity(intent);
    }

    public void openingImageActivity(View view) {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    public void openingWebActivity(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webPage));
        startActivity(browserIntent);
    }

    public void showingToast(View view) {
        Toast toast = Toast.makeText(view.getContext(), "This is a toast", Toast.LENGTH_LONG);
        toast.show();
    }

    public void showingDialog(final View view) {
        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("AlertDialog Title");
        builder.setMessage("Simple Dialog Message");
        builder.setPositiveButton("OK!!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //
                Toast toast1 = Toast.makeText(view.getContext(), "Thanks for clicking this dialog", Toast.LENGTH_LONG);
                toast1.show();
            }
        })
                .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast2 = Toast.makeText(view.getContext(), "Good bye", Toast.LENGTH_LONG);
                        toast2.show();
                    }
                });

        // Create the AlertDialog object and return it
        builder.create().show();
    }
}
;