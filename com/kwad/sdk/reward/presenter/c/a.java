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
/* loaded from: classes7.dex */
public class a extends g implements b.c, c.a, com.kwad.sdk.widget.d {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40954b;

    /* renamed from: c  reason: collision with root package name */
    public d f40955c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f40956d;

    /* renamed from: e  reason: collision with root package name */
    public C1997a f40957e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f40958f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.reward.d.c f40959g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.reward.b.kwai.a f40960h;

    /* renamed from: com.kwad.sdk.reward.presenter.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1997a implements j.b, p.b {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public KsAdWebView f40961b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.core.webview.a f40962c;

        /* renamed from: d  reason: collision with root package name */
        public com.kwad.sdk.core.webview.kwai.g f40963d;

        /* renamed from: e  reason: collision with root package name */
        public x f40964e;

        /* renamed from: f  reason: collision with root package name */
        public b.c f40965f;

        /* renamed from: g  reason: collision with root package name */
        public b f40966g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public AdTemplate f40967h;
        public boolean i = false;

        public C1997a(KsAdWebView ksAdWebView, View view, b.c cVar) {
            this.a = view;
            this.f40961b = ksAdWebView;
            this.f40965f = cVar;
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
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f40962c, (com.kwad.sdk.core.download.a.b) null, this.f40965f));
            gVar.a(new f(this.f40962c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.f40962c));
            gVar.a(new p(this));
            x xVar = new x();
            this.f40964e = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.f40962c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f40962c));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.f40962c, this));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                a();
                return;
            }
            b();
            be.b(this.f40961b);
            this.f40961b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.a.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i, String str2, String str3) {
                    com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    C1997a.this.a();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.f40961b);
            this.f40963d = gVar;
            a(gVar);
            this.f40961b.addJavascriptInterface(this.f40963d, "KwaiAd");
            this.f40961b.loadUrl(str);
            ax.a(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C1997a.this.i) {
                        return;
                    }
                    C1997a.this.i = true;
                    C1997a.this.a();
                }
            }, null, 1000L);
        }

        private void b() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.f40963d;
            if (gVar != null) {
                gVar.a();
                this.f40963d = null;
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f40962c = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.f40962c;
            aVar2.a = 0;
            aVar2.f39981b = null;
            aVar2.f39983d = viewGroup;
            aVar2.f39984e = this.f40961b;
            aVar2.f39982c = null;
            aVar2.f39987h = true;
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.f40961b;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.f40961b.getBackground() != null) {
                    this.f40961b.getBackground().setAlpha(0);
                }
            }
            this.f40967h = adTemplate;
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
            if (this.i) {
                return;
            }
            this.i = true;
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", getClass().getName() + " updatePageStatus: " + aVar);
            if (aVar.a == 1) {
                a(true);
            } else {
                a();
            }
        }

        public void a(b bVar) {
            this.f40966g = bVar;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.f40961b;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
    }

    /* loaded from: classes7.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public c() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return (!g() || af.e(q())) ? 8 : 0;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends C1997a {
        public d(KsAdWebView ksAdWebView, View view, b.c cVar) {
            super(ksAdWebView, view, cVar);
        }
    }

    public a() {
        a((Presenter) new c());
    }

    private void a(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.obfuscated_res_0x7f0910e2 || id == R.id.obfuscated_res_0x7f091010) {
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
        ((ViewStub) a(R.id.obfuscated_res_0x7f0910ec)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.obfuscated_res_0x7f0910e3);
        kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.obfuscated_res_0x7f070370));
        int size = com.kwad.sdk.core.response.a.c.i(((g) this).a.f40747g).size();
        kSFrameLayout.setRatio(0.0f);
        if (size == 0) {
            q = q();
            f2 = 136.0f;
        } else {
            q = q();
            f2 = 155.0f;
        }
        com.kwad.sdk.a.kwai.a.a(kSFrameLayout, com.kwad.sdk.a.kwai.a.a(q, f2));
        ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f0910e2);
        this.f40956d = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.f40956d, this);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f40956d);
        this.f40958f = cVar;
        cVar.a(this);
        this.f40958f.a(((g) this).a.f40747g, true);
        C1997a c1997a = new C1997a((KsAdWebView) a(R.id.obfuscated_res_0x7f0910e1), this.f40956d, this);
        this.f40957e = c1997a;
        c1997a.a(new b() { // from class: com.kwad.sdk.reward.presenter.c.a.1
        });
        this.f40957e.a(((g) this).a.f40747g, adBaseFrameLayout);
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
            this.f40960h = b2;
            ((g) this).a.z = b2;
            b2.g();
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.obfuscated_res_0x7f091131);
            ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f091010);
            this.f40954b = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.f40954b, this);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.f40954b);
            this.f40959g = cVar;
            cVar.a(this);
            this.f40959g.a(((g) this).a.f40747g, false);
            ((KSFrameLayout) a(R.id.obfuscated_res_0x7f091012)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.obfuscated_res_0x7f091011), this.f40954b, this);
            this.f40955c = dVar;
            dVar.a(((g) this).a.f40747g, adBaseFrameLayout);
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
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.f40747g)) {
            a(view, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onUnbind");
        if (this.f40957e != null) {
            this.f40957e = null;
        }
        ((g) this).a.z = null;
    }
}
