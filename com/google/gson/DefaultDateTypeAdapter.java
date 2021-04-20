package com.google.gson;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.gson.stream.JsonToken;
import d.g.d.b.c;
import d.g.d.b.f;
import d.g.d.b.j.c.a;
import d.g.d.d.b;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    public static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    public final List<DateFormat> dateFormats;
    public final Class<? extends Date> dateType;

    public DefaultDateTypeAdapter(Class<? extends Date> cls) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (c.e()) {
            this.dateFormats.add(f.e(2, 2));
        }
    }

    private Date deserializeToDate(String str) {
        synchronized (this.dateFormats) {
            for (DateFormat dateFormat : this.dateFormats) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return a.c(str, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException(str, e2);
            }
        }
    }

    public static Class<? extends Date> verifyDateType(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + StringUtil.ARRAY_ELEMENT_SEPARATOR + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public Date read(d.g.d.d.a aVar) throws IOException {
        if (aVar.M() == JsonToken.NULL) {
            aVar.I();
            return null;
        }
        Date deserializeToDate = deserializeToDate(aVar.K());
        Class<? extends Date> cls = this.dateType;
        if (cls == Date.class) {
            return deserializeToDate;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(deserializeToDate.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        throw new AssertionError();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.B();
            return;
        }
        synchronized (this.dateFormats) {
            bVar.O(this.dateFormats.get(0).format(date));
        }
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.dateFormats.add(new SimpleDateFormat(str));
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateInstance(i, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(i));
        }
        if (c.e()) {
            this.dateFormats.add(f.d(i));
        }
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(Date.class, i, i2);
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (c.e()) {
            this.dateFormats.add(f.e(i, i2));
        }
    }
}
