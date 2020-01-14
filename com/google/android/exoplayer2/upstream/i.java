package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes5.dex */
public final class i implements c, q<Object> {
    private final Handler lXR;
    private final c.a mFq;
    private final com.google.android.exoplayer2.util.p mFr;
    private final com.google.android.exoplayer2.util.b mFs;
    private int mFt;
    private long mFu;
    private long mFv;
    private long mFw;
    private long mFx;
    private long mFy;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mGs);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.lXR = handler;
        this.mFq = aVar;
        this.mFr = new com.google.android.exoplayer2.util.p(i);
        this.mFs = bVar;
        this.mFy = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dxI() {
        return this.mFy;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mFt == 0) {
            this.mFu = this.mFs.dxZ();
        }
        this.mFt++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mFv += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void bz(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mFt > 0);
        long dxZ = this.mFs.dxZ();
        int i = (int) (dxZ - this.mFu);
        this.mFw += i;
        this.mFx += this.mFv;
        if (i > 0) {
            this.mFr.r((int) Math.sqrt(this.mFv), (float) ((this.mFv * 8000) / i));
            if (this.mFw >= 2000 || this.mFx >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bE = this.mFr.bE(0.5f);
                this.mFy = Float.isNaN(bE) ? -1L : bE;
            }
        }
        m(i, this.mFv, this.mFy);
        int i2 = this.mFt - 1;
        this.mFt = i2;
        if (i2 > 0) {
            this.mFu = dxZ;
        }
        this.mFv = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.lXR != null && this.mFq != null) {
            this.lXR.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mFq.l(i, j, j2);
                }
            });
        }
    }
}
