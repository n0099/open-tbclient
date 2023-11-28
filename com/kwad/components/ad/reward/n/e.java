package com.kwad.components.ad.reward.n;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bg;
/* loaded from: classes10.dex */
public class e extends com.kwad.sdk.core.download.a.a implements aj.b, aq.b {
    public KsAdWebView cL;
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public com.kwad.sdk.core.webview.d.a.a cR;
    @Nullable
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (e.this.ys != null) {
                e.this.ys.ag(true);
            }
        }
    };
    public View yr;
    public bb ys;
    public f yt;

    public e(KsAdWebView ksAdWebView, View view2, @Nullable com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this.yr = view2;
        this.cL = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.cR = aVar;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void R(String str) {
        if (bg.isNullString(str)) {
            jR();
            return;
        }
        aA();
        this.cL.setClientConfig(this.cL.getClientConfig().eh(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cL);
        this.cN = aVar;
        a(aVar, str);
        this.cL.addJavascriptInterface(this.cN, "KwaiAd");
        this.cL.loadUrl(str);
    }

    private void ac(boolean z) {
        int i;
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        ksAdWebView.setVisibility(i);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        l(com.kwad.sdk.core.response.b.a.cR(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            l(com.kwad.sdk.core.response.b.a.cQ(i), i);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new x(this.cO, this.mApkDownloadHelper, this.cR));
        aVar.a(new ad(this.cO));
        aVar.a(new ac(this.cO));
        aVar.a(new aq(this, str));
        bb bbVar = new bb();
        this.ys = bbVar;
        aVar.a(bbVar);
        aVar.a(new ak(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.m(this.cO));
        aVar.b(new com.kwad.components.core.webview.jshandler.l(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new aj(this.cO, this));
        aVar.a(new az(this.cO, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.i.b(this.cL.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
                e.this.jR();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR() {
        View view2 = this.yr;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ac(false);
    }

    public final void jQ() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        } else {
            str = "立即下载";
        }
        l(str, 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        String bX;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            bX = "";
        } else {
            bX = com.kwad.sdk.core.response.b.a.bX(adTemplate);
        }
        l(bX, 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        } else {
            str = "立即下载";
        }
        l(str, 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        String str;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            str = com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        } else {
            str = "立即打开";
        }
        l(str, 100);
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cO = bVar;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cO;
        bVar2.mScreenOrientation = 0;
        bVar2.aCG = null;
        bVar2.Ov = viewGroup;
        bVar2.NP = this.cL;
        bVar2.mReportExtData = null;
        bVar2.aCI = true;
    }

    private void l(String str, int i) {
        f fVar = this.yt;
        if (fVar != null) {
            fVar.j(str, i);
        }
    }

    public final void a(f fVar) {
        this.yt = fVar;
    }

    @Override // com.kwad.components.core.webview.jshandler.aj.b
    public final void a(@NonNull aj.a aVar) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        com.kwad.sdk.core.e.c.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ac(true);
        } else {
            jR();
        }
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.cL.getBackground() != null) {
                this.cL.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        R(com.kwad.sdk.core.response.b.b.cj(this.mAdTemplate));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
