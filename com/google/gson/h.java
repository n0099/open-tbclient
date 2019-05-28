package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cIJ() {
        return this instanceof f;
    }

    public boolean cIK() {
        return this instanceof j;
    }

    public boolean cIL() {
        return this instanceof k;
    }

    public boolean cIM() {
        return this instanceof i;
    }

    public j cIN() {
        if (cIK()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cIO() {
        if (cIJ()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cIP() {
        if (cIL()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cIQ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cIH() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cII() {
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
