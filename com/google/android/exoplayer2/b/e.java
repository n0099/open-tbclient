package com.google.android.exoplayer2.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.t;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class e extends h {
    private a mDp;
    private final SparseArray<Map<u, b>> mDn = new SparseArray<>();
    private final SparseBooleanArray mDo = new SparseBooleanArray();
    private int lZX = 0;

    protected abstract f[] a(t[] tVarArr, u[] uVarArr, int[][][] iArr) throws ExoPlaybackException;

    /* loaded from: classes6.dex */
    public static final class a {
        public final int length;
        private final int[] mDq;
        private final u[] mDr;
        private final int[] mDs;
        private final int[][][] mDt;
        private final u mDu;

        a(int[] iArr, u[] uVarArr, int[] iArr2, int[][][] iArr3, u uVar) {
            this.mDq = iArr;
            this.mDr = uVarArr;
            this.mDt = iArr3;
            this.mDs = iArr2;
            this.mDu = uVar;
            this.length = uVarArr.length;
        }

        public u LH(int i) {
            return this.mDr[i];
        }

        public int ai(int i, int i2, int i3) {
            return this.mDt[i][i2][i3] & 7;
        }

        public int s(int i, int i2, boolean z) {
            int i3 = 0;
            int i4 = this.mDr[i].KR(i2).length;
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int ai = ai(i, i2, i5);
                if (ai == 4 || (z && ai == 3)) {
                    iArr[i3] = i5;
                    i3++;
                }
            }
            return a(i, i2, Arrays.copyOf(iArr, i3));
        }

        public int a(int i, int i2, int[] iArr) {
            boolean z;
            String str = null;
            int i3 = 0;
            boolean z2 = false;
            int i4 = 16;
            int i5 = 0;
            while (i3 < iArr.length) {
                String str2 = this.mDr[i].KR(i2).KQ(iArr[i3]).sampleMimeType;
                int i6 = i5 + 1;
                if (i5 == 0) {
                    z = z2;
                } else {
                    String str3 = str;
                    z = (!v.h(str, str2)) | z2;
                    str2 = str3;
                }
                i4 = Math.min(i4, this.mDt[i][i2][i3] & 24);
                i3++;
                i5 = i6;
                z2 = z;
                str = str2;
            }
            return z2 ? Math.min(i4, this.mDs[i]) : i4;
        }

        public u dyB() {
            return this.mDu;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public final int[] mCQ;
        public final f.a mDv;
        public final int mDw;

        public f a(u uVar) {
            return this.mDv.b(uVar.KR(this.mDw), this.mCQ);
        }
    }

    public final a dyA() {
        return this.mDp;
    }

    public final boolean a(int i, u uVar) {
        Map<u, b> map = this.mDn.get(i);
        return map != null && map.containsKey(uVar);
    }

    @Override // com.google.android.exoplayer2.b.h
    public final i a(t[] tVarArr, u uVar) throws ExoPlaybackException {
        int[] iArr = new int[tVarArr.length + 1];
        com.google.android.exoplayer2.source.t[][] tVarArr2 = new com.google.android.exoplayer2.source.t[tVarArr.length + 1];
        int[][][] iArr2 = new int[tVarArr.length + 1][];
        for (int i = 0; i < tVarArr2.length; i++) {
            tVarArr2[i] = new com.google.android.exoplayer2.source.t[uVar.length];
            iArr2[i] = new int[uVar.length];
        }
        int[] a2 = a(tVarArr);
        for (int i2 = 0; i2 < uVar.length; i2++) {
            com.google.android.exoplayer2.source.t KR = uVar.KR(i2);
            int a3 = a(tVarArr, KR);
            int[] a4 = a3 == tVarArr.length ? new int[KR.length] : a(tVarArr[a3], KR);
            int i3 = iArr[a3];
            tVarArr2[a3][i3] = KR;
            iArr2[a3][i3] = a4;
            iArr[a3] = iArr[a3] + 1;
        }
        u[] uVarArr = new u[tVarArr.length];
        int[] iArr3 = new int[tVarArr.length];
        for (int i4 = 0; i4 < tVarArr.length; i4++) {
            int i5 = iArr[i4];
            uVarArr[i4] = new u((com.google.android.exoplayer2.source.t[]) Arrays.copyOf(tVarArr2[i4], i5));
            iArr2[i4] = (int[][]) Arrays.copyOf(iArr2[i4], i5);
            iArr3[i4] = tVarArr[i4].getTrackType();
        }
        u uVar2 = new u((com.google.android.exoplayer2.source.t[]) Arrays.copyOf(tVarArr2[tVarArr.length], iArr[tVarArr.length]));
        f[] a5 = a(tVarArr, uVarArr, iArr2);
        for (int i6 = 0; i6 < tVarArr.length; i6++) {
            if (this.mDo.get(i6)) {
                a5[i6] = null;
            } else {
                u uVar3 = uVarArr[i6];
                if (a(i6, uVar3)) {
                    b bVar = this.mDn.get(i6).get(uVar3);
                    a5[i6] = bVar == null ? null : bVar.a(uVar3);
                }
            }
        }
        boolean[] a6 = a(tVarArr, a5);
        a aVar = new a(iArr3, uVarArr, a2, iArr2, uVar2);
        com.google.android.exoplayer2.u[] uVarArr2 = new com.google.android.exoplayer2.u[tVarArr.length];
        for (int i7 = 0; i7 < tVarArr.length; i7++) {
            uVarArr2[i7] = a6[i7] ? com.google.android.exoplayer2.u.lZW : null;
        }
        a(tVarArr, uVarArr, iArr2, uVarArr2, a5, this.lZX);
        return new i(uVar, a6, new g(a5), aVar, uVarArr2);
    }

    private boolean[] a(t[] tVarArr, f[] fVarArr) {
        boolean[] zArr = new boolean[fVarArr.length];
        for (int i = 0; i < zArr.length; i++) {
            zArr[i] = !this.mDo.get(i) && (tVarArr[i].getTrackType() == 5 || fVarArr[i] != null);
        }
        return zArr;
    }

    @Override // com.google.android.exoplayer2.b.h
    public final void bA(Object obj) {
        this.mDp = (a) obj;
    }

    private static int a(t[] tVarArr, com.google.android.exoplayer2.source.t tVar) throws ExoPlaybackException {
        int i;
        int i2;
        int i3 = 0;
        int length = tVarArr.length;
        for (int i4 = 0; i4 < tVarArr.length; i4++) {
            t tVar2 = tVarArr[i4];
            int i5 = 0;
            while (i5 < tVar.length) {
                int e = tVar2.e(tVar.KQ(i5)) & 7;
                if (e <= i3) {
                    i = length;
                    i2 = i3;
                } else if (e == 4) {
                    return i4;
                } else {
                    i2 = e;
                    i = i4;
                }
                i5++;
                i3 = i2;
                length = i;
            }
        }
        return length;
    }

    private static int[] a(t tVar, com.google.android.exoplayer2.source.t tVar2) throws ExoPlaybackException {
        int[] iArr = new int[tVar2.length];
        for (int i = 0; i < tVar2.length; i++) {
            iArr[i] = tVar.e(tVar2.KQ(i));
        }
        return iArr;
    }

    private static int[] a(t[] tVarArr) throws ExoPlaybackException {
        int[] iArr = new int[tVarArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = tVarArr[i].dsO();
        }
        return iArr;
    }

    private static void a(t[] tVarArr, u[] uVarArr, int[][][] iArr, com.google.android.exoplayer2.u[] uVarArr2, f[] fVarArr, int i) {
        boolean z;
        boolean z2 = false;
        if (i != 0) {
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= tVarArr.length) {
                    z = true;
                    break;
                }
                int trackType = tVarArr[i2].getTrackType();
                f fVar = fVarArr[i2];
                if ((trackType == 1 || trackType == 2) && fVar != null && a(iArr[i2], uVarArr[i2], fVar)) {
                    if (trackType == 1) {
                        if (i4 != -1) {
                            z = false;
                            break;
                        }
                        i4 = i2;
                    } else if (i3 != -1) {
                        z = false;
                        break;
                    } else {
                        i3 = i2;
                    }
                }
                i2++;
            }
            if (i4 != -1 && i3 != -1) {
                z2 = true;
            }
            if (z & z2) {
                com.google.android.exoplayer2.u uVar = new com.google.android.exoplayer2.u(i);
                uVarArr2[i4] = uVar;
                uVarArr2[i3] = uVar;
            }
        }
    }

    private static boolean a(int[][] iArr, u uVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int a2 = uVar.a(fVar.dxg());
        for (int i = 0; i < fVar.length(); i++) {
            if ((iArr[a2][fVar.LG(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }
}
