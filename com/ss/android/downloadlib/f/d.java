package com.ss.android.downloadlib.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.IMConnection;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    @Nullable
    public static JSONObject a() {
        return com.ss.android.downloadlib.a.j.i().optJSONObject("ad");
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.k.a g(com.ss.android.a.a.b.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.fm(h(cVar));
    }

    public static JSONObject h(com.ss.android.a.a.b.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.t()) {
            return a();
        }
        return cVar.p();
    }

    public static boolean a(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_switch", 0) == 1;
    }

    public static boolean b(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_vivo", 1) == 1;
    }

    public static boolean c(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_huawei", 1) == 1;
    }

    public static boolean d(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_xiaomi", 1) == 1;
    }

    public static boolean e(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_kllk", 1) == 1;
    }

    public static String QX(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).d("install_guide_lottie_url_xiaomi");
    }

    public static String OK(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).d("install_guide_lottie_url_kllk");
    }

    public static String OL(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).d("install_guide_lottie_url_vivo");
    }

    public static String OM(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).d("install_guide_lottie_url_huawei");
    }

    public static int fJ(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_hijack_days", 15);
    }

    public static int fI(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_interval", 3);
    }

    public static double QY(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).e("install_hijack_ratio", 0.5d);
    }

    public static long QZ(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("install_guide_show_time", IMConnection.RETRY_DELAY_TIMES);
    }

    public static int d(@NonNull com.ss.android.socialbase.downloader.k.a aVar) {
        return aVar.a("external_storage_permission_path_type", 0);
    }

    public static int i(@NonNull com.ss.android.a.a.b.c cVar) {
        return g(cVar).a("external_storage_permission_path_type", 0);
    }

    public static boolean n(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("pause_reserve_on_wifi", 0) == 1;
    }

    public static double Ra(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).e("clean_min_install_size", 0.0d);
    }

    public static long Rb(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("storage_min_size", 0L);
    }

    public static long Rc(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean Rd(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean Re(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("clean_space_optimise_switch", 0L) == 1;
    }

    public static boolean Rf(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("exec_clear_space_switch", 0) == 1;
    }

    public static boolean Rg(int i) {
        return com.ss.android.socialbase.downloader.k.a.RW(i).a("clean_app_cache_dir", 0) == 1;
    }
}
