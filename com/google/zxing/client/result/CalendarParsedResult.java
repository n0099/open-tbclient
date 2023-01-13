package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class CalendarParsedResult extends ParsedResult {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern DATE_TIME;
    public static final Pattern RFC2445_DURATION;
    public static final long[] RFC2445_DURATION_FIELD_UNITS;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] attendees;
    public final String description;
    public final Date end;
    public final boolean endAllDay;
    public final double latitude;
    public final String location;
    public final double longitude;
    public final String organizer;
    public final Date start;
    public final boolean startAllDay;
    public final String summary;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2063781658, "Lcom/google/zxing/client/result/CalendarParsedResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2063781658, "Lcom/google/zxing/client/result/CalendarParsedResult;");
                return;
            }
        }
        RFC2445_DURATION = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
        RFC2445_DURATION_FIELD_UNITS = new long[]{604800000, 86400000, 3600000, 60000, 1000};
        DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder(100);
            ParsedResult.maybeAppend(this.summary, sb);
            ParsedResult.maybeAppend(format(this.startAllDay, this.start), sb);
            ParsedResult.maybeAppend(format(this.endAllDay, this.end), sb);
            ParsedResult.maybeAppend(this.location, sb);
            ParsedResult.maybeAppend(this.organizer, sb);
            ParsedResult.maybeAppend(this.attendees, sb);
            ParsedResult.maybeAppend(this.description, sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d, double d2) {
        super(ParsedResultType.CALENDAR);
        boolean z;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, strArr, str7, Double.valueOf(d), Double.valueOf(d2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ParsedResultType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.summary = str;
        try {
            this.start = parseDate(str2);
            if (str3 == null) {
                long parseDurationMS = parseDurationMS(str4);
                if (parseDurationMS < 0) {
                    date = null;
                } else {
                    date = new Date(this.start.getTime() + parseDurationMS);
                }
                this.end = date;
            } else {
                try {
                    this.end = parseDate(str3);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e.toString());
                }
            }
            boolean z2 = true;
            if (str2.length() == 8) {
                z = true;
            } else {
                z = false;
            }
            this.startAllDay = z;
            this.endAllDay = (str3 == null || str3.length() != 8) ? false : false;
            this.location = str5;
            this.organizer = str6;
            this.attendees = strArr;
            this.description = str7;
            this.latitude = d;
            this.longitude = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    public static DateFormat buildDateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
        return (DateFormat) invokeV.objValue;
    }

    public static DateFormat buildDateTimeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
        }
        return (DateFormat) invokeV.objValue;
    }

    public String[] getAttendees() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.attendees;
        }
        return (String[]) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.description;
        }
        return (String) invokeV.objValue;
    }

    public Date getEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.end;
        }
        return (Date) invokeV.objValue;
    }

    public double getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.latitude;
        }
        return invokeV.doubleValue;
    }

    public String getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.location;
        }
        return (String) invokeV.objValue;
    }

    public double getLongitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.longitude;
        }
        return invokeV.doubleValue;
    }

    public String getOrganizer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.organizer;
        }
        return (String) invokeV.objValue;
    }

    public Date getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.start;
        }
        return (Date) invokeV.objValue;
    }

    public String getSummary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.summary;
        }
        return (String) invokeV.objValue;
    }

    public boolean isEndAllDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.endAllDay;
        }
        return invokeV.booleanValue;
    }

    public boolean isStartAllDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.startAllDay;
        }
        return invokeV.booleanValue;
    }

    public static String format(boolean z, Date date) {
        InterceptResult invokeZL;
        DateFormat dateTimeInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, null, z, date)) == null) {
            if (date == null) {
                return null;
            }
            if (z) {
                dateTimeInstance = DateFormat.getDateInstance(2);
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
            }
            return dateTimeInstance.format(date);
        }
        return (String) invokeZL.objValue;
    }

    public static Date parseDate(String str) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (DATE_TIME.matcher(str).matches()) {
                if (str.length() == 8) {
                    return buildDateFormat().parse(str);
                }
                if (str.length() == 16 && str.charAt(15) == 'Z') {
                    Date parse = buildDateTimeFormat().parse(str.substring(0, 15));
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    long time = parse.getTime() + gregorianCalendar.get(15);
                    gregorianCalendar.setTime(new Date(time));
                    return new Date(time + gregorianCalendar.get(16));
                }
                return buildDateTimeFormat().parse(str);
            }
            throw new ParseException(str, 0);
        }
        return (Date) invokeL.objValue;
    }

    public static long parseDurationMS(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, charSequence)) == null) {
            if (charSequence == null) {
                return -1L;
            }
            Matcher matcher = RFC2445_DURATION.matcher(charSequence);
            if (!matcher.matches()) {
                return -1L;
            }
            long j = 0;
            int i = 0;
            while (i < RFC2445_DURATION_FIELD_UNITS.length) {
                int i2 = i + 1;
                String group = matcher.group(i2);
                if (group != null) {
                    j += RFC2445_DURATION_FIELD_UNITS[i] * Integer.parseInt(group);
                }
                i = i2;
            }
            return j;
        }
        return invokeL.longValue;
    }
}
