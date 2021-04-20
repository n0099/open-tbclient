package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k {
    public static String a(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", jVar.f37543a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("host", jVar.f37544b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("key", jVar.f37545c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("maxBitrate", jVar.f37546d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("height", jVar.f37547e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("width", jVar.f37548f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("url", jVar.f37549g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("quality", jVar.f37550h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
