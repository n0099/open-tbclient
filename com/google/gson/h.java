package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cMX() {
        return this instanceof f;
    }

    public boolean cMY() {
        return this instanceof j;
    }

    public boolean cMZ() {
        return this instanceof k;
    }

    public boolean cNa() {
        return this instanceof i;
    }

    public j cNb() {
        if (cMY()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cNc() {
        if (cMX()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cNd() {
        if (cMZ()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean cMW() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cNe() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cMU() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cMV() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(stringWriter);
            aVar.sL(true);
            com.google.gson.internal.f.b(this, aVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
