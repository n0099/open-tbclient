package com.google.gson.internal.a;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public final class c extends m<Date> {
    public static final n hOD = new n() { // from class: com.google.gson.internal.a.c.1
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bNi() == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final DateFormat hOI = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat hOJ = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat hOK = bMZ();

    private static DateFormat bMZ() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.m
    public synchronized void a(com.google.gson.stream.a aVar, Date date) throws IOException {
        if (date == null) {
            aVar.bNg();
        } else {
            aVar.xq(this.hOI.format(date));
        }
    }
}
