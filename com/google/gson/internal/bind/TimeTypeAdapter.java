package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes17.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory pdR = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.etp() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat pet = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: e */
    public synchronized Time read(com.google.gson.stream.a aVar) throws IOException {
        Time time;
        if (aVar.esW() == JsonToken.NULL) {
            aVar.etb();
            time = null;
        } else {
            try {
                time = new Time(this.pet.parse(aVar.eta()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a */
    public synchronized void write(com.google.gson.stream.b bVar, Time time) throws IOException {
        bVar.YA(time == null ? null : this.pet.format((Date) time));
    }
}
