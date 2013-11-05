package org.msgpack.packer;

import com.baidu.zeus.bouncycastle.DERTags;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.msgpack.MessageTypeException;
import org.msgpack.type.r;
import org.msgpack.type.s;
/* loaded from: classes.dex */
public class Unconverter extends AbstractPacker {
    private b b;
    private Object[] c;
    private r d;

    public Unconverter() {
        this(new org.msgpack.a());
    }

    public Unconverter(org.msgpack.a aVar) {
        super(aVar);
        this.b = new b();
        this.c = new Object[DERTags.TAGGED];
    }

    public r c() {
        return this.d;
    }

    public void e() {
        this.d = null;
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(boolean z) {
        b(s.a(z));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(byte b) {
        b(s.a(b));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(short s) {
        b(s.a(s));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(int i) {
        b(s.a(i));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(BigInteger bigInteger) {
        b(s.a(bigInteger));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(long j) {
        b(s.a(j));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(float f) {
        b(s.a(f));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(double d) {
        b(s.a(d));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void a(byte[] bArr, int i, int i2) {
        b(s.a(bArr, i, i2));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(ByteBuffer byteBuffer) {
        b(s.a(byteBuffer));
    }

    @Override // org.msgpack.packer.AbstractPacker
    public void b(String str) {
        b(s.a(str));
    }

    @Override // org.msgpack.packer.a
    public a d() {
        b(s.a());
        return this;
    }

    @Override // org.msgpack.packer.a
    public a c(int i) {
        if (i == 0) {
            c(s.c());
            this.b.a(0);
            this.c[this.b.d()] = null;
        } else {
            r[] rVarArr = new r[i];
            c(s.a(rVarArr, true));
            this.b.a(i);
            this.c[this.b.d()] = rVarArr;
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a c(boolean z) {
        if (!this.b.f()) {
            throw new MessageTypeException("writeArrayEnd() is called but writeArrayBegin() is not called");
        }
        int e = this.b.e();
        if (e > 0) {
            if (z) {
                throw new MessageTypeException("writeArrayEnd(check=true) is called but the array is not end");
            }
            for (int i = 0; i < e; i++) {
                d();
            }
        }
        this.b.c();
        if (this.b.d() <= 0) {
            this.d = (r) this.c[0];
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a d(int i) {
        this.b.a();
        if (i == 0) {
            c(s.d());
            this.b.b(0);
            this.c[this.b.d()] = null;
        } else {
            r[] rVarArr = new r[i * 2];
            c(s.b(rVarArr, true));
            this.b.b(i);
            this.c[this.b.d()] = rVarArr;
        }
        return this;
    }

    @Override // org.msgpack.packer.a
    public a d(boolean z) {
        if (!this.b.g()) {
            throw new MessageTypeException("writeMapEnd() is called but writeMapBegin() is not called");
        }
        int e = this.b.e();
        if (e > 0) {
            if (z) {
                throw new MessageTypeException("writeMapEnd(check=true) is called but the map is not end");
            }
            for (int i = 0; i < e; i++) {
                d();
            }
        }
        this.b.c();
        if (this.b.d() <= 0) {
            this.d = (r) this.c[0];
        }
        return this;
    }

    @Override // org.msgpack.packer.AbstractPacker
    public a a(r rVar) {
        b(rVar);
        return this;
    }

    private void b(r rVar) {
        if (this.b.d() <= 0) {
            this.d = rVar;
            return;
        }
        this.b.a();
        r[] rVarArr = (r[]) this.c[this.b.d()];
        rVarArr[rVarArr.length - this.b.e()] = rVar;
        this.b.b();
    }

    private void c(r rVar) {
        if (this.b.d() <= 0) {
            this.c[0] = rVar;
            return;
        }
        this.b.a();
        r[] rVarArr = (r[]) this.c[this.b.d()];
        rVarArr[rVarArr.length - this.b.e()] = rVar;
        this.b.b();
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // org.msgpack.packer.AbstractPacker, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
