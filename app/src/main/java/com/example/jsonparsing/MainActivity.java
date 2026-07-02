package com.example.jsonparsing;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
        Button btnLoad;
        ProgressBar progressBar;
        TextView tvShowName;
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLoad = findViewById(R.id.btnLoad);
        progressBar = findViewById(R.id.progressBar);
        tvShowName = findViewById(R.id.tvShowName);
        imageView = findViewById(R.id.imageView);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://192.168.0.107/practiceandroid/jsondataset.json";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);
                                try {
                                    // যদি রেসপন্স একদম খালি বা স্পেস যুক্ত হয়, তবে অবজেক্ট তৈরি করার দরকার নেই
                                    if (response == null || response.trim().isEmpty()) {
                                        tvShowName.setText("Server file is completely empty!");
                                        progressBar.setVisibility(View.GONE);
                                        return;
                                    }
                                    // ১. রেসপন্সটিকে প্রথমে JSONArray হিসেবে নিন
                                    JSONArray jsonArray = new JSONArray(response);

                                    // ২. অ্যারের প্রথম উপাদানটি (Index 0) বের করুন যা একটি JSONObject
                                    if (jsonArray.length() > 0) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(0); // প্রথম আইটেম

                                        // ৩. এবার আগের মতোই কি (Key) দিয়ে ডেটা রিড করুন
                                        String name_st = jsonObject.getString("name");
                                        String image_st = jsonObject.getString("image");

                                        // ৪. ইউআই-তে ডেটা সেট করুন
                                        tvShowName.setText(name_st);
                                        Glide.with(MainActivity.this).load(image_st).into(imageView);
                                    } else {
                                        tvShowName.setText("No data found in JSON!");
                                    }

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        btnLoad.setText("Volley Error!");
                        progressBar.setVisibility(View.GONE);
                    }
                });
                queue.add(stringRequest);
            }
        });

    } //
} //