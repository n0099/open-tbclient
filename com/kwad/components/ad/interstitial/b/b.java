package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends Presenter {
    public c gh;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        this.gh = (c) xR();
    }

    public void cv() {
        List<Presenter> xQ = xQ();
        if (xQ == null) {
            return;
        }
        for (Presenter presenter : xQ) {
            if (presenter instanceof b) {
                ((b) presenter).cv();
            }
        }
    }

    public void cw() {
        List<Presenter> xQ = xQ();
        if (xQ == null) {
            return;
        }
        for (Presenter presenter : xQ) {
            if (presenter instanceof b) {
                ((b) presenter).cw();
            }
        }
    }
}
