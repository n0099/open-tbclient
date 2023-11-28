package com.kwad.components.ad.h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.PatchAdView;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.h.c {
    public static String nT = "PUSH_VIEW_TAG";
    public final com.kwad.components.core.widget.a.b bQ;
    public aw cQ;
    public i gj;
    public AdTemplate nU;
    public com.kwad.components.ad.b.a.b nV;
    public boolean nW;
    public ViewGroup nX;
    public boolean nY;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0664a c0664a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this;
    }

    public d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.nW = false;
        setTag(nT);
        this.nU = adTemplate;
        this.bQ = new com.kwad.components.core.widget.a.b(this, 100);
        this.gj = new i(-1L, getContext()) { // from class: com.kwad.components.ad.h.d.1
            {
                super(-1L, r4);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.components.p pVar, ViewGroup viewGroup) {
                super.a(bVar, cVar, pVar, viewGroup);
                pVar.c(new x(bVar, cVar, this) { // from class: com.kwad.components.ad.h.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void K(int i) {
                        super.K(i);
                        if (i == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.gj.a((Activity) null, com.kwad.sdk.core.response.b.c.dA(this.nU), this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((com.kwad.sdk.d.a.a.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((com.kwad.sdk.d.a.a.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.nV = bVar;
        if (this.nW && eT()) {
            eQ();
            return true;
        }
        return false;
    }

    private void destroy() {
        this.gj.jn();
        ViewGroup viewGroup = this.nX;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP() {
        if (this.nY) {
            return;
        }
        this.nY = true;
        eS();
        destroy();
    }

    private void eQ() {
        com.kwad.components.ad.b.a.b bVar = this.nV;
        if (bVar != null) {
            bVar.T();
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sg();
            this.cQ.sh();
        }
    }

    private void eS() {
        com.kwad.components.ad.b.a.b bVar = this.nV;
        if (bVar != null) {
            bVar.U();
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.si();
            this.cQ.sj();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onPageVisible: ");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sk();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onPageInvisible: ");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sl();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.bQ.a(this);
        this.bQ.tm();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.bQ.release();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        com.kwad.sdk.core.e.c.d("PushAdView", "onTkLoadSuccess");
        this.nW = true;
    }

    public final boolean eR() {
        return this.nW;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dx(this.nU);
    }

    private boolean eT() {
        try {
            com.kwad.sdk.core.c.b.Ct();
            final Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.nX = (ViewGroup) findViewById;
                this.nX.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.Ct();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.h.d.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.Ct();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.eP();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        this.cQ = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.e.c.d("PushAdView", "onTkLoadFailed");
        this.nW = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable WebCloseStatus webCloseStatus) {
        eP();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.e.c.d("PushAdView", PatchAdView.AD_CLICKED);
    }
}
