package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f6648a = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    private static final int b = f6648a.length;
    private static final int c = b + 2;
    private final byte d;
    private int e;

    public g(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.d = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = (this.e < 2 || this.e > c) ? super.read() : this.e == c ? this.d : f6648a[this.e - 2] & 255;
        if (read != -1) {
            this.e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int min;
        if (this.e > c) {
            min = super.read(bArr, i, i2);
        } else if (this.e == c) {
            bArr[i] = this.d;
            min = 1;
        } else if (this.e < 2) {
            min = super.read(bArr, i, 2 - this.e);
        } else {
            min = Math.min(c - this.e, i2);
            System.arraycopy(f6648a, this.e - 2, bArr, i, min);
        }
        if (min > 0) {
            this.e += min;
        }
        return min;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.e = (int) (this.e + skip);
        }
        return skip;
    }
}
