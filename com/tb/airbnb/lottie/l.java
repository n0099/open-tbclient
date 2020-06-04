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
    public static Executor AW = Executors.newCachedThreadPool();
    @Nullable
    private Thread AX;
    private final Set<h<T>> AY;
    private final Set<h<Throwable>> AZ;
    private final FutureTask<k<T>> Ba;
    private final Handler handler;
    @Nullable
    private volatile k<T> njz;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.AY = new LinkedHashSet(1);
        this.AZ = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.njz = null;
        this.Ba = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        AW.execute(this.Ba);
        gX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.njz != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.njz = kVar;
        gW();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.njz != null && this.njz.getValue() != null) {
            hVar.onResult(this.njz.getValue());
        }
        this.AY.add(hVar);
        gX();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.AY.remove(hVar);
        gY();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.njz != null && this.njz.gV() != null) {
            hVar.onResult(this.njz.gV());
        }
        this.AZ.add(hVar);
        gX();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.AZ.remove(hVar);
        gY();
        return this;
    }

    private void gW() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.njz != null && !l.this.Ba.isCancelled()) {
                    k kVar = l.this.njz;
                    if (kVar.getValue() != null) {
                        l.this.n(kVar.getValue());
                    } else {
                        l.this.g(kVar.gV());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(T t) {
        for (h hVar : new ArrayList(this.AY)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.AZ);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void gX() {
        if (!gZ() && this.njz == null) {
            this.AX = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean Bd = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Bd) {
                        if (l.this.Ba.isDone()) {
                            try {
                                l.this.a((k) l.this.Ba.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.Bd = true;
                            l.this.gY();
                        }
                    }
                }
            };
            this.AX.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gY() {
        if (gZ() && (this.AY.isEmpty() || this.njz != null)) {
            this.AX.interrupt();
            this.AX = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean gZ() {
        return this.AX != null && this.AX.isAlive();
    }
}
