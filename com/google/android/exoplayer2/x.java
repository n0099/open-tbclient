package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes6.dex */
public abstract class x {
    public static final x mae = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dtz() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dtA() {
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

    public abstract int dtA();

    public abstract int dtz();

    /* loaded from: classes6.dex */
    public static final class b {
        public boolean isDynamic;
        public long lZB;
        public Object maf;
        public long man;
        public long mao;
        public boolean maq;
        public int mar;
        public int mas;
        public long mat;
        public long mau;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.maf = obj;
            this.man = j;
            this.mao = j2;
            this.maq = z;
            this.isDynamic = z2;
            this.mat = j3;
            this.lZB = j4;
            this.mar = i;
            this.mas = i2;
            this.mau = j5;
            return this;
        }

        public long dtG() {
            return this.mat;
        }

        public long dtB() {
            return com.google.android.exoplayer2.b.fn(this.lZB);
        }

        public long dtH() {
            return this.mau;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public long lZB;
        public Object lZh;
        public Object maf;
        private long mag;
        private long[] mah;
        private int[] mai;
        private int[] maj;
        private int[] mak;
        private long[][] mal;
        private long mam;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.maf = obj;
            this.lZh = obj2;
            this.windowIndex = i;
            this.lZB = j;
            this.mag = j2;
            this.mah = jArr;
            this.mai = iArr;
            this.maj = iArr2;
            this.mak = iArr3;
            this.mal = jArr2;
            this.mam = j3;
            return this;
        }

        public long dtB() {
            return com.google.android.exoplayer2.b.fn(this.lZB);
        }

        public long getDurationUs() {
            return this.lZB;
        }

        public long dtC() {
            return com.google.android.exoplayer2.b.fn(this.mag);
        }

        public long dtD() {
            return this.mag;
        }

        public int dtE() {
            if (this.mah == null) {
                return 0;
            }
            return this.mah.length;
        }

        public long IZ(int i) {
            return this.mah[i];
        }

        public int Ja(int i) {
            return this.mak[i];
        }

        public boolean Jb(int i) {
            return this.mai[i] != -1 && this.mak[i] == this.mai[i];
        }

        public int fA(long j) {
            if (this.mah == null) {
                return -1;
            }
            int length = this.mah.length - 1;
            while (length >= 0 && (this.mah[length] == Long.MIN_VALUE || this.mah[length] > j)) {
                length--;
            }
            if (length < 0 || Jb(length)) {
                length = -1;
            }
            return length;
        }

        public int fB(long j) {
            if (this.mah == null) {
                return -1;
            }
            int i = 0;
            while (i < this.mah.length && this.mah[i] != Long.MIN_VALUE && (j >= this.mah[i] || Jb(i))) {
                i++;
            }
            if (i >= this.mah.length) {
                i = -1;
            }
            return i;
        }

        public int Jc(int i) {
            return this.mai[i];
        }

        public boolean dG(int i, int i2) {
            return i2 < this.maj[i];
        }

        public long dH(int i, int i2) {
            if (i2 >= this.mal[i].length) {
                return -9223372036854775807L;
            }
            return this.mal[i][i2];
        }

        public long dtF() {
            return this.mam;
        }
    }

    public final boolean isEmpty() {
        return dtz() == 0;
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
        return dtz() - 1;
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
        if (a(i3, bVar).mas == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).mar;
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
        com.google.android.exoplayer2.util.a.aj(i, 0, dtz());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.dtG();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.mar;
        long dtH = bVar.dtH() + j;
        long durationUs = a(i2, aVar).getDurationUs();
        while (durationUs != -9223372036854775807L && dtH >= durationUs && i2 < bVar.mas) {
            dtH -= durationUs;
            i2++;
            durationUs = a(i2, aVar).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(dtH));
    }
}
