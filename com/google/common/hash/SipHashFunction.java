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
    public final int f32183c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32184d;
    public final long k0;
    public final long k1;

    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: d  reason: collision with root package name */
        public final int f32185d;

        /* renamed from: e  reason: collision with root package name */
        public final int f32186e;

        /* renamed from: f  reason: collision with root package name */
        public long f32187f;

        /* renamed from: g  reason: collision with root package name */
        public long f32188g;

        /* renamed from: h  reason: collision with root package name */
        public long f32189h;

        /* renamed from: i  reason: collision with root package name */
        public long f32190i;
        public long j;
        public long k;

        public a(int i2, int i3, long j, long j2) {
            super(8);
            this.f32187f = 8317987319222330741L;
            this.f32188g = 7237128888997146477L;
            this.f32189h = 7816392313619706465L;
            this.f32190i = 8387220255154660723L;
            this.j = 0L;
            this.k = 0L;
            this.f32185d = i2;
            this.f32186e = i3;
            this.f32187f = 8317987319222330741L ^ j;
            this.f32188g = 7237128888997146477L ^ j2;
            this.f32189h = 7816392313619706465L ^ j;
            this.f32190i = 8387220255154660723L ^ j2;
        }

        @Override // d.g.c.d.d
        public HashCode l() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            r(j);
            this.f32189h ^= 255;
            s(this.f32186e);
            return HashCode.fromLong(((this.f32187f ^ this.f32188g) ^ this.f32189h) ^ this.f32190i);
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
            this.f32190i ^= j;
            s(this.f32185d);
            this.f32187f = j ^ this.f32187f;
        }

        public final void s(int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                long j = this.f32187f;
                long j2 = this.f32188g;
                this.f32187f = j + j2;
                this.f32189h += this.f32190i;
                this.f32188g = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f32190i, 16);
                this.f32190i = rotateLeft;
                long j3 = this.f32188g;
                long j4 = this.f32187f;
                this.f32188g = j3 ^ j4;
                this.f32190i = rotateLeft ^ this.f32189h;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f32187f = rotateLeft2;
                long j5 = this.f32189h;
                long j6 = this.f32188g;
                this.f32189h = j5 + j6;
                this.f32187f = rotateLeft2 + this.f32190i;
                this.f32188g = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f32190i, 21);
                this.f32190i = rotateLeft3;
                long j7 = this.f32188g;
                long j8 = this.f32189h;
                this.f32188g = j7 ^ j8;
                this.f32190i = rotateLeft3 ^ this.f32187f;
                this.f32189h = Long.rotateLeft(j8, 32);
            }
        }
    }

    public SipHashFunction(int i2, int i3, long j, long j2) {
        n.f(i2 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i2);
        n.f(i3 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i3);
        this.f32183c = i2;
        this.f32184d = i3;
        this.k0 = j;
        this.k1 = j2;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f32183c == sipHashFunction.f32183c && this.f32184d == sipHashFunction.f32184d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f32183c) ^ this.f32184d) ^ this.k0) ^ this.k1);
    }

    @Override // d.g.c.d.e
    public f newHasher() {
        return new a(this.f32183c, this.f32184d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f32183c + "" + this.f32184d + "(" + this.k0 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.k1 + SmallTailInfo.EMOTION_SUFFIX;
    }
}
