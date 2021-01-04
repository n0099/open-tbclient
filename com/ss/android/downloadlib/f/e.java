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
            com.ss.android.socialbase.downloader.k.a SR = com.ss.android.socialbase.downloader.k.a.SR(i);
            JSONObject abA = SR.abA("anti_hijack_report_config");
            if (abA != null) {
                try {
                    g.a aaV = com.ss.android.socialbase.appdownloader.b.aaV(abA.optString("report_installer_pkg_name"));
                    if (aaV != null) {
                        jSONObject.put("installer_package_name", aaV.c());
                        jSONObject.put("installer_version_code", aaV.f());
                        jSONObject.put("installer_version_name", aaV.g());
                    }
                    g.a aaV2 = com.ss.android.socialbase.appdownloader.b.aaV(abA.optString("report_file_manager_pkg_name"));
                    if (aaV2 != null) {
                        jSONObject.put("file_manager_package_name", aaV2.c());
                        jSONObject.put("file_manager_version_code", aaV2.f());
                        jSONObject.put("file_manager_version_name", aaV2.g());
                    }
                    g.a aaV3 = com.ss.android.socialbase.appdownloader.b.aaV(abA.optString("report_appstore_pkg_name"));
                    if (aaV3 != null) {
                        jSONObject.put("appstore_package_name", aaV3.c());
                        jSONObject.put("appstore_version_code", aaV3.f());
                        jSONObject.put("appstore_version_name", aaV3.g());
                    }
                    jSONObject.put("rom_version", com.ss.android.socialbase.downloader.m.g.g());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (SR.a("report_unknown_source", 0) == 1) {
                try {
                    jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.eHp()) ? 1 : 0);
                } catch (Throwable th2) {
                }
            }
        }
    }
}
