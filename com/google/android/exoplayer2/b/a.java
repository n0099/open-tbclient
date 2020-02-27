package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes6.dex */
public class a extends b {
    private int hxa;
    private final com.google.android.exoplayer2.upstream.c mCr;
    private final int mCs;
    private final long mCt;
    private final long mCu;
    private final long mCw;
    private final float mCx;
    private final float mCy;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0671a implements f.a {
        private final int mCA;
        private final int mCB;
        private final com.google.android.exoplayer2.upstream.c mCr;
        private final int mCs;
        private final float mCx;
        private final float mCy;
        private final int mCz;

        public C0671a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0671a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mCr = cVar;
            this.mCs = i;
            this.mCz = i2;
            this.mCA = i3;
            this.mCB = i4;
            this.mCx = f;
            this.mCy = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mCr, this.mCs, this.mCz, this.mCA, this.mCB, this.mCx, this.mCy);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mCr = cVar;
        this.mCs = i;
        this.mCt = 1000 * j;
        this.mCu = 1000 * j2;
        this.mCw = 1000 * j3;
        this.mCx = f;
        this.mCy = f2;
        this.hxa = gB(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void g(long j, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.hxa;
        this.hxa = gB(elapsedRealtime);
        if (this.hxa != i) {
            if (!I(i, elapsedRealtime)) {
                Format KQ = KQ(i);
                Format KQ2 = KQ(this.hxa);
                if (KQ2.bitrate > KQ.bitrate && j2 < gC(j3)) {
                    this.hxa = i;
                } else if (KQ2.bitrate < KQ.bitrate && j2 >= this.mCu) {
                    this.hxa = i;
                }
            }
            if (this.hxa != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxh() {
        return this.hxa;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxi() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dxj() {
        return null;
    }

    private int gB(long j) {
        long dyS;
        long j2 = this.mCr.dyS() == -1 ? this.mCs : ((float) dyS) * this.mCx;
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !I(i2, j)) {
                if (KQ(i2).bitrate <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long gC(long j) {
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mCt ? 1 : (j == this.mCt ? 0 : -1)) <= 0 ? ((float) j) * this.mCy : this.mCt;
    }
}
