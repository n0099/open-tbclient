package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer iuw = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l iux = new com.google.gson.l("closed");
    private com.google.gson.i iuA;
    private final List<com.google.gson.i> iuy;
    private String iuz;

    public f() {
        super(iuw);
        this.iuy = new ArrayList();
        this.iuA = com.google.gson.j.itd;
    }

    public com.google.gson.i caM() {
        if (!this.iuy.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.iuy);
        }
        return this.iuA;
    }

    private com.google.gson.i caN() {
        return this.iuy.get(this.iuy.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.iuz != null) {
            if (!iVar.cah() || cbf()) {
                ((com.google.gson.k) caN()).a(this.iuz, iVar);
            }
            this.iuz = null;
        } else if (this.iuy.isEmpty()) {
            this.iuA = iVar;
        } else {
            com.google.gson.i caN = caN();
            if (caN instanceof com.google.gson.f) {
                ((com.google.gson.f) caN).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b caO() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.iuy.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b caP() throws IOException {
        if (this.iuy.isEmpty() || this.iuz != null) {
            throw new IllegalStateException();
        }
        if (caN() instanceof com.google.gson.f) {
            this.iuy.remove(this.iuy.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b caQ() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.iuy.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b caR() throws IOException {
        if (this.iuy.isEmpty() || this.iuz != null) {
            throw new IllegalStateException();
        }
        if (caN() instanceof com.google.gson.k) {
            this.iuy.remove(this.iuy.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b zt(String str) throws IOException {
        if (this.iuy.isEmpty() || this.iuz != null) {
            throw new IllegalStateException();
        }
        if (caN() instanceof com.google.gson.k) {
            this.iuz = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b zu(String str) throws IOException {
        if (str == null) {
            return caS();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b caS() throws IOException {
        c(com.google.gson.j.itd);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b pd(boolean z) throws IOException {
        c(new com.google.gson.l(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b k(Boolean bool) throws IOException {
        if (bool == null) {
            return caS();
        }
        c(new com.google.gson.l(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dx(long j) throws IOException {
        c(new com.google.gson.l(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return caS();
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
        if (!this.iuy.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.iuy.add(iux);
    }
}
