package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonToken;
import d.g.d.b.c;
import d.g.d.b.f;
import d.g.d.c.a;
import d.g.d.d.b;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final TypeAdapterFactory f31237b = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final List<DateFormat> f31238a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f31238a = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f31238a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (c.e()) {
            this.f31238a.add(f.e(2, 2));
        }
    }

    public final synchronized Date deserializeToDate(String str) {
        for (DateFormat dateFormat : this.f31238a) {
            try {
                return dateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return d.g.d.b.j.c.a.c(str, new ParsePosition(0));
        } catch (ParseException e2) {
            throw new JsonSyntaxException(str, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public Date read(d.g.d.d.a aVar) throws IOException {
        if (aVar.M() == JsonToken.NULL) {
            aVar.I();
            return null;
        }
        return deserializeToDate(aVar.K());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public synchronized void write(b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.B();
        } else {
            bVar.O(this.f31238a.get(0).format(date));
        }
    }
}
