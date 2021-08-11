package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(ParsedResultType.CALENDAR);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, strArr, str7, Double.valueOf(d2), Double.valueOf(d3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                this.end = parseDurationMS < 0 ? null : new Date(this.start.getTime() + parseDurationMS);
            } else {
                try {
                    this.end = parseDate(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = true;
            this.startAllDay = str2.length() == 8;
            this.endAllDay = (str3 == null || str3.length() != 8) ? false : false;
            this.location = str5;
            this.organizer = str6;
            this.attendees = strArr;
            this.description = str7;
            this.latitude = d2;
            this.longitude = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH) : (DateFormat) invokeV.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, charSequence)) == null) {
            if (charSequence == null) {
                return -1L;
            }
            Matcher matcher = RFC2445_DURATION.matcher(charSequence);
            if (matcher.matches()) {
                long j2 = 0;
                int i2 = 0;
                while (i2 < RFC2445_DURATION_FIELD_UNITS.length) {
                    int i3 = i2 + 1;
                    String group = matcher.group(i3);
                    if (group != null) {
                        j2 += RFC2445_DURATION_FIELD_UNITS[i2] * Integer.parseInt(group);
                    }
                    i2 = i3;
                }
                return j2;
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public String[] getAttendees() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.attendees : (String[]) invokeV.objValue;
    }

    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.description : (String) invokeV.objValue;
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

    public Date getEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.end : (Date) invokeV.objValue;
    }

    public double getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.latitude : invokeV.doubleValue;
    }

    public String getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.location : (String) invokeV.objValue;
    }

    public double getLongitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.longitude : invokeV.doubleValue;
    }

    public String getOrganizer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.organizer : (String) invokeV.objValue;
    }

    public Date getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.start : (Date) invokeV.objValue;
    }

    public String getSummary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.summary : (String) invokeV.objValue;
    }

    public boolean isEndAllDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.endAllDay : invokeV.booleanValue;
    }

    public boolean isStartAllDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.startAllDay : invokeV.booleanValue;
    }
}
