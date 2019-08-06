package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
/* loaded from: classes2.dex */
public abstract class h {
    public boolean cMj() {
        return this instanceof f;
    }

    public boolean cMk() {
        return this instanceof j;
    }

    public boolean cMl() {
        return this instanceof k;
    }

    public boolean cMm() {
        return this instanceof i;
    }

    public j cMn() {
        if (cMk()) {
            return (j) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public f cMo() {
        if (cMj()) {
            return (f) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public k cMp() {
        if (cMl()) {
            return (k) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public boolean cMi() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean cMq() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number cMg() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String cMh() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(stringWriter);
            aVar.sI(true);
            com.google.gson.internal.f.b(this, aVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
