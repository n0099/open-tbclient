package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n {
    private int length;
    private int mup;
    private int muq;
    private int mur;
    private Format muw;
    private int mux;
    private int capacity = 1000;
    private int[] mum = new int[this.capacity];
    private long[] mfJ = new long[this.capacity];
    private long[] mfL = new long[this.capacity];
    private int[] mkY = new int[this.capacity];
    private int[] mfI = new int[this.capacity];
    private m.a[] mun = new m.a[this.capacity];
    private Format[] muo = new Format[this.capacity];
    private long mus = Long.MIN_VALUE;
    private long mut = Long.MIN_VALUE;
    private boolean muv = true;
    private boolean muu = true;

    /* loaded from: classes6.dex */
    public static final class a {
        public m.a mhS;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.mup = 0;
        this.muq = 0;
        this.mur = 0;
        this.muu = true;
        this.mus = Long.MIN_VALUE;
        this.mut = Long.MIN_VALUE;
        if (z) {
            this.muw = null;
            this.muv = true;
        }
    }

    public int dwT() {
        return this.mup + this.length;
    }

    public long KM(int i) {
        int KQ;
        int dwT = dwT() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dwT >= 0 && dwT <= this.length - this.mur);
        this.length -= dwT;
        this.mut = Math.max(this.mus, KP(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.mfI[KQ] + this.mfJ[KQ(this.length - 1)];
    }

    public void KN(int i) {
        this.mux = i;
    }

    public int dwU() {
        return this.mup + this.mur;
    }

    public int dwV() {
        return dwW() ? this.mum[KQ(this.mur)] : this.mux;
    }

    public synchronized boolean dwW() {
        return this.mur != this.length;
    }

    public synchronized Format dwX() {
        return this.muv ? null : this.muw;
    }

    public synchronized long dwP() {
        return this.mut;
    }

    public synchronized void rewind() {
        this.mur = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dwW()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.muw == null || (!z && this.muw == format)) {
                    i = -3;
                } else {
                    mVar.mbs = this.muw;
                    i = -5;
                }
            } else {
                int KQ = KQ(this.mur);
                if (z || this.muo[KQ] != format) {
                    mVar.mbs = this.muo[KQ];
                    i = -5;
                } else if (eVar.dvb()) {
                    i = -3;
                } else {
                    eVar.mfu = this.mfL[KQ];
                    eVar.setFlags(this.mkY[KQ]);
                    aVar.size = this.mfI[KQ];
                    aVar.offset = this.mfJ[KQ];
                    aVar.mhS = this.mun[KQ];
                    this.mur++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int KQ = KQ(this.mur);
            if (dwW() && j >= this.mfL[KQ] && ((j <= this.mut || z2) && (a2 = a(KQ, this.length - this.mur, j, z)) != -1)) {
                this.mur += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dwY() {
        int i;
        i = this.length - this.mur;
        this.mur = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.mfL[this.muq]) {
            j2 = -1;
        } else {
            int a2 = a(this.muq, (!z2 || this.mur == this.length) ? this.length : this.mur + 1, j, z);
            j2 = a2 == -1 ? -1L : KO(a2);
        }
        return j2;
    }

    public synchronized long dwZ() {
        return this.mur == 0 ? -1L : KO(this.mur);
    }

    public synchronized long dxa() {
        return this.length == 0 ? -1L : KO(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.muv = true;
            } else {
                this.muv = false;
                if (!v.h(format, this.muw)) {
                    this.muw = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.muu) {
            if ((i & 1) != 0) {
                this.muu = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.muv);
        gh(j);
        int KQ = KQ(this.length);
        this.mfL[KQ] = j;
        this.mfJ[KQ] = j2;
        this.mfI[KQ] = i2;
        this.mkY[KQ] = i;
        this.mun[KQ] = aVar;
        this.muo[KQ] = this.muw;
        this.mum[KQ] = this.mux;
        this.length++;
        if (this.length == this.capacity) {
            int i3 = this.capacity + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            m.a[] aVarArr = new m.a[i3];
            Format[] formatArr = new Format[i3];
            int i4 = this.capacity - this.muq;
            System.arraycopy(this.mfJ, this.muq, jArr, 0, i4);
            System.arraycopy(this.mfL, this.muq, jArr2, 0, i4);
            System.arraycopy(this.mkY, this.muq, iArr2, 0, i4);
            System.arraycopy(this.mfI, this.muq, iArr3, 0, i4);
            System.arraycopy(this.mun, this.muq, aVarArr, 0, i4);
            System.arraycopy(this.muo, this.muq, formatArr, 0, i4);
            System.arraycopy(this.mum, this.muq, iArr, 0, i4);
            int i5 = this.muq;
            System.arraycopy(this.mfJ, 0, jArr, i4, i5);
            System.arraycopy(this.mfL, 0, jArr2, i4, i5);
            System.arraycopy(this.mkY, 0, iArr2, i4, i5);
            System.arraycopy(this.mfI, 0, iArr3, i4, i5);
            System.arraycopy(this.mun, 0, aVarArr, i4, i5);
            System.arraycopy(this.muo, 0, formatArr, i4, i5);
            System.arraycopy(this.mum, 0, iArr, i4, i5);
            this.mfJ = jArr;
            this.mfL = jArr2;
            this.mkY = iArr2;
            this.mfI = iArr3;
            this.mun = aVarArr;
            this.muo = formatArr;
            this.mum = iArr;
            this.muq = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gh(long j) {
        this.mut = Math.max(this.mut, j);
    }

    public synchronized boolean gi(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.mus) {
                    z = false;
                }
            } else if (Math.max(this.mus, KP(this.mur)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int KQ = KQ(this.length - 1);
                while (i > this.mur && this.mfL[KQ] >= j) {
                    i--;
                    KQ--;
                    if (KQ == -1) {
                        KQ = this.capacity - 1;
                    }
                }
                KM(this.mup + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.mfL[i] <= j) {
            if (!z || (this.mkY[i] & 1) != 0) {
                i3 = i4;
            }
            int i5 = i + 1;
            if (i5 == this.capacity) {
                i5 = 0;
            }
            i4++;
            i = i5;
        }
        return i3;
    }

    private long KO(int i) {
        int i2;
        this.mus = Math.max(this.mus, KP(i));
        this.length -= i;
        this.mup += i;
        this.muq += i;
        if (this.muq >= this.capacity) {
            this.muq -= this.capacity;
        }
        this.mur -= i;
        if (this.mur < 0) {
            this.mur = 0;
        }
        if (this.length == 0) {
            return this.mfI[i2] + this.mfJ[(this.muq == 0 ? this.capacity : this.muq) - 1];
        }
        return this.mfJ[this.muq];
    }

    private long KP(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int KQ = KQ(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.mfL[KQ]);
            if ((this.mkY[KQ] & 1) != 0) {
                return max;
            }
            int i3 = KQ - 1;
            if (i3 == -1) {
                i3 = this.capacity - 1;
            }
            i2++;
            KQ = i3;
            j = max;
        }
        return j;
    }

    private int KQ(int i) {
        int i2 = this.muq + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
