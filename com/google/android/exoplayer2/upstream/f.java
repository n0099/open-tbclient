package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class f extends InputStream {
    private final g dataSpec;
    private final e mfN;
    private long totalBytesRead;
    private boolean mHB = false;
    private boolean closed = false;
    private final byte[] mHF = new byte[1];

    public f(e eVar, g gVar) {
        this.mfN = eVar;
        this.dataSpec = gVar;
    }

    public long dzu() {
        return this.totalBytesRead;
    }

    public void open() throws IOException {
        dzv();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mHF) == -1) {
            return -1;
        }
        return this.mHF[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(!this.closed);
        dzv();
        int read = this.mfN.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.mfN.close();
            this.closed = true;
        }
    }

    private void dzv() throws IOException {
        if (!this.mHB) {
            this.mfN.a(this.dataSpec);
            this.mHB = true;
        }
    }
}
