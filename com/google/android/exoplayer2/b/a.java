package com.google.android.exoplayer2.b;

import android.os.SystemClock;
import com.baidu.webkit.net.BdNetTask;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.source.t;
/* loaded from: classes4.dex */
public class a extends b {
    private int hry;
    private final com.google.android.exoplayer2.upstream.c mxR;
    private final int mxS;
    private final long mxT;
    private final long mxU;
    private final long mxV;
    private final float mxW;
    private final float mxX;
    private int reason;

    /* renamed from: com.google.android.exoplayer2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0657a implements f.a {
        private final com.google.android.exoplayer2.upstream.c mxR;
        private final int mxS;
        private final float mxW;
        private final float mxX;
        private final int mxY;
        private final int mxZ;
        private final int mya;

        public C0657a(com.google.android.exoplayer2.upstream.c cVar) {
            this(cVar, 800000, 10000, BdNetTask.TIMEOUT_READ, BdNetTask.TIMEOUT_READ, 0.75f, 0.75f);
        }

        public C0657a(com.google.android.exoplayer2.upstream.c cVar, int i, int i2, int i3, int i4, float f, float f2) {
            this.mxR = cVar;
            this.mxS = i;
            this.mxY = i2;
            this.mxZ = i3;
            this.mya = i4;
            this.mxW = f;
            this.mxX = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.b.f.a
        /* renamed from: a */
        public a b(t tVar, int... iArr) {
            return new a(tVar, iArr, this.mxR, this.mxS, this.mxY, this.mxZ, this.mya, this.mxW, this.mxX);
        }
    }

    public a(t tVar, int[] iArr, com.google.android.exoplayer2.upstream.c cVar, int i, long j, long j2, long j3, float f, float f2) {
        super(tVar, iArr);
        this.mxR = cVar;
        this.mxS = i;
        this.mxT = 1000 * j;
        this.mxU = 1000 * j2;
        this.mxV = 1000 * j3;
        this.mxW = f;
        this.mxX = f2;
        this.hry = gy(Long.MIN_VALUE);
        this.reason = 1;
    }

    @Override // com.google.android.exoplayer2.b.f
    public void f(long j, long j2, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.hry;
        this.hry = gy(elapsedRealtime);
        if (this.hry != i) {
            if (!J(i, elapsedRealtime)) {
                Format KC = KC(i);
                Format KC2 = KC(this.hry);
                if (KC2.bitrate > KC.bitrate && j2 < gz(j3)) {
                    this.hry = i;
                } else if (KC2.bitrate < KC.bitrate && j2 >= this.mxU) {
                    this.hry = i;
                }
            }
            if (this.hry != i) {
                this.reason = 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.f
    public int duK() {
        return this.hry;
    }

    @Override // com.google.android.exoplayer2.b.f
    public int duL() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.b.f
    public Object duM() {
        return null;
    }

    private int gy(long j) {
        long dwv;
        long j2 = this.mxR.dwv() == -1 ? this.mxS : ((float) dwv) * this.mxW;
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            if (j == Long.MIN_VALUE || !J(i2, j)) {
                if (KC(i2).bitrate <= j2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long gz(long j) {
        return (j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) != 0 && (j > this.mxT ? 1 : (j == this.mxT ? 0 : -1)) <= 0 ? ((float) j) * this.mxX : this.mxT;
    }
}
