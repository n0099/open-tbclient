package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cLO() {
        return this instanceof f;
    }

    public boolean cLP() {
        return this instanceof j;
    }

    public boolean cLQ() {
        return this instanceof k;
    }

    public boolean cLR() {
        return this instanceof i;
    }

    public j cLS() {
        if (cLP()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cLT() {
        if (cLO()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cLU() {
        if (cLQ()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean cLN() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cLV() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cLL() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cLM() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(stringWriter);
            aVar.sH(true);
            com.google.gson.internal.f.b(this, aVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
