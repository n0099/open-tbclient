package d.h.c.d;

import com.google.common.hash.HashCode;
import d.h.c.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f67168a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67169b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67170c;

    public d(int i) {
        this(i, i);
    }

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

    @Override // d.h.c.d.f
    public final HashCode g() {
        m();
        this.f67168a.flip();
        if (this.f67168a.remaining() > 0) {
            p(this.f67168a);
            ByteBuffer byteBuffer = this.f67168a;
            byteBuffer.position(byteBuffer.limit());
        }
        return l();
    }

    @Override // d.h.c.d.c, d.h.c.d.f
    public final f h(byte[] bArr, int i, int i2) {
        q(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    @Override // d.h.c.d.f
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

    @Override // d.h.c.d.c
    public final f k(char c2) {
        this.f67168a.putChar(c2);
        n();
        return this;
    }

    public abstract HashCode l();

    public final void m() {
        this.f67168a.flip();
        while (this.f67168a.remaining() >= this.f67170c) {
            o(this.f67168a);
        }
        this.f67168a.compact();
    }

    public final void n() {
        if (this.f67168a.remaining() < 8) {
            m();
        }
    }

    public abstract void o(ByteBuffer byteBuffer);

    public abstract void p(ByteBuffer byteBuffer);

    public final f q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f67168a.remaining()) {
            this.f67168a.put(byteBuffer);
            n();
            return this;
        }
        int position = this.f67169b - this.f67168a.position();
        for (int i = 0; i < position; i++) {
            this.f67168a.put(byteBuffer.get());
        }
        m();
        while (byteBuffer.remaining() >= this.f67170c) {
            o(byteBuffer);
        }
        this.f67168a.put(byteBuffer);
        return this;
    }

    public d(int i, int i2) {
        n.d(i2 % i == 0);
        this.f67168a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f67169b = i2;
        this.f67170c = i;
    }

    @Override // d.h.c.d.f, d.h.c.d.j
    public final f b(int i) {
        this.f67168a.putInt(i);
        n();
        return this;
    }

    @Override // d.h.c.d.f, d.h.c.d.j
    public final f d(long j) {
        this.f67168a.putLong(j);
        n();
        return this;
    }
}
