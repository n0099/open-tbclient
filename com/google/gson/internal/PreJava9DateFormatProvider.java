package com.google.gson.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes8.dex */
public class PreJava9DateFormatProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreJava9DateFormatProvider() {
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

    public static String getDateFormatPattern(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return "M/d/yy";
                        }
                        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                    }
                    return "MMM d, y";
                }
                return "MMMM d, y";
            }
            return "EEEE, MMMM d, y";
        }
        return (String) invokeI.objValue;
    }

    public static String getDatePartOfDateTimePattern(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return "M/d/yy";
                        }
                        throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                    }
                    return "MMM d, yyyy";
                }
                return "MMMM d, yyyy";
            }
            return "EEEE, MMMM d, yyyy";
        }
        return (String) invokeI.objValue;
    }

    public static String getTimePartOfDateTimePattern(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 0 && i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "h:mm a";
                    }
                    throw new IllegalArgumentException("Unknown DateFormat style: " + i);
                }
                return "h:mm:ss a";
            }
            return "h:mm:ss a z";
        }
        return (String) invokeI.objValue;
    }

    public static DateFormat getUSDateFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return new SimpleDateFormat(getDateFormatPattern(i), Locale.US);
        }
        return (DateFormat) invokeI.objValue;
    }

    public static DateFormat getUSDateTimeFormat(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            return new SimpleDateFormat(getDatePartOfDateTimePattern(i) + " " + getTimePartOfDateTimePattern(i2), Locale.US);
        }
        return (DateFormat) invokeII.objValue;
    }
}
