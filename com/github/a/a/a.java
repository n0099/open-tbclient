package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
abstract class a {
    protected long psd;
    protected AtomicBoolean psc = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.exF();
            if (a.this.psc.get()) {
                e.exN().postDelayed(a.this.mRunnable, a.this.psd);
            }
        }
    };

    abstract void exF();

    public a(long j) {
        this.psd = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.psc.get()) {
            this.psc.set(true);
            e.exN().removeCallbacks(this.mRunnable);
            e.exN().postDelayed(this.mRunnable, c.exJ().exL());
        }
    }

    public void stop() {
        if (this.psc.get()) {
            this.psc.set(false);
            e.exN().removeCallbacks(this.mRunnable);
        }
    }
}
