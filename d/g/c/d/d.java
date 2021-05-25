package d.g.c.d;

import com.google.common.hash.HashCode;
import d.g.c.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f66313a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66314b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66315c;

    public d(int i2) {
        this(i2, i2);
    }

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

    @Override // d.g.c.d.f
    public final HashCode e() {
        m();
        this.f66313a.flip();
        if (this.f66313a.remaining() > 0) {
            p(this.f66313a);
            ByteBuffer byteBuffer = this.f66313a;
            byteBuffer.position(byteBuffer.limit());
        }
        return l();
    }

    @Override // d.g.c.d.c, d.g.c.d.f
    public final f h(byte[] bArr, int i2, int i3) {
        q(ByteBuffer.wrap(bArr, i2, i3).order(ByteOrder.LITTLE_ENDIAN));
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
        this.f66313a.putChar(c2);
        n();
        return this;
    }

    public abstract HashCode l();

    public final void m() {
        this.f66313a.flip();
        while (this.f66313a.remaining() >= this.f66315c) {
            o(this.f66313a);
        }
        this.f66313a.compact();
    }

    public final void n() {
        if (this.f66313a.remaining() < 8) {
            m();
        }
    }

    public abstract void o(ByteBuffer byteBuffer);

    public abstract void p(ByteBuffer byteBuffer);

    public final f q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f66313a.remaining()) {
            this.f66313a.put(byteBuffer);
            n();
            return this;
        }
        int position = this.f66314b - this.f66313a.position();
        for (int i2 = 0; i2 < position; i2++) {
            this.f66313a.put(byteBuffer.get());
        }
        m();
        while (byteBuffer.remaining() >= this.f66315c) {
            o(byteBuffer);
        }
        this.f66313a.put(byteBuffer);
        return this;
    }

    public d(int i2, int i3) {
        n.d(i3 % i2 == 0);
        this.f66313a = ByteBuffer.allocate(i3 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f66314b = i3;
        this.f66315c = i2;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public final f a(int i2) {
        this.f66313a.putInt(i2);
        n();
        return this;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public final f b(long j) {
        this.f66313a.putLong(j);
        n();
        return this;
    }
}
