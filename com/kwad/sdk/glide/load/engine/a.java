package com.kwad.sdk.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.load.engine.n;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes5.dex */
final class a {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Map<com.kwad.sdk.glide.load.c, b> f10447a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10448b;
    private final Executor c;
    private final ReferenceQueue<n<?>> d;
    private n.a e;
    private volatile boolean f;
    @Nullable
    private volatile InterfaceC1101a g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1101a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.load.c f10452a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f10453b;
        @Nullable
        s<?> c;

        b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.f10452a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f10453b = nVar.f();
        }

        void a() {
            this.c = null;
            clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.glide.load.engine.a.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    @VisibleForTesting
    a(boolean z, Executor executor) {
        this.f10447a = new HashMap();
        this.d = new ReferenceQueue<>();
        this.f10448b = z;
        this.c = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    void a() {
        while (!this.f) {
            try {
                a((b) this.d.remove());
                InterfaceC1101a interfaceC1101a = this.g;
                if (interfaceC1101a != null) {
                    interfaceC1101a.a();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b remove = this.f10447a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b put = this.f10447a.put(cVar, new b(cVar, nVar, this.d, this.f10448b));
        if (put != null) {
            put.a();
        }
    }

    void a(@NonNull b bVar) {
        synchronized (this.e) {
            synchronized (this) {
                this.f10447a.remove(bVar.f10452a);
                if (!bVar.f10453b || bVar.c == null) {
                    return;
                }
                n<?> nVar = new n<>(bVar.c, true, false);
                nVar.a(bVar.f10452a, this.e);
                this.e.a(bVar.f10452a, nVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        n<?> nVar;
        b bVar = this.f10447a.get(cVar);
        if (bVar == null) {
            nVar = null;
        } else {
            nVar = (n) bVar.get();
            if (nVar == null) {
                a(bVar);
            }
        }
        return nVar;
    }
}
