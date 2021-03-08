package com.ksad.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes3.dex */
public class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f5366a = Executors.newCachedThreadPool();
    @Nullable
    private Thread b;
    private final Set<h<T>> c;
    private final Set<h<Throwable>> d;
    private final Handler e;
    private final FutureTask<j<T>> f;
    @Nullable
    private volatile j<T> g;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    k(Callable<j<T>> callable, boolean z) {
        this.c = new LinkedHashSet(1);
        this.d = new LinkedHashSet(1);
        this.e = new Handler(Looper.getMainLooper());
        this.g = null;
        this.f = new FutureTask<>(callable);
        if (!z) {
            f5366a.execute(this.f);
            b();
            return;
        }
        try {
            a((j) callable.call());
        } catch (Throwable th) {
            a((j) new j<>(th));
        }
    }

    private void a() {
        this.e.post(new Runnable() { // from class: com.ksad.lottie.k.1
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.g == null || k.this.f.isCancelled()) {
                    return;
                }
                j jVar = k.this.g;
                if (jVar.a() != null) {
                    k.this.a((k) jVar.a());
                } else {
                    k.this.a(jVar.b());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable j<T> jVar) {
        if (this.g != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.g = jVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t) {
        for (h hVar : new ArrayList(this.c)) {
            hVar.a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.d);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.a(th);
        }
    }

    private synchronized void b() {
        if (!d() && this.g == null) {
            this.b = new Thread("LottieTaskObserver") { // from class: com.ksad.lottie.k.2
                private boolean b = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.b) {
                        if (k.this.f.isDone()) {
                            try {
                                k.this.a((j) k.this.f.get());
                            } catch (InterruptedException | ExecutionException e) {
                                k.this.a(new j(e));
                            }
                            this.b = true;
                            k.this.c();
                        }
                    }
                }
            };
            this.b.start();
            c.a("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        if (d() && (this.c.isEmpty() || this.g != null)) {
            this.b.interrupt();
            this.b = null;
            c.a("Stopping TaskObserver thread");
        }
    }

    private boolean d() {
        return this.b != null && this.b.isAlive();
    }

    public synchronized k<T> a(h<T> hVar) {
        if (this.g != null && this.g.a() != null) {
            hVar.a(this.g.a());
        }
        this.c.add(hVar);
        b();
        return this;
    }

    public synchronized k<T> b(h<T> hVar) {
        this.c.remove(hVar);
        c();
        return this;
    }

    public synchronized k<T> c(h<Throwable> hVar) {
        if (this.g != null && this.g.b() != null) {
            hVar.a(this.g.b());
        }
        this.d.add(hVar);
        b();
        return this;
    }

    public synchronized k<T> d(h<Throwable> hVar) {
        this.d.remove(hVar);
        c();
        return this;
    }
}
