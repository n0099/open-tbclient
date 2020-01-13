package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class n {
    private int length;
    private int mrJ;
    private int mrK;
    private int mrL;
    private Format mrQ;
    private int mrR;
    private int capacity = 1000;
    private int[] mrG = new int[this.capacity];
    private long[] mdf = new long[this.capacity];
    private long[] mdh = new long[this.capacity];
    private int[] miu = new int[this.capacity];
    private int[] mde = new int[this.capacity];
    private m.a[] mrH = new m.a[this.capacity];
    private Format[] mrI = new Format[this.capacity];
    private long mrM = Long.MIN_VALUE;
    private long mrN = Long.MIN_VALUE;
    private boolean mrP = true;
    private boolean mrO = true;

    /* loaded from: classes5.dex */
    public static final class a {
        public m.a mfo;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.mrJ = 0;
        this.mrK = 0;
        this.mrL = 0;
        this.mrO = true;
        this.mrM = Long.MIN_VALUE;
        this.mrN = Long.MIN_VALUE;
        if (z) {
            this.mrQ = null;
            this.mrP = true;
        }
    }

    public int dvh() {
        return this.mrJ + this.length;
    }

    public long KB(int i) {
        int KF;
        int dvh = dvh() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dvh >= 0 && dvh <= this.length - this.mrL);
        this.length -= dvh;
        this.mrN = Math.max(this.mrM, KE(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.mde[KF] + this.mdf[KF(this.length - 1)];
    }

    public void KC(int i) {
        this.mrR = i;
    }

    public int dvi() {
        return this.mrJ + this.mrL;
    }

    public int dvj() {
        return dvk() ? this.mrG[KF(this.mrL)] : this.mrR;
    }

    public synchronized boolean dvk() {
        return this.mrL != this.length;
    }

    public synchronized Format dvl() {
        return this.mrP ? null : this.mrQ;
    }

    public synchronized long dvd() {
        return this.mrN;
    }

    public synchronized void rewind() {
        this.mrL = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dvk()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.mrQ == null || (!z && this.mrQ == format)) {
                    i = -3;
                } else {
                    mVar.lYL = this.mrQ;
                    i = -5;
                }
            } else {
                int KF = KF(this.mrL);
                if (z || this.mrI[KF] != format) {
                    mVar.lYL = this.mrI[KF];
                    i = -5;
                } else if (eVar.dto()) {
                    i = -3;
                } else {
                    eVar.mcQ = this.mdh[KF];
                    eVar.setFlags(this.miu[KF]);
                    aVar.size = this.mde[KF];
                    aVar.offset = this.mdf[KF];
                    aVar.mfo = this.mrH[KF];
                    this.mrL++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int KF = KF(this.mrL);
            if (dvk() && j >= this.mdh[KF] && ((j <= this.mrN || z2) && (a2 = a(KF, this.length - this.mrL, j, z)) != -1)) {
                this.mrL += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dvm() {
        int i;
        i = this.length - this.mrL;
        this.mrL = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.mdh[this.mrK]) {
            j2 = -1;
        } else {
            int a2 = a(this.mrK, (!z2 || this.mrL == this.length) ? this.length : this.mrL + 1, j, z);
            j2 = a2 == -1 ? -1L : KD(a2);
        }
        return j2;
    }

    public synchronized long dvn() {
        return this.mrL == 0 ? -1L : KD(this.mrL);
    }

    public synchronized long dvo() {
        return this.length == 0 ? -1L : KD(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.mrP = true;
            } else {
                this.mrP = false;
                if (!v.h(format, this.mrQ)) {
                    this.mrQ = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.mrO) {
            if ((i & 1) != 0) {
                this.mrO = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.mrP);
        gi(j);
        int KF = KF(this.length);
        this.mdh[KF] = j;
        this.mdf[KF] = j2;
        this.mde[KF] = i2;
        this.miu[KF] = i;
        this.mrH[KF] = aVar;
        this.mrI[KF] = this.mrQ;
        this.mrG[KF] = this.mrR;
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
            int i4 = this.capacity - this.mrK;
            System.arraycopy(this.mdf, this.mrK, jArr, 0, i4);
            System.arraycopy(this.mdh, this.mrK, jArr2, 0, i4);
            System.arraycopy(this.miu, this.mrK, iArr2, 0, i4);
            System.arraycopy(this.mde, this.mrK, iArr3, 0, i4);
            System.arraycopy(this.mrH, this.mrK, aVarArr, 0, i4);
            System.arraycopy(this.mrI, this.mrK, formatArr, 0, i4);
            System.arraycopy(this.mrG, this.mrK, iArr, 0, i4);
            int i5 = this.mrK;
            System.arraycopy(this.mdf, 0, jArr, i4, i5);
            System.arraycopy(this.mdh, 0, jArr2, i4, i5);
            System.arraycopy(this.miu, 0, iArr2, i4, i5);
            System.arraycopy(this.mde, 0, iArr3, i4, i5);
            System.arraycopy(this.mrH, 0, aVarArr, i4, i5);
            System.arraycopy(this.mrI, 0, formatArr, i4, i5);
            System.arraycopy(this.mrG, 0, iArr, i4, i5);
            this.mdf = jArr;
            this.mdh = jArr2;
            this.miu = iArr2;
            this.mde = iArr3;
            this.mrH = aVarArr;
            this.mrI = formatArr;
            this.mrG = iArr;
            this.mrK = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gi(long j) {
        this.mrN = Math.max(this.mrN, j);
    }

    public synchronized boolean gj(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.mrM) {
                    z = false;
                }
            } else if (Math.max(this.mrM, KE(this.mrL)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int KF = KF(this.length - 1);
                while (i > this.mrL && this.mdh[KF] >= j) {
                    i--;
                    KF--;
                    if (KF == -1) {
                        KF = this.capacity - 1;
                    }
                }
                KB(this.mrJ + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.mdh[i] <= j) {
            if (!z || (this.miu[i] & 1) != 0) {
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

    private long KD(int i) {
        int i2;
        this.mrM = Math.max(this.mrM, KE(i));
        this.length -= i;
        this.mrJ += i;
        this.mrK += i;
        if (this.mrK >= this.capacity) {
            this.mrK -= this.capacity;
        }
        this.mrL -= i;
        if (this.mrL < 0) {
            this.mrL = 0;
        }
        if (this.length == 0) {
            return this.mde[i2] + this.mdf[(this.mrK == 0 ? this.capacity : this.mrK) - 1];
        }
        return this.mdf[this.mrK];
    }

    private long KE(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int KF = KF(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.mdh[KF]);
            if ((this.miu[KF] & 1) != 0) {
                return max;
            }
            int i3 = KF - 1;
            if (i3 == -1) {
                i3 = this.capacity - 1;
            }
            i2++;
            KF = i3;
            j = max;
        }
        return j;
    }

    private int KF(int i) {
        int i2 = this.mrK + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
