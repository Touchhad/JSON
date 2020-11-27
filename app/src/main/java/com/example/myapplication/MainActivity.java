package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private JSONArray createJSON() throws JSONException {
        ArrayList<JSONObject> jsonArrayList = new ArrayList<>();
        JSONObject object;
        /*** Ряд 1 ***/
        object = new JSONObject();
        object.put("MemberID", "1");
        object.put("Name", "Анна");
        object.put("Tel", "4954876107");
        jsonArrayList.add(object);
        /*** Ряд 2 ***/
        object = new JSONObject();
        object.put("MemberID", "2");
        object.put("Name", "Николай");
        object.put("Tel", "4954780121");
        jsonArrayList.add(object);
        /*** Ряд 3 ***/
        object = new JSONObject();
        object.put("MemberID", "3");
        object.put("Name", "Владислав");
        object.put("Tel", "4235445712");
        jsonArrayList.add(object);
        /*** Ряд 4 ***/
        object = new JSONObject();
        object.put("MemberID", "4");
        object.put("Name", "Игорь");
        object.put("Tel", "4954723751");
        jsonArrayList.add(object);
        /*** Ряд 5 ***/
        object = new JSONObject();
        object.put("MemberID", "5");
        object.put("Name", "Максим");
        object.put("Tel", "4954543211");
        jsonArrayList.add(object);
        JSONArray jsonArray = new JSONArray(jsonArrayList);
        return jsonArray;
    }

    public void onClick(View view) {
        ListView listView = findViewById(R.id.listView);
        try {
            JSONArray data = createJSON();
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            HashMap<String, String> hashMap;
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonObject = data.getJSONObject(i);
                hashMap = new HashMap<>();
                hashMap.put("MemberID", jsonObject.getString("MemberID"));
                hashMap.put("Name", jsonObject.getString("Name"));
                hashMap.put("Tel", jsonObject.getString("Tel"));
                arrayList.add(hashMap);
            }
            SimpleAdapter simpleAdapter;
            simpleAdapter = new SimpleAdapter(this, arrayList,
                    R.layout.list_item, new String[]{"MemberID",
                    "Name", "Tel"}, new int[]{R.id.item_textViewMemberID,
                    R.id.item_textViewName, R.id.item_textViewNumber});
            listView.setAdapter(simpleAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}