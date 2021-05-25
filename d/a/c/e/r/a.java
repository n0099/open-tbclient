package d.a.c.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f38913e;

    /* renamed from: f  reason: collision with root package name */
    public final int f38914f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f38915g;

    public a(int i2, int i3) {
        this.f38913e = i2;
        this.f38914f = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        this.f38915g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f38915g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i2) {
        if (i2 > this.f38915g.capacity()) {
            ByteBuffer byteBuffer = this.f38915g;
            int position = this.f38915g.position();
            this.f38915g = ByteBuffer.allocateDirect(((i2 / this.f38914f) + 1) * this.f38914f);
            byteBuffer.clear();
            this.f38915g.clear();
            this.f38915g.put(byteBuffer);
            this.f38915g.position(position);
        }
    }

    public Buffer q() {
        return this.f38915g.flip();
    }

    public ByteBuffer r() {
        return this.f38915g;
    }

    public int s() {
        return this.f38915g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        if (this.f38915g.position() + 1 > this.f38915g.capacity()) {
            p(this.f38915g.capacity() + 1);
        }
        this.f38915g.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f38915g.position() + i3 > this.f38915g.capacity()) {
            p(this.f38915g.capacity() + i3);
        }
        this.f38915g.put(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
