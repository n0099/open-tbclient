package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class UtcDates {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String UTC = "UTC";
    public static AtomicReference<TimeSource> timeSourceRef;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-867600525, "Lcom/google/android/material/datepicker/UtcDates;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-867600525, "Lcom/google/android/material/datepicker/UtcDates;");
                return;
            }
        }
        timeSourceRef = new AtomicReference<>();
    }

    public UtcDates() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static DateFormat getFullFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return getFullFormat(Locale.getDefault());
        }
        return (DateFormat) invokeV.objValue;
    }

    public static DateFormat getMediumFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return getMediumFormat(Locale.getDefault());
        }
        return (DateFormat) invokeV.objValue;
    }

    public static DateFormat getMediumNoYear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return getMediumNoYear(Locale.getDefault());
        }
        return (DateFormat) invokeV.objValue;
    }

    public static TimeSource getTimeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            TimeSource timeSource = timeSourceRef.get();
            if (timeSource == null) {
                return TimeSource.system();
            }
            return timeSource;
        }
        return (TimeSource) invokeV.objValue;
    }

    public static TimeZone getTimeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return TimeZone.getTimeZone("UTC");
        }
        return (TimeZone) invokeV.objValue;
    }

    @TargetApi(24)
    public static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return android.icu.util.TimeZone.getTimeZone("UTC");
        }
        return (android.icu.util.TimeZone) invokeV.objValue;
    }

    public static Calendar getUtcCalendar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return getUtcCalendarOf(null);
        }
        return (Calendar) invokeV.objValue;
    }

    public static SimpleDateFormat getYearMonthFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return getYearMonthFormat(Locale.getDefault());
        }
        return (SimpleDateFormat) invokeV.objValue;
    }

    public static long canonicalYearMonthDay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            Calendar utcCalendar = getUtcCalendar();
            utcCalendar.setTimeInMillis(j);
            return getDayCopy(utcCalendar).getTimeInMillis();
        }
        return invokeJ.longValue;
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat getAbbrMonthDayFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, locale)) == null) {
            return getAndroidFormat("MMMd", locale);
        }
        return (android.icu.text.DateFormat) invokeL.objValue;
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat getAbbrMonthWeekdayDayFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, locale)) == null) {
            return getAndroidFormat("MMMEd", locale);
        }
        return (android.icu.text.DateFormat) invokeL.objValue;
    }

    public static Calendar getDayCopy(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, calendar)) == null) {
            Calendar utcCalendarOf = getUtcCalendarOf(calendar);
            Calendar utcCalendar = getUtcCalendar();
            utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
            return utcCalendar;
        }
        return (Calendar) invokeL.objValue;
    }

    public static DateFormat getFullFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, locale)) == null) {
            return getFormat(0, locale);
        }
        return (DateFormat) invokeL.objValue;
    }

    public static DateFormat getMediumFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, locale)) == null) {
            return getFormat(2, locale);
        }
        return (DateFormat) invokeL.objValue;
    }

    public static DateFormat getMediumNoYear(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, locale)) == null) {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getMediumFormat(locale);
            simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
            return simpleDateFormat;
        }
        return (DateFormat) invokeL.objValue;
    }

    public static SimpleDateFormat getSimpleFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return getSimpleFormat(str, Locale.getDefault());
        }
        return (SimpleDateFormat) invokeL.objValue;
    }

    public static Calendar getUtcCalendarOf(@Nullable Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, calendar)) == null) {
            Calendar calendar2 = Calendar.getInstance(getTimeZone());
            if (calendar == null) {
                calendar2.clear();
            } else {
                calendar2.setTimeInMillis(calendar.getTimeInMillis());
            }
            return calendar2;
        }
        return (Calendar) invokeL.objValue;
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat getYearAbbrMonthDayFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, locale)) == null) {
            return getAndroidFormat("yMMMd", locale);
        }
        return (android.icu.text.DateFormat) invokeL.objValue;
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat getYearAbbrMonthWeekdayDayFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, locale)) == null) {
            return getAndroidFormat("yMMMEd", locale);
        }
        return (android.icu.text.DateFormat) invokeL.objValue;
    }

    public static SimpleDateFormat getYearMonthFormat(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, locale)) == null) {
            return getSimpleFormat("LLLL, yyyy", locale);
        }
        return (SimpleDateFormat) invokeL.objValue;
    }

    public static void setTimeSource(@Nullable TimeSource timeSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, timeSource) == null) {
            timeSourceRef.set(timeSource);
        }
    }

    public static int findCharactersInDateFormatPattern(@NonNull String str, @NonNull String str2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, str, str2, i, i2)) == null) {
            while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
                if (str.charAt(i2) == '\'') {
                    do {
                        i2 += i;
                        if (i2 >= 0 && i2 < str.length()) {
                        }
                    } while (str.charAt(i2) != '\'');
                }
                i2 += i;
            }
            return i2;
        }
        return invokeLLII.intValue;
    }

    @TargetApi(24)
    public static android.icu.text.DateFormat getAndroidFormat(String str, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, locale)) == null) {
            android.icu.text.DateFormat instanceForSkeleton = android.icu.text.DateFormat.getInstanceForSkeleton(str, locale);
            instanceForSkeleton.setTimeZone(getUtcAndroidTimeZone());
            return instanceForSkeleton;
        }
        return (android.icu.text.DateFormat) invokeLL.objValue;
    }

    public static DateFormat getFormat(int i, Locale locale) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, locale)) == null) {
            DateFormat dateInstance = DateFormat.getDateInstance(i, locale);
            dateInstance.setTimeZone(getTimeZone());
            return dateInstance;
        }
        return (DateFormat) invokeIL.objValue;
    }

    public static SimpleDateFormat getSimpleFormat(String str, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, locale)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
            simpleDateFormat.setTimeZone(getTimeZone());
            return simpleDateFormat;
        }
        return (SimpleDateFormat) invokeLL.objValue;
    }

    public static SimpleDateFormat getTextInputFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
            simpleDateFormat.setTimeZone(getTimeZone());
            simpleDateFormat.setLenient(false);
            return simpleDateFormat;
        }
        return (SimpleDateFormat) invokeV.objValue;
    }

    public static Calendar getTodayCalendar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            Calendar now = getTimeSource().now();
            now.set(11, 0);
            now.set(12, 0);
            now.set(13, 0);
            now.set(14, 0);
            now.setTimeZone(getTimeZone());
            return now;
        }
        return (Calendar) invokeV.objValue;
    }

    public static String getTextInputHint(Resources resources, SimpleDateFormat simpleDateFormat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, resources, simpleDateFormat)) == null) {
            return simpleDateFormat.toLocalizedPattern().replaceAll("d", resources.getString(R.string.obfuscated_res_0x7f0f0b52)).replaceAll("M", resources.getString(R.string.obfuscated_res_0x7f0f0b53)).replaceAll("y", resources.getString(R.string.obfuscated_res_0x7f0f0b54));
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static String removeYearFromDateFormatPattern(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
            if (findCharactersInDateFormatPattern >= str.length()) {
                return str;
            }
            String str2 = "EMd";
            int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, "EMd", 1, findCharactersInDateFormatPattern);
            if (findCharactersInDateFormatPattern2 < str.length()) {
                str2 = "EMd,";
            }
            return str.replace(str.substring(findCharactersInDateFormatPattern(str, str2, -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), " ").trim();
        }
        return (String) invokeL.objValue;
    }
}
