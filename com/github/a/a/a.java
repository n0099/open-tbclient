package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
abstract class a {
    protected long pRH;
    protected AtomicBoolean pRG = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.eAI();
            if (a.this.pRG.get()) {
                e.eAQ().postDelayed(a.this.mRunnable, a.this.pRH);
            }
        }
    };

    abstract void eAI();

    public a(long j) {
        this.pRH = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.pRG.get()) {
            this.pRG.set(true);
            e.eAQ().removeCallbacks(this.mRunnable);
            e.eAQ().postDelayed(this.mRunnable, c.eAM().eAO());
        }
    }

    public void stop() {
        if (this.pRG.get()) {
            this.pRG.set(false);
            e.eAQ().removeCallbacks(this.mRunnable);
        }
    }
}
