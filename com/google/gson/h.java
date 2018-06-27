package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean bOe() {
        return this instanceof f;
    }

    public boolean bOf() {
        return this instanceof j;
    }

    public boolean bOg() {
        return this instanceof k;
    }

    public boolean bOh() {
        return this instanceof i;
    }

    public j bOi() {
        if (bOf()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f bOj() {
        if (bOe()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k bOk() {
        if (bOg()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean bOl() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number bOc() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String bOd() {
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
