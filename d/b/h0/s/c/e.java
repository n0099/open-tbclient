package d.b.h0.s.c;

import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Integer> f51159a;

    public static int a() {
        return d.b.h0.r.d0.b.i().j("pref_key_fun_ad_frs_density", 5);
    }

    public static int b() {
        return d.b.h0.r.d0.b.i().j("pref_key_fun_ad_frs_first_floor", 2);
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            d.b.h0.r.d0.b.i().u("pref_key_fun_ad_frs_first_floor", optInt);
            d.b.h0.r.d0.b.i().u("pref_key_fun_ad_frs_density", optInt2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("first_ floor", null);
            if (optString != null) {
                jSONObject.optInt("density", 6);
                this.f51159a = new ArrayList<>();
                for (String str : optString.split("\\|")) {
                    int d2 = d.b.b.e.m.b.d(str, 2);
                    if (d2 > 0) {
                        this.f51159a.add(Integer.valueOf(d2));
                    }
                }
            }
            d.b.h0.r.d0.b.i().w("pref_key_fun_ad_density", jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
