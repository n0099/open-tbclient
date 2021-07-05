package com.google.gson.internal;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes7.dex */
public class PreJava9DateFormatProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreJava9DateFormatProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getDateFormatPattern(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return "M/d/yy";
                        }
                        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
                    }
                    return "MMM d, y";
                }
                return "MMMM d, y";
            }
            return "EEEE, MMMM d, y";
        }
        return (String) invokeI.objValue;
    }

    public static String getDatePartOfDateTimePattern(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return "M/d/yy";
                        }
                        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
                    }
                    return "MMM d, yyyy";
                }
                return "MMMM d, yyyy";
            }
            return "EEEE, MMMM d, yyyy";
        }
        return (String) invokeI.objValue;
    }

    public static String getTimePartOfDateTimePattern(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 == 0 || i2 == 1) {
                return "h:mm:ss a z";
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    return "h:mm a";
                }
                throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
            }
            return "h:mm:ss a";
        }
        return (String) invokeI.objValue;
    }

    public static DateFormat getUSDateFormat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65540, null, i2)) == null) ? new SimpleDateFormat(getDateFormatPattern(i2), Locale.US) : (DateFormat) invokeI.objValue;
    }

    public static DateFormat getUSDateTimeFormat(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            return new SimpleDateFormat(getDatePartOfDateTimePattern(i2) + " " + getTimePartOfDateTimePattern(i3), Locale.US);
        }
        return (DateFormat) invokeII.objValue;
    }
}
