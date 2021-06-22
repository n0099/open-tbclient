package com.kwad.sdk.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f36435a;

    /* renamed from: b  reason: collision with root package name */
    public int f36436b;

    /* renamed from: c  reason: collision with root package name */
    public int f36437c;

    /* renamed from: d  reason: collision with root package name */
    public int f36438d;

    /* renamed from: e  reason: collision with root package name */
    public int f36439e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36440f;

    /* loaded from: classes7.dex */
    public static class InvalidMarkException extends IOException {
        public static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(inputStream, bVar, 65536);
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i2) {
        super(inputStream);
        this.f36438d = -1;
        this.f36440f = bVar;
        this.f36435a = (byte[]) bVar.a(i2, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i2 = this.f36438d;
        if (i2 != -1) {
            int i3 = this.f36439e - i2;
            int i4 = this.f36437c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f36436b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f36440f.a(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f36435a = bArr2;
                    this.f36440f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f36438d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                int i6 = this.f36439e - this.f36438d;
                this.f36439e = i6;
                this.f36438d = 0;
                this.f36436b = 0;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                int i7 = this.f36439e;
                if (read > 0) {
                    i7 += read;
                }
                this.f36436b = i7;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f36438d = -1;
            this.f36439e = 0;
            this.f36436b = read2;
        }
        return read2;
    }

    public static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f36437c = this.f36435a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f36435a == null || inputStream == null) {
            throw c();
        }
        return (this.f36436b - this.f36439e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f36435a != null) {
            this.f36440f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f36435a);
            this.f36435a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f36435a != null) {
            this.f36440f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f36435a);
            this.f36435a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f36437c = Math.max(this.f36437c, i2);
        this.f36438d = this.f36439e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f36435a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw c();
        }
        if (this.f36439e < this.f36436b || a(inputStream, bArr) != -1) {
            if (bArr != this.f36435a && (bArr = this.f36435a) == null) {
                throw c();
            }
            if (this.f36436b - this.f36439e > 0) {
                int i2 = this.f36439e;
                this.f36439e = i2 + 1;
                return bArr[i2] & 255;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        byte[] bArr2 = this.f36435a;
        if (bArr2 == null) {
            throw c();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw c();
        }
        if (this.f36439e < this.f36436b) {
            int i6 = this.f36436b - this.f36439e >= i3 ? i3 : this.f36436b - this.f36439e;
            System.arraycopy(bArr2, this.f36439e, bArr, i2, i6);
            this.f36439e += i6;
            if (i6 == i3 || inputStream.available() == 0) {
                return i6;
            }
            i2 += i6;
            i4 = i3 - i6;
        } else {
            i4 = i3;
        }
        while (true) {
            if (this.f36438d == -1 && i4 >= bArr2.length) {
                i5 = inputStream.read(bArr, i2, i4);
                if (i5 == -1) {
                    return i4 != i3 ? i3 - i4 : -1;
                }
            } else if (a(inputStream, bArr2) == -1) {
                return i4 != i3 ? i3 - i4 : -1;
            } else {
                if (bArr2 != this.f36435a && (bArr2 = this.f36435a) == null) {
                    throw c();
                }
                i5 = this.f36436b - this.f36439e >= i4 ? i4 : this.f36436b - this.f36439e;
                System.arraycopy(bArr2, this.f36439e, bArr, i2, i5);
                this.f36439e += i5;
            }
            i4 -= i5;
            if (i4 == 0) {
                return i3;
            }
            if (inputStream.available() == 0) {
                return i3 - i4;
            }
            i2 += i5;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f36435a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f36438d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f36439e + " markLimit: " + this.f36437c);
        }
        this.f36439e = this.f36438d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f36435a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.f36436b - this.f36439e >= j) {
                    this.f36439e = (int) (this.f36439e + j);
                    return j;
                }
                long j2 = this.f36436b - this.f36439e;
                this.f36439e = this.f36436b;
                if (this.f36438d == -1 || j > this.f36437c) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    if (this.f36436b - this.f36439e >= j - j2) {
                        this.f36439e = (int) ((this.f36439e + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + this.f36436b) - this.f36439e;
                    this.f36439e = this.f36436b;
                    return j3;
                }
            }
            throw c();
        }
        throw c();
    }
}
