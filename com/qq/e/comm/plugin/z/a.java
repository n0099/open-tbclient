package com.qq.e.comm.plugin.z;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<String>> f13032a = new HashMap();

    public a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.getString(i));
                    }
                    this.f13032a.put(next, arrayList);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<String> a(String str) {
        List<String> list;
        synchronized (this) {
            list = this.f13032a.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
        }
        return list;
    }

    public boolean a(String str, String str2) {
        boolean z;
        synchronized (this) {
            z = false;
            List<String> a2 = a(str);
            if (a2 == null) {
                a2 = new ArrayList<>();
            }
            if (!a2.contains(str2)) {
                a2.add(str2);
                z = true;
            }
            this.f13032a.put(str, a2);
        }
        return z;
    }

    @NonNull
    public String toString() {
        return new JSONObject(this.f13032a).toString();
    }
}
