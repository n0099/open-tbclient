package com.google.common.hash;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.common.primitives.Ints;
import d.h.c.a.n;
import d.h.c.d.b;
import d.h.c.d.c;
import d.h.c.d.e;
import d.h.c.d.f;
import d.h.c.d.j;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class Murmur3_32HashFunction extends b implements Serializable {
    public static final long serialVersionUID = 0;
    public final int seed;
    public static final e MURMUR3_32 = new Murmur3_32HashFunction(0);
    public static final e GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f31192a);

    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public int f31200a;

        /* renamed from: b  reason: collision with root package name */
        public long f31201b;

        /* renamed from: c  reason: collision with root package name */
        public int f31202c;

        /* renamed from: d  reason: collision with root package name */
        public int f31203d = 0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31204e = false;

        public a(int i) {
            this.f31200a = i;
        }

        @Override // d.h.c.d.f, d.h.c.d.j
        public /* bridge */ /* synthetic */ j b(int i) {
            b(i);
            return this;
        }

        @Override // d.h.c.d.f, d.h.c.d.j
        public /* bridge */ /* synthetic */ j d(long j) {
            d(j);
            return this;
        }

        @Override // d.h.c.d.f
        public HashCode g() {
            n.w(!this.f31204e);
            this.f31204e = true;
            int g2 = this.f31200a ^ Murmur3_32HashFunction.g((int) this.f31201b);
            this.f31200a = g2;
            return Murmur3_32HashFunction.d(g2, this.f31203d);
        }

        @Override // d.h.c.d.c, d.h.c.d.f
        public f h(byte[] bArr, int i, int i2) {
            n.v(i, i + i2, bArr.length);
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 > i2) {
                    break;
                }
                m(4, Murmur3_32HashFunction.e(bArr, i3 + i));
                i3 = i4;
            }
            while (i3 < i2) {
                l(bArr[i + i3]);
                i3++;
            }
            return this;
        }

        @Override // d.h.c.d.f
        public f i(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                b(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                l(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @Override // d.h.c.d.c
        public f k(char c2) {
            m(2, c2);
            return this;
        }

        public f l(byte b2) {
            m(1, b2 & 255);
            return this;
        }

        public final void m(int i, long j) {
            long j2 = this.f31201b;
            int i2 = this.f31202c;
            long j3 = ((j & 4294967295L) << i2) | j2;
            this.f31201b = j3;
            int i3 = i2 + (i * 8);
            this.f31202c = i3;
            this.f31203d += i;
            if (i3 >= 32) {
                this.f31200a = Murmur3_32HashFunction.f(this.f31200a, Murmur3_32HashFunction.g((int) j3));
                this.f31201b >>>= 32;
                this.f31202c -= 32;
            }
        }

        @Override // d.h.c.d.f, d.h.c.d.j
        public f b(int i) {
            m(4, i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.d.c, d.h.c.d.f, d.h.c.d.j
        public f c(CharSequence charSequence, Charset charset) {
            if (d.h.c.a.c.f67085a.equals(charset)) {
                int length = charSequence.length();
                int i = 0;
                while (true) {
                    int i2 = i + 4;
                    if (i2 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i);
                    char charAt2 = charSequence.charAt(i + 1);
                    char charAt3 = charSequence.charAt(i + 2);
                    char charAt4 = charSequence.charAt(i + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    m(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i = i2;
                }
                while (i < length) {
                    char charAt5 = charSequence.charAt(i);
                    if (charAt5 < 128) {
                        m(1, charAt5);
                    } else if (charAt5 < 2048) {
                        m(2, Murmur3_32HashFunction.b(charAt5));
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        m(3, Murmur3_32HashFunction.a(charAt5));
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i);
                        if (codePointAt != charAt5) {
                            i++;
                            m(4, Murmur3_32HashFunction.c(codePointAt));
                        } else {
                            e(charSequence.subSequence(i, length).toString().getBytes(charset));
                            return this;
                        }
                    }
                    i++;
                }
                return this;
            }
            return super.c(charSequence, charset);
        }

        @Override // d.h.c.d.f, d.h.c.d.j
        public f d(long j) {
            m(4, (int) j);
            m(4, j >>> 32);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i) {
        this.seed = i;
    }

    public static long a(char c2) {
        return (((c2 & '?') | 128) << 16) | (((c2 >>> '\f') | 480) & 255) | ((((c2 >>> 6) & 63) | 128) << 8);
    }

    public static long b(char c2) {
        return (((c2 & '?') | 128) << 8) | (((c2 >>> 6) | TbConfig.HEAD_IMG_SIZE) & 255);
    }

    public static long c(int i) {
        return (((i >>> 18) | 240) & 255) | ((((i >>> 12) & 63) | 128) << 8) | ((((i >>> 6) & 63) | 128) << 16) | (((i & 63) | 128) << 24);
    }

    public static HashCode d(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    public static int e(byte[] bArr, int i) {
        return Ints.e(bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
    }

    public static int f(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    public static int g(int i) {
        return Integer.rotateLeft(i * (-862048943), 15) * 461845907;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed;
    }

    @Override // d.h.c.d.b
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        n.v(i, i + i2, bArr.length);
        int i3 = this.seed;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 4;
            if (i6 > i2) {
                break;
            }
            i3 = f(i3, g(e(bArr, i5 + i)));
            i5 = i6;
        }
        int i7 = i5;
        int i8 = 0;
        while (i7 < i2) {
            i4 ^= d.h.c.g.b.c(bArr[i + i7]) << i8;
            i7++;
            i8 += 8;
        }
        return d(g(i4) ^ i3, i2);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // d.h.c.d.b
    public HashCode hashInt(int i) {
        return d(f(this.seed, g(i)), 4);
    }

    @Override // d.h.c.d.b
    public HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return d(f(f(this.seed, g((int) j)), g(i)), 8);
    }

    @Override // d.h.c.d.b
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (d.h.c.a.c.f67085a.equals(charset)) {
            int length = charSequence.length();
            int i = this.seed;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i3 + 4;
                if (i5 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i3);
                char charAt2 = charSequence.charAt(i3 + 1);
                char charAt3 = charSequence.charAt(i3 + 2);
                char charAt4 = charSequence.charAt(i3 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i = f(i, g((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i4 += 4;
                i3 = i5;
            }
            long j = 0;
            while (i3 < length) {
                char charAt5 = charSequence.charAt(i3);
                if (charAt5 < 128) {
                    j |= charAt5 << i2;
                    i2 += 8;
                    i4++;
                } else if (charAt5 < 2048) {
                    j |= b(charAt5) << i2;
                    i2 += 16;
                    i4 += 2;
                } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                    int codePointAt = Character.codePointAt(charSequence, i3);
                    if (codePointAt == charAt5) {
                        return hashBytes(charSequence.toString().getBytes(charset));
                    }
                    i3++;
                    j |= c(codePointAt) << i2;
                    i4 += 4;
                } else {
                    j |= a(charAt5) << i2;
                    i2 += 24;
                    i4 += 3;
                }
                if (i2 >= 32) {
                    i = f(i, g((int) j));
                    j >>>= 32;
                    i2 -= 32;
                }
                i3++;
            }
            return d(g((int) j) ^ i, i4);
        }
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // d.h.c.d.b
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.seed;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = f(i, g(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= g(charSequence.charAt(charSequence.length() - 1));
        }
        return d(i, charSequence.length() * 2);
    }

    @Override // d.h.c.d.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + SmallTailInfo.EMOTION_SUFFIX;
    }
}
