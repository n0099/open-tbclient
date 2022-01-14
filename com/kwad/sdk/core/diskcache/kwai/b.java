package com.kwad.sdk.core.diskcache.kwai;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public class b implements Closeable {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f55695b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f55696c;

    /* renamed from: d  reason: collision with root package name */
    public int f55697d;

    /* renamed from: e  reason: collision with root package name */
    public int f55698e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.f55695b = charset;
        this.f55696c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.a;
        byte[] bArr = this.f55696c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f55697d = 0;
        this.f55698e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.a) {
            if (this.f55696c != null) {
                if (this.f55697d >= this.f55698e) {
                    c();
                }
                for (int i4 = this.f55697d; i4 != this.f55698e; i4++) {
                    if (this.f55696c[i4] == 10) {
                        if (i4 != this.f55697d) {
                            i3 = i4 - 1;
                            if (this.f55696c[i3] == 13) {
                                String str = new String(this.f55696c, this.f55697d, i3 - this.f55697d, this.f55695b.name());
                                this.f55697d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f55696c, this.f55697d, i3 - this.f55697d, this.f55695b.name());
                        this.f55697d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f55698e - this.f55697d) + 80) { // from class: com.kwad.sdk.core.diskcache.kwai.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f55695b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f55696c, this.f55697d, this.f55698e - this.f55697d);
                    this.f55698e = -1;
                    c();
                    i2 = this.f55697d;
                    while (i2 != this.f55698e) {
                        if (this.f55696c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f55697d) {
                    byteArrayOutputStream.write(this.f55696c, this.f55697d, i2 - this.f55697d);
                }
                this.f55697d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f55698e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (this.f55696c != null) {
                this.f55696c = null;
                this.a.close();
            }
        }
    }
}
