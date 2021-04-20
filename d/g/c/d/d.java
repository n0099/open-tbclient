package d.g.c.d;

import com.google.common.hash.HashCode;
import d.g.c.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f67021a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67022b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67023c;

    public d(int i) {
        this(i, i);
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public /* bridge */ /* synthetic */ j b(int i) {
        b(i);
        return this;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public /* bridge */ /* synthetic */ j d(long j) {
        d(j);
        return this;
    }

    @Override // d.g.c.d.f
    public final HashCode g() {
        m();
        this.f67021a.flip();
        if (this.f67021a.remaining() > 0) {
            p(this.f67021a);
            ByteBuffer byteBuffer = this.f67021a;
            byteBuffer.position(byteBuffer.limit());
        }
        return l();
    }

    @Override // d.g.c.d.c, d.g.c.d.f
    public final f h(byte[] bArr, int i, int i2) {
        q(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    @Override // d.g.c.d.f
    public final f i(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            q(byteBuffer);
            return this;
        } finally {
            byteBuffer.order(order);
        }
    }

    @Override // d.g.c.d.c
    public final f k(char c2) {
        this.f67021a.putChar(c2);
        n();
        return this;
    }

    public abstract HashCode l();

    public final void m() {
        this.f67021a.flip();
        while (this.f67021a.remaining() >= this.f67023c) {
            o(this.f67021a);
        }
        this.f67021a.compact();
    }

    public final void n() {
        if (this.f67021a.remaining() < 8) {
            m();
        }
    }

    public abstract void o(ByteBuffer byteBuffer);

    public abstract void p(ByteBuffer byteBuffer);

    public final f q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f67021a.remaining()) {
            this.f67021a.put(byteBuffer);
            n();
            return this;
        }
        int position = this.f67022b - this.f67021a.position();
        for (int i = 0; i < position; i++) {
            this.f67021a.put(byteBuffer.get());
        }
        m();
        while (byteBuffer.remaining() >= this.f67023c) {
            o(byteBuffer);
        }
        this.f67021a.put(byteBuffer);
        return this;
    }

    public d(int i, int i2) {
        n.d(i2 % i == 0);
        this.f67021a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f67022b = i2;
        this.f67023c = i;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public final f b(int i) {
        this.f67021a.putInt(i);
        n();
        return this;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public final f d(long j) {
        this.f67021a.putLong(j);
        n();
        return this;
    }
}
