package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class DescendantOffsetUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<Matrix> matrix;
    public static final ThreadLocal<RectF> rectF;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(512421600, "Lcom/google/android/material/internal/DescendantOffsetUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(512421600, "Lcom/google/android/material/internal/DescendantOffsetUtils;");
                return;
            }
        }
        matrix = new ThreadLocal<>();
        rectF = new ThreadLocal<>();
    }

    public DescendantOffsetUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void getDescendantRect(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, viewGroup, view, rect) == null) {
            rect.set(0, 0, view.getWidth(), view.getHeight());
            offsetDescendantRect(viewGroup, view, rect);
        }
    }

    public static void offsetDescendantMatrix(ViewParent viewParent, @NonNull View view, @NonNull Matrix matrix2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, viewParent, view, matrix2) == null) {
            ViewParent parent = view.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                View view2 = (View) parent;
                offsetDescendantMatrix(viewParent, view2, matrix2);
                matrix2.preTranslate(-view2.getScrollX(), -view2.getScrollY());
            }
            matrix2.preTranslate(view.getLeft(), view.getTop());
            if (view.getMatrix().isIdentity()) {
                return;
            }
            matrix2.preConcat(view.getMatrix());
        }
    }

    public static void offsetDescendantRect(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, view, rect) == null) {
            Matrix matrix2 = matrix.get();
            if (matrix2 == null) {
                matrix2 = new Matrix();
                matrix.set(matrix2);
            } else {
                matrix2.reset();
            }
            offsetDescendantMatrix(viewGroup, view, matrix2);
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
}
