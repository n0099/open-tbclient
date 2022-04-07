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
/* loaded from: classes5.dex */
public class a extends g implements b.c, c.a, com.kwad.sdk.widget.d {
    public ViewGroup b;
    public d c;
    public ViewGroup d;
    public C0337a e;
    public com.kwad.sdk.reward.d.c f;
    public com.kwad.sdk.reward.d.c g;
    public com.kwad.sdk.reward.b.kwai.a h;

    /* renamed from: com.kwad.sdk.reward.presenter.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0337a implements j.b, p.b {
        public View a;
        public KsAdWebView b;
        public com.kwad.sdk.core.webview.a c;
        public com.kwad.sdk.core.webview.kwai.g d;
        public x e;
        public b.c f;
        public b g;
        @Nullable
        public AdTemplate h;
        public boolean i = false;

        public C0337a(KsAdWebView ksAdWebView, View view2, b.c cVar) {
            this.a = view2;
            this.b = ksAdWebView;
            this.f = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            View view2 = this.a;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            a(false);
        }

        private void a(com.kwad.sdk.core.webview.kwai.g gVar) {
            gVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.c, (com.kwad.sdk.core.download.a.b) null, this.f));
            gVar.a(new f(this.c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.d(this.c));
            gVar.a(new p(this));
            x xVar = new x();
            this.e = xVar;
            gVar.a(xVar);
            gVar.a(new k(this.c));
            gVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.c));
            gVar.a(new com.kwad.sdk.core.webview.a.g());
            gVar.a(new j(this.c, this));
        }

        @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
        private void a(String str) {
            if (at.a(str)) {
                a();
                return;
            }
            b();
            be.b(this.b);
            this.b.setHttpErrorListener(new KsAdWebView.d() { // from class: com.kwad.sdk.reward.presenter.c.a.a.1
                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a() {
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void a(int i, String str2, String str3) {
                    com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onReceivedHttpError: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
                    C0337a.this.a();
                }

                @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView.d
                public void b() {
                }
            });
            com.kwad.sdk.core.webview.kwai.g gVar = new com.kwad.sdk.core.webview.kwai.g(this.b);
            this.d = gVar;
            a(gVar);
            this.b.addJavascriptInterface(this.d, "KwaiAd");
            this.b.loadUrl(str);
            ax.a(new Runnable() { // from class: com.kwad.sdk.reward.presenter.c.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0337a.this.i) {
                        return;
                    }
                    C0337a.this.i = true;
                    C0337a.this.a();
                }
            }, null, 1000L);
        }

        private void b() {
            com.kwad.sdk.core.webview.kwai.g gVar = this.d;
            if (gVar != null) {
                gVar.a();
                this.d = null;
            }
        }

        private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.c = aVar;
            aVar.a(adTemplate);
            com.kwad.sdk.core.webview.a aVar2 = this.c;
            aVar2.a = 0;
            aVar2.b = null;
            aVar2.d = viewGroup;
            aVar2.e = this.b;
            aVar2.c = null;
            aVar2.h = true;
        }

        public void a(AdTemplate adTemplate, ViewGroup viewGroup) {
            KsAdWebView ksAdWebView = this.b;
            if (ksAdWebView != null) {
                ksAdWebView.setBackgroundColor(0);
                if (this.b.getBackground() != null) {
                    this.b.getBackground().setAlpha(0);
                }
            }
            this.h = adTemplate;
            b(adTemplate, viewGroup);
            String b = com.kwad.sdk.core.response.a.b.b(adTemplate);
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "init url: " + b);
            a(b);
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
            this.g = bVar;
        }

        public void a(boolean z) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "switchWebView: " + z);
            KsAdWebView ksAdWebView = this.b;
            if (ksAdWebView == null) {
                return;
            }
            ksAdWebView.setVisibility(z ? 0 : 8);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
    }

    /* loaded from: classes5.dex */
    public static class c extends com.kwad.sdk.reward.presenter.a {
        public c() {
        }

        @Override // com.kwad.sdk.reward.presenter.a
        public int i() {
            return (!g() || af.e(q())) ? 8 : 0;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends C0337a {
        public d(KsAdWebView ksAdWebView, View view2, b.c cVar) {
            super(ksAdWebView, view2, cVar);
        }
    }

    public a() {
        a((Presenter) new c());
    }

    private void a(View view2, boolean z) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0910db || id == R.id.obfuscated_res_0x7f091009) {
            b(z);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Context q;
        float f;
        if (!af.e(q())) {
            com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) a(R.id.obfuscated_res_0x7f0910e5)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) a(R.id.obfuscated_res_0x7f0910dc);
        kSFrameLayout.setRadius(q().getResources().getDimension(R.dimen.obfuscated_res_0x7f07037a));
        int size = com.kwad.sdk.core.response.a.c.i(((g) this).a.g).size();
        kSFrameLayout.setRatio(0.0f);
        if (size == 0) {
            q = q();
            f = 136.0f;
        } else {
            q = q();
            f = 155.0f;
        }
        com.kwad.sdk.a.kwai.a.a(kSFrameLayout, com.kwad.sdk.a.kwai.a.a(q, f));
        ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f0910db);
        this.d = viewGroup;
        viewGroup.setClickable(true);
        new com.kwad.sdk.widget.f(this.d, this);
        com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.d);
        this.f = cVar;
        cVar.a(this);
        this.f.a(((g) this).a.g, true);
        C0337a c0337a = new C0337a((KsAdWebView) a(R.id.obfuscated_res_0x7f0910da), this.d, this);
        this.e = c0337a;
        c0337a.a(new b() { // from class: com.kwad.sdk.reward.presenter.c.a.1
        });
        this.e.a(((g) this).a.g, adBaseFrameLayout);
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
            this.h = b2;
            ((g) this).a.z = b2;
            b2.g();
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) a(R.id.obfuscated_res_0x7f09112a);
            ViewGroup viewGroup = (ViewGroup) a(R.id.obfuscated_res_0x7f091009);
            this.b = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.b, this);
            com.kwad.sdk.reward.d.c cVar = new com.kwad.sdk.reward.d.c(this.b);
            this.g = cVar;
            cVar.a(this);
            this.g.a(((g) this).a.g, false);
            ((KSFrameLayout) a(R.id.obfuscated_res_0x7f09100b)).setWidthBasedRatio(false);
            d dVar = new d((KsAdWebView) a(R.id.obfuscated_res_0x7f09100a), this.b, this);
            this.c = dVar;
            dVar.a(((g) this).a.g, adBaseFrameLayout);
            a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.sdk.core.webview.jshandler.b.c
    public void a(@Nullable b.a aVar) {
    }

    @Override // com.kwad.sdk.reward.d.c.a
    public void a(com.kwad.sdk.reward.d.c cVar, View view2, boolean z) {
        b(z);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(((g) this).a.g)) {
            a(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("LandPageOpenTaskPresenter", "onUnbind");
        if (this.e != null) {
            this.e = null;
        }
        ((g) this).a.z = null;
    }
}
