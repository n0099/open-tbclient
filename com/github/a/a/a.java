package com.github.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
abstract class a {
    protected long pGm;
    protected AtomicBoolean pGl = new AtomicBoolean(false);
    private Runnable mRunnable = new Runnable() { // from class: com.github.a.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.eyc();
            if (a.this.pGl.get()) {
                e.eyk().postDelayed(a.this.mRunnable, a.this.pGm);
            }
        }
    };

    abstract void eyc();

    public a(long j) {
        this.pGm = 0 == j ? 300L : j;
    }

    public void start() {
        if (!this.pGl.get()) {
            this.pGl.set(true);
            e.eyk().removeCallbacks(this.mRunnable);
            e.eyk().postDelayed(this.mRunnable, c.eyg().eyi());
        }
    }

    public void stop() {
        if (this.pGl.get()) {
            this.pGl.set(false);
            e.eyk().removeCallbacks(this.mRunnable);
        }
    }
}
