package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class f extends InputStream {
    private final g dataSpec;
    private final e mdW;
    private long totalBytesRead;
    private boolean mFK = false;
    private boolean closed = false;
    private final byte[] mFO = new byte[1];

    public f(e eVar, g gVar) {
        this.mdW = eVar;
        this.dataSpec = gVar;
    }

    public long dyW() {
        return this.totalBytesRead;
    }

    public void open() throws IOException {
        dyX();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mFO) == -1) {
            return -1;
        }
        return this.mFO[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(!this.closed);
        dyX();
        int read = this.mdW.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.totalBytesRead += read;
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.mdW.close();
            this.closed = true;
        }
    }

    private void dyX() throws IOException {
        if (!this.mFK) {
            this.mdW.a(this.dataSpec);
            this.mFK = true;
        }
    }
}
