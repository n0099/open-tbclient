package com.bytedance.sdk.openadsdk.preload.a;

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
/* loaded from: classes6.dex */
final class a extends v<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Date> f4953a;
    private final List<DateFormat> b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Class<? extends Date> cls, String str) {
        this.f4953a = a(cls);
        this.b.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.b.add(new SimpleDateFormat(str));
        }
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        this.f4953a = a(cls);
        this.b.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.b.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (com.bytedance.sdk.openadsdk.preload.a.b.e.b()) {
            this.b.add(com.bytedance.sdk.openadsdk.preload.a.b.j.a(i, i2));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls != Date.class && cls != java.sql.Date.class && cls != Timestamp.class) {
            throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
        }
        return cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
            return;
        }
        synchronized (this.b) {
            cVar.b(this.b.get(0).format(date));
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
        if (this.f4953a != Date.class) {
            if (this.f4953a == Timestamp.class) {
                return new Timestamp(a2.getTime());
            }
            if (this.f4953a == java.sql.Date.class) {
                return new java.sql.Date(a2.getTime());
            }
            throw new AssertionError();
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        r0 = com.bytedance.sdk.openadsdk.preload.a.b.a.a.a.a(r4, new java.text.ParsePosition(0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Date a(String str) {
        Date a2;
        synchronized (this.b) {
            Iterator<DateFormat> it = this.b.iterator();
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
                        throw new t(str, e2);
                    }
                }
            }
        }
        return a2;
    }

    public String toString() {
        DateFormat dateFormat = this.b.get(0);
        return dateFormat instanceof SimpleDateFormat ? "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')' : "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
