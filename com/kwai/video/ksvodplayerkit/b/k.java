package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class k {
    public static String a(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", jVar.f37254a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("host", jVar.f37255b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("key", jVar.f37256c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("maxBitrate", jVar.f37257d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("height", jVar.f37258e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("width", jVar.f37259f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("url", jVar.f37260g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("quality", jVar.f37261h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
