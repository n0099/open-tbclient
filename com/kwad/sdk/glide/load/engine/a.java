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
/* loaded from: classes7.dex */
public final class a {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, b> f36089a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36090b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f36091c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<n<?>> f36092d;

    /* renamed from: e  reason: collision with root package name */
    public n.a f36093e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f36094f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile InterfaceC0416a f36095g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0416a {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f36099a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f36100b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f36101c;

        public b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.f36099a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f36101c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f36100b = nVar.f();
        }

        public void a() {
            this.f36101c = null;
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
        this.f36089a = new HashMap();
        this.f36092d = new ReferenceQueue<>();
        this.f36090b = z;
        this.f36091c = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    public void a() {
        while (!this.f36094f) {
            try {
                a((b) this.f36092d.remove());
                InterfaceC0416a interfaceC0416a = this.f36095g;
                if (interfaceC0416a != null) {
                    interfaceC0416a.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b remove = this.f36089a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b put = this.f36089a.put(cVar, new b(cVar, nVar, this.f36092d, this.f36090b));
        if (put != null) {
            put.a();
        }
    }

    public void a(@NonNull b bVar) {
        synchronized (this.f36093e) {
            synchronized (this) {
                this.f36089a.remove(bVar.f36099a);
                if (bVar.f36100b && bVar.f36101c != null) {
                    n<?> nVar = new n<>(bVar.f36101c, true, false);
                    nVar.a(bVar.f36099a, this.f36093e);
                    this.f36093e.a(bVar.f36099a, nVar);
                }
            }
        }
    }

    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f36093e = aVar;
            }
        }
    }

    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        b bVar = this.f36089a.get(cVar);
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
