package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k {
    public static String a(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", jVar.f37253a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("host", jVar.f37254b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("key", jVar.f37255c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("maxBitrate", jVar.f37256d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("height", jVar.f37257e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("width", jVar.f37258f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("url", jVar.f37259g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("quality", jVar.f37260h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
