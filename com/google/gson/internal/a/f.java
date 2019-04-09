package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer jOf = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l jOg = new com.google.gson.l("closed");
    private String jOh;
    private com.google.gson.i jOi;
    private final List<com.google.gson.i> stack;

    public f() {
        super(jOf);
        this.stack = new ArrayList();
        this.jOi = com.google.gson.j.jMM;
    }

    public com.google.gson.i cBv() {
        if (!this.stack.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.stack);
        }
        return this.jOi;
    }

    private com.google.gson.i cBw() {
        return this.stack.get(this.stack.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.jOh != null) {
            if (!iVar.cAQ() || cBM()) {
                ((com.google.gson.k) cBw()).a(this.jOh, iVar);
            }
            this.jOh = null;
        } else if (this.stack.isEmpty()) {
            this.jOi = iVar;
        } else {
            com.google.gson.i cBw = cBw();
            if (cBw instanceof com.google.gson.f) {
                ((com.google.gson.f) cBw).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBx() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.stack.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBy() throws IOException {
        if (this.stack.isEmpty() || this.jOh != null) {
            throw new IllegalStateException();
        }
        if (cBw() instanceof com.google.gson.f) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBz() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.stack.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBA() throws IOException {
        if (this.stack.isEmpty() || this.jOh != null) {
            throw new IllegalStateException();
        }
        if (cBw() instanceof com.google.gson.k) {
            this.stack.remove(this.stack.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FG(String str) throws IOException {
        if (this.stack.isEmpty() || this.jOh != null) {
            throw new IllegalStateException();
        }
        if (cBw() instanceof com.google.gson.k) {
            this.jOh = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FH(String str) throws IOException {
        if (str == null) {
            return cBB();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBB() throws IOException {
        c(com.google.gson.j.jMM);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b rB(boolean z) throws IOException {
        c(new com.google.gson.l(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b m(Boolean bool) throws IOException {
        if (bool == null) {
            return cBB();
        }
        c(new com.google.gson.l(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eg(long j) throws IOException {
        c(new com.google.gson.l(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b a(Number number) throws IOException {
        if (number == null) {
            return cBB();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new com.google.gson.l(number));
        return this;
    }

    @Override // com.google.gson.stream.b, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.stack.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.stack.add(jOg);
    }
}
