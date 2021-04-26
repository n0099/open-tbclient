package g.b.a;

import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public class b extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public byte[] f67592e;

    /* renamed from: f  reason: collision with root package name */
    public int f67593f;

    /* renamed from: g  reason: collision with root package name */
    public int f67594g;

    /* renamed from: h  reason: collision with root package name */
    public final j f67595h;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.a(this.f67595h);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f67594g >= this.f67593f) {
            byte[] bArr = this.f67592e;
            int read = read(bArr, 0, bArr.length);
            this.f67593f = read;
            this.f67594g = 0;
            if (read == -1) {
                return -1;
            }
        }
        byte[] bArr2 = this.f67592e;
        int i2 = this.f67594g;
        this.f67594g = i2 + 1;
        return bArr2[i2] & 255;
    }

    public b(InputStream inputStream, int i2, byte[] bArr) throws IOException {
        j jVar = new j();
        this.f67595h = jVar;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i2);
        } else if (inputStream != null) {
            this.f67592e = new byte[i2];
            this.f67593f = 0;
            this.f67594g = 0;
            try {
                j.c(jVar, inputStream);
                if (bArr != null) {
                    d.s(this.f67595h, bArr);
                }
            } catch (BrotliRuntimeException e2) {
                throw new IOException("Brotli decoder initialization failed", e2);
            }
        } else {
            throw new IllegalArgumentException("source is null");
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Bad offset: " + i2);
        } else if (i3 >= 0) {
            int i4 = i2 + i3;
            if (i4 > bArr.length) {
                throw new IllegalArgumentException("Buffer overflow: " + i4 + " > " + bArr.length);
            } else if (i3 == 0) {
                return 0;
            } else {
                int max = Math.max(this.f67593f - this.f67594g, 0);
                if (max != 0) {
                    max = Math.min(max, i3);
                    System.arraycopy(this.f67592e, this.f67594g, bArr, i2, max);
                    this.f67594g += max;
                    i2 += max;
                    i3 -= max;
                    if (i3 == 0) {
                        return max;
                    }
                }
                try {
                    this.f67595h.Z = bArr;
                    this.f67595h.U = i2;
                    this.f67595h.V = i3;
                    this.f67595h.W = 0;
                    d.i(this.f67595h);
                    if (this.f67595h.W == 0) {
                        return -1;
                    }
                    return this.f67595h.W + max;
                } catch (BrotliRuntimeException e2) {
                    throw new IOException("Brotli stream decoding failed", e2);
                }
            }
        } else {
            throw new IllegalArgumentException("Bad length: " + i3);
        }
    }
}
