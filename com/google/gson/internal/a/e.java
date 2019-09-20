package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Writer kru = new Writer() { // from class: com.google.gson.internal.a.e.1
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
    private static final com.google.gson.k krv = new com.google.gson.k("closed");
    private String krw;
    private com.google.gson.h krx;
    private final List<com.google.gson.h> stack;

    public e() {
        super(kru);
        this.stack = new ArrayList();
        this.krx = com.google.gson.i.kqj;
    }

    public com.google.gson.h cNA() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.krx;
    }

    private com.google.gson.h cNB() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.krw != null) {
            if (!hVar.cNa() || cNL()) {
                ((com.google.gson.j) cNB()).a(this.krw, hVar);
            }
            this.krw = null;
        } else if (this.stack.isEmpty()) {
            this.krx = hVar;
        } else {
            com.google.gson.h cNB = cNB();
            if (cNB instanceof com.google.gson.f) {
                ((com.google.gson.f) cNB).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cNC() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.stack.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cND() throws IOException {
        if (this.stack.isEmpty() || this.krw != null) {
            throw new IllegalStateException();
        }
        if (cNB() instanceof com.google.gson.f) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cNE() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.stack.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cNF() throws IOException {
        if (this.stack.isEmpty() || this.krw != null) {
            throw new IllegalStateException();
        }
        if (cNB() instanceof com.google.gson.j) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Ix(String str) throws IOException {
        if (this.stack.isEmpty() || this.krw != null) {
            throw new IllegalStateException();
        }
        if (cNB() instanceof com.google.gson.j) {
            this.krw = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Iy(String str) throws IOException {
        if (str == null) {
            return cNG();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cNG() throws IOException {
        c(com.google.gson.i.kqj);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a sK(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cNG();
        }
        c(new com.google.gson.k(bool));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a eQ(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return cNG();
        }
        if (!cNJ()) {
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
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(krv);
    }
}
