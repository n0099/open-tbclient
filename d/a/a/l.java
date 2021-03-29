package d.a.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public class l<T> {

    /* renamed from: g  reason: collision with root package name */
    public static Executor f41190g = Executors.newCachedThreadPool();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Thread f41191a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<h<T>> f41192b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<h<Throwable>> f41193c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f41194d;

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<k<T>> f41195e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public volatile k<T> f41196f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f41196f == null || l.this.f41195e.isCancelled()) {
                return;
            }
            k kVar = l.this.f41196f;
            if (kVar.b() != null) {
                l.this.k(kVar.b());
            } else {
                l.this.i(kVar.a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Thread {

        /* renamed from: e  reason: collision with root package name */
        public boolean f41198e;

        public b(String str) {
            super(str);
            this.f41198e = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!isInterrupted() && !this.f41198e) {
                if (l.this.f41195e.isDone()) {
                    try {
                        l.this.n((k) l.this.f41195e.get());
                    } catch (InterruptedException | ExecutionException e2) {
                        l.this.n(new k(e2));
                    }
                    this.f41198e = true;
                    l.this.p();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    public synchronized l<T> g(h<Throwable> hVar) {
        if (this.f41196f != null && this.f41196f.a() != null) {
            hVar.onResult(this.f41196f.a());
        }
        this.f41193c.add(hVar);
        o();
        return this;
    }

    public synchronized l<T> h(h<T> hVar) {
        if (this.f41196f != null && this.f41196f.b() != null) {
            hVar.onResult(this.f41196f.b());
        }
        this.f41192b.add(hVar);
        o();
        return this;
    }

    public final void i(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.f41193c);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    public final void j() {
        this.f41194d.post(new a());
    }

    public final void k(T t) {
        for (h hVar : new ArrayList(this.f41192b)) {
            hVar.onResult(t);
        }
    }

    public synchronized l<T> l(h<Throwable> hVar) {
        this.f41193c.remove(hVar);
        p();
        return this;
    }

    public synchronized l<T> m(h<T> hVar) {
        this.f41192b.remove(hVar);
        p();
        return this;
    }

    public final void n(@Nullable k<T> kVar) {
        if (this.f41196f == null) {
            this.f41196f = kVar;
            j();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public final synchronized void o() {
        if (!q() && this.f41196f == null) {
            b bVar = new b("LottieTaskObserver");
            this.f41191a = bVar;
            bVar.start();
            c.b("Starting TaskObserver thread");
        }
    }

    public final synchronized void p() {
        if (q()) {
            if (this.f41192b.isEmpty() || this.f41196f != null) {
                this.f41191a.interrupt();
                this.f41191a = null;
                c.b("Stopping TaskObserver thread");
            }
        }
    }

    public final boolean q() {
        Thread thread = this.f41191a;
        return thread != null && thread.isAlive();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable, boolean z) {
        this.f41192b = new LinkedHashSet(1);
        this.f41193c = new LinkedHashSet(1);
        this.f41194d = new Handler(Looper.getMainLooper());
        this.f41196f = null;
        FutureTask<k<T>> futureTask = new FutureTask<>(callable);
        this.f41195e = futureTask;
        if (z) {
            try {
                n(callable.call());
                return;
            } catch (Throwable th) {
                n(new k<>(th));
                return;
            }
        }
        f41190g.execute(futureTask);
        o();
    }
}
