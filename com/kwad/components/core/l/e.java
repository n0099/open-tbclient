package com.kwad.components.core.l;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.q;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a(activity, 0, true, true);
        }
    }

    public static void a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && a()) {
            b(activity, i, z);
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
            try {
                int intValue = ((Integer) q.a("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
                q.a((Object) activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void b(@NonNull Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Window window = activity.getWindow();
            int i2 = Build.VERSION.SDK_INT;
            int i3 = 1280;
            if (i2 < 21) {
                if (i2 >= 19) {
                    window.getDecorView().setSystemUiVisibility(1280);
                    return;
                }
                return;
            }
            if (z && i2 >= 23) {
                i3 = 9472;
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.addFlags(Integer.MIN_VALUE);
                if (am.b()) {
                    a(activity, true);
                } else if (am.c()) {
                    k.a(activity, true);
                }
            }
            window.getDecorView().setSystemUiVisibility(i3);
            window.setStatusBarColor(i);
            window.setNavigationBarColor(window.getNavigationBarColor());
        }
    }
}
