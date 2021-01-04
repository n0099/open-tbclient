package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k {
    public static String a(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("avgBitrate", jVar.f11351a);
        } catch (Exception e) {
        }
        try {
            jSONObject.put("host", jVar.f11352b);
        } catch (Exception e2) {
        }
        try {
            jSONObject.put("key", jVar.c);
        } catch (Exception e3) {
        }
        try {
            jSONObject.put("maxBitrate", jVar.d);
        } catch (Exception e4) {
        }
        try {
            jSONObject.put("height", jVar.e);
        } catch (Exception e5) {
        }
        try {
            jSONObject.put("width", jVar.f);
        } catch (Exception e6) {
        }
        try {
            jSONObject.put("url", jVar.g);
        } catch (Exception e7) {
        }
        try {
            jSONObject.put("quality", jVar.h);
        } catch (Exception e8) {
        }
        return jSONObject.toString();
    }
}
