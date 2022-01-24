package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public abstract class a<R extends g> {
    public static final ExecutorService a = com.kwad.sdk.core.i.b.h();

    /* renamed from: b  reason: collision with root package name */
    public Future<?> f55922b;

    public abstract void a(R r, c cVar);

    @NonNull
    public abstract R b();

    public void d() {
        try {
            this.f55922b = a.submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    @CallSuper
    public void e() {
        Future<?> future = this.f55922b;
        if (future != null) {
            future.cancel(true);
        }
    }

    @WorkerThread
    public abstract void f();
}
