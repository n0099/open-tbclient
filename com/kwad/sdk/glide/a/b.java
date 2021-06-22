package com.kwad.sdk.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes7.dex */
public class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f35824a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f35825b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f35826c;

    /* renamed from: d  reason: collision with root package name */
    public int f35827d;

    /* renamed from: e  reason: collision with root package name */
    public int f35828e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f35830a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f35824a = inputStream;
        this.f35825b = charset;
        this.f35826c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f35824a;
        byte[] bArr = this.f35826c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f35827d = 0;
        this.f35828e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.f35824a) {
            if (this.f35826c != null) {
                if (this.f35827d >= this.f35828e) {
                    c();
                }
                for (int i4 = this.f35827d; i4 != this.f35828e; i4++) {
                    if (this.f35826c[i4] == 10) {
                        if (i4 != this.f35827d) {
                            i3 = i4 - 1;
                            if (this.f35826c[i3] == 13) {
                                String str = new String(this.f35826c, this.f35827d, i3 - this.f35827d, this.f35825b.name());
                                this.f35827d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f35826c, this.f35827d, i3 - this.f35827d, this.f35825b.name());
                        this.f35827d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f35828e - this.f35827d) + 80) { // from class: com.kwad.sdk.glide.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f35825b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f35826c, this.f35827d, this.f35828e - this.f35827d);
                    this.f35828e = -1;
                    c();
                    i2 = this.f35827d;
                    while (i2 != this.f35828e) {
                        if (this.f35826c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f35827d) {
                    byteArrayOutputStream.write(this.f35826c, this.f35827d, i2 - this.f35827d);
                }
                this.f35827d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f35828e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f35824a) {
            if (this.f35826c != null) {
                this.f35826c = null;
                this.f35824a.close();
            }
        }
    }
}
