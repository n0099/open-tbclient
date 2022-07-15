package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class r {
    public static <T> List<T> a(String str) {
        return s.a(str);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, @NonNull com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                T a = cVar.a();
                a.parseJson(jSONObject);
                arrayList.add(a);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
        return arrayList;
    }

    public static <T> List<T> a(JSONArray jSONArray) {
        return s.a(jSONArray);
    }

    public static JSONArray a(@NonNull List<String> list) {
        return s.a(list);
    }

    public static JSONObject a(Map<String, String> map) {
        return s.a(map);
    }

    public static void a(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    public static void a(JSONObject jSONObject, String str, byte b) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, b);
    }

    public static void a(JSONObject jSONObject, String str, double d) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, d);
    }

    public static void a(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, f);
    }

    public static void a(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, i);
    }

    public static void a(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, j);
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, str2);
    }

    public static void a(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (obj instanceof com.kwad.sdk.core.b) {
                a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
            } else if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Double) || (obj instanceof Boolean)) {
                jSONArray.put(obj);
            } else {
                if (!(obj instanceof Float)) {
                    break;
                }
                try {
                    jSONArray.put(((Float) obj).floatValue());
                } catch (JSONException unused) {
                }
            }
            z = true;
        }
        if (z) {
            a(jSONObject, str, jSONArray);
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, jSONArray);
    }

    public static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, jSONObject2);
    }

    public static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return;
        }
        s.a(jSONObject, str, z);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        s.a(jSONObject, jSONObject2);
    }

    public static Map<String, String> b(String str) {
        return s.b(str);
    }

    public static <T> JSONArray b(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null) {
                    if (!(obj instanceof JSONObject)) {
                        if (obj instanceof com.kwad.sdk.core.b) {
                            obj = ((com.kwad.sdk.core.b) obj).toJson();
                        } else if (!(obj instanceof String)) {
                            throw new IllegalArgumentException("<T> now suppprt type: " + obj.getClass().getName());
                        }
                    }
                    jSONArray.put(obj);
                }
            }
        }
        return jSONArray;
    }
}
