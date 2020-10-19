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
/* loaded from: classes16.dex */
public class l<T> {
    public static Executor Ct = Executors.newCachedThreadPool();
    @Nullable
    private Thread Cu;
    private final Set<h<T>> Cv;
    private final Set<h<Throwable>> Cw;
    private final FutureTask<k<T>> Cx;
    private final Handler handler;
    @Nullable
    private volatile k<T> oHn;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.Cv = new LinkedHashSet(1);
        this.Cw = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.oHn = null;
        this.Cx = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        Ct.execute(this.Cx);
        iQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.oHn != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.oHn = kVar;
        iP();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.oHn != null && this.oHn.getValue() != null) {
            hVar.onResult(this.oHn.getValue());
        }
        this.Cv.add(hVar);
        iQ();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.Cv.remove(hVar);
        iR();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.oHn != null && this.oHn.iO() != null) {
            hVar.onResult(this.oHn.iO());
        }
        this.Cw.add(hVar);
        iQ();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.Cw.remove(hVar);
        iR();
        return this;
    }

    private void iP() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.oHn != null && !l.this.Cx.isCancelled()) {
                    k kVar = l.this.oHn;
                    if (kVar.getValue() != null) {
                        l.this.o(kVar.getValue());
                    } else {
                        l.this.f(kVar.iO());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(T t) {
        for (h hVar : new ArrayList(this.Cv)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.Cw);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void iQ() {
        if (!iS() && this.oHn == null) {
            this.Cu = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean CB = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.CB) {
                        if (l.this.Cx.isDone()) {
                            try {
                                l.this.a((k) l.this.Cx.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.CB = true;
                            l.this.iR();
                        }
                    }
                }
            };
            this.Cu.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iR() {
        if (iS() && (this.Cv.isEmpty() || this.oHn != null)) {
            this.Cu.interrupt();
            this.Cu = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iS() {
        return this.Cu != null && this.Cu.isAlive();
    }
}
