package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Writer kgH = new Writer() { // from class: com.google.gson.internal.a.e.1
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
    private static final com.google.gson.k kgI = new com.google.gson.k("closed");
    private String kgJ;
    private com.google.gson.h kgK;
    private final List<com.google.gson.h> stack;

    public e() {
        super(kgH);
        this.stack = new ArrayList();
        this.kgK = com.google.gson.i.kfw;
    }

    public com.google.gson.h cJk() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.kgK;
    }

    private com.google.gson.h cJl() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.kgJ != null) {
            if (!hVar.cIK() || cJu()) {
                ((com.google.gson.j) cJl()).a(this.kgJ, hVar);
            }
            this.kgJ = null;
        } else if (this.stack.isEmpty()) {
            this.kgK = hVar;
        } else {
            com.google.gson.h cJl = cJl();
            if (cJl instanceof com.google.gson.f) {
                ((com.google.gson.f) cJl).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJm() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.stack.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJn() throws IOException {
        if (this.stack.isEmpty() || this.kgJ != null) {
            throw new IllegalStateException();
        }
        if (cJl() instanceof com.google.gson.f) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJo() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.stack.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJp() throws IOException {
        if (this.stack.isEmpty() || this.kgJ != null) {
            throw new IllegalStateException();
        }
        if (cJl() instanceof com.google.gson.j) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Ha(String str) throws IOException {
        if (this.stack.isEmpty() || this.kgJ != null) {
            throw new IllegalStateException();
        }
        if (cJl() instanceof com.google.gson.j) {
            this.kgJ = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Hb(String str) throws IOException {
        if (str == null) {
            return cJq();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJq() throws IOException {
        c(com.google.gson.i.kfw);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a sq(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a m(Boolean bool) throws IOException {
        if (bool == null) {
            return cJq();
        }
        c(new com.google.gson.k(bool));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a eF(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return cJq();
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
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(kgI);
    }
}
