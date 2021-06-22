package d.g.c.d;

import com.google.common.hash.HashCode;
import d.g.c.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f70148a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70149b;

    /* renamed from: c  reason: collision with root package name */
    public final int f70150c;

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
        this.f70148a.flip();
        if (this.f70148a.remaining() > 0) {
            p(this.f70148a);
            ByteBuffer byteBuffer = this.f70148a;
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
        this.f70148a.putChar(c2);
        n();
        return this;
    }

    public abstract HashCode l();

    public final void m() {
        this.f70148a.flip();
        while (this.f70148a.remaining() >= this.f70150c) {
            o(this.f70148a);
        }
        this.f70148a.compact();
    }

    public final void n() {
        if (this.f70148a.remaining() < 8) {
            m();
        }
    }

    public abstract void o(ByteBuffer byteBuffer);

    public abstract void p(ByteBuffer byteBuffer);

    public final f q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f70148a.remaining()) {
            this.f70148a.put(byteBuffer);
            n();
            return this;
        }
        int position = this.f70149b - this.f70148a.position();
        for (int i2 = 0; i2 < position; i2++) {
            this.f70148a.put(byteBuffer.get());
        }
        m();
        while (byteBuffer.remaining() >= this.f70150c) {
            o(byteBuffer);
        }
        this.f70148a.put(byteBuffer);
        return this;
    }

    public d(int i2, int i3) {
        n.d(i3 % i2 == 0);
        this.f70148a = ByteBuffer.allocate(i3 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f70149b = i3;
        this.f70150c = i2;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public final f a(int i2) {
        this.f70148a.putInt(i2);
        n();
        return this;
    }

    @Override // d.g.c.d.f, d.g.c.d.j
    public final f b(long j) {
        this.f70148a.putLong(j);
        n();
        return this;
    }
}
