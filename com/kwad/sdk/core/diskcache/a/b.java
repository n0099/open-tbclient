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
    public final InputStream f33497a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f33498b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33499c;

    /* renamed from: d  reason: collision with root package name */
    public int f33500d;

    /* renamed from: e  reason: collision with root package name */
    public int f33501e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f33503a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f33497a = inputStream;
        this.f33498b = charset;
        this.f33499c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f33497a;
        byte[] bArr = this.f33499c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f33500d = 0;
        this.f33501e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f33497a) {
            if (this.f33499c != null) {
                if (this.f33500d >= this.f33501e) {
                    c();
                }
                for (int i3 = this.f33500d; i3 != this.f33501e; i3++) {
                    if (this.f33499c[i3] == 10) {
                        if (i3 != this.f33500d) {
                            i2 = i3 - 1;
                            if (this.f33499c[i2] == 13) {
                                String str = new String(this.f33499c, this.f33500d, i2 - this.f33500d, this.f33498b.name());
                                this.f33500d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f33499c, this.f33500d, i2 - this.f33500d, this.f33498b.name());
                        this.f33500d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f33501e - this.f33500d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f33498b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f33499c, this.f33500d, this.f33501e - this.f33500d);
                    this.f33501e = -1;
                    c();
                    i = this.f33500d;
                    while (i != this.f33501e) {
                        if (this.f33499c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f33500d) {
                    byteArrayOutputStream.write(this.f33499c, this.f33500d, i - this.f33500d);
                }
                this.f33500d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f33501e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f33497a) {
            if (this.f33499c != null) {
                this.f33499c = null;
                this.f33497a.close();
            }
        }
    }
}
