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
public class m<T> {
    public static Executor Ct = Executors.newCachedThreadPool();
    @Nullable
    private Thread Cu;
    private final Set<i<T>> Cv;
    private final Set<i<Throwable>> Cw;
    private final FutureTask<l<T>> Cx;
    private final Handler handler;
    @Nullable
    private volatile l<T> pIe;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.Cv = new LinkedHashSet(1);
        this.Cw = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.pIe = null;
        this.Cx = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        Ct.execute(this.Cx);
        iQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.pIe != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.pIe = lVar;
        iP();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.pIe != null && this.pIe.getValue() != null) {
            iVar.onResult(this.pIe.getValue());
        }
        this.Cv.add(iVar);
        iQ();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.Cv.remove(iVar);
        iR();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.pIe != null && this.pIe.iO() != null) {
            iVar.onResult(this.pIe.iO());
        }
        this.Cw.add(iVar);
        iQ();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.Cw.remove(iVar);
        iR();
        return this;
    }

    private void iP() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.pIe != null && !m.this.Cx.isCancelled()) {
                    l lVar = m.this.pIe;
                    if (lVar.getValue() != null) {
                        m.this.o(lVar.getValue());
                    } else {
                        m.this.f(lVar.iO());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(T t) {
        for (i iVar : new ArrayList(this.Cv)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.Cw);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void iQ() {
        if (!iS() && this.pIe == null) {
            this.Cu = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.m.2
                private boolean CB = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.CB) {
                        if (m.this.Cx.isDone()) {
                            try {
                                m.this.a((l) m.this.Cx.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.CB = true;
                            m.this.iR();
                        }
                    }
                }
            };
            this.Cu.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iR() {
        if (iS() && (this.Cv.isEmpty() || this.pIe != null)) {
            this.Cu.interrupt();
            this.Cu = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iS() {
        return this.Cu != null && this.Cu.isAlive();
    }
}
