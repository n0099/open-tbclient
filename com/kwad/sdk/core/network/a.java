package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public abstract class a<R extends g> {
    public static final ExecutorService a = com.kwad.sdk.core.i.b.h();
    public Future<?> b;

    public abstract void a(R r, c cVar);

    @NonNull
    public abstract R b();

    public void d() {
        try {
            this.b = a.submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f();
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.a.b(e);
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    @CallSuper
    public void e() {
        Future<?> future = this.b;
        if (future != null) {
            future.cancel(true);
        }
    }

    @WorkerThread
    public abstract void f();
}
