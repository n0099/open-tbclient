package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes5.dex */
public final class i implements c, q<Object> {
    private final Handler lXM;
    private final c.a mFl;
    private final com.google.android.exoplayer2.util.p mFm;
    private final com.google.android.exoplayer2.util.b mFn;
    private int mFo;
    private long mFp;
    private long mFq;
    private long mFr;
    private long mFs;
    private long mFt;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mGn);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.lXM = handler;
        this.mFl = aVar;
        this.mFm = new com.google.android.exoplayer2.util.p(i);
        this.mFn = bVar;
        this.mFt = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dxG() {
        return this.mFt;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mFo == 0) {
            this.mFp = this.mFn.dxX();
        }
        this.mFo++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mFq += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void bz(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mFo > 0);
        long dxX = this.mFn.dxX();
        int i = (int) (dxX - this.mFp);
        this.mFr += i;
        this.mFs += this.mFq;
        if (i > 0) {
            this.mFm.r((int) Math.sqrt(this.mFq), (float) ((this.mFq * 8000) / i));
            if (this.mFr >= 2000 || this.mFs >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bE = this.mFm.bE(0.5f);
                this.mFt = Float.isNaN(bE) ? -1L : bE;
            }
        }
        m(i, this.mFq, this.mFt);
        int i2 = this.mFo - 1;
        this.mFo = i2;
        if (i2 > 0) {
            this.mFp = dxX;
        }
        this.mFq = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.lXM != null && this.mFl != null) {
            this.lXM.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mFl.l(i, j, j2);
                }
            });
        }
    }
}
