package com.kwad.components.core.page.c;

import android.annotation.SuppressLint;
import com.baidu.tieba.R;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class b extends Presenter {
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public aq.b cU = new aq.b() { // from class: com.kwad.components.core.page.c.b.1
        @Override // com.kwad.components.core.webview.jshandler.aq.b
        public final void a(aq.a aVar) {
        }
    };
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;

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
        bVar2.NP = this.mAdWebView;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.cN = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.cN, "KwaiAd");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        aA();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new aq(this.cU, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate))));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) HU()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.obfuscated_res_0x7f091511);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().bv(true).eh(this.mAdTemplate));
        ax();
        az();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }
}
