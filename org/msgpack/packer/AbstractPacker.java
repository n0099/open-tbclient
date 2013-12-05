package org.msgpack.packer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public abstract class AbstractPacker implements a {

    /* renamed from: a  reason: collision with root package name */
    protected org.msgpack.a f3062a;

    protected abstract void a(byte[] bArr, int i, int i2);

    protected abstract void b(byte b);

    protected abstract void b(double d);

    protected abstract void b(float f);

    protected abstract void b(int i);

    protected abstract void b(long j);

    protected abstract void b(String str);

    protected abstract void b(BigInteger bigInteger);

    protected abstract void b(ByteBuffer byteBuffer);

    protected abstract void b(short s);

    protected abstract void b(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPacker(org.msgpack.a aVar) {
        this.f3062a = aVar;
    }

    @Override // org.msgpack.packer.a
    public a a(boolean z) {
        b(z);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(byte b) {
        b(b);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(short s) {
        b(s);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(int i) {
        b(i);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(long j) {
        b(j);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(float f) {
        b(f);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(double d) {
        b(d);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(Short sh) {
        if (sh == null) {
            d();
        } else {
            b(sh.shortValue());
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(BigInteger bigInteger) {
        if (bigInteger == null) {
            d();
        } else {
            b(bigInteger);
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(byte[] bArr) {
        if (bArr == null) {
            d();
        } else {
            b(bArr);
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            d();
        } else {
            b(byteBuffer);
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(String str) {
        if (str == null) {
            d();
        } else {
            b(str);
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a(Object obj) {
        if (obj == null) {
            d();
        } else {
            this.f3062a.a((Class) obj.getClass()).a(this, obj);
        }
        return this;
    }

    public a a(r rVar) {
        if (rVar == null) {
            d();
        } else {
            rVar.writeTo(this);
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a a() {
        c(true);
        return this;
    }

    @Override // org.msgpack.packer.a
    public a b() {
        d(true);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected void b(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }
}
