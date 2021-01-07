package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.g;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
            com.ss.android.socialbase.downloader.k.a Th = com.ss.android.socialbase.downloader.k.a.Th(i);
            JSONObject abB = Th.abB("anti_hijack_report_config");
            if (abB != null) {
                try {
                    g.a aaW = com.ss.android.socialbase.appdownloader.b.aaW(abB.optString("report_installer_pkg_name"));
                    if (aaW != null) {
                        jSONObject.put("installer_package_name", aaW.c());
                        jSONObject.put("installer_version_code", aaW.f());
                        jSONObject.put("installer_version_name", aaW.g());
                    }
                    g.a aaW2 = com.ss.android.socialbase.appdownloader.b.aaW(abB.optString("report_file_manager_pkg_name"));
                    if (aaW2 != null) {
                        jSONObject.put("file_manager_package_name", aaW2.c());
                        jSONObject.put("file_manager_version_code", aaW2.f());
                        jSONObject.put("file_manager_version_name", aaW2.g());
                    }
                    g.a aaW3 = com.ss.android.socialbase.appdownloader.b.aaW(abB.optString("report_appstore_pkg_name"));
                    if (aaW3 != null) {
                        jSONObject.put("appstore_package_name", aaW3.c());
                        jSONObject.put("appstore_version_code", aaW3.f());
                        jSONObject.put("appstore_version_name", aaW3.g());
                    }
                    jSONObject.put("rom_version", com.ss.android.socialbase.downloader.m.g.g());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (Th.a("report_unknown_source", 0) == 1) {
                try {
                    jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.eHT()) ? 1 : 0);
                } catch (Throwable th2) {
                }
            }
        }
    }
}
