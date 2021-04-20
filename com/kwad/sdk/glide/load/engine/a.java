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
    public final Map<com.kwad.sdk.glide.load.c, b> f35694a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35695b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f35696c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<n<?>> f35697d;

    /* renamed from: e  reason: collision with root package name */
    public n.a f35698e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35699f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile InterfaceC0430a f35700g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0430a {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f35704a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f35705b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f35706c;

        public b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.f35704a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f35706c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f35705b = nVar.f();
        }

        public void a() {
            this.f35706c = null;
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
        this.f35694a = new HashMap();
        this.f35697d = new ReferenceQueue<>();
        this.f35695b = z;
        this.f35696c = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    public void a() {
        while (!this.f35699f) {
            try {
                a((b) this.f35697d.remove());
                InterfaceC0430a interfaceC0430a = this.f35700g;
                if (interfaceC0430a != null) {
                    interfaceC0430a.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b remove = this.f35694a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b put = this.f35694a.put(cVar, new b(cVar, nVar, this.f35697d, this.f35695b));
        if (put != null) {
            put.a();
        }
    }

    public void a(@NonNull b bVar) {
        synchronized (this.f35698e) {
            synchronized (this) {
                this.f35694a.remove(bVar.f35704a);
                if (bVar.f35705b && bVar.f35706c != null) {
                    n<?> nVar = new n<>(bVar.f35706c, true, false);
                    nVar.a(bVar.f35704a, this.f35698e);
                    this.f35698e.a(bVar.f35704a, nVar);
                }
            }
        }
    }

    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f35698e = aVar;
            }
        }
    }

    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        b bVar = this.f35694a.get(cVar);
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
