package d.b.g0.g.i0;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.b.g0.a.a2.g.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f48211c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static String f48212d = "banner_ad_close_btn_show_key";

    /* renamed from: e  reason: collision with root package name */
    public static String f48213e = "banner_ad_close_duration_key";

    /* renamed from: f  reason: collision with root package name */
    public static String f48214f = "gdt_banner_ad_app_id_key";

    /* renamed from: g  reason: collision with root package name */
    public static String f48215g = "gdt_video_ad_app_id_key";

    /* renamed from: h  reason: collision with root package name */
    public static String f48216h = "gdt_banner_ad_id_key";
    public static String i = "gdt_video_ad_id_key";
    public static String j = "gdt_video_ad_config_time";
    public static String k = "video_interaction_optimization";
    public static String l = "video_request_optimization";
    public static String m = "first_request_optimization";

    /* renamed from: a  reason: collision with root package name */
    public long f48217a;

    /* renamed from: b  reason: collision with root package name */
    public long f48218b;

    /* loaded from: classes3.dex */
    public class a extends StringResponseCallback {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            JSONObject optJSONObject;
            try {
                if (!d.b.g0.g.w.c.a(str, i) || (optJSONObject = new JSONObject(str).optJSONObject("data")) == null) {
                    return;
                }
                c.this.J(optJSONObject.optString("show", "1"));
                c.this.L(optJSONObject.optString("duration", "1"));
                c.this.I(optJSONObject.optLong("startNoBannerADGap", 5L));
                c.this.H(optJSONObject.optLong("bannerShowSuccGap", 120L));
                c.this.G(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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
        public void onSuccess(String str, int i) {
            JSONObject optJSONObject;
            if (200 == i) {
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
                        c.this.N("");
                        c.this.P("");
                        c.this.Q("");
                        c.this.R("");
                        c.this.O(0L);
                        c.this.T(false);
                        c.this.S(false);
                        c.this.M(false);
                        return;
                    }
                    c.this.N(optJSONObject.optString("banner"));
                    c.this.P(optJSONObject.optString("video"));
                    c.this.Q(optJSONObject.optString("banner_app_id"));
                    c.this.R(optJSONObject.optString("video_app_id"));
                    c.this.O(System.currentTimeMillis());
                    c.this.T(optJSONObject.optBoolean("video_ui_opt"));
                    c.this.S(optJSONObject.optBoolean("video_request_opt"));
                    c.this.M(optJSONObject.optBoolean("first_request_opt"));
                } catch (JSONException unused) {
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
        }
    }

    public static c A() {
        return f48211c;
    }

    public boolean B() {
        return h.a().getBoolean(l, false);
    }

    public boolean C() {
        return h.a().getBoolean(k, false);
    }

    public void D() {
        this.f48217a = System.currentTimeMillis();
    }

    public void E() {
        this.f48218b = System.currentTimeMillis();
    }

    public void F() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || d.b.g0.a.w0.a.l() == null || d.b.g0.a.w0.a.m() == null) {
            return;
        }
        y.V().getRequest().cookieManager(d.b.g0.a.w0.a.m().a()).url(d.b.g0.a.w0.a.l().f()).addUrlParam(com.alipay.sdk.cons.b.f1858h, y.B()).addUrlParam("host", y.getPackageName()).addUrlParam(IXAdRequestInfo.OS, "android").build().executeAsync(new b());
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
        h.a().putBoolean(f48212d, "1".equals(str));
    }

    public void K(String str, String str2) {
        h.a().putString(str, str2);
    }

    public final void L(String str) {
        h.a().putString(f48213e, str);
    }

    public void M(boolean z) {
        h.a().putBoolean(m, z);
    }

    public final void N(String str) {
        h.a().putString(f48216h, str);
    }

    public final void O(long j2) {
        h.a().putLong(j, j2);
    }

    public final void P(String str) {
        h.a().putString(i, str);
    }

    public final void Q(String str) {
        h.a().putString(f48214f, str);
    }

    public final void R(String str) {
        h.a().putString(f48215g, str);
    }

    public void S(boolean z) {
        h.a().putBoolean(l, z);
    }

    public void T(boolean z) {
        h.a().putBoolean(k, z);
    }

    public boolean k() {
        return this.f48217a != 0 && System.currentTimeMillis() - this.f48217a <= p();
    }

    public boolean l() {
        return this.f48218b != 0 && System.currentTimeMillis() - this.f48218b <= o();
    }

    public void m() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || d.b.g0.a.w0.a.l() == null || d.b.g0.a.w0.a.m() == null) {
            return;
        }
        y.V().getRequest().cookieManager(d.b.g0.a.w0.a.m().a()).url(d.b.g0.a.w0.a.l().p()).build().executeAsync(new a());
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
        return h.a().getBoolean(f48212d, true);
    }

    public final long r(String str) {
        String string = h.a().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    public final long s() {
        String string = h.a().getString(f48213e, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : VideoCloudSetting.HOUR_MILLISECOND;
    }

    public boolean t(String str) {
        return System.currentTimeMillis() - r(str) <= s();
    }

    public boolean u() {
        return h.a().getBoolean(m, false);
    }

    public String v() {
        return h.a().getString(f48216h, "");
    }

    public Long w() {
        return Long.valueOf(h.a().getLong(j, 0L));
    }

    public String x() {
        return h.a().getString(i, "");
    }

    public String y() {
        return h.a().getString(f48214f, "");
    }

    public String z() {
        return h.a().getString(f48215g, "");
    }
}
