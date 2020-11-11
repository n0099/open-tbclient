package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes17.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory pdR = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
            if (aVar.etp() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };
    private final List<DateFormat> dateFormats = new ArrayList();

    public DateTypeAdapter() {
        this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (c.esK()) {
            this.dateFormats.add(f.eh(2, 2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.esW() == JsonToken.NULL) {
            aVar.etb();
            return null;
        }
        return deserializeToDate(aVar.eta());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = com.google.gson.internal.bind.a.a.a(r3, new java.text.ParsePosition(0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized Date deserializeToDate(String str) {
        Date a2;
        Iterator<DateFormat> it = this.dateFormats.iterator();
        while (true) {
            if (it.hasNext()) {
                try {
                    a2 = it.next().parse(str);
                    break;
                } catch (ParseException e) {
                }
            } else {
                try {
                    break;
                } catch (ParseException e2) {
                    throw new JsonSyntaxException(str, e2);
                }
            }
        }
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public synchronized void write(com.google.gson.stream.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.etl();
        } else {
            bVar.YA(this.dateFormats.get(0).format(date));
        }
    }
}
