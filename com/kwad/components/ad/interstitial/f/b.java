package com.kwad.components.ad.interstitial.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bq;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    public View mRootView;

    public b(@NonNull View view2, int i) {
        super(view2, 100);
        this.mRootView = view2;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean dW() {
        return bq.o(this.mRootView, 100);
    }
}
