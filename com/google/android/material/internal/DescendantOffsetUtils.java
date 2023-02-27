package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class DescendantOffsetUtils {
    public static final ThreadLocal<Matrix> matrix = new ThreadLocal<>();
    public static final ThreadLocal<RectF> rectF = new ThreadLocal<>();

    public static void getDescendantRect(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull Rect rect) {
        rect.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRect(viewGroup, view2, rect);
    }

    public static void offsetDescendantMatrix(ViewParent viewParent, @NonNull View view2, @NonNull Matrix matrix2) {
        ViewParent parent = view2.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view3 = (View) parent;
            offsetDescendantMatrix(viewParent, view3, matrix2);
            matrix2.preTranslate(-view3.getScrollX(), -view3.getScrollY());
        }
        matrix2.preTranslate(view2.getLeft(), view2.getTop());
        if (!view2.getMatrix().isIdentity()) {
            matrix2.preConcat(view2.getMatrix());
        }
    }

    public static void offsetDescendantRect(@NonNull ViewGroup viewGroup, @NonNull View view2, @NonNull Rect rect) {
        Matrix matrix2 = matrix.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            matrix.set(matrix2);
        } else {
            matrix2.reset();
        }
        offsetDescendantMatrix(viewGroup, view2, matrix2);
        RectF rectF2 = rectF.get();
        if (rectF2 == null) {
            rectF2 = new RectF();
            rectF.set(rectF2);
        }
        rectF2.set(rect);
        matrix2.mapRect(rectF2);
        rect.set((int) (rectF2.left + 0.5f), (int) (rectF2.top + 0.5f), (int) (rectF2.right + 0.5f), (int) (rectF2.bottom + 0.5f));
    }
}
