package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    @Nullable
    public static JSONObject a() {
        return com.ss.android.downloadlib.addownload.j.i().optJSONObject("ad");
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.g.a b(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.g.a.a(a(downloadModel));
    }

    public static int c(@NonNull DownloadModel downloadModel) {
        return a(b(downloadModel));
    }

    public static boolean d(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean e(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean f(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_space_switch", 0) == 1;
    }

    public static boolean g(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_app_cache_dir", 0) == 1;
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
        return a(aVar).a("pause_reserve_on_wifi", 0) == 1 && aVar.q();
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

    public static long c(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_fetch_apk_head_time_out", 800L);
    }

    public static long b(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("storage_min_size", 0L);
    }

    public static boolean c() {
        return com.ss.android.downloadlib.addownload.j.i().optInt("is_enable_start_install_again") == 1;
    }

    @NonNull
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

    public static boolean b(com.ss.android.socialbase.downloader.g.a aVar) {
        return aVar != null && aVar.a("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean b() {
        return com.ss.android.socialbase.downloader.g.a.c().a("fix_notification_anr");
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        return aVar.a("external_storage_permission_path_type", 0);
    }

    public static double a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_min_install_size", 0.0d);
    }
}
