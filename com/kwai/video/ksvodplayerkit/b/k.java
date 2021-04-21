package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k {
    public static String a(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", jVar.f37638a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("host", jVar.f37639b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("key", jVar.f37640c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("maxBitrate", jVar.f37641d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("height", jVar.f37642e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("width", jVar.f37643f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("url", jVar.f37644g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("quality", jVar.f37645h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
