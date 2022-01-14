package com.kwad.sdk.reward.presenter.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class a extends g implements b.c, c.a, com.kwad.sdk.widget.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57436b;

    /* renamed from: c  reason: collision with root package name */
    public d f57437c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57438d;

    /* renamed from: e  reason: collision with root package name */
    public C2141a f57439e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f57440f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f57441g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.b.kwai.a f57442h;

    /* renamed from: com.kwad.sdk.reward.presenter.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2141a implements j.b, p.b {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public KsAdWebView f57443b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f57444c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f57445d;

        /* renamed from: e  reason: collision with root package name */
        public x f57446e;

        /* renamed from: f  reason: collision with root package name */
        public b.c f57447f;

        /* renamed from: g  reason: collision with root package name */
        public b f57448g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public AdTemplate f57449h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f57450i = false;

        public C2141a(KsAdWebView ksAdWebView, View view, b.c cVar) {
            this.a = view;
            this.f57443b = ksAdWebView;
            this.f57447f = cVar;
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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f57444c, (com.kwad.sdk.core.download.a.b) null, this.f57447f));
            gVar.a(new f(this.f57444c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f57444c));
            gVar.a(new p(this));
            x xVar = new x();
            this.f57446e = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.f57444c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f57444c));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.f57444c, this));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                a();
                return;
            }
            b();
            be.b(this.f57443b);
            this.f57443b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.a.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i2, String str2, String str3) {
                    com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onReceivedHttpError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    C2141a.this.a();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f57443b);
            this.f57445d = gVar;
            a(gVar);
            this.f57443b.addJavascriptInterface(this.f57445d, "KwaiAd");
            this.f57443b.loadUrl(str);
            ax.a(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C2141a.this.f57450i) {
                        return;
                    }
                    C2141a.this.f57450i = true;
                    C2141a.this.a();
                }
            }, null, 1000L);
        }

        private void b() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.f57445d;
            if (gVar != null) {
                gVar.a();
                this.f57445d = null;
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f57444c = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.f57444c;
            aVar2.a = 0;
            aVar2.f56327b = null;
            aVar2.f56329d = viewGroup;
            aVar2.f56330e = this.f57443b;
            aVar2.f56328c = null;
            aVar2.f56333h = true;
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.f57443b;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.f57443b.getBackground() != null) {
                    this.f57443b.getBackground().setAlpha(0);
                }
            }
            this.f57449h = adTemplate;
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
            if (this.f57450i) {
                return;
            }
            this.f57450i = true;
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.a == 1) {
                a(true);
            } else {
                a();
            }
        }

        public void a(b bVar) {
            this.f57448g = bVar;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.f57443b;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public c() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return (!g() || af.e(q())) ? 8 : 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends C2141a {
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
        int size = com.kwad.sdk.core.response.a.c.i(((g) this).a.f57207g).size();
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
        this.f57438d = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.f57438d, this);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f57438d);
        this.f57440f = cVar;
        cVar.a(this);
        this.f57440f.a(((g) this).a.f57207g, true);
        C2141a c2141a = new C2141a((KsAdWebView) a(R.id.ksad_reward_apk_info_card_h5), this.f57438d, this);
        this.f57439e = c2141a;
        c2141a.a(new b() { // from class: com.kwad.sdk.reward.presenter.c.a.1
        });
        this.f57439e.a(((g) this).a.f57207g, adBaseFrameLayout);
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
            this.f57442h = b2;
            ((g) this).a.z = b2;
            b2.g();
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) a(R.id.ksad_activity_apk_info_area_native);
            this.f57436b = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.f57436b, this);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f57436b);
            this.f57441g = cVar;
            cVar.a(this);
            this.f57441g.a(((g) this).a.f57207g, false);
            ((KSFrameLayout) a(R.id.ksad_activity_apk_info_webview_container)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.ksad_activity_apk_info_webview), this.f57436b, this);
            this.f57437c = dVar;
            dVar.a(((g) this).a.f57207g, adBaseFrameLayout);
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
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.f57207g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onUnbind");
        if (this.f57439e != null) {
            this.f57439e = null;
        }
        ((g) this).a.z = null;
    }
}
