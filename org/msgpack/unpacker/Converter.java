package org.msgpack.unpacker;

import com.baidu.zeus.bouncycastle.DERTags;
import java.io.EOFException;
import org.msgpack.packer.Unconverter;
import org.msgpack.type.ArrayValue;
import org.msgpack.type.MapValue;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class Converter extends AbstractUnpacker {
    protected r e;
    private final m f;
    private Object[] g;

    public Converter(org.msgpack.a aVar, r rVar) {
        super(aVar);
        this.f = new m();
        this.g = new Object[DERTags.TAGGED];
        this.e = rVar;
    }

    protected r c() {
        throw new EOFException();
    }

    private void d() {
        if (this.e == null) {
            this.e = c();
        }
    }

    private r e() {
        d();
        this.f.a();
        if (this.f.d() == 0) {
            return this.e;
        }
        r[] rVarArr = (r[]) this.g[this.f.d()];
        return rVarArr[rVarArr.length - this.f.e()];
    }

    @Override // org.msgpack.unpacker.AbstractUnpacker, org.msgpack.unpacker.k
    public r b() {
        if (this.f.d() == 0) {
            if (this.e == null) {
                return c();
            }
            r rVar = this.e;
            this.e = null;
            return rVar;
        }
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.msgpack.unpacker.AbstractUnpacker
    public void a(Unconverter unconverter) {
        if (unconverter.c() != null) {
            unconverter.e();
        }
        this.f.a();
        r e = e();
        if (!e.isArrayValue() && !e.isMapValue()) {
            unconverter.a(e);
            this.f.b();
            if (this.f.d() == 0) {
                this.e = null;
            }
            if (unconverter.c() != null) {
                return;
            }
        }
        while (true) {
            if (this.f.d() != 0 && this.f.e() == 0) {
                if (this.f.f()) {
                    unconverter.c(true);
                    this.f.c();
                } else if (this.f.g()) {
                    unconverter.d(true);
                    this.f.c();
                } else {
                    throw new RuntimeException("invalid stack");
                }
                if (this.f.d() == 0) {
                    this.e = null;
                }
                if (unconverter.c() != null) {
                    return;
                }
            } else {
                this.f.a();
                r e2 = e();
                if (e2.isArrayValue()) {
                    ArrayValue asArrayValue = e2.asArrayValue();
                    unconverter.c(asArrayValue.size());
                    this.f.b();
                    this.f.a(asArrayValue.size());
                    this.g[this.f.d()] = asArrayValue.a();
                } else if (e2.isMapValue()) {
                    MapValue asMapValue = e2.asMapValue();
                    unconverter.d(asMapValue.size());
                    this.f.b();
                    this.f.b(asMapValue.size());
                    this.g[this.f.d()] = asMapValue.a();
                } else {
                    unconverter.a(e2);
                    this.f.b();
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
