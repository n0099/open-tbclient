package com.kwad.sdk.utils.kwai;

import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public final class f implements Executor {
    public Runnable aqn;
    public Runnable aqo;

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.kwai.f.1
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

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.aqo;
        this.aqn = runnable;
        this.aqo = null;
        if (runnable != null) {
            d.getExecutor().execute(this.aqn);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aqn == null) {
            this.aqn = d(runnable);
            d.getExecutor().execute(this.aqn);
            return;
        }
        if (this.aqo == null) {
            this.aqo = d(runnable);
        }
    }
}
