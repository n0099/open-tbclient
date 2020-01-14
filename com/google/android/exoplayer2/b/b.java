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
    protected final t mBV;
    protected final int[] mBW;
    private final long[] mBX;
    private final Format[] mrN;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.mBV = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.mrN = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.mrN[i] = tVar.KL(iArr[i]);
        }
        Arrays.sort(this.mrN, new a());
        this.mBW = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.mBW[i2] = tVar.m(this.mrN[i2]);
        }
        this.mBX = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t dvT() {
        return this.mBV;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.mBW.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KL(int i) {
        return this.mrN[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int LB(int i) {
        return this.mBW[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.mrN[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.mBW[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dxl() {
        return this.mrN[dvX()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dxm() {
        return this.mBW[dvX()];
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
            this.mBX[i] = Math.max(this.mBX[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J(int i, long j) {
        return this.mBX[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.mBV) * 31) + Arrays.hashCode(this.mBW);
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
        return this.mBV == bVar.mBV && Arrays.equals(this.mBW, bVar.mBW);
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
