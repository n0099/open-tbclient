package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.commons.lang3.exception.ExceptionUtils;
/* loaded from: classes9.dex */
public class CalendarReflection {
    public static /* synthetic */ Interceptable $ic;
    public static final Method GET_WEEK_YEAR;
    public static final Method IS_WEEK_DATE_SUPPORTED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1562832917, "Lorg/apache/commons/lang3/time/CalendarReflection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1562832917, "Lorg/apache/commons/lang3/time/CalendarReflection;");
                return;
            }
        }
        IS_WEEK_DATE_SUPPORTED = getCalendarMethod("isWeekDateSupported", new Class[0]);
        GET_WEEK_YEAR = getCalendarMethod("getWeekYear", new Class[0]);
    }

    public CalendarReflection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Method getCalendarMethod(String str, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, clsArr)) == null) {
            try {
                return Calendar.class.getMethod(str, clsArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Method) invokeLL.objValue;
    }

    public static int getWeekYear(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, calendar)) == null) {
            try {
                if (isWeekDateSupported(calendar)) {
                    return ((Integer) GET_WEEK_YEAR.invoke(calendar, new Object[0])).intValue();
                }
                int i2 = calendar.get(1);
                if (IS_WEEK_DATE_SUPPORTED == null && (calendar instanceof GregorianCalendar)) {
                    int i3 = calendar.get(2);
                    return i3 != 0 ? (i3 == 11 && calendar.get(3) == 1) ? i2 + 1 : i2 : calendar.get(3) >= 52 ? i2 - 1 : i2;
                }
                return i2;
            } catch (Exception e2) {
                return ((Integer) ExceptionUtils.rethrow(e2)).intValue();
            }
        }
        return invokeL.intValue;
    }

    public static boolean isWeekDateSupported(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, calendar)) == null) {
            try {
                if (IS_WEEK_DATE_SUPPORTED != null) {
                    return ((Boolean) IS_WEEK_DATE_SUPPORTED.invoke(calendar, new Object[0])).booleanValue();
                }
                return false;
            } catch (Exception e2) {
                return ((Boolean) ExceptionUtils.rethrow(e2)).booleanValue();
            }
        }
        return invokeL.booleanValue;
    }
}
