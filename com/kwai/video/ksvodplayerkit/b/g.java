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
        fVar.f37527a = jSONObject.optString("url", fVar.f37527a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add((String) optJSONArray.opt(i));
            }
            fVar.f37528b = arrayList;
        }
        fVar.f37529c = jSONObject.optString("m3u8", fVar.f37529c);
        fVar.f37530d = jSONObject.optString("baseUrl", fVar.f37530d);
        fVar.f37531e = jSONObject.optDouble("duration", fVar.f37531e);
        fVar.f37532f = jSONObject.optString("m3u8Slice", fVar.f37532f);
        fVar.f37533g = jSONObject.optInt("bandwidth", fVar.f37533g);
        fVar.f37534h = jSONObject.optString("codecs", fVar.f37534h);
        fVar.i = jSONObject.optInt("width", fVar.i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f37527a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f37528b));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", fVar.f37529c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.f37530d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", fVar.f37531e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f37532f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.f37533g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", fVar.f37534h);
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
