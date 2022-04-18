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
/* loaded from: classes5.dex */
public class c implements p.b {
    public boolean B;
    public Context a;
    public AdTemplate b;
    public int c;
    public View d;
    public KsAdWebView e;
    public ImageView f;
    public ImageView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
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

    /* loaded from: classes5.dex */
    public interface a {
        void onBackBtnClicked(View view2);

        void onCloseBtnClicked(View view2);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final boolean a;
        public final boolean b;
        public final String c;
        public final String d;

        public b(C0304c c0304c) {
            this.a = c0304c.a;
            this.b = c0304c.b;
            this.c = c0304c.d;
            this.d = c0304c.c;
        }
    }

    /* renamed from: com.kwad.sdk.core.page.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0304c {
        public boolean a = true;
        public boolean b = true;
        public String c;
        public String d;

        public b a() {
            return new b(this);
        }

        public C0304c a(String str) {
            this.c = str;
            return this;
        }

        public C0304c a(boolean z) {
            this.a = z;
            return this;
        }

        public C0304c b(String str) {
            this.d = str;
            return this;
        }

        public C0304c b(boolean z) {
            this.b = z;
            return this;
        }
    }

    public c(Context context, AdTemplate adTemplate, int i, boolean z) {
        this.z = false;
        this.a = context;
        this.b = adTemplate;
        this.c = i;
        this.z = z;
        this.d = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0412, (ViewGroup) null);
    }

    private <T extends View> T a(int i) {
        View view2 = this.d;
        if (view2 == null) {
            return null;
        }
        return (T) view2.findViewById(i);
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
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.b);
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
                String a2 = com.kwad.sdk.core.response.a.a.a(c.this.a, com.kwad.sdk.core.response.a.d.j(c.this.b));
                if (at.a(a2)) {
                    return;
                }
                com.kwad.sdk.core.download.kwai.b.a(c.this.a, c.this.b, a2);
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
        if (this.g != null) {
            this.g.setVisibility(bVar.b ? 0 : 8);
        }
        if (this.f != null) {
            this.f.setVisibility(bVar.a ? 0 : 8);
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
        aVar.w = this.c;
        ksAdWebView.setClientParams(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.j.setText(i());
        this.l.setText(j());
    }

    private String i() {
        StringBuilder sb;
        int i = this.v / 60;
        if (i >= 10) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append("0");
        }
        sb.append(i);
        sb.append("");
        return sb.toString();
    }

    private String j() {
        StringBuilder sb;
        int i = this.v % 60;
        if (i >= 10) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append("0");
        }
        sb.append(i);
        sb.append("");
        return sb.toString();
    }

    private void k() {
        LinearLayout linearLayout = (LinearLayout) a(R.id.obfuscated_res_0x7f09118b);
        this.o = linearLayout;
        if (this.B) {
            linearLayout.setVisibility(8);
            return;
        }
        this.p = (TextView) a(R.id.obfuscated_res_0x7f09118c);
        ImageView imageView = (ImageView) a(R.id.obfuscated_res_0x7f09118d);
        this.q = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.o.setVisibility(8);
            }
        });
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.b);
        boolean af = com.kwad.sdk.core.response.a.a.af(j);
        String ab = com.kwad.sdk.core.response.a.a.ab(j);
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
        aVar.a(this.b);
        com.kwad.sdk.core.webview.a aVar2 = this.u;
        aVar2.a = 0;
        aVar2.e = this.e;
        aVar2.d = this.r;
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
        int i = cVar.v;
        cVar.v = i - 1;
        return i;
    }

    public View a() {
        return this.d;
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
        this.B = (TextUtils.isEmpty(bVar.d) || TextUtils.isEmpty(bVar.c)) ? false : true;
        this.e = (KsAdWebView) a(R.id.obfuscated_res_0x7f091182);
        TextView textView = (TextView) a(R.id.obfuscated_res_0x7f0910a6);
        this.f = (ImageView) a(R.id.obfuscated_res_0x7f0910a7);
        a((WebView) this.e);
        c(this.e);
        this.e.setTemplateData(this.b);
        this.e.loadUrl(bVar.c);
        this.e.b();
        this.e.setOnWebViewScrollChangeListener(new KsAdWebView.c() { // from class: com.kwad.sdk.core.page.c.1
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.c
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (c.this.B && c.this.o.getVisibility() == 0) {
                    c.this.o.setVisibility(8);
                }
            }
        });
        this.e.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.core.page.c.2
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str2, String str3) {
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
        this.g = (ImageView) a(R.id.obfuscated_res_0x7f0910a8);
        this.r = (ViewGroup) a(R.id.obfuscated_res_0x7f0910ad);
        if (this.B) {
            str = bVar.d;
        } else {
            List<AdInfo> list = this.b.adInfoList;
            if (list == null || list.size() <= 0 || this.b.adInfoList.get(0) == null || (adBaseInfo = this.b.adInfoList.get(0).adBaseInfo) == null || TextUtils.isEmpty(adBaseInfo.productName)) {
                textView.setText("详情页面");
                this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c.this.e != null && c.this.e.canGoBack()) {
                            c.this.e.goBack();
                            com.kwad.sdk.core.report.a.l(c.this.b);
                        } else if (c.this.w != null) {
                            c.this.w.onCloseBtnClicked(view2);
                        }
                    }
                });
                this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c.this.e != null && c.this.e.canGoBack()) {
                            c.this.e.goBack();
                            com.kwad.sdk.core.report.a.l(c.this.b);
                        } else if (c.this.w != null) {
                            c.this.w.onBackBtnClicked(view2);
                        }
                    }
                });
                if (this.b != null) {
                    return;
                }
                k();
                if (com.kwad.sdk.core.response.a.a.d(com.kwad.sdk.core.response.a.d.j(this.b))) {
                    l();
                    a(this.e);
                } else if (this.c == 4) {
                    this.b.interactLandingPageShowing = true;
                    l();
                    b(this.e);
                }
                b(bVar);
                this.h = (LinearLayout) a(R.id.obfuscated_res_0x7f091106);
                this.i = (TextView) a(R.id.obfuscated_res_0x7f091103);
                this.j = (TextView) a(R.id.obfuscated_res_0x7f091104);
                this.k = (TextView) a(R.id.obfuscated_res_0x7f091102);
                this.l = (TextView) a(R.id.obfuscated_res_0x7f091105);
                if (com.kwad.sdk.core.response.a.d.v(this.b)) {
                    this.h.setVisibility(0);
                    if (!this.b.mRewardVerifyCalled) {
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
                                    c.this.i.setText("任务已完成");
                                    c.this.j.setVisibility(8);
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
                    this.i.setText("任务已完成");
                    this.j.setVisibility(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    return;
                }
                return;
            }
            str = adBaseInfo.productName;
        }
        textView.setText(str);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.e != null && c.this.e.canGoBack()) {
                    c.this.e.goBack();
                    com.kwad.sdk.core.report.a.l(c.this.b);
                } else if (c.this.w != null) {
                    c.this.w.onCloseBtnClicked(view2);
                }
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.e != null && c.this.e.canGoBack()) {
                    c.this.e.goBack();
                    com.kwad.sdk.core.report.a.l(c.this.b);
                } else if (c.this.w != null) {
                    c.this.w.onBackBtnClicked(view2);
                }
            }
        });
        if (this.b != null) {
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.p.b
    public void a(p.a aVar) {
        this.y = aVar.a;
    }

    public View b() {
        return this.f;
    }

    public View c() {
        return this.g;
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
            View view2 = this.d;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            s sVar2 = this.x;
            if (sVar2 != null) {
                sVar2.d();
            }
            if (com.kwad.sdk.core.response.a.d.v(this.b)) {
                this.n = false;
            }
        }
    }

    public void f() {
        s sVar = this.x;
        if (sVar != null) {
            sVar.e();
        }
        View view2 = this.d;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        s sVar2 = this.x;
        if (sVar2 != null) {
            sVar2.f();
        }
        if (com.kwad.sdk.core.response.a.d.v(this.b)) {
            this.n = true;
        }
    }

    public void g() {
        KsAdWebView ksAdWebView = this.e;
        if (ksAdWebView != null) {
            ksAdWebView.c();
            this.e = null;
        }
        if (com.kwad.sdk.core.response.a.d.v(this.b)) {
            this.m.removeCallbacksAndMessages(null);
        }
    }
}
