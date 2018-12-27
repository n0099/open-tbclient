package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer ixG = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l ixH = new com.google.gson.l("closed");
    private final List<com.google.gson.i> ixI;
    private String ixJ;
    private com.google.gson.i ixK;

    public f() {
        super(ixG);
        this.ixI = new ArrayList();
        this.ixK = com.google.gson.j.iwn;
    }

    public com.google.gson.i cbC() {
        if (!this.ixI.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.ixI);
        }
        return this.ixK;
    }

    private com.google.gson.i cbD() {
        return this.ixI.get(this.ixI.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.ixJ != null) {
            if (!iVar.caX() || cbV()) {
                ((com.google.gson.k) cbD()).a(this.ixJ, iVar);
            }
            this.ixJ = null;
        } else if (this.ixI.isEmpty()) {
            this.ixK = iVar;
        } else {
            com.google.gson.i cbD = cbD();
            if (cbD instanceof com.google.gson.f) {
                ((com.google.gson.f) cbD).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cbE() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.ixI.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cbF() throws IOException {
        if (this.ixI.isEmpty() || this.ixJ != null) {
            throw new IllegalStateException();
        }
        if (cbD() instanceof com.google.gson.f) {
            this.ixI.remove(this.ixI.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cbG() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.ixI.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cbH() throws IOException {
        if (this.ixI.isEmpty() || this.ixJ != null) {
            throw new IllegalStateException();
        }
        if (cbD() instanceof com.google.gson.k) {
            this.ixI.remove(this.ixI.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b zw(String str) throws IOException {
        if (this.ixI.isEmpty() || this.ixJ != null) {
            throw new IllegalStateException();
        }
        if (cbD() instanceof com.google.gson.k) {
            this.ixJ = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b zx(String str) throws IOException {
        if (str == null) {
            return cbI();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cbI() throws IOException {
        c(com.google.gson.j.iwn);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b pg(boolean z) throws IOException {
        c(new com.google.gson.l(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b k(Boolean bool) throws IOException {
        if (bool == null) {
            return cbI();
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
            return cbI();
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
        if (!this.ixI.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.ixI.add(ixH);
    }
}
