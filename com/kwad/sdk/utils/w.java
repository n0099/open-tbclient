package com.kwad.sdk.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.kwad.sdk.widget.c cVar, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cVar, drawable) == null) {
            if (drawable instanceof ShapeDrawable) {
                ((ShapeDrawable) drawable).getPaint().setColor(cVar.a());
            } else if (drawable instanceof ColorDrawable) {
                ((ColorDrawable) drawable).setColor(cVar.a());
            } else if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(cVar.a());
            }
        }
    }

    public static void a(com.kwad.sdk.widget.c cVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, cVar, viewGroup) == null) || cVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.sdk.widget.b) {
                ((com.kwad.sdk.widget.b) childAt).a(cVar);
            } else if (childAt instanceof ViewGroup) {
                a(cVar, (ViewGroup) childAt);
            }
        }
    }
}
