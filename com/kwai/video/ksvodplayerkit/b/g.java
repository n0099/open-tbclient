package com.kwai.video.ksvodplayerkit.b;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class g {
    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.f38008a = jSONObject.optString("url", fVar.f38008a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add((String) optJSONArray.opt(i2));
            }
            fVar.f38009b = arrayList;
        }
        fVar.f38010c = jSONObject.optString("m3u8", fVar.f38010c);
        fVar.f38011d = jSONObject.optString("baseUrl", fVar.f38011d);
        fVar.f38012e = jSONObject.optDouble("duration", fVar.f38012e);
        fVar.f38013f = jSONObject.optString("m3u8Slice", fVar.f38013f);
        fVar.f38014g = jSONObject.optInt("bandwidth", fVar.f38014g);
        fVar.f38015h = jSONObject.optString("codecs", fVar.f38015h);
        fVar.f38016i = jSONObject.optInt("width", fVar.f38016i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f38008a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f38009b));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", fVar.f38010c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.f38011d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", fVar.f38012e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f38013f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.f38014g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", fVar.f38015h);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("width", fVar.f38016i);
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
