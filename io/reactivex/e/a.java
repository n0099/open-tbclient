package io.reactivex.e;

import io.reactivex.c.c;
import io.reactivex.c.e;
import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.g;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class a {
    static volatile h<? super Callable<v>, ? extends v> oqA;
    static volatile h<? super Callable<v>, ? extends v> oqB;
    static volatile h<? super Callable<v>, ? extends v> oqC;
    static volatile h<? super Callable<v>, ? extends v> oqD;
    static volatile h<? super v, ? extends v> oqE;
    static volatile h<? super v, ? extends v> oqF;
    static volatile h<? super v, ? extends v> oqG;
    static volatile h<? super v, ? extends v> oqH;
    static volatile h<? super g, ? extends g> oqI;
    static volatile h<? super q, ? extends q> oqJ;
    static volatile c<? super g, ? super org.b.c, ? extends org.b.c> oqK;
    static volatile c<? super k, ? super m, ? extends m> oqL;
    static volatile c<? super q, ? super u, ? extends u> oqM;
    static volatile c<? super w, ? super y, ? extends y> oqN;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> oqO;
    static volatile e oqP;
    static volatile boolean oqQ;
    static volatile boolean oqR;
    static volatile io.reactivex.c.g<? super Throwable> oqy;
    static volatile h<? super Runnable, ? extends Runnable> oqz;

    public static boolean efv() {
        return oqR;
    }

    public static v f(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqA;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v g(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqC;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v h(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqD;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v i(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqB;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v f(v vVar) {
        h<? super v, ? extends v> hVar = oqE;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void onError(Throwable th) {
        io.reactivex.c.g<? super Throwable> gVar = oqy;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!N(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                O(th2);
            }
        }
        th.printStackTrace();
        O(th);
    }

    static boolean N(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    static void O(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static v g(v vVar) {
        h<? super v, ? extends v> hVar = oqG;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static v h(v vVar) {
        h<? super v, ? extends v> hVar = oqH;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static Runnable I(Runnable runnable) {
        io.reactivex.internal.functions.a.k(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = oqz;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, Object>) hVar, runnable);
    }

    public static v i(v vVar) {
        h<? super v, ? extends v> hVar = oqF;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void d(io.reactivex.c.g<? super Throwable> gVar) {
        if (oqQ) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        oqy = gVar;
    }

    public static <T> org.b.c<? super T> a(g<T> gVar, org.b.c<? super T> cVar) {
        c<? super g, ? super org.b.c, ? extends org.b.c> cVar2 = oqK;
        return cVar2 != null ? (org.b.c) a(cVar2, gVar, cVar) : cVar;
    }

    public static <T> u<? super T> a(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = oqM;
        return cVar != null ? (u) a(cVar, qVar, uVar) : uVar;
    }

    public static <T> y<? super T> a(w<T> wVar, y<? super T> yVar) {
        c<? super w, ? super y, ? extends y> cVar = oqN;
        return cVar != null ? (y) a(cVar, wVar, yVar) : yVar;
    }

    public static io.reactivex.c a(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = oqO;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        c<? super k, ? super m, ? extends m> cVar = oqL;
        return cVar != null ? (m) a(cVar, kVar, mVar) : mVar;
    }

    public static <T> g<T> a(g<T> gVar) {
        h<? super g, ? extends g> hVar = oqI;
        return hVar != null ? (g) a((h<g<T>, Object>) hVar, gVar) : gVar;
    }

    public static <T> q<T> a(q<T> qVar) {
        h<? super q, ? extends q> hVar = oqJ;
        return hVar != null ? (q) a((h<q<T>, Object>) hVar, qVar) : qVar;
    }

    public static boolean efw() {
        e eVar = oqP;
        if (eVar != null) {
            try {
                return eVar.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.L(th);
            }
        }
        return false;
    }

    static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.L(th);
        }
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.L(th);
        }
    }

    static v e(Callable<v> callable) {
        try {
            return (v) io.reactivex.internal.functions.a.k(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.L(th);
        }
    }

    static v a(h<? super Callable<v>, ? extends v> hVar, Callable<v> callable) {
        return (v) io.reactivex.internal.functions.a.k(a((h<Callable<v>, Object>) hVar, callable), "Scheduler Callable result can't be null");
    }
}
