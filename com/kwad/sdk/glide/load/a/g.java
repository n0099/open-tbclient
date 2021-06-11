package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f35939a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f35940b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f35941c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f35942d;

    /* renamed from: e  reason: collision with root package name */
    public int f35943e;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f35939a = bArr;
        int length = bArr.length;
        f35940b = length;
        f35941c = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f35942d = (byte) i2;
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
        int i3 = this.f35943e;
        int read = (i3 < 2 || i3 > (i2 = f35941c)) ? super.read() : i3 == i2 ? this.f35942d : f35939a[i3 - 2] & 255;
        if (read != -1) {
            this.f35943e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) {
        int i4;
        int i5 = this.f35943e;
        int i6 = f35941c;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f35942d;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f35939a, this.f35943e - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f35943e += i4;
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
            this.f35943e = (int) (this.f35943e + skip);
        }
        return skip;
    }
}
