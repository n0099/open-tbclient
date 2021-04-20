package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f35545a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f35546b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f35547c;

    /* renamed from: d  reason: collision with root package name */
    public final byte f35548d;

    /* renamed from: e  reason: collision with root package name */
    public int f35549e;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f35545a = bArr;
        int length = bArr.length;
        f35546b = length;
        f35547c = length + 2;
    }

    public g(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.f35548d = (byte) i;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
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
        int i;
        int i2 = this.f35549e;
        int read = (i2 < 2 || i2 > (i = f35547c)) ? super.read() : i2 == i ? this.f35548d : f35545a[i2 - 2] & 255;
        if (read != -1) {
            this.f35549e++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.f35549e;
        int i5 = f35547c;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f35548d;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(f35545a, this.f35549e - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f35549e += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f35549e = (int) (this.f35549e + skip);
        }
        return skip;
    }
}
