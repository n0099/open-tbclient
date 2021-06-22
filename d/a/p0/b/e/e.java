package d.a.p0.b.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f67694e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67695f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f67696g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f67697h;

    public e(d dVar) {
        this.f67694e = dVar;
    }

    public final void n() throws IOException {
        if (this.f67695f) {
            IOException iOException = this.f67697h;
            if (iOException != null) {
                throw iOException;
            }
        } else if (o()) {
        } else {
            if (this.f67696g == null) {
                this.f67696g = ByteBuffer.allocateDirect(32768);
            }
            this.f67696g.clear();
            this.f67694e.u(this.f67696g);
            IOException iOException2 = this.f67697h;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.f67696g;
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
        ByteBuffer byteBuffer = this.f67696g;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void p(IOException iOException) {
        this.f67697h = iOException;
        this.f67695f = true;
        this.f67696g = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        n();
        if (o()) {
            return this.f67696g.get() & 255;
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
            int min = Math.min(this.f67696g.limit() - this.f67696g.position(), i3);
            this.f67696g.get(bArr, i2, min);
            return min;
        }
        return -1;
    }
}
