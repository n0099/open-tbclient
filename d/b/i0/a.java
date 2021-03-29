package d.b.i0;

import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static final a j = new a();

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f51834a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public int f51835b;

    /* renamed from: c  reason: collision with root package name */
    public int f51836c;

    /* renamed from: d  reason: collision with root package name */
    public int f51837d;

    /* renamed from: e  reason: collision with root package name */
    public String f51838e;

    /* renamed from: f  reason: collision with root package name */
    public int f51839f;

    /* renamed from: g  reason: collision with root package name */
    public int f51840g;

    /* renamed from: h  reason: collision with root package name */
    public int f51841h;
    public int i;

    public static a e() {
        return j;
    }

    public int a() {
        return this.f51839f;
    }

    public int b() {
        return this.f51841h;
    }

    public int c() {
        return this.f51840g;
    }

    public String d() {
        return this.f51838e;
    }

    public boolean f() {
        return this.i == 1;
    }

    public boolean g() {
        return this.f51835b == 1;
    }

    public void h(JSONObject jSONObject) {
        boolean z = this.f51834a.get();
        if (jSONObject == null || z) {
            return;
        }
        this.f51834a.set(true);
        jSONObject.optInt("tieba_landing_page_type_switch", -1);
        this.f51835b = jSONObject.optInt("tieba_fix_apk_install_status_switch", 1);
        this.f51836c = jSONObject.optInt("tieba_12.2_download_ad_discard", -1);
        this.f51837d = jSONObject.optInt("tieba_12.3_ad_discard_optimize", -1);
        this.f51838e = jSONObject.optString("tieba_follow_up_cmatch_switchs", "");
        this.f51839f = jSONObject.optInt("tieba_follow_up_expire_time", 7);
        this.f51840g = jSONObject.optInt("tieba_follow_up_max_remind_times", 3);
        this.f51841h = jSONObject.optInt("tieba_follow_up_gap_time", 5);
        this.i = jSONObject.optInt("tieba_12.4_download_path", 0);
    }

    public boolean i() {
        return this.f51837d == 1;
    }

    public boolean j() {
        return this.f51836c == 1;
    }
}
