package d.a.a;

import android.os.Handler;
import android.os.Looper;
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
public class m<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f41591e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public final Set<h<T>> f41592a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<h<Throwable>> f41593b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f41594c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public volatile l<T> f41595d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f41595d == null) {
                return;
            }
            l lVar = m.this.f41595d;
            if (lVar.b() != null) {
                m.this.i(lVar.b());
            } else {
                m.this.g(lVar.a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends FutureTask<l<T>> {
        public b(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                m.this.l(get());
            } catch (InterruptedException | ExecutionException e2) {
                m.this.l(new l(e2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    public synchronized m<T> e(h<Throwable> hVar) {
        if (this.f41595d != null && this.f41595d.a() != null) {
            hVar.onResult(this.f41595d.a());
        }
        this.f41593b.add(hVar);
        return this;
    }

    public synchronized m<T> f(h<T> hVar) {
        if (this.f41595d != null && this.f41595d.b() != null) {
            hVar.onResult(this.f41595d.b());
        }
        this.f41592a.add(hVar);
        return this;
    }

    public final synchronized void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.f41593b);
        if (arrayList.isEmpty()) {
            d.a.a.x.d.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    public final void h() {
        this.f41594c.post(new a());
    }

    public final synchronized void i(T t) {
        for (h hVar : new ArrayList(this.f41592a)) {
            hVar.onResult(t);
        }
    }

    public synchronized m<T> j(h<Throwable> hVar) {
        this.f41593b.remove(hVar);
        return this;
    }

    public synchronized m<T> k(h<T> hVar) {
        this.f41592a.remove(hVar);
        return this;
    }

    public final void l(@Nullable l<T> lVar) {
        if (this.f41595d == null) {
            this.f41595d = lVar;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable, boolean z) {
        this.f41592a = new LinkedHashSet(1);
        this.f41593b = new LinkedHashSet(1);
        this.f41594c = new Handler(Looper.getMainLooper());
        this.f41595d = null;
        if (z) {
            try {
                l(callable.call());
                return;
            } catch (Throwable th) {
                l(new l<>(th));
                return;
            }
        }
        f41591e.execute(new b(callable));
    }
}
