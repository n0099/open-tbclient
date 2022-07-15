package com.repackage;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str == null) {
                return false;
            }
            int indexOf = str.indexOf("hiphotos");
            if (indexOf <= 0 || indexOf >= 20) {
                int indexOf2 = str.indexOf("tiebapic");
                return indexOf2 > 0 && indexOf2 < 20;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c() : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? FileHelper.checkSD() && ob.c() : invokeV.booleanValue;
    }
}
