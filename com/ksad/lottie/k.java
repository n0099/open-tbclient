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
/* loaded from: classes6.dex */
public class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f31432a = Executors.newCachedThreadPool();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Thread f31433b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<h<T>> f31434c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<h<Throwable>> f31435d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f31436e;

    /* renamed from: f  reason: collision with root package name */
    public final FutureTask<j<T>> f31437f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile j<T> f31438g;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable, boolean z) {
        this.f31434c = new LinkedHashSet(1);
        this.f31435d = new LinkedHashSet(1);
        this.f31436e = new Handler(Looper.getMainLooper());
        this.f31438g = null;
        FutureTask<j<T>> futureTask = new FutureTask<>(callable);
        this.f31437f = futureTask;
        if (!z) {
            f31432a.execute(futureTask);
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
        this.f31436e.post(new Runnable() { // from class: com.ksad.lottie.k.1
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.f31438g == null || k.this.f31437f.isCancelled()) {
                    return;
                }
                j jVar = k.this.f31438g;
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
        if (this.f31438g != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f31438g = jVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t) {
        for (h hVar : new ArrayList(this.f31434c)) {
            hVar.a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.f31435d);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.a(th);
        }
    }

    private synchronized void b() {
        if (!d() && this.f31438g == null) {
            Thread thread = new Thread("LottieTaskObserver") { // from class: com.ksad.lottie.k.2

                /* renamed from: b  reason: collision with root package name */
                public boolean f31441b = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.f31441b) {
                        if (k.this.f31437f.isDone()) {
                            try {
                                k.this.a((j) k.this.f31437f.get());
                            } catch (InterruptedException | ExecutionException e2) {
                                k.this.a(new j(e2));
                            }
                            this.f31441b = true;
                            k.this.c();
                        }
                    }
                }
            };
            this.f31433b = thread;
            thread.start();
            c.a("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        if (d()) {
            if (this.f31434c.isEmpty() || this.f31438g != null) {
                this.f31433b.interrupt();
                this.f31433b = null;
                c.a("Stopping TaskObserver thread");
            }
        }
    }

    private boolean d() {
        Thread thread = this.f31433b;
        return thread != null && thread.isAlive();
    }

    public synchronized k<T> a(h<T> hVar) {
        if (this.f31438g != null && this.f31438g.a() != null) {
            hVar.a(this.f31438g.a());
        }
        this.f31434c.add(hVar);
        b();
        return this;
    }

    public synchronized k<T> b(h<T> hVar) {
        this.f31434c.remove(hVar);
        c();
        return this;
    }

    public synchronized k<T> c(h<Throwable> hVar) {
        if (this.f31438g != null && this.f31438g.b() != null) {
            hVar.a(this.f31438g.b());
        }
        this.f31435d.add(hVar);
        b();
        return this;
    }

    public synchronized k<T> d(h<Throwable> hVar) {
        this.f31435d.remove(hVar);
        c();
        return this;
    }
}
