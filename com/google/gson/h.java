package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean bMF() {
        return this instanceof f;
    }

    public boolean bMG() {
        return this instanceof j;
    }

    public boolean bMH() {
        return this instanceof k;
    }

    public boolean bMI() {
        return this instanceof i;
    }

    public j bMJ() {
        if (bMG()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f bMK() {
        if (bMF()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k bML() {
        if (bMH()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean bMM() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number bMD() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String bME() {
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
