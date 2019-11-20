package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public final class i extends n<Date> {
    public static final o koI = new o() { // from class: com.google.gson.internal.a.i.1
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cKC() == Date.class) {
                return new i();
            }
            return null;
        }
    };
    private final DateFormat kpi = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.n
    public synchronized void a(com.google.gson.stream.a aVar, Date date) throws IOException {
        aVar.GP(date == null ? null : this.kpi.format((java.util.Date) date));
    }
}
