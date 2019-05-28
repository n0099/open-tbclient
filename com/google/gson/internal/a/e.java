package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Writer kgI = new Writer() { // from class: com.google.gson.internal.a.e.1
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
    private static final com.google.gson.k kgJ = new com.google.gson.k("closed");
    private String kgK;
    private com.google.gson.h kgL;
    private final List<com.google.gson.h> stack;

    public e() {
        super(kgI);
        this.stack = new ArrayList();
        this.kgL = com.google.gson.i.kfx;
    }

    public com.google.gson.h cJm() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.kgL;
    }

    private com.google.gson.h cJn() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.kgK != null) {
            if (!hVar.cIM() || cJw()) {
                ((com.google.gson.j) cJn()).a(this.kgK, hVar);
            }
            this.kgK = null;
        } else if (this.stack.isEmpty()) {
            this.kgL = hVar;
        } else {
            com.google.gson.h cJn = cJn();
            if (cJn instanceof com.google.gson.f) {
                ((com.google.gson.f) cJn).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJo() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.stack.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJp() throws IOException {
        if (this.stack.isEmpty() || this.kgK != null) {
            throw new IllegalStateException();
        }
        if (cJn() instanceof com.google.gson.f) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJq() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.stack.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJr() throws IOException {
        if (this.stack.isEmpty() || this.kgK != null) {
            throw new IllegalStateException();
        }
        if (cJn() instanceof com.google.gson.j) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Ha(String str) throws IOException {
        if (this.stack.isEmpty() || this.kgK != null) {
            throw new IllegalStateException();
        }
        if (cJn() instanceof com.google.gson.j) {
            this.kgK = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a Hb(String str) throws IOException {
        if (str == null) {
            return cJs();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cJs() throws IOException {
        c(com.google.gson.i.kfx);
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
            return cJs();
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
            return cJs();
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
        this.stack.add(kgJ);
    }
}
