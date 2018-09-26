package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class d extends com.google.gson.stream.a {
    private static final Writer hOL = new Writer() { // from class: com.google.gson.internal.a.d.1
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
    private static final com.google.gson.k hOM = new com.google.gson.k("closed");
    private final List<com.google.gson.h> hON;
    private String hOO;
    private com.google.gson.h hOP;

    public d() {
        super(hOL);
        this.hON = new ArrayList();
        this.hOP = com.google.gson.i.hNK;
    }

    public com.google.gson.h bNa() {
        if (!this.hON.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.hON);
        }
        return this.hOP;
    }

    private com.google.gson.h bNb() {
        return this.hON.get(this.hON.size() - 1);
    }

    private void c(com.google.gson.h hVar) {
        if (this.hOO != null) {
            if (!hVar.bMI() || bNl()) {
                ((com.google.gson.j) bNb()).a(this.hOO, hVar);
            }
            this.hOO = null;
        } else if (this.hON.isEmpty()) {
            this.hOP = hVar;
        } else {
            com.google.gson.h bNb = bNb();
            if (bNb instanceof com.google.gson.f) {
                ((com.google.gson.f) bNb).b(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bNc() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.hON.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bNd() throws IOException {
        if (this.hON.isEmpty() || this.hOO != null) {
            throw new IllegalStateException();
        }
        if (bNb() instanceof com.google.gson.f) {
            this.hON.remove(this.hON.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bNe() throws IOException {
        com.google.gson.j jVar = new com.google.gson.j();
        c(jVar);
        this.hON.add(jVar);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bNf() throws IOException {
        if (this.hON.isEmpty() || this.hOO != null) {
            throw new IllegalStateException();
        }
        if (bNb() instanceof com.google.gson.j) {
            this.hON.remove(this.hON.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a xp(String str) throws IOException {
        if (this.hON.isEmpty() || this.hOO != null) {
            throw new IllegalStateException();
        }
        if (bNb() instanceof com.google.gson.j) {
            this.hOO = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a xq(String str) throws IOException {
        if (str == null) {
            return bNg();
        }
        c(new com.google.gson.k(str));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a bNg() throws IOException {
        c(com.google.gson.i.hNK);
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a oi(boolean z) throws IOException {
        c(new com.google.gson.k(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a di(long j) throws IOException {
        c(new com.google.gson.k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.a b(Number number) throws IOException {
        if (number == null) {
            return bNg();
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
        if (!this.hON.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.hON.add(hOM);
    }
}
