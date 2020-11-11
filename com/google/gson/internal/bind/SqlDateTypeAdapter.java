package com.google.gson.internal.bind;

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
/* loaded from: classes17.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory pdR = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.etp() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat pet = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: d */
    public synchronized Date read(com.google.gson.stream.a aVar) throws IOException {
        Date date;
        if (aVar.esW() == JsonToken.NULL) {
            aVar.etb();
            date = null;
        } else {
            try {
                date = new Date(this.pet.parse(aVar.eta()).getTime());
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
        bVar.YA(date == null ? null : this.pet.format((java.util.Date) date));
    }
}
