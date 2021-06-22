package com.google.common.hash;

import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;
import d.g.c.a.n;
import java.io.Serializable;
/* loaded from: classes6.dex */
public abstract class HashCode {

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f31532e = "0123456789abcdef".toCharArray();

    /* loaded from: classes6.dex */
    public static final class BytesHashCode extends HashCode implements Serializable {
        public static final long serialVersionUID = 0;
        public final byte[] bytes;

        public BytesHashCode(byte[] bArr) {
            n.p(bArr);
            this.bytes = bArr;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            n.y(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
            byte[] bArr = this.bytes;
            return ((bArr[3] & 255) << 24) | ((bArr[1] & 255) << 8) | (bArr[0] & 255) | ((bArr[2] & 255) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            n.y(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
            return padToLong();
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode hashCode) {
            if (this.bytes.length != hashCode.getBytesInternal().length) {
                return false;
            }
            int i2 = 0;
            boolean z = true;
            while (true) {
                byte[] bArr = this.bytes;
                if (i2 >= bArr.length) {
                    return z;
                }
                z &= bArr[i2] == hashCode.getBytesInternal()[i2];
                i2++;
            }
        }

        @Override // com.google.common.hash.HashCode
        public byte[] getBytesInternal() {
            return this.bytes;
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            long j = this.bytes[0] & 255;
            for (int i2 = 1; i2 < Math.min(this.bytes.length, 8); i2++) {
                j |= (this.bytes[i2] & 255) << (i2 * 8);
            }
            return j;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            System.arraycopy(this.bytes, 0, bArr, i2, i3);
        }
    }

    /* loaded from: classes6.dex */
    public static final class IntHashCode extends HashCode implements Serializable {
        public static final long serialVersionUID = 0;
        public final int hash;

        public IntHashCode(int i2) {
            this.hash = i2;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            int i2 = this.hash;
            return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asInt();
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return UnsignedInts.f(this.hash);
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) (this.hash >> (i4 * 8));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class LongHashCode extends HashCode implements Serializable {
        public static final long serialVersionUID = 0;
        public final long hash;

        public LongHashCode(long j) {
            this.hash = j;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] asBytes() {
            long j = this.hash;
            return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int asInt() {
            return (int) this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public long asLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public int bits() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        public boolean equalsSameBits(HashCode hashCode) {
            return this.hash == hashCode.asLong();
        }

        @Override // com.google.common.hash.HashCode
        public long padToLong() {
            return this.hash;
        }

        @Override // com.google.common.hash.HashCode
        public void writeBytesToImpl(byte[] bArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[i2 + i4] = (byte) (this.hash >> (i4 * 8));
            }
        }
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            if (c2 < 'a' || c2 > 'f') {
                throw new IllegalArgumentException("Illegal hexadecimal character: " + c2);
            }
            return (c2 - 'a') + 10;
        }
        return c2 - '0';
    }

    public static HashCode fromBytes(byte[] bArr) {
        n.e(bArr.length >= 1, "A HashCode must contain at least 1 byte.");
        return fromBytesNoCopy((byte[]) bArr.clone());
    }

    public static HashCode fromBytesNoCopy(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode fromInt(int i2) {
        return new IntHashCode(i2);
    }

    public static HashCode fromLong(long j) {
        return new LongHashCode(j);
    }

    public static HashCode fromString(String str) {
        n.k(str.length() >= 2, "input string (%s) must have at least 2 characters", str);
        n.k(str.length() % 2 == 0, "input string (%s) must have an even number of characters", str);
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length(); i2 += 2) {
            bArr[i2 / 2] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return fromBytesNoCopy(bArr);
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public abstract int bits();

    public final boolean equals(Object obj) {
        if (obj instanceof HashCode) {
            HashCode hashCode = (HashCode) obj;
            return bits() == hashCode.bits() && equalsSameBits(hashCode);
        }
        return false;
    }

    public abstract boolean equalsSameBits(HashCode hashCode);

    public byte[] getBytesInternal() {
        return asBytes();
    }

    public final int hashCode() {
        if (bits() >= 32) {
            return asInt();
        }
        byte[] bytesInternal = getBytesInternal();
        int i2 = bytesInternal[0] & 255;
        for (int i3 = 1; i3 < bytesInternal.length; i3++) {
            i2 |= (bytesInternal[i3] & 255) << (i3 * 8);
        }
        return i2;
    }

    public abstract long padToLong();

    public final String toString() {
        byte[] bytesInternal = getBytesInternal();
        StringBuilder sb = new StringBuilder(bytesInternal.length * 2);
        for (byte b2 : bytesInternal) {
            sb.append(f31532e[(b2 >> 4) & 15]);
            sb.append(f31532e[b2 & 15]);
        }
        return sb.toString();
    }

    public int writeBytesTo(byte[] bArr, int i2, int i3) {
        int i4 = Ints.i(i3, bits() / 8);
        n.v(i2, i2 + i4, bArr.length);
        writeBytesToImpl(bArr, i2, i4);
        return i4;
    }

    public abstract void writeBytesToImpl(byte[] bArr, int i2, int i3);
}
