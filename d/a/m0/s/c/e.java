package d.a.m0.s.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int f50442a = 2;

    public static int a() {
        int k = d.a.m0.r.d0.b.j().k("pref_key_fun_ad_first_floor_min", 2);
        int k2 = d.a.m0.r.d0.b.j().k("pref_key_fun_ad_first_floor_max", 3);
        if (k < k2) {
            f50442a = d.a.n0.c1.a.a.a(k, k2);
        } else {
            f50442a = d.a.n0.c1.a.a.a(k2, k);
        }
        if (f50442a < 0) {
            f50442a = 2;
        }
        return f50442a;
    }

    public static int b() {
        if (f50442a < 0) {
            f50442a = 2;
        }
        return f50442a;
    }

    public static int c() {
        int k = d.a.m0.r.d0.b.j().k("pref_key_fun_ad_density", 6);
        if (k > 0) {
            return k;
        }
        return 6;
    }

    public static int d() {
        return d.a.m0.r.d0.b.j().k("pref_key_fun_ad_frs_density", 5);
    }

    public static int e() {
        return d.a.m0.r.d0.b.j().k("pref_key_fun_ad_frs_first_floor", 2);
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            d.a.m0.r.d0.b.j().v("pref_key_fun_ad_frs_first_floor", optInt);
            d.a.m0.r.d0.b.j().v("pref_key_fun_ad_frs_density", optInt2);
            int optInt3 = jSONObject.optInt("index_bear_density", 6);
            int optInt4 = jSONObject.optInt("index_bear_first_floor_max", 3);
            int optInt5 = jSONObject.optInt("index_bear_first_floor_min", 2);
            d.a.m0.r.d0.b.j().v("pref_key_fun_ad_density", optInt3);
            d.a.m0.r.d0.b.j().v("pref_key_fun_ad_first_floor_max", optInt4);
            d.a.m0.r.d0.b.j().v("pref_key_fun_ad_first_floor_min", optInt5);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
