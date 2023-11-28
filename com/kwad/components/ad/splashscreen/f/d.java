package com.kwad.components.ad.splashscreen.f;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.core.widget.a.b {
    public d(@NonNull View view2, int i) {
        super(view2, i);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean dW() {
        com.kwad.sdk.core.c.b.Ct();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.Ct();
            if (com.kwad.sdk.core.c.b.isAppOnForeground() && super.dW()) {
                return true;
            }
            return false;
        }
        return super.dW();
    }
}
