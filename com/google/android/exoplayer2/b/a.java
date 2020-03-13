package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes6.dex */
public class a extends b {
    private int hxo;
    private final com.google.android.exoplayer2.upstream.c mCF;
    private final int mCG;
    private final long mCH;
    private final long mCI;
    private final long mCJ;
    private final float mCK;
    private final float mCL;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0671a implements f.a {
        private final com.google.android.exoplayer2.upstream.c mCF;
        private final int mCG;
        private final float mCK;
        private final float mCL;
        private final int mCM;
        private final int mCN;
        private final int mCO;

        public C0671a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0671a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mCF = cVar;
            this.mCG = i;
            this.mCM = i2;
            this.mCN = i3;
            this.mCO = i4;
            this.mCK = f;
            this.mCL = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mCF, this.mCG, this.mCM, this.mCN, this.mCO, this.mCK, this.mCL);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mCF = cVar;
        this.mCG = i;
        this.mCH = 1000 * j;
        this.mCI = 1000 * j2;
        this.mCJ = 1000 * j3;
        this.mCK = f;
        this.mCL = f2;
        this.hxo = gB(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void g(long j, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.hxo;
        this.hxo = gB(elapsedRealtime);
        if (this.hxo != i) {
            if (!I(i, elapsedRealtime)) {
                Format KQ = KQ(i);
                Format KQ2 = KQ(this.hxo);
                if (KQ2.bitrate > KQ.bitrate && j2 < gC(j3)) {
                    this.hxo = i;
                } else if (KQ2.bitrate < KQ.bitrate && j2 >= this.mCI) {
                    this.hxo = i;
                }
            }
            if (this.hxo != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxk() {
        return this.hxo;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxl() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dxm() {
        return null;
    }

    private int gB(long j) {
        long dyV;
        long j2 = this.mCF.dyV() == -1 ? this.mCG : ((float) dyV) * this.mCK;
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
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mCH ? 1 : (j == this.mCH ? 0 : -1)) <= 0 ? ((float) j) * this.mCL : this.mCH;
    }
}
