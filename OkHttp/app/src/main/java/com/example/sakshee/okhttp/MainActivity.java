package com.example.sakshee.okhttp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;


class TestMain {
    final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build();
    private String data = "";

    // code request code here
    String doGetRequest() {
        final Request request = new Request.Builder()
                .url("https://reqres.in/api/users/2")
                .build();
        try {

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("Failure:", String.valueOf(e));
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        Log.v("success", response.body().string());
                        data = response.body().string();
                    }
                }

            });
            return data;

//            return response.body().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    // test data
//    String bowlingJson(String player1, String player2) {
//        return "{'winCondition':'HIGH_SCORE',"
//                + "'name':'Bowling',"
//                + "'round':4,"
//                + "'lastSaved':1367702411696,"
//                + "'dateStarted':1367702378785,"
//                + "'players':["
//                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
//                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
//                + "]}";
//    }

//    String doPostRequest(String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);

        setContentView(R.layout.activity_main);
        Button B1 = (Button) findViewById(R.id.getdata);
        B1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView txtString = (TextView) findViewById(R.id.data);

        TestMain example = new TestMain();

        String getResponse = example.doGetRequest();
        if (getResponse != null) {
            try {
                JSONObject user = (new JSONObject(getResponse)).getJSONObject("data");
                String name = user.getString("first_name");
                int id = user.getInt("id");

                String str = "User Name: " + name + "\nUser id: " + id;
                Log.v("JSON",str);
                txtString.setText(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.v("Main1Activity", getResponse);

        } else {
            Log.v("null:", "msg");
        }
    }
}
