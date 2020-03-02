package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.t;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes6.dex */
public abstract class b implements f {
    private int hashCode;
    protected final int length;
    protected final t mCE;
    protected final int[] mCF;
    private final long[] mCG;
    private final Format[] msw;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.mCE = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.msw = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.msw[i] = tVar.KQ(iArr[i]);
        }
        Arrays.sort(this.msw, new a());
        this.mCF = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.mCF[i2] = tVar.m(this.msw[i2]);
        }
        this.mCG = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t dxf() {
        return this.mCE;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.mCF.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KQ(int i) {
        return this.msw[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int LG(int i) {
        return this.mCF[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.msw[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.mCF[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dyx() {
        return this.msw[dxj()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dyy() {
        return this.mCF[dxj()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final boolean H(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean I = I(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !I) {
            I = (i2 == i || I(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (I) {
            this.mCG[i] = Math.max(this.mCG[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean I(int i, long j) {
        return this.mCG[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.mCE) * 31) + Arrays.hashCode(this.mCF);
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
        return this.mCE == bVar.mCE && Arrays.equals(this.mCF, bVar.mCF);
    }

    /* loaded from: classes6.dex */
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
