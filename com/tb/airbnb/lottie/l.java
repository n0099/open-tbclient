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
/* loaded from: classes6.dex */
public class l<T> {
    public static Executor fq = Executors.newCachedThreadPool();
    @Nullable
    private Thread fs;
    private final Set<h<T>> ft;
    private final Set<h<Throwable>> fu;
    private final FutureTask<k<T>> fv;
    private final Handler handler;
    @Nullable
    private volatile k<T> nry;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.ft = new LinkedHashSet(1);
        this.fu = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nry = null;
        this.fv = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        fq.execute(this.fv);
        bA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.nry != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.nry = kVar;
        bz();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.nry != null && this.nry.getValue() != null) {
            hVar.onResult(this.nry.getValue());
        }
        this.ft.add(hVar);
        bA();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.ft.remove(hVar);
        bB();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.nry != null && this.nry.by() != null) {
            hVar.onResult(this.nry.by());
        }
        this.fu.add(hVar);
        bA();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.fu.remove(hVar);
        bB();
        return this;
    }

    private void bz() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.nry != null && !l.this.fv.isCancelled()) {
                    k kVar = l.this.nry;
                    if (kVar.getValue() != null) {
                        l.this.m(kVar.getValue());
                    } else {
                        l.this.g(kVar.by());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(T t) {
        for (h hVar : new ArrayList(this.ft)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.fu);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void bA() {
        if (!bC() && this.nry == null) {
            this.fs = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean fA = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.fA) {
                        if (l.this.fv.isDone()) {
                            try {
                                l.this.a((k) l.this.fv.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.fA = true;
                            l.this.bB();
                        }
                    }
                }
            };
            this.fs.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bB() {
        if (bC() && (this.ft.isEmpty() || this.nry != null)) {
            this.fs.interrupt();
            this.fs = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean bC() {
        return this.fs != null && this.fs.isAlive();
    }
}
