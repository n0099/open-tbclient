package com.google.zxing.client.result;

import com.tencent.mm.sdk.platformtools.Util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class g extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2846a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] b = {604800000, Util.MILLSECONDS_OF_DAY, Util.MILLSECONDS_OF_HOUR, Util.MILLSECONDS_OF_MINUTE, 1000};
    private static final Pattern c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    private static final DateFormat d = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    private static final DateFormat e;
    private final String f;
    private final Date g;
    private final boolean h;
    private final Date i;
    private final boolean j;
    private final String k;
    private final String l;
    private final String[] m;
    private final String n;
    private final double o;
    private final double p;

    static {
        d.setTimeZone(TimeZone.getTimeZone("GMT"));
        e = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(ParsedResultType.CALENDAR);
        this.f = str;
        try {
            this.g = a(str2);
            if (str3 == null) {
                long a2 = a((CharSequence) str4);
                this.i = a2 < 0 ? null : new Date(a2 + this.g.getTime());
            } else {
                try {
                    this.i = a(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            this.h = str2.length() == 8;
            this.j = str3 != null && str3.length() == 8;
            this.k = str5;
            this.l = str6;
            this.m = strArr;
            this.n = str7;
            this.o = d2;
            this.p = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f, sb);
        a(a(this.h, this.g), sb);
        a(a(this.j, this.i), sb);
        a(this.k, sb);
        a(this.l, sb);
        a(this.m, sb);
        a(this.n, sb);
        return sb.toString();
    }

    private static Date a(String str) {
        if (!c.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            return d.parse(str);
        }
        if (str.length() == 16 && str.charAt(15) == 'Z') {
            Date parse = e.parse(str.substring(0, 15));
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            long time = parse.getTime() + gregorianCalendar.get(15);
            gregorianCalendar.setTime(new Date(time));
            return new Date(time + gregorianCalendar.get(16));
        }
        return e.parse(str);
    }

    private static String a(boolean z, Date date) {
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

    private static long a(CharSequence charSequence) {
        long j = -1;
        if (charSequence != null) {
            Matcher matcher = f2846a.matcher(charSequence);
            if (matcher.matches()) {
                j = 0;
                for (int i = 0; i < b.length; i++) {
                    String group = matcher.group(i + 1);
                    if (group != null) {
                        j += b[i] * Integer.parseInt(group);
                    }
                }
            }
        }
        return j;
    }
}
