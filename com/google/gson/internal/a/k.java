package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public final class k extends o<Time> {
    public static final p iln = new p() { // from class: com.google.gson.internal.a.k.1
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.bZq() == Time.class) {
                return new k();
            }
            return null;
        }
    };
    private final DateFormat ilV = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    /* renamed from: m */
    public synchronized Time b(com.google.gson.stream.a aVar) throws IOException {
        Time time;
        if (aVar.bZe() == JsonToken.NULL) {
            aVar.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.ilV.parse(aVar.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    public synchronized void a(com.google.gson.stream.b bVar, Time time) throws IOException {
        bVar.yM(time == null ? null : this.ilV.format((Date) time));
    }
}
