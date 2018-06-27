package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class d extends com.google.gson.stream.a {
    private static final Writer hNM = new Writer() { // from class: com.google.gson.internal.a.d.1
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
    private static final com.google.gson.k hNN = new com.google.gson.k("closed");
    private final List<com.google.gson.h> hNO;
    private String hNP;
    private com.google.gson.h hNQ;

    public d() {
        super(hNM);
        this.hNO = new ArrayList();
        this.hNQ = com.google.gson.i.hMM;
    }

    public com.google.gson.h bOz() {
        if (!this.hNO.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.hNO);
        }
        return this.hNQ;
    }

    private com.google.gson.h bOA() {
        return this.hNO.get(this.hNO.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.hNP != null) {
            if (!hVar.bOh() || bOK()) {
                ((com.google.gson.j) bOA()).a(this.hNP, hVar);
            }
            this.hNP = null;
        } else if (this.hNO.isEmpty()) {
            this.hNQ = hVar;
        } else {
            com.google.gson.h bOA = bOA();
            if (bOA instanceof com.google.gson.f) {
                ((com.google.gson.f) bOA).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOB() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.hNO.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOC() throws IOException {
        if (this.hNO.isEmpty() || this.hNP != null) {
            throw new IllegalStateException();
        }
        if (bOA() instanceof com.google.gson.f) {
            this.hNO.remove(this.hNO.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOD() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.hNO.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOE() throws IOException {
        if (this.hNO.isEmpty() || this.hNP != null) {
            throw new IllegalStateException();
        }
        if (bOA() instanceof com.google.gson.j) {
            this.hNO.remove(this.hNO.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a xx(String str) throws IOException {
        if (this.hNO.isEmpty() || this.hNP != null) {
            throw new IllegalStateException();
        }
        if (bOA() instanceof com.google.gson.j) {
            this.hNP = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a xy(String str) throws IOException {
        if (str == null) {
            return bOF();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bOF() throws IOException {
        c(com.google.gson.i.hMM);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a ol(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a dC(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a a(Number number) throws IOException {
        if (number == null) {
            return bOF();
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
        if (!this.hNO.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.hNO.add(hNN);
    }
}
