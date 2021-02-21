package com.ss.android.downloadlib.a.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    private static volatile f qbD;

    private f() {
    }

    public static f eED() {
        if (qbD == null) {
            synchronized (c.class) {
                if (qbD == null) {
                    qbD = new f();
                }
            }
        }
        return qbD;
    }

    public void a(int i, int i2, com.ss.android.b.a.b.a aVar) {
        if (aVar != null) {
            com.ss.android.socialbase.downloader.k.a RW = com.ss.android.socialbase.downloader.k.a.RW(aVar.t());
            if (RW.a("report_api_hijack", 0) != 0) {
                int i3 = i2 - i;
                if (i > 0 && i3 > RW.a("check_api_hijack_version_code_diff", 500)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("version_code_diff", i3);
                        jSONObject.put("installed_version_code", i2);
                        jSONObject.put("hijack_type", 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    com.ss.android.downloadlib.e.a.eFk().a("api_hijack", jSONObject, aVar);
                }
            }
        }
    }
}
