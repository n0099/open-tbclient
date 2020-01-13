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
/* loaded from: classes5.dex */
public class l<T> {
    public static Executor fk = Executors.newCachedThreadPool();
    @Nullable
    private Thread fn;
    private final Set<h<T>> fo;
    private final Set<h<Throwable>> fq;
    private final FutureTask<k<T>> fs;
    private final Handler handler;
    @Nullable
    private volatile k<T> noR;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.fo = new LinkedHashSet(1);
        this.fq = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.noR = null;
        this.fs = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        fk.execute(this.fs);
        bz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.noR != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.noR = kVar;
        by();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.noR != null && this.noR.getValue() != null) {
            hVar.onResult(this.noR.getValue());
        }
        this.fo.add(hVar);
        bz();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.fo.remove(hVar);
        bA();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.noR != null && this.noR.bx() != null) {
            hVar.onResult(this.noR.bx());
        }
        this.fq.add(hVar);
        bz();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.fq.remove(hVar);
        bA();
        return this;
    }

    private void by() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.noR != null && !l.this.fs.isCancelled()) {
                    k kVar = l.this.noR;
                    if (kVar.getValue() != null) {
                        l.this.m(kVar.getValue());
                    } else {
                        l.this.h(kVar.bx());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(T t) {
        for (h hVar : new ArrayList(this.fo)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.fq);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void bz() {
        if (!bB() && this.noR == null) {
            this.fn = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean fv = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.fv) {
                        if (l.this.fs.isDone()) {
                            try {
                                l.this.a((k) l.this.fs.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.fv = true;
                            l.this.bA();
                        }
                    }
                }
            };
            this.fn.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bA() {
        if (bB() && (this.fo.isEmpty() || this.noR != null)) {
            this.fn.interrupt();
            this.fn = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean bB() {
        return this.fn != null && this.fn.isAlive();
    }
}
