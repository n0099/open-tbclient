package com.google.gson.internal.a;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public final class h extends m<Date> {
    public static final n hNE = new n() { // from class: com.google.gson.internal.a.h.1
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bOH() == Date.class) {
                return new h();
            }
            return null;
        }
    };
    private final DateFormat hOg = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.m
    public synchronized void a(com.google.gson.stream.a aVar, Date date) throws IOException {
        aVar.xy(date == null ? null : this.hOg.format((java.util.Date) date));
    }
}
