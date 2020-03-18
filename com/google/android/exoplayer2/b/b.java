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
    private final long[] mEA;
    protected final t mEy;
    protected final int[] mEz;
    private final Format[] muo;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.mEy = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.muo = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.muo[i] = tVar.KW(iArr[i]);
        }
        Arrays.sort(this.muo, new a());
        this.mEz = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.mEz[i2] = tVar.m(this.muo[i2]);
        }
        this.mEA = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t dxD() {
        return this.mEy;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.mEz.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KW(int i) {
        return this.muo[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int LM(int i) {
        return this.mEz[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.muo[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.mEz[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dyV() {
        return this.muo[dxH()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dyW() {
        return this.mEz[dxH()];
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
            this.mEA[i] = Math.max(this.mEA[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean I(int i, long j) {
        return this.mEA[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.mEy) * 31) + Arrays.hashCode(this.mEz);
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
        return this.mEy == bVar.mEy && Arrays.equals(this.mEz, bVar.mEz);
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
