package developersudhanshu.com.creatingnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button notify;
    String channelId = "Channel_ID_1";
    int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notify = findViewById(R.id.btn_notify);

        notify.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_notify:
                NotificationCompat.Builder builder = initNotificationBuilder("Test Notification",
                        "This is a notification for Testing notifications", null);
                builder.setAutoCancel(true);
                Notification notification = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(notificationId, notification);
                break;
        }
    }

    private NotificationCompat.Builder initNotificationBuilder(String title, String content, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(content);

        return builder;
    }
}
