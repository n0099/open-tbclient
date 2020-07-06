package com.google.gson.internal.a;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes7.dex */
public final class j extends TypeAdapter<Date> {
    public static final TypeAdapterFactory naX = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.j.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.dIl() == Date.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat nbz = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: d */
    public synchronized Date read(com.google.gson.stream.a aVar) throws IOException {
        Date date;
        if (aVar.dHS() == JsonToken.NULL) {
            aVar.dHX();
            date = null;
        } else {
            try {
                date = new Date(this.nbz.parse(aVar.dHW()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a */
    public synchronized void write(com.google.gson.stream.b bVar, Date date) throws IOException {
        bVar.Rd(date == null ? null : this.nbz.format((java.util.Date) date));
    }
}
