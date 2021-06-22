package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f36037a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f36038b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f36039c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f36040d;

    /* renamed from: e  reason: collision with root package name */
    public int f36041e;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f36037a = bArr;
        int length = bArr.length;
        f36038b = length;
        f36039c = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f36040d = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i2;
        int i3 = this.f36041e;
        int read = (i3 < 2 || i3 > (i2 = f36039c)) ? super.read() : i3 == i2 ? this.f36040d : f36037a[i3 - 2] & 255;
        if (read != -1) {
            this.f36041e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = this.f36041e;
        int i6 = f36039c;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f36040d;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f36037a, this.f36041e - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f36041e += i4;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f36041e = (int) (this.f36041e + skip);
        }
        return skip;
    }
}
