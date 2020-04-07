package com.example.sakshee.jsonparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final String JSON_String = "{\"employee\":{\"name\":\"sachin\",\"salary\":56000}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView1);

        try{
            JSONObject emp = (new JSONObject(JSON_String)).getJSONObject("employee");
            String empName = emp.getString("name");
            int empSalary = emp.getInt("salary");

            String str = "Employee Name: "+empName+"\nEmployee Salary: "+empSalary;
            textView.setText(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
