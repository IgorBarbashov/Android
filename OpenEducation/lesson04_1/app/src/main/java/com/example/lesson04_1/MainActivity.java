package com.example.lesson04_1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMail();
        buttonWeb();
        buttonMap();
        buttonCall();
    }

    private void buttonCall() {
        Button buttonCall = findViewById(R.id.button_call);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel: ");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                if (isIntentSafe(callIntent)) {
                    startActivity(callIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Your phone have no app can dial",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void buttonMap() {
        Button buttonMap = findViewById(R.id.button_map);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo: 37.422219, -122.08364?z=14");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                if (isIntentSafe(mapIntent)) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Your phone have no app can show map",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void buttonWeb() {
        Button buttonWeb = findViewById(R.id.button_web);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webadress = Uri.parse("http://vk.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webadress);

                if (isIntentSafe(webIntent)) {
                    startActivity(webIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Your phone have no app can show web-pages",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void buttonMail() {
        Button buttonMail = findViewById(R.id.button_mail);
        buttonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
                        "mail1@mail.ru", null));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail2@mail.ru",
                        "mail3@mail.ru"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Send Intent message");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "I send my text by Android App");

                if (isIntentSafe(emailIntent)) {
                    startActivity(emailIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Your phone have no app can send e-mail",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }
}