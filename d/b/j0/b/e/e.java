package d.b.j0.b.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f64521e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64522f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f64523g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f64524h;

    public e(d dVar) {
        this.f64521e = dVar;
    }

    public final void n() throws IOException {
        if (this.f64522f) {
            IOException iOException = this.f64524h;
            if (iOException != null) {
                throw iOException;
            }
        } else if (o()) {
        } else {
            if (this.f64523g == null) {
                this.f64523g = ByteBuffer.allocateDirect(32768);
            }
            this.f64523g.clear();
            this.f64521e.u(this.f64523g);
            IOException iOException2 = this.f64524h;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.f64523g;
                if (byteBuffer != null) {
                    byteBuffer.flip();
                    return;
                }
                return;
            }
            throw iOException2;
        }
    }

    public final boolean o() {
        ByteBuffer byteBuffer = this.f64523g;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void p(IOException iOException) {
        this.f64524h = iOException;
        this.f64522f = true;
        this.f64523g = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        n();
        if (o()) {
            return this.f64523g.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        n();
        if (o()) {
            int min = Math.min(this.f64523g.limit() - this.f64523g.position(), i2);
            this.f64523g.get(bArr, i, min);
            return min;
        }
        return -1;
    }
}
