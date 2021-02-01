package com.ss.android.a.a.e;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static long C(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static boolean a(com.ss.android.socialbase.downloader.k.a aVar, String str) {
        if (aVar == null || aVar.a("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }
}
