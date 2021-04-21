package com.google.common.hash;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.n;
import d.h.c.d.b;
import d.h.c.d.d;
import d.h.c.d.e;
import d.h.c.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class SipHashFunction extends b implements Serializable {
    public static final e SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    public static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f31205c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31206d;
    public final long k0;
    public final long k1;

    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: d  reason: collision with root package name */
        public final int f31207d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31208e;

        /* renamed from: f  reason: collision with root package name */
        public long f31209f;

        /* renamed from: g  reason: collision with root package name */
        public long f31210g;

        /* renamed from: h  reason: collision with root package name */
        public long f31211h;
        public long i;
        public long j;
        public long k;

        public a(int i, int i2, long j, long j2) {
            super(8);
            this.f31209f = 8317987319222330741L;
            this.f31210g = 7237128888997146477L;
            this.f31211h = 7816392313619706465L;
            this.i = 8387220255154660723L;
            this.j = 0L;
            this.k = 0L;
            this.f31207d = i;
            this.f31208e = i2;
            this.f31209f = 8317987319222330741L ^ j;
            this.f31210g = 7237128888997146477L ^ j2;
            this.f31211h = 7816392313619706465L ^ j;
            this.i = 8387220255154660723L ^ j2;
        }

        @Override // d.h.c.d.d
        public HashCode l() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            r(j);
            this.f31211h ^= 255;
            s(this.f31208e);
            return HashCode.fromLong(((this.f31209f ^ this.f31210g) ^ this.f31211h) ^ this.i);
        }

        @Override // d.h.c.d.d
        public void o(ByteBuffer byteBuffer) {
            this.j += 8;
            r(byteBuffer.getLong());
        }

        @Override // d.h.c.d.d
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
            s(this.f31207d);
            this.f31209f = j ^ this.f31209f;
        }

        public final void s(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f31209f;
                long j2 = this.f31210g;
                this.f31209f = j + j2;
                this.f31211h += this.i;
                this.f31210g = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.i, 16);
                this.i = rotateLeft;
                long j3 = this.f31210g;
                long j4 = this.f31209f;
                this.f31210g = j3 ^ j4;
                this.i = rotateLeft ^ this.f31211h;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f31209f = rotateLeft2;
                long j5 = this.f31211h;
                long j6 = this.f31210g;
                this.f31211h = j5 + j6;
                this.f31209f = rotateLeft2 + this.i;
                this.f31210g = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.i, 21);
                this.i = rotateLeft3;
                long j7 = this.f31210g;
                long j8 = this.f31211h;
                this.f31210g = j7 ^ j8;
                this.i = rotateLeft3 ^ this.f31209f;
                this.f31211h = Long.rotateLeft(j8, 32);
            }
        }
    }

    public SipHashFunction(int i, int i2, long j, long j2) {
        n.f(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        n.f(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f31205c = i;
        this.f31206d = i2;
        this.k0 = j;
        this.k1 = j2;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f31205c == sipHashFunction.f31205c && this.f31206d == sipHashFunction.f31206d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f31205c) ^ this.f31206d) ^ this.k0) ^ this.k1);
    }

    @Override // d.h.c.d.e
    public f newHasher() {
        return new a(this.f31205c, this.f31206d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f31205c + "" + this.f31206d + "(" + this.k0 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.k1 + SmallTailInfo.EMOTION_SUFFIX;
    }
}
