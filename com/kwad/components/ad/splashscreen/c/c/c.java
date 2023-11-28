package com.kwad.components.ad.splashscreen.c.c;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.c.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
/* loaded from: classes10.dex */
public abstract class c extends e implements j {
    public b Fk;

    public void a(aw awVar) {
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

    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    public int lC() {
        return 1000;
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        int lC = lC();
        b bVar = new b(getContext(), lC, lC);
        this.Fk = bVar;
        bVar.a((Activity) null, this.Df.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.Df.mRootContainer;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Fk.jn();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0664a c0664a) {
        if (c0664a.VE.equals("adDownloadConfirmTipShow")) {
            this.Df.kC();
        } else if (c0664a.VE.equals("adDownloadConfirmTipDismiss")) {
            this.Df.kE();
        } else if (c0664a.VE.equals("adDownloadConfirmTipCancel")) {
            this.Df.kD();
        }
    }
}
