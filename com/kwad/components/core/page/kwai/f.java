package com.kwad.components.core.page.kwai;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tieba.R;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class f extends c {
    public WebView Fv;
    public int Gk = -1;
    public ViewGroup Gl;
    public final a Gm;
    public AdTemplate mAdTemplate;
    public final boolean mIsRewardLandPage;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;

    /* loaded from: classes8.dex */
    public interface a {
        void aj(int i);
    }

    public f(a aVar, boolean z) {
        this.Gm = aVar;
        this.mIsRewardLandPage = z;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.e.b.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.Gi.mAdTemplate);
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(new ac(this.mJsBridgeContext, cVar));
        aVar.a(new k(this.mJsBridgeContext));
        aVar.a(new aa());
        aVar.a(new x(nN(), com.kwad.sdk.core.response.a.b.aZ(this.mAdTemplate)));
        aVar.a(new s(this.mJsBridgeContext));
        aVar.a(new w(getOpenNewPageListener()));
        aVar.a(new i(this.mJsBridgeContext, cVar, null));
        aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, cVar, null, 2, this.mIsRewardLandPage));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Fv);
        this.mJsInterface = aVar;
        a(aVar);
        this.Fv.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void as(String str) {
        aF();
        this.Fv.loadUrl(str);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private w.a getOpenNewPageListener() {
        return new w.a() { // from class: com.kwad.components.core.page.kwai.f.2
            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(f.this.Fv.getContext(), new AdWebViewActivityProxy.a.C0600a().ao(bVar.title).ap(bVar.url).N(f.this.mAdTemplate).nx());
            }
        };
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.Gl = this.Gl;
        bVar2.Fv = this.Fv;
    }

    private x.b nN() {
        return new x.b() { // from class: com.kwad.components.core.page.kwai.f.1
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                f.this.Gk = aVar.status;
                if (f.this.Gm != null) {
                    f.this.Gm.aj(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.Gl.setVisibility(0);
                } else {
                    f.this.Fv.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.kwai.c, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.Gi.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String aZ = com.kwad.sdk.core.response.a.b.aZ(adTemplate);
        if (!TextUtils.isEmpty(aZ)) {
            inflateJsBridgeContext();
            as(aZ);
            return;
        }
        a aVar = this.Gm;
        if (aVar != null) {
            aVar.aj(this.Gk);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Fv = (WebView) findViewById(R.id.obfuscated_res_0x7f09125a);
        this.Gl = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0913a7);
        this.Fv.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        clearJsInterfaceRegister();
    }
}
