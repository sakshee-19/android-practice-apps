package com.example.sakshee.dpc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.PackageManager;

import android.app.Activity;
import android.content.Intent;
import android.app.Fragment;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PROVISION_MANAGED_PROFILE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PackageManager pm = getPackageManager();
        if (!pm.hasSystemFeature(PackageManager.FEATURE_MANAGED_USERS)) {
            // This device does not support work profiles!
        }

        Activity provisioningActivity = (Activity) MainActivity.this.getApplicationContext();
        // You'll need the package name for the DPC app.
        String myDPCPackageName = "com.example.myDPCApp";
        // Set up the provisioning intent
        android.content.Intent provisioningIntent = new Intent("android.app.action.PROVISION_MANAGED_PROFILE");
        provisioningIntent.putExtra(myDPCPackageName, provisioningActivity.getApplicationContext().getPackageName());
        if (provisioningIntent.resolveActivity(provisioningActivity.getPackageManager())== null)
        {
            // No handler for intent! Can't provision this device.
            // Show an error message and cancel.
        } else {
            // REQUEST_PROVISION_MANAGED_PROFILE is defined
            // to be a suitable request code
            startActivityForResult(provisioningIntent,REQUEST_PROVISION_MANAGED_PROFILE);
            provisioningActivity.finish();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check if this is the result of the provisioning activity
        if (requestCode == REQUEST_PROVISION_MANAGED_PROFILE) {
            // If provisioning was successful, the result code is
            // Activity.RESULT_OK
            if (resultCode == Activity.RESULT_OK) {
                // Work profile created and provisioned.
            } else {
                // Provisioning failed.
            }
            return;
        } else {
            // This is the result of some other activity. Call the superclass.
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
