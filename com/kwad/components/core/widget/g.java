package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(api = 21)
/* loaded from: classes10.dex */
public final class g extends ViewOutlineProvider {
    public float PF;

    public g(float f) {
        this.PF = f;
    }

    @RequiresApi(api = 21)
    public static void b(View view2, float f) {
        boolean z;
        if (f <= 0.0f) {
            view2.setOutlineProvider(null);
            z = false;
        } else {
            view2.setOutlineProvider(new g(f));
            z = true;
        }
        view2.setClipToOutline(z);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view2, Outline outline) {
        outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), this.PF);
    }
}
