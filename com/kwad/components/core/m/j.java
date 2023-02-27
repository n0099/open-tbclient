package com.kwad.components.core.m;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes8.dex */
public final class j {
    public static void a(com.kwad.components.core.widget.f fVar, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(fVar.qh());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(fVar.qh());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(fVar.qh());
        }
    }

    public static void a(com.kwad.components.core.widget.f fVar, ViewGroup viewGroup) {
        if (fVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.e) {
                ((com.kwad.components.core.widget.e) childAt).a(fVar);
            } else if (childAt instanceof ViewGroup) {
                a(fVar, (ViewGroup) childAt);
            }
        }
    }
}
