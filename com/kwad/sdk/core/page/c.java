package com.kwad.sdk.core.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.core.webview.jshandler.r;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.y;
import com.kwad.sdk.core.webview.kwai.g;
import com.kwad.sdk.core.webview.kwai.h;
import com.kwad.sdk.utils.at;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements p.b {
    public boolean B;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f54490b;

    /* renamed from: c  reason: collision with root package name */
    public int f54491c;

    /* renamed from: d  reason: collision with root package name */
    public View f54492d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f54493e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f54494f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54495g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f54496h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54497i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f54498j;
    public TextView k;
    public TextView l;
    public LinearLayout o;
    public TextView p;
    public ImageView q;
    public ViewGroup r;
    public g s;
    public h t;
    public com.kwad.sdk.core.webview.a u;
    public a w;
    public s x;
    public boolean z;
    public Handler m = new Handler(Looper.getMainLooper());
    public boolean n = true;
    public int v = com.kwad.sdk.core.config.b.aA();
    public int y = -1;
    public boolean A = false;

    /* loaded from: classes8.dex */
    public interface a {
        void onBackBtnClicked(View view);

        void onCloseBtnClicked(View view);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f54500b;

        /* renamed from: c  reason: collision with root package name */
        public final String f54501c;

        /* renamed from: d  reason: collision with root package name */
        public final String f54502d;

        public b(C2103c c2103c) {
            this.a = c2103c.a;
            this.f54500b = c2103c.f54503b;
            this.f54501c = c2103c.f54505d;
            this.f54502d = c2103c.f54504c;
        }
    }

    /* renamed from: com.kwad.sdk.core.page.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2103c {
        public boolean a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54503b = true;

        /* renamed from: c  reason: collision with root package name */
        public String f54504c;

        /* renamed from: d  reason: collision with root package name */
        public String f54505d;

        public b a() {
            return new b(this);
        }

        public C2103c a(String str) {
            this.f54504c = str;
            return this;
        }

        public C2103c a(boolean z) {
            this.a = z;
            return this;
        }

        public C2103c b(String str) {
            this.f54505d = str;
            return this;
        }

        public C2103c b(boolean z) {
            this.f54503b = z;
            return this;
        }
    }

    public c(Context context, AdTemplate adTemplate, int i2, boolean z) {
        this.z = false;
        this.a = context;
        this.f54490b = adTemplate;
        this.f54491c = i2;
        this.z = z;
        this.f54492d = LayoutInflater.from(context).inflate(R.layout.ksad_activity_ad_webview, (ViewGroup) null);
    }

    private <T extends View> T a(int i2) {
        View view = this.f54492d;
        if (view == null) {
            return null;
        }
        return (T) view.findViewById(i2);
    }

    private void a(WebView webView) {
        webView.getSettings().setAllowFileAccess(true);
    }

    private void a(KsAdWebView ksAdWebView) {
        m();
        h hVar = new h(ksAdWebView, this.u);
        this.t = hVar;
        ksAdWebView.addJavascriptInterface(hVar, "KwaiAdForThird");
    }

    private void a(KsAdWebView ksAdWebView, g gVar) {
        s sVar = new s();
        this.x = sVar;
        gVar.a(sVar);
        gVar.a(new p(this));
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.f54490b);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.u, bVar, n(), true));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.u, bVar, n(), true));
        gVar.a(new t(this.u, bVar));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.h(this.u));
        gVar.a(new q(this.u));
        gVar.a(new k(this.u));
        gVar.a(new f(this.u));
        gVar.a(new y(new y.a() { // from class: com.kwad.sdk.core.page.c.7
            @Override // com.kwad.sdk.core.webview.jshandler.y.a
            public void a() {
                String a2 = com.kwad.sdk.core.response.a.a.a(c.this.a, com.kwad.sdk.core.response.a.d.j(c.this.f54490b));
                if (at.a(a2)) {
                    return;
                }
                com.kwad.sdk.core.download.kwai.b.a(c.this.a, c.this.f54490b, a2);
            }
        }));
        final r rVar = new r();
        ksAdWebView.setDeepLinkListener(new KsAdWebView.b() { // from class: com.kwad.sdk.core.page.c.8
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
            public void a() {
                rVar.c();
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.b
            public void b() {
                rVar.d();
            }
        });
        gVar.a(rVar);
    }

    private void b(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.f54495g != null) {
            this.f54495g.setVisibility(bVar.f54500b ? 0 : 8);
        }
        if (this.f54494f != null) {
            this.f54494f.setVisibility(bVar.a ? 0 : 8);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        m();
        g gVar = new g(ksAdWebView);
        this.s = gVar;
        a(ksAdWebView, gVar);
        ksAdWebView.addJavascriptInterface(this.s, "KwaiAd");
    }

    private void c(KsAdWebView ksAdWebView) {
        p.a aVar = new p.a();
        aVar.n = 0;
        aVar.w = this.f54491c;
        ksAdWebView.setClientParams(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f54498j.setText(i());
        this.l.setText(j());
    }

    private String i() {
        StringBuilder sb;
        int i2 = this.v / 60;
        if (i2 >= 10) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append("0");
        }
        sb.append(i2);
        sb.append("");
        return sb.toString();
    }

    private String j() {
        StringBuilder sb;
        int i2 = this.v % 60;
        if (i2 >= 10) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append("0");
        }
        sb.append(i2);
        sb.append("");
        return sb.toString();
    }

    private void k() {
        LinearLayout linearLayout = (LinearLayout) a(R.id.ksad_web_tip_bar);
        this.o = linearLayout;
        if (this.B) {
            linearLayout.setVisibility(8);
            return;
        }
        this.p = (TextView) a(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) a(R.id.ksad_web_tip_close_btn);
        this.q = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.o.setVisibility(8);
            }
        });
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f54490b);
        boolean af = com.kwad.sdk.core.response.a.a.af(j2);
        String ab = com.kwad.sdk.core.response.a.a.ab(j2);
        if (!af) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        this.p.setText(ab);
        this.p.setSelected(true);
    }

    private void l() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.u = aVar;
        aVar.a(this.f54490b);
        com.kwad.sdk.core.webview.a aVar2 = this.u;
        aVar2.a = 0;
        aVar2.f54892e = this.f54493e;
        aVar2.f54891d = this.r;
    }

    private void m() {
        g gVar = this.s;
        if (gVar != null) {
            gVar.a();
            this.s = null;
        }
        h hVar = this.t;
        if (hVar != null) {
            hVar.a();
            this.t = null;
        }
    }

    @NonNull
    private b.c n() {
        return new b.c() { // from class: com.kwad.sdk.core.page.c.9
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
            }
        };
    }

    public static /* synthetic */ int o(c cVar) {
        int i2 = cVar.v;
        cVar.v = i2 - 1;
        return i2;
    }

    public View a() {
        return this.f54492d;
    }

    public void a(a aVar) {
        this.w = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar) {
        AdInfo.AdBaseInfo adBaseInfo;
        String str;
        this.B = (TextUtils.isEmpty(bVar.f54502d) || TextUtils.isEmpty(bVar.f54501c)) ? false : true;
        this.f54493e = (KsAdWebView) a(R.id.ksad_video_webview);
        TextView textView = (TextView) a(R.id.ksad_kwad_titlebar_title);
        this.f54494f = (ImageView) a(R.id.ksad_kwad_web_navi_back);
        a((WebView) this.f54493e);
        c(this.f54493e);
        this.f54493e.setTemplateData(this.f54490b);
        this.f54493e.loadUrl(bVar.f54501c);
        this.f54493e.b();
        this.f54493e.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.c.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view, int i2, int i3, int i4, int i5) {
                if (c.this.B && c.this.o.getVisibility() == 0) {
                    c.this.o.setVisibility(8);
                }
            }
        });
        this.f54493e.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.page.c.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i2, String str2, String str3) {
                c.this.A = false;
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
                c.this.A = true;
                if (c.this.z) {
                    c.this.e();
                }
            }
        });
        this.f54495g = (ImageView) a(R.id.ksad_kwad_web_navi_close);
        this.r = (ViewGroup) a(R.id.ksad_landing_page_root);
        if (this.B) {
            str = bVar.f54502d;
        } else {
            List<AdInfo> list = this.f54490b.adInfoList;
            if (list == null || list.size() <= 0 || this.f54490b.adInfoList.get(0) == null || (adBaseInfo = this.f54490b.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
                this.f54495g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.f54493e != null && c.this.f54493e.canGoBack()) {
                            c.this.f54493e.goBack();
                            com.kwad.sdk.core.report.a.l(c.this.f54490b);
                        } else if (c.this.w != null) {
                            c.this.w.onCloseBtnClicked(view);
                        }
                    }
                });
                this.f54494f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c.this.f54493e != null && c.this.f54493e.canGoBack()) {
                            c.this.f54493e.goBack();
                            com.kwad.sdk.core.report.a.l(c.this.f54490b);
                        } else if (c.this.w != null) {
                            c.this.w.onBackBtnClicked(view);
                        }
                    }
                });
                if (this.f54490b != null) {
                    return;
                }
                k();
                if (com.kwad.sdk.core.response.a.a.d(com.kwad.sdk.core.response.a.d.j(this.f54490b))) {
                    l();
                    a(this.f54493e);
                } else if (this.f54491c == 4) {
                    this.f54490b.interactLandingPageShowing = true;
                    l();
                    b(this.f54493e);
                }
                b(bVar);
                this.f54496h = (LinearLayout) a(R.id.ksad_reward_land_page_open_tip);
                this.f54497i = (TextView) a(R.id.ksad_reward_land_page_open_desc);
                this.f54498j = (TextView) a(R.id.ksad_reward_land_page_open_minute);
                this.k = (TextView) a(R.id.ksad_reward_land_page_open_colon);
                this.l = (TextView) a(R.id.ksad_reward_land_page_open_second);
                if (com.kwad.sdk.core.response.a.d.v(this.f54490b)) {
                    this.f54496h.setVisibility(0);
                    if (!this.f54490b.mRewardVerifyCalled) {
                        h();
                        this.m.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.page.c.5
                            @Override // java.lang.Runnable
                            @SuppressLint({"SetTextI18n"})
                            public void run() {
                                if (c.this.n) {
                                    c.this.m.postDelayed(this, 500L);
                                    return;
                                }
                                if (c.this.v <= 0) {
                                    c.this.f54497i.setText("任务已完成");
                                    c.this.f54498j.setVisibility(8);
                                    c.this.k.setVisibility(8);
                                    c.this.l.setVisibility(8);
                                    com.kwad.sdk.reward.d.a().b();
                                } else {
                                    c.this.h();
                                    c.this.m.postDelayed(this, 1000L);
                                }
                                c.o(c.this);
                            }
                        }, 1000L);
                        return;
                    }
                    this.f54497i.setText("任务已完成");
                    this.f54498j.setVisibility(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    return;
                }
                return;
            }
            str = adBaseInfo.productName;
        }
        textView.setText(str);
        this.f54495g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f54493e != null && c.this.f54493e.canGoBack()) {
                    c.this.f54493e.goBack();
                    com.kwad.sdk.core.report.a.l(c.this.f54490b);
                } else if (c.this.w != null) {
                    c.this.w.onCloseBtnClicked(view);
                }
            }
        });
        this.f54494f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f54493e != null && c.this.f54493e.canGoBack()) {
                    c.this.f54493e.goBack();
                    com.kwad.sdk.core.report.a.l(c.this.f54490b);
                } else if (c.this.w != null) {
                    c.this.w.onBackBtnClicked(view);
                }
            }
        });
        if (this.f54490b != null) {
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        this.y = aVar.a;
    }

    public View b() {
        return this.f54494f;
    }

    public View c() {
        return this.f54495g;
    }

    public boolean d() {
        return this.y == 1;
    }

    public void e() {
        if (this.A) {
            s sVar = this.x;
            if (sVar != null) {
                sVar.c();
            }
            View view = this.f54492d;
            if (view != null) {
                view.setVisibility(0);
            }
            s sVar2 = this.x;
            if (sVar2 != null) {
                sVar2.d();
            }
            if (com.kwad.sdk.core.response.a.d.v(this.f54490b)) {
                this.n = false;
            }
        }
    }

    public void f() {
        s sVar = this.x;
        if (sVar != null) {
            sVar.e();
        }
        View view = this.f54492d;
        if (view != null) {
            view.setVisibility(8);
        }
        s sVar2 = this.x;
        if (sVar2 != null) {
            sVar2.f();
        }
        if (com.kwad.sdk.core.response.a.d.v(this.f54490b)) {
            this.n = true;
        }
    }

    public void g() {
        KsAdWebView ksAdWebView = this.f54493e;
        if (ksAdWebView != null) {
            ksAdWebView.c();
            this.f54493e = null;
        }
        if (com.kwad.sdk.core.response.a.d.v(this.f54490b)) {
            this.m.removeCallbacksAndMessages(null);
        }
    }
}
