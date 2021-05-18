package com.google.common.hash;

import d.g.c.a.n;
import d.g.c.d.f;
import d.g.c.d.g;
import java.io.Serializable;
import java.util.zip.Checksum;
/* loaded from: classes6.dex */
public final class ChecksumHashFunction extends d.g.c.d.b implements Serializable {
    public static final long serialVersionUID = 0;
    public final int bits;
    public final g<? extends Checksum> checksumSupplier;
    public final String toString;

    /* loaded from: classes6.dex */
    public final class b extends d.g.c.d.a {

        /* renamed from: b  reason: collision with root package name */
        public final Checksum f31412b;

        @Override // d.g.c.d.f
        public HashCode e() {
            long value = this.f31412b.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        @Override // d.g.c.d.a
        public void m(byte b2) {
            this.f31412b.update(b2);
        }

        @Override // d.g.c.d.a
        public void p(byte[] bArr, int i2, int i3) {
            this.f31412b.update(bArr, i2, i3);
        }

        public b(Checksum checksum) {
            n.p(checksum);
            this.f31412b = checksum;
        }
    }

    public ChecksumHashFunction(g<? extends Checksum> gVar, int i2, String str) {
        n.p(gVar);
        this.checksumSupplier = gVar;
        n.f(i2 == 32 || i2 == 64, "bits (%s) must be either 32 or 64", i2);
        this.bits = i2;
        n.p(str);
        this.toString = str;
    }

    public int bits() {
        return this.bits;
    }

    @Override // d.g.c.d.e
    public f newHasher() {
        return new b(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
