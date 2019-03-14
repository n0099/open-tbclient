package com.google.gson.internal.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer jOK = new Writer() { // from class: com.google.gson.internal.a.f.1
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
    private static final com.google.gson.l jOL = new com.google.gson.l("closed");
    private final List<com.google.gson.i> jOM;
    private String jON;
    private com.google.gson.i jOO;

    public f() {
        super(jOK);
        this.jOM = new ArrayList();
        this.jOO = com.google.gson.j.jNr;
    }

    public com.google.gson.i cBC() {
        if (!this.jOM.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.jOM);
        }
        return this.jOO;
    }

    private com.google.gson.i cBD() {
        return this.jOM.get(this.jOM.size() - 1);
    }

    private void c(com.google.gson.i iVar) {
        if (this.jON != null) {
            if (!iVar.cAX() || cBV()) {
                ((com.google.gson.k) cBD()).a(this.jON, iVar);
            }
            this.jON = null;
        } else if (this.jOM.isEmpty()) {
            this.jOO = iVar;
        } else {
            com.google.gson.i cBD = cBD();
            if (cBD instanceof com.google.gson.f) {
                ((com.google.gson.f) cBD).b(iVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBE() throws IOException {
        com.google.gson.f fVar = new com.google.gson.f();
        c(fVar);
        this.jOM.add(fVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBF() throws IOException {
        if (this.jOM.isEmpty() || this.jON != null) {
            throw new IllegalStateException();
        }
        if (cBD() instanceof com.google.gson.f) {
            this.jOM.remove(this.jOM.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBG() throws IOException {
        com.google.gson.k kVar = new com.google.gson.k();
        c(kVar);
        this.jOM.add(kVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBH() throws IOException {
        if (this.jOM.isEmpty() || this.jON != null) {
            throw new IllegalStateException();
        }
        if (cBD() instanceof com.google.gson.k) {
            this.jOM.remove(this.jOM.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FQ(String str) throws IOException {
        if (this.jOM.isEmpty() || this.jON != null) {
            throw new IllegalStateException();
        }
        if (cBD() instanceof com.google.gson.k) {
            this.jON = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b FR(String str) throws IOException {
        if (str == null) {
            return cBI();
        }
        c(new com.google.gson.l(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b cBI() throws IOException {
        c(com.google.gson.j.jNr);
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
            return cBI();
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
            return cBI();
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
        if (!this.jOM.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.jOM.add(jOL);
    }
}
