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
    public static Executor By = Executors.newCachedThreadPool();
    private final Set<h<T>> BA;
    private final Set<h<Throwable>> BB;
    private final FutureTask<k<T>> BC;
    @Nullable
    private Thread Bz;
    private final Handler handler;
    @Nullable
    private volatile k<T> nOb;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.BA = new LinkedHashSet(1);
        this.BB = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nOb = null;
        this.BC = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        By.execute(this.BC);
        hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.nOb != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.nOb = kVar;
        hm();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.nOb != null && this.nOb.getValue() != null) {
            hVar.onResult(this.nOb.getValue());
        }
        this.BA.add(hVar);
        hn();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.BA.remove(hVar);
        ho();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.nOb != null && this.nOb.hl() != null) {
            hVar.onResult(this.nOb.hl());
        }
        this.BB.add(hVar);
        hn();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.BB.remove(hVar);
        ho();
        return this;
    }

    private void hm() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.nOb != null && !l.this.BC.isCancelled()) {
                    k kVar = l.this.nOb;
                    if (kVar.getValue() != null) {
                        l.this.n(kVar.getValue());
                    } else {
                        l.this.g(kVar.hl());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(T t) {
        for (h hVar : new ArrayList(this.BA)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.BB);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void hn() {
        if (!hp() && this.nOb == null) {
            this.Bz = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean BF = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.BF) {
                        if (l.this.BC.isDone()) {
                            try {
                                l.this.a((k) l.this.BC.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.BF = true;
                            l.this.ho();
                        }
                    }
                }
            };
            this.Bz.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ho() {
        if (hp() && (this.BA.isEmpty() || this.nOb != null)) {
            this.Bz.interrupt();
            this.Bz = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean hp() {
        return this.Bz != null && this.Bz.isAlive();
    }
}
