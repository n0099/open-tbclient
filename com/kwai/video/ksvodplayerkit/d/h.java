package com.kwai.video.ksvodplayerkit.d;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class h {
    public static String a(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fill_preload", gVar.f38186a);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("preload_url", gVar.f38187b);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("download_bytes", gVar.f38188c);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("preload_bytes", gVar.f38189d);
        } catch (Exception unused4) {
        }
        return jSONObject.toString();
    }
}
