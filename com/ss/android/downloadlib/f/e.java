package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static void a(com.ss.android.b.a.b.a aVar, JSONObject jSONObject) {
        if (jSONObject != null && aVar != null) {
            try {
                jSONObject.put("is_patch_apply_handled", aVar.K() ? 1 : 0);
                jSONObject.put("origin_mime_type", aVar.up());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            com.ss.android.socialbase.downloader.k.a Sa = com.ss.android.socialbase.downloader.k.a.Sa(i);
            JSONObject abM = Sa.abM("anti_hijack_report_config");
            if (abM != null) {
                try {
                    g.a abh = com.ss.android.socialbase.appdownloader.b.abh(abM.optString("report_installer_pkg_name"));
                    if (abh != null) {
                        jSONObject.put("installer_package_name", abh.c());
                        jSONObject.put("installer_version_code", abh.f());
                        jSONObject.put("installer_version_name", abh.g());
                    }
                    g.a abh2 = com.ss.android.socialbase.appdownloader.b.abh(abM.optString("report_file_manager_pkg_name"));
                    if (abh2 != null) {
                        jSONObject.put("file_manager_package_name", abh2.c());
                        jSONObject.put("file_manager_version_code", abh2.f());
                        jSONObject.put("file_manager_version_name", abh2.g());
                    }
                    g.a abh3 = com.ss.android.socialbase.appdownloader.b.abh(abM.optString("report_appstore_pkg_name"));
                    if (abh3 != null) {
                        jSONObject.put("appstore_package_name", abh3.c());
                        jSONObject.put("appstore_version_code", abh3.f());
                        jSONObject.put("appstore_version_name", abh3.g());
                    }
                    jSONObject.put("rom_version", com.ss.android.socialbase.downloader.m.g.g());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (Sa.a("report_unknown_source", 0) == 1) {
                try {
                    jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.eGG()) ? 1 : 0);
                } catch (Throwable th2) {
                }
            }
        }
    }
}
