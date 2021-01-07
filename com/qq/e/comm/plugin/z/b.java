package com.qq.e.comm.plugin.z;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qq.e.comm.plugin.y.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a> f13034a = new HashMap();

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f13035a;

        /* renamed from: b  reason: collision with root package name */
        private String f13036b;
        private String c;
        private String d;
        private String e;
        private JSONObject f;

        public a(String str, String str2, JSONObject jSONObject) {
            this.f13035a = str;
            this.f13036b = str2;
            this.c = jSONObject.optString("ver");
            this.d = jSONObject.optString("root_id");
            this.e = jSONObject.optString("url");
            this.f = jSONObject;
        }

        public a(JSONObject jSONObject) {
            this(jSONObject.optString("id"), jSONObject.optString("data"), jSONObject);
        }

        public String a() {
            return this.f13036b;
        }

        public JSONObject b() {
            try {
                return new JSONObject(this.f, new String[]{"id", "ver"});
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f13034a.put(next, new a(jSONObject.getJSONObject(next)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public a a(String str) {
        return this.f13034a.get(str);
    }

    public boolean a(JSONObject jSONObject, com.qq.e.comm.plugin.y.c cVar) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                u.a(1210025, cVar);
                return false;
            }
            this.f13034a.put(optString, new a(optString, optString2, jSONObject));
            u.a(1210026, cVar);
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, a> entry : this.f13034a.entrySet()) {
                a value = entry.getValue();
                if (value != null && value.f != null) {
                    jSONObject.put(entry.getKey(), value.f);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
