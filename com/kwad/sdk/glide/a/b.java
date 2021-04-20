package com.kwad.sdk.glide.a;

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
    public final InputStream f35341a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f35342b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f35343c;

    /* renamed from: d  reason: collision with root package name */
    public int f35344d;

    /* renamed from: e  reason: collision with root package name */
    public int f35345e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f35347a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f35341a = inputStream;
        this.f35342b = charset;
        this.f35343c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f35341a;
        byte[] bArr = this.f35343c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f35344d = 0;
        this.f35345e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f35341a) {
            if (this.f35343c != null) {
                if (this.f35344d >= this.f35345e) {
                    c();
                }
                for (int i3 = this.f35344d; i3 != this.f35345e; i3++) {
                    if (this.f35343c[i3] == 10) {
                        if (i3 != this.f35344d) {
                            i2 = i3 - 1;
                            if (this.f35343c[i2] == 13) {
                                String str = new String(this.f35343c, this.f35344d, i2 - this.f35344d, this.f35342b.name());
                                this.f35344d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f35343c, this.f35344d, i2 - this.f35344d, this.f35342b.name());
                        this.f35344d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f35345e - this.f35344d) + 80) { // from class: com.kwad.sdk.glide.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f35342b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f35343c, this.f35344d, this.f35345e - this.f35344d);
                    this.f35345e = -1;
                    c();
                    i = this.f35344d;
                    while (i != this.f35345e) {
                        if (this.f35343c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f35344d) {
                    byteArrayOutputStream.write(this.f35343c, this.f35344d, i - this.f35344d);
                }
                this.f35344d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f35345e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f35341a) {
            if (this.f35343c != null) {
                this.f35343c = null;
                this.f35341a.close();
            }
        }
    }
}
