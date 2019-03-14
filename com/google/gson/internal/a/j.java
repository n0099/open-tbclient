package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public final class j extends o<Date> {
    public static final p jOx = new p() { // from class: com.google.gson.internal.a.j.1
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cBJ() == Date.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat jPf = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    /* renamed from: l */
    public synchronized Date b(com.google.gson.stream.a aVar) throws IOException {
        Date date;
        if (aVar.cBx() == JsonToken.NULL) {
            aVar.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.jPf.parse(aVar.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    public synchronized void a(com.google.gson.stream.b bVar, Date date) throws IOException {
        bVar.FR(date == null ? null : this.jPf.format((java.util.Date) date));
    }
}
