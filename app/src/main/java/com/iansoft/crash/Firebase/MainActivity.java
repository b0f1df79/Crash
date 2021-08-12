package com.iansoft.crash.Firebase;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button crashJava = findViewById(R.id.crashJava);
        crashJava.setText(R.string.crash_java);
        crashJava.setOnClickListener(view -> {
            throw new RuntimeException("Test Crash"); // Force a crash
        });

        Button crashNative = findViewById(R.id.crashNative);
        crashNative.setText(R.string.crash_native);
        crashNative.setOnClickListener(view -> crashNative());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void crashNative();
}
