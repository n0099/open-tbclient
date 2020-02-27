package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n {
    private int length;
    private Format msC;
    private int msD;
    private int msv;
    private int msw;
    private int msx;
    private int capacity = 1000;
    private int[] mss = new int[this.capacity];
    private long[] mdQ = new long[this.capacity];
    private long[] mdS = new long[this.capacity];
    private int[] mjf = new int[this.capacity];
    private int[] mdP = new int[this.capacity];
    private m.a[] mst = new m.a[this.capacity];
    private Format[] msu = new Format[this.capacity];
    private long msy = Long.MIN_VALUE;
    private long msz = Long.MIN_VALUE;
    private boolean msB = true;
    private boolean msA = true;

    /* loaded from: classes6.dex */
    public static final class a {
        public m.a mfZ;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.msv = 0;
        this.msw = 0;
        this.msx = 0;
        this.msA = true;
        this.msy = Long.MIN_VALUE;
        this.msz = Long.MIN_VALUE;
        if (z) {
            this.msC = null;
            this.msB = true;
        }
    }

    public int dwt() {
        return this.msv + this.length;
    }

    public long KG(int i) {
        int KK;
        int dwt = dwt() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dwt >= 0 && dwt <= this.length - this.msx);
        this.length -= dwt;
        this.msz = Math.max(this.msy, KJ(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.mdP[KK] + this.mdQ[KK(this.length - 1)];
    }

    public void KH(int i) {
        this.msD = i;
    }

    public int dwu() {
        return this.msv + this.msx;
    }

    public int dwv() {
        return dww() ? this.mss[KK(this.msx)] : this.msD;
    }

    public synchronized boolean dww() {
        return this.msx != this.length;
    }

    public synchronized Format dwx() {
        return this.msB ? null : this.msC;
    }

    public synchronized long dwp() {
        return this.msz;
    }

    public synchronized void rewind() {
        this.msx = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dww()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.msC == null || (!z && this.msC == format)) {
                    i = -3;
                } else {
                    mVar.lZw = this.msC;
                    i = -5;
                }
            } else {
                int KK = KK(this.msx);
                if (z || this.msu[KK] != format) {
                    mVar.lZw = this.msu[KK];
                    i = -5;
                } else if (eVar.duB()) {
                    i = -3;
                } else {
                    eVar.mdB = this.mdS[KK];
                    eVar.setFlags(this.mjf[KK]);
                    aVar.size = this.mdP[KK];
                    aVar.offset = this.mdQ[KK];
                    aVar.mfZ = this.mst[KK];
                    this.msx++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int KK = KK(this.msx);
            if (dww() && j >= this.mdS[KK] && ((j <= this.msz || z2) && (a2 = a(KK, this.length - this.msx, j, z)) != -1)) {
                this.msx += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dwy() {
        int i;
        i = this.length - this.msx;
        this.msx = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.mdS[this.msw]) {
            j2 = -1;
        } else {
            int a2 = a(this.msw, (!z2 || this.msx == this.length) ? this.length : this.msx + 1, j, z);
            j2 = a2 == -1 ? -1L : KI(a2);
        }
        return j2;
    }

    public synchronized long dwz() {
        return this.msx == 0 ? -1L : KI(this.msx);
    }

    public synchronized long dwA() {
        return this.length == 0 ? -1L : KI(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.msB = true;
            } else {
                this.msB = false;
                if (!v.h(format, this.msC)) {
                    this.msC = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.msA) {
            if ((i & 1) != 0) {
                this.msA = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.msB);
        gg(j);
        int KK = KK(this.length);
        this.mdS[KK] = j;
        this.mdQ[KK] = j2;
        this.mdP[KK] = i2;
        this.mjf[KK] = i;
        this.mst[KK] = aVar;
        this.msu[KK] = this.msC;
        this.mss[KK] = this.msD;
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
            int i4 = this.capacity - this.msw;
            System.arraycopy(this.mdQ, this.msw, jArr, 0, i4);
            System.arraycopy(this.mdS, this.msw, jArr2, 0, i4);
            System.arraycopy(this.mjf, this.msw, iArr2, 0, i4);
            System.arraycopy(this.mdP, this.msw, iArr3, 0, i4);
            System.arraycopy(this.mst, this.msw, aVarArr, 0, i4);
            System.arraycopy(this.msu, this.msw, formatArr, 0, i4);
            System.arraycopy(this.mss, this.msw, iArr, 0, i4);
            int i5 = this.msw;
            System.arraycopy(this.mdQ, 0, jArr, i4, i5);
            System.arraycopy(this.mdS, 0, jArr2, i4, i5);
            System.arraycopy(this.mjf, 0, iArr2, i4, i5);
            System.arraycopy(this.mdP, 0, iArr3, i4, i5);
            System.arraycopy(this.mst, 0, aVarArr, i4, i5);
            System.arraycopy(this.msu, 0, formatArr, i4, i5);
            System.arraycopy(this.mss, 0, iArr, i4, i5);
            this.mdQ = jArr;
            this.mdS = jArr2;
            this.mjf = iArr2;
            this.mdP = iArr3;
            this.mst = aVarArr;
            this.msu = formatArr;
            this.mss = iArr;
            this.msw = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gg(long j) {
        this.msz = Math.max(this.msz, j);
    }

    public synchronized boolean gh(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.msy) {
                    z = false;
                }
            } else if (Math.max(this.msy, KJ(this.msx)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int KK = KK(this.length - 1);
                while (i > this.msx && this.mdS[KK] >= j) {
                    i--;
                    KK--;
                    if (KK == -1) {
                        KK = this.capacity - 1;
                    }
                }
                KG(this.msv + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.mdS[i] <= j) {
            if (!z || (this.mjf[i] & 1) != 0) {
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
        this.msy = Math.max(this.msy, KJ(i));
        this.length -= i;
        this.msv += i;
        this.msw += i;
        if (this.msw >= this.capacity) {
            this.msw -= this.capacity;
        }
        this.msx -= i;
        if (this.msx < 0) {
            this.msx = 0;
        }
        if (this.length == 0) {
            return this.mdP[i2] + this.mdQ[(this.msw == 0 ? this.capacity : this.msw) - 1];
        }
        return this.mdQ[this.msw];
    }

    private long KJ(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int KK = KK(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.mdS[KK]);
            if ((this.mjf[KK] & 1) != 0) {
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
        int i2 = this.msw + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
