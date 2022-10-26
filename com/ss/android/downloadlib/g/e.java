package com.ss.android.downloadlib.g;

import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static double a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_min_install_size", 0.0d);
    }

    public static long b(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("storage_min_size", 0L);
    }

    public static int c(DownloadModel downloadModel) {
        return a(b(downloadModel));
    }

    public static boolean d(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("clean_fetch_apk_switch", 0L) == 1) {
            return true;
        }
        return false;
    }

    public static boolean e(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("clean_space_before_download_switch", 0L) == 1) {
            return true;
        }
        return false;
    }

    public static boolean f(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("clean_space_switch", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean g(int i) {
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("clean_app_cache_dir", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int a(com.ss.android.socialbase.downloader.g.a aVar) {
        return aVar.a("external_storage_permission_path_type", 0);
    }

    public static com.ss.android.socialbase.downloader.g.a b(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.g.a.a(a(downloadModel));
    }

    public static long c(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_fetch_apk_head_time_out", 800L);
    }

    public static com.ss.android.socialbase.downloader.g.a a(com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            return com.ss.android.socialbase.downloader.g.a.c();
        }
        if (aVar.s() != 0) {
            return com.ss.android.socialbase.downloader.g.a.a(aVar.s());
        }
        if (aVar.c()) {
            return com.ss.android.socialbase.downloader.g.a.a(a());
        }
        if (aVar.r() != null) {
            return com.ss.android.socialbase.downloader.g.a.a(aVar.r());
        }
        return com.ss.android.socialbase.downloader.g.a.c();
    }

    public static JSONObject a() {
        return com.ss.android.downloadlib.addownload.j.i().optJSONObject(LaunchStatsUtils.AD);
    }

    public static boolean b() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_notification_anr")) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (com.ss.android.downloadlib.addownload.j.i().optInt("is_enable_start_install_again") == 1) {
            return true;
        }
        return false;
    }

    public static long d() {
        long optLong = com.ss.android.downloadlib.addownload.j.i().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static long e() {
        long optLong = com.ss.android.downloadlib.addownload.j.i().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static JSONObject a(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        if (downloadModel.isAd()) {
            return a();
        }
        return downloadModel.getDownloadSettings();
    }

    public static boolean b(com.ss.android.downloadad.api.a.a aVar) {
        if (a(aVar).a("pause_reserve_on_wifi", 0) != 1 || !aVar.q()) {
            return false;
        }
        return true;
    }

    public static boolean b(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar == null || aVar.a("kllk_need_rename_apk", 0) != 1) {
            return false;
        }
        return true;
    }
}
