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
/* loaded from: classes20.dex */
public class m<T> {
    public static Executor Dp = Executors.newCachedThreadPool();
    @Nullable
    private Thread Dq;
    private final Set<i<T>> Dr;
    private final Set<i<Throwable>> Ds;
    private final FutureTask<l<T>> Dt;
    private final Handler handler;
    @Nullable
    private volatile l<T> pAN;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.Dr = new LinkedHashSet(1);
        this.Ds = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.pAN = null;
        this.Dt = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        Dp.execute(this.Dt);
        iQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.pAN != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.pAN = lVar;
        iP();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.pAN != null && this.pAN.getValue() != null) {
            iVar.onResult(this.pAN.getValue());
        }
        this.Dr.add(iVar);
        iQ();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.Dr.remove(iVar);
        iR();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.pAN != null && this.pAN.iO() != null) {
            iVar.onResult(this.pAN.iO());
        }
        this.Ds.add(iVar);
        iQ();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.Ds.remove(iVar);
        iR();
        return this;
    }

    private void iP() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.pAN != null && !m.this.Dt.isCancelled()) {
                    l lVar = m.this.pAN;
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
        for (i iVar : new ArrayList(this.Dr)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.Ds);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void iQ() {
        if (!iS() && this.pAN == null) {
            this.Dq = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.m.2
                private boolean Dw = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Dw) {
                        if (m.this.Dt.isDone()) {
                            try {
                                m.this.a((l) m.this.Dt.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.Dw = true;
                            m.this.iR();
                        }
                    }
                }
            };
            this.Dq.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iR() {
        if (iS() && (this.Dr.isEmpty() || this.pAN != null)) {
            this.Dq.interrupt();
            this.Dq = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iS() {
        return this.Dq != null && this.Dq.isAlive();
    }
}
