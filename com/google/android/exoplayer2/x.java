package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes6.dex */
public abstract class x {
    public static final x mas = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dtC() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dtD() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int bw(Object obj) {
            return -1;
        }
    };

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, boolean z, long j);

    public abstract int bw(Object obj);

    public abstract int dtC();

    public abstract int dtD();

    /* loaded from: classes6.dex */
    public static final class b {
        public boolean isDynamic;
        public long lZO;
        public long maC;
        public long maD;
        public boolean maE;
        public int maF;
        public int maG;
        public long maH;
        public long maI;
        public Object mat;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.mat = obj;
            this.maC = j;
            this.maD = j2;
            this.maE = z;
            this.isDynamic = z2;
            this.maH = j3;
            this.lZO = j4;
            this.maF = i;
            this.maG = i2;
            this.maI = j5;
            return this;
        }

        public long dtJ() {
            return this.maH;
        }

        public long dtE() {
            return com.google.android.exoplayer2.b.fn(this.lZO);
        }

        public long dtK() {
            return this.maI;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public long lZO;
        public Object lZu;
        private long[][] maA;
        private long maB;
        public Object mat;
        private long mau;
        private long[] mav;
        private int[] maw;
        private int[] may;
        private int[] maz;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.mat = obj;
            this.lZu = obj2;
            this.windowIndex = i;
            this.lZO = j;
            this.mau = j2;
            this.mav = jArr;
            this.maw = iArr;
            this.may = iArr2;
            this.maz = iArr3;
            this.maA = jArr2;
            this.maB = j3;
            return this;
        }

        public long dtE() {
            return com.google.android.exoplayer2.b.fn(this.lZO);
        }

        public long getDurationUs() {
            return this.lZO;
        }

        public long dtF() {
            return com.google.android.exoplayer2.b.fn(this.mau);
        }

        public long dtG() {
            return this.mau;
        }

        public int dtH() {
            if (this.mav == null) {
                return 0;
            }
            return this.mav.length;
        }

        public long IZ(int i) {
            return this.mav[i];
        }

        public int Ja(int i) {
            return this.maz[i];
        }

        public boolean Jb(int i) {
            return this.maw[i] != -1 && this.maz[i] == this.maw[i];
        }

        public int fA(long j) {
            if (this.mav == null) {
                return -1;
            }
            int length = this.mav.length - 1;
            while (length >= 0 && (this.mav[length] == Long.MIN_VALUE || this.mav[length] > j)) {
                length--;
            }
            if (length < 0 || Jb(length)) {
                length = -1;
            }
            return length;
        }

        public int fB(long j) {
            if (this.mav == null) {
                return -1;
            }
            int i = 0;
            while (i < this.mav.length && this.mav[i] != Long.MIN_VALUE && (j >= this.mav[i] || Jb(i))) {
                i++;
            }
            if (i >= this.mav.length) {
                i = -1;
            }
            return i;
        }

        public int Jc(int i) {
            return this.maw[i];
        }

        public boolean dG(int i, int i2) {
            return i2 < this.may[i];
        }

        public long dH(int i, int i2) {
            if (i2 >= this.maA[i].length) {
                return -9223372036854775807L;
            }
            return this.maA[i][i2];
        }

        public long dtI() {
            return this.maB;
        }
    }

    public final boolean isEmpty() {
        return dtC() == 0;
    }

    public int p(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vD(z)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                return i == vD(z) ? vE(z) : i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int q(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vE(z)) {
                    return -1;
                }
                return i - 1;
            case 1:
                return i;
            case 2:
                return i == vE(z) ? vD(z) : i - 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int vD(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return dtC() - 1;
    }

    public int vE(boolean z) {
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
        if (a(i3, bVar).maG == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).maF;
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
        com.google.android.exoplayer2.util.a.aj(i, 0, dtC());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.dtJ();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.maF;
        long dtK = bVar.dtK() + j;
        long durationUs = a(i2, aVar).getDurationUs();
        while (durationUs != -9223372036854775807L && dtK >= durationUs && i2 < bVar.maG) {
            dtK -= durationUs;
            i2++;
            durationUs = a(i2, aVar).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(dtK));
    }
}
