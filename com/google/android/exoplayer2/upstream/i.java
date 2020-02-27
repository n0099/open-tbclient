package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes6.dex */
public final class i implements c, q<Object> {
    private final Handler lYx;
    private final c.a mFW;
    private final com.google.android.exoplayer2.util.p mFX;
    private final com.google.android.exoplayer2.util.b mFY;
    private int mFZ;
    private long mGa;
    private long mGb;
    private long mGc;
    private long mGd;
    private long mGe;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mGY);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.lYx = handler;
        this.mFW = aVar;
        this.mFX = new com.google.android.exoplayer2.util.p(i);
        this.mFY = bVar;
        this.mGe = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dyS() {
        return this.mGe;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mFZ == 0) {
            this.mGa = this.mFY.dzj();
        }
        this.mFZ++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mGb += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void bB(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mFZ > 0);
        long dzj = this.mFY.dzj();
        int i = (int) (dzj - this.mGa);
        this.mGc += i;
        this.mGd += this.mGb;
        if (i > 0) {
            this.mFX.r((int) Math.sqrt(this.mGb), (float) ((this.mGb * 8000) / i));
            if (this.mGc >= 2000 || this.mGd >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bD = this.mFX.bD(0.5f);
                this.mGe = Float.isNaN(bD) ? -1L : bD;
            }
        }
        m(i, this.mGb, this.mGe);
        int i2 = this.mFZ - 1;
        this.mFZ = i2;
        if (i2 > 0) {
            this.mGa = dzj;
        }
        this.mGb = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.lYx != null && this.mFW != null) {
            this.lYx.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mFW.l(i, j, j2);
                }
            });
        }
    }
}
