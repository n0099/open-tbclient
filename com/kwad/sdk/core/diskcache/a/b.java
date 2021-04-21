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
    public final InputStream f33881a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f33882b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33883c;

    /* renamed from: d  reason: collision with root package name */
    public int f33884d;

    /* renamed from: e  reason: collision with root package name */
    public int f33885e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f33887a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f33881a = inputStream;
        this.f33882b = charset;
        this.f33883c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f33881a;
        byte[] bArr = this.f33883c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f33884d = 0;
        this.f33885e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f33881a) {
            if (this.f33883c != null) {
                if (this.f33884d >= this.f33885e) {
                    c();
                }
                for (int i3 = this.f33884d; i3 != this.f33885e; i3++) {
                    if (this.f33883c[i3] == 10) {
                        if (i3 != this.f33884d) {
                            i2 = i3 - 1;
                            if (this.f33883c[i2] == 13) {
                                String str = new String(this.f33883c, this.f33884d, i2 - this.f33884d, this.f33882b.name());
                                this.f33884d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f33883c, this.f33884d, i2 - this.f33884d, this.f33882b.name());
                        this.f33884d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f33885e - this.f33884d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f33882b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f33883c, this.f33884d, this.f33885e - this.f33884d);
                    this.f33885e = -1;
                    c();
                    i = this.f33884d;
                    while (i != this.f33885e) {
                        if (this.f33883c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f33884d) {
                    byteArrayOutputStream.write(this.f33883c, this.f33884d, i - this.f33884d);
                }
                this.f33884d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f33885e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f33881a) {
            if (this.f33883c != null) {
                this.f33883c = null;
                this.f33881a.close();
            }
        }
    }
}
