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
    protected final t mCP;
    protected final int[] mCQ;
    private final long[] mCR;
    private final Format[] msH;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.mCP = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.msH = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.msH[i] = tVar.KQ(iArr[i]);
        }
        Arrays.sort(this.msH, new a());
        this.mCQ = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.mCQ[i2] = tVar.m(this.msH[i2]);
        }
        this.mCR = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t dxg() {
        return this.mCP;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.mCQ.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KQ(int i) {
        return this.msH[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int LG(int i) {
        return this.mCQ[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.msH[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.mCQ[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dyy() {
        return this.msH[dxk()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dyz() {
        return this.mCQ[dxk()];
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
            this.mCR[i] = Math.max(this.mCR[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean I(int i, long j) {
        return this.mCR[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.mCP) * 31) + Arrays.hashCode(this.mCQ);
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
        return this.mCP == bVar.mCP && Arrays.equals(this.mCQ, bVar.mCQ);
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
