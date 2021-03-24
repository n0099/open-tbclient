package com.kwai.video.ksvodplayerkit.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class h {
    public static String a(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fill_preload", gVar.f37311a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("preload_url", gVar.f37312b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("download_bytes", gVar.f37313c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("preload_bytes", gVar.f37314d);
        } catch (Exception unused4) {
        }
        return jSONObject.toString();
    }
}
