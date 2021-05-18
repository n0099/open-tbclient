package d.a.c.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f39249e;

    /* renamed from: f  reason: collision with root package name */
    public final int f39250f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f39251g;

    public a(int i2, int i3) {
        this.f39249e = i2;
        this.f39250f = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        this.f39251g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f39251g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i2) {
        if (i2 > this.f39251g.capacity()) {
            ByteBuffer byteBuffer = this.f39251g;
            int position = this.f39251g.position();
            this.f39251g = ByteBuffer.allocateDirect(((i2 / this.f39250f) + 1) * this.f39250f);
            byteBuffer.clear();
            this.f39251g.clear();
            this.f39251g.put(byteBuffer);
            this.f39251g.position(position);
        }
    }

    public Buffer q() {
        return this.f39251g.flip();
    }

    public ByteBuffer r() {
        return this.f39251g;
    }

    public int s() {
        return this.f39251g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        if (this.f39251g.position() + 1 > this.f39251g.capacity()) {
            p(this.f39251g.capacity() + 1);
        }
        this.f39251g.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f39251g.position() + i3 > this.f39251g.capacity()) {
            p(this.f39251g.capacity() + i3);
        }
        this.f39251g.put(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
