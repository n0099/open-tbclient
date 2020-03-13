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
    private static final int[] mCS = new int[0];
    private final f.a mCT;
    private final AtomicReference<C0672c> mCU;

    /* renamed from: com.google.android.exoplayer2.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0672c {
        public final String mCZ;
        public final String mDa;
        public final int mDc;
        public final int mDd;
        public final int mDe;
        public final boolean mDf;
        public final int mDg;
        public final int mDh;
        public final boolean mDi;
        public final boolean mDj;
        public final boolean mDk;
        public final boolean mDl;
        public final boolean mDm;

        public C0672c() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public C0672c(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4, boolean z5, int i4, int i5, boolean z6) {
            this.mCZ = str;
            this.mDa = str2;
            this.mDj = z;
            this.mDk = z2;
            this.mDl = z3;
            this.mDc = i;
            this.mDd = i2;
            this.mDe = i3;
            this.mDf = z4;
            this.mDm = z5;
            this.mDg = i4;
            this.mDh = i5;
            this.mDi = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0672c c0672c = (C0672c) obj;
            return this.mDj == c0672c.mDj && this.mDk == c0672c.mDk && this.mDl == c0672c.mDl && this.mDc == c0672c.mDc && this.mDd == c0672c.mDd && this.mDf == c0672c.mDf && this.mDm == c0672c.mDm && this.mDi == c0672c.mDi && this.mDg == c0672c.mDg && this.mDh == c0672c.mDh && this.mDe == c0672c.mDe && TextUtils.equals(this.mCZ, c0672c.mCZ) && TextUtils.equals(this.mDa, c0672c.mDa);
        }

        public int hashCode() {
            return (((((((this.mDm ? 1 : 0) + (((this.mDf ? 1 : 0) + (((((((((this.mDl ? 1 : 0) + (((this.mDk ? 1 : 0) + (((this.mDj ? 1 : 0) + (((this.mCZ.hashCode() * 31) + this.mDa.hashCode()) * 31)) * 31)) * 31)) * 31) + this.mDc) * 31) + this.mDd) * 31) + this.mDe) * 31)) * 31)) * 31) + (this.mDi ? 1 : 0)) * 31) + this.mDg) * 31) + this.mDh;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.mCT = aVar;
        this.mCU = new AtomicReference<>(new C0672c());
    }

    @Override // com.google.android.exoplayer2.b.e
    protected f[] a(t[] tVarArr, u[] uVarArr, int[][][] iArr) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        boolean z3;
        int length = tVarArr.length;
        f[] fVarArr = new f[length];
        C0672c c0672c = this.mCU.get();
        boolean z4 = false;
        int i = 0;
        boolean z5 = false;
        while (i < length) {
            if (2 == tVarArr[i].getTrackType()) {
                if (!z5) {
                    fVarArr[i] = a(tVarArr[i], uVarArr[i], iArr[i], c0672c, this.mCT);
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
                        fVarArr[i2] = a(uVarArr[i2], iArr[i2], c0672c, z4 ? null : this.mCT);
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
        if (!c0672c.mDj && aVar != null) {
            fVar = b(tVar, uVar, iArr, c0672c, aVar);
        }
        if (fVar == null) {
            return a(uVar, iArr, c0672c);
        }
        return fVar;
    }

    private static f b(t tVar, u uVar, int[][] iArr, C0672c c0672c, f.a aVar) throws ExoPlaybackException {
        int i = 0;
        int i2 = c0672c.mDl ? 24 : 16;
        boolean z = c0672c.mDk && (tVar.dsO() & i2) != 0;
        while (true) {
            int i3 = i;
            if (i3 < uVar.length) {
                com.google.android.exoplayer2.source.t KR = uVar.KR(i3);
                int[] a2 = a(KR, iArr[i3], z, i2, c0672c.mDc, c0672c.mDd, c0672c.mDe, c0672c.mDg, c0672c.mDh, c0672c.mDi);
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
            return mCS;
        }
        List<Integer> a2 = a(tVar, i5, i6, z2);
        if (a2.size() < 2) {
            return mCS;
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
        return a2.size() < 2 ? mCS : v.fl(a2);
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
            List<Integer> a2 = a(KR, c0672c.mDg, c0672c.mDh, c0672c.mDi);
            int[] iArr2 = iArr[i6];
            int i7 = 0;
            while (i7 < KR.length) {
                if (af(iArr2[i7], c0672c.mDm)) {
                    Format KQ = KR.KQ(i7);
                    boolean z = a2.contains(Integer.valueOf(i7)) && (KQ.width == -1 || KQ.width <= c0672c.mDc) && ((KQ.height == -1 || KQ.height <= c0672c.mDd) && (KQ.bitrate == -1 || KQ.bitrate <= c0672c.mDe));
                    if (z || c0672c.mDf) {
                        int i8 = z ? 2 : 1;
                        boolean af = af(iArr2[i7], false);
                        if (af) {
                            i8 += 1000;
                        }
                        boolean z2 = i8 > i5;
                        if (i8 == i5) {
                            if (c0672c.mDj) {
                                z2 = dT(KQ.bitrate, i4) < 0;
                            } else {
                                int dtz = KQ.dtz();
                                if (dtz != i3) {
                                    dT = dT(dtz, i3);
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
                            i3 = KQ.dtz();
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
                if (af(iArr2[i6], c0672c.mDm)) {
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
        if (!c0672c.mDj && aVar != null) {
            int[] a2 = a(KR2, iArr[i4], c0672c.mDk);
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
        return mCS;
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
                if (af(iArr2[i6], c0672c.mDm)) {
                    Format KQ = KR.KQ(i6);
                    boolean z = (KQ.selectionFlags & 1) != 0;
                    boolean z2 = (KQ.selectionFlags & 2) != 0;
                    if (a(KQ, c0672c.mDa)) {
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
                        if (a(KQ, c0672c.mCZ)) {
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
                if (af(iArr2[i8], c0672c.mDm)) {
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
        return str != null && TextUtils.equals(str, v.QA(format.language));
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
                int dtz = tVar.KQ(((Integer) arrayList.get(size)).intValue()).dtz();
                if (dtz == -1 || dtz > i6) {
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
        private final C0672c mCV;
        private final int mCW;
        private final int mCX;
        private final int mCY;
        private final int sampleRate;

        public b(Format format, C0672c c0672c, int i) {
            this.mCV = c0672c;
            this.mCW = c.af(i, false) ? 1 : 0;
            this.mCX = c.a(format, c0672c.mCZ) ? 1 : 0;
            this.mCY = (format.selectionFlags & 1) == 0 ? 0 : 1;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            if (this.mCW != bVar.mCW) {
                return c.dU(this.mCW, bVar.mCW);
            }
            if (this.mCX != bVar.mCX) {
                return c.dU(this.mCX, bVar.mCX);
            }
            if (this.mCY != bVar.mCY) {
                return c.dU(this.mCY, bVar.mCY);
            }
            if (this.mCV.mDj) {
                return c.dU(bVar.bitrate, this.bitrate);
            }
            int i = this.mCW != 1 ? -1 : 1;
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
            return this.mCW == bVar.mCW && this.mCX == bVar.mCX && this.mCY == bVar.mCY && this.channelCount == bVar.channelCount && this.sampleRate == bVar.sampleRate && this.bitrate == bVar.bitrate;
        }

        public int hashCode() {
            return (((((((((this.mCW * 31) + this.mCX) * 31) + this.mCY) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
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
