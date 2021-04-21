package g.b.a;

import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public class b extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public byte[] f68734e;

    /* renamed from: f  reason: collision with root package name */
    public int f68735f;

    /* renamed from: g  reason: collision with root package name */
    public int f68736g;

    /* renamed from: h  reason: collision with root package name */
    public final j f68737h;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.a(this.f68737h);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f68736g >= this.f68735f) {
            byte[] bArr = this.f68734e;
            int read = read(bArr, 0, bArr.length);
            this.f68735f = read;
            this.f68736g = 0;
            if (read == -1) {
                return -1;
            }
        }
        byte[] bArr2 = this.f68734e;
        int i = this.f68736g;
        this.f68736g = i + 1;
        return bArr2[i] & 255;
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        j jVar = new j();
        this.f68737h = jVar;
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        } else if (inputStream != null) {
            this.f68734e = new byte[i];
            this.f68735f = 0;
            this.f68736g = 0;
            try {
                j.c(jVar, inputStream);
                if (bArr != null) {
                    d.s(this.f68737h, bArr);
                }
            } catch (BrotliRuntimeException e2) {
                throw new IOException("Brotli decoder initialization failed", e2);
            }
        } else {
            throw new IllegalArgumentException("source is null");
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Bad offset: " + i);
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                throw new IllegalArgumentException("Buffer overflow: " + i3 + " > " + bArr.length);
            } else if (i2 == 0) {
                return 0;
            } else {
                int max = Math.max(this.f68735f - this.f68736g, 0);
                if (max != 0) {
                    max = Math.min(max, i2);
                    System.arraycopy(this.f68734e, this.f68736g, bArr, i, max);
                    this.f68736g += max;
                    i += max;
                    i2 -= max;
                    if (i2 == 0) {
                        return max;
                    }
                }
                try {
                    this.f68737h.Z = bArr;
                    this.f68737h.U = i;
                    this.f68737h.V = i2;
                    this.f68737h.W = 0;
                    d.i(this.f68737h);
                    if (this.f68737h.W == 0) {
                        return -1;
                    }
                    return this.f68737h.W + max;
                } catch (BrotliRuntimeException e2) {
                    throw new IOException("Brotli stream decoding failed", e2);
                }
            }
        } else {
            throw new IllegalArgumentException("Bad length: " + i2);
        }
    }
}
