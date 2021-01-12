package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f9072a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f9073b;
    private byte[] c;
    private int d;
    private int e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f9075a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f9072a = inputStream;
        this.f9073b = charset;
        this.c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        int read = this.f9072a.read(this.c, 0, this.c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }

    public String a() {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f9072a) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                c();
            }
            int i2 = this.d;
            while (true) {
                if (i2 == this.e) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((this.e - this.d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                        @Override // java.io.ByteArrayOutputStream
                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, b.this.f9073b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1: while (true) {
                        byteArrayOutputStream2.write(this.c, this.d, this.e - this.d);
                        this.e = -1;
                        c();
                        i = this.d;
                        while (i != this.e) {
                            if (this.c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.d) {
                        byteArrayOutputStream2.write(this.c, this.d, i - this.d);
                    }
                    this.d = i + 1;
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                } else if (this.c[i2] == 10) {
                    byteArrayOutputStream = new String(this.c, this.d, ((i2 == this.d || this.c[i2 + (-1)] != 13) ? i2 : i2 - 1) - this.d, this.f9073b.name());
                    this.d = i2 + 1;
                } else {
                    i2++;
                }
            }
            return byteArrayOutputStream;
        }
    }

    public boolean b() {
        return this.e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f9072a) {
            if (this.c != null) {
                this.c = null;
                this.f9072a.close();
            }
        }
    }
}
