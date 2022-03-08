package com.kwad.sdk.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(api = 21)
/* loaded from: classes8.dex */
public class g extends ViewOutlineProvider {
    public float a;

    public g(float f2) {
        this.a = f2;
    }

    @RequiresApi(api = 21)
    public static void a(View view, float f2) {
        boolean z;
        if (f2 <= 0.0f) {
            view.setOutlineProvider(null);
            z = false;
        } else {
            view.setOutlineProvider(new g(f2));
            z = true;
        }
        view.setClipToOutline(z);
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
    }
}
