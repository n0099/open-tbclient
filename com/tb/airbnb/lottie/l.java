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
    public static Executor Bw = Executors.newCachedThreadPool();
    private final FutureTask<k<T>> BA;
    @Nullable
    private Thread Bx;
    private final Set<h<T>> By;
    private final Set<h<Throwable>> Bz;
    private final Handler handler;
    @Nullable
    private volatile k<T> nFo;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.By = new LinkedHashSet(1);
        this.Bz = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nFo = null;
        this.BA = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        Bw.execute(this.BA);
        hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.nFo != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.nFo = kVar;
        hm();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.nFo != null && this.nFo.getValue() != null) {
            hVar.onResult(this.nFo.getValue());
        }
        this.By.add(hVar);
        hn();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.By.remove(hVar);
        ho();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.nFo != null && this.nFo.hl() != null) {
            hVar.onResult(this.nFo.hl());
        }
        this.Bz.add(hVar);
        hn();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.Bz.remove(hVar);
        ho();
        return this;
    }

    private void hm() {
        this.handler.post(new Runnable() { // from class: com.tb.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.nFo != null && !l.this.BA.isCancelled()) {
                    k kVar = l.this.nFo;
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
        for (h hVar : new ArrayList(this.By)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.Bz);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void hn() {
        if (!hp() && this.nFo == null) {
            this.Bx = new Thread("LottieTaskObserver") { // from class: com.tb.airbnb.lottie.l.2
                private boolean BD = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.BD) {
                        if (l.this.BA.isDone()) {
                            try {
                                l.this.a((k) l.this.BA.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.BD = true;
                            l.this.ho();
                        }
                    }
                }
            };
            this.Bx.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ho() {
        if (hp() && (this.By.isEmpty() || this.nFo != null)) {
            this.Bx.interrupt();
            this.Bx = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean hp() {
        return this.Bx != null && this.Bx.isAlive();
    }
}
