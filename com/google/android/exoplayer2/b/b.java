package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.t;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes5.dex */
public abstract class b implements f {
    private int hashCode;
    protected final int length;
    protected final t mBQ;
    protected final int[] mBR;
    private final long[] mBS;
    private final Format[] mrI;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.mBQ = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.mrI = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.mrI[i] = tVar.KL(iArr[i]);
        }
        Arrays.sort(this.mrI, new a());
        this.mBR = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.mBR[i2] = tVar.m(this.mrI[i2]);
        }
        this.mBS = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t dvR() {
        return this.mBQ;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.mBR.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KL(int i) {
        return this.mrI[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int LB(int i) {
        return this.mBR[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.mrI[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.mBR[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dxj() {
        return this.mrI[dvV()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dxk() {
        return this.mBR[dvV()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final boolean I(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean J = J(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !J) {
            J = (i2 == i || J(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (J) {
            this.mBS[i] = Math.max(this.mBS[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J(int i, long j) {
        return this.mBS[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.mBQ) * 31) + Arrays.hashCode(this.mBR);
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.mBQ == bVar.mBQ && Arrays.equals(this.mBR, bVar.mBR);
    }

    /* loaded from: classes5.dex */
    private static final class a implements Comparator<Format> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }
}
