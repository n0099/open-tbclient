package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
abstract class a {
    protected long psb;
    protected AtomicBoolean psa = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.exE();
            if (a.this.psa.get()) {
                e.exM().postDelayed(a.this.mRunnable, a.this.psb);
            }
        }
    };

    abstract void exE();

    public a(long j) {
        this.psb = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.psa.get()) {
            this.psa.set(true);
            e.exM().removeCallbacks(this.mRunnable);
            e.exM().postDelayed(this.mRunnable, c.exI().exK());
        }
    }

    public void stop() {
        if (this.psa.get()) {
            this.psa.set(false);
            e.exM().removeCallbacks(this.mRunnable);
        }
    }
}
