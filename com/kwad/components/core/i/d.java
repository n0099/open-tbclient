package com.kwad.components.core.i;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;
/* loaded from: classes10.dex */
public final class d {
    @Nullable
    public Object LY;

    public d(Object obj) {
        this.LY = obj;
    }

    public final void c(c cVar) {
        if (this.LY != null && cVar != null && cVar.getHost() != null) {
            try {
                ((KsInnerAd.KsInnerAdInteractionListener) this.LY).onAdClicked((KsInnerAd) cVar.getHost());
            } catch (Exception unused) {
            }
        }
    }

    public final void d(c cVar) {
        if (this.LY != null && cVar != null && cVar.getHost() != null) {
            try {
                ((KsInnerAd.KsInnerAdInteractionListener) this.LY).onAdShow((KsInnerAd) cVar.getHost());
            } catch (Exception unused) {
            }
        }
    }

    public final void destroy() {
        this.LY = null;
    }
}
