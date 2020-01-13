package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class f extends InputStream {
    private final g dataSpec;
    private final e mdj;
    private long totalBytesRead;
    private boolean mEW = false;
    private boolean closed = false;
    private final byte[] mFa = new byte[1];

    public f(e eVar, g gVar) {
        this.mdj = eVar;
        this.dataSpec = gVar;
    }

    public long dxI() {
        return this.totalBytesRead;
    }

    public void open() throws IOException {
        dxJ();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mFa) == -1) {
            return -1;
        }
        return this.mFa[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(!this.closed);
        dxJ();
        int read = this.mdj.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.mdj.close();
            this.closed = true;
        }
    }

    private void dxJ() throws IOException {
        if (!this.mEW) {
            this.mdj.a(this.dataSpec);
            this.mEW = true;
        }
    }
}
