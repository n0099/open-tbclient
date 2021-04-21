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
/* loaded from: classes6.dex */
public final class a {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, b> f35789a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35790b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f35791c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<n<?>> f35792d;

    /* renamed from: e  reason: collision with root package name */
    public n.a f35793e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35794f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile InterfaceC0433a f35795g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0433a {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f35799a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35800b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f35801c;

        public b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.f35799a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f35801c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f35800b = nVar.f();
        }

        public void a() {
            this.f35801c = null;
            clear();
        }
    }

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
    public a(boolean z, Executor executor) {
        this.f35789a = new HashMap();
        this.f35792d = new ReferenceQueue<>();
        this.f35790b = z;
        this.f35791c = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    public void a() {
        while (!this.f35794f) {
            try {
                a((b) this.f35792d.remove());
                InterfaceC0433a interfaceC0433a = this.f35795g;
                if (interfaceC0433a != null) {
                    interfaceC0433a.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b remove = this.f35789a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b put = this.f35789a.put(cVar, new b(cVar, nVar, this.f35792d, this.f35790b));
        if (put != null) {
            put.a();
        }
    }

    public void a(@NonNull b bVar) {
        synchronized (this.f35793e) {
            synchronized (this) {
                this.f35789a.remove(bVar.f35799a);
                if (bVar.f35800b && bVar.f35801c != null) {
                    n<?> nVar = new n<>(bVar.f35801c, true, false);
                    nVar.a(bVar.f35799a, this.f35793e);
                    this.f35793e.a(bVar.f35799a, nVar);
                }
            }
        }
    }

    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f35793e = aVar;
            }
        }
    }

    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        b bVar = this.f35789a.get(cVar);
        if (bVar == null) {
            return null;
        }
        n<?> nVar = bVar.get();
        if (nVar == null) {
            a(bVar);
        }
        return nVar;
    }
}
