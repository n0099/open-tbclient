package com.google.gson;

import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes17.dex */
final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;

    DefaultDateTypeAdapter(Class<? extends Date> cls) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (c.esK()) {
            this.dateFormats.add(f.eh(2, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(str));
        }
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, int i) {
        this.dateFormats = new ArrayList();
        this.dateType = verifyDateType(cls);
        this.dateFormats.add(DateFormat.getDateInstance(i, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateInstance(i));
        }
        if (c.esK()) {
            this.dateFormats.add(f.Qq(i));
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
        if (c.esK()) {
            this.dateFormats.add(f.eh(i, i2));
        }
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> cls) {
        if (cls != Date.class && cls != java.sql.Date.class && cls != Timestamp.class) {
            throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
        }
        return cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.etl();
            return;
        }
        synchronized (this.dateFormats) {
            bVar.YA(this.dateFormats.get(0).format(date));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public Date read(a aVar) throws IOException {
        if (aVar.esW() == JsonToken.NULL) {
            aVar.etb();
            return null;
        }
        Date deserializeToDate = deserializeToDate(aVar.eta());
        if (this.dateType != Date.class) {
            if (this.dateType == Timestamp.class) {
                return new Timestamp(deserializeToDate.getTime());
            }
            if (this.dateType == java.sql.Date.class) {
                return new java.sql.Date(deserializeToDate.getTime());
            }
            throw new AssertionError();
        }
        return deserializeToDate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = com.google.gson.internal.bind.a.a.a(r4, new java.text.ParsePosition(0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Date deserializeToDate(String str) {
        Date a2;
        synchronized (this.dateFormats) {
            Iterator<DateFormat> it = this.dateFormats.iterator();
            while (true) {
                if (it.hasNext()) {
                    try {
                        a2 = it.next().parse(str);
                        break;
                    } catch (ParseException e) {
                    }
                } else {
                    try {
                        break;
                    } catch (ParseException e2) {
                        throw new JsonSyntaxException(str, e2);
                    }
                }
            }
        }
        return a2;
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        return dateFormat instanceof SimpleDateFormat ? "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')' : "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
