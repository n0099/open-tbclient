package com.kwad.sdk.core.diskcache.kwai;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public final class b implements Closeable {
    public final InputStream a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(com.kwad.sdk.crash.utils.a.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.b = charset;
        this.c = new byte[8192];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() {
        InputStream inputStream = this.a;
        byte[] bArr = this.c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }

    public final String a() {
        int i;
        int i2;
        synchronized (this.a) {
            if (this.c != null) {
                if (this.d >= this.e) {
                    b();
                }
                for (int i3 = this.d; i3 != this.e; i3++) {
                    if (this.c[i3] == 10) {
                        if (i3 != this.d) {
                            i2 = i3 - 1;
                            if (this.c[i2] == 13) {
                                String str = new String(this.c, this.d, i2 - this.d, this.b.name());
                                this.d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.c, this.d, i2 - this.d, this.b.name());
                        this.d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.e - this.d) + 80) { // from class: com.kwad.sdk.core.diskcache.kwai.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.b.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.c, this.d, this.e - this.d);
                    this.e = -1;
                    b();
                    i = this.d;
                    while (i != this.e) {
                        if (this.c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.d) {
                    byteArrayOutputStream.write(this.c, this.d, i - this.d);
                }
                this.d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                com.kwad.sdk.crash.utils.b.a(this.a);
            }
        }
    }
}
