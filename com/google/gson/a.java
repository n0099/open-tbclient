package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
final class a implements q, w {

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f1610a;
    private final DateFormat b;
    private final DateFormat c;

    a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f1610a = dateFormat;
        this.b = dateFormat2;
        this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.w
    public r a(Date date, Type type, v vVar) {
        u uVar;
        synchronized (this.b) {
            uVar = new u(this.f1610a.format(date));
        }
        return uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.q
    /* renamed from: a */
    public Date b(r rVar, Type type, p pVar) {
        if (!(rVar instanceof u)) {
            throw new JsonParseException("The date should be a string value");
        }
        Date a2 = a(rVar);
        if (type != Date.class) {
            if (type == Timestamp.class) {
                return new Timestamp(a2.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a2.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        return a2;
    }

    private Date a(r rVar) {
        Date parse;
        synchronized (this.b) {
            try {
                parse = this.b.parse(rVar.b());
            } catch (ParseException e) {
                try {
                    parse = this.f1610a.parse(rVar.b());
                } catch (ParseException e2) {
                    try {
                        parse = this.c.parse(rVar.b());
                    } catch (ParseException e3) {
                        throw new JsonSyntaxException(rVar.b(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(a.class.getSimpleName());
        sb.append('(').append(this.b.getClass().getSimpleName()).append(')');
        return sb.toString();
    }
}
