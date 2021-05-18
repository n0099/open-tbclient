package com.bytedance.sdk.openadsdk.preload.a;

import com.baidu.android.common.others.lang.StringUtil;
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
public final class a extends v<Date> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends Date> f29745a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DateFormat> f29746b = new ArrayList();

    public a(Class<? extends Date> cls, String str) {
        this.f29745a = a(cls);
        this.f29746b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f29746b.add(new SimpleDateFormat(str));
    }

    public String toString() {
        DateFormat dateFormat = this.f29746b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + StringUtil.ARRAY_ELEMENT_SEPARATOR + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
            return;
        }
        synchronized (this.f29746b) {
            cVar.b(this.f29746b.get(0).format(date));
        }
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        this.f29745a = a(cls);
        this.f29746b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f29746b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (com.bytedance.sdk.openadsdk.preload.a.b.e.b()) {
            this.f29746b.add(com.bytedance.sdk.openadsdk.preload.a.b.j.a(i2, i3));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    /* renamed from: a */
    public Date b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        Date a2 = a(aVar.h());
        Class<? extends Date> cls = this.f29745a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }

    private Date a(String str) {
        synchronized (this.f29746b) {
            for (DateFormat dateFormat : this.f29746b) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.bytedance.sdk.openadsdk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new t(str, e2);
            }
        }
    }
}
