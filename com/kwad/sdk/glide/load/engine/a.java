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
    public final Map<com.kwad.sdk.glide.load.c, b> f35405a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35406b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f35407c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<n<?>> f35408d;

    /* renamed from: e  reason: collision with root package name */
    public n.a f35409e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35410f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile InterfaceC0416a f35411g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0416a {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f35415a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35416b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f35417c;

        public b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.f35415a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f35417c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f35416b = nVar.f();
        }

        public void a() {
            this.f35417c = null;
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
        this.f35405a = new HashMap();
        this.f35408d = new ReferenceQueue<>();
        this.f35406b = z;
        this.f35407c = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    public void a() {
        while (!this.f35410f) {
            try {
                a((b) this.f35408d.remove());
                InterfaceC0416a interfaceC0416a = this.f35411g;
                if (interfaceC0416a != null) {
                    interfaceC0416a.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b remove = this.f35405a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b put = this.f35405a.put(cVar, new b(cVar, nVar, this.f35408d, this.f35406b));
        if (put != null) {
            put.a();
        }
    }

    public void a(@NonNull b bVar) {
        synchronized (this.f35409e) {
            synchronized (this) {
                this.f35405a.remove(bVar.f35415a);
                if (bVar.f35416b && bVar.f35417c != null) {
                    n<?> nVar = new n<>(bVar.f35417c, true, false);
                    nVar.a(bVar.f35415a, this.f35409e);
                    this.f35409e.a(bVar.f35415a, nVar);
                }
            }
        }
    }

    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f35409e = aVar;
            }
        }
    }

    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        b bVar = this.f35405a.get(cVar);
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
