package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer jOS = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l jOT = new com.google.gson.l("closed");
    private final List<com.google.gson.i> jOU;
    private String jOV;
    private com.google.gson.i jOW;

    public f() {
        super(jOS);
        this.jOU = new ArrayList();
        this.jOW = com.google.gson.j.jNz;
    }

    public com.google.gson.i cBz() {
        if (!this.jOU.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.jOU);
        }
        return this.jOW;
    }

    private com.google.gson.i cBA() {
        return this.jOU.get(this.jOU.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.jOV != null) {
            if (!iVar.cAU() || cBS()) {
                ((com.google.gson.k) cBA()).a(this.jOV, iVar);
            }
            this.jOV = null;
        } else if (this.jOU.isEmpty()) {
            this.jOW = iVar;
        } else {
            com.google.gson.i cBA = cBA();
            if (cBA instanceof com.google.gson.f) {
                ((com.google.gson.f) cBA).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBB() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.jOU.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBC() throws IOException {
        if (this.jOU.isEmpty() || this.jOV != null) {
            throw new IllegalStateException();
        }
        if (cBA() instanceof com.google.gson.f) {
            this.jOU.remove(this.jOU.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBD() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.jOU.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBE() throws IOException {
        if (this.jOU.isEmpty() || this.jOV != null) {
            throw new IllegalStateException();
        }
        if (cBA() instanceof com.google.gson.k) {
            this.jOU.remove(this.jOU.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FS(String str) throws IOException {
        if (this.jOU.isEmpty() || this.jOV != null) {
            throw new IllegalStateException();
        }
        if (cBA() instanceof com.google.gson.k) {
            this.jOV = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FT(String str) throws IOException {
        if (str == null) {
            return cBF();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBF() throws IOException {
        c(com.google.gson.j.jNz);
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
            return cBF();
        }
        c(new com.google.gson.l(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b eh(long j) throws IOException {
        c(new com.google.gson.l(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return cBF();
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
        if (!this.jOU.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.jOU.add(jOT);
    }
}
