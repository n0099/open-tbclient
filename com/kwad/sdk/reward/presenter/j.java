package com.kwad.sdk.reward.presenter;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
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
/* loaded from: classes4.dex */
public class j extends com.kwad.sdk.reward.g implements KsRefluxView.a, a.InterfaceC2147a {

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f57707b;

    /* renamed from: d  reason: collision with root package name */
    public KsRefluxView f57709d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f57710e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f57711f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57712g;

    /* renamed from: i  reason: collision with root package name */
    public s f57714i;

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f57708c = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f57713h = -1;

    /* renamed from: j  reason: collision with root package name */
    public p.b f57715j = new p.b() { // from class: com.kwad.sdk.reward.presenter.j.2
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            j.this.f57713h = aVar.a;
            if (j.this.f57713h == 1) {
                j.this.f57709d.a(true);
            }
        }
    };
    public KsAdWebView.d k = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.j.3
        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a() {
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void a(int i2, String str, String str2) {
            j.this.t();
        }

        @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
        public void b() {
        }
    };

    private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
        s sVar = new s();
        this.f57714i = sVar;
        gVar.a(sVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57712g, this.f57708c, (b.c) null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f57712g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57712g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57712g));
        gVar.a(new p(this.f57715j));
        gVar.a(new m(this.f57707b, this.f57708c));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f57712g));
        gVar.a(new o(new o.a() { // from class: com.kwad.sdk.reward.presenter.j.1
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(com.kwad.sdk.core.webview.kwai.i iVar) {
                if (iVar.a() <= 0 || j.this.f57707b == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = j.this.f57707b.iterator();
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
                    AdWebViewActivityProxy.launch(j.this.q(), new AdWebViewActivityProxy.a.C2123a().a(iVar.f56695b).b(iVar.a).a(adTemplate).a());
                }
            }
        }));
    }

    private void s() {
        SceneImpl sceneImpl = ((com.kwad.sdk.reward.g) this).a.f57419g.mAdScene;
        SceneImpl m121clone = sceneImpl != null ? sceneImpl.m121clone() : null;
        if (m121clone != null) {
            com.kwad.sdk.reflux.a.a(m121clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f57709d.getNativeView().a(com.kwad.sdk.reflux.b.a(this.f57707b, this.f57708c));
        this.f57709d.a(false);
    }

    private void u() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f57712g = aVar;
        aVar.a(this.f57707b);
        com.kwad.sdk.core.webview.a aVar2 = this.f57712g;
        com.kwad.sdk.reward.a aVar3 = ((com.kwad.sdk.reward.g) this).a;
        aVar2.a = aVar3.f57418f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f57422j;
        aVar2.f56539b = adBaseFrameLayout;
        aVar2.f56541d = adBaseFrameLayout;
        aVar2.f56542e = this.f57710e;
    }

    private void v() {
        this.f57713h = -1;
        x();
        this.f57709d.a(false);
        String w = w();
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "startPreloadWebView url : " + w);
        if (at.a(w)) {
            t();
        } else {
            this.f57710e.loadUrl(w);
        }
    }

    @Nullable
    private String w() {
        return com.kwad.sdk.core.config.b.a(q());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void x() {
        y();
        be.a(this.f57710e);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57710e);
        this.f57711f = gVar;
        a(gVar);
        this.f57710e.addJavascriptInterface(this.f57711f, "KwaiAd");
    }

    private void y() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f57711f;
        if (gVar != null) {
            gVar.a();
            this.f57711f = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        KsAdWebView ksAdWebView = this.f57710e;
        if (ksAdWebView != null) {
            ksAdWebView.setHttpErrorListener(this.k);
        }
        s();
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2147a
    public void a(int i2, String str) {
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2147a
    public void a(@Nullable List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.f57707b = list;
        if (list.size() > 0) {
            this.f57708c.clear();
            for (AdTemplate adTemplate : this.f57707b) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
                com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar.a());
                this.f57708c.add(bVar);
            }
            if (this.f57710e == null) {
                t();
                return;
            }
            u();
            v();
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2147a
    public void a_(int i2) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        KsRefluxView ksRefluxView = (KsRefluxView) a(R.id.ksad_reward_reflux);
        this.f57709d = ksRefluxView;
        this.f57710e = ksRefluxView.getWebView();
        this.f57709d.setViewListener(this);
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void d() {
        ((com.kwad.sdk.reward.g) this).a.f57414b.a(false);
        h();
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void e() {
        ((com.kwad.sdk.reward.g) this).a.k.c();
    }

    public int i() {
        List<AdTemplate> list;
        if (this.f57709d.isShown()) {
            return 3;
        }
        if (!((com.kwad.sdk.reward.g) this).a.v || (list = this.f57707b) == null || list.size() <= 0) {
            return 1;
        }
        s sVar = this.f57714i;
        if (sVar != null) {
            sVar.c();
        }
        this.f57709d.c();
        s sVar2 = this.f57714i;
        if (sVar2 != null) {
            sVar2.d();
            return 2;
        }
        return 2;
    }

    public boolean r() {
        KsRefluxView ksRefluxView = this.f57709d;
        return ksRefluxView != null && ksRefluxView.getVisibility() == 0;
    }
}
