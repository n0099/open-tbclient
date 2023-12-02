package com.kwad.components.ad.splashscreen.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bn;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class p extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.h.c {
    public com.kwad.components.ad.splashscreen.f.b DU;
    public boolean DV;
    public long DX;
    public aw DY;
    public ViewGroup Ea;
    @Nullable
    public KsAdWebView cL;
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public com.kwad.sdk.core.g.d eg;
    public Vibrator eh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public long mStartTime;
    public boolean DW = false;
    public boolean DZ = false;
    public final Runnable Eb = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.1
        @Override // java.lang.Runnable
        public final void run() {
            p.a(p.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, com.kwad.sdk.core.response.b.b.ch(p.this.mAdTemplate), SystemClock.elapsedRealtime() - p.this.DX, 1, "");
            p.this.lp();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i) {
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    private void ax() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.Df.mRootContainer;
        bVar2.aCG = adBaseFrameLayout;
        bVar2.Ov = adBaseFrameLayout;
        bVar2.NP = this.cL;
        bVar2.mReportExtData = null;
        bVar2.aCI = false;
        bVar2.aCJ = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        if (this.eg == null && !this.DW) {
            com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.cS(this.Df.mAdTemplate));
            this.eg = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.c.p.8
                @Override // com.kwad.sdk.core.g.b
                public final void aV() {
                }

                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    boolean nj = com.kwad.components.core.e.c.b.nj();
                    if (!p.this.Df.Cr.tp() || nj) {
                        return;
                    }
                    p.this.h(d);
                    if (p.this.eh == null) {
                        p pVar = p.this;
                        pVar.eh = pVar.D(pVar.getContext());
                    }
                    bn.a(p.this.getContext(), p.this.eh);
                    p.this.eg.bj(p.this.getContext());
                }
            });
            this.eg.bi(getContext());
        }
    }

    private x lr() {
        return new x(this.cO, this.Df.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.p.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (com.kwad.sdk.d.a.a.zz()) {
                    return;
                }
                if (!aVar.FS() && !com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    return;
                }
                y.b bVar = new y.b();
                bVar.Xd = aVar.Xo.Xd;
                p.this.a(false, aVar.Xn, bVar, aVar.kk);
            }
        });
    }

    private aa ls() {
        return new aa(this.cO, this.Df.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.p.3
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                int i;
                if (!aVar.Xl && com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                    return;
                }
                if (aVar.Xl) {
                    i = 1;
                } else {
                    i = 3;
                }
                p.this.a(false, i, null, aVar.kk);
            }
        }, (byte) 0);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bi(getContext());
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ky() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.f.b bVar = this.DU;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bj(getContext());
        }
        aw awVar = this.DY;
        if (awVar != null) {
            awVar.si();
            this.DY.sj();
        }
        this.Df.Cr.b(this);
        aA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator D(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z, boolean z2) {
        int i;
        com.kwad.sdk.core.e.c.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        if (z2) {
            i = 1;
        } else {
            i = 2;
        }
        a(!z, i, null, 132);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        aA();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.cN = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new az(this.cO, this.Df.mApkDownloadHelper));
        aVar.a(ls());
        aVar.a(lr());
        aVar.a(new ad(this.cO));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new aq(new aq.b() { // from class: com.kwad.components.ad.splashscreen.c.p.6
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                com.kwad.sdk.core.e.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bn.c(p.this.Eb);
                if (aVar2.status == 1) {
                    p.this.Df.CI = SystemClock.elapsedRealtime() - p.this.mStartTime;
                    if (!p.this.DZ) {
                        if (p.this.DY != null) {
                            p.this.DY.sg();
                            p.this.DY.sh();
                        }
                    } else {
                        p.this.Df.isWebTimeout = true;
                    }
                    if (com.kwad.sdk.core.response.b.b.dB(p.this.mAdInfo)) {
                        p.this.lo();
                        return;
                    }
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.DX, 3, "");
                p.this.lp();
            }
        }, str));
        aVar.a(new ay(new ay.a() { // from class: com.kwad.components.ad.splashscreen.c.p.7
            @Override // com.kwad.components.core.webview.jshandler.ay.a
            public final void bB() {
                p.this.bu();
            }
        }));
        aVar.a(new ak(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aw awVar = new aw();
        this.DY = awVar;
        aVar.a(awVar);
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        ax();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().eh(this.Df.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.c.p.5
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.DX);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                bn.c(p.this.Eb);
                p.this.lp();
                com.kwad.components.ad.splashscreen.monitor.c.a(p.this.mAdTemplate, str, SystemClock.elapsedRealtime() - p.this.DX, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            lp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, int i, @Nullable y.b bVar, int i2) {
        boolean z2;
        boolean z3;
        this.Df.kz();
        int i3 = 0;
        if (bVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z2) {
            JSONObject jSONObject = new JSONObject();
            try {
            } catch (JSONException e) {
                e = e;
                i3 = i2;
            }
            if (this.Df != null) {
                if (this.Df.Cp != null) {
                    jSONObject.put("duration", this.Df.Cp.getCurrentPosition());
                }
                if (z) {
                    i3 = 153;
                } else if (z3) {
                    i3 = 132;
                }
                try {
                    com.kwad.sdk.core.report.a.a(this.Df.mAdTemplate, new com.kwad.sdk.core.report.j().cA(i3), jSONObject);
                } catch (JSONException e2) {
                    e = e2;
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                    a.C0644a a = new a.C0644a(this.Df.mRootContainer.getContext()).aq(this.Df.mAdTemplate).b(this.Df.mApkDownloadHelper).ao(z3).an(i).a(bVar);
                    if (!z2) {
                    }
                    com.kwad.components.core.e.d.a.a(a.am(i2).al(1).aq(z2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.c.p.4
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                        }
                    }));
                }
                a.C0644a a2 = new a.C0644a(this.Df.mRootContainer.getContext()).aq(this.Df.mAdTemplate).b(this.Df.mApkDownloadHelper).ao(z3).an(i).a(bVar);
                if (!z2) {
                    i2 = i3;
                }
                com.kwad.components.core.e.d.a.a(a2.am(i2).al(1).aq(z2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.c.p.4
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        }
        i3 = i2;
        a.C0644a a22 = new a.C0644a(this.Df.mRootContainer.getContext()).aq(this.Df.mAdTemplate).b(this.Df.mApkDownloadHelper).ao(z3).an(i).a(bVar);
        if (!z2) {
        }
        com.kwad.components.core.e.d.a.a(a22.am(i2).al(1).aq(z2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.c.p.4
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
            }
        }));
    }

    public static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.DZ = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d) {
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar != null) {
            hVar.a(1, getContext(), Cea708Decoder.COMMAND_DF5, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.p.9
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.report.j jVar) {
                    jVar.l(d);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp() {
        this.DW = true;
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.Ea;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.b.b.du(this.mAdInfo)) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.10
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a((Presenter) new m(), true);
                }
            });
        } else if (com.kwad.sdk.core.response.b.b.dw(this.mAdInfo)) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.11
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a((Presenter) new l(), true);
                }
            });
        } else if (com.kwad.sdk.core.response.b.b.dz(this.mAdInfo)) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.p.12
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.a((Presenter) new n(), true);
                }
            });
        } else {
            lq();
        }
    }

    private void lq() {
        lo();
        boolean dE = com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.f.b bVar = new com.kwad.components.ad.splashscreen.f.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.obfuscated_res_0x7f0914b2), dE, this.Df.mApkDownloadHelper);
        this.DU = bVar;
        bVar.ah(this.mAdTemplate);
        this.DU.a(this);
        this.DU.lp();
    }

    @SuppressLint({"WrongConstant"})
    public final void lo() {
        if (this.DV) {
            return;
        }
        this.DV = true;
        y.a aVar = new y.a();
        aVar.axb = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.report.a.d(this.Df.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.j().cC(123).a(aVar));
        com.kwad.components.core.webview.tachikoma.d.a.sO().aR(123);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.Df.Cr.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914d2);
        this.Ea = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.cL = new KsAdWebView(getContext());
            this.cL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.Ea.addView(this.cL);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.Df.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.DV = false;
        this.DW = false;
        String ch = com.kwad.sdk.core.response.b.b.ch(this.mAdTemplate);
        if (this.cL != null && !TextUtils.isEmpty(ch) && !this.Df.Cw) {
            this.DX = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ag(this.mAdTemplate);
            a(this.cL, ch);
            bn.a(this.Eb, null, com.kwad.sdk.core.response.b.b.dD(this.mAdInfo));
        } else {
            lp();
        }
        this.Df.a(this);
    }
}
