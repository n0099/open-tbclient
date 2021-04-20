package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public abstract class a<R extends g> {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f34148a = Executors.newFixedThreadPool(5);

    /* renamed from: b  reason: collision with root package name */
    public Future<?> f34149b;

    public abstract void a(R r, c cVar);

    @NonNull
    public abstract R b();

    public void d() {
        try {
            this.f34149b = f34148a.submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f();
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public void e() {
        Future<?> future = this.f34149b;
        if (future == null) {
            return;
        }
        future.cancel(true);
    }

    public abstract void f();
}
