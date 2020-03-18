package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes6.dex */
public class a extends b {
    private int hyO;
    private final com.google.android.exoplayer2.upstream.c mEo;
    private final int mEp;
    private final long mEq;
    private final long mEr;
    private final long mEs;
    private final float mEt;
    private final float mEu;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0672a implements f.a {
        private final com.google.android.exoplayer2.upstream.c mEo;
        private final int mEp;
        private final float mEt;
        private final float mEu;
        private final int mEv;
        private final int mEw;
        private final int mEx;

        public C0672a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0672a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mEo = cVar;
            this.mEp = i;
            this.mEv = i2;
            this.mEw = i3;
            this.mEx = i4;
            this.mEt = f;
            this.mEu = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mEo, this.mEp, this.mEv, this.mEw, this.mEx, this.mEt, this.mEu);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mEo = cVar;
        this.mEp = i;
        this.mEq = 1000 * j;
        this.mEr = 1000 * j2;
        this.mEs = 1000 * j3;
        this.mEt = f;
        this.mEu = f2;
        this.hyO = gC(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void g(long j, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.hyO;
        this.hyO = gC(elapsedRealtime);
        if (this.hyO != i) {
            if (!I(i, elapsedRealtime)) {
                Format KW = KW(i);
                Format KW2 = KW(this.hyO);
                if (KW2.bitrate > KW.bitrate && j2 < gD(j3)) {
                    this.hyO = i;
                } else if (KW2.bitrate < KW.bitrate && j2 >= this.mEr) {
                    this.hyO = i;
                }
            }
            if (this.hyO != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxH() {
        return this.hyO;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int dxI() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object dxJ() {
        return null;
    }

    private int gC(long j) {
        long dzs;
        long j2 = this.mEo.dzs() == -1 ? this.mEp : ((float) dzs) * this.mEt;
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !I(i2, j)) {
                if (KW(i2).bitrate <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long gD(long j) {
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mEq ? 1 : (j == this.mEq ? 0 : -1)) <= 0 ? ((float) j) * this.mEu : this.mEq;
    }
}
