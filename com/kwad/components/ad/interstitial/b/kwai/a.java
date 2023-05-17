package com.kwad.components.ad.interstitial.b.kwai;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.d;
import com.kwad.components.core.webview.b.e;
import com.kwad.components.core.webview.b.kwai.i;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.sdk.components.h;
/* loaded from: classes9.dex */
public abstract class a extends com.kwad.components.ad.interstitial.b.b implements e {
    public d hN;

    @Override // com.kwad.components.core.webview.b.e
    public final void a(q qVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(i iVar) {
        com.kwad.components.core.webview.b.a.i iVar2 = new com.kwad.components.core.webview.b.a.i();
        iVar2.NR = !this.gh.cN.isVideoSoundEnable();
        iVar.c(iVar2);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(j jVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(aa aaVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        this.hN.a(getActivity(), this.gh.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(com.kwad.components.core.webview.b.a.i iVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.widget.e dD() {
        return this.gh.gq;
    }

    @Override // com.kwad.components.core.webview.b.e
    public void dE() {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.interstitial.b.kwai.a.1
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
                a.this.gh.gl = true;
                a.this.gh.fo.onAdClicked();
            }
        };
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.hN = new d(-1L, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.hN.pF();
    }
}
