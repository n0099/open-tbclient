package com.kwad.sdk.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f35643a;

    /* renamed from: b  reason: collision with root package name */
    public int f35644b;

    /* renamed from: c  reason: collision with root package name */
    public int f35645c;

    /* renamed from: d  reason: collision with root package name */
    public int f35646d;

    /* renamed from: e  reason: collision with root package name */
    public int f35647e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35648f;

    /* loaded from: classes6.dex */
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
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        super(inputStream);
        this.f35646d = -1;
        this.f35648f = bVar;
        this.f35643a = (byte[]) bVar.a(i, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i = this.f35646d;
        if (i != -1) {
            int i2 = this.f35647e - i;
            int i3 = this.f35645c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f35644b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f35648f.a(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f35643a = bArr2;
                    this.f35648f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f35646d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                int i5 = this.f35647e - this.f35646d;
                this.f35647e = i5;
                this.f35646d = 0;
                this.f35644b = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.f35647e;
                if (read > 0) {
                    i6 += read;
                }
                this.f35644b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f35646d = -1;
            this.f35647e = 0;
            this.f35644b = read2;
        }
        return read2;
    }

    public static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f35645c = this.f35643a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f35643a == null || inputStream == null) {
            throw c();
        }
        return (this.f35644b - this.f35647e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f35643a != null) {
            this.f35648f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f35643a);
            this.f35643a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f35643a != null) {
            this.f35648f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f35643a);
            this.f35643a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f35645c = Math.max(this.f35645c, i);
        this.f35646d = this.f35647e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f35643a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw c();
        }
        if (this.f35647e < this.f35644b || a(inputStream, bArr) != -1) {
            if (bArr != this.f35643a && (bArr = this.f35643a) == null) {
                throw c();
            }
            if (this.f35644b - this.f35647e > 0) {
                int i = this.f35647e;
                this.f35647e = i + 1;
                return bArr[i] & 255;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.f35643a;
        if (bArr2 == null) {
            throw c();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw c();
        }
        if (this.f35647e < this.f35644b) {
            int i5 = this.f35644b - this.f35647e >= i2 ? i2 : this.f35644b - this.f35647e;
            System.arraycopy(bArr2, this.f35647e, bArr, i, i5);
            this.f35647e += i5;
            if (i5 == i2 || inputStream.available() == 0) {
                return i5;
            }
            i += i5;
            i3 = i2 - i5;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.f35646d == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else if (a(inputStream, bArr2) == -1) {
                return i3 != i2 ? i2 - i3 : -1;
            } else {
                if (bArr2 != this.f35643a && (bArr2 = this.f35643a) == null) {
                    throw c();
                }
                i4 = this.f35644b - this.f35647e >= i3 ? i3 : this.f35644b - this.f35647e;
                System.arraycopy(bArr2, this.f35647e, bArr, i, i4);
                this.f35647e += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f35643a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f35646d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f35647e + " markLimit: " + this.f35645c);
        }
        this.f35647e = this.f35646d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f35643a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.f35644b - this.f35647e >= j) {
                    this.f35647e = (int) (this.f35647e + j);
                    return j;
                }
                long j2 = this.f35644b - this.f35647e;
                this.f35647e = this.f35644b;
                if (this.f35646d == -1 || j > this.f35645c) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    if (this.f35644b - this.f35647e >= j - j2) {
                        this.f35647e = (int) ((this.f35647e + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + this.f35644b) - this.f35647e;
                    this.f35647e = this.f35644b;
                    return j3;
                }
            }
            throw c();
        }
        throw c();
    }
}
