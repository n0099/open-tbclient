package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class i extends com.google.gson.stream.d {

    /* renamed from: a  reason: collision with root package name */
    private static final Writer f1631a = new j();
    private static final com.google.gson.u b = new com.google.gson.u("closed");
    private final List c;
    private String d;
    private com.google.gson.r e;

    public i() {
        super(f1631a);
        this.c = new ArrayList();
        this.e = com.google.gson.s.f1672a;
    }

    public com.google.gson.r a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    private com.google.gson.r i() {
        return (com.google.gson.r) this.c.get(this.c.size() - 1);
    }

    private void a(com.google.gson.r rVar) {
        if (this.d != null) {
            if (!rVar.j() || h()) {
                ((com.google.gson.t) i()).a(this.d, rVar);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = rVar;
        } else {
            com.google.gson.r i = i();
            if (i instanceof com.google.gson.o) {
                ((com.google.gson.o) i).a(rVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d b() {
        com.google.gson.o oVar = new com.google.gson.o();
        a(oVar);
        this.c.add(oVar);
        return this;
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d c() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (i() instanceof com.google.gson.o) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d d() {
        com.google.gson.t tVar = new com.google.gson.t();
        a(tVar);
        this.c.add(tVar);
        return this;
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d e() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (i() instanceof com.google.gson.t) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d a(String str) {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (i() instanceof com.google.gson.t) {
            this.d = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d b(String str) {
        if (str == null) {
            return f();
        }
        a(new com.google.gson.u(str));
        return this;
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d f() {
        a(com.google.gson.s.f1672a);
        return this;
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d a(boolean z) {
        a(new com.google.gson.u(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d a(long j) {
        a(new com.google.gson.u(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.d
    public com.google.gson.stream.d a(Number number) {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new com.google.gson.u(number));
        return this;
    }

    @Override // com.google.gson.stream.d, java.io.Flushable
    public void flush() {
    }

    @Override // com.google.gson.stream.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }
}
