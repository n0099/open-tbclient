package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
final class n {
    private int length;
    private int mrO;
    private int mrP;
    private int mrQ;
    private Format mrV;
    private int mrW;
    private int capacity = 1000;
    private int[] mrL = new int[this.capacity];
    private long[] mdk = new long[this.capacity];
    private long[] mdm = new long[this.capacity];
    private int[] miz = new int[this.capacity];
    private int[] mdj = new int[this.capacity];
    private m.a[] mrM = new m.a[this.capacity];
    private Format[] mrN = new Format[this.capacity];
    private long mrR = Long.MIN_VALUE;
    private long mrS = Long.MIN_VALUE;
    private boolean mrU = true;
    private boolean mrT = true;

    /* loaded from: classes5.dex */
    public static final class a {
        public m.a mft;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.mrO = 0;
        this.mrP = 0;
        this.mrQ = 0;
        this.mrT = true;
        this.mrR = Long.MIN_VALUE;
        this.mrS = Long.MIN_VALUE;
        if (z) {
            this.mrV = null;
            this.mrU = true;
        }
    }

    public int dvj() {
        return this.mrO + this.length;
    }

    public long KB(int i) {
        int KF;
        int dvj = dvj() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dvj >= 0 && dvj <= this.length - this.mrQ);
        this.length -= dvj;
        this.mrS = Math.max(this.mrR, KE(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.mdj[KF] + this.mdk[KF(this.length - 1)];
    }

    public void KC(int i) {
        this.mrW = i;
    }

    public int dvk() {
        return this.mrO + this.mrQ;
    }

    public int dvl() {
        return dvm() ? this.mrL[KF(this.mrQ)] : this.mrW;
    }

    public synchronized boolean dvm() {
        return this.mrQ != this.length;
    }

    public synchronized Format dvn() {
        return this.mrU ? null : this.mrV;
    }

    public synchronized long dvf() {
        return this.mrS;
    }

    public synchronized void rewind() {
        this.mrQ = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dvm()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.mrV == null || (!z && this.mrV == format)) {
                    i = -3;
                } else {
                    mVar.lYQ = this.mrV;
                    i = -5;
                }
            } else {
                int KF = KF(this.mrQ);
                if (z || this.mrN[KF] != format) {
                    mVar.lYQ = this.mrN[KF];
                    i = -5;
                } else if (eVar.dtq()) {
                    i = -3;
                } else {
                    eVar.mcV = this.mdm[KF];
                    eVar.setFlags(this.miz[KF]);
                    aVar.size = this.mdj[KF];
                    aVar.offset = this.mdk[KF];
                    aVar.mft = this.mrM[KF];
                    this.mrQ++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int KF = KF(this.mrQ);
            if (dvm() && j >= this.mdm[KF] && ((j <= this.mrS || z2) && (a2 = a(KF, this.length - this.mrQ, j, z)) != -1)) {
                this.mrQ += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dvo() {
        int i;
        i = this.length - this.mrQ;
        this.mrQ = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.mdm[this.mrP]) {
            j2 = -1;
        } else {
            int a2 = a(this.mrP, (!z2 || this.mrQ == this.length) ? this.length : this.mrQ + 1, j, z);
            j2 = a2 == -1 ? -1L : KD(a2);
        }
        return j2;
    }

    public synchronized long dvp() {
        return this.mrQ == 0 ? -1L : KD(this.mrQ);
    }

    public synchronized long dvq() {
        return this.length == 0 ? -1L : KD(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.mrU = true;
            } else {
                this.mrU = false;
                if (!v.h(format, this.mrV)) {
                    this.mrV = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.mrT) {
            if ((i & 1) != 0) {
                this.mrT = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.mrU);
        gi(j);
        int KF = KF(this.length);
        this.mdm[KF] = j;
        this.mdk[KF] = j2;
        this.mdj[KF] = i2;
        this.miz[KF] = i;
        this.mrM[KF] = aVar;
        this.mrN[KF] = this.mrV;
        this.mrL[KF] = this.mrW;
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
            int i4 = this.capacity - this.mrP;
            System.arraycopy(this.mdk, this.mrP, jArr, 0, i4);
            System.arraycopy(this.mdm, this.mrP, jArr2, 0, i4);
            System.arraycopy(this.miz, this.mrP, iArr2, 0, i4);
            System.arraycopy(this.mdj, this.mrP, iArr3, 0, i4);
            System.arraycopy(this.mrM, this.mrP, aVarArr, 0, i4);
            System.arraycopy(this.mrN, this.mrP, formatArr, 0, i4);
            System.arraycopy(this.mrL, this.mrP, iArr, 0, i4);
            int i5 = this.mrP;
            System.arraycopy(this.mdk, 0, jArr, i4, i5);
            System.arraycopy(this.mdm, 0, jArr2, i4, i5);
            System.arraycopy(this.miz, 0, iArr2, i4, i5);
            System.arraycopy(this.mdj, 0, iArr3, i4, i5);
            System.arraycopy(this.mrM, 0, aVarArr, i4, i5);
            System.arraycopy(this.mrN, 0, formatArr, i4, i5);
            System.arraycopy(this.mrL, 0, iArr, i4, i5);
            this.mdk = jArr;
            this.mdm = jArr2;
            this.miz = iArr2;
            this.mdj = iArr3;
            this.mrM = aVarArr;
            this.mrN = formatArr;
            this.mrL = iArr;
            this.mrP = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gi(long j) {
        this.mrS = Math.max(this.mrS, j);
    }

    public synchronized boolean gj(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.mrR) {
                    z = false;
                }
            } else if (Math.max(this.mrR, KE(this.mrQ)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int KF = KF(this.length - 1);
                while (i > this.mrQ && this.mdm[KF] >= j) {
                    i--;
                    KF--;
                    if (KF == -1) {
                        KF = this.capacity - 1;
                    }
                }
                KB(this.mrO + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.mdm[i] <= j) {
            if (!z || (this.miz[i] & 1) != 0) {
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
        this.mrR = Math.max(this.mrR, KE(i));
        this.length -= i;
        this.mrO += i;
        this.mrP += i;
        if (this.mrP >= this.capacity) {
            this.mrP -= this.capacity;
        }
        this.mrQ -= i;
        if (this.mrQ < 0) {
            this.mrQ = 0;
        }
        if (this.length == 0) {
            return this.mdj[i2] + this.mdk[(this.mrP == 0 ? this.capacity : this.mrP) - 1];
        }
        return this.mdk[this.mrP];
    }

    private long KE(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int KF = KF(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.mdm[KF]);
            if ((this.miz[KF] & 1) != 0) {
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
        int i2 = this.mrP + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
