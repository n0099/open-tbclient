package com.kwad.components.core.l;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.kwad.components.core.widget.f fVar, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fVar, drawable) == null) {
            if (drawable instanceof ShapeDrawable) {
                ((ShapeDrawable) drawable).getPaint().setColor(fVar.a());
            } else if (drawable instanceof ColorDrawable) {
                ((ColorDrawable) drawable).setColor(fVar.a());
            } else if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(fVar.a());
            }
        }
    }

    public static void a(com.kwad.components.core.widget.f fVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, fVar, viewGroup) == null) || fVar == null || viewGroup == null) {
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
