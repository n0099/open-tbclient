package com.kwad.components.ad.interstitial.e.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.i;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.widget.e;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.components.ad.interstitial.e.b implements j {
    public i gj;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0664a c0664a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(aw awVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.gj.a(getActivity(), this.jK.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public e getTouchCoordsView() {
        return this.jK.jS;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.gj = new i(-1L, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.gj.jn();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        m mVar = new m();
        mVar.aaa = !this.jK.dU.isVideoSoundEnable();
        oVar.c(mVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
        pVar.c(new com.kwad.components.core.webview.tachikoma.a.i(new i.a() { // from class: com.kwad.components.ad.interstitial.e.a.a.1
            @Override // com.kwad.components.core.webview.tachikoma.a.i.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                com.kwad.components.ad.interstitial.report.a.dM().a(a.this.jK.mAdTemplate, 1L, 177L);
                a.this.a(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        c cVar = this.jK;
        cVar.jM = true;
        cVar.b(aVar.aDI, aVar.kk);
    }
}
