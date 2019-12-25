package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.c;
/* loaded from: classes4.dex */
public final class i implements c, q<Object> {
    private final Handler lTV;
    private long mBA;
    private long mBB;
    private final c.a mBt;
    private final com.google.android.exoplayer2.util.p mBu;
    private final com.google.android.exoplayer2.util.b mBv;
    private int mBw;
    private long mBx;
    private long mBy;
    private long mBz;

    public i() {
        this(null, null);
    }

    public i(Handler handler, c.a aVar) {
        this(handler, aVar, 2000);
    }

    public i(Handler handler, c.a aVar, int i) {
        this(handler, aVar, i, com.google.android.exoplayer2.util.b.mCw);
    }

    public i(Handler handler, c.a aVar, int i, com.google.android.exoplayer2.util.b bVar) {
        this.lTV = handler;
        this.mBt = aVar;
        this.mBu = new com.google.android.exoplayer2.util.p(i);
        this.mBv = bVar;
        this.mBB = -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.c
    public synchronized long dwv() {
        return this.mBB;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void a(Object obj, g gVar) {
        if (this.mBw == 0) {
            this.mBx = this.mBv.dwM();
        }
        this.mBw++;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void h(Object obj, int i) {
        this.mBy += i;
    }

    @Override // com.google.android.exoplayer2.upstream.q
    public synchronized void by(Object obj) {
        com.google.android.exoplayer2.util.a.checkState(this.mBw > 0);
        long dwM = this.mBv.dwM();
        int i = (int) (dwM - this.mBx);
        this.mBz += i;
        this.mBA += this.mBy;
        if (i > 0) {
            this.mBu.q((int) Math.sqrt(this.mBy), (float) ((this.mBy * 8000) / i));
            if (this.mBz >= 2000 || this.mBA >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float bE = this.mBu.bE(0.5f);
                this.mBB = Float.isNaN(bE) ? -1L : bE;
            }
        }
        m(i, this.mBy, this.mBB);
        int i2 = this.mBw - 1;
        this.mBw = i2;
        if (i2 > 0) {
            this.mBx = dwM;
        }
        this.mBy = 0L;
    }

    private void m(final int i, final long j, final long j2) {
        if (this.lTV != null && this.mBt != null) {
            this.lTV.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.mBt.l(i, j, j2);
                }
            });
        }
    }
}
