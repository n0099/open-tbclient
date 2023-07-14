package com.kwad.components.ad.splashscreen.d;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.core.widget.kwai.b {
    public d(@NonNull View view2, int i) {
        super(view2, 70);
    }

    @Override // com.kwad.components.core.widget.kwai.b, com.kwad.components.core.widget.kwai.a
    public final boolean dK() {
        com.kwad.sdk.core.c.b.tp();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.tp();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.dK();
        }
        return super.dK();
    }
}
