package com.ksad.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.L;
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
    public static Executor f32062a = Executors.newCachedThreadPool();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Thread f32063b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<h<T>> f32064c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<h<Throwable>> f32065d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f32066e;

    /* renamed from: f  reason: collision with root package name */
    public final FutureTask<j<T>> f32067f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile j<T> f32068g;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable, boolean z) {
        this.f32064c = new LinkedHashSet(1);
        this.f32065d = new LinkedHashSet(1);
        this.f32066e = new Handler(Looper.getMainLooper());
        this.f32068g = null;
        FutureTask<j<T>> futureTask = new FutureTask<>(callable);
        this.f32067f = futureTask;
        if (!z) {
            f32062a.execute(futureTask);
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
        this.f32066e.post(new Runnable() { // from class: com.ksad.lottie.k.1
            @Override // java.lang.Runnable
            public void run() {
                if (k.this.f32068g == null || k.this.f32067f.isCancelled()) {
                    return;
                }
                j jVar = k.this.f32068g;
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
        if (this.f32068g != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f32068g = jVar;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t) {
        for (h hVar : new ArrayList(this.f32064c)) {
            hVar.a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.f32065d);
        if (arrayList.isEmpty()) {
            Log.w(L.TAG, "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.a(th);
        }
    }

    private synchronized void b() {
        if (!d() && this.f32068g == null) {
            Thread thread = new Thread("LottieTaskObserver") { // from class: com.ksad.lottie.k.2

                /* renamed from: b  reason: collision with root package name */
                public boolean f32071b = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.f32071b) {
                        if (k.this.f32067f.isDone()) {
                            try {
                                k.this.a((j) k.this.f32067f.get());
                            } catch (InterruptedException | ExecutionException e2) {
                                k.this.a(new j(e2));
                            }
                            this.f32071b = true;
                            k.this.c();
                        }
                    }
                }
            };
            this.f32063b = thread;
            thread.start();
            c.a("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        if (d()) {
            if (this.f32064c.isEmpty() || this.f32068g != null) {
                this.f32063b.interrupt();
                this.f32063b = null;
                c.a("Stopping TaskObserver thread");
            }
        }
    }

    private boolean d() {
        Thread thread = this.f32063b;
        return thread != null && thread.isAlive();
    }

    public synchronized k<T> a(h<T> hVar) {
        if (this.f32068g != null && this.f32068g.a() != null) {
            hVar.a(this.f32068g.a());
        }
        this.f32064c.add(hVar);
        b();
        return this;
    }

    public synchronized k<T> b(h<T> hVar) {
        this.f32064c.remove(hVar);
        c();
        return this;
    }

    public synchronized k<T> c(h<Throwable> hVar) {
        if (this.f32068g != null && this.f32068g.b() != null) {
            hVar.a(this.f32068g.b());
        }
        this.f32065d.add(hVar);
        b();
        return this;
    }

    public synchronized k<T> d(h<Throwable> hVar) {
        this.f32065d.remove(hVar);
        c();
        return this;
    }
}
