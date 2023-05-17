package com.kwad.components.ad.splashscreen.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes9.dex */
public class e extends Presenter {
    @Nullable
    public com.kwad.components.ad.splashscreen.h yF;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        Object xR = xR();
        if (xR instanceof com.kwad.components.ad.splashscreen.h) {
            this.yF = (com.kwad.components.ad.splashscreen.h) xR;
        }
    }
}
