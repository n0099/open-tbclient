package io.reactivex.e;

import io.reactivex.c.c;
import io.reactivex.c.e;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public final class a {
    static volatile boolean nAa;
    static volatile g<? super Throwable> nzH;
    static volatile h<? super Runnable, ? extends Runnable> nzI;
    static volatile h<? super Callable<v>, ? extends v> nzJ;
    static volatile h<? super Callable<v>, ? extends v> nzK;
    static volatile h<? super Callable<v>, ? extends v> nzL;
    static volatile h<? super Callable<v>, ? extends v> nzM;
    static volatile h<? super v, ? extends v> nzN;
    static volatile h<? super v, ? extends v> nzO;
    static volatile h<? super v, ? extends v> nzP;
    static volatile h<? super v, ? extends v> nzQ;
    static volatile h<? super io.reactivex.g, ? extends io.reactivex.g> nzR;
    static volatile h<? super q, ? extends q> nzS;
    static volatile c<? super io.reactivex.g, ? super org.a.c, ? extends org.a.c> nzT;
    static volatile c<? super k, ? super m, ? extends m> nzU;
    static volatile c<? super q, ? super u, ? extends u> nzV;
    static volatile c<? super w, ? super y, ? extends y> nzW;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> nzX;
    static volatile e nzY;
    static volatile boolean nzZ;

    public static boolean dIy() {
        return nAa;
    }

    public static v f(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nzJ;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v g(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nzL;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v h(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nzM;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v i(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nzK;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v f(v vVar) {
        h<? super v, ? extends v> hVar = nzN;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void onError(Throwable th) {
        g<? super Throwable> gVar = nzH;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!M(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                N(th2);
            }
        }
        th.printStackTrace();
        N(th);
    }

    static boolean M(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    static void N(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static v g(v vVar) {
        h<? super v, ? extends v> hVar = nzP;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static v h(v vVar) {
        h<? super v, ? extends v> hVar = nzQ;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static Runnable F(Runnable runnable) {
        io.reactivex.internal.functions.a.h(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = nzI;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, Object>) hVar, runnable);
    }

    public static v i(v vVar) {
        h<? super v, ? extends v> hVar = nzO;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void d(g<? super Throwable> gVar) {
        if (nzZ) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        nzH = gVar;
    }

    public static <T> org.a.c<? super T> a(io.reactivex.g<T> gVar, org.a.c<? super T> cVar) {
        c<? super io.reactivex.g, ? super org.a.c, ? extends org.a.c> cVar2 = nzT;
        return cVar2 != null ? (org.a.c) a(cVar2, gVar, cVar) : cVar;
    }

    public static <T> u<? super T> a(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = nzV;
        return cVar != null ? (u) a(cVar, qVar, uVar) : uVar;
    }

    public static <T> y<? super T> a(w<T> wVar, y<? super T> yVar) {
        c<? super w, ? super y, ? extends y> cVar = nzW;
        return cVar != null ? (y) a(cVar, wVar, yVar) : yVar;
    }

    public static io.reactivex.c a(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = nzX;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        c<? super k, ? super m, ? extends m> cVar = nzU;
        return cVar != null ? (m) a(cVar, kVar, mVar) : mVar;
    }

    public static <T> io.reactivex.g<T> a(io.reactivex.g<T> gVar) {
        h<? super io.reactivex.g, ? extends io.reactivex.g> hVar = nzR;
        return hVar != null ? (io.reactivex.g) a((h<io.reactivex.g<T>, Object>) hVar, gVar) : gVar;
    }

    public static <T> q<T> a(q<T> qVar) {
        h<? super q, ? extends q> hVar = nzS;
        return hVar != null ? (q) a((h<q<T>, Object>) hVar, qVar) : qVar;
    }

    public static boolean dIz() {
        e eVar = nzY;
        if (eVar != null) {
            try {
                return eVar.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.K(th);
            }
        }
        return false;
    }

    static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.K(th);
        }
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.K(th);
        }
    }

    static v e(Callable<v> callable) {
        try {
            return (v) io.reactivex.internal.functions.a.h(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.K(th);
        }
    }

    static v a(h<? super Callable<v>, ? extends v> hVar, Callable<v> callable) {
        return (v) io.reactivex.internal.functions.a.h(a((h<Callable<v>, Object>) hVar, callable), "Scheduler Callable result can't be null");
    }
}
