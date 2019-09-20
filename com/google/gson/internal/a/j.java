package com.google.gson.internal.a;

import com.google.gson.n;
import com.google.gson.o;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public final class j extends n<Time> {
    public static final o krn = new o() { // from class: com.google.gson.internal.a.j.1
        @Override // com.google.gson.o
        public <T> n<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cNH() == Time.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat krN = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.n
    public synchronized void a(com.google.gson.stream.a aVar, Time time) throws IOException {
        aVar.Iy(time == null ? null : this.krN.format((Date) time));
    }
}
