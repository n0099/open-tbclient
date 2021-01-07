package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes5.dex */
public abstract class a<R extends g> {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f9611a = Executors.newFixedThreadPool(5);

    /* renamed from: b  reason: collision with root package name */
    private Future<?> f9612b;

    protected abstract void a(R r, c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract R b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        try {
            this.f9612b = f9611a.submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f();
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.f9612b == null) {
            return;
        }
        this.f9612b.cancel(true);
    }

    protected abstract void f();
}
