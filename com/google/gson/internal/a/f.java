package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private final List<com.google.gson.i> jOB;
    private String jOC;
    private com.google.gson.i jOD;
    private static final Writer jOz = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l jOA = new com.google.gson.l("closed");

    public f() {
        super(jOz);
        this.jOB = new ArrayList();
        this.jOD = com.google.gson.j.jNg;
    }

    public com.google.gson.i cBp() {
        if (!this.jOB.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.jOB);
        }
        return this.jOD;
    }

    private com.google.gson.i cBq() {
        return this.jOB.get(this.jOB.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.jOC != null) {
            if (!iVar.cAK() || cBI()) {
                ((com.google.gson.k) cBq()).a(this.jOC, iVar);
            }
            this.jOC = null;
        } else if (this.jOB.isEmpty()) {
            this.jOD = iVar;
        } else {
            com.google.gson.i cBq = cBq();
            if (cBq instanceof com.google.gson.f) {
                ((com.google.gson.f) cBq).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBr() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.jOB.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBs() throws IOException {
        if (this.jOB.isEmpty() || this.jOC != null) {
            throw new IllegalStateException();
        }
        if (cBq() instanceof com.google.gson.f) {
            this.jOB.remove(this.jOB.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBt() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.jOB.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBu() throws IOException {
        if (this.jOB.isEmpty() || this.jOC != null) {
            throw new IllegalStateException();
        }
        if (cBq() instanceof com.google.gson.k) {
            this.jOB.remove(this.jOB.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FP(String str) throws IOException {
        if (this.jOB.isEmpty() || this.jOC != null) {
            throw new IllegalStateException();
        }
        if (cBq() instanceof com.google.gson.k) {
            this.jOC = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FQ(String str) throws IOException {
        if (str == null) {
            return cBv();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBv() throws IOException {
        c(com.google.gson.j.jNg);
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
            return cBv();
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
            return cBv();
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
        if (!this.jOB.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.jOB.add(jOA);
    }
}
