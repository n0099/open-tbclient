package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes6.dex */
public final class i implements c, q<Object> {
    private final Handler lYz;
    private final c.a mFY;
    private final com.google.android.exoplayer2.util.p mFZ;
    private final com.google.android.exoplayer2.util.b mGa;
    private int mGb;
    private long mGc;
    private long mGd;
    private long mGe;
    private long mGf;
    private long mGg;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mHa);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.lYz = handler;
        this.mFY = aVar;
        this.mFZ = new com.google.android.exoplayer2.util.p(i);
        this.mGa = bVar;
        this.mGg = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dyU() {
        return this.mGg;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mGb == 0) {
            this.mGc = this.mGa.dzl();
        }
        this.mGb++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mGd += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void bB(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mGb > 0);
        long dzl = this.mGa.dzl();
        int i = (int) (dzl - this.mGc);
        this.mGe += i;
        this.mGf += this.mGd;
        if (i > 0) {
            this.mFZ.r((int) Math.sqrt(this.mGd), (float) ((this.mGd * 8000) / i));
            if (this.mGe >= 2000 || this.mGf >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bD = this.mFZ.bD(0.5f);
                this.mGg = Float.isNaN(bD) ? -1L : bD;
            }
        }
        m(i, this.mGd, this.mGg);
        int i2 = this.mGb - 1;
        this.mGb = i2;
        if (i2 > 0) {
            this.mGc = dzl;
        }
        this.mGd = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.lYz != null && this.mFY != null) {
            this.lYz.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mFY.l(i, j, j2);
                }
            });
        }
    }
}
