package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
abstract class a {
    protected long pJf;
    protected AtomicBoolean pJe = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.eBq();
            if (a.this.pJe.get()) {
                e.eBy().postDelayed(a.this.mRunnable, a.this.pJf);
            }
        }
    };

    abstract void eBq();

    public a(long j) {
        this.pJf = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.pJe.get()) {
            this.pJe.set(true);
            e.eBy().removeCallbacks(this.mRunnable);
            e.eBy().postDelayed(this.mRunnable, c.eBu().eBw());
        }
    }

    public void stop() {
        if (this.pJe.get()) {
            this.pJe.set(false);
            e.eBy().removeCallbacks(this.mRunnable);
        }
    }
}
