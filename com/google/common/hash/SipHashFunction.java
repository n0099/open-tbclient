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
    public final int f31448c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31449d;
    public final long k0;
    public final long k1;

    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: d  reason: collision with root package name */
        public final int f31450d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31451e;

        /* renamed from: f  reason: collision with root package name */
        public long f31452f;

        /* renamed from: g  reason: collision with root package name */
        public long f31453g;

        /* renamed from: h  reason: collision with root package name */
        public long f31454h;

        /* renamed from: i  reason: collision with root package name */
        public long f31455i;
        public long j;
        public long k;

        public a(int i2, int i3, long j, long j2) {
            super(8);
            this.f31452f = 8317987319222330741L;
            this.f31453g = 7237128888997146477L;
            this.f31454h = 7816392313619706465L;
            this.f31455i = 8387220255154660723L;
            this.j = 0L;
            this.k = 0L;
            this.f31450d = i2;
            this.f31451e = i3;
            this.f31452f = 8317987319222330741L ^ j;
            this.f31453g = 7237128888997146477L ^ j2;
            this.f31454h = 7816392313619706465L ^ j;
            this.f31455i = 8387220255154660723L ^ j2;
        }

        @Override // d.g.c.d.d
        public HashCode l() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            r(j);
            this.f31454h ^= 255;
            s(this.f31451e);
            return HashCode.fromLong(((this.f31452f ^ this.f31453g) ^ this.f31454h) ^ this.f31455i);
        }

        @Override // d.g.c.d.d
        public void o(ByteBuffer byteBuffer) {
            this.j += 8;
            r(byteBuffer.getLong());
        }

        @Override // d.g.c.d.d
        public void p(ByteBuffer byteBuffer) {
            this.j += byteBuffer.remaining();
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (byteBuffer.get() & 255) << i2;
                i2 += 8;
            }
        }

        public final void r(long j) {
            this.f31455i ^= j;
            s(this.f31450d);
            this.f31452f = j ^ this.f31452f;
        }

        public final void s(int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                long j = this.f31452f;
                long j2 = this.f31453g;
                this.f31452f = j + j2;
                this.f31454h += this.f31455i;
                this.f31453g = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f31455i, 16);
                this.f31455i = rotateLeft;
                long j3 = this.f31453g;
                long j4 = this.f31452f;
                this.f31453g = j3 ^ j4;
                this.f31455i = rotateLeft ^ this.f31454h;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f31452f = rotateLeft2;
                long j5 = this.f31454h;
                long j6 = this.f31453g;
                this.f31454h = j5 + j6;
                this.f31452f = rotateLeft2 + this.f31455i;
                this.f31453g = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f31455i, 21);
                this.f31455i = rotateLeft3;
                long j7 = this.f31453g;
                long j8 = this.f31454h;
                this.f31453g = j7 ^ j8;
                this.f31455i = rotateLeft3 ^ this.f31452f;
                this.f31454h = Long.rotateLeft(j8, 32);
            }
        }
    }

    public SipHashFunction(int i2, int i3, long j, long j2) {
        n.f(i2 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i2);
        n.f(i3 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i3);
        this.f31448c = i2;
        this.f31449d = i3;
        this.k0 = j;
        this.k1 = j2;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f31448c == sipHashFunction.f31448c && this.f31449d == sipHashFunction.f31449d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f31448c) ^ this.f31449d) ^ this.k0) ^ this.k1);
    }

    @Override // d.g.c.d.e
    public f newHasher() {
        return new a(this.f31448c, this.f31449d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f31448c + "" + this.f31449d + "(" + this.k0 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.k1 + SmallTailInfo.EMOTION_SUFFIX;
    }
}
