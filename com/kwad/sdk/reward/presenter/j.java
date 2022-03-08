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
/* loaded from: classes8.dex */
public class j extends com.kwad.sdk.reward.g implements KsRefluxView.a, a.InterfaceC2126a {

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f56057b;

    /* renamed from: d  reason: collision with root package name */
    public KsRefluxView f56059d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f56060e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f56061f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f56062g;

    /* renamed from: i  reason: collision with root package name */
    public s f56064i;

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f56058c = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f56063h = -1;

    /* renamed from: j  reason: collision with root package name */
    public p.b f56065j = new p.b() { // from class: com.kwad.sdk.reward.presenter.j.2
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            j.this.f56063h = aVar.a;
            if (j.this.f56063h == 1) {
                j.this.f56059d.a(true);
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
        this.f56064i = sVar;
        gVar.a(sVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f56062g, this.f56058c, (b.c) null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f56062g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f56062g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f56062g));
        gVar.a(new p(this.f56065j));
        gVar.a(new m(this.f56057b, this.f56058c));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f56062g));
        gVar.a(new o(new o.a() { // from class: com.kwad.sdk.reward.presenter.j.1
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(com.kwad.sdk.core.webview.kwai.i iVar) {
                if (iVar.a() <= 0 || j.this.f56057b == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = j.this.f56057b.iterator();
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
                    AdWebViewActivityProxy.launch(j.this.q(), new AdWebViewActivityProxy.a.C2102a().a(iVar.f55045b).b(iVar.a).a(adTemplate).a());
                }
            }
        }));
    }

    private void s() {
        SceneImpl sceneImpl = ((com.kwad.sdk.reward.g) this).a.f55769g.mAdScene;
        SceneImpl m121clone = sceneImpl != null ? sceneImpl.m121clone() : null;
        if (m121clone != null) {
            com.kwad.sdk.reflux.a.a(m121clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f56059d.getNativeView().a(com.kwad.sdk.reflux.b.a(this.f56057b, this.f56058c));
        this.f56059d.a(false);
    }

    private void u() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f56062g = aVar;
        aVar.a(this.f56057b);
        com.kwad.sdk.core.webview.a aVar2 = this.f56062g;
        com.kwad.sdk.reward.a aVar3 = ((com.kwad.sdk.reward.g) this).a;
        aVar2.a = aVar3.f55768f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f55772j;
        aVar2.f54889b = adBaseFrameLayout;
        aVar2.f54891d = adBaseFrameLayout;
        aVar2.f54892e = this.f56060e;
    }

    private void v() {
        this.f56063h = -1;
        x();
        this.f56059d.a(false);
        String w = w();
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "startPreloadWebView url : " + w);
        if (at.a(w)) {
            t();
        } else {
            this.f56060e.loadUrl(w);
        }
    }

    @Nullable
    private String w() {
        return com.kwad.sdk.core.config.b.a(q());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void x() {
        y();
        be.a(this.f56060e);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f56060e);
        this.f56061f = gVar;
        a(gVar);
        this.f56060e.addJavascriptInterface(this.f56061f, "KwaiAd");
    }

    private void y() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f56061f;
        if (gVar != null) {
            gVar.a();
            this.f56061f = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        KsAdWebView ksAdWebView = this.f56060e;
        if (ksAdWebView != null) {
            ksAdWebView.setHttpErrorListener(this.k);
        }
        s();
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2126a
    public void a(int i2, String str) {
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2126a
    public void a(@Nullable List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.f56057b = list;
        if (list.size() > 0) {
            this.f56058c.clear();
            for (AdTemplate adTemplate : this.f56057b) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
                com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar.a());
                this.f56058c.add(bVar);
            }
            if (this.f56060e == null) {
                t();
                return;
            }
            u();
            v();
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2126a
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
        this.f56059d = ksRefluxView;
        this.f56060e = ksRefluxView.getWebView();
        this.f56059d.setViewListener(this);
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void d() {
        ((com.kwad.sdk.reward.g) this).a.f55764b.a(false);
        h();
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void e() {
        ((com.kwad.sdk.reward.g) this).a.k.c();
    }

    public int i() {
        List<AdTemplate> list;
        if (this.f56059d.isShown()) {
            return 3;
        }
        if (!((com.kwad.sdk.reward.g) this).a.v || (list = this.f56057b) == null || list.size() <= 0) {
            return 1;
        }
        s sVar = this.f56064i;
        if (sVar != null) {
            sVar.c();
        }
        this.f56059d.c();
        s sVar2 = this.f56064i;
        if (sVar2 != null) {
            sVar2.d();
            return 2;
        }
        return 2;
    }

    public boolean r() {
        KsRefluxView ksRefluxView = this.f56059d;
        return ksRefluxView != null && ksRefluxView.getVisibility() == 0;
    }
}
