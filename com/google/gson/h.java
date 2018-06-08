package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean bNC() {
        return this instanceof f;
    }

    public boolean bND() {
        return this instanceof j;
    }

    public boolean bNE() {
        return this instanceof k;
    }

    public boolean bNF() {
        return this instanceof i;
    }

    public j bNG() {
        if (bND()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f bNH() {
        if (bNC()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k bNI() {
        if (bNE()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean bNJ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number bNA() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String bNB() {
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
