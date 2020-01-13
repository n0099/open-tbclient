package com.google.android.exoplayer2.util;

import android.util.Pair;
import com.baidu.ala.player.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class c {
    private static final byte[] mGo = {0, 0, 0, 1};
    private static final int[] mGp = {96000, 88200, 64000, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_FREQUENCY, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K, 24000, 22050, 16000, 12000, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000, 7350};
    private static final int[] mGq = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> au(byte[] bArr) throws ParserException {
        return a(new k(bArr), false);
    }

    public static Pair<Integer, Integer> a(k kVar, boolean z) throws ParserException {
        int j = j(kVar);
        int k = k(kVar);
        int readBits = kVar.readBits(4);
        if (j == 5 || j == 29) {
            k = k(kVar);
            j = j(kVar);
            if (j == 22) {
                readBits = kVar.readBits(4);
            }
        }
        if (z) {
            switch (j) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    a(kVar, j, readBits);
                    switch (j) {
                        case 17:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            int readBits2 = kVar.readBits(2);
                            if (readBits2 == 2 || readBits2 == 3) {
                                throw new ParserException("Unsupported epConfig: " + readBits2);
                            }
                            break;
                    }
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    throw new ParserException("Unsupported audio object type: " + j);
            }
        }
        int i = mGq[readBits];
        a.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(k), Integer.valueOf(i));
    }

    public static byte[] dT(int i, int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < mGp.length; i4++) {
            if (i == mGp[i4]) {
                i3 = i4;
            }
        }
        int i5 = -1;
        for (int i6 = 0; i6 < mGq.length; i6++) {
            if (i2 == mGq[i6]) {
                i5 = i6;
            }
        }
        if (i == -1 || i5 == -1) {
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i + ", " + i2);
        }
        return aj(2, i3, i5);
    }

    public static byte[] aj(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] x(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[mGo.length + i2];
        System.arraycopy(mGo, 0, bArr2, 0, mGo.length);
        System.arraycopy(bArr, i, bArr2, mGo.length, i2);
        return bArr2;
    }

    public static byte[][] av(byte[] bArr) {
        if (!C(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            arrayList.add(Integer.valueOf(i));
            i = B(bArr, i + mGo.length);
        } while (i != -1);
        byte[][] bArr2 = new byte[arrayList.size()];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            byte[] bArr3 = new byte[(i2 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i2 + 1)).intValue() : bArr.length) - intValue];
            System.arraycopy(bArr, intValue, bArr3, 0, bArr3.length);
            bArr2[i2] = bArr3;
            i2++;
        }
        return bArr2;
    }

    private static int B(byte[] bArr, int i) {
        int length = bArr.length - mGo.length;
        for (int i2 = i; i2 <= length; i2++) {
            if (C(bArr, i2)) {
                return i2;
            }
        }
        return -1;
    }

    private static boolean C(byte[] bArr, int i) {
        if (bArr.length - i <= mGo.length) {
            return false;
        }
        for (int i2 = 0; i2 < mGo.length; i2++) {
            if (bArr[i + i2] != mGo[i2]) {
                return false;
            }
        }
        return true;
    }

    private static int j(k kVar) {
        int readBits = kVar.readBits(5);
        if (readBits == 31) {
            return kVar.readBits(6) + 32;
        }
        return readBits;
    }

    private static int k(k kVar) {
        int readBits = kVar.readBits(4);
        if (readBits == 15) {
            return kVar.readBits(24);
        }
        a.checkArgument(readBits < 13);
        return mGp[readBits];
    }

    private static void a(k kVar, int i, int i2) {
        kVar.JP(1);
        if (kVar.dtY()) {
            kVar.JP(14);
        }
        boolean dtY = kVar.dtY();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            kVar.JP(3);
        }
        if (dtY) {
            if (i == 22) {
                kVar.JP(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                kVar.JP(3);
            }
            kVar.JP(1);
        }
    }
}
