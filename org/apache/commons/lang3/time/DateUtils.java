package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class DateUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    public static final int[][] fields;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class DateIterator implements Iterator<Calendar> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Calendar endFinal;
        public final Calendar spot;

        public DateIterator(Calendar calendar, Calendar calendar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {calendar, calendar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.spot.before(this.endFinal) : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Calendar next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!this.spot.equals(this.endFinal)) {
                    this.spot.add(5, 1);
                    return (Calendar) this.spot.clone();
                }
                throw new NoSuchElementException();
            }
            return (Calendar) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ModifyType {
        public static final /* synthetic */ ModifyType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ModifyType CEILING;
        public static final ModifyType ROUND;
        public static final ModifyType TRUNCATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1266513825, "Lorg/apache/commons/lang3/time/DateUtils$ModifyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1266513825, "Lorg/apache/commons/lang3/time/DateUtils$ModifyType;");
                    return;
                }
            }
            TRUNCATE = new ModifyType("TRUNCATE", 0);
            ROUND = new ModifyType("ROUND", 1);
            ModifyType modifyType = new ModifyType("CEILING", 2);
            CEILING = modifyType;
            $VALUES = new ModifyType[]{TRUNCATE, ROUND, modifyType};
        }

        public ModifyType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ModifyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ModifyType) Enum.valueOf(ModifyType.class, str) : (ModifyType) invokeL.objValue;
        }

        public static ModifyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ModifyType[]) $VALUES.clone() : (ModifyType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2080115263, "Lorg/apache/commons/lang3/time/DateUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2080115263, "Lorg/apache/commons/lang3/time/DateUtils;");
                return;
            }
        }
        fields = new int[][]{new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};
    }

    public DateUtils() {
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

    public static Date add(Date date, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, date, i2, i3)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(i2, i3);
                return calendar.getTime();
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLII.objValue;
    }

    public static Date addDays(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, date, i2)) == null) ? add(date, 5, i2) : (Date) invokeLI.objValue;
    }

    public static Date addHours(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, date, i2)) == null) ? add(date, 11, i2) : (Date) invokeLI.objValue;
    }

    public static Date addMilliseconds(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, date, i2)) == null) ? add(date, 14, i2) : (Date) invokeLI.objValue;
    }

    public static Date addMinutes(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, date, i2)) == null) ? add(date, 12, i2) : (Date) invokeLI.objValue;
    }

    public static Date addMonths(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, date, i2)) == null) ? add(date, 2, i2) : (Date) invokeLI.objValue;
    }

    public static Date addSeconds(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, date, i2)) == null) ? add(date, 13, i2) : (Date) invokeLI.objValue;
    }

    public static Date addWeeks(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, date, i2)) == null) ? add(date, 3, i2) : (Date) invokeLI.objValue;
    }

    public static Date addYears(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, date, i2)) == null) ? add(date, 1, i2) : (Date) invokeLI.objValue;
    }

    public static Date ceiling(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, date, i2)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                modify(calendar, i2, ModifyType.CEILING);
                return calendar.getTime();
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLI.objValue;
    }

    public static long getFragment(Date date, int i2, TimeUnit timeUnit) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, date, i2, timeUnit)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return getFragment(calendar, i2, timeUnit);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return invokeLIL.longValue;
    }

    public static long getFragmentInDays(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, date, i2)) == null) ? getFragment(date, i2, TimeUnit.DAYS) : invokeLI.longValue;
    }

    public static long getFragmentInHours(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, date, i2)) == null) ? getFragment(date, i2, TimeUnit.HOURS) : invokeLI.longValue;
    }

    public static long getFragmentInMilliseconds(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, date, i2)) == null) ? getFragment(date, i2, TimeUnit.MILLISECONDS) : invokeLI.longValue;
    }

    public static long getFragmentInMinutes(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, date, i2)) == null) ? getFragment(date, i2, TimeUnit.MINUTES) : invokeLI.longValue;
    }

    public static long getFragmentInSeconds(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, date, i2)) == null) ? getFragment(date, i2, TimeUnit.SECONDS) : invokeLI.longValue;
    }

    public static boolean isSameDay(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, date, date2)) == null) {
            if (date != null && date2 != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(date2);
                return isSameDay(calendar, calendar2);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return invokeLL.booleanValue;
    }

    public static boolean isSameInstant(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, date, date2)) == null) {
            if (date == null || date2 == null) {
                throw new IllegalArgumentException("The date must not be null");
            }
            return date.getTime() == date2.getTime();
        }
        return invokeLL.booleanValue;
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, calendar, calendar2)) == null) {
            if (calendar == null || calendar2 == null) {
                throw new IllegalArgumentException("The date must not be null");
            }
            return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
        }
        return invokeLL.booleanValue;
    }

    public static Iterator<Calendar> iterator(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65569, null, date, i2)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return iterator(calendar, i2);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Iterator) invokeLI.objValue;
    }

    public static void modify(Calendar calendar, int i2, ModifyType modifyType) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65570, null, calendar, i2, modifyType) == null) {
            if (calendar.get(1) > 280000000) {
                throw new ArithmeticException("Calendar value too large for accurate calculations");
            }
            if (i2 == 14) {
                return;
            }
            Date time = calendar.getTime();
            long time2 = time.getTime();
            int i5 = calendar.get(14);
            if (ModifyType.TRUNCATE == modifyType || i5 < 500) {
                time2 -= i5;
            }
            boolean z3 = i2 == 13;
            int i6 = calendar.get(13);
            if (!z3 && (ModifyType.TRUNCATE == modifyType || i6 < 30)) {
                time2 -= i6 * 1000;
            }
            if (i2 == 12) {
                z3 = true;
            }
            int i7 = calendar.get(12);
            if (!z3 && (ModifyType.TRUNCATE == modifyType || i7 < 30)) {
                time2 -= i7 * 60000;
            }
            if (time.getTime() != time2) {
                time.setTime(time2);
                calendar.setTime(time);
            }
            int[][] iArr = fields;
            int length = iArr.length;
            int i8 = 0;
            boolean z4 = false;
            while (i8 < length) {
                int[] iArr2 = iArr[i8];
                for (int i9 : iArr2) {
                    if (i9 == i2) {
                        if (modifyType == ModifyType.CEILING || (modifyType == ModifyType.ROUND && z4)) {
                            if (i2 == 1001) {
                                if (calendar.get(5) == 1) {
                                    calendar.add(5, 15);
                                    return;
                                }
                                calendar.add(5, -15);
                                calendar.add(2, 1);
                                return;
                            } else if (i2 == 9) {
                                if (calendar.get(11) == 0) {
                                    calendar.add(11, 12);
                                    return;
                                }
                                calendar.add(11, -12);
                                calendar.add(5, 1);
                                return;
                            } else {
                                calendar.add(iArr2[0], 1);
                                return;
                            }
                        }
                        return;
                    }
                }
                if (i2 != 9) {
                    if (i2 == 1001 && iArr2[0] == 5) {
                        i3 = calendar.get(5) - 1;
                        if (i3 >= 15) {
                            i3 -= 15;
                        }
                        z = i3 > 7;
                        i4 = i3;
                        z2 = true;
                    }
                    z = z4;
                    z2 = false;
                    i4 = 0;
                } else {
                    if (iArr2[0] == 11) {
                        i3 = calendar.get(11);
                        if (i3 >= 12) {
                            i3 -= 12;
                        }
                        z = i3 >= 6;
                        i4 = i3;
                        z2 = true;
                    }
                    z = z4;
                    z2 = false;
                    i4 = 0;
                }
                if (z2) {
                    c2 = 0;
                } else {
                    c2 = 0;
                    int actualMinimum = calendar.getActualMinimum(iArr2[0]);
                    int actualMaximum = calendar.getActualMaximum(iArr2[0]);
                    int i10 = calendar.get(iArr2[0]) - actualMinimum;
                    z = i10 > (actualMaximum - actualMinimum) / 2;
                    i4 = i10;
                }
                if (i4 != 0) {
                    calendar.set(iArr2[c2], calendar.get(iArr2[c2]) - i4);
                }
                i8++;
                z4 = z;
            }
            throw new IllegalArgumentException("The field " + i2 + " is not supported");
        }
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, strArr)) == null) ? parseDate(str, null, strArr) : (Date) invokeLL.objValue;
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, str, strArr)) == null) ? parseDateStrictly(str, null, strArr) : (Date) invokeLL.objValue;
    }

    public static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{str, locale, strArr, Boolean.valueOf(z)})) == null) {
            if (str != null && strArr != null) {
                TimeZone timeZone = TimeZone.getDefault();
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                ParsePosition parsePosition = new ParsePosition(0);
                Calendar calendar = Calendar.getInstance(timeZone, locale);
                calendar.setLenient(z);
                for (String str2 : strArr) {
                    FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale);
                    calendar.clear();
                    try {
                        if (fastDateParser.parse(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                            return calendar.getTime();
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                    parsePosition.setIndex(0);
                }
                throw new ParseException("Unable to parse the date: " + str, -1);
            }
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        return (Date) invokeCommon.objValue;
    }

    public static Date round(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65578, null, date, i2)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                modify(calendar, i2, ModifyType.ROUND);
                return calendar.getTime();
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLI.objValue;
    }

    public static Date set(Date date, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65579, null, date, i2, i3)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setLenient(false);
                calendar.setTime(date);
                calendar.set(i2, i3);
                return calendar.getTime();
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLII.objValue;
    }

    public static Date setDays(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65580, null, date, i2)) == null) ? set(date, 5, i2) : (Date) invokeLI.objValue;
    }

    public static Date setHours(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65581, null, date, i2)) == null) ? set(date, 11, i2) : (Date) invokeLI.objValue;
    }

    public static Date setMilliseconds(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65582, null, date, i2)) == null) ? set(date, 14, i2) : (Date) invokeLI.objValue;
    }

    public static Date setMinutes(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65583, null, date, i2)) == null) ? set(date, 12, i2) : (Date) invokeLI.objValue;
    }

    public static Date setMonths(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65584, null, date, i2)) == null) ? set(date, 2, i2) : (Date) invokeLI.objValue;
    }

    public static Date setSeconds(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65585, null, date, i2)) == null) ? set(date, 13, i2) : (Date) invokeLI.objValue;
    }

    public static Date setYears(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65586, null, date, i2)) == null) ? set(date, 1, i2) : (Date) invokeLI.objValue;
    }

    public static Calendar toCalendar(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, date)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
        return (Calendar) invokeL.objValue;
    }

    public static Date truncate(Date date, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65591, null, date, i2)) == null) {
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                modify(calendar, i2, ModifyType.TRUNCATE);
                return calendar.getTime();
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLI.objValue;
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65592, null, calendar, calendar2, i2)) == null) ? truncate(calendar, i2).compareTo(truncate(calendar2, i2)) : invokeLLI.intValue;
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65594, null, calendar, calendar2, i2)) == null) ? truncatedCompareTo(calendar, calendar2, i2) == 0 : invokeLLI.booleanValue;
    }

    public static long getFragmentInDays(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, calendar, i2)) == null) ? getFragment(calendar, i2, TimeUnit.DAYS) : invokeLI.longValue;
    }

    public static long getFragmentInHours(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, calendar, i2)) == null) ? getFragment(calendar, i2, TimeUnit.HOURS) : invokeLI.longValue;
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, calendar, i2)) == null) ? getFragment(calendar, i2, TimeUnit.MILLISECONDS) : invokeLI.longValue;
    }

    public static long getFragmentInMinutes(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, calendar, i2)) == null) ? getFragment(calendar, i2, TimeUnit.MINUTES) : invokeLI.longValue;
    }

    public static long getFragmentInSeconds(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, calendar, i2)) == null) ? getFragment(calendar, i2, TimeUnit.SECONDS) : invokeLI.longValue;
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65571, null, str, locale, strArr)) == null) ? parseDateWithLeniency(str, locale, strArr, true) : (Date) invokeLLL.objValue;
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65573, null, str, locale, strArr)) == null) ? parseDateWithLeniency(str, locale, strArr, false) : (Date) invokeLLL.objValue;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65595, null, date, date2, i2)) == null) ? truncatedCompareTo(date, date2, i2) == 0 : invokeLLI.booleanValue;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, calendar, calendar2)) == null) {
            if (calendar == null || calendar2 == null) {
                throw new IllegalArgumentException("The date must not be null");
            }
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        return invokeLL.booleanValue;
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, date, timeZone)) == null) {
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(date);
            return calendar;
        }
        return (Calendar) invokeLL.objValue;
    }

    public static int truncatedCompareTo(Date date, Date date2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65593, null, date, date2, i2)) == null) ? truncate(date, i2).compareTo(truncate(date2, i2)) : invokeLLI.intValue;
    }

    public static long getFragment(Calendar calendar, int i2, TimeUnit timeUnit) {
        InterceptResult invokeLIL;
        long convert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65550, null, calendar, i2, timeUnit)) == null) {
            if (calendar != null) {
                long j2 = 0;
                int i3 = timeUnit == TimeUnit.DAYS ? 0 : 1;
                if (i2 == 1) {
                    convert = timeUnit.convert(calendar.get(6) - i3, TimeUnit.DAYS);
                } else {
                    if (i2 == 2) {
                        convert = timeUnit.convert(calendar.get(5) - i3, TimeUnit.DAYS);
                    }
                    if (i2 != 1 || i2 == 2 || i2 == 5 || i2 == 6) {
                        j2 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                    } else {
                        switch (i2) {
                            case 11:
                                break;
                            case 12:
                                j2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                                break;
                            case 13:
                                break;
                            case 14:
                                return j2;
                            default:
                                throw new IllegalArgumentException("The fragment " + i2 + " is not supported");
                        }
                        return j2 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                    }
                    j2 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                    j2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                    return j2 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                }
                j2 = 0 + convert;
                if (i2 != 1) {
                }
                j2 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                j2 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                j2 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                return j2 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return invokeLIL.longValue;
    }

    public static Iterator<Calendar> iterator(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Calendar truncate;
        Calendar truncate2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65568, null, calendar, i2)) == null) {
            if (calendar != null) {
                int i4 = 2;
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        truncate = truncate(calendar, 5);
                        truncate2 = truncate(calendar, 5);
                        if (i2 != 2) {
                            if (i2 == 3) {
                                i4 = calendar.get(7);
                                i3 = i4 - 1;
                                break;
                            } else if (i2 == 4) {
                                i3 = calendar.get(7) + 3;
                                i4 = calendar.get(7) - 3;
                                break;
                            } else {
                                i3 = 7;
                                i4 = 1;
                                break;
                            }
                        }
                        i3 = 1;
                        break;
                    case 5:
                    case 6:
                        Calendar truncate3 = truncate(calendar, 2);
                        Calendar calendar2 = (Calendar) truncate3.clone();
                        calendar2.add(2, 1);
                        calendar2.add(5, -1);
                        if (i2 != 6) {
                            truncate2 = calendar2;
                            i4 = 1;
                            truncate = truncate3;
                            i3 = 7;
                            break;
                        } else {
                            truncate2 = calendar2;
                            truncate = truncate3;
                            i3 = 1;
                            break;
                        }
                    default:
                        throw new IllegalArgumentException("The range style " + i2 + " is not valid.");
                }
                if (i4 < 1) {
                    i4 += 7;
                }
                if (i4 > 7) {
                    i4 -= 7;
                }
                if (i3 < 1) {
                    i3 += 7;
                }
                if (i3 > 7) {
                    i3 -= 7;
                }
                while (truncate.get(7) != i4) {
                    truncate.add(5, -1);
                }
                while (truncate2.get(7) != i3) {
                    truncate2.add(5, 1);
                }
                return new DateIterator(truncate, truncate2);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Iterator) invokeLI.objValue;
    }

    public static Calendar ceiling(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, calendar, i2)) == null) {
            if (calendar != null) {
                Calendar calendar2 = (Calendar) calendar.clone();
                modify(calendar2, i2, ModifyType.CEILING);
                return calendar2;
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Calendar) invokeLI.objValue;
    }

    public static Calendar round(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65576, null, calendar, i2)) == null) {
            if (calendar != null) {
                Calendar calendar2 = (Calendar) calendar.clone();
                modify(calendar2, i2, ModifyType.ROUND);
                return calendar2;
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Calendar) invokeLI.objValue;
    }

    public static Calendar truncate(Calendar calendar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65589, null, calendar, i2)) == null) {
            if (calendar != null) {
                Calendar calendar2 = (Calendar) calendar.clone();
                modify(calendar2, i2, ModifyType.TRUNCATE);
                return calendar2;
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Calendar) invokeLI.objValue;
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, calendar, calendar2)) == null) {
            if (calendar == null || calendar2 == null) {
                throw new IllegalArgumentException("The date must not be null");
            }
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeLL.booleanValue;
    }

    public static Date ceiling(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, obj, i2)) == null) {
            if (obj != null) {
                if (obj instanceof Date) {
                    return ceiling((Date) obj, i2);
                }
                if (obj instanceof Calendar) {
                    return ceiling((Calendar) obj, i2).getTime();
                }
                throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLI.objValue;
    }

    public static Date round(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65577, null, obj, i2)) == null) {
            if (obj != null) {
                if (obj instanceof Date) {
                    return round((Date) obj, i2);
                }
                if (obj instanceof Calendar) {
                    return round((Calendar) obj, i2).getTime();
                }
                throw new ClassCastException("Could not round " + obj);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLI.objValue;
    }

    public static Date truncate(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65590, null, obj, i2)) == null) {
            if (obj != null) {
                if (obj instanceof Date) {
                    return truncate((Date) obj, i2);
                }
                if (obj instanceof Calendar) {
                    return truncate((Calendar) obj, i2).getTime();
                }
                throw new ClassCastException("Could not truncate " + obj);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Date) invokeLI.objValue;
    }

    public static Iterator<?> iterator(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, obj, i2)) == null) {
            if (obj != null) {
                if (obj instanceof Date) {
                    return iterator((Date) obj, i2);
                }
                if (obj instanceof Calendar) {
                    return iterator((Calendar) obj, i2);
                }
                throw new ClassCastException("Could not iterate based on " + obj);
            }
            throw new IllegalArgumentException("The date must not be null");
        }
        return (Iterator) invokeLI.objValue;
    }
}
