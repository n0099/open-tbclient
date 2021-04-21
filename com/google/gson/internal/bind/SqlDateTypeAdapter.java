package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import d.h.d.c.a;
import d.h.d.d.b;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes6.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final TypeAdapterFactory f31358b = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final DateFormat f31359a = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a */
    public synchronized Date read(d.h.d.d.a aVar) throws IOException {
        if (aVar.M() == JsonToken.NULL) {
            aVar.I();
            return null;
        }
        try {
            return new Date(this.f31359a.parse(aVar.K()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: b */
    public synchronized void write(b bVar, Date date) throws IOException {
        bVar.O(date == null ? null : this.f31359a.format((java.util.Date) date));
    }
}
