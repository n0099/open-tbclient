package com.google.common.hash;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.a.n;
import d.g.c.d.b;
import d.g.c.d.d;
import d.g.c.d.e;
import d.g.c.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class SipHashFunction extends b implements Serializable {
    public static final e SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    public static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f31110c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31111d;
    public final long k0;
    public final long k1;

    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: d  reason: collision with root package name */
        public final int f31112d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31113e;

        /* renamed from: f  reason: collision with root package name */
        public long f31114f;

        /* renamed from: g  reason: collision with root package name */
        public long f31115g;

        /* renamed from: h  reason: collision with root package name */
        public long f31116h;
        public long i;
        public long j;
        public long k;

        public a(int i, int i2, long j, long j2) {
            super(8);
            this.f31114f = 8317987319222330741L;
            this.f31115g = 7237128888997146477L;
            this.f31116h = 7816392313619706465L;
            this.i = 8387220255154660723L;
            this.j = 0L;
            this.k = 0L;
            this.f31112d = i;
            this.f31113e = i2;
            this.f31114f = 8317987319222330741L ^ j;
            this.f31115g = 7237128888997146477L ^ j2;
            this.f31116h = 7816392313619706465L ^ j;
            this.i = 8387220255154660723L ^ j2;
        }

        @Override // d.g.c.d.d
        public HashCode l() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            r(j);
            this.f31116h ^= 255;
            s(this.f31113e);
            return HashCode.fromLong(((this.f31114f ^ this.f31115g) ^ this.f31116h) ^ this.i);
        }

        @Override // d.g.c.d.d
        public void o(ByteBuffer byteBuffer) {
            this.j += 8;
            r(byteBuffer.getLong());
        }

        @Override // d.g.c.d.d
        public void p(ByteBuffer byteBuffer) {
            this.j += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        public final void r(long j) {
            this.i ^= j;
            s(this.f31112d);
            this.f31114f = j ^ this.f31114f;
        }

        public final void s(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f31114f;
                long j2 = this.f31115g;
                this.f31114f = j + j2;
                this.f31116h += this.i;
                this.f31115g = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.i, 16);
                this.i = rotateLeft;
                long j3 = this.f31115g;
                long j4 = this.f31114f;
                this.f31115g = j3 ^ j4;
                this.i = rotateLeft ^ this.f31116h;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f31114f = rotateLeft2;
                long j5 = this.f31116h;
                long j6 = this.f31115g;
                this.f31116h = j5 + j6;
                this.f31114f = rotateLeft2 + this.i;
                this.f31115g = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.i, 21);
                this.i = rotateLeft3;
                long j7 = this.f31115g;
                long j8 = this.f31116h;
                this.f31115g = j7 ^ j8;
                this.i = rotateLeft3 ^ this.f31114f;
                this.f31116h = Long.rotateLeft(j8, 32);
            }
        }
    }

    public SipHashFunction(int i, int i2, long j, long j2) {
        n.f(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        n.f(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f31110c = i;
        this.f31111d = i2;
        this.k0 = j;
        this.k1 = j2;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f31110c == sipHashFunction.f31110c && this.f31111d == sipHashFunction.f31111d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f31110c) ^ this.f31111d) ^ this.k0) ^ this.k1);
    }

    @Override // d.g.c.d.e
    public f newHasher() {
        return new a(this.f31110c, this.f31111d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f31110c + "" + this.f31111d + "(" + this.k0 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.k1 + SmallTailInfo.EMOTION_SUFFIX;
    }
}
