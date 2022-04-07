package com.kwad.sdk.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f {
    public static <T extends c> List<T> a(String str, @NonNull d<T> dVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                T createInstance = dVar.createInstance();
                createInstance.parseJson(jSONObject);
                arrayList.add(createInstance);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static <T> JSONArray a(@NonNull Set<T> set) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : set) {
            if (!(obj instanceof JSONObject)) {
                if (obj instanceof c) {
                    obj = ((c) obj).toJson();
                }
            }
            jSONArray.put(obj);
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

    public static void a(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0 && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, z);
            } catch (JSONException unused) {
            }
        }
    }
}
