package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
abstract class a {
    protected long pQs;
    protected AtomicBoolean pQr = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.eAu();
            if (a.this.pQr.get()) {
                e.eAC().postDelayed(a.this.mRunnable, a.this.pQs);
            }
        }
    };

    abstract void eAu();

    public a(long j) {
        this.pQs = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.pQr.get()) {
            this.pQr.set(true);
            e.eAC().removeCallbacks(this.mRunnable);
            e.eAC().postDelayed(this.mRunnable, c.eAy().eAA());
        }
    }

    public void stop() {
        if (this.pQr.get()) {
            this.pQr.set(false);
            e.eAC().removeCallbacks(this.mRunnable);
        }
    }
}
