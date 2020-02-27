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
    public static Executor fs = Executors.newCachedThreadPool();
    @Nullable
    private Thread ft;
    private final Set<h<T>> fu;
    private final Set<h<Throwable>> fv;
    private final FutureTask<k<T>> fw;
    private final Handler handler;
    @Nullable
    private volatile k<T> npy;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.fu = new LinkedHashSet(1);
        this.fv = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.npy = null;
        this.fw = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        fs.execute(this.fw);
        bA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.npy != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.npy = kVar;
        bz();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.npy != null && this.npy.getValue() != null) {
            hVar.onResult(this.npy.getValue());
        }
        this.fu.add(hVar);
        bA();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.fu.remove(hVar);
        bB();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.npy != null && this.npy.by() != null) {
            hVar.onResult(this.npy.by());
        }
        this.fv.add(hVar);
        bA();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.fv.remove(hVar);
        bB();
        return this;
    }

    private void bz() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.npy != null && !l.this.fw.isCancelled()) {
                    k kVar = l.this.npy;
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
        for (h hVar : new ArrayList(this.fu)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.fv);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void bA() {
        if (!bC() && this.npy == null) {
            this.ft = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean fB = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.fB) {
                        if (l.this.fw.isDone()) {
                            try {
                                l.this.a((k) l.this.fw.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.fB = true;
                            l.this.bB();
                        }
                    }
                }
            };
            this.ft.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bB() {
        if (bC() && (this.fu.isEmpty() || this.npy != null)) {
            this.ft.interrupt();
            this.ft = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean bC() {
        return this.ft != null && this.ft.isAlive();
    }
}
