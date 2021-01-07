package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
abstract class a {
    protected long pKN;
    protected AtomicBoolean pKM = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.eBU();
            if (a.this.pKM.get()) {
                e.eCc().postDelayed(a.this.mRunnable, a.this.pKN);
            }
        }
    };

    abstract void eBU();

    public a(long j) {
        this.pKN = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.pKM.get()) {
            this.pKM.set(true);
            e.eCc().removeCallbacks(this.mRunnable);
            e.eCc().postDelayed(this.mRunnable, c.eBY().eCa());
        }
    }

    public void stop() {
        if (this.pKM.get()) {
            this.pKM.set(false);
            e.eCc().removeCallbacks(this.mRunnable);
        }
    }
}
