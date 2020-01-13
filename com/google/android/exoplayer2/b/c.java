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
/* loaded from: classes5.dex */
public class c extends e {
    private static final int[] mBT = new int[0];
    private final f.a mBU;
    private final AtomicReference<C0664c> mBV;

    /* renamed from: com.google.android.exoplayer2.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0664c {
        public final String mCa;
        public final String mCb;
        public final int mCc;
        public final int mCd;
        public final int mCe;
        public final boolean mCf;
        public final int mCg;
        public final int mCh;
        public final boolean mCi;
        public final boolean mCj;
        public final boolean mCk;
        public final boolean mCl;
        public final boolean mCm;

        public C0664c() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public C0664c(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4, boolean z5, int i4, int i5, boolean z6) {
            this.mCa = str;
            this.mCb = str2;
            this.mCj = z;
            this.mCk = z2;
            this.mCl = z3;
            this.mCc = i;
            this.mCd = i2;
            this.mCe = i3;
            this.mCf = z4;
            this.mCm = z5;
            this.mCg = i4;
            this.mCh = i5;
            this.mCi = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0664c c0664c = (C0664c) obj;
            return this.mCj == c0664c.mCj && this.mCk == c0664c.mCk && this.mCl == c0664c.mCl && this.mCc == c0664c.mCc && this.mCd == c0664c.mCd && this.mCf == c0664c.mCf && this.mCm == c0664c.mCm && this.mCi == c0664c.mCi && this.mCg == c0664c.mCg && this.mCh == c0664c.mCh && this.mCe == c0664c.mCe && TextUtils.equals(this.mCa, c0664c.mCa) && TextUtils.equals(this.mCb, c0664c.mCb);
        }

        public int hashCode() {
            return (((((((this.mCm ? 1 : 0) + (((this.mCf ? 1 : 0) + (((((((((this.mCl ? 1 : 0) + (((this.mCk ? 1 : 0) + (((this.mCj ? 1 : 0) + (((this.mCa.hashCode() * 31) + this.mCb.hashCode()) * 31)) * 31)) * 31)) * 31) + this.mCc) * 31) + this.mCd) * 31) + this.mCe) * 31)) * 31)) * 31) + (this.mCi ? 1 : 0)) * 31) + this.mCg) * 31) + this.mCh;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.mBU = aVar;
        this.mBV = new AtomicReference<>(new C0664c());
    }

    @Override // com.google.android.exoplayer2.b.e
    protected f[] a(t[] tVarArr, u[] uVarArr, int[][][] iArr) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        boolean z3;
        int length = tVarArr.length;
        f[] fVarArr = new f[length];
        C0664c c0664c = this.mBV.get();
        boolean z4 = false;
        int i = 0;
        boolean z5 = false;
        while (i < length) {
            if (2 == tVarArr[i].getTrackType()) {
                if (!z5) {
                    fVarArr[i] = a(tVarArr[i], uVarArr[i], iArr[i], c0664c, this.mBU);
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
                        fVarArr[i2] = a(uVarArr[i2], iArr[i2], c0664c, z4 ? null : this.mBU);
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
                        fVarArr[i2] = b(uVarArr[i2], iArr[i2], c0664c);
                        z = fVarArr[i2] != null;
                        z2 = z6;
                        continue;
                        i2++;
                        z6 = z2;
                        z7 = z;
                    }
                    break;
                default:
                    fVarArr[i2] = a(tVarArr[i2].getTrackType(), uVarArr[i2], iArr[i2], c0664c);
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

    protected f a(t tVar, u uVar, int[][] iArr, C0664c c0664c, f.a aVar) throws ExoPlaybackException {
        f fVar = null;
        if (!c0664c.mCj && aVar != null) {
            fVar = b(tVar, uVar, iArr, c0664c, aVar);
        }
        if (fVar == null) {
            return a(uVar, iArr, c0664c);
        }
        return fVar;
    }

    private static f b(t tVar, u uVar, int[][] iArr, C0664c c0664c, f.a aVar) throws ExoPlaybackException {
        int i = 0;
        int i2 = c0664c.mCl ? 24 : 16;
        boolean z = c0664c.mCk && (tVar.drx() & i2) != 0;
        while (true) {
            int i3 = i;
            if (i3 < uVar.length) {
                com.google.android.exoplayer2.source.t KM = uVar.KM(i3);
                int[] a2 = a(KM, iArr[i3], z, i2, c0664c.mCc, c0664c.mCd, c0664c.mCe, c0664c.mCg, c0664c.mCh, c0664c.mCi);
                if (a2.length <= 0) {
                    i = i3 + 1;
                } else {
                    return aVar.b(KM, a2);
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
            return mBT;
        }
        List<Integer> a2 = a(tVar, i5, i6, z2);
        if (a2.size() < 2) {
            return mBT;
        }
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i8 = 0;
            int i9 = 0;
            while (i9 < a2.size()) {
                String str3 = tVar.KL(a2.get(i9).intValue()).sampleMimeType;
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
        return a2.size() < 2 ? mBT : v.fq(a2);
    }

    private static int a(com.google.android.exoplayer2.source.t tVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 < list.size()) {
                int intValue = list.get(i7).intValue();
                i5 = a(tVar.KL(intValue), str, iArr[intValue], i, i2, i3, i4) ? i8 + 1 : i8;
                i6 = i7 + 1;
            } else {
                return i8;
            }
        }
    }

    private static void b(com.google.android.exoplayer2.source.t tVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!a(tVar.KL(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!ag(i, false) || (i & i2) == 0) {
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

    private static f a(u uVar, int[][] iArr, C0664c c0664c) {
        int i;
        com.google.android.exoplayer2.source.t tVar;
        int dQ;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < uVar.length; i6++) {
            com.google.android.exoplayer2.source.t KM = uVar.KM(i6);
            List<Integer> a2 = a(KM, c0664c.mCg, c0664c.mCh, c0664c.mCi);
            int[] iArr2 = iArr[i6];
            int i7 = 0;
            while (i7 < KM.length) {
                if (ag(iArr2[i7], c0664c.mCm)) {
                    Format KL = KM.KL(i7);
                    boolean z = a2.contains(Integer.valueOf(i7)) && (KL.width == -1 || KL.width <= c0664c.mCc) && ((KL.height == -1 || KL.height <= c0664c.mCd) && (KL.bitrate == -1 || KL.bitrate <= c0664c.mCe));
                    if (z || c0664c.mCf) {
                        int i8 = z ? 2 : 1;
                        boolean ag = ag(iArr2[i7], false);
                        if (ag) {
                            i8 += 1000;
                        }
                        boolean z2 = i8 > i5;
                        if (i8 == i5) {
                            if (c0664c.mCj) {
                                z2 = dQ(KL.bitrate, i4) < 0;
                            } else {
                                int dsi = KL.dsi();
                                if (dsi != i3) {
                                    dQ = dQ(dsi, i3);
                                } else {
                                    dQ = dQ(KL.bitrate, i4);
                                }
                                if (ag && z) {
                                    z2 = dQ > 0;
                                } else {
                                    z2 = dQ < 0;
                                }
                            }
                        }
                        if (z2) {
                            i4 = KL.bitrate;
                            i3 = KL.dsi();
                            i5 = i8;
                            tVar = KM;
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

    private static int dQ(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    protected f a(u uVar, int[][] iArr, C0664c c0664c, f.a aVar) throws ExoPlaybackException {
        int i;
        int i2;
        int i3 = -1;
        int i4 = -1;
        b bVar = null;
        for (int i5 = 0; i5 < uVar.length; i5++) {
            com.google.android.exoplayer2.source.t KM = uVar.KM(i5);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < KM.length) {
                if (ag(iArr2[i6], c0664c.mCm)) {
                    b bVar2 = new b(KM.KL(i6), c0664c, iArr2[i6]);
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
        com.google.android.exoplayer2.source.t KM2 = uVar.KM(i4);
        if (!c0664c.mCj && aVar != null) {
            int[] a2 = a(KM2, iArr[i4], c0664c.mCk);
            if (a2.length > 0) {
                return aVar.b(KM2, a2);
            }
        }
        return new d(KM2, i3);
    }

    private static int[] a(com.google.android.exoplayer2.source.t tVar, int[] iArr, boolean z) {
        int i;
        int a2;
        HashSet hashSet = new HashSet();
        int i2 = 0;
        a aVar = null;
        int i3 = 0;
        while (i2 < tVar.length) {
            Format KL = tVar.KL(i2);
            a aVar2 = new a(KL.channelCount, KL.sampleRate, z ? null : KL.sampleMimeType);
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
                if (a(tVar.KL(i5), iArr[i5], aVar)) {
                    iArr2[i4] = i5;
                    i4++;
                }
            }
            return iArr2;
        }
        return mBT;
    }

    private static int a(com.google.android.exoplayer2.source.t tVar, int[] iArr, a aVar) {
        int i = 0;
        for (int i2 = 0; i2 < tVar.length; i2++) {
            if (a(tVar.KL(i2), iArr[i2], aVar)) {
                i++;
            }
        }
        return i;
    }

    private static boolean a(Format format, int i, a aVar) {
        if (ag(i, false) && format.channelCount == aVar.channelCount && format.sampleRate == aVar.sampleRate) {
            return aVar.mimeType == null || TextUtils.equals(aVar.mimeType, format.sampleMimeType);
        }
        return false;
    }

    protected f b(u uVar, int[][] iArr, C0664c c0664c) throws ExoPlaybackException {
        int i;
        com.google.android.exoplayer2.source.t tVar;
        int i2;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < uVar.length; i5++) {
            com.google.android.exoplayer2.source.t KM = uVar.KM(i5);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < KM.length) {
                if (ag(iArr2[i6], c0664c.mCm)) {
                    Format KL = KM.KL(i6);
                    boolean z = (KL.selectionFlags & 1) != 0;
                    boolean z2 = (KL.selectionFlags & 2) != 0;
                    if (a(KL, c0664c.mCb)) {
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
                        if (a(KL, c0664c.mCa)) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    if (ag(iArr2[i6], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i4) {
                        i4 = i2;
                        tVar = KM;
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

    protected f a(int i, u uVar, int[][] iArr, C0664c c0664c) throws ExoPlaybackException {
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
            com.google.android.exoplayer2.source.t KM = uVar.KM(i7);
            int[] iArr2 = iArr[i7];
            int i8 = 0;
            while (i8 < KM.length) {
                if (ag(iArr2[i8], c0664c.mCm)) {
                    i2 = (KM.KL(i8).selectionFlags & 1) != 0 ? 2 : 1;
                    if (ag(iArr2[i8], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i5) {
                        i3 = i8;
                        tVar = KM;
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

    protected static boolean ag(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    protected static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, v.Qm(format.language));
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
            Format KL = tVar.KL(i4);
            if (KL.width > 0 && KL.height > 0) {
                Point a2 = a(z, i, i2, KL.width, KL.height);
                i3 = KL.width * KL.height;
                if (KL.width >= ((int) (a2.x * 0.98f)) && KL.height >= ((int) (a2.y * 0.98f)) && i3 < i6) {
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
                int dsi = tVar.KL(((Integer) arrayList.get(size)).intValue()).dsi();
                if (dsi == -1 || dsi > i6) {
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
            return new Point(i, v.dW(i * i4, i3));
        }
        return new Point(v.dW(i2 * i3, i4), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        private final int bitrate;
        private final int channelCount;
        private final C0664c mBW;
        private final int mBX;
        private final int mBY;
        private final int mBZ;
        private final int sampleRate;

        public b(Format format, C0664c c0664c, int i) {
            this.mBW = c0664c;
            this.mBX = c.ag(i, false) ? 1 : 0;
            this.mBY = c.a(format, c0664c.mCa) ? 1 : 0;
            this.mBZ = (format.selectionFlags & 1) == 0 ? 0 : 1;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            if (this.mBX != bVar.mBX) {
                return c.dR(this.mBX, bVar.mBX);
            }
            if (this.mBY != bVar.mBY) {
                return c.dR(this.mBY, bVar.mBY);
            }
            if (this.mBZ != bVar.mBZ) {
                return c.dR(this.mBZ, bVar.mBZ);
            }
            if (this.mBW.mCj) {
                return c.dR(bVar.bitrate, this.bitrate);
            }
            int i = this.mBX != 1 ? -1 : 1;
            if (this.channelCount != bVar.channelCount) {
                return i * c.dR(this.channelCount, bVar.channelCount);
            }
            return this.sampleRate != bVar.sampleRate ? i * c.dR(this.sampleRate, bVar.sampleRate) : i * c.dR(this.bitrate, bVar.bitrate);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.mBX == bVar.mBX && this.mBY == bVar.mBY && this.mBZ == bVar.mBZ && this.channelCount == bVar.channelCount && this.sampleRate == bVar.sampleRate && this.bitrate == bVar.bitrate;
        }

        public int hashCode() {
            return (((((((((this.mBX * 31) + this.mBY) * 31) + this.mBZ) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dR(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
