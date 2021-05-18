package com.google.common.hash;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.common.primitives.Ints;
import d.g.c.a.n;
import d.g.c.d.b;
import d.g.c.d.c;
import d.g.c.d.e;
import d.g.c.d.f;
import d.g.c.d.j;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class Murmur3_32HashFunction extends b implements Serializable {
    public static final long serialVersionUID = 0;
    public final int seed;
    public static final e MURMUR3_32 = new Murmur3_32HashFunction(0);
    public static final e GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f31415a);

    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public int f31423a;

        /* renamed from: b  reason: collision with root package name */
        public long f31424b;

        /* renamed from: c  reason: collision with root package name */
        public int f31425c;

        /* renamed from: d  reason: collision with root package name */
        public int f31426d = 0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f31427e = false;

        public a(int i2) {
            this.f31423a = i2;
        }

        @Override // d.g.c.d.f, d.g.c.d.j
        public /* bridge */ /* synthetic */ j a(int i2) {
            a(i2);
            return this;
        }

        @Override // d.g.c.d.f, d.g.c.d.j
        public /* bridge */ /* synthetic */ j b(long j) {
            b(j);
            return this;
        }

        @Override // d.g.c.d.f
        public HashCode e() {
            n.w(!this.f31427e);
            this.f31427e = true;
            int g2 = this.f31423a ^ Murmur3_32HashFunction.g((int) this.f31424b);
            this.f31423a = g2;
            return Murmur3_32HashFunction.d(g2, this.f31426d);
        }

        @Override // d.g.c.d.c, d.g.c.d.f
        public f h(byte[] bArr, int i2, int i3) {
            n.v(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (true) {
                int i5 = i4 + 4;
                if (i5 > i3) {
                    break;
                }
                m(4, Murmur3_32HashFunction.e(bArr, i4 + i2));
                i4 = i5;
            }
            while (i4 < i3) {
                l(bArr[i2 + i4]);
                i4++;
            }
            return this;
        }

        @Override // d.g.c.d.f
        public f i(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                a(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                l(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @Override // d.g.c.d.c
        public f k(char c2) {
            m(2, c2);
            return this;
        }

        public f l(byte b2) {
            m(1, b2 & 255);
            return this;
        }

        public final void m(int i2, long j) {
            long j2 = this.f31424b;
            int i3 = this.f31425c;
            long j3 = ((j & 4294967295L) << i3) | j2;
            this.f31424b = j3;
            int i4 = i3 + (i2 * 8);
            this.f31425c = i4;
            this.f31426d += i2;
            if (i4 >= 32) {
                this.f31423a = Murmur3_32HashFunction.f(this.f31423a, Murmur3_32HashFunction.g((int) j3));
                this.f31424b >>>= 32;
                this.f31425c -= 32;
            }
        }

        @Override // d.g.c.d.f, d.g.c.d.j
        public f a(int i2) {
            m(4, i2);
            return this;
        }

        @Override // d.g.c.d.f, d.g.c.d.j
        public f b(long j) {
            m(4, (int) j);
            m(4, j >>> 32);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.d.c, d.g.c.d.f, d.g.c.d.j
        public f d(CharSequence charSequence, Charset charset) {
            if (d.g.c.a.c.f66186a.equals(charset)) {
                int length = charSequence.length();
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 4;
                    if (i3 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i2);
                    char charAt2 = charSequence.charAt(i2 + 1);
                    char charAt3 = charSequence.charAt(i2 + 2);
                    char charAt4 = charSequence.charAt(i2 + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    m(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i2 = i3;
                }
                while (i2 < length) {
                    char charAt5 = charSequence.charAt(i2);
                    if (charAt5 < 128) {
                        m(1, charAt5);
                    } else if (charAt5 < 2048) {
                        m(2, Murmur3_32HashFunction.b(charAt5));
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        m(3, Murmur3_32HashFunction.a(charAt5));
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i2);
                        if (codePointAt != charAt5) {
                            i2++;
                            m(4, Murmur3_32HashFunction.c(codePointAt));
                        } else {
                            f(charSequence.subSequence(i2, length).toString().getBytes(charset));
                            return this;
                        }
                    }
                    i2++;
                }
                return this;
            }
            return super.d(charSequence, charset);
        }
    }

    public Murmur3_32HashFunction(int i2) {
        this.seed = i2;
    }

    public static long a(char c2) {
        return (((c2 & '?') | 128) << 16) | (((c2 >>> '\f') | 480) & 255) | ((((c2 >>> 6) & 63) | 128) << 8);
    }

    public static long b(char c2) {
        return (((c2 & '?') | 128) << 8) | (((c2 >>> 6) | TbConfig.HEAD_IMG_SIZE) & 255);
    }

    public static long c(int i2) {
        return (((i2 >>> 18) | 240) & 255) | ((((i2 >>> 12) & 63) | 128) << 8) | ((((i2 >>> 6) & 63) | 128) << 16) | (((i2 & 63) | 128) << 24);
    }

    public static HashCode d(int i2, int i3) {
        int i4 = i2 ^ i3;
        int i5 = (i4 ^ (i4 >>> 16)) * (-2048144789);
        int i6 = (i5 ^ (i5 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i6 ^ (i6 >>> 16));
    }

    public static int e(byte[] bArr, int i2) {
        return Ints.e(bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]);
    }

    public static int f(int i2, int i3) {
        return (Integer.rotateLeft(i2 ^ i3, 13) * 5) - 430675100;
    }

    public static int g(int i2) {
        return Integer.rotateLeft(i2 * (-862048943), 15) * 461845907;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed;
    }

    @Override // d.g.c.d.b
    public HashCode hashBytes(byte[] bArr, int i2, int i3) {
        n.v(i2, i2 + i3, bArr.length);
        int i4 = this.seed;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6 + 4;
            if (i7 > i3) {
                break;
            }
            i4 = f(i4, g(e(bArr, i6 + i2)));
            i6 = i7;
        }
        int i8 = i6;
        int i9 = 0;
        while (i8 < i3) {
            i5 ^= d.g.c.g.b.c(bArr[i2 + i8]) << i9;
            i8++;
            i9 += 8;
        }
        return d(g(i5) ^ i4, i3);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // d.g.c.d.b
    public HashCode hashInt(int i2) {
        return d(f(this.seed, g(i2)), 4);
    }

    @Override // d.g.c.d.b
    public HashCode hashLong(long j) {
        int i2 = (int) (j >>> 32);
        return d(f(f(this.seed, g((int) j)), g(i2)), 8);
    }

    @Override // d.g.c.d.b
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (d.g.c.a.c.f66186a.equals(charset)) {
            int length = charSequence.length();
            int i2 = this.seed;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i4 + 4;
                if (i6 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i4);
                char charAt2 = charSequence.charAt(i4 + 1);
                char charAt3 = charSequence.charAt(i4 + 2);
                char charAt4 = charSequence.charAt(i4 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i2 = f(i2, g((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i5 += 4;
                i4 = i6;
            }
            long j = 0;
            while (i4 < length) {
                char charAt5 = charSequence.charAt(i4);
                if (charAt5 < 128) {
                    j |= charAt5 << i3;
                    i3 += 8;
                    i5++;
                } else if (charAt5 < 2048) {
                    j |= b(charAt5) << i3;
                    i3 += 16;
                    i5 += 2;
                } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                    int codePointAt = Character.codePointAt(charSequence, i4);
                    if (codePointAt == charAt5) {
                        return hashBytes(charSequence.toString().getBytes(charset));
                    }
                    i4++;
                    j |= c(codePointAt) << i3;
                    i5 += 4;
                } else {
                    j |= a(charAt5) << i3;
                    i3 += 24;
                    i5 += 3;
                }
                if (i3 >= 32) {
                    i2 = f(i2, g((int) j));
                    j >>>= 32;
                    i3 -= 32;
                }
                i4++;
            }
            return d(g((int) j) ^ i2, i5);
        }
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // d.g.c.d.b
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i2 = this.seed;
        for (int i3 = 1; i3 < charSequence.length(); i3 += 2) {
            i2 = f(i2, g(charSequence.charAt(i3 - 1) | (charSequence.charAt(i3) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i2 ^= g(charSequence.charAt(charSequence.length() - 1));
        }
        return d(i2, charSequence.length() * 2);
    }

    @Override // d.g.c.d.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + SmallTailInfo.EMOTION_SUFFIX;
    }
}
