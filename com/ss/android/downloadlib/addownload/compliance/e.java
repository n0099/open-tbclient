package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.b.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static void a(String str, long j2) {
        com.ss.android.downloadlib.addownload.b.e e2 = f.a().e(j2);
        if (e2.x()) {
            return;
        }
        e2.f59465c.setRefer(str);
        com.ss.android.downloadlib.d.a.a().b("lp_app_dialog_click", e2);
    }

    public static void b(String str, long j2) {
        a(str, null, j2);
    }

    public static void a(String str, JSONObject jSONObject, long j2) {
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, f.a().e(j2));
    }

    public static void a(String str, com.ss.android.downloadlib.addownload.b.e eVar) {
        com.ss.android.downloadlib.d.a.a().b(str, eVar);
    }

    public static void a(int i2, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, eVar);
    }

    public static void a(int i2, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, f.a().e(j2));
    }
}
