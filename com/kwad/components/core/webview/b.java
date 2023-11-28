package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.components.core.webview.tachikoma.a.j;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.b.g;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.d;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public KsAdWebView Hw;
    public KsAdWebView.c OA;
    public ViewGroup Vl;
    public com.kwad.components.core.webview.a.a Vm;
    public au Vn;
    public d Vo;
    public boolean Vp;
    public aq.b Vq = new aq.b() { // from class: com.kwad.components.core.webview.b.13
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            if (b.this.fY != null) {
                b.this.fY.a(aVar);
            }
        }
    };
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public c fY;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public String mPageUrl;

    /* loaded from: classes10.dex */
    public static class a {
        public KsAdWebView Hw;
        public KsAdWebView.c OA;
        public ViewGroup Vl;
        public boolean Vp;
        public c fY;
        public AdTemplate mAdTemplate;
        public com.kwad.components.core.e.d.c mApkDownloadHelper;
        public String mPageUrl;
        public JSONObject mReportExtData;

        public final com.kwad.components.core.e.d.c gX() {
            return this.mApkDownloadHelper;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final String oV() {
            return this.mPageUrl;
        }

        public final KsAdWebView.c pq() {
            return this.OA;
        }

        public final ViewGroup rW() {
            return this.Vl;
        }

        public final KsAdWebView rX() {
            return this.Hw;
        }

        public final c rY() {
            return this.fY;
        }

        public final boolean rZ() {
            return this.Vp;
        }

        @Nullable
        public final a a(c cVar) {
            this.fY = cVar;
            return this;
        }

        public final a aR(boolean z) {
            this.Vp = z;
            return this;
        }

        @NonNull
        public final a ay(String str) {
            this.mPageUrl = str;
            return this;
        }

        @Nullable
        public final a az(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.OA = cVar;
            return this;
        }

        @NonNull
        public final a d(KsAdWebView ksAdWebView) {
            this.Hw = ksAdWebView;
            return this;
        }

        public final a e(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }

        public final a f(com.kwad.components.core.e.d.c cVar) {
            this.mApkDownloadHelper = cVar;
            return this;
        }

        @NonNull
        public final a k(ViewGroup viewGroup) {
            this.Vl = viewGroup;
            return this;
        }
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
        com.kwad.components.core.webview.a.a aVar2 = this.Vm;
        if (aVar2 != null) {
            aVar2.destroy();
            this.Vm = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.NP = this.Hw;
        bVar2.Ov = this.Vl;
    }

    private void er() {
        this.Hw.setClientConfig(this.Hw.getClientConfig().eh(this.mAdTemplate).b(rS()).b(rT()).a(rR()).c(this.OA));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (b.this.fY != null) {
                    b.this.fY.a(aVar);
                }
            }
        };
    }

    private boolean rO() {
        c cVar = this.fY;
        if (cVar == null) {
            return false;
        }
        return cVar.pw();
    }

    private boolean rP() {
        if (this.fY == null) {
        }
        return false;
    }

    private ak.a rQ() {
        return new ak.a() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.components.core.webview.jshandler.ak.a
            public final void onAdShow() {
                if (b.this.fY != null) {
                    b.this.fY.onAdShow();
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.b rR() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.Vn != null) {
                    b.this.Vn.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.Vn != null) {
                    b.this.Vn.onSuccess();
                }
            }
        };
    }

    private y.b rS() {
        y.b bVar = new y.b();
        bVar.axA = 0;
        bVar.Od = rU();
        return bVar;
    }

    private KsAdWebView.d rT() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.webview.b.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (b.this.fY != null) {
                    b.this.fY.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (b.this.fY != null) {
                    b.this.fY.g(i, str);
                }
            }
        };
    }

    private int rU() {
        if (com.kwad.sdk.core.response.b.a.T(e.dP(this.mAdTemplate))) {
            return 5;
        }
        return 1;
    }

    public final void jn() {
        aA();
        if (this.Vo != null) {
            com.kwad.sdk.core.download.b.BU().a(this.Vo);
        }
    }

    public static void a(c cVar, WebView webView) {
        if (cVar != null && cVar.pv()) {
            webView.getSettings().setAllowFileAccess(true);
        }
    }

    private void a(aw awVar) {
        c cVar = this.fY;
        if (cVar == null) {
            return;
        }
        cVar.a(awVar);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.cN = aVar;
        b(aVar, this.cO);
        c cVar = this.fY;
        if (cVar != null) {
            cVar.a(this.cN, this.cO);
        }
        ksAdWebView.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void c(KsAdWebView ksAdWebView) {
        aA();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.cO);
        this.Vm = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        aw awVar = new aw();
        aVar.a(awVar);
        a(awVar);
        aVar.a(new t());
        aVar.a(new com.kwad.components.core.webview.jshandler.b());
        aVar.a(new u());
        aVar.a(new o());
        aVar.a(new p());
        ak akVar = new ak(bVar);
        aVar.b(new m(bVar));
        aVar.b(new l(bVar));
        akVar.a(rQ());
        aVar.a(akVar);
        aVar.a(new ad(bVar));
        aVar.a(new f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        if (!this.Vp) {
            aVar.a(new aa(this.cO, this.mApkDownloadHelper, getClickListener(), rO(), false, true));
            aVar.a(new x(this.cO, this.mApkDownloadHelper, getClickListener(), rO(), 0, rP(), true));
        }
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new as(this.cO));
        aVar.a(new ap(this.cO.NP.getContext(), this.mAdTemplate));
        aVar.a(new bd(new bd.a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.bd.a
            public final void rV() {
                if (com.kwad.sdk.core.response.b.b.cW(b.this.mAdTemplate)) {
                    com.kwad.components.core.e.c.b.a(b.this.cO.NP.getContext(), new b.a().ap(b.this.mAdTemplate).ae(com.kwad.sdk.core.response.b.b.cV(b.this.mAdTemplate)).nm());
                }
            }
        }));
        aVar.a(new ah(this.cO));
        aVar.a(new aq(this.Vq, this.mPageUrl));
        au auVar = new au();
        this.Vn = auVar;
        aVar.a(auVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.y(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.b.6
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                if (b.this.fY != null) {
                    b.this.fY.a(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.7
            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar2) {
                if (!TextUtils.isEmpty(sVar2.message)) {
                    v.d(b.this.cO.NP.getContext(), sVar2.message, 0L);
                }
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new ag(bVar));
        if (com.kwad.sdk.core.response.b.a.aF(e.dP(this.mAdTemplate))) {
            final com.kwad.components.core.webview.tachikoma.a.l lVar = new com.kwad.components.core.webview.tachikoma.a.l();
            aVar.a(lVar);
            this.Vo = new d(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar2 = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar2.ZQ = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.b.BU().a(this.Vo, this.mAdTemplate);
        }
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(g gVar) {
                com.kwad.components.core.o.a.pX().a(gVar.actionType, b.this.mAdTemplate, gVar.Xd);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(b.this.cO.NP.getContext(), new AdWebViewActivityProxy.a.C0655a().al(nVar.title).am(nVar.url).aB(true).as(b.this.mAdTemplate).pa());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.d());
        aVar.a(new com.kwad.components.core.webview.jshandler.g());
        aVar.a(new com.kwad.components.core.webview.jshandler.j());
        aVar.a(new com.kwad.components.core.webview.jshandler.c());
        ac acVar = new ac(this.cO);
        acVar.a(new ac.b() { // from class: com.kwad.components.core.webview.b.11
            @Override // com.kwad.components.core.webview.jshandler.ac.b
            public final void c(ac.a aVar2) {
                if (b.this.fY != null) {
                    b.this.fY.a(aVar2);
                }
            }
        });
        aVar.a(acVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.k(this.cO.NP.getContext(), this.mAdTemplate));
        aVar.a(new aj(this.cO, new aj.b() { // from class: com.kwad.components.core.webview.b.12
            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar2) {
                if (b.this.fY != null) {
                    b.this.fY.a(aVar2);
                }
            }
        }));
        aVar.a(new i());
        aVar.a(new com.kwad.components.core.webview.jshandler.s());
        aVar.a(new r());
        aVar.a(new q());
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.oV();
        this.mAdTemplate = aVar.getAdTemplate();
        this.Vl = aVar.rW();
        this.Hw = aVar.rX();
        this.fY = aVar.rY();
        this.mApkDownloadHelper = aVar.gX();
        this.Vp = aVar.rZ();
        this.OA = aVar.pq();
        er();
        a(this.fY, this.Hw);
        ax();
        if (com.kwad.sdk.core.response.b.a.P(e.dP(this.mAdTemplate))) {
            c(this.Hw);
        } else if (com.kwad.sdk.core.response.b.b.dT(this.mPageUrl)) {
            b(this.Hw);
        }
    }
}
