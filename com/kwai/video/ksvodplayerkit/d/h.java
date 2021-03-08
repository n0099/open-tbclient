package com.kwai.video.ksvodplayerkit.d;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {
    public static String a(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fill_preload", gVar.f7290a);
        } catch (Exception e) {
        }
        try {
            jSONObject.put("preload_url", gVar.b);
        } catch (Exception e2) {
        }
        try {
            jSONObject.put("download_bytes", gVar.c);
        } catch (Exception e3) {
        }
        try {
            jSONObject.put("preload_bytes", gVar.d);
        } catch (Exception e4) {
        }
        return jSONObject.toString();
    }
}
