package com.kwad.sdk.core.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public abstract class a {
    public static final ExecutorService sExecutors = com.kwad.sdk.core.threads.b.vn();
    public Future mTask;

    public void cancel() {
        Future future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    public abstract g createRequest();

    public void fetch() {
        try {
            this.mTask = getExecutor().submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.fetchImpl();
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
    }

    public abstract void fetchImpl();

    public ExecutorService getExecutor() {
        return sExecutors;
    }

    public abstract void onResponse(g gVar, c cVar);
}
