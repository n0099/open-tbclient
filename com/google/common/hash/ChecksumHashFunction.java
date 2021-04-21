package com.google.common.hash;

import d.h.c.a.n;
import d.h.c.d.f;
import d.h.c.d.g;
import java.io.Serializable;
import java.util.zip.Checksum;
/* loaded from: classes6.dex */
public final class ChecksumHashFunction extends d.h.c.d.b implements Serializable {
    public static final long serialVersionUID = 0;
    public final int bits;
    public final g<? extends Checksum> checksumSupplier;
    public final String toString;

    /* loaded from: classes6.dex */
    public final class b extends d.h.c.d.a {

        /* renamed from: b  reason: collision with root package name */
        public final Checksum f31189b;

        @Override // d.h.c.d.f
        public HashCode g() {
            long value = this.f31189b.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        @Override // d.h.c.d.a
        public void m(byte b2) {
            this.f31189b.update(b2);
        }

        @Override // d.h.c.d.a
        public void p(byte[] bArr, int i, int i2) {
            this.f31189b.update(bArr, i, i2);
        }

        public b(Checksum checksum) {
            n.p(checksum);
            this.f31189b = checksum;
        }
    }

    public ChecksumHashFunction(g<? extends Checksum> gVar, int i, String str) {
        n.p(gVar);
        this.checksumSupplier = gVar;
        n.f(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
        this.bits = i;
        n.p(str);
        this.toString = str;
    }

    public int bits() {
        return this.bits;
    }

    @Override // d.h.c.d.e
    public f newHasher() {
        return new b(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
