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
    public final InputStream f35726a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f35727b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f35728c;

    /* renamed from: d  reason: collision with root package name */
    public int f35729d;

    /* renamed from: e  reason: collision with root package name */
    public int f35730e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f35732a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f35726a = inputStream;
        this.f35727b = charset;
        this.f35728c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f35726a;
        byte[] bArr = this.f35728c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f35729d = 0;
        this.f35730e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.f35726a) {
            if (this.f35728c != null) {
                if (this.f35729d >= this.f35730e) {
                    c();
                }
                for (int i4 = this.f35729d; i4 != this.f35730e; i4++) {
                    if (this.f35728c[i4] == 10) {
                        if (i4 != this.f35729d) {
                            i3 = i4 - 1;
                            if (this.f35728c[i3] == 13) {
                                String str = new String(this.f35728c, this.f35729d, i3 - this.f35729d, this.f35727b.name());
                                this.f35729d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f35728c, this.f35729d, i3 - this.f35729d, this.f35727b.name());
                        this.f35729d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f35730e - this.f35729d) + 80) { // from class: com.kwad.sdk.glide.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f35727b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f35728c, this.f35729d, this.f35730e - this.f35729d);
                    this.f35730e = -1;
                    c();
                    i2 = this.f35729d;
                    while (i2 != this.f35730e) {
                        if (this.f35728c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f35729d) {
                    byteArrayOutputStream.write(this.f35728c, this.f35729d, i2 - this.f35729d);
                }
                this.f35729d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f35730e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f35726a) {
            if (this.f35728c != null) {
                this.f35728c = null;
                this.f35726a.close();
            }
        }
    }
}
