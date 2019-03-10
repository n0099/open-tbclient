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
    public static final p jOF = new p() { // from class: com.google.gson.internal.a.j.1
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cBG() == Date.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat jPn = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    /* renamed from: l */
    public synchronized Date b(com.google.gson.stream.a aVar) throws IOException {
        Date date;
        if (aVar.cBu() == JsonToken.NULL) {
            aVar.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.jPn.parse(aVar.nextString()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    public synchronized void a(com.google.gson.stream.b bVar, Date date) throws IOException {
        bVar.FT(date == null ? null : this.jPn.format((java.util.Date) date));
    }
}
