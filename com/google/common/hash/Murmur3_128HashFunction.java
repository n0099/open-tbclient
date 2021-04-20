package com.google.common.hash;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.g.c.d.b;
import d.g.c.d.d;
import d.g.c.d.e;
import d.g.c.d.f;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public final class Murmur3_128HashFunction extends b implements Serializable {
    public static final long serialVersionUID = 0;
    public final int seed;
    public static final e MURMUR3_128 = new Murmur3_128HashFunction(0);
    public static final e GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f31097a);

    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: d  reason: collision with root package name */
        public long f31102d;

        /* renamed from: e  reason: collision with root package name */
        public long f31103e;

        /* renamed from: f  reason: collision with root package name */
        public int f31104f;

        public a(int i) {
            super(16);
            long j = i;
            this.f31102d = j;
            this.f31103e = j;
            this.f31104f = 0;
        }

        public static long s(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        public static long t(long j) {
            return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        public static long u(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // d.g.c.d.d
        public HashCode l() {
            long j = this.f31102d;
            int i = this.f31104f;
            long j2 = j ^ i;
            this.f31102d = j2;
            long j3 = this.f31103e ^ i;
            this.f31103e = j3;
            long j4 = j2 + j3;
            this.f31102d = j4;
            this.f31103e = j3 + j4;
            this.f31102d = s(j4);
            long s = s(this.f31103e);
            this.f31103e = s;
            long j5 = this.f31102d + s;
            this.f31102d = j5;
            this.f31103e = s + j5;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f31102d).putLong(this.f31103e).array());
        }

        @Override // d.g.c.d.d
        public void o(ByteBuffer byteBuffer) {
            r(byteBuffer.getLong(), byteBuffer.getLong());
            this.f31104f += 16;
        }

        @Override // d.g.c.d.d
        public void p(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long c2;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            this.f31104f += byteBuffer.remaining();
            long j14 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j = 0;
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 2:
                    j2 = 0;
                    j = j2 ^ (d.g.c.g.b.c(byteBuffer.get(1)) << 8);
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 3:
                    j3 = 0;
                    j2 = j3 ^ (d.g.c.g.b.c(byteBuffer.get(2)) << 16);
                    j = j2 ^ (d.g.c.g.b.c(byteBuffer.get(1)) << 8);
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 4:
                    j4 = 0;
                    j3 = j4 ^ (d.g.c.g.b.c(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (d.g.c.g.b.c(byteBuffer.get(2)) << 16);
                    j = j2 ^ (d.g.c.g.b.c(byteBuffer.get(1)) << 8);
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 5:
                    j5 = 0;
                    j4 = j5 ^ (d.g.c.g.b.c(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (d.g.c.g.b.c(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (d.g.c.g.b.c(byteBuffer.get(2)) << 16);
                    j = j2 ^ (d.g.c.g.b.c(byteBuffer.get(1)) << 8);
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 6:
                    j6 = 0;
                    j5 = j6 ^ (d.g.c.g.b.c(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (d.g.c.g.b.c(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (d.g.c.g.b.c(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (d.g.c.g.b.c(byteBuffer.get(2)) << 16);
                    j = j2 ^ (d.g.c.g.b.c(byteBuffer.get(1)) << 8);
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 7:
                    j6 = (d.g.c.g.b.c(byteBuffer.get(6)) << 48) ^ 0;
                    j5 = j6 ^ (d.g.c.g.b.c(byteBuffer.get(5)) << 40);
                    j4 = j5 ^ (d.g.c.g.b.c(byteBuffer.get(4)) << 32);
                    j3 = j4 ^ (d.g.c.g.b.c(byteBuffer.get(3)) << 24);
                    j2 = j3 ^ (d.g.c.g.b.c(byteBuffer.get(2)) << 16);
                    j = j2 ^ (d.g.c.g.b.c(byteBuffer.get(1)) << 8);
                    c2 = d.g.c.g.b.c(byteBuffer.get(0)) ^ j;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 8:
                    j7 = 0;
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 9:
                    j8 = 0;
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 10:
                    j9 = 0;
                    j8 = j9 ^ (d.g.c.g.b.c(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 11:
                    j10 = 0;
                    j9 = j10 ^ (d.g.c.g.b.c(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (d.g.c.g.b.c(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 12:
                    j11 = 0;
                    j10 = j11 ^ (d.g.c.g.b.c(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (d.g.c.g.b.c(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (d.g.c.g.b.c(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 13:
                    j12 = 0;
                    j11 = j12 ^ (d.g.c.g.b.c(byteBuffer.get(12)) << 32);
                    j10 = j11 ^ (d.g.c.g.b.c(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (d.g.c.g.b.c(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (d.g.c.g.b.c(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 14:
                    j13 = 0;
                    j12 = j13 ^ (d.g.c.g.b.c(byteBuffer.get(13)) << 40);
                    j11 = j12 ^ (d.g.c.g.b.c(byteBuffer.get(12)) << 32);
                    j10 = j11 ^ (d.g.c.g.b.c(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (d.g.c.g.b.c(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (d.g.c.g.b.c(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                case 15:
                    j13 = (d.g.c.g.b.c(byteBuffer.get(14)) << 48) ^ 0;
                    j12 = j13 ^ (d.g.c.g.b.c(byteBuffer.get(13)) << 40);
                    j11 = j12 ^ (d.g.c.g.b.c(byteBuffer.get(12)) << 32);
                    j10 = j11 ^ (d.g.c.g.b.c(byteBuffer.get(11)) << 24);
                    j9 = j10 ^ (d.g.c.g.b.c(byteBuffer.get(10)) << 16);
                    j8 = j9 ^ (d.g.c.g.b.c(byteBuffer.get(9)) << 8);
                    j7 = j8 ^ d.g.c.g.b.c(byteBuffer.get(8));
                    c2 = byteBuffer.getLong() ^ 0;
                    j14 = j7;
                    this.f31102d ^= t(c2);
                    this.f31103e ^= u(j14);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        public final void r(long j, long j2) {
            long t = t(j) ^ this.f31102d;
            this.f31102d = t;
            long rotateLeft = Long.rotateLeft(t, 27);
            this.f31102d = rotateLeft;
            long j3 = this.f31103e;
            long j4 = rotateLeft + j3;
            this.f31102d = j4;
            this.f31102d = (j4 * 5) + 1390208809;
            long u = u(j2) ^ j3;
            this.f31103e = u;
            long rotateLeft2 = Long.rotateLeft(u, 31);
            this.f31103e = rotateLeft2;
            long j5 = rotateLeft2 + this.f31102d;
            this.f31103e = j5;
            this.f31103e = (j5 * 5) + 944331445;
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // d.g.c.d.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + SmallTailInfo.EMOTION_SUFFIX;
    }
}
