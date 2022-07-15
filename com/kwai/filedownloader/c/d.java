package com.kwai.filedownloader.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? i < 0 : invokeI.booleanValue;
    }

    public static boolean a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) {
            if ((i == 3 || i == 5 || i != i2) && !a(i)) {
                if (i <= 0 || i > 6 || i2 < 10 || i2 > 11) {
                    if (i == 1) {
                        return i2 != 0;
                    } else if (i == 2) {
                        return (i2 == 0 || i2 == 1 || i2 == 6) ? false : true;
                    } else if (i == 3) {
                        return (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) ? false : true;
                    } else if (i == 5) {
                        return (i2 == 1 || i2 == 6) ? false : true;
                    } else if (i != 6) {
                        return true;
                    } else {
                        return (i2 == 0 || i2 == 1) ? false : true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static boolean a(com.kwai.filedownloader.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) ? aVar.v() == 0 || aVar.v() == 3 : invokeL.booleanValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i > 0 : invokeI.booleanValue;
    }

    public static boolean b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            if ((i == 3 || i == 5 || i != i2) && !a(i)) {
                if (i2 == -2 || i2 == -1) {
                    return true;
                }
                if (i == 0) {
                    return i2 == 10;
                } else if (i == 1) {
                    return i2 == 6;
                } else if (i == 2 || i == 3) {
                    return i2 == -3 || i2 == 3 || i2 == 5;
                } else if (i == 5 || i == 6) {
                    return i2 == 2 || i2 == 5;
                } else if (i == 10) {
                    return i2 == 11;
                } else if (i != 11) {
                    return false;
                } else {
                    return i2 == -4 || i2 == -3 || i2 == 1;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }
}
