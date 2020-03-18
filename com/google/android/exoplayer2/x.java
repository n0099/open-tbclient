package com.google.android.exoplayer2;

import android.util.Pair;
/* loaded from: classes6.dex */
public abstract class x {
    public static final x mbZ = new x() { // from class: com.google.android.exoplayer2.x.1
        @Override // com.google.android.exoplayer2.x
        public int dtZ() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.x
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.x
        public int dua() {
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

    public abstract int dtZ();

    public abstract int dua();

    /* loaded from: classes6.dex */
    public static final class b {
        public boolean isDynamic;
        public long mbx;
        public Object mca;
        public long mci;
        public long mcj;
        public boolean mck;
        public int mcl;
        public int mcm;
        public long mcn;
        public long mco;

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.mca = obj;
            this.mci = j;
            this.mcj = j2;
            this.mck = z;
            this.isDynamic = z2;
            this.mcn = j3;
            this.mbx = j4;
            this.mcl = i;
            this.mcm = i2;
            this.mco = j5;
            return this;
        }

        public long dug() {
            return this.mcn;
        }

        public long dub() {
            return com.google.android.exoplayer2.b.fo(this.mbx);
        }

        public long duh() {
            return this.mco;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public Object mbd;
        public long mbx;
        public Object mca;
        private long mcb;
        private long[] mcc;
        private int[] mcd;
        private int[] mce;
        private int[] mcf;
        private long[][] mcg;
        private long mch;
        public int windowIndex;

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, null, null, null, null, null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j3) {
            this.mca = obj;
            this.mbd = obj2;
            this.windowIndex = i;
            this.mbx = j;
            this.mcb = j2;
            this.mcc = jArr;
            this.mcd = iArr;
            this.mce = iArr2;
            this.mcf = iArr3;
            this.mcg = jArr2;
            this.mch = j3;
            return this;
        }

        public long dub() {
            return com.google.android.exoplayer2.b.fo(this.mbx);
        }

        public long getDurationUs() {
            return this.mbx;
        }

        public long duc() {
            return com.google.android.exoplayer2.b.fo(this.mcb);
        }

        public long dud() {
            return this.mcb;
        }

        public int due() {
            if (this.mcc == null) {
                return 0;
            }
            return this.mcc.length;
        }

        public long Jf(int i) {
            return this.mcc[i];
        }

        public int Jg(int i) {
            return this.mcf[i];
        }

        public boolean Jh(int i) {
            return this.mcd[i] != -1 && this.mcf[i] == this.mcd[i];
        }

        public int fB(long j) {
            if (this.mcc == null) {
                return -1;
            }
            int length = this.mcc.length - 1;
            while (length >= 0 && (this.mcc[length] == Long.MIN_VALUE || this.mcc[length] > j)) {
                length--;
            }
            if (length < 0 || Jh(length)) {
                length = -1;
            }
            return length;
        }

        public int fC(long j) {
            if (this.mcc == null) {
                return -1;
            }
            int i = 0;
            while (i < this.mcc.length && this.mcc[i] != Long.MIN_VALUE && (j >= this.mcc[i] || Jh(i))) {
                i++;
            }
            if (i >= this.mcc.length) {
                i = -1;
            }
            return i;
        }

        public int Ji(int i) {
            return this.mcd[i];
        }

        public boolean dH(int i, int i2) {
            return i2 < this.mce[i];
        }

        public long dI(int i, int i2) {
            if (i2 >= this.mcg[i].length) {
                return -9223372036854775807L;
            }
            return this.mcg[i][i2];
        }

        public long duf() {
            return this.mch;
        }
    }

    public final boolean isEmpty() {
        return dtZ() == 0;
    }

    public int p(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vK(z)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                return i == vK(z) ? vL(z) : i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int q(int i, int i2, boolean z) {
        switch (i2) {
            case 0:
                if (i == vL(z)) {
                    return -1;
                }
                return i - 1;
            case 1:
                return i;
            case 2:
                return i == vL(z) ? vK(z) : i - 1;
            default:
                throw new IllegalStateException();
        }
    }

    public int vK(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return dtZ() - 1;
    }

    public int vL(boolean z) {
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
        if (a(i3, bVar).mcm == i) {
            int p = p(i3, i2, z);
            if (p == -1) {
                return -1;
            }
            return a(p, bVar).mcl;
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
        com.google.android.exoplayer2.util.a.aj(i, 0, dtZ());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.dug();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.mcl;
        long duh = bVar.duh() + j;
        long durationUs = a(i2, aVar).getDurationUs();
        while (durationUs != -9223372036854775807L && duh >= durationUs && i2 < bVar.mcm) {
            duh -= durationUs;
            i2++;
            durationUs = a(i2, aVar).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(duh));
    }
}
