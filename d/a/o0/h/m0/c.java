package d.a.o0.h.m0;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d.a.o0.a.y.b.a aVar, boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{aVar, Boolean.valueOf(z), obj}) == null) {
            d.a.o0.h.d.c.a e2 = d.a.o0.h.d.c.a.e(aVar);
            if (z) {
                e2.d(obj);
            } else {
                e2.b(obj);
            }
        }
    }

    public static String b(@NonNull String str, @NonNull JSTypeMismatchException jSTypeMismatchException) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSTypeMismatchException)) == null) ? String.format("%s:fail parameter error: parameter.%s should be %s instead of %s", str, jSTypeMismatchException.name, d(jSTypeMismatchException.requiredType), d(jSTypeMismatchException.actualType)) : (String) invokeLL.objValue;
    }

    public static String c(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? String.format("%s: %s", str, str2) : (String) invokeLL.objValue;
    }

    public static String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return "boolean";
                case 2:
                case 3:
                case 5:
                    return IdCardActivity.KEY_NUMBER;
                case 4:
                case 9:
                case 10:
                default:
                    return "object";
                case 6:
                    return "array object";
                case 7:
                    return "string";
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

    public static void e(d.a.o0.a.l0.c cVar, JSTypeMismatchException jSTypeMismatchException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, jSTypeMismatchException) == null) {
            cVar.throwJSException(JSExceptionType.TypeError, String.format("The \"%s\" argument must be %s. Received type %s", jSTypeMismatchException.name, d(jSTypeMismatchException.requiredType), d(jSTypeMismatchException.actualType)));
        }
    }
}
