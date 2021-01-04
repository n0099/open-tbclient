package com.kwad.sdk.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f10563a;

    /* renamed from: b  reason: collision with root package name */
    private int f10564b;
    private int c;
    private int d;
    private int e;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f;

    /* loaded from: classes5.dex */
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(inputStream, bVar, 65536);
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        super(inputStream);
        this.d = -1;
        this.f = bVar;
        this.f10563a = (byte[]) bVar.a(i, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        if (this.d == -1 || this.e - this.d >= this.c) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.d = -1;
                this.e = 0;
                this.f10564b = read;
                return read;
            }
            return read;
        }
        if (this.d == 0 && this.c > bArr.length && this.f10564b == bArr.length) {
            int length = bArr.length * 2;
            if (length > this.c) {
                length = this.c;
            }
            byte[] bArr2 = (byte[]) this.f.a(length, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f10563a = bArr2;
            this.f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            bArr = bArr2;
        } else if (this.d > 0) {
            System.arraycopy(bArr, this.d, bArr, 0, bArr.length - this.d);
        }
        this.e -= this.d;
        this.d = 0;
        this.f10564b = 0;
        int read2 = inputStream.read(bArr, this.e, bArr.length - this.e);
        this.f10564b = read2 <= 0 ? this.e : this.e + read2;
        return read2;
    }

    private static IOException c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.c = this.f10563a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f10563a == null || inputStream == null) {
            throw c();
        }
        return inputStream.available() + (this.f10564b - this.e);
    }

    public synchronized void b() {
        if (this.f10563a != null) {
            this.f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f10563a);
            this.f10563a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f10563a != null) {
            this.f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f10563a);
            this.f10563a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.f10563a;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw c();
            }
            if (this.e < this.f10564b || a(inputStream, bArr) != -1) {
                if (bArr != this.f10563a && (bArr = this.f10563a) == null) {
                    throw c();
                }
                if (this.f10564b - this.e > 0) {
                    int i2 = this.e;
                    this.e = i2 + 1;
                    i = bArr[i2] & 255;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0090 A[Catch: all -> 0x000b, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x0006, B:7:0x000a, B:15:0x0013, B:17:0x0017, B:18:0x001b, B:19:0x001c, B:21:0x0022, B:24:0x002a, B:26:0x0036, B:30:0x0044, B:31:0x0047, B:33:0x004b, B:35:0x004e, B:38:0x0056, B:54:0x0085, B:58:0x0090, B:40:0x005b, B:43:0x0063, B:44:0x0066, B:46:0x006a, B:48:0x006e, B:49:0x0072, B:50:0x0073, B:53:0x007b, B:57:0x008a, B:29:0x003e), top: B:62:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0088 A[SYNTHETIC] */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5 = -1;
        synchronized (this) {
            byte[] bArr2 = this.f10563a;
            if (bArr2 == null) {
                throw c();
            }
            if (i2 == 0) {
                i5 = 0;
            } else {
                InputStream inputStream = this.in;
                if (inputStream == null) {
                    throw c();
                }
                if (this.e < this.f10564b) {
                    int i6 = this.f10564b - this.e >= i2 ? i2 : this.f10564b - this.e;
                    System.arraycopy(bArr2, this.e, bArr, i, i6);
                    this.e += i6;
                    if (i6 == i2 || inputStream.available() == 0) {
                        i5 = i6;
                    } else {
                        i += i6;
                        i3 = i2 - i6;
                    }
                } else {
                    i3 = i2;
                }
                while (true) {
                    if (this.d == -1 && i3 >= bArr2.length) {
                        i4 = inputStream.read(bArr, i, i3);
                        if (i4 == -1) {
                            if (i3 != i2) {
                                i5 = i2 - i3;
                            }
                        }
                        i3 -= i4;
                        if (i3 != 0) {
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        if (i3 != i2) {
                            i5 = i2 - i3;
                        }
                    } else if (bArr2 != this.f10563a && (bArr2 = this.f10563a) == null) {
                        throw c();
                    } else {
                        i4 = this.f10564b - this.e >= i3 ? i3 : this.f10564b - this.e;
                        System.arraycopy(bArr2, this.e, bArr, i, i4);
                        this.e += i4;
                        i3 -= i4;
                        if (i3 != 0) {
                            i5 = i2;
                            break;
                        } else if (inputStream.available() == 0) {
                            i5 = i2 - i3;
                            break;
                        } else {
                            i += i4;
                        }
                    }
                }
            }
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f10563a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
        }
        this.e = this.d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            j = 0;
        } else {
            byte[] bArr = this.f10563a;
            if (bArr == null) {
                throw c();
            }
            InputStream inputStream = this.in;
            if (inputStream == null) {
                throw c();
            }
            if (this.f10564b - this.e >= j) {
                this.e = (int) (this.e + j);
            } else {
                long j2 = this.f10564b - this.e;
                this.e = this.f10564b;
                if (this.d == -1 || j > this.c) {
                    j = j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    j = j2;
                } else if (this.f10564b - this.e >= j - j2) {
                    this.e = (int) ((this.e + j) - j2);
                } else {
                    j = (j2 + this.f10564b) - this.e;
                    this.e = this.f10564b;
                }
            }
        }
        return j;
    }
}
