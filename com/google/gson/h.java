package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean bJO() {
        return this instanceof f;
    }

    public boolean bJP() {
        return this instanceof j;
    }

    public boolean bJQ() {
        return this instanceof k;
    }

    public boolean bJR() {
        return this instanceof i;
    }

    public j bJS() {
        if (bJP()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f bJT() {
        if (bJO()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k bJU() {
        if (bJQ()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean bJV() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number bJM() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String bJN() {
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
