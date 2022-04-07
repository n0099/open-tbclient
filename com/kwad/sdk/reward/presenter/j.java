package com.kwad.sdk.reward.presenter;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reflux.KsRefluxView;
import com.kwad.sdk.reflux.a;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class j extends com.kwad.sdk.reward.g implements KsRefluxView.a, a.InterfaceC0327a {
    public List<AdTemplate> b;
    public KsRefluxView d;
    public KsAdWebView e;
    public com.kwad.sdk.core.webview.kwai.g f;
    public com.kwad.sdk.core.webview.a g;
    public s i;
    public List<com.kwad.sdk.core.download.a.b> c = new ArrayList();
    public int h = -1;
    public p.b j = new p.b() { // from class: com.kwad.sdk.reward.presenter.j.2
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            j.this.h = aVar.a;
            if (j.this.h == 1) {
                j.this.d.a(true);
            }
        }
    };
    public KsAdWebView.d k = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.j.3
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i, String str, String str2) {
            j.this.t();
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void b() {
        }
    };

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        s sVar = new s();
        this.i = sVar;
        gVar.a(sVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.g, this.c, (b.c) null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.g));
        gVar.a(new p(this.j));
        gVar.a(new m(this.b, this.c));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.g));
        gVar.a(new o(new o.a() { // from class: com.kwad.sdk.reward.presenter.j.1
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(com.kwad.sdk.core.webview.kwai.i iVar) {
                if (iVar.a() <= 0 || j.this.b == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = j.this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdTemplate adTemplate2 = (AdTemplate) it.next();
                    if (com.kwad.sdk.core.response.a.d.y(adTemplate2) == iVar.a()) {
                        adTemplate = adTemplate2;
                        break;
                    }
                }
                if (adTemplate != null) {
                    AdWebViewActivityProxy.launch(j.this.q(), new AdWebViewActivityProxy.a.C0303a().a(iVar.b).b(iVar.a).a(adTemplate).a());
                }
            }
        }));
    }

    private void s() {
        SceneImpl sceneImpl = ((com.kwad.sdk.reward.g) this).a.g.mAdScene;
        SceneImpl m105clone = sceneImpl != null ? sceneImpl.m105clone() : null;
        if (m105clone != null) {
            com.kwad.sdk.reflux.a.a(m105clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.d.getNativeView().a(com.kwad.sdk.reflux.b.a(this.b, this.c));
        this.d.a(false);
    }

    private void u() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.g = aVar;
        aVar.a(this.b);
        com.kwad.sdk.core.webview.a aVar2 = this.g;
        com.kwad.sdk.reward.a aVar3 = ((com.kwad.sdk.reward.g) this).a;
        aVar2.a = aVar3.f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.j;
        aVar2.b = adBaseFrameLayout;
        aVar2.d = adBaseFrameLayout;
        aVar2.e = this.e;
    }

    private void v() {
        this.h = -1;
        x();
        this.d.a(false);
        String w = w();
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "startPreloadWebView url : " + w);
        if (at.a(w)) {
            t();
        } else {
            this.e.loadUrl(w);
        }
    }

    @Nullable
    private String w() {
        return com.kwad.sdk.core.config.b.a(q());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void x() {
        y();
        be.a(this.e);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.e);
        this.f = gVar;
        a(gVar);
        this.e.addJavascriptInterface(this.f, "KwaiAd");
    }

    private void y() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f;
        if (gVar != null) {
            gVar.a();
            this.f = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        KsAdWebView ksAdWebView = this.e;
        if (ksAdWebView != null) {
            ksAdWebView.setHttpErrorListener(this.k);
        }
        s();
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC0327a
    public void a(int i, String str) {
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC0327a
    public void a(@Nullable List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.b = list;
        if (list.size() > 0) {
            this.c.clear();
            for (AdTemplate adTemplate : this.b) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
                com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar.a());
                this.c.add(bVar);
            }
            if (this.e == null) {
                t();
                return;
            }
            u();
            v();
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC0327a
    public void a_(int i) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsRefluxView ksRefluxView = (KsRefluxView) a(R.id.obfuscated_res_0x7f09111f);
        this.d = ksRefluxView;
        this.e = ksRefluxView.getWebView();
        this.d.setViewListener(this);
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void d() {
        ((com.kwad.sdk.reward.g) this).a.b.a(false);
        h();
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void e() {
        ((com.kwad.sdk.reward.g) this).a.k.c();
    }

    public int i() {
        List<AdTemplate> list;
        if (this.d.isShown()) {
            return 3;
        }
        if (!((com.kwad.sdk.reward.g) this).a.v || (list = this.b) == null || list.size() <= 0) {
            return 1;
        }
        s sVar = this.i;
        if (sVar != null) {
            sVar.c();
        }
        this.d.c();
        s sVar2 = this.i;
        if (sVar2 != null) {
            sVar2.d();
            return 2;
        }
        return 2;
    }

    public boolean r() {
        KsRefluxView ksRefluxView = this.d;
        return ksRefluxView != null && ksRefluxView.getVisibility() == 0;
    }
}
