package com.kwad.components.ad.reward.k;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes9.dex */
public class e extends com.kwad.sdk.core.download.kwai.a implements r.b, x.b {
    public KsAdWebView bF;
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    @Nullable
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener = new com.kwad.components.ad.reward.d.h() { // from class: com.kwad.components.ad.reward.k.e.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (e.this.uF != null) {
                e.this.uF.af(true);
            }
        }
    };
    public View uE;
    public ae uF;
    public f uG;

    public e(KsAdWebView ksAdWebView, View view2, @Nullable com.kwad.components.core.c.a.c cVar, com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this.uE = view2;
        this.bF = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.bJ = aVar;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.mApkDownloadHelper, this.bJ));
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext));
        aVar.a(new x(this, str));
        ae aeVar = new ae();
        this.uF = aeVar;
        aVar.a(aeVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.s(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.o(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(new com.kwad.components.core.webview.jshandler.r(this.mJsBridgeContext, this));
        aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.f.b(this.bF.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void ab(boolean z) {
        com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.bF;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z ? 0 : 8);
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        bVar2.agd = null;
        bVar2.Gl = viewGroup;
        bVar2.Fv = this.bF;
        bVar2.mReportExtData = null;
        bVar2.agf = true;
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.k.e.2
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
                e.this.hn();
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        View view2 = this.uE;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ab(false);
    }

    private void j(String str, int i) {
        f fVar = this.uG;
        if (fVar != null) {
            fVar.h(str, i);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v(String str) {
        if (ax.dT(str)) {
            hn();
            return;
        }
        clearJsInterfaceRegister();
        this.bF.setClientConfig(this.bF.getClientConfig().R(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
        this.mJsInterface = aVar;
        a(aVar, str);
        this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.bF.loadUrl(str);
    }

    public final void a(f fVar) {
        this.uG = fVar;
    }

    @Override // com.kwad.components.core.webview.jshandler.r.b
    public final void a(@NonNull r.a aVar) {
        com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        com.kwad.sdk.core.e.b.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ab(true);
        } else {
            hn();
        }
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.bF;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.bF.getBackground() != null) {
                this.bF.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        v(com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate));
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void iR() {
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        j(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        j(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aJ(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        j(adTemplate != null ? com.kwad.sdk.core.response.a.a.al(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        j(adTemplate != null ? com.kwad.sdk.core.response.a.a.P(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        j(com.kwad.sdk.core.response.a.a.aX(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            j(com.kwad.sdk.core.response.a.a.aW(i), i);
        }
    }
}
