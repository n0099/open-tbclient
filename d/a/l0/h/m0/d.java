package d.a.l0.h.m0;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import d.a.l0.a.k2.g.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f51138c = new d();

    /* renamed from: d  reason: collision with root package name */
    public static String f51139d = "banner_ad_close_btn_show_key";

    /* renamed from: e  reason: collision with root package name */
    public static String f51140e = "banner_ad_close_duration_key";

    /* renamed from: f  reason: collision with root package name */
    public static String f51141f = "gdt_banner_ad_app_id_key";

    /* renamed from: g  reason: collision with root package name */
    public static String f51142g = "gdt_video_ad_app_id_key";

    /* renamed from: h  reason: collision with root package name */
    public static String f51143h = "gdt_banner_ad_id_key";

    /* renamed from: i  reason: collision with root package name */
    public static String f51144i = "gdt_video_ad_id_key";
    public static String j = "gdt_video_ad_config_time";
    public static String k = "video_interaction_optimization";
    public static String l = "video_request_optimization";
    public static String m = "first_request_optimization";

    /* renamed from: a  reason: collision with root package name */
    public long f51145a;

    /* renamed from: b  reason: collision with root package name */
    public long f51146b;

    /* loaded from: classes3.dex */
    public class a extends StringResponseCallback {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            JSONObject optJSONObject;
            try {
                if (!d.a.l0.h.y.c.a(str, i2) || (optJSONObject = new JSONObject(str).optJSONObject("data")) == null) {
                    return;
                }
                d.this.J(optJSONObject.optString("show", "1"));
                d.this.L(optJSONObject.optString("duration", "1"));
                d.this.I(optJSONObject.optLong("startNoBannerADGap", 5L));
                d.this.H(optJSONObject.optLong("bannerShowSuccGap", 120L));
                d.this.G(optJSONObject.optLong("preventBannerADShowingGap", 60L));
            } catch (JSONException unused) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    /* loaded from: classes3.dex */
    public class b extends StringResponseCallback {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            JSONObject optJSONObject;
            if (200 == i2) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") != 0) {
                        return;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ads_config")) == null) {
                        d.this.N("");
                        d.this.P("");
                        d.this.Q("");
                        d.this.R("");
                        d.this.O(0L);
                        d.this.T(false);
                        d.this.S(false);
                        d.this.M(false);
                        return;
                    }
                    d.this.N(optJSONObject.optString("banner"));
                    d.this.P(optJSONObject.optString("video"));
                    d.this.Q(optJSONObject.optString("banner_app_id"));
                    d.this.R(optJSONObject.optString("video_app_id"));
                    d.this.O(System.currentTimeMillis());
                    d.this.T(optJSONObject.optBoolean("video_ui_opt"));
                    d.this.S(optJSONObject.optBoolean("video_request_opt"));
                    d.this.M(optJSONObject.optBoolean("first_request_opt"));
                } catch (JSONException unused) {
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    public static d A() {
        return f51138c;
    }

    public boolean B() {
        return h.a().getBoolean(l, false);
    }

    public boolean C() {
        return h.a().getBoolean(k, false);
    }

    public void D() {
        this.f51145a = System.currentTimeMillis();
    }

    public void E() {
        this.f51146b = System.currentTimeMillis();
    }

    public void F() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || d.a.l0.h.t.a.b() == null || d.a.l0.a.c1.a.p() == null) {
            return;
        }
        i2.X().getRequest().cookieManager(d.a.l0.a.c1.a.p().a()).url(d.a.l0.h.t.a.b().a()).addUrlParam("app_key", i2.D()).addUrlParam("host", i2.getPackageName()).addUrlParam(IAdRequestParam.OS, "android").requestFrom(16).requestFrom(1604).build().executeAsync(new b());
    }

    public final void G(long j2) {
        h.a().putLong("banner_ad_close_key", j2);
    }

    public final void H(long j2) {
        h.a().putLong("banner_ad_repeat_show_key", j2);
    }

    public final void I(long j2) {
        h.a().putLong("banner_ad_start_show_key", j2);
    }

    public final void J(String str) {
        h.a().putBoolean(f51139d, "1".equals(str));
    }

    public void K(String str, String str2) {
        h.a().putString(str, str2);
    }

    public final void L(String str) {
        h.a().putString(f51140e, str);
    }

    public void M(boolean z) {
        h.a().putBoolean(m, z);
    }

    public final void N(String str) {
        h.a().putString(f51143h, str);
    }

    public final void O(long j2) {
        h.a().putLong(j, j2);
    }

    public final void P(String str) {
        h.a().putString(f51144i, str);
    }

    public final void Q(String str) {
        h.a().putString(f51141f, str);
    }

    public final void R(String str) {
        h.a().putString(f51142g, str);
    }

    public void S(boolean z) {
        h.a().putBoolean(l, z);
    }

    public void T(boolean z) {
        h.a().putBoolean(k, z);
    }

    public boolean k() {
        return this.f51145a != 0 && System.currentTimeMillis() - this.f51145a <= p();
    }

    public boolean l() {
        return this.f51146b != 0 && System.currentTimeMillis() - this.f51146b <= o();
    }

    public void m() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || d.a.l0.a.c1.a.n() == null || d.a.l0.a.c1.a.p() == null) {
            return;
        }
        i2.X().getRequest().cookieManager(d.a.l0.a.c1.a.p().a()).url(d.a.l0.h.t.a.b().d()).requestFrom(16).requestFrom(1603).build().executeAsync(new a());
    }

    public long n() {
        return h.a().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public long o() {
        return h.a().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    public long p() {
        return h.a().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    public boolean q() {
        return h.a().getBoolean(f51139d, true);
    }

    public final long r(String str) {
        String string = h.a().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    public final long s() {
        String string = h.a().getString(f51140e, "1");
        if (string != null) {
            return Long.valueOf(string).longValue() * 60 * 60 * 1000;
        }
        return 3600000L;
    }

    public boolean t(String str) {
        return System.currentTimeMillis() - r(str) <= s();
    }

    public boolean u() {
        return h.a().getBoolean(m, false);
    }

    public String v() {
        return h.a().getString(f51143h, "");
    }

    public Long w() {
        return Long.valueOf(h.a().getLong(j, 0L));
    }

    public String x() {
        return h.a().getString(f51144i, "");
    }

    public String y() {
        return h.a().getString(f51141f, "");
    }

    public String z() {
        return h.a().getString(f51142g, "");
    }
}
