package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import com.baidu.down.request.db.DownloadDataConstants;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f {
    public static JSONObject a(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        l.a(jSONObject, "open_url", l.a(aVar.f(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject b(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        l.a(jSONObject, com.ss.android.socialbase.appdownloader.f.d.i().replaceAll("\\.", "_"), Integer.valueOf(l.b(com.ss.android.downloadlib.addownload.j.getContext(), com.ss.android.socialbase.appdownloader.f.d.i())));
        return jSONObject;
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        int i;
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            if (bVar.X()) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.put("is_patch_apply_handled", i);
            jSONObject.put("origin_mime_type", bVar.W());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        int i;
        try {
            c(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a == null) {
                return;
            }
            if (a.V()) {
                i = 1;
            } else {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
            a(a, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, int i) {
        int i2;
        if (jSONObject == null) {
            return;
        }
        JSONArray e = com.ss.android.socialbase.downloader.g.a.a(i).e("ah_report_config");
        if (e != null) {
            for (int i3 = 0; i3 < e.length(); i3++) {
                try {
                    String string = e.getString(i3);
                    g.a a = com.ss.android.socialbase.appdownloader.f.a.a(string);
                    if (a != null) {
                        String replaceAll = string.replaceAll("\\.", "_");
                        jSONObject.put(replaceAll, a.f() + "_" + a.g());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            if (com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.c.N())) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            jSONObject.put("is_unknown_source_enabled", i2);
        } catch (Throwable unused) {
        }
    }

    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a;
        double d;
        int i;
        if (jSONObject == null || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        try {
            c(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - a.T()));
            jSONObject.putOpt("click_download_size", Long.valueOf(a.U()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            a.A();
            com.ss.android.downloadlib.addownload.b.i.a().a(a);
            jSONObject.put("click_pause_times", a.z());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            if (curBytes >= 0 && totalBytes > 0) {
                d = curBytes / totalBytes;
            } else {
                d = 0.0d;
            }
            jSONObject.put("download_percent", d);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long H = a.H();
            if (H > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - H);
            }
            long B = a.B();
            if (B > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - B);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(a.E()));
            jSONObject.putOpt("fail_msg", a.F());
            jSONObject.put("download_failed_times", a.x());
            if (com.ss.android.socialbase.appdownloader.e.d.a()) {
                i = 1;
            } else {
                i = 2;
            }
            jSONObject.put("can_show_notification", i);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        int i;
        int i2;
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getId());
                if (a != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(a.T()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(a.U()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        int i3 = 1;
        if (com.ss.android.socialbase.appdownloader.e.d.a()) {
            i = 1;
        } else {
            i = 2;
        }
        jSONObject.putOpt("permission_notification", Integer.valueOf(i));
        if (com.ss.android.socialbase.downloader.i.f.c(com.ss.android.downloadlib.addownload.j.getContext())) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        jSONObject.putOpt("network_available", Integer.valueOf(i2));
        if (!com.ss.android.socialbase.downloader.i.f.b(com.ss.android.downloadlib.addownload.j.getContext())) {
            i3 = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i3));
    }
}
