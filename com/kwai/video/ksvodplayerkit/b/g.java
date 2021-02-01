package com.kwai.video.ksvodplayerkit.b;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class g {
    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.f11048a = jSONObject.optString("url", fVar.f11048a);
        JSONArray optJSONArray = jSONObject.optJSONArray("backupUrl");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                arrayList.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
            fVar.f11049b = arrayList;
        }
        fVar.c = jSONObject.optString("m3u8", fVar.c);
        fVar.d = jSONObject.optString("baseUrl", fVar.d);
        fVar.e = jSONObject.optDouble("duration", fVar.e);
        fVar.f = jSONObject.optString("m3u8Slice", fVar.f);
        fVar.g = jSONObject.optInt("bandwidth", fVar.g);
        fVar.h = jSONObject.optString("codecs", fVar.h);
        fVar.i = jSONObject.optInt("width", fVar.i);
        fVar.j = jSONObject.optInt("height", fVar.j);
        fVar.k = jSONObject.optDouble("frameRate", fVar.k);
        fVar.l = jSONObject.optString("cacheKey", fVar.l);
        return fVar;
    }

    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", fVar.f11048a);
        } catch (Exception e) {
        }
        try {
            jSONObject.put("backupUrl", new JSONArray((Collection) fVar.f11049b));
        } catch (Exception e2) {
        }
        try {
            jSONObject.put("m3u8", fVar.c);
        } catch (Exception e3) {
        }
        try {
            jSONObject.put("baseUrl", fVar.d);
        } catch (Exception e4) {
        }
        try {
            jSONObject.put("duration", fVar.e);
        } catch (Exception e5) {
        }
        try {
            jSONObject.put("m3u8Slice", fVar.f);
        } catch (Exception e6) {
        }
        try {
            jSONObject.put("bandwidth", fVar.g);
        } catch (Exception e7) {
        }
        try {
            jSONObject.put("codecs", fVar.h);
        } catch (Exception e8) {
        }
        try {
            jSONObject.put("width", fVar.i);
        } catch (Exception e9) {
        }
        try {
            jSONObject.put("height", fVar.j);
        } catch (Exception e10) {
        }
        try {
            jSONObject.put("frameRate", fVar.k);
        } catch (Exception e11) {
        }
        try {
            jSONObject.put("cacheKey", fVar.l);
        } catch (Exception e12) {
        }
        return jSONObject.toString();
    }
}
