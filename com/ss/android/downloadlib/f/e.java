package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static void a(com.ss.android.b.a.b.a aVar, JSONObject jSONObject) {
        if (jSONObject != null && aVar != null) {
            try {
                jSONObject.put("is_patch_apply_handled", aVar.K() ? 1 : 0);
                jSONObject.put("origin_mime_type", aVar.J());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            com.ss.android.socialbase.downloader.k.a RV = com.ss.android.socialbase.downloader.k.a.RV(i);
            JSONObject abv = RV.abv("anti_hijack_report_config");
            if (abv != null) {
                try {
                    g.a aaQ = com.ss.android.socialbase.appdownloader.b.aaQ(abv.optString("report_installer_pkg_name"));
                    if (aaQ != null) {
                        jSONObject.put("installer_package_name", aaQ.c());
                        jSONObject.put("installer_version_code", aaQ.f());
                        jSONObject.put("installer_version_name", aaQ.g());
                    }
                    g.a aaQ2 = com.ss.android.socialbase.appdownloader.b.aaQ(abv.optString("report_file_manager_pkg_name"));
                    if (aaQ2 != null) {
                        jSONObject.put("file_manager_package_name", aaQ2.c());
                        jSONObject.put("file_manager_version_code", aaQ2.f());
                        jSONObject.put("file_manager_version_name", aaQ2.g());
                    }
                    g.a aaQ3 = com.ss.android.socialbase.appdownloader.b.aaQ(abv.optString("report_appstore_pkg_name"));
                    if (aaQ3 != null) {
                        jSONObject.put("appstore_package_name", aaQ3.c());
                        jSONObject.put("appstore_version_code", aaQ3.f());
                        jSONObject.put("appstore_version_name", aaQ3.g());
                    }
                    jSONObject.put("rom_version", com.ss.android.socialbase.downloader.m.g.g());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (RV.a("report_unknown_source", 0) == 1) {
                try {
                    jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.eGu()) ? 1 : 0);
                } catch (Throwable th2) {
                }
            }
        }
    }
}
