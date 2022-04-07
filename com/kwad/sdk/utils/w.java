package com.kwad.sdk.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public class w {
    public static void a(com.kwad.sdk.widget.c cVar, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(cVar.a());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(cVar.a());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(cVar.a());
        }
    }

    public static void a(com.kwad.sdk.widget.c cVar, ViewGroup viewGroup) {
        if (cVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.sdk.widget.b) {
                ((com.kwad.sdk.widget.b) childAt).a(cVar);
            } else if (childAt instanceof ViewGroup) {
                a(cVar, (ViewGroup) childAt);
            }
        }
    }
}
