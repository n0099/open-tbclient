package com.google.android.exoplayer2.extractor.d;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.l;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class k {
    public static int JQ(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static d G(l lVar) throws ParserException {
        a(1, lVar, false);
        long dyn = lVar.dyn();
        int readUnsignedByte = lVar.readUnsignedByte();
        long dyn2 = lVar.dyn();
        int dyo = lVar.dyo();
        int dyo2 = lVar.dyo();
        int dyo3 = lVar.dyo();
        int readUnsignedByte2 = lVar.readUnsignedByte();
        return new d(dyn, readUnsignedByte, dyn2, dyo, dyo2, dyo3, (int) Math.pow(2.0d, readUnsignedByte2 & 15), (int) Math.pow(2.0d, (readUnsignedByte2 & 240) >> 4), (lVar.readUnsignedByte() & 1) > 0, Arrays.copyOf(lVar.data, lVar.dyi()));
    }

    public static b H(l lVar) throws ParserException {
        a(3, lVar, false);
        String LP = lVar.LP((int) lVar.dyn());
        long dyn = lVar.dyn();
        String[] strArr = new String[(int) dyn];
        int length = LP.length() + 11 + 4;
        for (int i = 0; i < dyn; i++) {
            strArr[i] = lVar.LP((int) lVar.dyn());
            length = length + 4 + strArr[i].length();
        }
        if ((lVar.readUnsignedByte() & 1) == 0) {
            throw new ParserException("framing bit expected to be set");
        }
        return new b(LP, strArr, length + 1);
    }

    public static boolean a(int i, l lVar, boolean z) throws ParserException {
        if (lVar.dyh() < 7) {
            if (z) {
                return false;
            }
            throw new ParserException("too short header: " + lVar.dyh());
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
        iVar.JP(lVar.getPosition() * 8);
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
        if (!iVar.dua()) {
            throw new ParserException("framing bit after modes not set as expected");
        }
        return a2;
    }

    private static c[] a(i iVar) {
        int readBits = iVar.readBits(6) + 1;
        c[] cVarArr = new c[readBits];
        for (int i = 0; i < readBits; i++) {
            cVarArr[i] = new c(iVar.dua(), iVar.readBits(16), iVar.readBits(16), iVar.readBits(8));
        }
        return cVarArr;
    }

    private static void a(int i, i iVar) throws ParserException {
        int readBits = iVar.readBits(6) + 1;
        for (int i2 = 0; i2 < readBits; i2++) {
            int readBits2 = iVar.readBits(16);
            switch (readBits2) {
                case 0:
                    int readBits3 = iVar.dua() ? iVar.readBits(4) + 1 : 1;
                    if (iVar.dua()) {
                        int readBits4 = iVar.readBits(8) + 1;
                        for (int i3 = 0; i3 < readBits4; i3++) {
                            iVar.JP(JQ(i - 1));
                            iVar.JP(JQ(i - 1));
                        }
                    }
                    if (iVar.readBits(2) != 0) {
                        throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                    }
                    if (readBits3 > 1) {
                        for (int i4 = 0; i4 < i; i4++) {
                            iVar.JP(4);
                        }
                    }
                    for (int i5 = 0; i5 < readBits3; i5++) {
                        iVar.JP(8);
                        iVar.JP(8);
                        iVar.JP(8);
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
            iVar.JP(24);
            iVar.JP(24);
            iVar.JP(24);
            int readBits2 = iVar.readBits(6) + 1;
            iVar.JP(8);
            int[] iArr = new int[readBits2];
            for (int i2 = 0; i2 < readBits2; i2++) {
                iArr[i2] = ((iVar.dua() ? iVar.readBits(5) : 0) * 8) + iVar.readBits(3);
            }
            for (int i3 = 0; i3 < readBits2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        iVar.JP(8);
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
                    iVar.JP(8);
                    iVar.JP(16);
                    iVar.JP(16);
                    iVar.JP(6);
                    iVar.JP(8);
                    int readBits3 = iVar.readBits(4) + 1;
                    for (int i2 = 0; i2 < readBits3; i2++) {
                        iVar.JP(8);
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
                            iVar.JP(8);
                        }
                        for (int i6 = 0; i6 < (1 << readBits5); i6++) {
                            iVar.JP(8);
                        }
                    }
                    iVar.JP(2);
                    int readBits6 = iVar.readBits(4);
                    int i7 = 0;
                    int i8 = 0;
                    for (int i9 = 0; i9 < readBits4; i9++) {
                        i8 += iArr2[iArr[i9]];
                        while (i7 < i8) {
                            iVar.JP(readBits6);
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
        boolean dua = iVar.dua();
        if (!dua) {
            boolean dua2 = iVar.dua();
            for (int i = 0; i < jArr.length; i++) {
                if (dua2) {
                    if (iVar.dua()) {
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
                int readBits4 = iVar.readBits(JQ(readBits2 - i2));
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
            iVar.JP(32);
            iVar.JP(32);
            int readBits6 = iVar.readBits(4) + 1;
            iVar.JP(1);
            if (readBits5 == 1) {
                if (readBits != 0) {
                    j = P(readBits2, readBits);
                } else {
                    j = 0;
                }
            } else {
                j = readBits2 * readBits;
            }
            iVar.JP((int) (j * readBits6));
        }
        return new a(readBits, readBits2, jArr, readBits5, dua);
    }

    private static long P(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public final int dimensions;
        public final boolean isOrdered;
        public final int mlr;
        public final long[] mls;
        public final int mlt;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.dimensions = i;
            this.mlr = i2;
            this.mls = jArr;
            this.mlt = i3;
            this.isOrdered = z;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public final int length;
        public final String[] mlu;
        public final String vendor;

        public b(String str, String[] strArr, int i) {
            this.vendor = str;
            this.mlu = strArr;
            this.length = i;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public final int channels;
        public final byte[] data;
        public final int mlA;
        public final int mlB;
        public final int mlC;
        public final int mlD;
        public final boolean mlE;
        public final int mlz;
        public final long sampleRate;
        public final long version;

        public d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.version = j;
            this.channels = i;
            this.sampleRate = j2;
            this.mlz = i2;
            this.mlA = i3;
            this.mlB = i4;
            this.mlC = i5;
            this.mlD = i6;
            this.mlE = z;
            this.data = bArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public final boolean mlv;
        public final int mlw;
        public final int mlx;
        public final int mly;

        public c(boolean z, int i, int i2, int i3) {
            this.mlv = z;
            this.mlw = i;
            this.mlx = i2;
            this.mly = i3;
        }
    }
}
