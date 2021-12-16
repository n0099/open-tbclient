package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public class DateFormatUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_DATE_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_TIME_FORMAT;
    public static final FastDateFormat ISO_8601_EXTENDED_TIME_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATETIME_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_NO_T_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT;
    @Deprecated
    public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT;
    public static final FastDateFormat SMTP_DATETIME_FORMAT;
    public static final TimeZone UTC_TIME_ZONE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1912362326, "Lorg/apache/commons/lang3/time/DateFormatUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1912362326, "Lorg/apache/commons/lang3/time/DateFormatUtils;");
                return;
            }
        }
        UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
        ISO_8601_EXTENDED_DATETIME_FORMAT = fastDateFormat;
        ISO_DATETIME_FORMAT = fastDateFormat;
        FastDateFormat fastDateFormat2 = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
        ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT = fastDateFormat2;
        ISO_DATETIME_TIME_ZONE_FORMAT = fastDateFormat2;
        FastDateFormat fastDateFormat3 = FastDateFormat.getInstance("yyyy-MM-dd");
        ISO_8601_EXTENDED_DATE_FORMAT = fastDateFormat3;
        ISO_DATE_FORMAT = fastDateFormat3;
        ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
        ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
        ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
        FastDateFormat fastDateFormat4 = FastDateFormat.getInstance("HH:mm:ss");
        ISO_8601_EXTENDED_TIME_FORMAT = fastDateFormat4;
        ISO_TIME_NO_T_FORMAT = fastDateFormat4;
        FastDateFormat fastDateFormat5 = FastDateFormat.getInstance("HH:mm:ssZZ");
        ISO_8601_EXTENDED_TIME_TIME_ZONE_FORMAT = fastDateFormat5;
        ISO_TIME_NO_T_TIME_ZONE_FORMAT = fastDateFormat5;
        SMTP_DATETIME_FORMAT = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
    }

    public DateFormatUtils() {
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

    public static String format(long j2, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j2, str)) == null) ? format(new Date(j2), str, (TimeZone) null, (Locale) null) : (String) invokeJL.objValue;
    }

    public static String formatUTC(long j2, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65550, null, j2, str)) == null) ? format(new Date(j2), str, UTC_TIME_ZONE, (Locale) null) : (String) invokeJL.objValue;
    }

    public static String format(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, date, str)) == null) ? format(date, str, (TimeZone) null, (Locale) null) : (String) invokeLL.objValue;
    }

    public static String formatUTC(Date date, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, date, str)) == null) ? format(date, str, UTC_TIME_ZONE, (Locale) null) : (String) invokeLL.objValue;
    }

    public static String format(Calendar calendar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, calendar, str)) == null) ? format(calendar, str, (TimeZone) null, (Locale) null) : (String) invokeLL.objValue;
    }

    public static String formatUTC(long j2, String str, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Long.valueOf(j2), str, locale})) == null) ? format(new Date(j2), str, UTC_TIME_ZONE, locale) : (String) invokeCommon.objValue;
    }

    public static String format(long j2, String str, TimeZone timeZone) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), str, timeZone})) == null) ? format(new Date(j2), str, timeZone, (Locale) null) : (String) invokeCommon.objValue;
    }

    public static String formatUTC(Date date, String str, Locale locale) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, date, str, locale)) == null) ? format(date, str, UTC_TIME_ZONE, locale) : (String) invokeLLL.objValue;
    }

    public static String format(Date date, String str, TimeZone timeZone) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, date, str, timeZone)) == null) ? format(date, str, timeZone, (Locale) null) : (String) invokeLLL.objValue;
    }

    public static String format(Calendar calendar, String str, TimeZone timeZone) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, calendar, str, timeZone)) == null) ? format(calendar, str, timeZone, (Locale) null) : (String) invokeLLL.objValue;
    }

    public static String format(long j2, String str, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), str, locale})) == null) ? format(new Date(j2), str, (TimeZone) null, locale) : (String) invokeCommon.objValue;
    }

    public static String format(Date date, String str, Locale locale) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, date, str, locale)) == null) ? format(date, str, (TimeZone) null, locale) : (String) invokeLLL.objValue;
    }

    public static String format(Calendar calendar, String str, Locale locale) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, calendar, str, locale)) == null) ? format(calendar, str, (TimeZone) null, locale) : (String) invokeLLL.objValue;
    }

    public static String format(long j2, String str, TimeZone timeZone, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), str, timeZone, locale})) == null) ? format(new Date(j2), str, timeZone, locale) : (String) invokeCommon.objValue;
    }

    public static String format(Date date, String str, TimeZone timeZone, Locale locale) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, date, str, timeZone, locale)) == null) ? FastDateFormat.getInstance(str, timeZone, locale).format(date) : (String) invokeLLLL.objValue;
    }

    public static String format(Calendar calendar, String str, TimeZone timeZone, Locale locale) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, calendar, str, timeZone, locale)) == null) ? FastDateFormat.getInstance(str, timeZone, locale).format(calendar) : (String) invokeLLLL.objValue;
    }
}
