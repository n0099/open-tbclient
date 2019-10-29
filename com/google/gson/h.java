package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cJU() {
        return this instanceof f;
    }

    public boolean cJV() {
        return this instanceof j;
    }

    public boolean cJW() {
        return this instanceof k;
    }

    public boolean cJX() {
        return this instanceof i;
    }

    public j cJY() {
        if (cJV()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cJZ() {
        if (cJU()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cKa() {
        if (cJW()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean cJT() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cKb() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cJR() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cJS() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(stringWriter);
            aVar.sq(true);
            com.google.gson.internal.f.b(this, aVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
