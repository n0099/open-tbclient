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
            com.ss.android.socialbase.downloader.k.a RA = com.ss.android.socialbase.downloader.k.a.RA(i);
            JSONObject aau = RA.aau("anti_hijack_report_config");
            if (aau != null) {
                try {
                    g.a ZP = com.ss.android.socialbase.appdownloader.b.ZP(aau.optString("report_installer_pkg_name"));
                    if (ZP != null) {
                        jSONObject.put("installer_package_name", ZP.c());
                        jSONObject.put("installer_version_code", ZP.f());
                        jSONObject.put("installer_version_name", ZP.g());
                    }
                    g.a ZP2 = com.ss.android.socialbase.appdownloader.b.ZP(aau.optString("report_file_manager_pkg_name"));
                    if (ZP2 != null) {
                        jSONObject.put("file_manager_package_name", ZP2.c());
                        jSONObject.put("file_manager_version_code", ZP2.f());
                        jSONObject.put("file_manager_version_name", ZP2.g());
                    }
                    g.a ZP3 = com.ss.android.socialbase.appdownloader.b.ZP(aau.optString("report_appstore_pkg_name"));
                    if (ZP3 != null) {
                        jSONObject.put("appstore_package_name", ZP3.c());
                        jSONObject.put("appstore_version_code", ZP3.f());
                        jSONObject.put("appstore_version_name", ZP3.g());
                    }
                    jSONObject.put("rom_version", com.ss.android.socialbase.downloader.m.g.g());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (RA.a("report_unknown_source", 0) == 1) {
                try {
                    jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.b.eEd()) ? 1 : 0);
                } catch (Throwable th2) {
                }
            }
        }
    }
}
