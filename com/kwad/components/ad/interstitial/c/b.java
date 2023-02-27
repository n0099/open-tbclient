package com.kwad.components.ad.interstitial.c;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.core.widget.kwai.a {
    public View mRootView;

    public b(@NonNull View view2, int i) {
        super(view2, 100);
        this.mRootView = view2;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public final boolean dK() {
        return com.kwad.sdk.b.kwai.a.g(this.mRootView, 100);
    }
}
