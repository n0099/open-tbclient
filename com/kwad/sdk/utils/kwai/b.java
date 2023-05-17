package com.kwad.sdk.utils.kwai;

import java.nio.charset.Charset;
import kotlin.jvm.internal.ByteCompanionObject;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes9.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public char[] apv;
    public byte[] apw;
    public int position;

    public b(int i) {
        this(new byte[i], 0);
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public b(byte[] bArr, int i) {
        this.apv = null;
        this.apw = bArr;
        this.position = i;
    }

    public static int bG(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    private char[] bI(int i) {
        char[] cArr = this.apv;
        if (cArr == null) {
            if (i <= 256) {
                this.apv = new char[256];
            } else {
                this.apv = new char[2048];
            }
        } else if (cArr.length < i) {
            this.apv = new char[2048];
        }
        return this.apv;
    }

    private String bJ(int i) {
        if (i > 2048) {
            return new String(this.apw, this.position, i, UTF_8);
        }
        char[] bI = bI(i);
        byte[] bArr = this.apw;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                bI[i4] = (char) (b ^ 1);
                i2 = i5;
                i4++;
            } else if (b < -32) {
                bI[i4] = (char) (((b & 31) << 6) | (bArr[i5] & 63));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                bI[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & 63) << 6) | (bArr[i6] & 63));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((bArr[i5] & 63) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i8] & 63);
                int i10 = i4 + 1;
                bI[i4] = (char) ((i9 >>> 10) + 55232);
                i4 = i10 + 1;
                bI[i10] = (char) ((i9 & 1023) + 56320);
                i2 = i8 + 1;
            }
        }
        if (i2 <= i3) {
            return new String(bI, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String bK(int i) {
        if (i > 2048) {
            return new String(this.apw, this.position, i, UTF_8);
        }
        char[] bI = bI(i);
        byte[] bArr = this.apw;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                bI[i4] = (char) b;
                i2 = i5;
                i4++;
            } else if (b < -32) {
                bI[i4] = (char) (((b & 31) << 6) | (bArr[i5] & 63));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                bI[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & 63) << 6) | (bArr[i6] & 63));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((bArr[i5] & 63) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i8] & 63);
                int i10 = i4 + 1;
                bI[i4] = (char) ((i9 >>> 10) + 55232);
                i4 = i10 + 1;
                bI[i10] = (char) ((i9 & 1023) + 56320);
                i2 = i8 + 1;
            }
        }
        if (i2 <= i3) {
            return new String(bI, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public static int ed(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                i2++;
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i2 += 3;
            } else {
                i = i3 + 1;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    private void ee(String str) {
        byte[] bArr = this.apw;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) (charAt ^ 1);
                i2 = i3;
                i++;
            } else if (charAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((charAt >>> 6) | 192);
                i = i4 + 1;
                bArr[i4] = (byte) ((charAt & RFC1522Codec.SEP) | 128);
                i2 = i3;
            } else if (charAt < 55296 || charAt > 57343) {
                int i5 = i + 1;
                bArr[i] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((charAt & RFC1522Codec.SEP) | 128);
                i2 = i3;
                i = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & 63) | 128);
                i2 = i7;
            }
        }
        this.position = i;
    }

    public static byte[] ef(String str) {
        byte[] bArr = new byte[ed(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                bArr[i2] = (byte) (charAt ^ 1);
                i = i3;
                i2++;
            } else if (charAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> 6) | 192);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((charAt & RFC1522Codec.SEP) | 128);
                i = i3;
            } else if (charAt < 55296 || charAt > 57343) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((charAt & RFC1522Codec.SEP) | 128);
                i = i3;
                i2 = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i2 + 1;
                bArr[i2] = (byte) ((charAt2 >>> 18) | 240);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i2 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & 63) | 128);
                i = i7;
            }
        }
        return bArr;
    }

    private long getLong(int i) {
        byte[] bArr = this.apw;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        return (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 40) | ((255 & bArr[i7]) << 48) | (bArr[i7 + 1] << 56);
    }

    public static String j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i2 = i4;
                i3++;
            } else if (b < -32) {
                cArr[i3] = (char) (((b & 31) << 6) | (bArr[i4] & 63));
                i2 = i4 + 1;
                i3++;
            } else if (b < -16) {
                int i5 = i4 + 1;
                cArr[i3] = (char) (((b & 15) << 12) | ((bArr[i4] & 63) << 6) | (bArr[i5] & 63));
                i2 = i5 + 1;
                i3++;
            } else {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                int i8 = ((b & 7) << 18) | ((bArr[i4] & 63) << 12) | ((bArr[i6] & 63) << 6) | (bArr[i7] & 63);
                int i9 = i3 + 1;
                cArr[i3] = (char) ((i8 >>> 10) + 55232);
                i3 = i9 + 1;
                cArr[i9] = (char) ((i8 & 1023) + 56320);
                i2 = i7 + 1;
            }
        }
        if (i2 <= i) {
            return new String(cArr, 0, i3);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private int s(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.apw[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.apw[i] = (byte) i2;
        return i3;
    }

    public final int AX() {
        byte[] bArr = this.apw;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = b & ByteCompanionObject.MAX_VALUE;
        int i4 = i2 + 1;
        this.position = i4;
        int i5 = i3 | (bArr[i2] << 7);
        if ((i5 >> 14) == 0) {
            return i5;
        }
        int i6 = i4 + 1;
        this.position = i6;
        int i7 = (i5 & 16383) | (bArr[i4] << 14);
        if ((i7 >> 21) == 0) {
            return i7;
        }
        int i8 = i6 + 1;
        this.position = i8;
        int i9 = (i7 & 2097151) | (bArr[i6] << 21);
        if ((i9 >> 28) == 0) {
            return i9;
        }
        this.position = i8 + 1;
        return (bArr[i8] << 28) | (i9 & 268435455);
    }

    public final void T(long j) {
        b(this.position, j);
        this.position += 8;
    }

    public final void a(short s) {
        byte[] bArr = this.apw;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) s;
        this.position = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public final void b(byte b) {
        byte[] bArr = this.apw;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final void b(int i, long j) {
        byte[] bArr = this.apw;
        int i2 = i + 1;
        bArr[i] = (byte) j;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >> 40);
        bArr[i7] = (byte) (j >> 48);
        bArr[i7 + 1] = (byte) (j >> 56);
    }

    public final void bE(int i) {
        byte[] bArr = this.apw;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (i >> 16);
        this.position = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void bF(int i) {
        this.position = s(this.position, i);
    }

    public final String bH(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String bK = bK(i);
        this.position += i;
        return bK;
    }

    public final void ec(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ee(str);
    }

    public final byte get() {
        byte[] bArr = this.apw;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.apw, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.apw;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = (bArr[i] & 255) | ((bArr[i2] & 255) << 8);
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        this.position = i5 + 1;
        return (bArr[i5] << 24) | i6;
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public final short getShort() {
        byte[] bArr = this.apw;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        this.position = i2 + 1;
        return (short) ((bArr[i2] << 8) | (bArr[i] & 255));
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String bJ = bJ(i);
        this.position += i;
        return bJ;
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.apw, this.position, length);
            this.position += length;
        }
    }

    public final void r(int i, int i2) {
        byte[] bArr = this.apw;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    public final long t(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            j ^= (this.apw[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (j >>> (64 - i9)) | (j << i9);
    }
}
