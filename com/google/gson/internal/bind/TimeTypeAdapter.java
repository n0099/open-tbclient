package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import d.g.d.c.a;
import d.g.d.d.b;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    /* renamed from: b  reason: collision with root package name */
    public static final TypeAdapterFactory f31265b = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, a<T> aVar) {
            if (aVar.c() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final DateFormat f31266a = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a */
    public synchronized Time read(d.g.d.d.a aVar) throws IOException {
        if (aVar.M() == JsonToken.NULL) {
            aVar.I();
            return null;
        }
        try {
            return new Time(this.f31266a.parse(aVar.K()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: b */
    public synchronized void write(b bVar, Time time) throws IOException {
        bVar.O(time == null ? null : this.f31266a.format((Date) time));
    }
}
