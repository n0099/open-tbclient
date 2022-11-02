package com.google.android.gms.common.util;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
@VisibleForTesting
@KeepForSdk
/* loaded from: classes7.dex */
public final class PlatformVersion {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlatformVersion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @KeepForSdk
    public static boolean isAtLeastHoneycomb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastHoneycombMR1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwich() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwichMR1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.VERSION.SDK_INT >= 15 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Build.VERSION.SDK_INT >= 16 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.VERSION.SDK_INT >= 17 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastKitKat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Build.VERSION.SDK_INT >= 19 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastKitKatWatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Build.VERSION.SDK_INT >= 20 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastLollipop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastLollipopMR1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Build.VERSION.SDK_INT >= 22 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 23 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Build.VERSION.SDK_INT >= 26 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Build.VERSION.SDK_INT >= 28 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? Build.VERSION.SDK_INT >= 29 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.VERSION.SDK_INT >= 30 : invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (Build.VERSION.SDK_INT >= 31) {
                return true;
            }
            if (isAtLeastR() && Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'S' && Build.VERSION.CODENAME.charAt(0) <= 'Z') {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isAtLeastT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (!isAtLeastS() || Build.VERSION.CODENAME.charAt(0) < 'T' || Build.VERSION.CODENAME.charAt(0) > 'Z') {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
