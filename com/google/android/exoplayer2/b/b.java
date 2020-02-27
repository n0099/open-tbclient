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
    protected final t mCC;
    protected final int[] mCD;
    private final long[] mCE;
    private final Format[] msu;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.mCC = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.msu = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.msu[i] = tVar.KQ(iArr[i]);
        }
        Arrays.sort(this.msu, new a());
        this.mCD = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.mCD[i2] = tVar.m(this.msu[i2]);
        }
        this.mCE = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t dxd() {
        return this.mCC;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.mCD.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KQ(int i) {
        return this.msu[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int LG(int i) {
        return this.mCD[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.msu[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.mCD[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dyv() {
        return this.msu[dxh()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dyw() {
        return this.mCD[dxh()];
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
            this.mCE[i] = Math.max(this.mCE[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean I(int i, long j) {
        return this.mCE[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.mCC) * 31) + Arrays.hashCode(this.mCD);
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
        return this.mCC == bVar.mCC && Arrays.equals(this.mCD, bVar.mCD);
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
