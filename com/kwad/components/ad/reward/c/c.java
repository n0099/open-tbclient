package com.kwad.components.ad.reward.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;
/* loaded from: classes9.dex */
public class c {
    @Nullable
    public Object oR;

    public c(Object obj) {
        this.oR = obj;
    }

    public void d(b bVar) {
        if (this.oR == null || bVar == null || bVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.oR).onAdClicked((KsInnerAd) bVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.oR = null;
    }

    public void e(b bVar) {
        if (this.oR == null || bVar == null || bVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.oR).onAdShow((KsInnerAd) bVar.getHost());
        } catch (Exception unused) {
        }
    }
}
