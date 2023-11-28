package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(api = 21)
/* loaded from: classes10.dex */
public final class h extends ViewOutlineProvider {
    public float acg;

    public h(float f) {
        this.acg = f;
    }

    @RequiresApi(api = 21)
    public static void b(View view2, float f) {
        if (f <= 0.0f) {
            view2.setOutlineProvider(null);
            view2.setClipToOutline(false);
            return;
        }
        view2.setOutlineProvider(new h(f));
        view2.setClipToOutline(true);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view2, Outline outline) {
        outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), this.acg);
    }
}
