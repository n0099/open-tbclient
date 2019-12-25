package com.dd.plist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public class f extends i {
    private static final SimpleDateFormat lCr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final SimpleDateFormat lCs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    private Date date;

    static {
        lCr.setTimeZone(TimeZone.getTimeZone("GMT"));
        lCs.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    private static synchronized Date Oi(String str) throws ParseException {
        Date parse;
        synchronized (f.class) {
            try {
                parse = lCr.parse(str);
            } catch (ParseException e) {
                parse = lCs.parse(str);
            }
        }
        return parse;
    }

    public f(byte[] bArr) {
        this.date = new Date(978307200000L + ((long) (1000.0d * c.ad(bArr))));
    }

    public f(String str) throws ParseException {
        this.date = Oi(str);
    }

    public f(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && this.date.equals(((f) obj).getDate());
    }

    public int hashCode() {
        return this.date.hashCode();
    }

    public String toString() {
        return this.date.toString();
    }
}
