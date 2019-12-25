package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.t;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes4.dex */
public abstract class b implements f {
    private int hashCode;
    protected final int length;
    private final Format[] mnT;
    protected final t myb;
    protected final int[] myc;
    private final long[] myd;

    public b(t tVar, int... iArr) {
        com.google.android.exoplayer2.util.a.checkState(iArr.length > 0);
        this.myb = (t) com.google.android.exoplayer2.util.a.checkNotNull(tVar);
        this.length = iArr.length;
        this.mnT = new Format[this.length];
        for (int i = 0; i < iArr.length; i++) {
            this.mnT[i] = tVar.KC(iArr[i]);
        }
        Arrays.sort(this.mnT, new a());
        this.myc = new int[this.length];
        for (int i2 = 0; i2 < this.length; i2++) {
            this.myc[i2] = tVar.m(this.mnT[i2]);
        }
        this.myd = new long[this.length];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final t duG() {
        return this.myb;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int length() {
        return this.myc.length;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format KC(int i) {
        return this.mnT[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int Ls(int i) {
        return this.myc[i];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int m(Format format) {
        for (int i = 0; i < this.length; i++) {
            if (this.mnT[i] == format) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.myc[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public final Format dvY() {
        return this.mnT[duK()];
    }

    @Override // com.google.android.exoplayer2.b.f
    public final int dvZ() {
        return this.myc[duK()];
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
            this.myd[i] = Math.max(this.myd[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J(int i, long j) {
        return this.myd[i] > j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.myb) * 31) + Arrays.hashCode(this.myc);
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
        return this.myb == bVar.myb && Arrays.equals(this.myc, bVar.myc);
    }

    /* loaded from: classes4.dex */
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
