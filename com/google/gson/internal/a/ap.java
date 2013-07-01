package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* loaded from: classes.dex */
final class ap extends com.google.gson.aa {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public Calendar b(com.google.gson.stream.a aVar) {
        int i = 0;
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            return null;
        }
        aVar.c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (aVar.f() != JsonToken.END_OBJECT) {
            String g = aVar.g();
            int m = aVar.m();
            if ("year".equals(g)) {
                i6 = m;
            } else if ("month".equals(g)) {
                i5 = m;
            } else if ("dayOfMonth".equals(g)) {
                i4 = m;
            } else if ("hourOfDay".equals(g)) {
                i3 = m;
            } else if ("minute".equals(g)) {
                i2 = m;
            } else if ("second".equals(g)) {
                i = m;
            }
        }
        aVar.d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public void a(com.google.gson.stream.d dVar, Calendar calendar) {
        if (calendar == null) {
            dVar.f();
            return;
        }
        dVar.d();
        dVar.a("year");
        dVar.a(calendar.get(1));
        dVar.a("month");
        dVar.a(calendar.get(2));
        dVar.a("dayOfMonth");
        dVar.a(calendar.get(5));
        dVar.a("hourOfDay");
        dVar.a(calendar.get(11));
        dVar.a("minute");
        dVar.a(calendar.get(12));
        dVar.a("second");
        dVar.a(calendar.get(13));
        dVar.e();
    }
}
