package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes6.dex */
public final class i implements c, q<Object> {
    private final Handler lYK;
    private final c.a mGj;
    private final com.google.android.exoplayer2.util.p mGk;
    private final com.google.android.exoplayer2.util.b mGl;
    private int mGm;
    private long mGn;
    private long mGo;
    private long mGp;
    private long mGq;
    private long mGr;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mHl);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.lYK = handler;
        this.mGj = aVar;
        this.mGk = new com.google.android.exoplayer2.util.p(i);
        this.mGl = bVar;
        this.mGr = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dyV() {
        return this.mGr;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mGm == 0) {
            this.mGn = this.mGl.dzm();
        }
        this.mGm++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mGo += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void bB(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mGm > 0);
        long dzm = this.mGl.dzm();
        int i = (int) (dzm - this.mGn);
        this.mGp += i;
        this.mGq += this.mGo;
        if (i > 0) {
            this.mGk.r((int) Math.sqrt(this.mGo), (float) ((this.mGo * 8000) / i));
            if (this.mGp >= 2000 || this.mGq >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bD = this.mGk.bD(0.5f);
                this.mGr = Float.isNaN(bD) ? -1L : bD;
            }
        }
        m(i, this.mGo, this.mGr);
        int i2 = this.mGm - 1;
        this.mGm = i2;
        if (i2 > 0) {
            this.mGn = dzm;
        }
        this.mGo = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.lYK != null && this.mGj != null) {
            this.lYK.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mGj.l(i, j, j2);
                }
            });
        }
    }
}
