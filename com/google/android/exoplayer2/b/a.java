package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes5.dex */
public class a extends b {
    private int hvb;
    private final com.google.android.exoplayer2.upstream.c mBL;
    private final int mBM;
    private final long mBN;
    private final long mBO;
    private final long mBP;
    private final float mBQ;
    private final float mBR;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0663a implements f.a {
        private final com.google.android.exoplayer2.upstream.c mBL;
        private final int mBM;
        private final float mBQ;
        private final float mBR;
        private final int mBS;
        private final int mBT;
        private final int mBU;

        public C0663a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0663a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mBL = cVar;
            this.mBM = i;
            this.mBS = i2;
            this.mBT = i3;
            this.mBU = i4;
            this.mBQ = f;
            this.mBR = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mBL, this.mBM, this.mBS, this.mBT, this.mBU, this.mBQ, this.mBR);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mBL = cVar;
        this.mBM = i;
        this.mBN = 1000 * j;
        this.mBO = 1000 * j2;
        this.mBP = 1000 * j3;
        this.mBQ = f;
        this.mBR = f2;
        this.hvb = gD(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void f(long j, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.hvb;
        this.hvb = gD(elapsedRealtime);
        if (this.hvb != i) {
            if (!J(i, elapsedRealtime)) {
                Format KL = KL(i);
                Format KL2 = KL(this.hvb);
                if (KL2.bitrate > KL.bitrate && j2 < gE(j3)) {
                    this.hvb = i;
                } else if (KL2.bitrate < KL.bitrate && j2 >= this.mBO) {
                    this.hvb = i;
                }
            }
            if (this.hvb != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dvX() {
        return this.hvb;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dvY() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dvZ() {
        return null;
    }

    private int gD(long j) {
        long dxI;
        long j2 = this.mBL.dxI() == -1 ? this.mBM : ((float) dxI) * this.mBQ;
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !J(i2, j)) {
                if (KL(i2).bitrate <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long gE(long j) {
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mBN ? 1 : (j == this.mBN ? 0 : -1)) <= 0 ? ((float) j) * this.mBR : this.mBN;
    }
}
