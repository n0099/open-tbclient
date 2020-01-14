package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class f extends InputStream {
    private final g dataSpec;
    private final e mdo;
    private long totalBytesRead;
    private boolean mFb = false;
    private boolean closed = false;
    private final byte[] mFg = new byte[1];

    public f(e eVar, g gVar) {
        this.mdo = eVar;
        this.dataSpec = gVar;
    }

    public long dxK() {
        return this.totalBytesRead;
    }

    public void open() throws IOException {
        dxL();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mFg) == -1) {
            return -1;
        }
        return this.mFg[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(!this.closed);
        dxL();
        int read = this.mdo.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.mdo.close();
            this.closed = true;
        }
    }

    private void dxL() throws IOException {
        if (!this.mFb) {
            this.mdo.a(this.dataSpec);
            this.mFb = true;
        }
    }
}
