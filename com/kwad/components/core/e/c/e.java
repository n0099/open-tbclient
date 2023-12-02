package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
/* loaded from: classes10.dex */
public final class e extends c implements View.OnClickListener {
    @Nullable
    public b Kd;
    public b.C0643b Ke;
    public Runnable Km;
    public KsAdWebView cL;
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public aw cQ;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean Kn = false;
    public com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.e.c.e.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.Kn);
            e.a(e.this, true);
        }
    };
    public aj.b cS = new aj.b() { // from class: com.kwad.components.core.e.c.e.4
        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.cL.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    public ai.b cT = new ai.b() { // from class: com.kwad.components.core.e.c.e.5
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aF();
        }
    };
    public aq.b cU = new aq.b() { // from class: com.kwad.components.core.e.c.e.6
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
            com.kwad.sdk.core.e.c.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.np();
                return;
            }
            e.this.aF();
            if (e.this.getContext() != null) {
                v.O(e.this.getContext(), w.bY(e.this.getContext()));
            }
        }
    };

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
        bVar.setAdTemplate(this.Kf.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        AdBaseFrameLayout adBaseFrameLayout = this.Kf.mRootContainer;
        bVar2.aCG = adBaseFrameLayout;
        bVar2.Ov = adBaseFrameLayout;
        bVar2.NP = this.cL;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private void nn() {
        az();
        this.cL.loadUrl(this.Ke.url);
        this.cL.postDelayed(no(), 1500L);
        this.cL.setBackgroundColor(0);
        this.cL.getBackground().setAlpha(0);
        this.cL.setVisibility(0);
    }

    private Runnable no() {
        if (this.Km == null) {
            this.Km = new Runnable() { // from class: com.kwad.components.core.e.c.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.aF();
                    if (e.this.getContext() != null) {
                        v.O(e.this.getContext(), w.bY(e.this.getContext()));
                    }
                }
            };
        }
        return this.Km;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np() {
        Runnable runnable = this.Km;
        if (runnable != null) {
            this.cL.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.cL.setVisibility(8);
        this.cL.release();
        aA();
    }

    @Override // com.kwad.components.core.e.c.c, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        d dVar = this.Kf;
        this.Kd = dVar.Kd;
        this.Ke = dVar.Ke;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.Kf.mApkDownloadHelper;
        ax();
        nn();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cL = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09135a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        np();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new aa(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR, 1));
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aj(this.cO, this.cS));
        aVar.a(new aq(this.cU, this.Ke.url));
        aw awVar = new aw();
        this.cQ = awVar;
        aVar.a(awVar);
        aVar.a(new az(this.cO, this.mApkDownloadHelper, new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.core.e.c.e.3
            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                super.onInstalled();
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(e.this.mAdTemplate);
                String ay = com.kwad.sdk.core.response.b.a.ay(dP);
                if (com.kwad.sdk.core.response.b.a.aO(dP) && com.kwad.sdk.core.response.b.a.aF(dP) && ak.an(e.this.getContext(), ay) && com.kwad.components.core.q.a.qu().qy() && com.kwad.sdk.core.response.b.a.aN(dP) == 1) {
                    e.this.Kd.dismiss();
                }
            }
        }));
        aVar.a(new ai(this.cT));
        aVar.a(new com.kwad.components.core.webview.jshandler.ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.sdk.core.report.a.bR(this.mAdTemplate);
        b bVar = this.Kd;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.Kn = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF() {
        com.kwad.sdk.core.e.c.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.Kn);
        if (this.cL.getVisibility() != 0) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.si();
        }
        this.cL.setVisibility(4);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sj();
        }
        if (this.Kn) {
            com.kwad.sdk.core.report.a.bR(this.mAdTemplate);
        }
        b bVar = this.Kd;
        if (bVar != null && bVar.isShowing()) {
            this.Kd.aj(this.Kn);
        }
    }
}
