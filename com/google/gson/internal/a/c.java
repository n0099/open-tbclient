package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class c extends o<Date> {
    public static final p jOm = new p() { // from class: com.google.gson.internal.a.c.1
        @Override // com.google.gson.p
        public <T> o<T> a(com.google.gson.d dVar, com.google.gson.b.a<T> aVar) {
            if (aVar.cBw() == Date.class) {
                return new c();
            }
            return null;
        }
    };
    private final DateFormat jOr = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat jOs = DateFormat.getDateTimeInstance(2, 2);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    /* renamed from: j */
    public Date b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.cBk() == JsonToken.NULL) {
            aVar.nextNull();
            return null;
        }
        return FO(aVar.nextString());
    }

    private synchronized Date FO(String str) {
        Date parse;
        try {
            parse = this.jOs.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.jOr.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = com.google.gson.internal.a.a.a.parse(str, new ParsePosition(0));
                } catch (ParseException e3) {
                    throw new JsonSyntaxException(str, e3);
                }
            }
        }
        return parse;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.o
    public synchronized void a(com.google.gson.stream.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.cBv();
        } else {
            bVar.FQ(this.jOr.format(date));
        }
    }
}
