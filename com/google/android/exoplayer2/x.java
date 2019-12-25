package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes4.dex */
public abstract class x {
    public static final x lVD = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dqZ() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dra() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int bt(Object obj) {
            return -1;
        }
    };

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, boolean z, long j);

    public abstract int bt(Object obj);

    public abstract int dqZ();

    public abstract int dra();

    /* loaded from: classes4.dex */
    public static final class b {
        public boolean isDynamic;
        public long lUZ;
        public Object lVE;
        public long lVM;
        public long lVN;
        public boolean lVO;
        public int lVP;
        public int lVQ;
        public long lVR;
        public long lVS;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.lVE = obj;
            this.lVM = j;
            this.lVN = j2;
            this.lVO = z;
            this.isDynamic = z2;
            this.lVR = j3;
            this.lUZ = j4;
            this.lVP = i;
            this.lVQ = i2;
            this.lVS = j5;
            return this;
        }

        public long drh() {
            return this.lVR;
        }

        public long drb() {
            return com.google.android.exoplayer2.b.fk(this.lUZ);
        }

        public long dri() {
            return this.lVS;
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public Object lUF;
        public long lUZ;
        public Object lVE;
        private long lVF;
        private long[] lVG;
        private int[] lVH;
        private int[] lVI;
        private int[] lVJ;
        private long[][] lVK;
        private long lVL;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.lVE = obj;
            this.lUF = obj2;
            this.windowIndex = i;
            this.lUZ = j;
            this.lVF = j2;
            this.lVG = jArr;
            this.lVH = iArr;
            this.lVI = iArr2;
            this.lVJ = iArr3;
            this.lVK = jArr2;
            this.lVL = j3;
            return this;
        }

        public long drb() {
            return com.google.android.exoplayer2.b.fk(this.lUZ);
        }

        public long drc() {
            return this.lUZ;
        }

        public long drd() {
            return com.google.android.exoplayer2.b.fk(this.lVF);
        }

        public long dre() {
            return this.lVF;
        }

        public int drf() {
            if (this.lVG == null) {
                return 0;
            }
            return this.lVG.length;
        }

        public long IL(int i) {
            return this.lVG[i];
        }

        public int IM(int i) {
            return this.lVJ[i];
        }

        public boolean IN(int i) {
            return this.lVH[i] != -1 && this.lVJ[i] == this.lVH[i];
        }

        public int fx(long j) {
            if (this.lVG == null) {
                return -1;
            }
            int length = this.lVG.length - 1;
            while (length >= 0 && (this.lVG[length] == Long.MIN_VALUE || this.lVG[length] > j)) {
                length--;
            }
            if (length < 0 || IN(length)) {
                length = -1;
            }
            return length;
        }

        public int fy(long j) {
            if (this.lVG == null) {
                return -1;
            }
            int i = 0;
            while (i < this.lVG.length && this.lVG[i] != Long.MIN_VALUE && (j >= this.lVG[i] || IN(i))) {
                i++;
            }
            if (i >= this.lVG.length) {
                i = -1;
            }
            return i;
        }

        public int IO(int i) {
            return this.lVH[i];
        }

        public boolean dF(int i, int i2) {
            return i2 < this.lVI[i];
        }

        public long dG(int i, int i2) {
            if (i2 >= this.lVK[i].length) {
                return -9223372036854775807L;
            }
            return this.lVK[i][i2];
        }

        public long drg() {
            return this.lVL;
        }
    }

    public final boolean isEmpty() {
        return dqZ() == 0;
    }

    public int p(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vn(z)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                return i == vn(z) ? vo(z) : i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int q(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vo(z)) {
                    return -1;
                }
                return i - 1;
            case 1:
                return i;
            case 2:
                return i == vo(z) ? vn(z) : i - 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int vn(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return dqZ() - 1;
    }

    public int vo(boolean z) {
        return isEmpty() ? -1 : 0;
    }

    public final b a(int i, b bVar) {
        return a(i, bVar, false);
    }

    public final b a(int i, b bVar, boolean z) {
        return a(i, bVar, z, 0L);
    }

    public final int a(int i, a aVar, b bVar, int i2, boolean z) {
        int i3 = a(i, aVar).windowIndex;
        if (a(i3, bVar).lVQ == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).lVP;
        }
        return i + 1;
    }

    public final boolean b(int i, a aVar, b bVar, int i2, boolean z) {
        return a(i, aVar, bVar, i2, z) == -1;
    }

    public final a a(int i, a aVar) {
        return a(i, aVar, false);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0L);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j, long j2) {
        com.google.android.exoplayer2.util.a.ai(i, 0, dqZ());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.drh();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.lVP;
        long dri = bVar.dri() + j;
        long drc = a(i2, aVar).drc();
        while (drc != -9223372036854775807L && dri >= drc && i2 < bVar.lVQ) {
            dri -= drc;
            i2++;
            drc = a(i2, aVar).drc();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(dri));
    }
}
