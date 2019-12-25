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
/* loaded from: classes4.dex */
public class c extends e {
    private static final int[] mye = new int[0];
    private final f.a myf;
    private final AtomicReference<C0658c> myg;

    /* renamed from: com.google.android.exoplayer2.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0658c {
        public final String myl;
        public final String mym;
        public final int myn;
        public final int myo;
        public final int myp;
        public final boolean myq;
        public final int myr;
        public final int mys;
        public final boolean myt;
        public final boolean myu;
        public final boolean myv;
        public final boolean myw;
        public final boolean myx;

        public C0658c() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public C0658c(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4, boolean z5, int i4, int i5, boolean z6) {
            this.myl = str;
            this.mym = str2;
            this.myu = z;
            this.myv = z2;
            this.myw = z3;
            this.myn = i;
            this.myo = i2;
            this.myp = i3;
            this.myq = z4;
            this.myx = z5;
            this.myr = i4;
            this.mys = i5;
            this.myt = z6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0658c c0658c = (C0658c) obj;
            return this.myu == c0658c.myu && this.myv == c0658c.myv && this.myw == c0658c.myw && this.myn == c0658c.myn && this.myo == c0658c.myo && this.myq == c0658c.myq && this.myx == c0658c.myx && this.myt == c0658c.myt && this.myr == c0658c.myr && this.mys == c0658c.mys && this.myp == c0658c.myp && TextUtils.equals(this.myl, c0658c.myl) && TextUtils.equals(this.mym, c0658c.mym);
        }

        public int hashCode() {
            return (((((((this.myx ? 1 : 0) + (((this.myq ? 1 : 0) + (((((((((this.myw ? 1 : 0) + (((this.myv ? 1 : 0) + (((this.myu ? 1 : 0) + (((this.myl.hashCode() * 31) + this.mym.hashCode()) * 31)) * 31)) * 31)) * 31) + this.myn) * 31) + this.myo) * 31) + this.myp) * 31)) * 31)) * 31) + (this.myt ? 1 : 0)) * 31) + this.myr) * 31) + this.mys;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.myf = aVar;
        this.myg = new AtomicReference<>(new C0658c());
    }

    @Override // com.google.android.exoplayer2.b.e
    protected f[] a(t[] tVarArr, u[] uVarArr, int[][][] iArr) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        boolean z3;
        int length = tVarArr.length;
        f[] fVarArr = new f[length];
        C0658c c0658c = this.myg.get();
        boolean z4 = false;
        int i = 0;
        boolean z5 = false;
        while (i < length) {
            if (2 == tVarArr[i].getTrackType()) {
                if (!z5) {
                    fVarArr[i] = a(tVarArr[i], uVarArr[i], iArr[i], c0658c, this.myf);
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
                        fVarArr[i2] = a(uVarArr[i2], iArr[i2], c0658c, z4 ? null : this.myf);
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
                        fVarArr[i2] = b(uVarArr[i2], iArr[i2], c0658c);
                        z = fVarArr[i2] != null;
                        z2 = z6;
                        continue;
                        i2++;
                        z6 = z2;
                        z7 = z;
                    }
                    break;
                default:
                    fVarArr[i2] = a(tVarArr[i2].getTrackType(), uVarArr[i2], iArr[i2], c0658c);
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

    protected f a(t tVar, u uVar, int[][] iArr, C0658c c0658c, f.a aVar) throws ExoPlaybackException {
        f fVar = null;
        if (!c0658c.myu && aVar != null) {
            fVar = b(tVar, uVar, iArr, c0658c, aVar);
        }
        if (fVar == null) {
            return a(uVar, iArr, c0658c);
        }
        return fVar;
    }

    private static f b(t tVar, u uVar, int[][] iArr, C0658c c0658c, f.a aVar) throws ExoPlaybackException {
        int i = 0;
        int i2 = c0658c.myw ? 24 : 16;
        boolean z = c0658c.myv && (tVar.dql() & i2) != 0;
        while (true) {
            int i3 = i;
            if (i3 < uVar.length) {
                com.google.android.exoplayer2.source.t KD = uVar.KD(i3);
                int[] a2 = a(KD, iArr[i3], z, i2, c0658c.myn, c0658c.myo, c0658c.myp, c0658c.myr, c0658c.mys, c0658c.myt);
                if (a2.length <= 0) {
                    i = i3 + 1;
                } else {
                    return aVar.b(KD, a2);
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
            return mye;
        }
        List<Integer> a2 = a(tVar, i5, i6, z2);
        if (a2.size() < 2) {
            return mye;
        }
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i8 = 0;
            int i9 = 0;
            while (i9 < a2.size()) {
                String str3 = tVar.KC(a2.get(i9).intValue()).sampleMimeType;
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
        return a2.size() < 2 ? mye : v.fq(a2);
    }

    private static int a(com.google.android.exoplayer2.source.t tVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 < list.size()) {
                int intValue = list.get(i7).intValue();
                i5 = a(tVar.KC(intValue), str, iArr[intValue], i, i2, i3, i4) ? i8 + 1 : i8;
                i6 = i7 + 1;
            } else {
                return i8;
            }
        }
    }

    private static void b(com.google.android.exoplayer2.source.t tVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!a(tVar.KC(intValue), str, iArr[intValue], i, i2, i3, i4)) {
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

    private static f a(u uVar, int[][] iArr, C0658c c0658c) {
        int i;
        com.google.android.exoplayer2.source.t tVar;
        int dS;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < uVar.length; i6++) {
            com.google.android.exoplayer2.source.t KD = uVar.KD(i6);
            List<Integer> a2 = a(KD, c0658c.myr, c0658c.mys, c0658c.myt);
            int[] iArr2 = iArr[i6];
            int i7 = 0;
            while (i7 < KD.length) {
                if (ag(iArr2[i7], c0658c.myx)) {
                    Format KC = KD.KC(i7);
                    boolean z = a2.contains(Integer.valueOf(i7)) && (KC.width == -1 || KC.width <= c0658c.myn) && ((KC.height == -1 || KC.height <= c0658c.myo) && (KC.bitrate == -1 || KC.bitrate <= c0658c.myp));
                    if (z || c0658c.myq) {
                        int i8 = z ? 2 : 1;
                        boolean ag = ag(iArr2[i7], false);
                        if (ag) {
                            i8 += 1000;
                        }
                        boolean z2 = i8 > i5;
                        if (i8 == i5) {
                            if (c0658c.myu) {
                                z2 = dS(KC.bitrate, i4) < 0;
                            } else {
                                int dqW = KC.dqW();
                                if (dqW != i3) {
                                    dS = dS(dqW, i3);
                                } else {
                                    dS = dS(KC.bitrate, i4);
                                }
                                if (ag && z) {
                                    z2 = dS > 0;
                                } else {
                                    z2 = dS < 0;
                                }
                            }
                        }
                        if (z2) {
                            i4 = KC.bitrate;
                            i3 = KC.dqW();
                            i5 = i8;
                            tVar = KD;
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

    private static int dS(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    protected f a(u uVar, int[][] iArr, C0658c c0658c, f.a aVar) throws ExoPlaybackException {
        int i;
        int i2;
        int i3 = -1;
        int i4 = -1;
        b bVar = null;
        for (int i5 = 0; i5 < uVar.length; i5++) {
            com.google.android.exoplayer2.source.t KD = uVar.KD(i5);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < KD.length) {
                if (ag(iArr2[i6], c0658c.myx)) {
                    b bVar2 = new b(KD.KC(i6), c0658c, iArr2[i6]);
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
        com.google.android.exoplayer2.source.t KD2 = uVar.KD(i4);
        if (!c0658c.myu && aVar != null) {
            int[] a2 = a(KD2, iArr[i4], c0658c.myv);
            if (a2.length > 0) {
                return aVar.b(KD2, a2);
            }
        }
        return new d(KD2, i3);
    }

    private static int[] a(com.google.android.exoplayer2.source.t tVar, int[] iArr, boolean z) {
        int i;
        int a2;
        HashSet hashSet = new HashSet();
        int i2 = 0;
        a aVar = null;
        int i3 = 0;
        while (i2 < tVar.length) {
            Format KC = tVar.KC(i2);
            a aVar2 = new a(KC.channelCount, KC.sampleRate, z ? null : KC.sampleMimeType);
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
                if (a(tVar.KC(i5), iArr[i5], aVar)) {
                    iArr2[i4] = i5;
                    i4++;
                }
            }
            return iArr2;
        }
        return mye;
    }

    private static int a(com.google.android.exoplayer2.source.t tVar, int[] iArr, a aVar) {
        int i = 0;
        for (int i2 = 0; i2 < tVar.length; i2++) {
            if (a(tVar.KC(i2), iArr[i2], aVar)) {
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

    protected f b(u uVar, int[][] iArr, C0658c c0658c) throws ExoPlaybackException {
        int i;
        com.google.android.exoplayer2.source.t tVar;
        int i2;
        com.google.android.exoplayer2.source.t tVar2 = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < uVar.length; i5++) {
            com.google.android.exoplayer2.source.t KD = uVar.KD(i5);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < KD.length) {
                if (ag(iArr2[i6], c0658c.myx)) {
                    Format KC = KD.KC(i6);
                    boolean z = (KC.selectionFlags & 1) != 0;
                    boolean z2 = (KC.selectionFlags & 2) != 0;
                    if (a(KC, c0658c.mym)) {
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
                        if (a(KC, c0658c.myl)) {
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
                        tVar = KD;
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

    protected f a(int i, u uVar, int[][] iArr, C0658c c0658c) throws ExoPlaybackException {
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
            com.google.android.exoplayer2.source.t KD = uVar.KD(i7);
            int[] iArr2 = iArr[i7];
            int i8 = 0;
            while (i8 < KD.length) {
                if (ag(iArr2[i8], c0658c.myx)) {
                    i2 = (KD.KC(i8).selectionFlags & 1) != 0 ? 2 : 1;
                    if (ag(iArr2[i8], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i5) {
                        i3 = i8;
                        tVar = KD;
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
        return str != null && TextUtils.equals(str, v.Qb(format.language));
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
            Format KC = tVar.KC(i4);
            if (KC.width > 0 && KC.height > 0) {
                Point a2 = a(z, i, i2, KC.width, KC.height);
                i3 = KC.width * KC.height;
                if (KC.width >= ((int) (a2.x * 0.98f)) && KC.height >= ((int) (a2.y * 0.98f)) && i3 < i6) {
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
                int dqW = tVar.KC(((Integer) arrayList.get(size)).intValue()).dqW();
                if (dqW == -1 || dqW > i6) {
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
            return new Point(i, v.dY(i * i4, i3));
        }
        return new Point(v.dY(i2 * i3, i4), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements Comparable<b> {
        private final int bitrate;
        private final int channelCount;
        private final C0658c myh;
        private final int myi;
        private final int myj;
        private final int myk;
        private final int sampleRate;

        public b(Format format, C0658c c0658c, int i) {
            this.myh = c0658c;
            this.myi = c.ag(i, false) ? 1 : 0;
            this.myj = c.a(format, c0658c.myl) ? 1 : 0;
            this.myk = (format.selectionFlags & 1) == 0 ? 0 : 1;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            if (this.myi != bVar.myi) {
                return c.dT(this.myi, bVar.myi);
            }
            if (this.myj != bVar.myj) {
                return c.dT(this.myj, bVar.myj);
            }
            if (this.myk != bVar.myk) {
                return c.dT(this.myk, bVar.myk);
            }
            if (this.myh.myu) {
                return c.dT(bVar.bitrate, this.bitrate);
            }
            int i = this.myi != 1 ? -1 : 1;
            if (this.channelCount != bVar.channelCount) {
                return i * c.dT(this.channelCount, bVar.channelCount);
            }
            return this.sampleRate != bVar.sampleRate ? i * c.dT(this.sampleRate, bVar.sampleRate) : i * c.dT(this.bitrate, bVar.bitrate);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.myi == bVar.myi && this.myj == bVar.myj && this.myk == bVar.myk && this.channelCount == bVar.channelCount && this.sampleRate == bVar.sampleRate && this.bitrate == bVar.bitrate;
        }

        public int hashCode() {
            return (((((((((this.myi * 31) + this.myj) * 31) + this.myk) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dT(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
