package com.google.android.exoplayer2.extractor.d;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import java.util.Arrays;
/* loaded from: classes4.dex */
final class k {
    public static int JH(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static d G(l lVar) throws ParserException {
        a(1, lVar, false);
        long dxb = lVar.dxb();
        int readUnsignedByte = lVar.readUnsignedByte();
        long dxb2 = lVar.dxb();
        int dxc = lVar.dxc();
        int dxc2 = lVar.dxc();
        int dxc3 = lVar.dxc();
        int readUnsignedByte2 = lVar.readUnsignedByte();
        return new d(dxb, readUnsignedByte, dxb2, dxc, dxc2, dxc3, (int) Math.pow(2.0d, readUnsignedByte2 & 15), (int) Math.pow(2.0d, (readUnsignedByte2 & 240) >> 4), (lVar.readUnsignedByte() & 1) > 0, Arrays.copyOf(lVar.data, lVar.dwW()));
    }

    public static b H(l lVar) throws ParserException {
        a(3, lVar, false);
        String LG = lVar.LG((int) lVar.dxb());
        long dxb = lVar.dxb();
        String[] strArr = new String[(int) dxb];
        int length = LG.length() + 11 + 4;
        for (int i = 0; i < dxb; i++) {
            strArr[i] = lVar.LG((int) lVar.dxb());
            length = length + 4 + strArr[i].length();
        }
        if ((lVar.readUnsignedByte() & 1) == 0) {
            throw new ParserException("framing bit expected to be set");
        }
        return new b(LG, strArr, length + 1);
    }

    public static boolean a(int i, l lVar, boolean z) throws ParserException {
        if (lVar.dwV() < 7) {
            if (z) {
                return false;
            }
            throw new ParserException("too short header: " + lVar.dwV());
        } else if (lVar.readUnsignedByte() != i) {
            if (z) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i));
        } else if (lVar.readUnsignedByte() != 118 || lVar.readUnsignedByte() != 111 || lVar.readUnsignedByte() != 114 || lVar.readUnsignedByte() != 98 || lVar.readUnsignedByte() != 105 || lVar.readUnsignedByte() != 115) {
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        } else {
            return true;
        }
    }

    public static c[] i(l lVar, int i) throws ParserException {
        a(5, lVar, false);
        int readUnsignedByte = lVar.readUnsignedByte() + 1;
        i iVar = new i(lVar.data);
        iVar.JG(lVar.getPosition() * 8);
        for (int i2 = 0; i2 < readUnsignedByte; i2++) {
            d(iVar);
        }
        int readBits = iVar.readBits(6) + 1;
        for (int i3 = 0; i3 < readBits; i3++) {
            if (iVar.readBits(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        c(iVar);
        b(iVar);
        a(i, iVar);
        c[] a2 = a(iVar);
        if (!iVar.dsM()) {
            throw new ParserException("framing bit after modes not set as expected");
        }
        return a2;
    }

    private static c[] a(i iVar) {
        int readBits = iVar.readBits(6) + 1;
        c[] cVarArr = new c[readBits];
        for (int i = 0; i < readBits; i++) {
            cVarArr[i] = new c(iVar.dsM(), iVar.readBits(16), iVar.readBits(16), iVar.readBits(8));
        }
        return cVarArr;
    }

    private static void a(int i, i iVar) throws ParserException {
        int readBits = iVar.readBits(6) + 1;
        for (int i2 = 0; i2 < readBits; i2++) {
            int readBits2 = iVar.readBits(16);
            switch (readBits2) {
                case 0:
                    int readBits3 = iVar.dsM() ? iVar.readBits(4) + 1 : 1;
                    if (iVar.dsM()) {
                        int readBits4 = iVar.readBits(8) + 1;
                        for (int i3 = 0; i3 < readBits4; i3++) {
                            iVar.JG(JH(i - 1));
                            iVar.JG(JH(i - 1));
                        }
                    }
                    if (iVar.readBits(2) != 0) {
                        throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                    }
                    if (readBits3 > 1) {
                        for (int i4 = 0; i4 < i; i4++) {
                            iVar.JG(4);
                        }
                    }
                    for (int i5 = 0; i5 < readBits3; i5++) {
                        iVar.JG(8);
                        iVar.JG(8);
                        iVar.JG(8);
                    }
                    break;
                default:
                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + readBits2);
                    break;
            }
        }
    }

    private static void b(i iVar) throws ParserException {
        int readBits = iVar.readBits(6) + 1;
        for (int i = 0; i < readBits; i++) {
            if (iVar.readBits(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            iVar.JG(24);
            iVar.JG(24);
            iVar.JG(24);
            int readBits2 = iVar.readBits(6) + 1;
            iVar.JG(8);
            int[] iArr = new int[readBits2];
            for (int i2 = 0; i2 < readBits2; i2++) {
                iArr[i2] = ((iVar.dsM() ? iVar.readBits(5) : 0) * 8) + iVar.readBits(3);
            }
            for (int i3 = 0; i3 < readBits2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        iVar.JG(8);
                    }
                }
            }
        }
    }

    private static void c(i iVar) throws ParserException {
        int readBits = iVar.readBits(6) + 1;
        for (int i = 0; i < readBits; i++) {
            int readBits2 = iVar.readBits(16);
            switch (readBits2) {
                case 0:
                    iVar.JG(8);
                    iVar.JG(16);
                    iVar.JG(16);
                    iVar.JG(6);
                    iVar.JG(8);
                    int readBits3 = iVar.readBits(4) + 1;
                    for (int i2 = 0; i2 < readBits3; i2++) {
                        iVar.JG(8);
                    }
                    break;
                case 1:
                    int readBits4 = iVar.readBits(5);
                    int i3 = -1;
                    int[] iArr = new int[readBits4];
                    for (int i4 = 0; i4 < readBits4; i4++) {
                        iArr[i4] = iVar.readBits(4);
                        if (iArr[i4] > i3) {
                            i3 = iArr[i4];
                        }
                    }
                    int[] iArr2 = new int[i3 + 1];
                    for (int i5 = 0; i5 < iArr2.length; i5++) {
                        iArr2[i5] = iVar.readBits(3) + 1;
                        int readBits5 = iVar.readBits(2);
                        if (readBits5 > 0) {
                            iVar.JG(8);
                        }
                        for (int i6 = 0; i6 < (1 << readBits5); i6++) {
                            iVar.JG(8);
                        }
                    }
                    iVar.JG(2);
                    int readBits6 = iVar.readBits(4);
                    int i7 = 0;
                    int i8 = 0;
                    for (int i9 = 0; i9 < readBits4; i9++) {
                        i8 += iArr2[iArr[i9]];
                        while (i7 < i8) {
                            iVar.JG(readBits6);
                            i7++;
                        }
                    }
                    break;
                default:
                    throw new ParserException("floor type greater than 1 not decodable: " + readBits2);
            }
        }
    }

    private static a d(i iVar) throws ParserException {
        long j;
        if (iVar.readBits(24) != 5653314) {
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + iVar.getPosition());
        }
        int readBits = iVar.readBits(16);
        int readBits2 = iVar.readBits(24);
        long[] jArr = new long[readBits2];
        boolean dsM = iVar.dsM();
        if (!dsM) {
            boolean dsM2 = iVar.dsM();
            for (int i = 0; i < jArr.length; i++) {
                if (dsM2) {
                    if (iVar.dsM()) {
                        jArr[i] = iVar.readBits(5) + 1;
                    } else {
                        jArr[i] = 0;
                    }
                } else {
                    jArr[i] = iVar.readBits(5) + 1;
                }
            }
        } else {
            int readBits3 = iVar.readBits(5) + 1;
            int i2 = 0;
            while (i2 < jArr.length) {
                int readBits4 = iVar.readBits(JH(readBits2 - i2));
                int i3 = 0;
                while (i3 < readBits4 && i2 < jArr.length) {
                    jArr[i2] = readBits3;
                    i3++;
                    i2++;
                }
                readBits3++;
            }
        }
        int readBits5 = iVar.readBits(4);
        if (readBits5 > 2) {
            throw new ParserException("lookup type greater than 2 not decodable: " + readBits5);
        }
        if (readBits5 == 1 || readBits5 == 2) {
            iVar.JG(32);
            iVar.JG(32);
            int readBits6 = iVar.readBits(4) + 1;
            iVar.JG(1);
            if (readBits5 == 1) {
                if (readBits != 0) {
                    j = P(readBits2, readBits);
                } else {
                    j = 0;
                }
            } else {
                j = readBits2 * readBits;
            }
            iVar.JG((int) (j * readBits6));
        }
        return new a(readBits, readBits2, jArr, readBits5, dsM);
    }

    private static long P(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public final boolean isOrdered;
        public final int mhv;
        public final int mhw;
        public final long[] mhx;
        public final int mhy;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.mhv = i;
            this.mhw = i2;
            this.mhx = jArr;
            this.mhy = i3;
            this.isOrdered = z;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public final int length;
        public final String[] mhz;
        public final String vendor;

        public b(String str, String[] strArr, int i) {
            this.vendor = str;
            this.mhz = strArr;
            this.length = i;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public final int channels;
        public final byte[] data;
        public final int mhE;
        public final int mhF;
        public final int mhG;
        public final int mhH;
        public final int mhI;
        public final boolean mhJ;
        public final long sampleRate;
        public final long version;

        public d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.version = j;
            this.channels = i;
            this.sampleRate = j2;
            this.mhE = i2;
            this.mhF = i3;
            this.mhG = i4;
            this.mhH = i5;
            this.mhI = i6;
            this.mhJ = z;
            this.data = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public final boolean mhA;
        public final int mhB;
        public final int mhC;
        public final int mhD;

        public c(boolean z, int i, int i2, int i3) {
            this.mhA = z;
            this.mhB = i;
            this.mhC = i2;
            this.mhD = i3;
        }
    }
}
