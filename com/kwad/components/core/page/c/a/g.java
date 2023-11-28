package com.kwad.components.core.page.c.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class g extends a {
    public AdWebViewActivityProxy.a Oj;
    public aw Pa;
    public at Pb;
    public com.kwad.components.core.webview.b fX;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean OY = false;
    public boolean OZ = false;
    public final com.kwad.sdk.core.c.c wS = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView != null && g.this.getActivity() != null && g.this.getActivity().equals(activity)) {
                g.this.mAdWebView.onActivityDestroy();
                g.a(g.this, (KsAdWebView) null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    };
    public at.b OC = new at.b() { // from class: com.kwad.components.core.page.c.a.g.2
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void pu() {
            if (g.this.Pb != null) {
                g.this.Pb.sf();
            }
        }
    };
    public com.kwad.components.core.webview.c fY = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.c.a.g.3
        @Override // com.kwad.components.core.webview.c
        public final boolean pv() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean pw() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            g.this.Oy.OD = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bc(new bc.b() { // from class: com.kwad.components.core.page.c.a.g.3.1
                @Override // com.kwad.components.core.webview.jshandler.bc.b
                public final void a(bc.a aVar2) {
                    f.a aVar3 = g.this.Oy.OB;
                    if (aVar3 != null && aVar2 != null) {
                        aVar3.ax(aVar2.visibility);
                    }
                }
            }));
            g.this.Pb = new at(new at.c() { // from class: com.kwad.components.core.page.c.a.g.3.2
                @Override // com.kwad.components.core.webview.jshandler.at.c
                public final void px() {
                    g gVar = g.this;
                    gVar.Oy.a(gVar.OC);
                }
            });
            aVar.a(g.this.Pb);
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.b(bVar, g.this.Oy.mAdTemplate));
            k kVar = new k();
            kVar.ZY = g.this.Oy.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.a.g(kVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            g.this.Pa = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.Oy.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i, String str) {
            g.this.OY = false;
            g gVar = g.this;
            com.kwad.sdk.commercial.h.a.d(gVar.mAdTemplate, gVar.Oj.oW(), g.this.Oj.oV(), i, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.OY = true;
            if (!g.this.OZ) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.h.a.n(gVar.mAdTemplate, gVar.Oj.oW(), g.this.Oj.oV());
            }
            if (g.this.Oy.pj()) {
                g.this.show();
            }
        }
    };

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = this.Oy;
        this.Oj = bVar.Oj;
        this.mAdTemplate = bVar.mAdTemplate;
        er();
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(this.wS);
    }

    public final void hide() {
        aw awVar = this.Pa;
        if (awVar != null) {
            awVar.si();
        }
        KsAdWebView ksAdWebView = this.Oy.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aw awVar2 = this.Pa;
        if (awVar2 != null) {
            awVar2.sj();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091512);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fX.jn();
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.b(this.wS);
    }

    public final void show() {
        if (!this.OY) {
            return;
        }
        aw awVar = this.Pa;
        if (awVar != null) {
            awVar.sg();
        }
        try {
            if (this.Oy.mAdWebView != null) {
                this.Oy.mAdWebView.setVisibility(0);
            }
        } catch (Exception e) {
            com.kwad.components.core.d.a.b(e);
        }
        aw awVar2 = this.Pa;
        if (awVar2 != null) {
            awVar2.sh();
        }
    }

    public static /* synthetic */ boolean b(g gVar, boolean z) {
        gVar.OZ = true;
        return true;
    }

    public static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    private void er() {
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().az(this.Oy.mAdTemplate).ay(this.Oy.mPageUrl).d(this.mAdWebView).k(this.Oy.gS).a(this.fY).b(this.Oy.OA));
        pt();
        com.kwad.sdk.commercial.h.a.m(this.mAdTemplate, this.Oj.oW(), this.Oj.oV());
        this.mAdWebView.loadUrl(this.Oy.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void pt() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().bv(true).eh(this.Oy.mAdTemplate).bt(false));
        if (com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate)) > 0) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bt(true);
                    }
                }
            }, com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bt(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    g.this.mAdWebView.getClientConfig().bt(true);
                    return false;
                }
                return false;
            }
        });
    }
}
