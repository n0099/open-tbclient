package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes7.dex */
public class s24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str, @NonNull JSTypeMismatchException jSTypeMismatchException) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, jSTypeMismatchException)) == null) ? String.format("%s:fail parameter error: parameter.%s should be %s instead of %s", str, jSTypeMismatchException.name, c(jSTypeMismatchException.requiredType), c(jSTypeMismatchException.actualType)) : (String) invokeLL.objValue;
    }

    public static String b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? String.format("%s: %s", str, str2) : (String) invokeLL.objValue;
    }

    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            switch (i) {
                case 1:
                    return "boolean";
                case 2:
                case 3:
                case 5:
                    return "number";
                case 4:
                case 9:
                case 10:
                default:
                    return "object";
                case 6:
                    return "array object";
                case 7:
                    return EMABTest.TYPE_STRING;
                case 8:
                    return "function object";
                case 11:
                    return StringUtil.NULL_STRING;
                case 12:
                    return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeI.objValue;
    }

    public static void call(os1 os1Var, boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{os1Var, Boolean.valueOf(z), obj}) == null) {
            ou3 e = ou3.e(os1Var);
            if (z) {
                e.d(obj);
            } else {
                e.b(obj);
            }
        }
    }

    public static void d(r72 r72Var, JSTypeMismatchException jSTypeMismatchException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, r72Var, jSTypeMismatchException) == null) {
            r72Var.throwJSException(JSExceptionType.TypeError, String.format("The \"%s\" argument must be %s. Received type %s", jSTypeMismatchException.name, c(jSTypeMismatchException.requiredType), c(jSTypeMismatchException.actualType)));
        }
    }
}
