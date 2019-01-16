package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer iyN = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l iyO = new com.google.gson.l("closed");
    private final List<com.google.gson.i> iyP;
    private String iyQ;
    private com.google.gson.i iyR;

    public f() {
        super(iyN);
        this.iyP = new ArrayList();
        this.iyR = com.google.gson.j.ixu;
    }

    public com.google.gson.i cck() {
        if (!this.iyP.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.iyP);
        }
        return this.iyR;
    }

    private com.google.gson.i ccl() {
        return this.iyP.get(this.iyP.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.iyQ != null) {
            if (!iVar.cbF() || ccD()) {
                ((com.google.gson.k) ccl()).a(this.iyQ, iVar);
            }
            this.iyQ = null;
        } else if (this.iyP.isEmpty()) {
            this.iyR = iVar;
        } else {
            com.google.gson.i ccl = ccl();
            if (ccl instanceof com.google.gson.f) {
                ((com.google.gson.f) ccl).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ccm() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.iyP.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ccn() throws IOException {
        if (this.iyP.isEmpty() || this.iyQ != null) {
            throw new IllegalStateException();
        }
        if (ccl() instanceof com.google.gson.f) {
            this.iyP.remove(this.iyP.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cco() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.iyP.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ccp() throws IOException {
        if (this.iyP.isEmpty() || this.iyQ != null) {
            throw new IllegalStateException();
        }
        if (ccl() instanceof com.google.gson.k) {
            this.iyP.remove(this.iyP.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b zM(String str) throws IOException {
        if (this.iyP.isEmpty() || this.iyQ != null) {
            throw new IllegalStateException();
        }
        if (ccl() instanceof com.google.gson.k) {
            this.iyQ = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b zN(String str) throws IOException {
        if (str == null) {
            return ccq();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ccq() throws IOException {
        c(com.google.gson.j.ixu);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b ph(boolean z) throws IOException {
        c(new com.google.gson.l(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b k(Boolean bool) throws IOException {
        if (bool == null) {
            return ccq();
        }
        c(new com.google.gson.l(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dC(long j) throws IOException {
        c(new com.google.gson.l(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return ccq();
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
        if (!this.iyP.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.iyP.add(iyO);
    }
}
