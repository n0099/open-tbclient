package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class f extends InputStream {
    private final g dataSpec;
    private final e mdU;
    private long totalBytesRead;
    private boolean mFI = false;
    private boolean closed = false;
    private final byte[] mFM = new byte[1];

    public f(e eVar, g gVar) {
        this.mdU = eVar;
        this.dataSpec = gVar;
    }

    public long dyU() {
        return this.totalBytesRead;
    }

    public void open() throws IOException {
        dyV();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mFM) == -1) {
            return -1;
        }
        return this.mFM[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(!this.closed);
        dyV();
        int read = this.mdU.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.mdU.close();
            this.closed = true;
        }
    }

    private void dyV() throws IOException {
        if (!this.mFI) {
            this.mdU.a(this.dataSpec);
            this.mFI = true;
        }
    }
}
