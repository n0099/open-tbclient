package com.google.gson.internal.a;

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
/* loaded from: classes7.dex */
public final class k extends TypeAdapter<Time> {
    public static final TypeAdapterFactory mDH = new TypeAdapterFactory() { // from class: com.google.gson.internal.a.k.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.dDr() == Time.class) {
                return new k();
            }
            return null;
        }
    };
    private final DateFormat mEj = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: e */
    public synchronized Time read(com.google.gson.stream.a aVar) throws IOException {
        Time time;
        if (aVar.dCY() == JsonToken.NULL) {
            aVar.dDd();
            time = null;
        } else {
            try {
                time = new Time(this.mEj.parse(aVar.dDc()).getTime());
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
        bVar.Qp(time == null ? null : this.mEj.format((Date) time));
    }
}
