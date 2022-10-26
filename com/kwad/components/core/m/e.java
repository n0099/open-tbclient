package com.kwad.components.core.m;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a(activity, 0, true, true);
        }
    }

    public static void a(Activity activity, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && oB()) {
            b(activity, i, z);
        }
    }

    public static boolean a(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, activity, z)) == null) {
            try {
                int intValue = ((Integer) q.N("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
                q.a((Object) activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static void b(Activity activity, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
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
                if (ap.zQ()) {
                    a(activity, true);
                } else if (ap.zR()) {
                    k.b(activity, true);
                }
            }
            window.getDecorView().setSystemUiVisibility(i3);
            window.setStatusBarColor(i);
            window.setNavigationBarColor(window.getNavigationBarColor());
        }
    }

    public static boolean oB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }
}
