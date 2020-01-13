package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes5.dex */
public abstract class x {
    public static final x lZs = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dsl() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dsm() {
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

    public abstract int dsl();

    public abstract int dsm();

    /* loaded from: classes5.dex */
    public static final class b {
        public boolean isDynamic;
        public long lYQ;
        public long lZB;
        public long lZC;
        public boolean lZD;
        public int lZE;
        public int lZF;
        public long lZG;
        public long lZH;
        public Object lZt;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.lZt = obj;
            this.lZB = j;
            this.lZC = j2;
            this.lZD = z;
            this.isDynamic = z2;
            this.lZG = j3;
            this.lYQ = j4;
            this.lZE = i;
            this.lZF = i2;
            this.lZH = j5;
            return this;
        }

        public long dst() {
            return this.lZG;
        }

        public long dsn() {
            return com.google.android.exoplayer2.b.fp(this.lYQ);
        }

        public long dsu() {
            return this.lZH;
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public long lYQ;
        public Object lYw;
        private long lZA;
        public Object lZt;
        private long lZu;
        private long[] lZv;
        private int[] lZw;
        private int[] lZx;
        private int[] lZy;
        private long[][] lZz;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.lZt = obj;
            this.lYw = obj2;
            this.windowIndex = i;
            this.lYQ = j;
            this.lZu = j2;
            this.lZv = jArr;
            this.lZw = iArr;
            this.lZx = iArr2;
            this.lZy = iArr3;
            this.lZz = jArr2;
            this.lZA = j3;
            return this;
        }

        public long dsn() {
            return com.google.android.exoplayer2.b.fp(this.lYQ);
        }

        public long dso() {
            return this.lYQ;
        }

        public long dsp() {
            return com.google.android.exoplayer2.b.fp(this.lZu);
        }

        public long dsq() {
            return this.lZu;
        }

        public int dsr() {
            if (this.lZv == null) {
                return 0;
            }
            return this.lZv.length;
        }

        public long IU(int i) {
            return this.lZv[i];
        }

        public int IV(int i) {
            return this.lZy[i];
        }

        public boolean IW(int i) {
            return this.lZw[i] != -1 && this.lZy[i] == this.lZw[i];
        }

        public int fC(long j) {
            if (this.lZv == null) {
                return -1;
            }
            int length = this.lZv.length - 1;
            while (length >= 0 && (this.lZv[length] == Long.MIN_VALUE || this.lZv[length] > j)) {
                length--;
            }
            if (length < 0 || IW(length)) {
                length = -1;
            }
            return length;
        }

        public int fD(long j) {
            if (this.lZv == null) {
                return -1;
            }
            int i = 0;
            while (i < this.lZv.length && this.lZv[i] != Long.MIN_VALUE && (j >= this.lZv[i] || IW(i))) {
                i++;
            }
            if (i >= this.lZv.length) {
                i = -1;
            }
            return i;
        }

        public int IX(int i) {
            return this.lZw[i];
        }

        public boolean dD(int i, int i2) {
            return i2 < this.lZx[i];
        }

        public long dE(int i, int i2) {
            if (i2 >= this.lZz[i].length) {
                return -9223372036854775807L;
            }
            return this.lZz[i][i2];
        }

        public long dss() {
            return this.lZA;
        }
    }

    public final boolean isEmpty() {
        return dsl() == 0;
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
        return dsl() - 1;
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
        if (a(i3, bVar).lZF == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).lZE;
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
        com.google.android.exoplayer2.util.a.ai(i, 0, dsl());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.dst();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.lZE;
        long dsu = bVar.dsu() + j;
        long dso = a(i2, aVar).dso();
        while (dso != -9223372036854775807L && dsu >= dso && i2 < bVar.lZF) {
            dsu -= dso;
            i2++;
            dso = a(i2, aVar).dso();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(dsu));
    }
}
