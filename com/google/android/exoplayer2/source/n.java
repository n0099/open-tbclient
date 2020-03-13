package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n {
    private int length;
    private int msI;
    private int msJ;
    private int msK;
    private Format msP;
    private int msQ;
    private int capacity = 1000;
    private int[] msF = new int[this.capacity];
    private long[] med = new long[this.capacity];
    private long[] mef = new long[this.capacity];
    private int[] mjs = new int[this.capacity];
    private int[] mec = new int[this.capacity];
    private m.a[] msG = new m.a[this.capacity];
    private Format[] msH = new Format[this.capacity];
    private long msL = Long.MIN_VALUE;
    private long msM = Long.MIN_VALUE;
    private boolean msO = true;
    private boolean msN = true;

    /* loaded from: classes6.dex */
    public static final class a {
        public m.a mgm;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.msI = 0;
        this.msJ = 0;
        this.msK = 0;
        this.msN = true;
        this.msL = Long.MIN_VALUE;
        this.msM = Long.MIN_VALUE;
        if (z) {
            this.msP = null;
            this.msO = true;
        }
    }

    public int dww() {
        return this.msI + this.length;
    }

    public long KG(int i) {
        int KK;
        int dww = dww() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dww >= 0 && dww <= this.length - this.msK);
        this.length -= dww;
        this.msM = Math.max(this.msL, KJ(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.mec[KK] + this.med[KK(this.length - 1)];
    }

    public void KH(int i) {
        this.msQ = i;
    }

    public int dwx() {
        return this.msI + this.msK;
    }

    public int dwy() {
        return dwz() ? this.msF[KK(this.msK)] : this.msQ;
    }

    public synchronized boolean dwz() {
        return this.msK != this.length;
    }

    public synchronized Format dwA() {
        return this.msO ? null : this.msP;
    }

    public synchronized long dws() {
        return this.msM;
    }

    public synchronized void rewind() {
        this.msK = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dwz()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.msP == null || (!z && this.msP == format)) {
                    i = -3;
                } else {
                    mVar.lZJ = this.msP;
                    i = -5;
                }
            } else {
                int KK = KK(this.msK);
                if (z || this.msH[KK] != format) {
                    mVar.lZJ = this.msH[KK];
                    i = -5;
                } else if (eVar.duE()) {
                    i = -3;
                } else {
                    eVar.mdO = this.mef[KK];
                    eVar.setFlags(this.mjs[KK]);
                    aVar.size = this.mec[KK];
                    aVar.offset = this.med[KK];
                    aVar.mgm = this.msG[KK];
                    this.msK++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int KK = KK(this.msK);
            if (dwz() && j >= this.mef[KK] && ((j <= this.msM || z2) && (a2 = a(KK, this.length - this.msK, j, z)) != -1)) {
                this.msK += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dwB() {
        int i;
        i = this.length - this.msK;
        this.msK = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.mef[this.msJ]) {
            j2 = -1;
        } else {
            int a2 = a(this.msJ, (!z2 || this.msK == this.length) ? this.length : this.msK + 1, j, z);
            j2 = a2 == -1 ? -1L : KI(a2);
        }
        return j2;
    }

    public synchronized long dwC() {
        return this.msK == 0 ? -1L : KI(this.msK);
    }

    public synchronized long dwD() {
        return this.length == 0 ? -1L : KI(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.msO = true;
            } else {
                this.msO = false;
                if (!v.h(format, this.msP)) {
                    this.msP = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.msN) {
            if ((i & 1) != 0) {
                this.msN = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.msO);
        gg(j);
        int KK = KK(this.length);
        this.mef[KK] = j;
        this.med[KK] = j2;
        this.mec[KK] = i2;
        this.mjs[KK] = i;
        this.msG[KK] = aVar;
        this.msH[KK] = this.msP;
        this.msF[KK] = this.msQ;
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
            int i4 = this.capacity - this.msJ;
            System.arraycopy(this.med, this.msJ, jArr, 0, i4);
            System.arraycopy(this.mef, this.msJ, jArr2, 0, i4);
            System.arraycopy(this.mjs, this.msJ, iArr2, 0, i4);
            System.arraycopy(this.mec, this.msJ, iArr3, 0, i4);
            System.arraycopy(this.msG, this.msJ, aVarArr, 0, i4);
            System.arraycopy(this.msH, this.msJ, formatArr, 0, i4);
            System.arraycopy(this.msF, this.msJ, iArr, 0, i4);
            int i5 = this.msJ;
            System.arraycopy(this.med, 0, jArr, i4, i5);
            System.arraycopy(this.mef, 0, jArr2, i4, i5);
            System.arraycopy(this.mjs, 0, iArr2, i4, i5);
            System.arraycopy(this.mec, 0, iArr3, i4, i5);
            System.arraycopy(this.msG, 0, aVarArr, i4, i5);
            System.arraycopy(this.msH, 0, formatArr, i4, i5);
            System.arraycopy(this.msF, 0, iArr, i4, i5);
            this.med = jArr;
            this.mef = jArr2;
            this.mjs = iArr2;
            this.mec = iArr3;
            this.msG = aVarArr;
            this.msH = formatArr;
            this.msF = iArr;
            this.msJ = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gg(long j) {
        this.msM = Math.max(this.msM, j);
    }

    public synchronized boolean gh(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.msL) {
                    z = false;
                }
            } else if (Math.max(this.msL, KJ(this.msK)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int KK = KK(this.length - 1);
                while (i > this.msK && this.mef[KK] >= j) {
                    i--;
                    KK--;
                    if (KK == -1) {
                        KK = this.capacity - 1;
                    }
                }
                KG(this.msI + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.mef[i] <= j) {
            if (!z || (this.mjs[i] & 1) != 0) {
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

    private long KI(int i) {
        int i2;
        this.msL = Math.max(this.msL, KJ(i));
        this.length -= i;
        this.msI += i;
        this.msJ += i;
        if (this.msJ >= this.capacity) {
            this.msJ -= this.capacity;
        }
        this.msK -= i;
        if (this.msK < 0) {
            this.msK = 0;
        }
        if (this.length == 0) {
            return this.mec[i2] + this.med[(this.msJ == 0 ? this.capacity : this.msJ) - 1];
        }
        return this.med[this.msJ];
    }

    private long KJ(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int KK = KK(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.mef[KK]);
            if ((this.mjs[KK] & 1) != 0) {
                return max;
            }
            int i3 = KK - 1;
            if (i3 == -1) {
                i3 = this.capacity - 1;
            }
            i2++;
            KK = i3;
            j = max;
        }
        return j;
    }

    private int KK(int i) {
        int i2 = this.msJ + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
