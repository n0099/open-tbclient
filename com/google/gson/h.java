package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cIH() {
        return this instanceof f;
    }

    public boolean cII() {
        return this instanceof j;
    }

    public boolean cIJ() {
        return this instanceof k;
    }

    public boolean cIK() {
        return this instanceof i;
    }

    public j cIL() {
        if (cII()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cIM() {
        if (cIH()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cIN() {
        if (cIJ()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cIO() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cIF() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cIG() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(stringWriter);
            aVar.setLenient(true);
            com.google.gson.internal.f.b(this, aVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
