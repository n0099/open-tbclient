package d.b.b.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f42053e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42054f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f42055g;

    public a(int i, int i2) {
        this.f42053e = i;
        this.f42054f = i2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        this.f42055g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f42055g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i) {
        if (i > this.f42055g.capacity()) {
            ByteBuffer byteBuffer = this.f42055g;
            int position = this.f42055g.position();
            this.f42055g = ByteBuffer.allocateDirect(((i / this.f42054f) + 1) * this.f42054f);
            byteBuffer.clear();
            this.f42055g.clear();
            this.f42055g.put(byteBuffer);
            this.f42055g.position(position);
        }
    }

    public Buffer q() {
        return this.f42055g.flip();
    }

    public ByteBuffer r() {
        return this.f42055g;
    }

    public int s() {
        return this.f42055g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.f42055g.position() + 1 > this.f42055g.capacity()) {
            p(this.f42055g.capacity() + 1);
        }
        this.f42055g.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.f42055g.position() + i2 > this.f42055g.capacity()) {
            p(this.f42055g.capacity() + i2);
        }
        this.f42055g.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
