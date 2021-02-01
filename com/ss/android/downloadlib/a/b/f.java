package com.ss.android.downloadlib.a.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    private static volatile f qbd;

    private f() {
    }

    public static f eEv() {
        if (qbd == null) {
            synchronized (c.class) {
                if (qbd == null) {
                    qbd = new f();
                }
            }
        }
        return qbd;
    }

    public void a(int i, int i2, com.ss.android.b.a.b.a aVar) {
        if (aVar != null) {
            com.ss.android.socialbase.downloader.k.a RV = com.ss.android.socialbase.downloader.k.a.RV(aVar.t());
            if (RV.a("report_api_hijack", 0) != 0) {
                int i3 = i2 - i;
                if (i > 0 && i3 > RV.a("check_api_hijack_version_code_diff", 500)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("version_code_diff", i3);
                        jSONObject.put("installed_version_code", i2);
                        jSONObject.put("hijack_type", 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    com.ss.android.downloadlib.e.a.eFc().a("api_hijack", jSONObject, aVar);
                }
            }
        }
    }
}
