package com.kwad.sdk.reward.presenter.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.x;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d.c;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public class a extends g implements b.c, c.a, com.kwad.sdk.widget.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55998b;

    /* renamed from: c  reason: collision with root package name */
    public d f55999c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56000d;

    /* renamed from: e  reason: collision with root package name */
    public C2136a f56001e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f56002f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f56003g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.b.kwai.a f56004h;

    /* renamed from: com.kwad.sdk.reward.presenter.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2136a implements j.b, p.b {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public KsAdWebView f56005b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f56006c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f56007d;

        /* renamed from: e  reason: collision with root package name */
        public x f56008e;

        /* renamed from: f  reason: collision with root package name */
        public b.c f56009f;

        /* renamed from: g  reason: collision with root package name */
        public b f56010g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public AdTemplate f56011h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f56012i = false;

        public C2136a(KsAdWebView ksAdWebView, View view, b.c cVar) {
            this.a = view;
            this.f56005b = ksAdWebView;
            this.f56009f = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            View view = this.a;
            if (view != null) {
                view.setVisibility(0);
            }
            a(false);
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f56006c, (com.kwad.sdk.core.download.a.b) null, this.f56009f));
            gVar.a(new f(this.f56006c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f56006c));
            gVar.a(new p(this));
            x xVar = new x();
            this.f56008e = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.f56006c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f56006c));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.f56006c, this));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                a();
                return;
            }
            b();
            be.b(this.f56005b);
            this.f56005b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.a.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onReceivedHttpError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    C2136a.this.a();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f56005b);
            this.f56007d = gVar;
            a(gVar);
            this.f56005b.addJavascriptInterface(this.f56007d, "KwaiAd");
            this.f56005b.loadUrl(str);
            ax.a(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C2136a.this.f56012i) {
                        return;
                    }
                    C2136a.this.f56012i = true;
                    C2136a.this.a();
                }
            }, null, 1000L);
        }

        private void b() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.f56007d;
            if (gVar != null) {
                gVar.a();
                this.f56007d = null;
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f56006c = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.f56006c;
            aVar2.a = 0;
            aVar2.f54889b = null;
            aVar2.f54891d = viewGroup;
            aVar2.f54892e = this.f56005b;
            aVar2.f54890c = null;
            aVar2.f54895h = true;
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.f56005b;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.f56005b.getBackground() != null) {
                    this.f56005b.getBackground().setAlpha(0);
                }
            }
            this.f56011h = adTemplate;
            b(adTemplate, viewGroup);
            String b2 = com.kwad.sdk.core.response.a.b.b(adTemplate);
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "init url: " + b2);
            a(b2);
        }

        @Override // com.kwad.sdk.core.webview.jshandler.j.b
        public void a(@NonNull j.a aVar) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onAdFrameValid : " + aVar.toJson());
        }

        @Override // com.kwad.sdk.core.webview.jshandler.p.b
        public void a(p.a aVar) {
            if (this.f56012i) {
                return;
            }
            this.f56012i = true;
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.a == 1) {
                a(true);
            } else {
                a();
            }
        }

        public void a(b bVar) {
            this.f56010g = bVar;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.f56005b;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
    }

    /* loaded from: classes8.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public c() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return (!g() || af.e(q())) ? 8 : 0;
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends C2136a {
        public d(KsAdWebView ksAdWebView, View view, b.c cVar) {
            super(ksAdWebView, view, cVar);
        }
    }

    public a() {
        a((Presenter) new c());
    }

    private void a(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            b(z);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context q;
        float f2;
        if (!af.e(q())) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) a(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        int size = com.kwad.sdk.core.response.a.c.i(((g) this).a.f55769g).size();
        kSFrameLayout.setRatio(0.0f);
        if (size == 0) {
            q = q();
            f2 = 136.0f;
        } else {
            q = q();
            f2 = 155.0f;
        }
        com.kwad.sdk.a.kwai.a.a(kSFrameLayout, com.kwad.sdk.a.kwai.a.a(q, f2));
        ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_reward_apk_info_card_native_container);
        this.f56000d = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.f56000d, this);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f56000d);
        this.f56002f = cVar;
        cVar.a(this);
        this.f56002f.a(((g) this).a.f55769g, true);
        C2136a c2136a = new C2136a((KsAdWebView) a(R.id.ksad_reward_apk_info_card_h5), this.f56000d, this);
        this.f56001e = c2136a;
        c2136a.a(new b() { // from class: com.kwad.sdk.reward.presenter.c.a.1
        });
        this.f56001e.a(((g) this).a.f55769g, adBaseFrameLayout);
    }

    private void b(boolean z) {
        ((g) this).a.a(q(), z ? 1 : 153, 1);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onBind");
        if (g()) {
            com.kwad.sdk.reward.b.kwai.a b2 = com.kwad.sdk.reward.b.c.b();
            this.f56004h = b2;
            ((g) this).a.z = b2;
            b2.g();
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_activity_apk_info_area_native);
            this.f55998b = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.f55998b, this);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f55998b);
            this.f56003g = cVar;
            cVar.a(this);
            this.f56003g.a(((g) this).a.f55769g, false);
            ((KSFrameLayout) a(R.id.ksad_activity_apk_info_webview_container)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.ksad_activity_apk_info_webview), this.f55998b, this);
            this.f55999c = dVar;
            dVar.a(((g) this).a.f55769g, adBaseFrameLayout);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.b.c
    public void a(@Nullable b.a aVar) {
    }

    @Override // com.kwad.sdk.reward.d.c.a
    public void a(com.kwad.sdk.reward.d.c cVar, View view, boolean z) {
        b(z);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.f55769g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onUnbind");
        if (this.f56001e != null) {
            this.f56001e = null;
        }
        ((g) this).a.z = null;
    }
}
