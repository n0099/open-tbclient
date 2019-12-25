package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class n {
    private int length;
    private int mnU;
    private int mnV;
    private int mnW;
    private Format mob;
    private int moc;
    private int capacity = 1000;
    private int[] mnR = new int[this.capacity];
    private long[] lZn = new long[this.capacity];
    private long[] lZp = new long[this.capacity];
    private int[] meD = new int[this.capacity];
    private int[] lZm = new int[this.capacity];
    private m.a[] mnS = new m.a[this.capacity];
    private Format[] mnT = new Format[this.capacity];
    private long mnX = Long.MIN_VALUE;
    private long mnY = Long.MIN_VALUE;
    private boolean moa = true;
    private boolean mnZ = true;

    /* loaded from: classes4.dex */
    public static final class a {
        public m.a mbz;
        public long offset;
        public int size;
    }

    public void reset(boolean z) {
        this.length = 0;
        this.mnU = 0;
        this.mnV = 0;
        this.mnW = 0;
        this.mnZ = true;
        this.mnX = Long.MIN_VALUE;
        this.mnY = Long.MIN_VALUE;
        if (z) {
            this.mob = null;
            this.moa = true;
        }
    }

    public int dtW() {
        return this.mnU + this.length;
    }

    public long Ks(int i) {
        int Kw;
        int dtW = dtW() - i;
        com.google.android.exoplayer2.util.a.checkArgument(dtW >= 0 && dtW <= this.length - this.mnW);
        this.length -= dtW;
        this.mnY = Math.max(this.mnX, Kv(this.length));
        if (this.length == 0) {
            return 0L;
        }
        return this.lZm[Kw] + this.lZn[Kw(this.length - 1)];
    }

    public void Kt(int i) {
        this.moc = i;
    }

    public int dtX() {
        return this.mnU + this.mnW;
    }

    public int dtY() {
        return dtZ() ? this.mnR[Kw(this.mnW)] : this.moc;
    }

    public synchronized boolean dtZ() {
        return this.mnW != this.length;
    }

    public synchronized Format dua() {
        return this.moa ? null : this.mob;
    }

    public synchronized long dtS() {
        return this.mnY;
    }

    public synchronized void rewind() {
        this.mnW = 0;
    }

    public synchronized int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            if (!dtZ()) {
                if (z2) {
                    eVar.setFlags(4);
                } else if (this.mob == null || (!z && this.mob == format)) {
                    i = -3;
                } else {
                    mVar.lUU = this.mob;
                    i = -5;
                }
            } else {
                int Kw = Kw(this.mnW);
                if (z || this.mnT[Kw] != format) {
                    mVar.lUU = this.mnT[Kw];
                    i = -5;
                } else if (eVar.dsc()) {
                    i = -3;
                } else {
                    eVar.lYY = this.lZp[Kw];
                    eVar.setFlags(this.meD[Kw]);
                    aVar.size = this.lZm[Kw];
                    aVar.offset = this.lZn[Kw];
                    aVar.mbz = this.mnS[Kw];
                    this.mnW++;
                }
            }
        }
        return i;
    }

    public synchronized int a(long j, boolean z, boolean z2) {
        int a2;
        int i = -1;
        synchronized (this) {
            int Kw = Kw(this.mnW);
            if (dtZ() && j >= this.lZp[Kw] && ((j <= this.mnY || z2) && (a2 = a(Kw, this.length - this.mnW, j, z)) != -1)) {
                this.mnW += a2;
                i = a2;
            }
        }
        return i;
    }

    public synchronized int dub() {
        int i;
        i = this.length - this.mnW;
        this.mnW = this.length;
        return i;
    }

    public synchronized long b(long j, boolean z, boolean z2) {
        long j2;
        if (this.length == 0 || j < this.lZp[this.mnV]) {
            j2 = -1;
        } else {
            int a2 = a(this.mnV, (!z2 || this.mnW == this.length) ? this.length : this.mnW + 1, j, z);
            j2 = a2 == -1 ? -1L : Ku(a2);
        }
        return j2;
    }

    public synchronized long duc() {
        return this.mnW == 0 ? -1L : Ku(this.mnW);
    }

    public synchronized long dud() {
        return this.length == 0 ? -1L : Ku(this.length);
    }

    public synchronized boolean l(Format format) {
        boolean z = false;
        synchronized (this) {
            if (format == null) {
                this.moa = true;
            } else {
                this.moa = false;
                if (!v.h(format, this.mob)) {
                    this.mob = format;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void a(long j, int i, long j2, int i2, m.a aVar) {
        if (this.mnZ) {
            if ((i & 1) != 0) {
                this.mnZ = false;
            }
        }
        com.google.android.exoplayer2.util.a.checkState(!this.moa);
        gd(j);
        int Kw = Kw(this.length);
        this.lZp[Kw] = j;
        this.lZn[Kw] = j2;
        this.lZm[Kw] = i2;
        this.meD[Kw] = i;
        this.mnS[Kw] = aVar;
        this.mnT[Kw] = this.mob;
        this.mnR[Kw] = this.moc;
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
            int i4 = this.capacity - this.mnV;
            System.arraycopy(this.lZn, this.mnV, jArr, 0, i4);
            System.arraycopy(this.lZp, this.mnV, jArr2, 0, i4);
            System.arraycopy(this.meD, this.mnV, iArr2, 0, i4);
            System.arraycopy(this.lZm, this.mnV, iArr3, 0, i4);
            System.arraycopy(this.mnS, this.mnV, aVarArr, 0, i4);
            System.arraycopy(this.mnT, this.mnV, formatArr, 0, i4);
            System.arraycopy(this.mnR, this.mnV, iArr, 0, i4);
            int i5 = this.mnV;
            System.arraycopy(this.lZn, 0, jArr, i4, i5);
            System.arraycopy(this.lZp, 0, jArr2, i4, i5);
            System.arraycopy(this.meD, 0, iArr2, i4, i5);
            System.arraycopy(this.lZm, 0, iArr3, i4, i5);
            System.arraycopy(this.mnS, 0, aVarArr, i4, i5);
            System.arraycopy(this.mnT, 0, formatArr, i4, i5);
            System.arraycopy(this.mnR, 0, iArr, i4, i5);
            this.lZn = jArr;
            this.lZp = jArr2;
            this.meD = iArr2;
            this.lZm = iArr3;
            this.mnS = aVarArr;
            this.mnT = formatArr;
            this.mnR = iArr;
            this.mnV = 0;
            this.length = this.capacity;
            this.capacity = i3;
        }
    }

    public synchronized void gd(long j) {
        this.mnY = Math.max(this.mnY, j);
    }

    public synchronized boolean ge(long j) {
        boolean z = true;
        synchronized (this) {
            if (this.length == 0) {
                if (j <= this.mnX) {
                    z = false;
                }
            } else if (Math.max(this.mnX, Kv(this.mnW)) >= j) {
                z = false;
            } else {
                int i = this.length;
                int Kw = Kw(this.length - 1);
                while (i > this.mnW && this.lZp[Kw] >= j) {
                    i--;
                    Kw--;
                    if (Kw == -1) {
                        Kw = this.capacity - 1;
                    }
                }
                Ks(this.mnU + i);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.lZp[i] <= j) {
            if (!z || (this.meD[i] & 1) != 0) {
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

    private long Ku(int i) {
        int i2;
        this.mnX = Math.max(this.mnX, Kv(i));
        this.length -= i;
        this.mnU += i;
        this.mnV += i;
        if (this.mnV >= this.capacity) {
            this.mnV -= this.capacity;
        }
        this.mnW -= i;
        if (this.mnW < 0) {
            this.mnW = 0;
        }
        if (this.length == 0) {
            return this.lZm[i2] + this.lZn[(this.mnV == 0 ? this.capacity : this.mnV) - 1];
        }
        return this.lZn[this.mnV];
    }

    private long Kv(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 0;
        int Kw = Kw(i - 1);
        while (i2 < i) {
            long max = Math.max(j, this.lZp[Kw]);
            if ((this.meD[Kw] & 1) != 0) {
                return max;
            }
            int i3 = Kw - 1;
            if (i3 == -1) {
                i3 = this.capacity - 1;
            }
            i2++;
            Kw = i3;
            j = max;
        }
        return j;
    }

    private int Kw(int i) {
        int i2 = this.mnV + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
