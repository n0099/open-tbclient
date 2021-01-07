package com.fun.ad;

import android.text.TextUtils;
import android.util.Log;
import com.fun.ad.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public List<ar> f8040a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, au> f8041b;

    public void a(String str) {
        m.a("Ad config json: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f8040a = new ArrayList();
            this.f8041b = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (TextUtils.equals(next, "platform_ids")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    if (optJSONArray == null) {
                        Log.e("FunAdSdk", "FunAdConfig: platform_ids can not be null");
                        return;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        this.f8040a.add(new ar(optJSONObject.optString("id"), optJSONObject.optString("type")));
                    }
                } else {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(next);
                    if (optJSONObject2 == null) {
                        Log.e("FunAdSdk", "FunAdConfig: parse sid error: wt is empty");
                        return;
                    }
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("ad_ids");
                    if (optJSONArray2 == null) {
                        Log.e("FunAdSdk", "FunAdConfig: parse sid error: ad_ids is empty");
                        return;
                    }
                    long optLong = optJSONObject2.optLong("wt");
                    ArrayList arrayList = new ArrayList();
                    au auVar = new au(next, optLong, arrayList);
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                        arrayList.add(new au.a(optJSONObject3.optString("id"), optJSONObject3.optString("type"), optJSONObject3.optInt("width"), optJSONObject3.optInt("height"), optJSONObject3.optInt("expressWidth"), optJSONObject3.optInt("expressHeight"), optJSONObject3.optInt("interval", 30), optJSONObject3.optInt("orientation")));
                    }
                    this.f8041b.put(next, auVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("FunAdSdk", "FunAdConfig: parse adConfigJson error");
        }
    }
}
