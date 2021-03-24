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
    public final Map<com.kwad.sdk.glide.load.c, b> f35404a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35405b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f35406c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<n<?>> f35407d;

    /* renamed from: e  reason: collision with root package name */
    public n.a f35408e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35409f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile InterfaceC0415a f35410g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0415a {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f35414a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35415b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f35416c;

        public b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.f35414a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f35416c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f35415b = nVar.f();
        }

        public void a() {
            this.f35416c = null;
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
        this.f35404a = new HashMap();
        this.f35407d = new ReferenceQueue<>();
        this.f35405b = z;
        this.f35406c = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    public void a() {
        while (!this.f35409f) {
            try {
                a((b) this.f35407d.remove());
                InterfaceC0415a interfaceC0415a = this.f35410g;
                if (interfaceC0415a != null) {
                    interfaceC0415a.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b remove = this.f35404a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b put = this.f35404a.put(cVar, new b(cVar, nVar, this.f35407d, this.f35405b));
        if (put != null) {
            put.a();
        }
    }

    public void a(@NonNull b bVar) {
        synchronized (this.f35408e) {
            synchronized (this) {
                this.f35404a.remove(bVar.f35414a);
                if (bVar.f35415b && bVar.f35416c != null) {
                    n<?> nVar = new n<>(bVar.f35416c, true, false);
                    nVar.a(bVar.f35414a, this.f35408e);
                    this.f35408e.a(bVar.f35414a, nVar);
                }
            }
        }
    }

    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f35408e = aVar;
            }
        }
    }

    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        b bVar = this.f35404a.get(cVar);
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
