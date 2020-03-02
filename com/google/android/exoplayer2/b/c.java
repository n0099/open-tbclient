package com.google.android.exoplayer2.b;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class c extends e {
    private static final int[] mCH = new int[0];
    private final f.a mCI;
    private final AtomicReference<C0672c> mCJ;

    /* renamed from: com.google.android.exoplayer2.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0672c {
        public final String mCO;
        public final String mCP;
        public final int mCQ;
        public final int mCR;
        public final int mCS;
        public final boolean mCT;
        public final int mCU;
        public final int mCV;
        public final boolean mCW;
        public final boolean mCX;
        public final boolean mCY;
        public final boolean mCZ;
        public final boolean mDa;

        public C0672c() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public C0672c(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4, boolean z5, int i4, int i5, boolean z6) {
            this.mCO = str;
            this.mCP = str2;
            this.mCX = z;
            this.mCY = z2;
            this.mCZ = z3;
            this.mCQ = i;
            this.mCR = i2;
            this.mCS = i3;
            this.mCT = z4;
            this.mDa = z5;
            this.mCU = i4;
            this.mCV = i5;
            this.mCW = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0672c c0672c = (C0672c) obj;
            return this.mCX == c0672c.mCX && this.mCY == c0672c.mCY && this.mCZ == c0672c.mCZ && this.mCQ == c0672c.mCQ && this.mCR == c0672c.mCR && this.mCT == c0672c.mCT && this.mDa == c0672c.mDa && this.mCW == c0672c.mCW && this.mCU == c0672c.mCU && this.mCV == c0672c.mCV && this.mCS == c0672c.mCS && TextUtils.equals(this.mCO, c0672c.mCO) && TextUtils.equals(this.mCP, c0672c.mCP);
        }

        public int hashCode() {
            return (((((((this.mDa ? 1 : 0) + (((this.mCT ? 1 : 0) + (((((((((this.mCZ ? 1 : 0) + (((this.mCY ? 1 : 0) + (((this.mCX ? 1 : 0) + (((this.mCO.hashCode() * 31) + this.mCP.hashCode()) * 31)) * 31)) * 31)) * 31) + this.mCQ) * 31) + this.mCR) * 31) + this.mCS) * 31)) * 31)) * 31) + (this.mCW ? 1 : 0)) * 31) + this.mCU) * 31) + this.mCV;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.mCI = aVar;
        this.mCJ = new AtomicReference<>(new C0672c());
    }

    @Override // com.google.android.exoplayer2.b.e
    protected f[] a(t[] tVarArr, u[] uVarArr, int[][][] iArr) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        boolean z3;
        int length = tVarArr.length;
        f[] fVarArr = new f[length];
        C0672c c0672c = this.mCJ.get();
        boolean z4 = false;
        int i = 0;
        boolean z5 = false;
        while (i < length) {
            if (2 == tVarArr[i].getTrackType()) {
                if (!z5) {
                    fVarArr[i] = a(tVarArr[i], uVarArr[i], iArr[i], c0672c, this.mCI);
                    z5 = fVarArr[i] != null;
                }
                z3 = (uVarArr[i].length > 0) | z4;
            } else {
                z3 = z4;
            }
            i++;
            z4 = z3;
        }
        boolean z6 = false;
        boolean z7 = false;
        int i2 = 0;
        while (i2 < length) {
            switch (tVarArr[i2].getTrackType()) {
                case 1:
                    if (!z6) {
                        fVarArr[i2] = a(uVarArr[i2], iArr[i2], c0672c, z4 ? null : this.mCI);
                        boolean z8 = z7;
                        z2 = fVarArr[i2] != null;
                        z = z8;
                        continue;
                        i2++;
                        z6 = z2;
                        z7 = z;
                    }
                    break;
                case 2:
                    z = z7;
                    z2 = z6;
                    continue;
                    i2++;
                    z6 = z2;
                    z7 = z;
                case 3:
                    if (!z7) {
                        fVarArr[i2] = b(uVarArr[i2], iArr[i2], c0672c);
                        z = fVarArr[i2] != null;
                        z2 = z6;
                        continue;
                        i2++;
                        z6 = z2;
                        z7 = z;
                    }
                    break;
                default:
                    fVarArr[i2] = a(tVarArr[i2].getTrackType(), uVarArr[i2], iArr[i2], c0672c);
                    break;
            }
            z = z7;
            z2 = z6;
            i2++;
            z6 = z2;
            z7 = z;
        }
        return fVarArr;
    }

    protected f a(t tVar, u uVar, int[][] iArr, C0672c c0672c, f.a aVar) throws ExoPlaybackException {
        f fVar = null;
        if (!c0672c.mCX && aVar != null) {
            fVar = b(tVar, uVar, iArr, c0672c, aVar);
        }
        if (fVar == null) {
            return a(uVar, iArr, c0672c);
        }
        return fVar;
    }

    private static f b(t tVar, u uVar, int[][] iArr, C0672c c0672c, f.a aVar) throws ExoPlaybackException {
        int i = 0;
        int i2 = c0672c.mCZ ? 24 : 16;
        boolean z = c0672c.mCY && (tVar.dsN() & i2) != 0;
        while (true) {
            int i3 = i;
            if (i3 < uVar.length) {
                com.google.android.exoplayer2.source.t KR = uVar.KR(i3);
                int[] a2 = a(KR, iArr[i3], z, i2, c0672c.mCQ, c0672c.mCR, c0672c.mCS, c0672c.mCU, c0672c.mCV, c0672c.mCW);
                if (a2.length <= 0) {
                    i = i3 + 1;
                } else {
                    return aVar.b(KR, a2);
                }
            } else {
                return null;
            }
        }
    }

    private static int[] a(com.google.android.exoplayer2.source.t tVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        String str;
        int i7;
        if (tVar.length < 2) {
            return mCH;
        }
        List<Integer> a2 = a(tVar, i5, i6, z2);
        if (a2.size() < 2) {
            return mCH;
        }
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i8 = 0;
            int i9 = 0;
            while (i9 < a2.size()) {
                String str3 = tVar.KQ(a2.get(i9).intValue()).sampleMimeType;
                if (!hashSet.add(str3) || (i7 = a(tVar, iArr, i, str3, i2, i3, i4, a2)) <= i8) {
                    i7 = i8;
                    str3 = str2;
                }
                i9++;
                i8 = i7;
                str2 = str3;
            }
            str = str2;
        }
        b(tVar, iArr, i, str, i2, i3, i4, a2);
        return a2.size() < 2 ? mCH : v.fl(a2);
    }

    private static int a(com.google.android.exoplayer2.source.t tVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 < list.size()) {
                int intValue = list.get(i7).intValue();
                i5 = a(tVar.KQ(intValue), str, iArr[intValue], i, i2, i3, i4) ? i8 + 1 : i8;
                i6 = i7 + 1;
            } else {
                return i8;
            }
        }
    }

    private static void b(com.google.android.exoplayer2.source.t tVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!a(tVar.KQ(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!af(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str == null || v.h(format.sampleMimeType, str)) {
            if (format.width == -1 || format.width <= i3) {
                if (format.height == -1 || format.height <= i4) {
                    return format.bitrate == -1 || format.bitrate <= i5;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static f a(u uVar, int[][] iArr, C0672c c0672c) {
        int i;
        com.google.android.exoplayer2.source.t tVar;
        int dT;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < uVar.length; i6++) {
            com.google.android.exoplayer2.source.t KR = uVar.KR(i6);
            List<Integer> a2 = a(KR, c0672c.mCU, c0672c.mCV, c0672c.mCW);
            int[] iArr2 = iArr[i6];
            int i7 = 0;
            while (i7 < KR.length) {
                if (af(iArr2[i7], c0672c.mDa)) {
                    Format KQ = KR.KQ(i7);
                    boolean z = a2.contains(Integer.valueOf(i7)) && (KQ.width == -1 || KQ.width <= c0672c.mCQ) && ((KQ.height == -1 || KQ.height <= c0672c.mCR) && (KQ.bitrate == -1 || KQ.bitrate <= c0672c.mCS));
                    if (z || c0672c.mCT) {
                        int i8 = z ? 2 : 1;
                        boolean af = af(iArr2[i7], false);
                        if (af) {
                            i8 += 1000;
                        }
                        boolean z2 = i8 > i5;
                        if (i8 == i5) {
                            if (c0672c.mCX) {
                                z2 = dT(KQ.bitrate, i4) < 0;
                            } else {
                                int dty = KQ.dty();
                                if (dty != i3) {
                                    dT = dT(dty, i3);
                                } else {
                                    dT = dT(KQ.bitrate, i4);
                                }
                                if (af && z) {
                                    z2 = dT > 0;
                                } else {
                                    z2 = dT < 0;
                                }
                            }
                        }
                        if (z2) {
                            i4 = KQ.bitrate;
                            i3 = KQ.dty();
                            i5 = i8;
                            tVar = KR;
                            i = i7;
                        }
                    } else {
                        i = i2;
                        tVar = tVar2;
                    }
                    i7++;
                    tVar2 = tVar;
                    i2 = i;
                }
                i = i2;
                tVar = tVar2;
                i7++;
                tVar2 = tVar;
                i2 = i;
            }
        }
        if (tVar2 == null) {
            return null;
        }
        return new d(tVar2, i2);
    }

    private static int dT(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    protected f a(u uVar, int[][] iArr, C0672c c0672c, f.a aVar) throws ExoPlaybackException {
        int i;
        int i2;
        int i3 = -1;
        int i4 = -1;
        b bVar = null;
        for (int i5 = 0; i5 < uVar.length; i5++) {
            com.google.android.exoplayer2.source.t KR = uVar.KR(i5);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < KR.length) {
                if (af(iArr2[i6], c0672c.mDa)) {
                    b bVar2 = new b(KR.KQ(i6), c0672c, iArr2[i6]);
                    if (bVar == null || bVar2.compareTo(bVar) > 0) {
                        bVar = bVar2;
                        i2 = i6;
                        i = i5;
                        i6++;
                        i3 = i2;
                        i4 = i;
                    }
                }
                i = i4;
                i2 = i3;
                i6++;
                i3 = i2;
                i4 = i;
            }
        }
        if (i4 == -1) {
            return null;
        }
        com.google.android.exoplayer2.source.t KR2 = uVar.KR(i4);
        if (!c0672c.mCX && aVar != null) {
            int[] a2 = a(KR2, iArr[i4], c0672c.mCY);
            if (a2.length > 0) {
                return aVar.b(KR2, a2);
            }
        }
        return new d(KR2, i3);
    }

    private static int[] a(com.google.android.exoplayer2.source.t tVar, int[] iArr, boolean z) {
        int i;
        int a2;
        HashSet hashSet = new HashSet();
        int i2 = 0;
        a aVar = null;
        int i3 = 0;
        while (i2 < tVar.length) {
            Format KQ = tVar.KQ(i2);
            a aVar2 = new a(KQ.channelCount, KQ.sampleRate, z ? null : KQ.sampleMimeType);
            if (!hashSet.add(aVar2) || (a2 = a(tVar, iArr, aVar2)) <= i3) {
                aVar2 = aVar;
                i = i3;
            } else {
                i = a2;
            }
            i2++;
            i3 = i;
            aVar = aVar2;
        }
        if (i3 > 1) {
            int[] iArr2 = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < tVar.length; i5++) {
                if (a(tVar.KQ(i5), iArr[i5], aVar)) {
                    iArr2[i4] = i5;
                    i4++;
                }
            }
            return iArr2;
        }
        return mCH;
    }

    private static int a(com.google.android.exoplayer2.source.t tVar, int[] iArr, a aVar) {
        int i = 0;
        for (int i2 = 0; i2 < tVar.length; i2++) {
            if (a(tVar.KQ(i2), iArr[i2], aVar)) {
                i++;
            }
        }
        return i;
    }

    private static boolean a(Format format, int i, a aVar) {
        if (af(i, false) && format.channelCount == aVar.channelCount && format.sampleRate == aVar.sampleRate) {
            return aVar.mimeType == null || TextUtils.equals(aVar.mimeType, format.sampleMimeType);
        }
        return false;
    }

    protected f b(u uVar, int[][] iArr, C0672c c0672c) throws ExoPlaybackException {
        int i;
        com.google.android.exoplayer2.source.t tVar;
        int i2;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < uVar.length; i5++) {
            com.google.android.exoplayer2.source.t KR = uVar.KR(i5);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < KR.length) {
                if (af(iArr2[i6], c0672c.mDa)) {
                    Format KQ = KR.KQ(i6);
                    boolean z = (KQ.selectionFlags & 1) != 0;
                    boolean z2 = (KQ.selectionFlags & 2) != 0;
                    if (a(KQ, c0672c.mCP)) {
                        if (z) {
                            i2 = 6;
                        } else if (!z2) {
                            i2 = 5;
                        } else {
                            i2 = 4;
                        }
                    } else if (z) {
                        i2 = 3;
                    } else if (z2) {
                        if (a(KQ, c0672c.mCO)) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    if (af(iArr2[i6], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i4) {
                        i4 = i2;
                        tVar = KR;
                        i = i6;
                        i6++;
                        tVar2 = tVar;
                        i3 = i;
                    }
                }
                i = i3;
                tVar = tVar2;
                i6++;
                tVar2 = tVar;
                i3 = i;
            }
        }
        if (tVar2 == null) {
            return null;
        }
        return new d(tVar2, i3);
    }

    protected f a(int i, u uVar, int[][] iArr, C0672c c0672c) throws ExoPlaybackException {
        int i2;
        int i3;
        com.google.android.exoplayer2.source.t tVar;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= uVar.length) {
                break;
            }
            com.google.android.exoplayer2.source.t KR = uVar.KR(i7);
            int[] iArr2 = iArr[i7];
            int i8 = 0;
            while (i8 < KR.length) {
                if (af(iArr2[i8], c0672c.mDa)) {
                    i2 = (KR.KQ(i8).selectionFlags & 1) != 0 ? 2 : 1;
                    if (af(iArr2[i8], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i5) {
                        i3 = i8;
                        tVar = KR;
                        i8++;
                        tVar2 = tVar;
                        i4 = i3;
                        i5 = i2;
                    }
                }
                i2 = i5;
                i3 = i4;
                tVar = tVar2;
                i8++;
                tVar2 = tVar;
                i4 = i3;
                i5 = i2;
            }
            i6 = i7 + 1;
        }
        if (tVar2 == null) {
            return null;
        }
        return new d(tVar2, i4);
    }

    protected static boolean af(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    protected static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, v.Qz(format.language));
    }

    private static List<Integer> a(com.google.android.exoplayer2.source.t tVar, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        ArrayList arrayList = new ArrayList(tVar.length);
        for (int i5 = 0; i5 < tVar.length; i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i6 = Integer.MAX_VALUE;
        while (i4 < tVar.length) {
            Format KQ = tVar.KQ(i4);
            if (KQ.width > 0 && KQ.height > 0) {
                Point a2 = a(z, i, i2, KQ.width, KQ.height);
                i3 = KQ.width * KQ.height;
                if (KQ.width >= ((int) (a2.x * 0.98f)) && KQ.height >= ((int) (a2.y * 0.98f)) && i3 < i6) {
                    i4++;
                    i6 = i3;
                }
            }
            i3 = i6;
            i4++;
            i6 = i3;
        }
        if (i6 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int dty = tVar.KQ(((Integer) arrayList.get(size)).intValue()).dty();
                if (dty == -1 || dty > i6) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    private static Point a(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) != (i > i2)) {
                i = i2;
                i2 = i;
            }
        }
        if (i3 * i2 >= i4 * i) {
            return new Point(i, v.dZ(i * i4, i3));
        }
        return new Point(v.dZ(i2 * i3, i4), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements Comparable<b> {
        private final int bitrate;
        private final int channelCount;
        private final C0672c mCK;
        private final int mCL;
        private final int mCM;
        private final int mCN;
        private final int sampleRate;

        public b(Format format, C0672c c0672c, int i) {
            this.mCK = c0672c;
            this.mCL = c.af(i, false) ? 1 : 0;
            this.mCM = c.a(format, c0672c.mCO) ? 1 : 0;
            this.mCN = (format.selectionFlags & 1) == 0 ? 0 : 1;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            if (this.mCL != bVar.mCL) {
                return c.dU(this.mCL, bVar.mCL);
            }
            if (this.mCM != bVar.mCM) {
                return c.dU(this.mCM, bVar.mCM);
            }
            if (this.mCN != bVar.mCN) {
                return c.dU(this.mCN, bVar.mCN);
            }
            if (this.mCK.mCX) {
                return c.dU(bVar.bitrate, this.bitrate);
            }
            int i = this.mCL != 1 ? -1 : 1;
            if (this.channelCount != bVar.channelCount) {
                return i * c.dU(this.channelCount, bVar.channelCount);
            }
            return this.sampleRate != bVar.sampleRate ? i * c.dU(this.sampleRate, bVar.sampleRate) : i * c.dU(this.bitrate, bVar.bitrate);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.mCL == bVar.mCL && this.mCM == bVar.mCM && this.mCN == bVar.mCN && this.channelCount == bVar.channelCount && this.sampleRate == bVar.sampleRate && this.bitrate == bVar.bitrate;
        }

        public int hashCode() {
            return (((((((((this.mCL * 31) + this.mCM) * 31) + this.mCN) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dU(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public a(int i, int i2, String str) {
            this.channelCount = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.channelCount == aVar.channelCount && this.sampleRate == aVar.sampleRate && TextUtils.equals(this.mimeType, aVar.mimeType);
        }

        public int hashCode() {
            return (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.channelCount * 31) + this.sampleRate) * 31);
        }
    }
}
