package com.kwad.sdk.d.kwai;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.a.j;
import com.kwad.sdk.core.webview.a.k;
import com.kwad.sdk.core.webview.a.n;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.aa;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.core.webview.jshandler.u;
import com.kwad.sdk.d.kwai.c;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends b {
    public static float c = 0.61f;
    public static float d = 0.8f;
    public static float e = 0.768f;
    public static float f = 1.0f;
    public static float g = 0.749f;
    public static float h = 0.637f;
    public k A;
    public s B;
    @Nullable
    public u C;
    public com.kwad.sdk.core.j.f E;
    @NonNull
    public Context a;
    public AdInfo b;
    public c i;
    public com.kwad.sdk.core.webview.kwai.g j;
    public com.kwad.sdk.core.webview.a k;
    public AdTemplate l;
    public boolean m;
    public KSFrameLayout n;
    public KSFrameLayout o;
    public Dialog q;
    public KsAdWebView r;
    @Nullable
    public com.kwad.sdk.core.download.a.b s;
    public List<Integer> u;
    public com.kwad.sdk.core.video.videoview.b v;
    public ImageView w;
    @NonNull
    public KsAdVideoPlayConfig x;
    public ImageView y;
    public a.b z;
    public Handler p = new Handler(Looper.getMainLooper());
    public int t = -1;
    public boolean D = false;
    public com.kwad.sdk.core.j.d F = new com.kwad.sdk.core.j.e() { // from class: com.kwad.sdk.d.kwai.d.1
        @Override // com.kwad.sdk.core.j.e, com.kwad.sdk.core.j.d
        public void e() {
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "onPageVisible");
            if (d.this.B != null) {
                d.this.B.c();
                d.this.B.d();
            }
        }

        @Override // com.kwad.sdk.core.j.e, com.kwad.sdk.core.j.d
        public void f() {
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "onPageInvisible");
            if (d.this.B != null) {
                d.this.B.e();
                d.this.B.f();
            }
        }
    };
    public final Runnable G = new Runnable() { // from class: com.kwad.sdk.d.kwai.d.12
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "rollBackRunnable run");
            d.this.r();
            d.this.i.b();
        }
    };
    public p.b H = new p.b() { // from class: com.kwad.sdk.d.kwai.d.11
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            if (d.this.m || d.this.D) {
                return;
            }
            d.this.t = aVar.a;
            if (d.this.t != 1) {
                d.this.b("3");
                return;
            }
            d.this.r.setVisibility(0);
            com.kwad.sdk.core.report.d.a(d.this.l);
            d.this.p.removeCallbacksAndMessages(null);
            ax.b(d.this.G);
            if (d.this.C != null) {
                d.this.C.c();
            }
        }
    };

    @NonNull
    private WebCardVideoPositionHandler A() {
        return new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.sdk.d.kwai.d.4
            @Override // com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.a
            public void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + d.this.D);
                if (d.this.D || (adInfo = d.this.b) == null || !com.kwad.sdk.core.response.a.a.P(adInfo)) {
                    return;
                }
                c cVar = d.this.i;
                d dVar = d.this;
                boolean a = cVar.a(dVar.a, dVar.b);
                d dVar2 = d.this;
                dVar2.a(dVar2.b, videoPosition, dVar2.o, a);
                d.this.o.setVisibility(0);
                d.this.r.setVisibility(0);
            }
        });
    }

    private aa B() {
        aa aaVar = new aa(q(), this.l);
        aaVar.a(new aa.a() { // from class: com.kwad.sdk.d.kwai.d.5
            @Override // com.kwad.sdk.core.webview.jshandler.aa.a
            public boolean a() {
                if (d.this.A != null) {
                    d.this.A.a(false);
                }
                ax.a(new Runnable() { // from class: com.kwad.sdk.d.kwai.d.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.q != null) {
                            d.this.q.dismiss();
                            if (d.this.i.b != null) {
                                d.this.i.b.onAdClosed();
                            }
                        }
                    }
                });
                boolean z = !d.this.i.j;
                if (z) {
                    d.this.i.a(true, d.this.i.i);
                }
                return z;
            }
        });
        return aaVar;
    }

    @NonNull
    private i C() {
        return new i(new i.b() { // from class: com.kwad.sdk.d.kwai.d.6
            @Override // com.kwad.sdk.core.webview.jshandler.i.b
            public void a(final int i) {
                if (d.this.q != null) {
                    d.this.p.post(new Runnable() { // from class: com.kwad.sdk.d.kwai.d.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.q.dismiss();
                            d.this.i.a(i == 3, d.this.v);
                            if (d.this.i.b != null) {
                                d.this.i.b.onAdClosed();
                            }
                        }
                    });
                }
            }
        });
    }

    private k D() {
        k kVar = new k() { // from class: com.kwad.sdk.d.kwai.d.7
            @Override // com.kwad.sdk.core.webview.a.i, com.kwad.sdk.core.webview.kwai.a
            public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                if (d.this.v.d()) {
                    com.kwad.sdk.core.webview.a.kwai.f fVar = new com.kwad.sdk.core.webview.a.kwai.f();
                    fVar.b = false;
                    fVar.c = false;
                    fVar.a = 0;
                    cVar.a(fVar);
                }
                if (d.this.v.i()) {
                    com.kwad.sdk.core.webview.a.kwai.f fVar2 = new com.kwad.sdk.core.webview.a.kwai.f();
                    fVar2.b = false;
                    fVar2.c = true;
                    fVar2.a = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(d.this.k.a()));
                    cVar.a(fVar2);
                }
            }
        };
        this.A = kVar;
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.kwad.sdk.core.video.videoview.b bVar = this.i.i;
        if (bVar != null) {
            bVar.k();
        }
        this.i.c.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.i.b;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @NonNull
    private com.kwad.sdk.core.webview.jshandler.a F() {
        return new com.kwad.sdk.core.webview.jshandler.a(this.k, this.s, new b.c() { // from class: com.kwad.sdk.d.kwai.d.8
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (aVar != null) {
                    if (d.this.i.b != null) {
                        d.this.i.b.onAdClicked();
                    }
                    if (d.this.i.c == null || !com.kwad.sdk.core.config.b.aC()) {
                        return;
                    }
                    d.this.i.c.dismiss();
                }
            }
        });
    }

    @NonNull
    private com.kwad.sdk.core.webview.jshandler.b G() {
        return new com.kwad.sdk.core.webview.jshandler.b(this.k, this.s, new b.c() { // from class: com.kwad.sdk.d.kwai.d.9
            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(b.a aVar) {
                if (aVar != null) {
                    if (d.this.i.b != null) {
                        d.this.i.b.onAdClicked();
                    }
                    if (d.this.i.c == null || !com.kwad.sdk.core.config.b.aC()) {
                        return;
                    }
                    d.this.i.c.dismiss();
                }
            }
        });
    }

    public static float a(boolean z, boolean z2) {
        if (z && z2) {
            return 1.7777778f;
        }
        if (z) {
            return 0.749f;
        }
        return s();
    }

    public static ViewGroup.LayoutParams a(int i, boolean z) {
        boolean z2 = com.kwad.sdk.core.config.b.q() == 0;
        int i2 = (int) (i * (z ? z2 ? d : c : z2 ? f : e));
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? 1.7777778f : 0.749f)));
    }

    public static ViewGroup.MarginLayoutParams a(Context context, WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.topMargin = videoPosition.topMargin;
        marginLayoutParams.leftMargin = videoPosition.leftMargin;
        marginLayoutParams.width = videoPosition.width;
        marginLayoutParams.height = videoPosition.height;
        return marginLayoutParams;
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
        marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
        marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
        marginLayoutParams2.width = marginLayoutParams.width;
        marginLayoutParams2.height = marginLayoutParams.height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setWidthBasedRatio(!z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
        com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + StringUtil.ARRAY_ELEMENT_SEPARATOR + marginLayoutParams.height);
        a(this.a, videoPosition, marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
        float L = com.kwad.sdk.core.response.a.a.L(adInfo);
        com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + L);
        if (z && L > 0.0f) {
            int i = marginLayoutParams.width;
            int i2 = marginLayoutParams.height;
            int i3 = (int) (i2 / L);
            marginLayoutParams.width = i3;
            marginLayoutParams.leftMargin += (i - i3) / 2;
            if (i3 != 0) {
                float f2 = i2 / i3;
                com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "cardParams ratio: " + f2);
                kSFrameLayout.setRatio(f2);
            }
        }
        com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
        kSFrameLayout.setLayoutParams(marginLayoutParams);
        if (z) {
            this.w.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
            a(marginLayoutParams2, marginLayoutParams3);
            this.w.setLayoutParams(marginLayoutParams3);
            this.i.a(this.a, adInfo, this.l, this.w);
        } else {
            this.w.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            kSFrameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.kwad.sdk.d.kwai.d.10
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                }
            });
            kSFrameLayout.setClipToOutline(true);
        }
    }

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        gVar.a(G());
        gVar.a(F());
        gVar.a(new com.kwad.sdk.core.webview.a.g());
        gVar.a(y());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.k));
        gVar.a(x());
        gVar.a(w());
        gVar.a(C());
        s sVar = new s();
        this.B = sVar;
        gVar.a(sVar);
        this.i.a(z());
        gVar.a(D());
        gVar.a(A());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.k));
        gVar.a(u());
        gVar.a(new p(this.H));
        gVar.a(t());
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.k));
        gVar.a(B());
        if (v() != null) {
            gVar.a(this.C);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(String str) {
        i();
        be.b(this.r);
        this.r.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.d.kwai.d.14
            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void a(int i, String str2, String str3) {
                d.this.b("1");
            }

            @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
            public void b() {
            }
        });
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.r);
        this.j = gVar;
        a(gVar);
        this.r.addJavascriptInterface(this.j, "KwaiAd");
        this.r.loadUrl(str);
        ax.a(this.G, null, 3000L);
    }

    public static ViewGroup.LayoutParams b(int i) {
        boolean z = com.kwad.sdk.core.config.b.q() == 0;
        float f2 = z ? 0.749f : 0.8f;
        int i2 = (int) (i * (z ? g : h));
        return new ViewGroup.LayoutParams((int) (i2 / f2), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "handleWebViewError " + str);
        this.p.removeCallbacksAndMessages(null);
        if (this.m) {
            return;
        }
        this.m = true;
        AdTemplate adTemplate = this.l;
        com.kwad.sdk.core.report.d.c(adTemplate, com.kwad.sdk.core.response.a.b.n(adTemplate), str);
        this.p.post(new Runnable() { // from class: com.kwad.sdk.d.kwai.d.15
            @Override // java.lang.Runnable
            public void run() {
                d.this.r();
                d.this.i.b();
            }
        });
    }

    private void f() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.k = aVar;
        aVar.a(this.i.a);
        com.kwad.sdk.core.webview.a aVar2 = this.k;
        aVar2.a = 0;
        aVar2.b = null;
        aVar2.d = this.n;
        aVar2.e = this.r;
        aVar2.c = null;
    }

    private void i() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.j;
        if (gVar != null) {
            gVar.a();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        boolean K = com.kwad.sdk.core.response.a.a.K(this.b);
        boolean e2 = af.e(this.a);
        float a = a(e2, K);
        this.i.e.setRatio(a);
        com.kwad.sdk.core.d.a.a("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a);
        ViewGroup.LayoutParams a2 = e2 ? a(bb.b(this.a), K) : b(bb.a(this.a));
        this.r.setVisibility(8);
        this.o.setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) this.n.findViewById(R.id.obfuscated_res_0x7f091099);
        viewGroup.setVisibility(0);
        ViewParent parent = this.i.e.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.i.e);
        }
        viewGroup.addView(this.i.e);
        this.i.e.a(a2.width, a2.height);
        this.v.requestLayout();
        this.D = true;
    }

    public static float s() {
        return com.kwad.sdk.core.config.b.q() == 0 ? 0.749f : 0.8f;
    }

    private t t() {
        return new t(this.k, this.s);
    }

    private com.kwad.sdk.core.webview.jshandler.d u() {
        com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.k);
        dVar.a(new d.b() { // from class: com.kwad.sdk.d.kwai.d.16
            @Override // com.kwad.sdk.core.webview.jshandler.d.b
            public void a(d.a aVar) {
                aVar.b = bb.a(d.this.a);
                aVar.a = bb.a(d.this.a);
            }
        });
        return dVar;
    }

    private u v() {
        u a = u.a(q(), this.l);
        this.C = a;
        if (a != null) {
            a.a(new u.b() { // from class: com.kwad.sdk.d.kwai.d.17
                @Override // com.kwad.sdk.core.webview.jshandler.u.b
                public void a(int i) {
                    if (i == u.b) {
                        d.this.i.a(d.this.q(), d.this.l);
                        d.this.i.a(true, d.this.i.i);
                    }
                    d.this.E();
                }
            });
        }
        return this.C;
    }

    private n w() {
        n nVar = new n();
        nVar.a(new n.a() { // from class: com.kwad.sdk.d.kwai.d.18
            @Override // com.kwad.sdk.core.webview.a.n.a
            public void a(com.kwad.sdk.core.webview.a.kwai.b bVar) {
                d.this.v.setVideoSoundEnable(!bVar.a);
            }
        });
        return nVar;
    }

    @NonNull
    private j x() {
        return new j() { // from class: com.kwad.sdk.d.kwai.d.19
            @Override // com.kwad.sdk.core.webview.a.i, com.kwad.sdk.core.webview.kwai.a
            public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                com.kwad.sdk.core.webview.a.kwai.b bVar = new com.kwad.sdk.core.webview.a.kwai.b();
                bVar.a = !d.this.x.isVideoSoundEnable();
                cVar.a(bVar);
            }
        };
    }

    @NonNull
    private com.kwad.sdk.core.webview.jshandler.j y() {
        return new com.kwad.sdk.core.webview.jshandler.j(this.k, new j.b() { // from class: com.kwad.sdk.d.kwai.d.2
            @Override // com.kwad.sdk.core.webview.jshandler.j.b
            public void a(j.a aVar) {
            }
        });
    }

    private a.b z() {
        final com.kwad.sdk.core.webview.a.kwai.f fVar = new com.kwad.sdk.core.webview.a.kwai.f();
        a.b bVar = new a.b() { // from class: com.kwad.sdk.d.kwai.d.3
            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j) {
                com.kwad.sdk.core.webview.a.kwai.f fVar2 = fVar;
                fVar2.b = false;
                fVar2.c = false;
                fVar2.a = (int) Math.ceil(((float) j) / 1000.0f);
                d.this.A.a(fVar);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                com.kwad.sdk.core.webview.a.kwai.f fVar2 = fVar;
                fVar2.b = false;
                fVar2.c = false;
                fVar2.a = 0;
                d.this.A.a(fVar);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                if (d.this.y.getVisibility() == 0) {
                    d.this.y.setVisibility(8);
                }
                com.kwad.sdk.core.webview.a.kwai.f fVar2 = fVar;
                fVar2.b = false;
                fVar2.c = false;
                fVar2.a = (int) Math.ceil(((float) d.this.v.getCurrentPosition()) / 1000.0f);
                d.this.A.a(fVar);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                com.kwad.sdk.core.webview.a.kwai.f fVar2 = fVar;
                fVar2.b = false;
                fVar2.c = true;
                fVar.a = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(d.this.k.a()));
                d.this.A.a(fVar);
            }
        };
        this.z = bVar;
        return bVar;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        this.i = cVar;
        this.D = false;
        this.q = cVar.c;
        this.x = cVar.g;
        this.s = cVar.d;
        AdTemplate adTemplate = cVar.a;
        this.l = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.b = j;
        this.u = com.kwad.sdk.core.response.a.a.S(j);
        this.v = this.i.i;
        this.E.a(this.F);
        this.E.a();
        f();
        e();
        this.i.a(new c.b() { // from class: com.kwad.sdk.d.kwai.d.13
            @Override // com.kwad.sdk.d.kwai.c.b
            public void a() {
                if (d.this.t == 1) {
                    d.this.r.reload();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.p.removeCallbacksAndMessages(null);
        this.E.b(this.F);
        this.E.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsAdWebView ksAdWebView = (KsAdWebView) m().findViewById(R.id.obfuscated_res_0x7f091184);
        this.r = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.r.setVisibility(4);
        this.E = new com.kwad.sdk.core.j.f(this.r, 70);
        this.n = (KSFrameLayout) m().findViewById(R.id.obfuscated_res_0x7f091052);
        this.o = (KSFrameLayout) m().findViewById(R.id.obfuscated_res_0x7f091157);
        this.y = (ImageView) m().findViewById(R.id.obfuscated_res_0x7f091167);
        this.w = (ImageView) m().findViewById(R.id.obfuscated_res_0x7f09109f);
        this.a = q();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
    }

    public void e() {
        String n = com.kwad.sdk.core.response.a.b.n(this.l);
        if (TextUtils.isEmpty(n)) {
            b("1");
        } else {
            a(n);
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        super.g();
        u uVar = this.C;
        if (uVar != null) {
            uVar.e();
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        super.h();
        u uVar = this.C;
        if (uVar != null) {
            uVar.d();
        }
    }
}
