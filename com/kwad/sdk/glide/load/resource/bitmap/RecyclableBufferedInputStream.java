package com.kwad.sdk.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f36028a;

    /* renamed from: b  reason: collision with root package name */
    public int f36029b;

    /* renamed from: c  reason: collision with root package name */
    public int f36030c;

    /* renamed from: d  reason: collision with root package name */
    public int f36031d;

    /* renamed from: e  reason: collision with root package name */
    public int f36032e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36033f;

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
        this.f36031d = -1;
        this.f36033f = bVar;
        this.f36028a = (byte[]) bVar.a(i, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i = this.f36031d;
        if (i != -1) {
            int i2 = this.f36032e - i;
            int i3 = this.f36030c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f36029b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f36033f.a(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f36028a = bArr2;
                    this.f36033f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f36031d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                int i5 = this.f36032e - this.f36031d;
                this.f36032e = i5;
                this.f36031d = 0;
                this.f36029b = 0;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.f36032e;
                if (read > 0) {
                    i6 += read;
                }
                this.f36029b = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f36031d = -1;
            this.f36032e = 0;
            this.f36029b = read2;
        }
        return read2;
    }

    public static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f36030c = this.f36028a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f36028a == null || inputStream == null) {
            throw c();
        }
        return (this.f36029b - this.f36032e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f36028a != null) {
            this.f36033f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f36028a);
            this.f36028a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f36028a != null) {
            this.f36033f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f36028a);
            this.f36028a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f36030c = Math.max(this.f36030c, i);
        this.f36031d = this.f36032e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f36028a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw c();
        }
        if (this.f36032e < this.f36029b || a(inputStream, bArr) != -1) {
            if (bArr != this.f36028a && (bArr = this.f36028a) == null) {
                throw c();
            }
            if (this.f36029b - this.f36032e > 0) {
                int i = this.f36032e;
                this.f36032e = i + 1;
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
        byte[] bArr2 = this.f36028a;
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
        if (this.f36032e < this.f36029b) {
            int i5 = this.f36029b - this.f36032e >= i2 ? i2 : this.f36029b - this.f36032e;
            System.arraycopy(bArr2, this.f36032e, bArr, i, i5);
            this.f36032e += i5;
            if (i5 == i2 || inputStream.available() == 0) {
                return i5;
            }
            i += i5;
            i3 = i2 - i5;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.f36031d == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else if (a(inputStream, bArr2) == -1) {
                return i3 != i2 ? i2 - i3 : -1;
            } else {
                if (bArr2 != this.f36028a && (bArr2 = this.f36028a) == null) {
                    throw c();
                }
                i4 = this.f36029b - this.f36032e >= i3 ? i3 : this.f36029b - this.f36032e;
                System.arraycopy(bArr2, this.f36032e, bArr, i, i4);
                this.f36032e += i4;
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
        if (this.f36028a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f36031d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f36032e + " markLimit: " + this.f36030c);
        }
        this.f36032e = this.f36031d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f36028a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.f36029b - this.f36032e >= j) {
                    this.f36032e = (int) (this.f36032e + j);
                    return j;
                }
                long j2 = this.f36029b - this.f36032e;
                this.f36032e = this.f36029b;
                if (this.f36031d == -1 || j > this.f36030c) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    if (this.f36029b - this.f36032e >= j - j2) {
                        this.f36032e = (int) ((this.f36032e + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + this.f36029b) - this.f36032e;
                    this.f36032e = this.f36029b;
                    return j3;
                }
            }
            throw c();
        }
        throw c();
    }
}
