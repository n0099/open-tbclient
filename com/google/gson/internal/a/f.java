package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer inl = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l inm = new com.google.gson.l("closed");
    private final List<com.google.gson.i> inn;
    private String ino;
    private com.google.gson.i inp;

    public f() {
        super(inl);
        this.inn = new ArrayList();
        this.inp = com.google.gson.j.ilR;
    }

    public com.google.gson.i bYG() {
        if (!this.inn.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.inn);
        }
        return this.inp;
    }

    private com.google.gson.i bYH() {
        return this.inn.get(this.inn.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.ino != null) {
            if (!iVar.bYb() || bYZ()) {
                ((com.google.gson.k) bYH()).a(this.ino, iVar);
            }
            this.ino = null;
        } else if (this.inn.isEmpty()) {
            this.inp = iVar;
        } else {
            com.google.gson.i bYH = bYH();
            if (bYH instanceof com.google.gson.f) {
                ((com.google.gson.f) bYH).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bYI() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.inn.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bYJ() throws IOException {
        if (this.inn.isEmpty() || this.ino != null) {
            throw new IllegalStateException();
        }
        if (bYH() instanceof com.google.gson.f) {
            this.inn.remove(this.inn.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bYK() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.inn.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bYL() throws IOException {
        if (this.inn.isEmpty() || this.ino != null) {
            throw new IllegalStateException();
        }
        if (bYH() instanceof com.google.gson.k) {
            this.inn.remove(this.inn.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b yQ(String str) throws IOException {
        if (this.inn.isEmpty() || this.ino != null) {
            throw new IllegalStateException();
        }
        if (bYH() instanceof com.google.gson.k) {
            this.ino = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b yR(String str) throws IOException {
        if (str == null) {
            return bYM();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bYM() throws IOException {
        c(com.google.gson.j.ilR);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b pb(boolean z) throws IOException {
        c(new com.google.gson.l(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b k(Boolean bool) throws IOException {
        if (bool == null) {
            return bYM();
        }
        c(new com.google.gson.l(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dq(long j) throws IOException {
        c(new com.google.gson.l(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return bYM();
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
        if (!this.inn.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.inn.add(inm);
    }
}
