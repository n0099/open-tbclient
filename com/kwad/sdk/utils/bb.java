package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class bb {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static int a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) {
            return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    @NonNull
    public static Context a(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            Activity b2 = b(view);
            if (b2 == null && (view.getParent() instanceof View)) {
                b2 = b((View) view.getParent());
            }
            return b2 == null ? view.getContext() : b2;
        }
        return (Context) invokeL.objValue;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i2, i3, i4, i5);
            view.requestLayout();
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = (Math.abs(uptimeMillis - a) > 500L ? 1 : (Math.abs(uptimeMillis - a) == 500L ? 0 : -1));
            a = uptimeMillis;
            return i2 < 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(@Nullable Matrix matrix, int i2, int i3, PhotoInfo.VideoInfo videoInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{matrix, Integer.valueOf(i2), Integer.valueOf(i3), videoInfo})) == null) {
            if (matrix != null) {
                matrix.reset();
            }
            if (videoInfo == null) {
                return false;
            }
            float f2 = videoInfo.width;
            float f3 = videoInfo.height;
            if (f2 >= f3) {
                return false;
            }
            float f4 = (float) videoInfo.leftRatio;
            float f5 = (float) videoInfo.topRatio;
            float f6 = (float) videoInfo.widthRatio;
            float f7 = (float) videoInfo.heightRatio;
            float f8 = i2;
            float f9 = f8 / f2;
            float f10 = i3;
            float f11 = f10 / f3;
            float f12 = f9 / f11;
            if (Math.abs(f12 - 1.0f) < 0.01d) {
                return false;
            }
            if (f9 > f11) {
                float f13 = f11 / f9;
                float f14 = (f13 + 1.0f) / 2.0f;
                if (f5 < (1.0f - f13) / 2.0f || f5 + f7 > f14) {
                    return false;
                }
            } else {
                float f15 = (f12 + 1.0f) / 2.0f;
                if (f4 < (1.0f - f12) / 2.0f || f4 + f6 > f15) {
                    return false;
                }
                f9 = f11;
            }
            if (matrix == null) {
                return true;
            }
            matrix.preTranslate((f8 - f2) / 2.0f, (f10 - f3) / 2.0f);
            matrix.preScale(f2 / f8, f3 / f10);
            matrix.postScale(f9, f9, f8 / 2.0f, f10 / 2.0f);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, view, i2)) == null) ? view != null && b(view, i2, true) && view.hasWindowFocus() && e(view.getContext()) : invokeLI.booleanValue;
    }

    public static boolean a(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? view != null && b(view, i2, z) && e(view.getContext()) : invokeCommon.booleanValue;
    }

    @Deprecated
    public static int b(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static Activity b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view)) == null) {
            Context context = view.getContext();
            HashSet hashSet = new HashSet();
            do {
                hashSet.add(context);
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Activity) {
                    return (Activity) context;
                } else {
                    context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
                }
            } while (!hashSet.contains(context));
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public static boolean b(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (view == null || view.getParent() == null) {
                return false;
            }
            if (com.kwad.sdk.core.config.b.ay()) {
                if (!view.isShown() && view.getVisibility() != 0) {
                    return false;
                }
            } else if (!view.isShown() || view.getVisibility() != 0) {
                return false;
            }
            if (!z || view.hasWindowFocus()) {
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    long height = rect.height() * rect.width();
                    long height2 = view.getHeight() * view.getWidth();
                    return height2 > 0 && height * 100 >= ((long) i2) * height2;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static float c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context.getResources().getDisplayMetrics().density : invokeL.floatValue;
    }

    @Nullable
    public static int[] c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) {
            if (view == null) {
                return null;
            }
            view.getLocationInWindow(r1);
            int[] iArr = {iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    @Nullable
    public static Context d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
            HashSet hashSet = new HashSet();
            hashSet.add(context);
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                if (context2 instanceof Activity) {
                    return context2;
                }
                if (context2 instanceof ResContext) {
                    ResContext resContext2 = (ResContext) context2;
                    context2 = resContext2.getDelegatedContext();
                    resContext = resContext2;
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
                if (hashSet.contains(context2)) {
                    break;
                }
                hashSet.add(context2);
            }
            return resContext != null ? resContext.getDelegatedContext() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? ak.a().a(context) : invokeL.booleanValue;
    }
}
