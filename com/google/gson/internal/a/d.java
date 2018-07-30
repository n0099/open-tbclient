package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class d extends com.google.gson.stream.a {
    private static final Writer hGK = new Writer() { // from class: com.google.gson.internal.a.d.1
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
    private static final com.google.gson.k hGL = new com.google.gson.k("closed");
    private final List<com.google.gson.h> hGM;
    private String hGN;
    private com.google.gson.h hGO;

    public d() {
        super(hGK);
        this.hGM = new ArrayList();
        this.hGO = com.google.gson.i.hFJ;
    }

    public com.google.gson.h bKs() {
        if (!this.hGM.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.hGM);
        }
        return this.hGO;
    }

    private com.google.gson.h bKt() {
        return this.hGM.get(this.hGM.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.hGN != null) {
            if (!hVar.bKa() || bKD()) {
                ((com.google.gson.j) bKt()).a(this.hGN, hVar);
            }
            this.hGN = null;
        } else if (this.hGM.isEmpty()) {
            this.hGO = hVar;
        } else {
            com.google.gson.h bKt = bKt();
            if (bKt instanceof com.google.gson.f) {
                ((com.google.gson.f) bKt).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKu() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.hGM.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKv() throws IOException {
        if (this.hGM.isEmpty() || this.hGN != null) {
            throw new IllegalStateException();
        }
        if (bKt() instanceof com.google.gson.f) {
            this.hGM.remove(this.hGM.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKw() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.hGM.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKx() throws IOException {
        if (this.hGM.isEmpty() || this.hGN != null) {
            throw new IllegalStateException();
        }
        if (bKt() instanceof com.google.gson.j) {
            this.hGM.remove(this.hGM.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a wD(String str) throws IOException {
        if (this.hGM.isEmpty() || this.hGN != null) {
            throw new IllegalStateException();
        }
        if (bKt() instanceof com.google.gson.j) {
            this.hGN = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a wE(String str) throws IOException {
        if (str == null) {
            return bKy();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bKy() throws IOException {
        c(com.google.gson.i.hFJ);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a nL(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a dh(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return bKy();
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
        if (!this.hGM.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.hGM.add(hGL);
    }
}
