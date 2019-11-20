package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cJS() {
        return this instanceof f;
    }

    public boolean cJT() {
        return this instanceof j;
    }

    public boolean cJU() {
        return this instanceof k;
    }

    public boolean cJV() {
        return this instanceof i;
    }

    public j cJW() {
        if (cJT()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cJX() {
        if (cJS()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cJY() {
        if (cJU()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean cJR() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cJZ() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cJP() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cJQ() {
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
