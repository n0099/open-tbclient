package d.a.o0.b.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f63872e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63873f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f63874g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f63875h;

    public e(d dVar) {
        this.f63872e = dVar;
    }

    public final void n() throws IOException {
        if (this.f63873f) {
            IOException iOException = this.f63875h;
            if (iOException != null) {
                throw iOException;
            }
        } else if (o()) {
        } else {
            if (this.f63874g == null) {
                this.f63874g = ByteBuffer.allocateDirect(32768);
            }
            this.f63874g.clear();
            this.f63872e.u(this.f63874g);
            IOException iOException2 = this.f63875h;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.f63874g;
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
        ByteBuffer byteBuffer = this.f63874g;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void p(IOException iOException) {
        this.f63875h = iOException;
        this.f63873f = true;
        this.f63874g = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        n();
        if (o()) {
            return this.f63874g.get() & 255;
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
            int min = Math.min(this.f63874g.limit() - this.f63874g.position(), i3);
            this.f63874g.get(bArr, i2, min);
            return min;
        }
        return -1;
    }
}
