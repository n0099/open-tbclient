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
        fVar.f37237a = jSONObject.optString("url", fVar.f37237a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add((String) optJSONArray.opt(i));
            }
            fVar.f37238b = arrayList;
        }
        fVar.f37239c = jSONObject.optString("m3u8", fVar.f37239c);
        fVar.f37240d = jSONObject.optString("baseUrl", fVar.f37240d);
        fVar.f37241e = jSONObject.optDouble("duration", fVar.f37241e);
        fVar.f37242f = jSONObject.optString("m3u8Slice", fVar.f37242f);
        fVar.f37243g = jSONObject.optInt("bandwidth", fVar.f37243g);
        fVar.f37244h = jSONObject.optString("codecs", fVar.f37244h);
        fVar.i = jSONObject.optInt("width", fVar.i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f37237a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f37238b));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", fVar.f37239c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.f37240d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", fVar.f37241e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f37242f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.f37243g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", fVar.f37244h);
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
