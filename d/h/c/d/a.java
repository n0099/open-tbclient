package d.h.c.d;

import d.h.c.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f67167a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    @Override // d.h.c.d.f, d.h.c.d.j
    public /* bridge */ /* synthetic */ j b(int i) {
        b(i);
        return this;
    }

    @Override // d.h.c.d.f, d.h.c.d.j
    public /* bridge */ /* synthetic */ j d(long j) {
        d(j);
        return this;
    }

    @Override // d.h.c.d.c, d.h.c.d.j
    public /* bridge */ /* synthetic */ j e(byte[] bArr) {
        j(bArr);
        return this;
    }

    @Override // d.h.c.d.c, d.h.c.d.f
    public f h(byte[] bArr, int i, int i2) {
        n.v(i, i + i2, bArr.length);
        p(bArr, i, i2);
        return this;
    }

    @Override // d.h.c.d.f
    public f i(ByteBuffer byteBuffer) {
        n(byteBuffer);
        return this;
    }

    @Override // d.h.c.d.c
    public f j(byte[] bArr) {
        n.p(bArr);
        o(bArr);
        return this;
    }

    @Override // d.h.c.d.c
    public f k(char c2) {
        this.f67167a.putChar(c2);
        l(2);
        return this;
    }

    public final f l(int i) {
        try {
            p(this.f67167a.array(), 0, i);
            return this;
        } finally {
            this.f67167a.clear();
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

    public abstract void p(byte[] bArr, int i, int i2);

    @Override // d.h.c.d.f, d.h.c.d.j
    public f b(int i) {
        this.f67167a.putInt(i);
        l(4);
        return this;
    }

    @Override // d.h.c.d.f, d.h.c.d.j
    public f d(long j) {
        this.f67167a.putLong(j);
        l(8);
        return this;
    }
}
