package d.b.j0.b.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f63820e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63821f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f63822g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f63823h;

    public e(d dVar) {
        this.f63820e = dVar;
    }

    public final void n() throws IOException {
        if (this.f63821f) {
            IOException iOException = this.f63823h;
            if (iOException != null) {
                throw iOException;
            }
        } else if (o()) {
        } else {
            if (this.f63822g == null) {
                this.f63822g = ByteBuffer.allocateDirect(32768);
            }
            this.f63822g.clear();
            this.f63820e.u(this.f63822g);
            IOException iOException2 = this.f63823h;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.f63822g;
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
        ByteBuffer byteBuffer = this.f63822g;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void p(IOException iOException) {
        this.f63823h = iOException;
        this.f63821f = true;
        this.f63822g = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        n();
        if (o()) {
            return this.f63822g.get() & 255;
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
            int min = Math.min(this.f63822g.limit() - this.f63822g.position(), i2);
            this.f63822g.get(bArr, i, min);
            return min;
        }
        return -1;
    }
}
