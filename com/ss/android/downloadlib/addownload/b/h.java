package com.ss.android.downloadlib.addownload.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    public static volatile h a;

    public static h a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    public void a(int i2, int i3, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(bVar.s());
        if (a2.a("report_api_hijack", 0) == 0) {
            return;
        }
        int i4 = i3 - i2;
        if (i2 <= 0 || i4 <= a2.a("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i4);
            jSONObject.put("installed_version_code", i3);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("api_hijack", jSONObject, bVar);
    }
}
