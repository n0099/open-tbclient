package d.a.a0.k.f;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public class b implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final InputStream f38404e;

    /* renamed from: f  reason: collision with root package name */
    public final Charset f38405f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f38406g;

    /* renamed from: h  reason: collision with root package name */
    public int f38407h;

    /* renamed from: i  reason: collision with root package name */
    public int f38408i;

    /* loaded from: classes2.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
            if (((java.io.ByteArrayOutputStream) r5).buf[r0] == 13) goto L5;
         */
        @Override // java.io.ByteArrayOutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            int i2;
            int i3 = ((ByteArrayOutputStream) this).count;
            if (i3 > 0) {
                i2 = i3 - 1;
            }
            i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.f38405f.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f38404e) {
            if (this.f38406g != null) {
                this.f38406g = null;
                this.f38404e.close();
            }
        }
    }

    public boolean n() {
        return this.f38408i == -1;
    }

    public String q() {
        int i2;
        int i3;
        synchronized (this.f38404e) {
            if (this.f38406g != null) {
                if (this.f38407h >= this.f38408i) {
                    r();
                }
                for (int i4 = this.f38407h; i4 != this.f38408i; i4++) {
                    if (this.f38406g[i4] == 10) {
                        if (i4 != this.f38407h) {
                            i3 = i4 - 1;
                            if (this.f38406g[i3] == 13) {
                                String str = new String(this.f38406g, this.f38407h, i3 - this.f38407h, this.f38405f.name());
                                this.f38407h = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f38406g, this.f38407h, i3 - this.f38407h, this.f38405f.name());
                        this.f38407h = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f38408i - this.f38407h) + 80);
                loop1: while (true) {
                    aVar.write(this.f38406g, this.f38407h, this.f38408i - this.f38407h);
                    this.f38408i = -1;
                    r();
                    i2 = this.f38407h;
                    while (i2 != this.f38408i) {
                        if (this.f38406g[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f38407h) {
                    aVar.write(this.f38406g, this.f38407h, i2 - this.f38407h);
                }
                this.f38407h = i2 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void r() {
        InputStream inputStream = this.f38404e;
        byte[] bArr = this.f38406g;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f38407h = 0;
            this.f38408i = read;
            return;
        }
        throw new EOFException();
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 >= 0) {
            if (charset.equals(c.f38410a)) {
                this.f38404e = inputStream;
                this.f38405f = charset;
                this.f38406g = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
