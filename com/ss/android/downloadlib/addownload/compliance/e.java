package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.b.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static void a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, f.a().e(j));
    }

    public static void b(String str, long j) {
        a(str, null, j);
    }

    public static void a(int i, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, eVar);
    }

    public static void a(String str, long j) {
        com.ss.android.downloadlib.addownload.b.e e = f.a().e(j);
        if (!e.x()) {
            e.c.setRefer(str);
            com.ss.android.downloadlib.d.a.a().b("lp_app_dialog_click", e);
        }
    }

    public static void a(String str, com.ss.android.downloadlib.addownload.b.e eVar) {
        com.ss.android.downloadlib.d.a.a().b(str, eVar);
    }

    public static void a(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, f.a().e(j));
    }
}
