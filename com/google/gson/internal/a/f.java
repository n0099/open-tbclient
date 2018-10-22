package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer ilA = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l ilB = new com.google.gson.l("closed");
    private final List<com.google.gson.i> ilC;
    private String ilD;
    private com.google.gson.i ilE;

    public f() {
        super(ilA);
        this.ilC = new ArrayList();
        this.ilE = com.google.gson.j.ikh;
    }

    public com.google.gson.i bZj() {
        if (!this.ilC.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.ilC);
        }
        return this.ilE;
    }

    private com.google.gson.i bZk() {
        return this.ilC.get(this.ilC.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.ilD != null) {
            if (!iVar.bYE() || bZC()) {
                ((com.google.gson.k) bZk()).a(this.ilD, iVar);
            }
            this.ilD = null;
        } else if (this.ilC.isEmpty()) {
            this.ilE = iVar;
        } else {
            com.google.gson.i bZk = bZk();
            if (bZk instanceof com.google.gson.f) {
                ((com.google.gson.f) bZk).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bZl() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.ilC.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bZm() throws IOException {
        if (this.ilC.isEmpty() || this.ilD != null) {
            throw new IllegalStateException();
        }
        if (bZk() instanceof com.google.gson.f) {
            this.ilC.remove(this.ilC.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bZn() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.ilC.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bZo() throws IOException {
        if (this.ilC.isEmpty() || this.ilD != null) {
            throw new IllegalStateException();
        }
        if (bZk() instanceof com.google.gson.k) {
            this.ilC.remove(this.ilC.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b yL(String str) throws IOException {
        if (this.ilC.isEmpty() || this.ilD != null) {
            throw new IllegalStateException();
        }
        if (bZk() instanceof com.google.gson.k) {
            this.ilD = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b yM(String str) throws IOException {
        if (str == null) {
            return bZp();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b bZp() throws IOException {
        c(com.google.gson.j.ikh);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b oO(boolean z) throws IOException {
        c(new com.google.gson.l(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b k(Boolean bool) throws IOException {
        if (bool == null) {
            return bZp();
        }
        c(new com.google.gson.l(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b dv(long j) throws IOException {
        c(new com.google.gson.l(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b b(Number number) throws IOException {
        if (number == null) {
            return bZp();
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
        if (!this.ilC.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.ilC.add(ilB);
    }
}
