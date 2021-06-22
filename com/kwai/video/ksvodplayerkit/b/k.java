package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class k {
    public static String a(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", jVar.f38123a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("host", jVar.f38124b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("key", jVar.f38125c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("maxBitrate", jVar.f38126d);
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("height", jVar.f38127e);
        } catch (Exception unused5) {
        }
        try {
            jSONObject.put("width", jVar.f38128f);
        } catch (Exception unused6) {
        }
        try {
            jSONObject.put("url", jVar.f38129g);
        } catch (Exception unused7) {
        }
        try {
            jSONObject.put("quality", jVar.f38130h);
        } catch (Exception unused8) {
        }
        return jSONObject.toString();
    }
}
