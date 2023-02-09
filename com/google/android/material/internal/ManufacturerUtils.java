package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public class ManufacturerUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LGE = "lge";
    public static final String MEIZU = "meizu";
    public static final String SAMSUNG = "samsung";
    public transient /* synthetic */ FieldHolder $fh;

    public ManufacturerUtils() {
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

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!isLGEDevice() && !isSamsungDevice()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLGEDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(LGE);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMeizuDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
        }
        return invokeV.booleanValue;
    }

    public static boolean isSamsungDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(SAMSUNG);
        }
        return invokeV.booleanValue;
    }
}
