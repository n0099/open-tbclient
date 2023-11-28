package com.kwad.components.core.e.a;

import com.kwad.components.core.webview.jshandler.aw;
/* loaded from: classes10.dex */
public final class a extends com.kwad.sdk.mvp.a {
    public g JG;
    public com.kwad.components.core.widget.a.b JH;
    public d JI;
    public aw cQ;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void bv() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sg();
            this.cQ.sh();
        }
    }

    public final void mU() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.si();
            this.cQ.sj();
        }
    }
}
