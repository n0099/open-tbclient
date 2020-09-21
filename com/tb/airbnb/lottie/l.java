package com.tb.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes17.dex */
public class l<T> {
    public static Executor Cc = Executors.newCachedThreadPool();
    @Nullable
    private Thread Cd;
    private final Set<h<T>> Ce;
    private final Set<h<Throwable>> Cf;
    private final FutureTask<k<T>> Cg;
    private final Handler handler;
    @Nullable
    private volatile k<T> orX;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.Ce = new LinkedHashSet(1);
        this.Cf = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.orX = null;
        this.Cg = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        Cc.execute(this.Cg);
        iP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.orX != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.orX = kVar;
        iO();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.orX != null && this.orX.getValue() != null) {
            hVar.onResult(this.orX.getValue());
        }
        this.Ce.add(hVar);
        iP();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.Ce.remove(hVar);
        iQ();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.orX != null && this.orX.iN() != null) {
            hVar.onResult(this.orX.iN());
        }
        this.Cf.add(hVar);
        iP();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.Cf.remove(hVar);
        iQ();
        return this;
    }

    private void iO() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.orX != null && !l.this.Cg.isCancelled()) {
                    k kVar = l.this.orX;
                    if (kVar.getValue() != null) {
                        l.this.o(kVar.getValue());
                    } else {
                        l.this.f(kVar.iN());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(T t) {
        for (h hVar : new ArrayList(this.Ce)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.Cf);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void iP() {
        if (!iR() && this.orX == null) {
            this.Cd = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean Cj = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Cj) {
                        if (l.this.Cg.isDone()) {
                            try {
                                l.this.a((k) l.this.Cg.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.Cj = true;
                            l.this.iQ();
                        }
                    }
                }
            };
            this.Cd.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iQ() {
        if (iR() && (this.Ce.isEmpty() || this.orX != null)) {
            this.Cd.interrupt();
            this.Cd = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iR() {
        return this.Cd != null && this.Cd.isAlive();
    }
}
