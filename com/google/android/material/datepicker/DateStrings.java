package com.google.android.material.datepicker;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public class DateStrings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DateStrings() {
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

    public static Pair<String, String> getDateRangeString(@Nullable Long l, @Nullable Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, l, l2)) == null) ? getDateRangeString(l, l2, null) : (Pair) invokeLL.objValue;
    }

    public static String getDateString(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? getDateString(j, null) : (String) invokeJ.objValue;
    }

    public static String getMonthDay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) ? getMonthDay(j, Locale.getDefault()) : (String) invokeJ.objValue;
    }

    public static String getMonthDayOfWeekDay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) ? getMonthDayOfWeekDay(j, Locale.getDefault()) : (String) invokeJ.objValue;
    }

    public static String getYearMonthDay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) ? getYearMonthDay(j, Locale.getDefault()) : (String) invokeJ.objValue;
    }

    public static String getYearMonthDayOfWeekDay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65547, null, j)) == null) ? getYearMonthDayOfWeekDay(j, Locale.getDefault()) : (String) invokeJ.objValue;
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l, @Nullable Long l2, @Nullable SimpleDateFormat simpleDateFormat) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, l, l2, simpleDateFormat)) == null) {
            if (l == null && l2 == null) {
                return Pair.create(null, null);
            }
            if (l == null) {
                return Pair.create(null, getDateString(l2.longValue(), simpleDateFormat));
            }
            if (l2 == null) {
                return Pair.create(getDateString(l.longValue(), simpleDateFormat), null);
            }
            Calendar todayCalendar = UtcDates.getTodayCalendar();
            Calendar utcCalendar = UtcDates.getUtcCalendar();
            utcCalendar.setTimeInMillis(l.longValue());
            Calendar utcCalendar2 = UtcDates.getUtcCalendar();
            utcCalendar2.setTimeInMillis(l2.longValue());
            if (simpleDateFormat != null) {
                return Pair.create(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
            }
            if (utcCalendar.get(1) == utcCalendar2.get(1)) {
                if (utcCalendar.get(1) == todayCalendar.get(1)) {
                    return Pair.create(getMonthDay(l.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
                }
                return Pair.create(getMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return Pair.create(getYearMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
        return (Pair) invokeLLL.objValue;
    }

    public static String getDateString(long j, @Nullable SimpleDateFormat simpleDateFormat) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, null, j, simpleDateFormat)) == null) {
            Calendar todayCalendar = UtcDates.getTodayCalendar();
            Calendar utcCalendar = UtcDates.getUtcCalendar();
            utcCalendar.setTimeInMillis(j);
            if (simpleDateFormat != null) {
                return simpleDateFormat.format(new Date(j));
            }
            if (todayCalendar.get(1) == utcCalendar.get(1)) {
                return getMonthDay(j);
            }
            return getYearMonthDay(j);
        }
        return (String) invokeJL.objValue;
    }

    public static String getMonthDay(long j, Locale locale) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65542, null, j, locale)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j));
            }
            return UtcDates.getMediumNoYear(locale).format(new Date(j));
        }
        return (String) invokeJL.objValue;
    }

    public static String getMonthDayOfWeekDay(long j, Locale locale) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65544, null, j, locale)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
            }
            return UtcDates.getFullFormat(locale).format(new Date(j));
        }
        return (String) invokeJL.objValue;
    }

    public static String getYearMonthDay(long j, Locale locale) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65546, null, j, locale)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j));
            }
            return UtcDates.getMediumFormat(locale).format(new Date(j));
        }
        return (String) invokeJL.objValue;
    }

    public static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65548, null, j, locale)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
            }
            return UtcDates.getFullFormat(locale).format(new Date(j));
        }
        return (String) invokeJL.objValue;
    }
}
