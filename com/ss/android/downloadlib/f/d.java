package com.ss.android.downloadlib.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    @Nullable
    public static JSONObject a() {
        return com.ss.android.downloadlib.a.j.i().optJSONObject(MapBundleKey.MapObjKey.OBJ_AD);
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.k.a g(com.ss.android.a.a.b.c cVar) {
        return com.ss.android.socialbase.downloader.k.a.fl(h(cVar));
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
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_switch", 0) == 1;
    }

    public static boolean b(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_vivo", 1) == 1;
    }

    public static boolean c(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_huawei", 1) == 1;
    }

    public static boolean d(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_xiaomi", 1) == 1;
    }

    public static boolean e(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_kllk", 1) == 1;
    }

    public static String Si(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).d("install_guide_lottie_url_xiaomi");
    }

    public static String PV(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).d("install_guide_lottie_url_kllk");
    }

    public static String PW(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).d("install_guide_lottie_url_vivo");
    }

    public static String PX(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).d("install_guide_lottie_url_huawei");
    }

    public static int hk(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_hijack_days", 15);
    }

    public static int hj(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_interval", 3);
    }

    public static double Sj(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).e("install_hijack_ratio", 0.5d);
    }

    public static long Sk(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("install_guide_show_time", IMConnection.RETRY_DELAY_TIMES);
    }

    public static int d(@NonNull com.ss.android.socialbase.downloader.k.a aVar) {
        return aVar.a("external_storage_permission_path_type", 0);
    }

    public static int i(@NonNull com.ss.android.a.a.b.c cVar) {
        return g(cVar).a("external_storage_permission_path_type", 0);
    }

    public static boolean n(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("pause_reserve_on_wifi", 0) == 1;
    }

    public static double Sl(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).e("clean_min_install_size", 0.0d);
    }

    public static long Sm(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("storage_min_size", 0L);
    }

    public static long Sn(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean So(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean Sp(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("clean_space_optimise_switch", 0L) == 1;
    }

    public static boolean Sq(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("exec_clear_space_switch", 0) == 1;
    }

    public static boolean Sr(int i) {
        return com.ss.android.socialbase.downloader.k.a.Th(i).a("clean_app_cache_dir", 0) == 1;
    }
}
