package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class n {
    private int length;
    private Format msE;
    private int msF;
    private int msx;
    private int msy;
    private int msz;
    private int capacity = 1000;
    private int[] msu = new int[this.capacity];
    private long[] mdS = new long[this.capacity];
    private long[] mdU = new long[this.capacity];
    private int[] mjh = new int[this.capacity];
    private int[] mdR = new int[this.capacity];
    private m.a[] msv = new m.a[this.capacity];
    private Format[] msw = new Format[this.capacity];
    private long msA = Long.MIN_VALUE;
    private long msB = Long.MIN_VALUE;
    private boolean msD = true;
    private boolean msC = true;

    /* loaded from: classes6.dex */
    public static final class a {
        public m.a mgb;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.msx = 0;
        this.msy = 0;
        this.msz = 0;
        this.msC = true;
        this.msA = Long.MIN_VALUE;
        this.msB = Long.MIN_VALUE;
        if (z) {
            this.msE = null;
            this.msD = true;
        }
    }

    public int dwv() {
        return this.msx + this.length;
    }

    public long KG(int i) {
        int KK;
        int dwv = dwv() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dwv >= 0 && dwv <= this.length - this.msz);
        this.length -= dwv;
        this.msB = Math.max(this.msA, KJ(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.mdR[KK] + this.mdS[KK(this.length - 1)];
    }

    public void KH(int i) {
        this.msF = i;
    }

    public int dww() {
        return this.msx + this.msz;
    }

    public int dwx() {
        return dwy() ? this.msu[KK(this.msz)] : this.msF;
    }

    public synchronized boolean dwy() {
        return this.msz != this.length;
    }

    public synchronized Format dwz() {
        return this.msD ? null : this.msE;
    }

    public synchronized long dwr() {
        return this.msB;
    }

    public synchronized void rewind() {
        this.msz = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dwy()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.msE == null || (!z && this.msE == format)) {
                    i = -3;
                } else {
                    mVar.lZy = this.msE;
                    i = -5;
                }
            } else {
                int KK = KK(this.msz);
                if (z || this.msw[KK] != format) {
                    mVar.lZy = this.msw[KK];
                    i = -5;
                } else if (eVar.duD()) {
                    i = -3;
                } else {
                    eVar.mdD = this.mdU[KK];
                    eVar.setFlags(this.mjh[KK]);
                    aVar.size = this.mdR[KK];
                    aVar.offset = this.mdS[KK];
                    aVar.mgb = this.msv[KK];
                    this.msz++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int KK = KK(this.msz);
            if (dwy() && j >= this.mdU[KK] && ((j <= this.msB || z2) && (a2 = a(KK, this.length - this.msz, j, z)) != -1)) {
                this.msz += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dwA() {
        int i;
        i = this.length - this.msz;
        this.msz = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.mdU[this.msy]) {
            j2 = -1;
        } else {
            int a2 = a(this.msy, (!z2 || this.msz == this.length) ? this.length : this.msz + 1, j, z);
            j2 = a2 == -1 ? -1L : KI(a2);
        }
        return j2;
    }

    public synchronized long dwB() {
        return this.msz == 0 ? -1L : KI(this.msz);
    }

    public synchronized long dwC() {
        return this.length == 0 ? -1L : KI(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.msD = true;
            } else {
                this.msD = false;
                if (!v.h(format, this.msE)) {
                    this.msE = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.msC) {
            if ((i & 1) != 0) {
                this.msC = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.msD);
        gg(j);
        int KK = KK(this.length);
        this.mdU[KK] = j;
        this.mdS[KK] = j2;
        this.mdR[KK] = i2;
        this.mjh[KK] = i;
        this.msv[KK] = aVar;
        this.msw[KK] = this.msE;
        this.msu[KK] = this.msF;
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
            int i4 = this.capacity - this.msy;
            System.arraycopy(this.mdS, this.msy, jArr, 0, i4);
            System.arraycopy(this.mdU, this.msy, jArr2, 0, i4);
            System.arraycopy(this.mjh, this.msy, iArr2, 0, i4);
            System.arraycopy(this.mdR, this.msy, iArr3, 0, i4);
            System.arraycopy(this.msv, this.msy, aVarArr, 0, i4);
            System.arraycopy(this.msw, this.msy, formatArr, 0, i4);
            System.arraycopy(this.msu, this.msy, iArr, 0, i4);
            int i5 = this.msy;
            System.arraycopy(this.mdS, 0, jArr, i4, i5);
            System.arraycopy(this.mdU, 0, jArr2, i4, i5);
            System.arraycopy(this.mjh, 0, iArr2, i4, i5);
            System.arraycopy(this.mdR, 0, iArr3, i4, i5);
            System.arraycopy(this.msv, 0, aVarArr, i4, i5);
            System.arraycopy(this.msw, 0, formatArr, i4, i5);
            System.arraycopy(this.msu, 0, iArr, i4, i5);
            this.mdS = jArr;
            this.mdU = jArr2;
            this.mjh = iArr2;
            this.mdR = iArr3;
            this.msv = aVarArr;
            this.msw = formatArr;
            this.msu = iArr;
            this.msy = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gg(long j) {
        this.msB = Math.max(this.msB, j);
    }

    public synchronized boolean gh(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.msA) {
                    z = false;
                }
            } else if (Math.max(this.msA, KJ(this.msz)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int KK = KK(this.length - 1);
                while (i > this.msz && this.mdU[KK] >= j) {
                    i--;
                    KK--;
                    if (KK == -1) {
                        KK = this.capacity - 1;
                    }
                }
                KG(this.msx + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.mdU[i] <= j) {
            if (!z || (this.mjh[i] & 1) != 0) {
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
        this.msA = Math.max(this.msA, KJ(i));
        this.length -= i;
        this.msx += i;
        this.msy += i;
        if (this.msy >= this.capacity) {
            this.msy -= this.capacity;
        }
        this.msz -= i;
        if (this.msz < 0) {
            this.msz = 0;
        }
        if (this.length == 0) {
            return this.mdR[i2] + this.mdS[(this.msy == 0 ? this.capacity : this.msy) - 1];
        }
        return this.mdS[this.msy];
    }

    private long KJ(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int KK = KK(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.mdU[KK]);
            if ((this.mjh[KK] & 1) != 0) {
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
        int i2 = this.msy + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
