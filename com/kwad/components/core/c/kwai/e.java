package com.kwad.components.core.c.kwai;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.u;
/* loaded from: classes8.dex */
public final class e extends c implements View.OnClickListener {
    @Nullable
    public b DG;
    public b.C0595b DH;
    public Runnable DP;
    public KsAdWebView bF;
    public aa bI;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public boolean DQ = false;
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.core.c.kwai.e.1
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "onAdClicked convertBridgeClicked: " + e.this.DQ);
            e.a(e.this, true);
        }
    };
    public r.b bK = new r.b() { // from class: com.kwad.components.core.c.kwai.e.3
        @Override // com.kwad.components.core.webview.jshandler.r.b
        public final void a(r.a aVar) {
            com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "onAdFrameValid=" + aVar);
            e.this.bF.setTranslationY((float) (aVar.height + aVar.bottomMargin));
        }
    };
    public q.b bL = new q.b() { // from class: com.kwad.components.core.c.kwai.e.4
        @Override // com.kwad.components.core.webview.jshandler.q.b
        public final void a(q.a aVar) {
            com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "handleWebCardHide");
            e.this.aK();
        }
    };
    public x.b bM = new x.b() { // from class: com.kwad.components.core.c.kwai.e.5
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
            com.kwad.sdk.core.e.b.i("DownloadTipsDialogWebCardPresenter", "updatePageStatus mPageState: " + aVar);
            if (aVar.status == 1) {
                e.this.mv();
                return;
            }
            e.this.aK();
            if (e.this.getContext() != null) {
                t.z(e.this.getContext(), u.ck(e.this.getContext()));
            }
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new i(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
        aVar.a(new f(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ, 1));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(new k(this.mJsBridgeContext));
        aVar.a(new r(this.mJsBridgeContext, this.bK));
        aVar.a(new x(this.bM, this.DH.url));
        aa aaVar = new aa();
        this.bI = aaVar;
        aVar.a(aaVar);
        aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new q(this.bL));
        aVar.a(new s(this.mJsBridgeContext));
    }

    public static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.DQ = true;
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "setupJsBridge");
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
        this.mJsInterface = aVar;
        a(aVar);
        this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK() {
        com.kwad.sdk.core.e.b.d("DownloadTipsDialogWebCardPresenter", "hideWithOutAnimation  convertBridgeClicked: " + this.DQ);
        if (this.bF.getVisibility() != 0) {
            return;
        }
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.pA();
        }
        this.bF.setVisibility(4);
        aa aaVar2 = this.bI;
        if (aaVar2 != null) {
            aaVar2.pB();
        }
        if (this.DQ) {
            com.kwad.sdk.core.report.a.aB(this.mAdTemplate);
        }
        b bVar = this.DG;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        this.DG.ai(this.DQ);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.DI.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        AdBaseFrameLayout adBaseFrameLayout = this.DI.mRootContainer;
        bVar2.agd = adBaseFrameLayout;
        bVar2.Gl = adBaseFrameLayout;
        bVar2.Fv = this.bF;
    }

    private void mt() {
        aF();
        this.bF.loadUrl(this.DH.url);
        this.bF.postDelayed(mu(), 1500L);
        this.bF.setBackgroundColor(0);
        this.bF.getBackground().setAlpha(0);
        this.bF.setVisibility(0);
    }

    private Runnable mu() {
        if (this.DP == null) {
            this.DP = new Runnable() { // from class: com.kwad.components.core.c.kwai.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.aK();
                    if (e.this.getContext() != null) {
                        t.z(e.this.getContext(), u.ck(e.this.getContext()));
                    }
                }
            };
        }
        return this.DP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        Runnable runnable = this.DP;
        if (runnable != null) {
            this.bF.removeCallbacks(runnable);
        }
    }

    private void release() {
        this.bF.setVisibility(8);
        this.bF.release();
        clearJsInterfaceRegister();
    }

    @Override // com.kwad.components.core.c.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        d dVar = this.DI;
        this.DG = dVar.DG;
        this.DH = dVar.DH;
        this.mAdTemplate = dVar.mAdTemplate;
        dVar.mRootContainer.setOnClickListener(this);
        this.mApkDownloadHelper = this.DI.mApkDownloadHelper;
        inflateJsBridgeContext();
        mt();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        com.kwad.sdk.core.report.a.aB(this.mAdTemplate);
        b bVar = this.DG;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091210);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        mv();
    }
}
