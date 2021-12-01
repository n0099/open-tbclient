package com.kwad.sdk.a.kwai;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            int i2 = a;
            if (i2 <= 0 && context != null) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    a = context.getResources().getDimensionPixelSize(identifier);
                } else {
                    try {
                        Class<?> cls = Class.forName("com.android.internal.R$dimen");
                        Object newInstance = cls.newInstance();
                        Field field = cls.getField("status_bar_height");
                        field.setAccessible(true);
                        a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (a <= 0) {
                    a = a(context, 25.0f);
                }
                return a;
            }
            return i2;
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

    public static View a(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) ? a(activity.getWindow()) : (View) invokeL.objValue;
    }

    public static View a(ViewGroup viewGroup, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{viewGroup, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? d(viewGroup.getContext()).inflate(i2, viewGroup, z) : (View) invokeCommon.objValue;
    }

    public static View a(@NonNull Window window) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, window)) == null) ? window.getDecorView().findViewById(16908290) : (View) invokeL.objValue;
    }

    public static void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, view, i2) == null) || view == null || i2 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void a(View view, int i2, int i3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65542, null, view, i2, i3) == null) || view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i2 <= i3) {
                layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
                layoutParams.height = height;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            if (i3 <= i2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static int b(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, activity)) == null) ? a(activity).getHeight() : invokeL.intValue;
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
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static void b(View view, int i2, int i3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65545, null, view, i2, i3) == null) || view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    @Deprecated
    public static int c(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static void c(View view, int i2, int i3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65547, null, view, i2, i3) == null) || view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static LayoutInflater d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? LayoutInflater.from(context) : (LayoutInflater) invokeL.objValue;
    }
}
