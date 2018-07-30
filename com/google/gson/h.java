package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean bJX() {
        return this instanceof f;
    }

    public boolean bJY() {
        return this instanceof j;
    }

    public boolean bJZ() {
        return this instanceof k;
    }

    public boolean bKa() {
        return this instanceof i;
    }

    public j bKb() {
        if (bJY()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f bKc() {
        if (bJX()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k bKd() {
        if (bJZ()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean bKe() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number bJV() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String bJW() {
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
