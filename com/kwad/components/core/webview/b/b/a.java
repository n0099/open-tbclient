package com.kwad.components.core.webview.b.b;

import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.e;
import com.kwad.components.core.webview.b.kwai.i;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.sdk.components.h;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public abstract class a extends Presenter implements e {
    public b Ob;
    public com.kwad.components.core.webview.b.d hN;

    @Override // com.kwad.components.core.webview.b.e
    public void a(q qVar) {
    }

    public void a(b bVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(i iVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(j jVar) {
    }

    public void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        b bVar = (b) xR();
        this.Ob = bVar;
        a(bVar);
        if (this.hN == null) {
            this.hN = ip();
        }
        com.kwad.components.core.webview.b.d dVar = this.hN;
        b bVar2 = this.Ob;
        dVar.a(bVar2.mActivity, bVar2.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(com.kwad.components.core.webview.b.a.i iVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.widget.e dD() {
        return this.Ob.Oc;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dE() {
        d dVar = this.Ob.Ne;
        if (dVar != null) {
            dVar.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public void dI() {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        return null;
    }

    public com.kwad.components.core.webview.b.d ip() {
        return new com.kwad.components.core.webview.b.d(this.Ob.tS, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.hN.pF();
        this.hN = null;
    }
}
