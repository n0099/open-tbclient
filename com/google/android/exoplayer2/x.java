package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes6.dex */
public abstract class x {
    public static final x mag = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dtB() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dtC() {
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

    public abstract int dtB();

    public abstract int dtC();

    /* loaded from: classes6.dex */
    public static final class b {
        public boolean isDynamic;
        public long lZD;
        public Object mah;
        public long maq;
        public long mar;
        public boolean mas;
        public int mat;
        public int mau;
        public long mav;
        public long maw;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.mah = obj;
            this.maq = j;
            this.mar = j2;
            this.mas = z;
            this.isDynamic = z2;
            this.mav = j3;
            this.lZD = j4;
            this.mat = i;
            this.mau = i2;
            this.maw = j5;
            return this;
        }

        public long dtI() {
            return this.mav;
        }

        public long dtD() {
            return com.google.android.exoplayer2.b.fn(this.lZD);
        }

        public long dtJ() {
            return this.maw;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public long lZD;
        public Object lZj;
        public Object mah;
        private long mai;
        private long[] maj;
        private int[] mak;
        private int[] mal;
        private int[] mam;
        private long[][] man;
        private long mao;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.mah = obj;
            this.lZj = obj2;
            this.windowIndex = i;
            this.lZD = j;
            this.mai = j2;
            this.maj = jArr;
            this.mak = iArr;
            this.mal = iArr2;
            this.mam = iArr3;
            this.man = jArr2;
            this.mao = j3;
            return this;
        }

        public long dtD() {
            return com.google.android.exoplayer2.b.fn(this.lZD);
        }

        public long getDurationUs() {
            return this.lZD;
        }

        public long dtE() {
            return com.google.android.exoplayer2.b.fn(this.mai);
        }

        public long dtF() {
            return this.mai;
        }

        public int dtG() {
            if (this.maj == null) {
                return 0;
            }
            return this.maj.length;
        }

        public long IZ(int i) {
            return this.maj[i];
        }

        public int Ja(int i) {
            return this.mam[i];
        }

        public boolean Jb(int i) {
            return this.mak[i] != -1 && this.mam[i] == this.mak[i];
        }

        public int fA(long j) {
            if (this.maj == null) {
                return -1;
            }
            int length = this.maj.length - 1;
            while (length >= 0 && (this.maj[length] == Long.MIN_VALUE || this.maj[length] > j)) {
                length--;
            }
            if (length < 0 || Jb(length)) {
                length = -1;
            }
            return length;
        }

        public int fB(long j) {
            if (this.maj == null) {
                return -1;
            }
            int i = 0;
            while (i < this.maj.length && this.maj[i] != Long.MIN_VALUE && (j >= this.maj[i] || Jb(i))) {
                i++;
            }
            if (i >= this.maj.length) {
                i = -1;
            }
            return i;
        }

        public int Jc(int i) {
            return this.mak[i];
        }

        public boolean dG(int i, int i2) {
            return i2 < this.mal[i];
        }

        public long dH(int i, int i2) {
            if (i2 >= this.man[i].length) {
                return -9223372036854775807L;
            }
            return this.man[i][i2];
        }

        public long dtH() {
            return this.mao;
        }
    }

    public final boolean isEmpty() {
        return dtB() == 0;
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
        return dtB() - 1;
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
        if (a(i3, bVar).mau == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).mat;
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
        com.google.android.exoplayer2.util.a.aj(i, 0, dtB());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.dtI();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.mat;
        long dtJ = bVar.dtJ() + j;
        long durationUs = a(i2, aVar).getDurationUs();
        while (durationUs != -9223372036854775807L && dtJ >= durationUs && i2 < bVar.mau) {
            dtJ -= durationUs;
            i2++;
            durationUs = a(i2, aVar).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(dtJ));
    }
}
