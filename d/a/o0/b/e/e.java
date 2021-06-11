package d.a.o0.b.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f67590e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67591f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f67592g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f67593h;

    public e(d dVar) {
        this.f67590e = dVar;
    }

    public final void n() throws IOException {
        if (this.f67591f) {
            IOException iOException = this.f67593h;
            if (iOException != null) {
                throw iOException;
            }
        } else if (o()) {
        } else {
            if (this.f67592g == null) {
                this.f67592g = ByteBuffer.allocateDirect(32768);
            }
            this.f67592g.clear();
            this.f67590e.u(this.f67592g);
            IOException iOException2 = this.f67593h;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.f67592g;
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
        ByteBuffer byteBuffer = this.f67592g;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void p(IOException iOException) {
        this.f67593h = iOException;
        this.f67591f = true;
        this.f67592g = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        n();
        if (o()) {
            return this.f67592g.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        n();
        if (o()) {
            int min = Math.min(this.f67592g.limit() - this.f67592g.position(), i3);
            this.f67592g.get(bArr, i2, min);
            return min;
        }
        return -1;
    }
}
