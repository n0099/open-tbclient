package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f33496a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f33497b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33498c;

    /* renamed from: d  reason: collision with root package name */
    public int f33499d;

    /* renamed from: e  reason: collision with root package name */
    public int f33500e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f33502a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f33496a = inputStream;
        this.f33497b = charset;
        this.f33498c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f33496a;
        byte[] bArr = this.f33498c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f33499d = 0;
        this.f33500e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f33496a) {
            if (this.f33498c != null) {
                if (this.f33499d >= this.f33500e) {
                    c();
                }
                for (int i3 = this.f33499d; i3 != this.f33500e; i3++) {
                    if (this.f33498c[i3] == 10) {
                        if (i3 != this.f33499d) {
                            i2 = i3 - 1;
                            if (this.f33498c[i2] == 13) {
                                String str = new String(this.f33498c, this.f33499d, i2 - this.f33499d, this.f33497b.name());
                                this.f33499d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f33498c, this.f33499d, i2 - this.f33499d, this.f33497b.name());
                        this.f33499d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f33500e - this.f33499d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f33497b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f33498c, this.f33499d, this.f33500e - this.f33499d);
                    this.f33500e = -1;
                    c();
                    i = this.f33499d;
                    while (i != this.f33500e) {
                        if (this.f33498c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f33499d) {
                    byteArrayOutputStream.write(this.f33498c, this.f33499d, i - this.f33499d);
                }
                this.f33499d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f33500e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f33496a) {
            if (this.f33498c != null) {
                this.f33498c = null;
                this.f33496a.close();
            }
        }
    }
}
