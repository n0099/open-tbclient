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
        fVar.f37238a = jSONObject.optString("url", fVar.f37238a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add((String) optJSONArray.opt(i));
            }
            fVar.f37239b = arrayList;
        }
        fVar.f37240c = jSONObject.optString("m3u8", fVar.f37240c);
        fVar.f37241d = jSONObject.optString("baseUrl", fVar.f37241d);
        fVar.f37242e = jSONObject.optDouble("duration", fVar.f37242e);
        fVar.f37243f = jSONObject.optString("m3u8Slice", fVar.f37243f);
        fVar.f37244g = jSONObject.optInt("bandwidth", fVar.f37244g);
        fVar.f37245h = jSONObject.optString("codecs", fVar.f37245h);
        fVar.i = jSONObject.optInt("width", fVar.i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f37238a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f37239b));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", fVar.f37240c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.f37241d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", fVar.f37242e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f37243f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.f37244g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", fVar.f37245h);
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
