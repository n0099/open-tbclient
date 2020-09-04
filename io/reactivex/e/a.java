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
/* loaded from: classes7.dex */
public final class a {
    static volatile g<? super Throwable> oqQ;
    static volatile h<? super Runnable, ? extends Runnable> oqR;
    static volatile h<? super Callable<v>, ? extends v> oqS;
    static volatile h<? super Callable<v>, ? extends v> oqT;
    static volatile h<? super Callable<v>, ? extends v> oqU;
    static volatile h<? super Callable<v>, ? extends v> oqV;
    static volatile h<? super v, ? extends v> oqW;
    static volatile h<? super v, ? extends v> oqX;
    static volatile h<? super v, ? extends v> oqY;
    static volatile h<? super v, ? extends v> oqZ;
    static volatile h<? super io.reactivex.g, ? extends io.reactivex.g> ora;
    static volatile h<? super q, ? extends q> orb;
    static volatile c<? super io.reactivex.g, ? super org.b.c, ? extends org.b.c> orc;
    static volatile c<? super k, ? super m, ? extends m> ord;
    static volatile c<? super q, ? super u, ? extends u> ore;
    static volatile c<? super w, ? super y, ? extends y> orf;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> orh;
    static volatile e ori;
    static volatile boolean orj;
    static volatile boolean ork;

    public static boolean efE() {
        return ork;
    }

    public static v f(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqS;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v g(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqU;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v h(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqV;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v i(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = oqT;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v f(v vVar) {
        h<? super v, ? extends v> hVar = oqW;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void onError(Throwable th) {
        g<? super Throwable> gVar = oqQ;
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
        h<? super v, ? extends v> hVar = oqY;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static v h(v vVar) {
        h<? super v, ? extends v> hVar = oqZ;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static Runnable I(Runnable runnable) {
        io.reactivex.internal.functions.a.k(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = oqR;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, Object>) hVar, runnable);
    }

    public static v i(v vVar) {
        h<? super v, ? extends v> hVar = oqX;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void d(g<? super Throwable> gVar) {
        if (orj) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        oqQ = gVar;
    }

    public static <T> org.b.c<? super T> a(io.reactivex.g<T> gVar, org.b.c<? super T> cVar) {
        c<? super io.reactivex.g, ? super org.b.c, ? extends org.b.c> cVar2 = orc;
        return cVar2 != null ? (org.b.c) a(cVar2, gVar, cVar) : cVar;
    }

    public static <T> u<? super T> a(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = ore;
        return cVar != null ? (u) a(cVar, qVar, uVar) : uVar;
    }

    public static <T> y<? super T> a(w<T> wVar, y<? super T> yVar) {
        c<? super w, ? super y, ? extends y> cVar = orf;
        return cVar != null ? (y) a(cVar, wVar, yVar) : yVar;
    }

    public static io.reactivex.c a(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = orh;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        c<? super k, ? super m, ? extends m> cVar = ord;
        return cVar != null ? (m) a(cVar, kVar, mVar) : mVar;
    }

    public static <T> io.reactivex.g<T> a(io.reactivex.g<T> gVar) {
        h<? super io.reactivex.g, ? extends io.reactivex.g> hVar = ora;
        return hVar != null ? (io.reactivex.g) a((h<io.reactivex.g<T>, Object>) hVar, gVar) : gVar;
    }

    public static <T> q<T> a(q<T> qVar) {
        h<? super q, ? extends q> hVar = orb;
        return hVar != null ? (q) a((h<q<T>, Object>) hVar, qVar) : qVar;
    }

    public static boolean efF() {
        e eVar = ori;
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
