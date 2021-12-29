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
public class j extends com.kwad.sdk.reward.g implements KsRefluxView.a, a.InterfaceC2114a {

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f59753b;

    /* renamed from: d  reason: collision with root package name */
    public KsRefluxView f59755d;

    /* renamed from: e  reason: collision with root package name */
    public KsAdWebView f59756e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.g f59757f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59758g;

    /* renamed from: i  reason: collision with root package name */
    public s f59760i;

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.core.download.a.b> f59754c = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f59759h = -1;

    /* renamed from: j  reason: collision with root package name */
    public p.b f59761j = new p.b() { // from class: com.kwad.sdk.reward.presenter.j.2
        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            j.this.f59759h = aVar.a;
            if (j.this.f59759h == 1) {
                j.this.f59755d.a(true);
            }
        }
    };

    /* renamed from: k  reason: collision with root package name */
    public KsAdWebView.d f59762k = new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.j.3
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
        this.f59760i = sVar;
        gVar.a(sVar);
        gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59758g, this.f59754c, (b.c) null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59758g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59758g));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f59758g));
        gVar.a(new p(this.f59761j));
        gVar.a(new m(this.f59753b, this.f59754c));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.i(null));
        gVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f59758g));
        gVar.a(new o(new o.a() { // from class: com.kwad.sdk.reward.presenter.j.1
            @Override // com.kwad.sdk.core.webview.jshandler.o.a
            public void a(com.kwad.sdk.core.webview.kwai.i iVar) {
                if (iVar.a() <= 0 || j.this.f59753b == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = j.this.f59753b.iterator();
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
                    AdWebViewActivityProxy.launch(j.this.q(), new AdWebViewActivityProxy.a.C2090a().a(iVar.f58694b).b(iVar.a).a(adTemplate).a());
                }
            }
        }));
    }

    private void s() {
        SceneImpl sceneImpl = ((com.kwad.sdk.reward.g) this).a.f59455g.mAdScene;
        SceneImpl m110clone = sceneImpl != null ? sceneImpl.m110clone() : null;
        if (m110clone != null) {
            com.kwad.sdk.reflux.a.a(m110clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f59755d.getNativeView().a(com.kwad.sdk.reflux.b.a(this.f59753b, this.f59754c));
        this.f59755d.a(false);
    }

    private void u() {
        com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
        this.f59758g = aVar;
        aVar.a(this.f59753b);
        com.kwad.sdk.core.webview.a aVar2 = this.f59758g;
        com.kwad.sdk.reward.a aVar3 = ((com.kwad.sdk.reward.g) this).a;
        aVar2.a = aVar3.f59454f;
        AdBaseFrameLayout adBaseFrameLayout = aVar3.f59458j;
        aVar2.f58536b = adBaseFrameLayout;
        aVar2.f58538d = adBaseFrameLayout;
        aVar2.f58539e = this.f59756e;
    }

    private void v() {
        this.f59759h = -1;
        x();
        this.f59755d.a(false);
        String w = w();
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "startPreloadWebView url : " + w);
        if (at.a(w)) {
            t();
        } else {
            this.f59756e.loadUrl(w);
        }
    }

    @Nullable
    private String w() {
        return com.kwad.sdk.core.config.b.a(q());
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void x() {
        y();
        be.a(this.f59756e);
        com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f59756e);
        this.f59757f = gVar;
        a(gVar);
        this.f59756e.addJavascriptInterface(this.f59757f, "KwaiAd");
    }

    private void y() {
        com.kwad.sdk.core.webview.kwai.g gVar = this.f59757f;
        if (gVar != null) {
            gVar.a();
            this.f59757f = null;
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        KsAdWebView ksAdWebView = this.f59756e;
        if (ksAdWebView != null) {
            ksAdWebView.setHttpErrorListener(this.f59762k);
        }
        s();
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2114a
    public void a(int i2, String str) {
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2114a
    public void a(@Nullable List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.f59753b = list;
        if (list.size() > 0) {
            this.f59754c.clear();
            for (AdTemplate adTemplate : this.f59753b) {
                com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(adTemplate);
                com.kwad.sdk.core.d.a.a("RewardRefluxPresenter", "onRefluxAdLoad helper: " + bVar.a());
                this.f59754c.add(bVar);
            }
            if (this.f59756e == null) {
                t();
                return;
            }
            u();
            v();
        }
    }

    @Override // com.kwad.sdk.reflux.a.InterfaceC2114a
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
        this.f59755d = ksRefluxView;
        this.f59756e = ksRefluxView.getWebView();
        this.f59755d.setViewListener(this);
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void d() {
        ((com.kwad.sdk.reward.g) this).a.f59450b.a(false);
        h();
    }

    @Override // com.kwad.sdk.reflux.KsRefluxView.a
    public void e() {
        ((com.kwad.sdk.reward.g) this).a.f59459k.c();
    }

    public int i() {
        List<AdTemplate> list;
        if (this.f59755d.isShown()) {
            return 3;
        }
        if (!((com.kwad.sdk.reward.g) this).a.v || (list = this.f59753b) == null || list.size() <= 0) {
            return 1;
        }
        s sVar = this.f59760i;
        if (sVar != null) {
            sVar.c();
        }
        this.f59755d.c();
        s sVar2 = this.f59760i;
        if (sVar2 != null) {
            sVar2.d();
            return 2;
        }
        return 2;
    }

    public boolean r() {
        KsRefluxView ksRefluxView = this.f59755d;
        return ksRefluxView != null && ksRefluxView.getVisibility() == 0;
    }
}
