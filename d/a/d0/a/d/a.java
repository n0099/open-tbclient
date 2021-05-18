package d.a.d0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompatJellybean;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.sdk.internal.ScreenUtils;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.sdk.container.widget.BDSplashActionView;
import com.baidu.sdk.container.widget.CircleTextProgressbar;
import com.baidu.sdk.container.widget.DisplayInfoView;
import com.baidu.sdk.container.widget.RectangleCountDownView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.coremedia.iso.boxes.FreeSpaceBox;
import d.a.b0.a.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a implements d.a.d0.a.g.b, AdView.a {
    public static final String M = "a";
    public int F;
    public String H;
    public String I;
    public boolean J;
    public int K;
    public JSONObject L;

    /* renamed from: a  reason: collision with root package name */
    public Context f39802a;

    /* renamed from: e  reason: collision with root package name */
    public AbsCountDownView f39806e;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39809h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.d0.a.c.b f39810i;
    public JSONObject j;
    public JSONObject k;
    public AdView l;
    public d.a.d0.a.j.a m;
    public TextView n;
    public d.a.d0.a.g.a o;
    public d.a.d0.a.g.c p;
    public boolean v;
    public String w;
    public String x;

    /* renamed from: b  reason: collision with root package name */
    public int f39803b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f39804c = null;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f39805d = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39808g = false;
    public int q = 4;
    public String r = "";
    public String s = "image";
    public int t = 5000;
    public String u = "";
    public boolean y = true;
    public boolean z = false;
    public boolean A = false;
    public boolean B = true;
    public boolean C = false;
    public boolean D = true;
    public boolean E = false;
    public int G = 16;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.d0.a.k.b f39807f = d.a.d0.a.k.b.i();

    /* renamed from: d.a.d0.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0522a implements View.OnClickListener {
        public View$OnClickListenerC0522a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.C();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.y();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.z();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DisplayInfoView.d {
        public d() {
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPermissionClick() {
            a.this.I();
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void onPrivacyClick() {
            a.this.J();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.d0.a.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f39815a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f39816b;

        /* renamed from: d.a.d0.a.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0523a implements Runnable {
            public RunnableC0523a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                a.this.A(eVar.f39815a, eVar.f39816b);
            }
        }

        public e(ImageView imageView, String str) {
            this.f39815a = imageView;
            this.f39816b = str;
        }

        @Override // d.a.d0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            a.this.D("Fetch Ad icon image load failed.");
        }

        @Override // d.a.d0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a.this.A(this.f39815a, this.f39816b);
            } else {
                d.a.d0.a.k.a.a(new RunnableC0523a());
            }
        }

        @Override // d.a.d0.a.e.a
        public void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f39808g) {
                return;
            }
            a.this.f39808g = true;
            a.this.F();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f39808g) {
                return;
            }
            a.this.f39808g = true;
            a.this.F();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.pause();
            a.this.K();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements AbsCountDownView.b {
        public i() {
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onEnd() {
            if (a.this.f39809h) {
                a.this.u("time_end");
            }
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i2) {
        }
    }

    /* loaded from: classes2.dex */
    public class j implements b.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f39823a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f39824b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f39825c;

        /* renamed from: d.a.d0.a.d.a$j$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0524a implements View.OnClickListener {
            public View$OnClickListenerC0524a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.C();
            }
        }

        public j(LottieAnimationView lottieAnimationView, int i2, int i3) {
            this.f39823a = lottieAnimationView;
            this.f39824b = i2;
            this.f39825c = i3;
        }

        @Override // d.a.b0.a.c.b.f
        public void a() {
            a aVar = a.this;
            aVar.m(this.f39823a, this.f39824b, this.f39825c, "click_float_lottie", aVar.L);
            this.f39823a.setOnClickListener(new View$OnClickListenerC0524a());
            a aVar2 = a.this;
            if (aVar2.K == 1) {
                aVar2.v();
            }
        }

        @Override // d.a.b0.a.c.b.f
        public void b() {
            try {
                a.this.j.put("displayMantle", true);
                a.this.r();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public a(Context context, JSONObject jSONObject) {
        this.f39802a = context.getApplicationContext();
        this.j = jSONObject;
        AdView adView = new AdView(this.f39802a);
        this.l = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.l.setListener(this);
        this.f39810i = new d.a.d0.a.c.b(this.f39802a);
        this.m = new d.a.d0.a.j.a(this.f39802a);
        L();
    }

    public final void A(ImageView imageView, String str) {
        if (this.l == null || this.f39802a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(XBaseAdContainer.Baidu_Ad_IMG_ID);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            l(imageView, d.a.d0.a.k.h.a(this.f39802a, 13.0f), d.a.d0.a.k.h.a(this.f39802a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            l(imageView, d.a.d0.a.k.h.a(this.f39802a, 25.0f), d.a.d0.a.k.h.a(this.f39802a, 13.0f), "ad_logo");
        }
        this.f39804c = (ImageView) this.l.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.l.findViewWithTag("AD_LOGO");
        this.f39805d = imageView2;
        this.f39808g = false;
        if (this.f39804c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new f());
        this.f39804c.setOnClickListener(new g());
    }

    public void B(String str) {
        ImageView imageView = new ImageView(this.f39802a);
        MaterialLoader.k(this.f39802a).q(imageView, str, new e(imageView, str));
    }

    public void C() {
        d.a.d0.a.g.a aVar = this.o;
        if (aVar != null) {
            aVar.onAdClick();
        }
    }

    public void D(String str) {
        d.a.d0.a.g.c cVar = this.p;
        if (cVar != null) {
            cVar.onAdError(str);
        }
    }

    public void E() {
        d.a.d0.a.g.c cVar = this.p;
        if (cVar != null) {
            cVar.onAdLoad();
        }
    }

    public void F() {
        d.a.d0.a.g.a aVar = this.o;
        if (aVar != null) {
            aVar.onAdLogoClick();
        }
    }

    public void G() {
        d.a.d0.a.g.c cVar = this.p;
        if (cVar != null) {
            cVar.onAdStart();
        }
    }

    public void H(String str) {
        d.a.d0.a.g.c cVar = this.p;
        if (cVar != null) {
            cVar.onAdStop(str);
        }
    }

    public void I() {
        d.a.d0.a.g.a aVar = this.o;
        if (aVar != null) {
            aVar.onPermissionClick();
        }
    }

    public void J() {
        d.a.d0.a.g.a aVar = this.o;
        if (aVar != null) {
            aVar.onPrivacyClick();
        }
    }

    public void K() {
        d.a.d0.a.g.a aVar = this.o;
        if (aVar != null) {
            aVar.onSkipClick();
        }
    }

    public void L() {
        try {
            this.r = this.j.optString("prod");
            this.u = this.j.optString("material_url");
            this.k = this.j.optJSONObject("style");
            this.L = this.j.optJSONObject("inner_style");
            this.f39809h = this.j.optBoolean("countDownNew", true);
            this.A = this.j.optBoolean("Display_Down_Info");
            this.v = this.j.optBoolean("popDialogIfDl", false);
            this.w = this.j.optString("publisher");
            this.x = this.j.optString("app_version");
            this.z = this.j.optBoolean("show_wifi_view", "video".equals(this.s));
            this.y = this.j.optBoolean("show_skip", "rsplash".equals(this.r));
            this.t = this.j.optInt("skipTime", 5000);
            this.B = this.j.optBoolean("hide_ad_logo", true);
            this.C = this.j.optBoolean("hide_bd_logo", false);
            this.D = this.j.optBoolean("full_screen", true);
            this.E = this.j.optBoolean("show_host_small_logo", false);
            this.F = this.j.optInt("skip_btn_type");
            this.q = this.j.optInt("close_type");
            this.G = this.j.optInt("bitmapDisplayMode");
            this.H = this.j.optString("host_big_logo_res_id");
        } catch (Exception unused) {
        }
    }

    public void M() {
        this.f39807f.b(M, IntentConfig.START);
        d.a.d0.a.k.a.a(new b());
    }

    public void N() {
        this.f39803b = 2;
        d.a.d0.a.k.a.a(new c());
    }

    @Override // d.a.d0.a.g.b
    public void a() {
        this.f39807f.b(M, "load");
        this.f39803b = 1;
    }

    @Override // d.a.d0.a.g.b
    public void b(d.a.d0.a.g.c cVar) {
        this.p = cVar;
    }

    @Override // d.a.d0.a.g.b
    public void d(d.a.d0.a.g.a aVar) {
        this.o = aVar;
    }

    @Override // d.a.d0.a.g.b
    public void destroy() {
        this.l = null;
        this.n = null;
        this.f39805d = null;
        this.f39804c = null;
        this.f39802a = null;
    }

    @Override // d.a.d0.a.g.b
    public View getAdView() {
        return this.l;
    }

    public final void i(String str) {
        int optInt = this.j.optInt("ad_label_width", 25);
        int optInt2 = this.j.optInt("ad_label_height", 13);
        TextView textView = new TextView(this.f39802a);
        textView.setText(str);
        textView.setBackgroundColor(Color.parseColor("#33000000"));
        textView.setTextSize(10.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-1);
        textView.setGravity(17);
        l(textView, d.a.d0.a.k.h.a(this.f39802a, optInt), d.a.d0.a.k.h.a(this.f39802a, optInt2), NotificationCompatJellybean.KEY_LABEL);
    }

    public void j(View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.D) {
            this.l.addView(view, layoutParams);
            return;
        }
        n();
        layoutParams.addRule(2, 15);
        this.l.addView(view, layoutParams);
    }

    public void k() {
        if (!this.A || this.v || TextUtils.isEmpty(this.x) || TextUtils.isEmpty(this.w)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f39802a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.f39802a);
        cVar.a(this.x, this.w);
        cVar.c(-10066330);
        cVar.b(new d());
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        l(relativeLayout, -1, -2, "download_desc");
    }

    public void l(View view, int i2, int i3, String str) {
        m(view, i2, i3, str, this.k);
    }

    public void m(View view, int i2, int i3, String str, JSONObject jSONObject) {
        if (this.l == null || view == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.m.g(layoutParams, new d.a.d0.a.j.b().b(jSONObject, str, this.D));
        this.l.addView(view, layoutParams);
    }

    public void n() {
        if (TextUtils.isEmpty(this.H)) {
            return;
        }
        int optInt = this.j.optInt("bottom_logo_height", d.a.d0.a.j.b.f39859a);
        if (optInt != d.a.d0.a.j.b.f39859a) {
            d.a.d0.a.j.b.f39859a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.f39802a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d.a.d0.a.k.h.a(this.f39802a, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            ImageView imageView = new ImageView(this.f39802a);
            imageView.setImageResource(Integer.parseInt(this.H));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            relativeLayout.addView(imageView);
            this.l.addView(relativeLayout, layoutParams);
        } catch (Throwable th) {
            this.f39807f.f(M, th);
        }
    }

    public void o() {
        if (this.E) {
            String optString = this.j.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.j.optInt("small_logo_width", -2);
            int optInt2 = this.j.optInt("small_logo_height", -2);
            try {
                ImageView imageView = new ImageView(this.f39802a);
                imageView.setImageResource(Integer.parseInt(optString));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                l(imageView, d.a.d0.a.k.h.a(this.f39802a, optInt), d.a.d0.a.k.h.a(this.f39802a, optInt2), "logo");
            } catch (Throwable th) {
                this.f39807f.f(M, th);
            }
        }
    }

    public void p() {
        if (this.B) {
            String optString = this.j.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                i(optString);
            } else {
                B("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.C) {
                B("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    @Override // d.a.d0.a.g.b
    public void pause() {
        AbsCountDownView absCountDownView = this.f39806e;
        if (absCountDownView != null) {
            absCountDownView.c();
        }
    }

    public void q() {
        this.I = this.j.optString("lottie_url");
        this.J = this.j.optBoolean("lottie_show");
        this.K = this.j.optInt("ad_click_opt");
        if (TextUtils.isEmpty(this.I) || !this.J) {
            return;
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.f39802a);
        JSONObject optJSONObject = this.L.optJSONObject("click_float_lottie");
        double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
        double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
        int screenWidth = (int) (ScreenUtils.getScreenWidth(this.f39802a) * optDouble);
        d.a.b0.a.c.b.c().b(this.I, lottieAnimationView, null, new j(lottieAnimationView, screenWidth, (int) (screenWidth * optDouble2)));
    }

    public void r() {
        if (this.j.optBoolean("displayMantle", false)) {
            String optString = this.j.optString("mantleActionText");
            int optInt = this.j.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.D);
            aVar.n(new View$OnClickListenerC0522a());
            aVar.k(this.f39802a).a(this.l);
        }
    }

    @Override // d.a.d0.a.g.b
    public void resume() {
        AbsCountDownView absCountDownView = this.f39806e;
        if (absCountDownView != null) {
            absCountDownView.b();
        }
    }

    public final void s() {
        try {
            if (this.F == 1) {
                this.f39806e = new RectangleCountDownView(this.f39802a);
            } else {
                this.f39806e = new CircleTextProgressbar(this.f39802a);
            }
            this.f39806e.setVisibility(4);
            this.f39806e.setOnClickListener(new h());
            this.f39806e.setCountdownProgressListener(new i());
            l(this.f39806e, d.a.d0.a.k.h.a(this.f39802a, this.j.optInt("skip_btn_width", 40)), d.a.d0.a.k.h.a(this.f39802a, this.j.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
        } catch (Exception unused) {
        }
    }

    public void t() {
        if (this.z) {
            TextView textView = new TextView(this.f39802a);
            this.n = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.n.setTextColor(Color.parseColor("#999999"));
            this.n.setTextSize(0, d.a.d0.a.k.h.c(this.f39802a, 11));
            l(this.n, -2, -2, "wifi_tip");
        }
    }

    public void u(String str) {
        H(str);
    }

    public abstract void v();

    public void w() {
        if (!d.a.d0.a.k.e.f39864b || this.f39802a == null) {
            return;
        }
        TextView textView = new TextView(this.f39802a);
        textView.setTextColor(-16776961);
        textView.setTextSize(15.0f);
        textView.setText("P : " + d.a.d0.a.k.e.f39863a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = 10;
        layoutParams.addRule(13);
        this.l.addView(textView, layoutParams);
    }

    public void x() {
        if (this.y) {
            s();
            if (!"video".equals(this.s)) {
                this.f39806e.setTimeMillis(this.t);
                this.f39806e.b();
            }
            int i2 = this.q;
            if (i2 == 5) {
                this.f39806e.setVisibility(0);
            } else if (i2 == 1) {
                this.f39806e.setVisibility(0);
            }
        }
    }

    public void y() {
        t();
        r();
        k();
        x();
        p();
        o();
        w();
        q();
    }

    public void z() {
    }
}
