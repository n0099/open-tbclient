package com.google.gson.internal.a;

import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class g extends com.google.gson.stream.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Reader f1630a = new h();
    private static final Object b = new Object();
    private final List c;

    @Override // com.google.gson.stream.a
    public void a() {
        a(JsonToken.BEGIN_ARRAY);
        this.c.add(((com.google.gson.o) q()).iterator());
    }

    @Override // com.google.gson.stream.a
    public void b() {
        a(JsonToken.END_ARRAY);
        r();
        r();
    }

    @Override // com.google.gson.stream.a
    public void c() {
        a(JsonToken.BEGIN_OBJECT);
        this.c.add(((com.google.gson.t) q()).o().iterator());
    }

    @Override // com.google.gson.stream.a
    public void d() {
        a(JsonToken.END_OBJECT);
        r();
        r();
    }

    @Override // com.google.gson.stream.a
    public boolean e() {
        JsonToken f = f();
        return (f == JsonToken.END_OBJECT || f == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public JsonToken f() {
        if (this.c.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object q = q();
        if (q instanceof Iterator) {
            boolean z = this.c.get(this.c.size() - 2) instanceof com.google.gson.t;
            Iterator it = (Iterator) q;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                this.c.add(it.next());
                return f();
            }
        } else if (q instanceof com.google.gson.t) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (q instanceof com.google.gson.o) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (q instanceof com.google.gson.u) {
                com.google.gson.u uVar = (com.google.gson.u) q;
                if (uVar.q()) {
                    return JsonToken.STRING;
                }
                if (uVar.o()) {
                    return JsonToken.BOOLEAN;
                }
                if (uVar.p()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (q instanceof com.google.gson.s) {
                return JsonToken.NULL;
            } else {
                if (q == b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object q() {
        return this.c.get(this.c.size() - 1);
    }

    private Object r() {
        return this.c.remove(this.c.size() - 1);
    }

    private void a(JsonToken jsonToken) {
        if (f() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + f());
        }
    }

    @Override // com.google.gson.stream.a
    public String g() {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.gson.stream.a
    public String h() {
        JsonToken f = f();
        if (f != JsonToken.STRING && f != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + f);
        }
        return ((com.google.gson.u) r()).b();
    }

    @Override // com.google.gson.stream.a
    public boolean i() {
        a(JsonToken.BOOLEAN);
        return ((com.google.gson.u) r()).f();
    }

    @Override // com.google.gson.stream.a
    public void j() {
        a(JsonToken.NULL);
        r();
    }

    @Override // com.google.gson.stream.a
    public double k() {
        JsonToken f = f();
        if (f != JsonToken.NUMBER && f != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + f);
        }
        double c = ((com.google.gson.u) q()).c();
        if (!p() && (Double.isNaN(c) || Double.isInfinite(c))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        r();
        return c;
    }

    @Override // com.google.gson.stream.a
    public long l() {
        JsonToken f = f();
        if (f != JsonToken.NUMBER && f != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + f);
        }
        long d = ((com.google.gson.u) q()).d();
        r();
        return d;
    }

    @Override // com.google.gson.stream.a
    public int m() {
        JsonToken f = f();
        if (f != JsonToken.NUMBER && f != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + f);
        }
        int e = ((com.google.gson.u) q()).e();
        r();
        return e;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.clear();
        this.c.add(b);
    }

    @Override // com.google.gson.stream.a
    public void n() {
        if (f() == JsonToken.NAME) {
            g();
        } else {
            r();
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        this.c.add(new com.google.gson.u((String) entry.getKey()));
    }
}
