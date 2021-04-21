package com.kwai.video.ksvodplayerkit.b;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {
    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.f37622a = jSONObject.optString("url", fVar.f37622a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add((String) optJSONArray.opt(i));
            }
            fVar.f37623b = arrayList;
        }
        fVar.f37624c = jSONObject.optString("m3u8", fVar.f37624c);
        fVar.f37625d = jSONObject.optString("baseUrl", fVar.f37625d);
        fVar.f37626e = jSONObject.optDouble("duration", fVar.f37626e);
        fVar.f37627f = jSONObject.optString("m3u8Slice", fVar.f37627f);
        fVar.f37628g = jSONObject.optInt("bandwidth", fVar.f37628g);
        fVar.f37629h = jSONObject.optString("codecs", fVar.f37629h);
        fVar.i = jSONObject.optInt("width", fVar.i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f37622a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f37623b));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", fVar.f37624c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.f37625d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", fVar.f37626e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f37627f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.f37628g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", fVar.f37629h);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("width", fVar.i);
        } catch (Exception unused9) {
        }
        try {
            jSONObject.put("height", fVar.j);
        } catch (Exception unused10) {
        }
        try {
            jSONObject.put("frameRate", fVar.k);
        } catch (Exception unused11) {
        }
        try {
            jSONObject.put("cacheKey", fVar.l);
        } catch (Exception unused12) {
        }
        return jSONObject.toString();
    }
}
