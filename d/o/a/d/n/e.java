package d.o.a.d.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.o.a.d.f.n;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static double a(int i) {
        return d.o.a.e.b.j.a.d(i).a("clean_min_install_size", 0.0d);
    }

    public static int b(@NonNull d.o.a.e.b.j.a aVar) {
        return aVar.b("external_storage_permission_path_type", 0);
    }

    @NonNull
    public static d.o.a.e.b.j.a c(d.o.a.b.a.c.a aVar) {
        if (aVar == null) {
            return d.o.a.e.b.j.a.r();
        }
        if (aVar.s() != 0) {
            return d.o.a.e.b.j.a.d(aVar.s());
        }
        if (aVar.c()) {
            return d.o.a.e.b.j.a.g(d());
        }
        if (aVar.r() != null) {
            return d.o.a.e.b.j.a.g(aVar.r());
        }
        return d.o.a.e.b.j.a.r();
    }

    @Nullable
    public static JSONObject d() {
        return n.s().optJSONObject("ad");
    }

    public static JSONObject e(d.o.a.a.a.c.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.t()) {
            return d();
        }
        return dVar.p();
    }

    public static long f(int i) {
        return d.o.a.e.b.j.a.d(i).c("storage_min_size", 0L);
    }

    @NonNull
    public static d.o.a.e.b.j.a g(d.o.a.a.a.c.d dVar) {
        return d.o.a.e.b.j.a.g(e(dVar));
    }

    public static boolean h(d.o.a.b.a.c.a aVar) {
        return c(aVar).b("pause_reserve_on_wifi", 0) == 1 && aVar.q();
    }

    public static boolean i(d.o.a.e.b.j.a aVar) {
        return aVar != null && aVar.b("kllk_need_rename_apk", 0) == 1;
    }

    public static int j(@NonNull d.o.a.a.a.c.d dVar) {
        return b(g(dVar));
    }

    public static long k(int i) {
        return d.o.a.e.b.j.a.d(i).c("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean l(int i) {
        return d.o.a.e.b.j.a.d(i).c("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean m(int i) {
        return d.o.a.e.b.j.a.d(i).c("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean n(int i) {
        return d.o.a.e.b.j.a.d(i).b("clean_space_switch", 0) == 1;
    }

    public static boolean o(int i) {
        return d.o.a.e.b.j.a.d(i).b("clean_app_cache_dir", 0) == 1;
    }
}
