package com.sdk.o;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str, String str2, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, bool)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            if (bool.booleanValue()) {
                return Log.e(str, str2);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static Boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str)) ? Boolean.TRUE : Boolean.FALSE : (Boolean) invokeL.objValue;
    }

    public static int b(String str, String str2, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, bool)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            if (bool.booleanValue()) {
                return Log.i(str, str2);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static Boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE : (Boolean) invokeL.objValue;
    }

    public static int c(String str, String str2, Boolean bool) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, bool)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            if (bool.booleanValue()) {
                return Log.w(str, str2);
            }
            return -1;
        }
        return invokeLLL.intValue;
    }
}
