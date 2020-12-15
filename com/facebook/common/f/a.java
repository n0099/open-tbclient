package com.facebook.common.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes19.dex */
public class a extends FilterInputStream {
    private int pcy;
    private int pcz;

    public a(InputStream inputStream, int i) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("limit must be >= 0");
        }
        this.pcy = i;
        this.pcz = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.pcy == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.pcy--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.pcy == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, Math.min(i2, this.pcy));
        if (read > 0) {
            this.pcy -= read;
            return read;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.pcy));
        this.pcy = (int) (this.pcy - skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(this.in.available(), this.pcy);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (this.in.markSupported()) {
            this.in.mark(i);
            this.pcz = this.pcy;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        if (this.pcz == -1) {
            throw new IOException("mark not set");
        }
        this.in.reset();
        this.pcy = this.pcz;
    }
}
