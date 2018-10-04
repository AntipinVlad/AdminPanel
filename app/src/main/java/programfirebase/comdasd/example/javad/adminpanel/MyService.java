package programfirebase.comdasd.example.javad.adminpanel;

/**
 * Created by javad on 16.08.2018.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.app.LauncherActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.select.Elements;

import static android.content.ContentValues.TAG;

public class MyService extends Service {

    public Elements content;
    public ArrayList<String> titleList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView lv;
    String URL = "http://decor.zbv.in.ua/1/not.json";
    NotificationManager nm;
    String Link ="https://www.google.com.ua";

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    /*    class Push extends AsyncTask<JSONObject, Integer, Void> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Void doInBackground(JSONObject... urls) {
                StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String s) {
                                try {
                                    JSONArray array = new JSONArray(s);

                                    for (int i = 0; i < array.length(); i++) {
                                        JSONObject o = array.getJSONObject(i);
                                 /*   ListItem item = new ListItem(
                                            o.getString("Lang"),
                                            o.getString("InfL"),
                                            o.getString("Information")
                                    );
                                    listItems.add(item);
                                   */
                                      /*  List<ListItem> listItem2 = null;
                                  /*  if (listItems.equals(listItem2)) {
                                        // они равны нечего не выполнять
                                    }else{
                                        listItem2 = listItems;
                                    }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });
                return null;
            }

            @Override
            protected void onPostExecute(Void results) {
                super.onPostExecute(results);

            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);

            }

            private void getFloor(int floor) throws InterruptedException {
            }
        }*/

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    void sendNotif() {
        Notification.Builder notificationBuilder = new Notification.Builder(this);
//1-я часть
        notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_info);
        notificationBuilder.setTicker("Text in status bar");
        notificationBuilder.setWhen(System.currentTimeMillis());
//3-я часть
        Intent intent = new Intent(this, WebView.class);
        intent.putExtra("link", Link);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
//2 часть
        notificationBuilder.setContentTitle("Notification title");
        notificationBuilder.setContentText("Notification text");
        notificationBuilder.setContentIntent(pIntent);
//ставим флаг, чтобы уведомление пропало после нажатия
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.build();
        Notification notification = notificationBuilder.getNotification();
        nm.notify(1, notification);
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }
}
