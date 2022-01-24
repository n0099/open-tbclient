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
/* loaded from: classes3.dex */
public class j extends com.kwad.sdk.reward.g implements KsRefluxView.a, a.InterfaceC2137a {

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f57540b;

    /* renamed from: d  reason: collision with root package name */
    public KsRefluxView f57542d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f57543e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f57544f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f57545g;

    /* renamed from: i  reason: collision with root package name */
    public s f57547i;

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f57541c = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f57546h = -1;

    /* renamed from: j  reason: collision with root package name */
    public p.b f57548j = new p.b() { // from class: com.kwad.sdk.reward.presenter.j.2
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            j.this.f57546h = aVar.a;
            if (j.this.f57546h == 1) {
                j.this.f57542d.a(true);
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
        this.f57547i = sVar;
        gVar.a(sVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57545g, this.f57541c, (b.c) null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f57545g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57545g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57545g));
        gVar.a(new p(this.f57548j));
        gVar.a(new m(this.f57540b, this.f57541c));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f57545g));
        gVar.a(new o(new o.a() { // from class: com.kwad.sdk.reward.presenter.j.1
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(com.kwad.sdk.core.webview.kwai.i iVar) {
                if (iVar.a() <= 0 || j.this.f57540b == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = j.this.f57540b.iterator();
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
                    AdWebViewActivityProxy.launch(j.this.q(), new AdWebViewActivityProxy.a.C2113a().a(iVar.f56528b).b(iVar.a).a(adTemplate).a());
                }
            }
        }));
    }

    private void s() {
        SceneImpl sceneImpl = ((com.kwad.sdk.reward.g) this).a.f57252g.mAdScene;
        SceneImpl m122clone = sceneImpl != null ? sceneImpl.m122clone() : null;
        if (m122clone != null) {
            com.kwad.sdk.reflux.a.a(m122clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f57542d.getNativeView().a(com.kwad.sdk.reflux.b.a(this.f57540b, this.f57541c));
        this.f57542d.a(false);
    }

    private void u() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f57545g = aVar;
        aVar.a(this.f57540b);
        com.kwad.sdk.core.webview.a aVar2 = this.f57545g;
        com.kwad.sdk.reward.a aVar3 = ((com.kwad.sdk.reward.g) this).a;
        aVar2.a = aVar3.f57251f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f57255j;
        aVar2.f56372b = adBaseFrameLayout;
        aVar2.f56374d = adBaseFrameLayout;
        aVar2.f56375e = this.f57543e;
    }

    private void v() {
        this.f57546h = -1;
        x();
        this.f57542d.a(false);
        String w = w();
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "startPreloadWebView url : " + w);
        if (at.a(w)) {
            t();
        } else {
            this.f57543e.loadUrl(w);
        }
    }

    @Nullable
    private String w() {
        return com.kwad.sdk.core.config.b.a(q());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void x() {
        y();
        be.a(this.f57543e);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57543e);
        this.f57544f = gVar;
        a(gVar);
        this.f57543e.addJavascriptInterface(this.f57544f, "KwaiAd");
    }

    private void y() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f57544f;
        if (gVar != null) {
            gVar.a();
            this.f57544f = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        KsAdWebView ksAdWebView = this.f57543e;
        if (ksAdWebView != null) {
            ksAdWebView.setHttpErrorListener(this.k);
        }
        s();
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2137a
    public void a(int i2, String str) {
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2137a
    public void a(@Nullable List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.f57540b = list;
        if (list.size() > 0) {
            this.f57541c.clear();
            for (AdTemplate adTemplate : this.f57540b) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
                com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar.a());
                this.f57541c.add(bVar);
            }
            if (this.f57543e == null) {
                t();
                return;
            }
            u();
            v();
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2137a
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
        this.f57542d = ksRefluxView;
        this.f57543e = ksRefluxView.getWebView();
        this.f57542d.setViewListener(this);
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void d() {
        ((com.kwad.sdk.reward.g) this).a.f57247b.a(false);
        h();
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void e() {
        ((com.kwad.sdk.reward.g) this).a.k.c();
    }

    public int i() {
        List<AdTemplate> list;
        if (this.f57542d.isShown()) {
            return 3;
        }
        if (!((com.kwad.sdk.reward.g) this).a.v || (list = this.f57540b) == null || list.size() <= 0) {
            return 1;
        }
        s sVar = this.f57547i;
        if (sVar != null) {
            sVar.c();
        }
        this.f57542d.c();
        s sVar2 = this.f57547i;
        if (sVar2 != null) {
            sVar2.d();
            return 2;
        }
        return 2;
    }

    public boolean r() {
        KsRefluxView ksRefluxView = this.f57542d;
        return ksRefluxView != null && ksRefluxView.getVisibility() == 0;
    }
}
