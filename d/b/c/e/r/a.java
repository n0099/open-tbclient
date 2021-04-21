package d.b.c.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f42791e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42792f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f42793g;

    public a(int i, int i2) {
        this.f42791e = i;
        this.f42792f = i2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        this.f42793g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f42793g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i) {
        if (i > this.f42793g.capacity()) {
            ByteBuffer byteBuffer = this.f42793g;
            int position = this.f42793g.position();
            this.f42793g = ByteBuffer.allocateDirect(((i / this.f42792f) + 1) * this.f42792f);
            byteBuffer.clear();
            this.f42793g.clear();
            this.f42793g.put(byteBuffer);
            this.f42793g.position(position);
        }
    }

    public Buffer q() {
        return this.f42793g.flip();
    }

    public ByteBuffer r() {
        return this.f42793g;
    }

    public int s() {
        return this.f42793g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.f42793g.position() + 1 > this.f42793g.capacity()) {
            p(this.f42793g.capacity() + 1);
        }
        this.f42793g.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.f42793g.position() + i2 > this.f42793g.capacity()) {
            p(this.f42793g.capacity() + i2);
        }
        this.f42793g.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
