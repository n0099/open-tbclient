package io.reactivex.d;

import io.reactivex.b.c;
import io.reactivex.b.e;
import io.reactivex.b.g;
import io.reactivex.b.h;
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
    static volatile g<? super Throwable> qrL;
    static volatile h<? super Runnable, ? extends Runnable> qrM;
    static volatile h<? super Callable<v>, ? extends v> qrN;
    static volatile h<? super Callable<v>, ? extends v> qrO;
    static volatile h<? super Callable<v>, ? extends v> qrP;
    static volatile h<? super Callable<v>, ? extends v> qrQ;
    static volatile h<? super v, ? extends v> qrR;
    static volatile h<? super io.reactivex.g, ? extends io.reactivex.g> qrS;
    static volatile c<? super io.reactivex.g, ? super org.a.c, ? extends org.a.c> qrT;
    static volatile c<? super k, ? super m, ? extends m> qrU;
    static volatile c<? super q, ? super u, ? extends u> qrV;
    static volatile c<? super w, ? super y, ? extends y> qrW;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> qrX;
    static volatile e qrY;
    static volatile boolean qrZ;

    public static boolean eKG() {
        return qrZ;
    }

    public static v d(Callable<v> callable) {
        io.reactivex.internal.functions.a.m(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = qrN;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static v e(Callable<v> callable) {
        io.reactivex.internal.functions.a.m(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = qrP;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static v f(Callable<v> callable) {
        io.reactivex.internal.functions.a.m(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = qrQ;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static v g(Callable<v> callable) {
        io.reactivex.internal.functions.a.m(callable, "Scheduler Callable can't be null");
        h<? super Callable<v>, ? extends v> hVar = qrO;
        return hVar == null ? h(callable) : a(hVar, callable);
    }

    public static void onError(Throwable th) {
        g<? super Throwable> gVar = qrL;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!Q(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                R(th2);
            }
        }
        th.printStackTrace();
        R(th);
    }

    static boolean Q(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    static void R(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Runnable G(Runnable runnable) {
        io.reactivex.internal.functions.a.m(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = qrM;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, Object>) hVar, runnable);
    }

    public static v a(v vVar) {
        h<? super v, ? extends v> hVar = qrR;
        return hVar == null ? vVar : (v) a((h<v, Object>) hVar, vVar);
    }

    public static <T> org.a.c<? super T> a(io.reactivex.g<T> gVar, org.a.c<? super T> cVar) {
        c<? super io.reactivex.g, ? super org.a.c, ? extends org.a.c> cVar2 = qrT;
        return cVar2 != null ? (org.a.c) a(cVar2, gVar, cVar) : cVar;
    }

    public static <T> u<? super T> a(q<T> qVar, u<? super T> uVar) {
        c<? super q, ? super u, ? extends u> cVar = qrV;
        return cVar != null ? (u) a(cVar, qVar, uVar) : uVar;
    }

    public static <T> y<? super T> a(w<T> wVar, y<? super T> yVar) {
        c<? super w, ? super y, ? extends y> cVar = qrW;
        return cVar != null ? (y) a(cVar, wVar, yVar) : yVar;
    }

    public static io.reactivex.c a(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = qrX;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        c<? super k, ? super m, ? extends m> cVar = qrU;
        return cVar != null ? (m) a(cVar, kVar, mVar) : mVar;
    }

    public static <T> io.reactivex.g<T> a(io.reactivex.g<T> gVar) {
        h<? super io.reactivex.g, ? extends io.reactivex.g> hVar = qrS;
        return hVar != null ? (io.reactivex.g) a((h<io.reactivex.g<T>, Object>) hVar, gVar) : gVar;
    }

    public static boolean eKH() {
        e eVar = qrY;
        if (eVar != null) {
            try {
                return eVar.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.P(th);
            }
        }
        return false;
    }

    static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.P(th);
        }
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.P(th);
        }
    }

    static v h(Callable<v> callable) {
        try {
            return (v) io.reactivex.internal.functions.a.m(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.P(th);
        }
    }

    static v a(h<? super Callable<v>, ? extends v> hVar, Callable<v> callable) {
        return (v) io.reactivex.internal.functions.a.m(a((h<Callable<v>, Object>) hVar, callable), "Scheduler Callable result can't be null");
    }
}
