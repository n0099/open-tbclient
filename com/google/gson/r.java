package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes.dex */
public abstract class r {
    public boolean g() {
        return this instanceof o;
    }

    public boolean h() {
        return this instanceof t;
    }

    public boolean i() {
        return this instanceof u;
    }

    public boolean j() {
        return this instanceof s;
    }

    public t k() {
        if (h()) {
            return (t) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o l() {
        if (g()) {
            return (o) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public u m() {
        if (i()) {
            return (u) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.d dVar = new com.google.gson.stream.d(stringWriter);
            dVar.b(true);
            com.google.gson.internal.p.a(this, dVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
