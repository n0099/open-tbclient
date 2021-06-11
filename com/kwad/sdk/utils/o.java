package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    public static <T> List<T> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object obj = jSONArray.get(i2);
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return arrayList;
    }

    public static JSONArray a(@NonNull List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void a(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    public static void a(JSONObject jSONObject, String str, double d2) {
        try {
            jSONObject.put(str, d2);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, float f2) {
        try {
            jSONObject.put(str, f2);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, int i2) {
        try {
            jSONObject.put(str, i2);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, List<?> list) {
        if (list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (!(obj instanceof com.kwad.sdk.core.b)) {
                if (!(obj instanceof String)) {
                    break;
                }
                jSONArray.put(obj);
            } else {
                a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
            }
            z = true;
        }
        if (z) {
            a(jSONObject, str, jSONArray);
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, boolean z) {
        try {
            jSONObject.put(str, z);
        } catch (JSONException unused) {
        }
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) {
                    optString = "";
                }
                hashMap.put(next, optString);
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }
}
