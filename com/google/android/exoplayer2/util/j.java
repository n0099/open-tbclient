package com.google.android.exoplayer2.util;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j {
    public static final byte[] mGZ = {0, 0, 0, 1};
    public static final float[] mHk = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object mHl = new Object();
    private static int[] mHm = new int[10];

    /* loaded from: classes6.dex */
    public static final class b {
        public final int height;
        public final int mHn;
        public final float mHp;
        public final boolean mHq;
        public final boolean mHr;
        public final int mHs;
        public final int mHt;
        public final int mHu;
        public final boolean mHv;
        public final int width;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.mHn = i;
            this.width = i2;
            this.height = i3;
            this.mHp = f;
            this.mHq = z;
            this.mHr = z2;
            this.mHs = i4;
            this.mHt = i5;
            this.mHu = i6;
            this.mHv = z3;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public final int mHn;
        public final boolean mHo;
        public final int mnA;

        public a(int i, int i2, boolean z) {
            this.mnA = i;
            this.mHn = i2;
            this.mHo = z;
        }
    }

    public static int F(byte[] bArr, int i) {
        int i2;
        synchronized (mHl) {
            int i3 = 0;
            int i4 = 0;
            while (i4 < i) {
                int E = E(bArr, i4, i);
                if (E < i) {
                    if (mHm.length <= i3) {
                        mHm = Arrays.copyOf(mHm, mHm.length * 2);
                    }
                    mHm[i3] = E;
                    i3++;
                    i4 = E + 3;
                } else {
                    i4 = E;
                }
            }
            i2 = i - i3;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = mHm[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void k(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        for (int i2 = 0; i2 + 1 < position; i2++) {
            int i3 = byteBuffer.get(i2) & 255;
            if (i == 3) {
                if (i3 == 1 && (byteBuffer.get(i2 + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i2 - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i3 == 0) {
                i++;
            }
            if (i3 != 0) {
                i = 0;
            }
        }
        byteBuffer.clear();
    }

    public static boolean a(String str, byte b2) {
        return ("video/avc".equals(str) && (b2 & 31) == 6) || ("video/hevc".equals(str) && ((b2 & 126) >> 1) == 39);
    }

    public static int G(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int H(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static b C(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        m mVar = new m(bArr, i, i2);
        mVar.JU(8);
        int readBits = mVar.readBits(8);
        mVar.JU(16);
        int dzI = mVar.dzI();
        boolean z2 = false;
        if (readBits != 100 && readBits != 110 && readBits != 122 && readBits != 244 && readBits != 44 && readBits != 83 && readBits != 86 && readBits != 118 && readBits != 128 && readBits != 138) {
            z = false;
            i3 = 1;
        } else {
            int dzI2 = mVar.dzI();
            if (dzI2 == 3) {
                z2 = mVar.dvl();
            }
            mVar.dzI();
            mVar.dzI();
            mVar.dzp();
            if (mVar.dvl()) {
                int i7 = dzI2 != 3 ? 8 : 12;
                int i8 = 0;
                while (i8 < i7) {
                    if (mVar.dvl()) {
                        a(mVar, i8 < 6 ? 16 : 64);
                    }
                    i8++;
                }
            }
            z = z2;
            i3 = dzI2;
        }
        int dzI3 = mVar.dzI() + 4;
        int dzI4 = mVar.dzI();
        int i9 = 0;
        boolean z3 = false;
        if (dzI4 == 0) {
            i9 = mVar.dzI() + 4;
        } else if (dzI4 == 1) {
            z3 = mVar.dvl();
            mVar.dzJ();
            mVar.dzJ();
            long dzI5 = mVar.dzI();
            for (int i10 = 0; i10 < dzI5; i10++) {
                mVar.dzI();
            }
        }
        mVar.dzI();
        mVar.dzp();
        int dzI6 = mVar.dzI() + 1;
        int dzI7 = mVar.dzI() + 1;
        boolean dvl = mVar.dvl();
        int i11 = (2 - (dvl ? 1 : 0)) * dzI7;
        if (!dvl) {
            mVar.dzp();
        }
        mVar.dzp();
        int i12 = dzI6 * 16;
        int i13 = i11 * 16;
        if (mVar.dvl()) {
            int dzI8 = mVar.dzI();
            int dzI9 = mVar.dzI();
            int dzI10 = mVar.dzI();
            int dzI11 = mVar.dzI();
            if (i3 == 0) {
                i5 = 1;
                i6 = 2 - (dvl ? 1 : 0);
            } else {
                i5 = i3 == 3 ? 1 : 2;
                i6 = (2 - (dvl ? 1 : 0)) * (i3 == 1 ? 2 : 1);
            }
            i4 = i12 - (i5 * (dzI8 + dzI9));
            i13 -= i6 * (dzI10 + dzI11);
        } else {
            i4 = i12;
        }
        float f2 = 1.0f;
        if (mVar.dvl() && mVar.dvl()) {
            int readBits2 = mVar.readBits(8);
            if (readBits2 == 255) {
                int readBits3 = mVar.readBits(16);
                int readBits4 = mVar.readBits(16);
                if (readBits3 != 0 && readBits4 != 0) {
                    f2 = readBits3 / readBits4;
                }
                f = f2;
            } else if (readBits2 < mHk.length) {
                f = mHk[readBits2];
            } else {
                Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + readBits2);
            }
            return new b(dzI, i4, i13, f, z, dvl, dzI3, dzI4, i9, z3);
        }
        f = 1.0f;
        return new b(dzI, i4, i13, f, z, dvl, dzI3, dzI4, i9, z3);
    }

    public static a D(byte[] bArr, int i, int i2) {
        m mVar = new m(bArr, i, i2);
        mVar.JU(8);
        int dzI = mVar.dzI();
        int dzI2 = mVar.dzI();
        mVar.dzp();
        return new a(dzI, dzI2, mVar.dvl());
    }

    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        com.google.android.exoplayer2.util.a.checkState(i3 >= 0);
        if (i3 != 0) {
            if (zArr != null) {
                if (zArr[0]) {
                    b(zArr);
                    return i - 3;
                } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
                    b(zArr);
                    return i - 2;
                } else if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
                    b(zArr);
                    return i - 1;
                }
            }
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                if ((bArr[i5] & 254) == 0) {
                    if (bArr[i5 - 2] == 0 && bArr[i5 - 1] == 0 && bArr[i5] == 1) {
                        if (zArr != null) {
                            b(zArr);
                        }
                        return i5 - 2;
                    }
                    i5 -= 2;
                }
                i5 += 3;
            }
            if (zArr != null) {
                zArr[0] = i3 > 2 ? bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i2 + (-1)] == 1 : i3 == 2 ? zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i2 + (-1)] == 1 : zArr[1] && bArr[i2 + (-1)] == 1;
                zArr[1] = i3 > 1 ? bArr[i2 + (-2)] == 0 && bArr[i2 + (-1)] == 0 : zArr[2] && bArr[i2 + (-1)] == 0;
                zArr[2] = bArr[i2 + (-1)] == 0;
                return i2;
            }
            return i2;
        }
        return i2;
    }

    public static void b(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int E(byte[] bArr, int i, int i2) {
        for (int i3 = i; i3 < i2 - 2; i3++) {
            if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                return i3;
            }
        }
        return i2;
    }

    private static void a(m mVar, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((mVar.dzJ() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }
}
