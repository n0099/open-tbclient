package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class i {
    public boolean cae() {
        return this instanceof f;
    }

    public boolean caf() {
        return this instanceof k;
    }

    public boolean cag() {
        return this instanceof l;
    }

    public boolean cah() {
        return this instanceof j;
    }

    public k cai() {
        if (caf()) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f caj() {
        if (cae()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public l cak() {
        if (cag()) {
            return (l) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cac() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cad() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.b bVar = new com.google.gson.stream.b(stringWriter);
            bVar.setLenient(true);
            com.google.gson.internal.g.b(this, bVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
