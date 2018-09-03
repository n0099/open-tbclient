package com.google.gson.internal.a;

import com.google.gson.m;
import com.google.gson.n;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public final class i extends m<Time> {
    public static final n hGj = new n() { // from class: com.google.gson.internal.a.i.1
        @Override // com.google.gson.n
        public <T> m<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bKr() == Time.class) {
                return new i();
            }
            return null;
        }
    };
    private final DateFormat hGL = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.m
    public synchronized void a(com.google.gson.stream.a aVar, Time time) throws IOException {
        aVar.wF(time == null ? null : this.hGL.format((Date) time));
    }
}
