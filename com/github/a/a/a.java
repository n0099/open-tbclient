package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
abstract class a {
    protected long pQS;
    protected AtomicBoolean pQR = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.eAC();
            if (a.this.pQR.get()) {
                e.eAK().postDelayed(a.this.mRunnable, a.this.pQS);
            }
        }
    };

    abstract void eAC();

    public a(long j) {
        this.pQS = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.pQR.get()) {
            this.pQR.set(true);
            e.eAK().removeCallbacks(this.mRunnable);
            e.eAK().postDelayed(this.mRunnable, c.eAG().eAI());
        }
    }

    public void stop() {
        if (this.pQR.get()) {
            this.pQR.set(false);
            e.eAK().removeCallbacks(this.mRunnable);
        }
    }
}
