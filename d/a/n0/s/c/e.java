package d.a.n0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int f54225a = 2;

    public static int a() {
        int k = d.a.n0.r.d0.b.j().k("pref_key_fun_ad_first_floor_min", 2);
        int k2 = d.a.n0.r.d0.b.j().k("pref_key_fun_ad_first_floor_max", 3);
        if (k < k2) {
            f54225a = d.a.o0.c1.a.a.a(k, k2);
        } else {
            f54225a = d.a.o0.c1.a.a.a(k2, k);
        }
        if (f54225a < 0) {
            f54225a = 2;
        }
        return f54225a;
    }

    public static int b() {
        if (f54225a < 0) {
            f54225a = 2;
        }
        return f54225a;
    }

    public static int c() {
        int k = d.a.n0.r.d0.b.j().k("pref_key_fun_ad_density", 6);
        if (k > 0) {
            return k;
        }
        return 6;
    }

    public static int d() {
        return d.a.n0.r.d0.b.j().k("pref_key_fun_ad_frs_density", 5);
    }

    public static int e() {
        return d.a.n0.r.d0.b.j().k("pref_key_fun_ad_frs_first_floor", 2);
    }

    public static int f() {
        return d.a.n0.r.d0.b.j().k("key_video_middle_density", 4);
    }

    public static int g() {
        int k = d.a.n0.r.d0.b.j().k("key_video_middle_first", 2);
        if (k <= 0) {
            return 2;
        }
        return k;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            d.a.n0.r.d0.b.j().v("pref_key_fun_ad_frs_first_floor", optInt);
            d.a.n0.r.d0.b.j().v("pref_key_fun_ad_frs_density", optInt2);
            int optInt3 = jSONObject.optInt("index_bear_density", 6);
            int optInt4 = jSONObject.optInt("index_bear_first_floor_max", 3);
            int optInt5 = jSONObject.optInt("index_bear_first_floor_min", 2);
            d.a.n0.r.d0.b.j().v("pref_key_fun_ad_density", optInt3);
            d.a.n0.r.d0.b.j().v("pref_key_fun_ad_first_floor_max", optInt4);
            d.a.n0.r.d0.b.j().v("pref_key_fun_ad_first_floor_min", optInt5);
            int optInt6 = jSONObject.optInt("video_bear_density", 4);
            int optInt7 = jSONObject.optInt("video_bear_first_floor", 2);
            d.a.n0.r.d0.b.j().v("key_video_middle_density", optInt6);
            d.a.n0.r.d0.b.j().v("key_video_middle_first", optInt7);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
