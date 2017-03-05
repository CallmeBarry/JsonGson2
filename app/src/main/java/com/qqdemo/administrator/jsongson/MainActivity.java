package com.qqdemo.administrator.jsongson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn1)
    Button mBtn1;
    @InjectView(R.id.btn2)
    Button mBtn2;
    @InjectView(R.id.txt)
    TextView mTxt;
    private String jsonStr;
    Student s1 = new Student(101, "张三", 20);
    Student s2 = new Student(102, "张四", 30);
    Student s3 = new Student(103, "张五", 40);
    final Student[] stus = {s1, s2, s3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);




    }

    private JSONObject getStudentJsonObj(Student s) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", s.getId());
            obj.put("name", s.getName());
            obj.put("age", s.getAge());
        } catch (JSONException e) {
            Log.i("MainActivity", e.toString());
        }
        return obj;
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                JSONArray array = new JSONArray();
                for (int i = 0; i < stus.length; i++) {
                    JSONObject stuObj = getStudentJsonObj(stus[i]);
                    array.put(stuObj);
                }
                JSONObject obj = new JSONObject();
                try {
                    obj.put("stuList", array);
                } catch (JSONException e) {
                    Log.i("MainActivity", e.toString());
                }

                jsonStr = obj.toString();
                mTxt.setText(obj.toString());
                break;
            case R.id.btn2:
                Gson gson = new Gson();
                Student s = gson.fromJson(jsonStr, Student.class);
                StringBuffer stringBuffer=new StringBuffer();
                for(Student a: s.getStuList()){
                    stringBuffer.append(a.getId()+" "+a.getName()+" "+a.getAge()+"\r\n");
                }
                mTxt.setText(stringBuffer.toString());
                break;
        }
    }
}
