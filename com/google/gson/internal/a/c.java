package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class c extends n<Date> {
    public static final o koQ = new o() { // from class: com.google.gson.internal.a.c.1
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cMT() == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final DateFormat koV = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat koW = DateFormat.getDateTimeInstance(2, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.n
    public synchronized void a(com.google.gson.stream.a aVar, Date date) throws IOException {
        if (date == null) {
            aVar.cMS();
        } else {
            aVar.HY(this.koV.format(date));
        }
    }
}
