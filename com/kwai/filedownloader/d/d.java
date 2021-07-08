package com.kwai.filedownloader.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? i2 < 0 : invokeI.booleanValue;
    }

    public static boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            if ((i2 == 3 || i2 == 5 || i2 != i3) && !a(i2)) {
                if (i2 < 1 || i2 > 6 || i3 < 10 || i3 > 11) {
                    if (i2 == 1) {
                        return i3 != 0;
                    } else if (i2 == 2) {
                        return (i3 == 0 || i3 == 1 || i3 == 6) ? false : true;
                    } else if (i2 == 3) {
                        return (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 6) ? false : true;
                    } else if (i2 == 5) {
                        return (i3 == 1 || i3 == 6) ? false : true;
                    } else if (i2 != 6) {
                        return true;
                    } else {
                        return (i3 == 0 || i3 == 1) ? false : true;
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

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 > 0 : invokeI.booleanValue;
    }

    public static boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) {
            if ((i2 == 3 || i2 == 5 || i2 != i3) && !a(i2)) {
                if (i3 == -2 || i3 == -1) {
                    return true;
                }
                if (i2 == 0) {
                    return i3 == 10;
                } else if (i2 == 1) {
                    return i3 == 6;
                } else if (i2 == 2 || i2 == 3) {
                    return i3 == -3 || i3 == 3 || i3 == 5;
                } else if (i2 == 5 || i2 == 6) {
                    return i3 == 2 || i3 == 5;
                } else if (i2 == 10) {
                    return i3 == 11;
                } else if (i2 != 11) {
                    return false;
                } else {
                    return i3 == -4 || i3 == -3 || i3 == 1;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }
}
