package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes5.dex */
public class a extends b {
    private int hvb;
    private final com.google.android.exoplayer2.upstream.c mBG;
    private final int mBH;
    private final long mBI;
    private final long mBJ;
    private final long mBK;
    private final float mBL;
    private final float mBM;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0663a implements f.a {
        private final com.google.android.exoplayer2.upstream.c mBG;
        private final int mBH;
        private final float mBL;
        private final float mBM;
        private final int mBN;
        private final int mBO;
        private final int mBP;

        public C0663a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0663a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mBG = cVar;
            this.mBH = i;
            this.mBN = i2;
            this.mBO = i3;
            this.mBP = i4;
            this.mBL = f;
            this.mBM = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mBG, this.mBH, this.mBN, this.mBO, this.mBP, this.mBL, this.mBM);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mBG = cVar;
        this.mBH = i;
        this.mBI = 1000 * j;
        this.mBJ = 1000 * j2;
        this.mBK = 1000 * j3;
        this.mBL = f;
        this.mBM = f2;
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
                } else if (KL2.bitrate < KL.bitrate && j2 >= this.mBJ) {
                    this.hvb = i;
                }
            }
            if (this.hvb != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dvV() {
        return this.hvb;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dvW() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dvX() {
        return null;
    }

    private int gD(long j) {
        long dxG;
        long j2 = this.mBG.dxG() == -1 ? this.mBH : ((float) dxG) * this.mBL;
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
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mBI ? 1 : (j == this.mBI ? 0 : -1)) <= 0 ? ((float) j) * this.mBM : this.mBI;
    }
}
