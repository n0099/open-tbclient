package com.kwad.components.ad.reward.presenter.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.j;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.a.a.c;
import com.kwad.components.ad.reward.presenter.a.a.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.kwad.components.ad.reward.presenter.a implements e, f, com.kwad.components.core.webview.b.d.b {
    public a() {
        bY();
    }

    private void bQ() {
        this.nM.a(this);
        com.kwad.components.ad.reward.b.eV().a(this);
    }

    private void dW() {
        List<Presenter> xQ = xQ();
        if (xQ == null) {
            return;
        }
        for (Presenter presenter : xQ) {
            if (presenter instanceof c) {
                ((c) presenter).hR();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable j jVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.a(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        dW();
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
        dW();
    }

    public void bY() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.a.a.a());
        a(new com.kwad.components.ad.reward.presenter.a.a.b());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.b(this);
        com.kwad.components.ad.reward.b.eV().b(this);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
