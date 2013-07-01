package com.google.gson.internal.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public final class v extends com.google.gson.aa {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.gson.ab f1640a = new w();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    /* renamed from: a */
    public synchronized Time b(com.google.gson.stream.a aVar) {
        Time time;
        if (aVar.f() == JsonToken.NULL) {
            aVar.j();
            time = null;
        } else {
            try {
                time = new Time(this.b.parse(aVar.h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.aa
    public synchronized void a(com.google.gson.stream.d dVar, Time time) {
        dVar.b(time == null ? null : this.b.format((Date) time));
    }
}
