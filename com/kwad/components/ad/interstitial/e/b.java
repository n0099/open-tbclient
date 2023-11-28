package com.kwad.components.ad.interstitial.e;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends Presenter {
    public c jK;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.jK = (c) HU();
    }

    public void cP() {
        List<Presenter> HT = HT();
        if (HT == null) {
            return;
        }
        for (Presenter presenter : HT) {
            if (presenter instanceof b) {
                ((b) presenter).cP();
            }
        }
    }

    public void cQ() {
        List<Presenter> HT = HT();
        if (HT == null) {
            return;
        }
        for (Presenter presenter : HT) {
            if (presenter instanceof b) {
                ((b) presenter).cQ();
            }
        }
    }
}
