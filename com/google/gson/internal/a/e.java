package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Writer knR = new Writer() { // from class: com.google.gson.internal.a.e.1
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
    private static final com.google.gson.k knS = new com.google.gson.k("closed");
    private String knT;
    private com.google.gson.h knU;
    private final List<com.google.gson.h> stack;

    public e() {
        super(knR);
        this.stack = new ArrayList();
        this.knU = com.google.gson.i.kmG;
    }

    public com.google.gson.h cMr() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.knU;
    }

    private com.google.gson.h cMs() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.knT != null) {
            if (!hVar.cLR() || cMC()) {
                ((com.google.gson.j) cMs()).a(this.knT, hVar);
            }
            this.knT = null;
        } else if (this.stack.isEmpty()) {
            this.knU = hVar;
        } else {
            com.google.gson.h cMs = cMs();
            if (cMs instanceof com.google.gson.f) {
                ((com.google.gson.f) cMs).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cMt() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.stack.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cMu() throws IOException {
        if (this.stack.isEmpty() || this.knT != null) {
            throw new IllegalStateException();
        }
        if (cMs() instanceof com.google.gson.f) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cMv() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.stack.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cMw() throws IOException {
        if (this.stack.isEmpty() || this.knT != null) {
            throw new IllegalStateException();
        }
        if (cMs() instanceof com.google.gson.j) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a HW(String str) throws IOException {
        if (this.stack.isEmpty() || this.knT != null) {
            throw new IllegalStateException();
        }
        if (cMs() instanceof com.google.gson.j) {
            this.knT = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a HX(String str) throws IOException {
        if (str == null) {
            return cMx();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cMx() throws IOException {
        c(com.google.gson.i.kmG);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a sG(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cMx();
        }
        c(new com.google.gson.k(bool));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a eN(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return cMx();
        }
        if (!cMA()) {
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
        this.stack.add(knS);
    }
}
