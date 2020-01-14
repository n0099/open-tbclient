package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes5.dex */
public abstract class x {
    public static final x lZx = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dsn() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dso() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int bu(Object obj) {
            return -1;
        }
    };

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, boolean z, long j);

    public abstract int bu(Object obj);

    public abstract int dsn();

    public abstract int dso();

    /* loaded from: classes5.dex */
    public static final class b {
        public boolean isDynamic;
        public long lYV;
        public long lZG;
        public long lZH;
        public boolean lZI;
        public int lZJ;
        public int lZK;
        public long lZL;
        public long lZM;
        public Object lZy;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.lZy = obj;
            this.lZG = j;
            this.lZH = j2;
            this.lZI = z;
            this.isDynamic = z2;
            this.lZL = j3;
            this.lYV = j4;
            this.lZJ = i;
            this.lZK = i2;
            this.lZM = j5;
            return this;
        }

        public long dsv() {
            return this.lZL;
        }

        public long dsp() {
            return com.google.android.exoplayer2.b.fp(this.lYV);
        }

        public long dsw() {
            return this.lZM;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public Object lYB;
        public long lYV;
        private long[] lZA;
        private int[] lZB;
        private int[] lZC;
        private int[] lZD;
        private long[][] lZE;
        private long lZF;
        public Object lZy;
        private long lZz;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.lZy = obj;
            this.lYB = obj2;
            this.windowIndex = i;
            this.lYV = j;
            this.lZz = j2;
            this.lZA = jArr;
            this.lZB = iArr;
            this.lZC = iArr2;
            this.lZD = iArr3;
            this.lZE = jArr2;
            this.lZF = j3;
            return this;
        }

        public long dsp() {
            return com.google.android.exoplayer2.b.fp(this.lYV);
        }

        public long dsq() {
            return this.lYV;
        }

        public long dsr() {
            return com.google.android.exoplayer2.b.fp(this.lZz);
        }

        public long dss() {
            return this.lZz;
        }

        public int dst() {
            if (this.lZA == null) {
                return 0;
            }
            return this.lZA.length;
        }

        public long IU(int i) {
            return this.lZA[i];
        }

        public int IV(int i) {
            return this.lZD[i];
        }

        public boolean IW(int i) {
            return this.lZB[i] != -1 && this.lZD[i] == this.lZB[i];
        }

        public int fC(long j) {
            if (this.lZA == null) {
                return -1;
            }
            int length = this.lZA.length - 1;
            while (length >= 0 && (this.lZA[length] == Long.MIN_VALUE || this.lZA[length] > j)) {
                length--;
            }
            if (length < 0 || IW(length)) {
                length = -1;
            }
            return length;
        }

        public int fD(long j) {
            if (this.lZA == null) {
                return -1;
            }
            int i = 0;
            while (i < this.lZA.length && this.lZA[i] != Long.MIN_VALUE && (j >= this.lZA[i] || IW(i))) {
                i++;
            }
            if (i >= this.lZA.length) {
                i = -1;
            }
            return i;
        }

        public int IX(int i) {
            return this.lZB[i];
        }

        public boolean dD(int i, int i2) {
            return i2 < this.lZC[i];
        }

        public long dE(int i, int i2) {
            if (i2 >= this.lZE[i].length) {
                return -9223372036854775807L;
            }
            return this.lZE[i][i2];
        }

        public long dsu() {
            return this.lZF;
        }
    }

    public final boolean isEmpty() {
        return dsn() == 0;
    }

    public int p(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vz(z)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                return i == vz(z) ? vA(z) : i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int q(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vA(z)) {
                    return -1;
                }
                return i - 1;
            case 1:
                return i;
            case 2:
                return i == vA(z) ? vz(z) : i - 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int vz(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return dsn() - 1;
    }

    public int vA(boolean z) {
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
        if (a(i3, bVar).lZK == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).lZJ;
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
        com.google.android.exoplayer2.util.a.ai(i, 0, dsn());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.dsv();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.lZJ;
        long dsw = bVar.dsw() + j;
        long dsq = a(i2, aVar).dsq();
        while (dsq != -9223372036854775807L && dsw >= dsq && i2 < bVar.lZK) {
            dsw -= dsq;
            i2++;
            dsq = a(i2, aVar).dsq();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(dsw));
    }
}
