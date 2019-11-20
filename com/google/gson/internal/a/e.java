package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Writer koP = new Writer() { // from class: com.google.gson.internal.a.e.1
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
    private static final com.google.gson.k koQ = new com.google.gson.k("closed");
    private String koR;
    private com.google.gson.h koS;
    private final List<com.google.gson.h> stack;

    public e() {
        super(koP);
        this.stack = new ArrayList();
        this.koS = com.google.gson.i.knE;
    }

    public com.google.gson.h cKv() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.koS;
    }

    private com.google.gson.h cKw() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.koR != null) {
            if (!hVar.cJV() || cKG()) {
                ((com.google.gson.j) cKw()).a(this.koR, hVar);
            }
            this.koR = null;
        } else if (this.stack.isEmpty()) {
            this.koS = hVar;
        } else {
            com.google.gson.h cKw = cKw();
            if (cKw instanceof com.google.gson.f) {
                ((com.google.gson.f) cKw).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cKx() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.stack.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cKy() throws IOException {
        if (this.stack.isEmpty() || this.koR != null) {
            throw new IllegalStateException();
        }
        if (cKw() instanceof com.google.gson.f) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cKz() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.stack.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cKA() throws IOException {
        if (this.stack.isEmpty() || this.koR != null) {
            throw new IllegalStateException();
        }
        if (cKw() instanceof com.google.gson.j) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a GO(String str) throws IOException {
        if (this.stack.isEmpty() || this.koR != null) {
            throw new IllegalStateException();
        }
        if (cKw() instanceof com.google.gson.j) {
            this.koR = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a GP(String str) throws IOException {
        if (str == null) {
            return cKB();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a cKB() throws IOException {
        c(com.google.gson.i.knE);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a sp(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a l(Boolean bool) throws IOException {
        if (bool == null) {
            return cKB();
        }
        c(new com.google.gson.k(bool));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a ej(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return cKB();
        }
        if (!cKE()) {
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
        this.stack.add(koQ);
    }
}
