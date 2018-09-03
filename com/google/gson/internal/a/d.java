package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class d extends com.google.gson.stream.a {
    private static final Writer hGr = new Writer() { // from class: com.google.gson.internal.a.d.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final com.google.gson.k hGs = new com.google.gson.k("closed");
    private final List<com.google.gson.h> hGt;
    private String hGu;
    private com.google.gson.h hGv;

    public d() {
        super(hGr);
        this.hGt = new ArrayList();
        this.hGv = com.google.gson.i.hFq;
    }

    public com.google.gson.h bKj() {
        if (!this.hGt.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.hGt);
        }
        return this.hGv;
    }

    private com.google.gson.h bKk() {
        return this.hGt.get(this.hGt.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.hGu != null) {
            if (!hVar.bJR() || bKu()) {
                ((com.google.gson.j) bKk()).a(this.hGu, hVar);
            }
            this.hGu = null;
        } else if (this.hGt.isEmpty()) {
            this.hGv = hVar;
        } else {
            com.google.gson.h bKk = bKk();
            if (bKk instanceof com.google.gson.f) {
                ((com.google.gson.f) bKk).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKl() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.hGt.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKm() throws IOException {
        if (this.hGt.isEmpty() || this.hGu != null) {
            throw new IllegalStateException();
        }
        if (bKk() instanceof com.google.gson.f) {
            this.hGt.remove(this.hGt.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKn() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.hGt.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKo() throws IOException {
        if (this.hGt.isEmpty() || this.hGu != null) {
            throw new IllegalStateException();
        }
        if (bKk() instanceof com.google.gson.j) {
            this.hGt.remove(this.hGt.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a wE(String str) throws IOException {
        if (this.hGt.isEmpty() || this.hGu != null) {
            throw new IllegalStateException();
        }
        if (bKk() instanceof com.google.gson.j) {
            this.hGu = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a wF(String str) throws IOException {
        if (str == null) {
            return bKp();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKp() throws IOException {
        c(com.google.gson.i.hFq);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a nL(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a dg(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a b(Number number) throws IOException {
        if (number == null) {
            return bKp();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new com.google.gson.k(number));
        return this;
    }

    @Override // com.google.gson.stream.a, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.hGt.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.hGt.add(hGs);
    }
}
