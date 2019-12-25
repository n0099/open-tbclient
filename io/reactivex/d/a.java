package io.reactivex.d;

import io.reactivex.b.c;
import io.reactivex.b.e;
import io.reactivex.b.h;
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
/* loaded from: classes4.dex */
public final class a {
    static volatile h<? super v, ? extends v> mXA;
    static volatile h<? super g, ? extends g> mXB;
    static volatile c<? super g, ? super org.a.c, ? extends org.a.c> mXC;
    static volatile c<? super k, ? super m, ? extends m> mXD;
    static volatile c<? super q, ? super u, ? extends u> mXE;
    static volatile c<? super w, ? super y, ? extends y> mXF;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> mXG;
    static volatile e mXH;
    static volatile boolean mXI;
    static volatile io.reactivex.b.g<? super Throwable> mXu;
    static volatile h<? super Runnable, ? extends Runnable> mXv;
    static volatile h<? super Callable<v>, ? extends v> mXw;
    static volatile h<? super Callable<v>, ? extends v> mXx;
    static volatile h<? super Callable<v>, ? extends v> mXy;
    static volatile h<? super Callable<v>, ? extends v> mXz;

    public static boolean dEm() {
        return mXI;
    }

    public static v d(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = mXw;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static v e(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = mXy;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static v f(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = mXz;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static v g(Callable<v> callable) {
        io.reactivex.internal.functions.a.h(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = mXx;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static void onError(Throwable th) {
        io.reactivex.b.g<? super Throwable> gVar = mXu;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!L(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                M(th2);
            }
        }
        th.printStackTrace();
        M(th);
    }

    static boolean L(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    static void M(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Runnable E(Runnable runnable) {
        io.reactivex.internal.functions.a.h(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = mXv;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, Object>) hVar, runnable);
    }

    public static v a(v vVar) {
        h<? super v, ? extends v> hVar = mXA;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static <T> org.a.c<? super T> a(g<T> gVar, org.a.c<? super T> cVar) {
        c<? super g, ? super org.a.c, ? extends org.a.c> cVar2 = mXC;
        return cVar2 != null ? (org.a.c) a(cVar2, gVar, cVar) : cVar;
    }

    public static <T> u<? super T> a(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = mXE;
        return cVar != null ? (u) a(cVar, qVar, uVar) : uVar;
    }

    public static <T> y<? super T> a(w<T> wVar, y<? super T> yVar) {
        c<? super w, ? super y, ? extends y> cVar = mXF;
        return cVar != null ? (y) a(cVar, wVar, yVar) : yVar;
    }

    public static io.reactivex.c a(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = mXG;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        c<? super k, ? super m, ? extends m> cVar = mXD;
        return cVar != null ? (m) a(cVar, kVar, mVar) : mVar;
    }

    public static <T> g<T> a(g<T> gVar) {
        h<? super g, ? extends g> hVar = mXB;
        return hVar != null ? (g) a((h<g<T>, Object>) hVar, gVar) : gVar;
    }

    public static boolean dEn() {
        e eVar = mXH;
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

    static v h(Callable<v> callable) {
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
