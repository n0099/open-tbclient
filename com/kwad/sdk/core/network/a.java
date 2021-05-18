package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public abstract class a<R extends g> {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f32456a = Executors.newFixedThreadPool(5);

    /* renamed from: b  reason: collision with root package name */
    public Future<?> f32457b;

    public abstract void a(R r, c cVar);

    @NonNull
    public abstract R b();

    public void c() {
        try {
            this.f32457b = f32456a.submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.d();
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public abstract void d();
}
