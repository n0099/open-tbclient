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
        fVar.f38106a = jSONObject.optString("url", fVar.f38106a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add((String) optJSONArray.opt(i2));
            }
            fVar.f38107b = arrayList;
        }
        fVar.f38108c = jSONObject.optString("m3u8", fVar.f38108c);
        fVar.f38109d = jSONObject.optString("baseUrl", fVar.f38109d);
        fVar.f38110e = jSONObject.optDouble("duration", fVar.f38110e);
        fVar.f38111f = jSONObject.optString("m3u8Slice", fVar.f38111f);
        fVar.f38112g = jSONObject.optInt("bandwidth", fVar.f38112g);
        fVar.f38113h = jSONObject.optString("codecs", fVar.f38113h);
        fVar.f38114i = jSONObject.optInt("width", fVar.f38114i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f38106a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f38107b));
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("m3u8", fVar.f38108c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.f38109d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("duration", fVar.f38110e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f38111f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.f38112g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("codecs", fVar.f38113h);
        } catch (Exception unused8) {
        }
        try {
            jSONObject.put("width", fVar.f38114i);
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
