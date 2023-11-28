package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public final class f implements Executor {
    public Runnable aQy;
    public Runnable aQz;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.aQz;
        this.aQy = runnable;
        this.aQz = null;
        if (runnable != null) {
            d.getExecutor().execute(this.aQy);
        }
    }

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aQy == null) {
            this.aQy = d(runnable);
            d.getExecutor().execute(this.aQy);
            return;
        }
        if (this.aQz == null) {
            this.aQz = d(runnable);
        }
    }
}
