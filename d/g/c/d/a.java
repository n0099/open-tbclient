package d.g.c.d;

import d.g.c.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f66312a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    @Override // d.g.c.d.f, d.g.c.d.j
    public /* bridge */ /* synthetic */ j a(int i2) {
        a(i2);
        return this;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public /* bridge */ /* synthetic */ j b(long j) {
        b(j);
        return this;
    }

    @Override // d.g.c.d.c, d.g.c.d.j
    public /* bridge */ /* synthetic */ j f(byte[] bArr) {
        j(bArr);
        return this;
    }

    @Override // d.g.c.d.c, d.g.c.d.f
    public f h(byte[] bArr, int i2, int i3) {
        n.v(i2, i2 + i3, bArr.length);
        p(bArr, i2, i3);
        return this;
    }

    @Override // d.g.c.d.f
    public f i(ByteBuffer byteBuffer) {
        n(byteBuffer);
        return this;
    }

    @Override // d.g.c.d.c
    public f j(byte[] bArr) {
        n.p(bArr);
        o(bArr);
        return this;
    }

    @Override // d.g.c.d.c
    public f k(char c2) {
        this.f66312a.putChar(c2);
        l(2);
        return this;
    }

    public final f l(int i2) {
        try {
            p(this.f66312a.array(), 0, i2);
            return this;
        } finally {
            this.f66312a.clear();
        }
    }

    public abstract void m(byte b2);

    public void n(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            p(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            m(byteBuffer.get());
        }
    }

    public void o(byte[] bArr) {
        p(bArr, 0, bArr.length);
    }

    public abstract void p(byte[] bArr, int i2, int i3);

    @Override // d.g.c.d.f, d.g.c.d.j
    public f a(int i2) {
        this.f66312a.putInt(i2);
        l(4);
        return this;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public f b(long j) {
        this.f66312a.putLong(j);
        l(8);
        return this;
    }
}
