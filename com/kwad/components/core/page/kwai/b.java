package com.kwad.components.core.page.kwai;

import android.annotation.SuppressLint;
import com.baidu.tieba.R;
import com.kwad.components.core.page.recycle.NestedScrollWebView;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class b extends Presenter {
    public NestedScrollWebView Gg;
    public x.b bM = new x.b() { // from class: com.kwad.components.core.page.kwai.b.1
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
        }
    };
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))));
        aVar.a(new s(this.mJsBridgeContext));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Gg);
        this.mJsInterface = aVar;
        a(aVar);
        this.Gg.addJavascriptInterface(this.mJsInterface, "KwaiAd");
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
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        bVar2.Fv = this.Gg;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) xR()).adTemplate;
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) getRootView().findViewById(R.id.obfuscated_res_0x7f091458);
        this.Gg = nestedScrollWebView;
        this.Gg.setClientConfig(nestedScrollWebView.getClientConfig().R(this.mAdTemplate));
        this.Gg.setNestedScrollingEnabled(true);
        inflateJsBridgeContext();
        aF();
        this.Gg.loadUrl(com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)));
        this.Gg.pp();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        clearJsInterfaceRegister();
        NestedScrollWebView nestedScrollWebView = this.Gg;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.onActivityDestroy();
            this.Gg = null;
        }
    }
}
