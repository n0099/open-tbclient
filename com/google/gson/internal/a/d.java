package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class d extends com.google.gson.stream.a {
    private static final Writer hJG = new Writer() { // from class: com.google.gson.internal.a.d.1
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
    private static final com.google.gson.k hJH = new com.google.gson.k("closed");
    private final List<com.google.gson.h> hJI;
    private String hJJ;
    private com.google.gson.h hJK;

    public d() {
        super(hJG);
        this.hJI = new ArrayList();
        this.hJK = com.google.gson.i.hIG;
    }

    public com.google.gson.h bNX() {
        if (!this.hJI.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.hJI);
        }
        return this.hJK;
    }

    private com.google.gson.h bNY() {
        return this.hJI.get(this.hJI.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.hJJ != null) {
            if (!hVar.bNF() || bOi()) {
                ((com.google.gson.j) bNY()).a(this.hJJ, hVar);
            }
            this.hJJ = null;
        } else if (this.hJI.isEmpty()) {
            this.hJK = hVar;
        } else {
            com.google.gson.h bNY = bNY();
            if (bNY instanceof com.google.gson.f) {
                ((com.google.gson.f) bNY).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bNZ() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.hJI.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOa() throws IOException {
        if (this.hJI.isEmpty() || this.hJJ != null) {
            throw new IllegalStateException();
        }
        if (bNY() instanceof com.google.gson.f) {
            this.hJI.remove(this.hJI.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOb() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.hJI.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOc() throws IOException {
        if (this.hJI.isEmpty() || this.hJJ != null) {
            throw new IllegalStateException();
        }
        if (bNY() instanceof com.google.gson.j) {
            this.hJI.remove(this.hJI.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a xz(String str) throws IOException {
        if (this.hJI.isEmpty() || this.hJJ != null) {
            throw new IllegalStateException();
        }
        if (bNY() instanceof com.google.gson.j) {
            this.hJJ = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a xA(String str) throws IOException {
        if (str == null) {
            return bOd();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOd() throws IOException {
        c(com.google.gson.i.hIG);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a oe(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a dE(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return bOd();
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
        if (!this.hJI.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.hJI.add(hJH);
    }
}
