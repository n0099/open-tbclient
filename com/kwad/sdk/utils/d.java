package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Activity activity, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            a(activity, i2, z, true);
        }
    }

    public static void a(@NonNull Activity activity, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && a()) {
            b(activity, i2, z);
            if (z2) {
                return;
            }
            activity.findViewById(16908290).setPadding(0, com.kwad.sdk.a.kwai.a.a((Context) activity), 0, 0);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    public static boolean a(@NonNull Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, activity, z)) == null) {
            Class<?> cls = activity.getWindow().getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window = activity.getWindow();
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? i2 : 0);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void b(@NonNull Activity activity, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Window window = activity.getWindow();
            int i3 = Build.VERSION.SDK_INT;
            int i4 = 1280;
            if (i3 < 21) {
                if (i3 >= 19) {
                    window.getDecorView().setSystemUiVisibility(1280);
                    return;
                }
                return;
            }
            if (z && i3 >= 23) {
                i4 = 9472;
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.addFlags(Integer.MIN_VALUE);
                if (an.b()) {
                    a(activity, true);
                } else if (an.c()) {
                    ab.a(activity, true);
                }
            }
            window.getDecorView().setSystemUiVisibility(i4);
            window.setStatusBarColor(i2);
            window.setNavigationBarColor(window.getNavigationBarColor());
        }
    }
}
