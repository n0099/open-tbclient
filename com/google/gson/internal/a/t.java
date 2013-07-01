package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
public final class t extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.ab f1639a = new u();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public synchronized Date b(com.google.gson.stream.a aVar) {
        Date date;
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            date = null;
        } else {
            try {
                date = new Date(this.b.parse(aVar.h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public synchronized void a(com.google.gson.stream.d dVar, Date date) {
        dVar.b(date == null ? null : this.b.format((java.util.Date) date));
    }
}
