package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes6.dex */
public final class i implements c, q<Object> {
    private final c.a mHP;
    private final com.google.android.exoplayer2.util.p mHQ;
    private final com.google.android.exoplayer2.util.b mHR;
    private int mHS;
    private long mHT;
    private long mHU;
    private long mHV;
    private long mHW;
    private long mHX;
    private final Handler mas;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mIV);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.mas = handler;
        this.mHP = aVar;
        this.mHQ = new com.google.android.exoplayer2.util.p(i);
        this.mHR = bVar;
        this.mHX = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dzs() {
        return this.mHX;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mHS == 0) {
            this.mHT = this.mHR.dzJ();
        }
        this.mHS++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mHU += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void bB(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mHS > 0);
        long dzJ = this.mHR.dzJ();
        int i = (int) (dzJ - this.mHT);
        this.mHV += i;
        this.mHW += this.mHU;
        if (i > 0) {
            this.mHQ.r((int) Math.sqrt(this.mHU), (float) ((this.mHU * 8000) / i));
            if (this.mHV >= 2000 || this.mHW >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bD = this.mHQ.bD(0.5f);
                this.mHX = Float.isNaN(bD) ? -1L : bD;
            }
        }
        m(i, this.mHU, this.mHX);
        int i2 = this.mHS - 1;
        this.mHS = i2;
        if (i2 > 0) {
            this.mHT = dzJ;
        }
        this.mHU = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.mas != null && this.mHP != null) {
            this.mas.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mHP.l(i, j, j2);
                }
            });
        }
    }
}
