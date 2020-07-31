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
    static volatile h<? super Runnable, ? extends Runnable> nWA;
    static volatile h<? super Callable<v>, ? extends v> nWB;
    static volatile h<? super Callable<v>, ? extends v> nWC;
    static volatile h<? super Callable<v>, ? extends v> nWD;
    static volatile h<? super Callable<v>, ? extends v> nWE;
    static volatile h<? super v, ? extends v> nWF;
    static volatile h<? super v, ? extends v> nWG;
    static volatile h<? super v, ? extends v> nWH;
    static volatile h<? super v, ? extends v> nWI;
    static volatile h<? super g, ? extends g> nWJ;
    static volatile h<? super q, ? extends q> nWK;
    static volatile c<? super g, ? super org.a.c, ? extends org.a.c> nWL;
    static volatile c<? super k, ? super m, ? extends m> nWM;
    static volatile c<? super q, ? super u, ? extends u> nWN;
    static volatile c<? super w, ? super y, ? extends y> nWO;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> nWP;
    static volatile e nWQ;
    static volatile boolean nWR;
    static volatile boolean nWS;
    static volatile io.reactivex.c.g<? super Throwable> nWz;

    public static boolean dTs() {
        return nWS;
    }

    public static v f(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nWB;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v g(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nWD;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v h(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nWE;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v i(Callable<v> callable) {
        io.reactivex.internal.functions.a.k(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = nWC;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v f(v vVar) {
        h<? super v, ? extends v> hVar = nWF;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void onError(Throwable th) {
        io.reactivex.c.g<? super Throwable> gVar = nWz;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!O(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                P(th2);
            }
        }
        th.printStackTrace();
        P(th);
    }

    static boolean O(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    static void P(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static v g(v vVar) {
        h<? super v, ? extends v> hVar = nWH;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static v h(v vVar) {
        h<? super v, ? extends v> hVar = nWI;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static Runnable L(Runnable runnable) {
        io.reactivex.internal.functions.a.k(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = nWA;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, Object>) hVar, runnable);
    }

    public static v i(v vVar) {
        h<? super v, ? extends v> hVar = nWG;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static void d(io.reactivex.c.g<? super Throwable> gVar) {
        if (nWR) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        nWz = gVar;
    }

    public static <T> org.a.c<? super T> a(g<T> gVar, org.a.c<? super T> cVar) {
        c<? super g, ? super org.a.c, ? extends org.a.c> cVar2 = nWL;
        return cVar2 != null ? (org.a.c) a(cVar2, gVar, cVar) : cVar;
    }

    public static <T> u<? super T> a(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = nWN;
        return cVar != null ? (u) a(cVar, qVar, uVar) : uVar;
    }

    public static <T> y<? super T> a(w<T> wVar, y<? super T> yVar) {
        c<? super w, ? super y, ? extends y> cVar = nWO;
        return cVar != null ? (y) a(cVar, wVar, yVar) : yVar;
    }

    public static io.reactivex.c a(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = nWP;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        c<? super k, ? super m, ? extends m> cVar = nWM;
        return cVar != null ? (m) a(cVar, kVar, mVar) : mVar;
    }

    public static <T> g<T> a(g<T> gVar) {
        h<? super g, ? extends g> hVar = nWJ;
        return hVar != null ? (g) a((h<g<T>, Object>) hVar, gVar) : gVar;
    }

    public static <T> q<T> a(q<T> qVar) {
        h<? super q, ? extends q> hVar = nWK;
        return hVar != null ? (q) a((h<q<T>, Object>) hVar, qVar) : qVar;
    }

    public static boolean dTt() {
        e eVar = nWQ;
        if (eVar != null) {
            try {
                return eVar.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.M(th);
            }
        }
        return false;
    }

    static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.M(th);
        }
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.M(th);
        }
    }

    static v e(Callable<v> callable) {
        try {
            return (v) io.reactivex.internal.functions.a.k(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.M(th);
        }
    }

    static v a(h<? super Callable<v>, ? extends v> hVar, Callable<v> callable) {
        return (v) io.reactivex.internal.functions.a.k(a((h<Callable<v>, Object>) hVar, callable), "Scheduler Callable result can't be null");
    }
}
