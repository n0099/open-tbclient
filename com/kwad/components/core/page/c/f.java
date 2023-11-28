package com.kwad.components.core.page.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.baidu.tieba.R;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class f extends c {
    public WebView NP;
    public int Ou = -1;
    public ViewGroup Ov;
    public final a Ow;
    public com.kwad.components.core.webview.a cN;
    public com.kwad.sdk.core.webview.b cO;
    public AdTemplate mAdTemplate;
    public final boolean mIsRewardLandPage;

    /* loaded from: classes10.dex */
    public interface a {
        void aw(int i);
    }

    public f(a aVar, boolean z) {
        this.Ow = aVar;
        this.mIsRewardLandPage = z;
    }

    private void an(String str) {
        az();
        this.NP.loadUrl(str);
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.e.c.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.Os.mAdTemplate);
        aVar.a(new ad(this.cO));
        aVar.a(new ag(this.cO));
        aVar.a(new az(this.cO, cVar));
        aVar.a(new ac(this.cO));
        aVar.a(new aw());
        aVar.a(new aq(ph(), com.kwad.sdk.core.response.b.b.cv(this.mAdTemplate)));
        aVar.a(new ak(this.cO));
        aVar.b(new m(this.cO));
        aVar.b(new l(this.cO));
        aVar.a(new ao(getOpenNewPageListener()));
        aVar.a(new aa(this.cO, cVar, null, (byte) 0));
        aVar.a(new x(this.cO, cVar, null, 2, this.mIsRewardLandPage));
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
        bVar2.Ov = this.Ov;
        bVar2.NP = this.NP;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void az() {
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.NP);
        this.cN = aVar;
        a(aVar);
        this.NP.addJavascriptInterface(this.cN, "KwaiAd");
    }

    private ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.core.page.c.f.2
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(f.this.NP.getContext(), new AdWebViewActivityProxy.a.C0655a().al(bVar.title).am(bVar.url).aB(true).as(f.this.mAdTemplate).pa());
            }
        };
    }

    private aq.b ph() {
        return new aq.b() { // from class: com.kwad.components.core.page.c.f.1
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                f.this.Ou = aVar.status;
                if (f.this.Ow != null) {
                    f.this.Ow.aw(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.Ov.setVisibility(0);
                } else {
                    f.this.NP.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.Os.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String cv = com.kwad.sdk.core.response.b.b.cv(adTemplate);
        if (!TextUtils.isEmpty(cv)) {
            ax();
            an(cv);
            return;
        }
        a aVar = this.Ow;
        if (aVar != null) {
            aVar.aw(this.Ou);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.NP = (WebView) findViewById(R.id.obfuscated_res_0x7f0913ac);
        this.Ov = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091514);
        this.NP.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        aA();
    }
}
