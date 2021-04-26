package com.google.zxing.client.result;

import com.baidu.webkit.sdk.VideoCloudSetting;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class CalendarParsedResult extends ParsedResult {
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
    public static final Pattern RFC2445_DURATION = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    public static final long[] RFC2445_DURATION_FIELD_UNITS = {604800000, 86400000, VideoCloudSetting.HOUR_MILLISECOND, 60000, 1000};
    public static final Pattern DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(ParsedResultType.CALENDAR);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static DateFormat buildDateTimeFormat() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    public static String format(boolean z, Date date) {
        DateFormat dateTimeInstance;
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

    public static Date parseDate(String str) throws ParseException {
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

    public static long parseDurationMS(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = RFC2445_DURATION.matcher(charSequence);
        if (matcher.matches()) {
            long j = 0;
            int i2 = 0;
            while (i2 < RFC2445_DURATION_FIELD_UNITS.length) {
                int i3 = i2 + 1;
                String group = matcher.group(i3);
                if (group != null) {
                    j += RFC2445_DURATION_FIELD_UNITS[i2] * Integer.parseInt(group);
                }
                i2 = i3;
            }
            return j;
        }
        return -1L;
    }

    public String[] getAttendees() {
        return this.attendees;
    }

    public String getDescription() {
        return this.description;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
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

    public Date getEnd() {
        return this.end;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocation() {
        return this.location;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public Date getStart() {
        return this.start;
    }

    public String getSummary() {
        return this.summary;
    }

    public boolean isEndAllDay() {
        return this.endAllDay;
    }

    public boolean isStartAllDay() {
        return this.startAllDay;
    }
}
