package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public final class f extends InputStream {
    private final g dataSpec;
    private final e lZr;
    private long totalBytesRead;
    private boolean mBe = false;
    private boolean closed = false;
    private final byte[] mBj = new byte[1];

    public f(e eVar, g gVar) {
        this.lZr = eVar;
        this.dataSpec = gVar;
    }

    public long dwx() {
        return this.totalBytesRead;
    }

    public void open() throws IOException {
        dwy();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mBj) == -1) {
            return -1;
        }
        return this.mBj[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(!this.closed);
        dwy();
        int read = this.lZr.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.lZr.close();
            this.closed = true;
        }
    }

    private void dwy() throws IOException {
        if (!this.mBe) {
            this.lZr.a(this.dataSpec);
            this.mBe = true;
        }
    }
}
