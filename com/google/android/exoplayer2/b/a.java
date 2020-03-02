package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes6.dex */
public class a extends b {
    private int hxc;
    private final float mCA;
    private final com.google.android.exoplayer2.upstream.c mCt;
    private final int mCu;
    private final long mCw;
    private final long mCx;
    private final long mCy;
    private final float mCz;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0671a implements f.a {
        private final float mCA;
        private final int mCB;
        private final int mCC;
        private final int mCD;
        private final com.google.android.exoplayer2.upstream.c mCt;
        private final int mCu;
        private final float mCz;

        public C0671a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0671a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mCt = cVar;
            this.mCu = i;
            this.mCB = i2;
            this.mCC = i3;
            this.mCD = i4;
            this.mCz = f;
            this.mCA = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mCt, this.mCu, this.mCB, this.mCC, this.mCD, this.mCz, this.mCA);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mCt = cVar;
        this.mCu = i;
        this.mCw = 1000 * j;
        this.mCx = 1000 * j2;
        this.mCy = 1000 * j3;
        this.mCz = f;
        this.mCA = f2;
        this.hxc = gB(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void g(long j, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.hxc;
        this.hxc = gB(elapsedRealtime);
        if (this.hxc != i) {
            if (!I(i, elapsedRealtime)) {
                Format KQ = KQ(i);
                Format KQ2 = KQ(this.hxc);
                if (KQ2.bitrate > KQ.bitrate && j2 < gC(j3)) {
                    this.hxc = i;
                } else if (KQ2.bitrate < KQ.bitrate && j2 >= this.mCx) {
                    this.hxc = i;
                }
            }
            if (this.hxc != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxj() {
        return this.hxc;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxk() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dxl() {
        return null;
    }

    private int gB(long j) {
        long dyU;
        long j2 = this.mCt.dyU() == -1 ? this.mCu : ((float) dyU) * this.mCz;
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
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mCw ? 1 : (j == this.mCw ? 0 : -1)) <= 0 ? ((float) j) * this.mCA : this.mCw;
    }
}
