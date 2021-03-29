package f.a.a0;

import f.a.b;
import f.a.e;
import f.a.i;
import f.a.l;
import f.a.o;
import f.a.q;
import f.a.r;
import f.a.w.c;
import f.a.w.g;
import f.a.w.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g<? super Throwable> f67445a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile h<? super Runnable, ? extends Runnable> f67446b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c<? super e, ? super g.d.c, ? extends g.d.c> f67447c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c<? super f.a.h, ? super i, ? extends i> f67448d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile c<? super l, ? super o, ? extends o> f67449e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile c<? super q, ? super r, ? extends r> f67450f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c<? super f.a.a, ? super b, ? extends b> f67451g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile f.a.w.e f67452h;
    public static volatile boolean i;

    public static <T, U, R> R a(c<T, U, R> cVar, T t, U u) {
        try {
            return cVar.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.c(th);
        }
    }

    public static <T, R> R b(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.c(th);
        }
    }

    public static boolean c(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static boolean d() {
        return i;
    }

    public static boolean e() {
        f.a.w.e eVar = f67452h;
        if (eVar != null) {
            try {
                return eVar.getAsBoolean();
            } catch (Throwable th) {
                throw ExceptionHelper.c(th);
            }
        }
        return false;
    }

    public static void f(Throwable th) {
        g<? super Throwable> gVar = f67445a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!c(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m(th2);
            }
        }
        th.printStackTrace();
        m(th);
    }

    public static Runnable g(Runnable runnable) {
        f.a.x.b.a.b(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = f67446b;
        return hVar == null ? runnable : (Runnable) b(hVar, runnable);
    }

    public static b h(f.a.a aVar, b bVar) {
        c<? super f.a.a, ? super b, ? extends b> cVar = f67451g;
        return cVar != null ? (b) a(cVar, aVar, bVar) : bVar;
    }

    public static <T> i<? super T> i(f.a.h<T> hVar, i<? super T> iVar) {
        c<? super f.a.h, ? super i, ? extends i> cVar = f67448d;
        return cVar != null ? (i) a(cVar, hVar, iVar) : iVar;
    }

    public static <T> o<? super T> j(l<T> lVar, o<? super T> oVar) {
        c<? super l, ? super o, ? extends o> cVar = f67449e;
        return cVar != null ? (o) a(cVar, lVar, oVar) : oVar;
    }

    public static <T> r<? super T> k(q<T> qVar, r<? super T> rVar) {
        c<? super q, ? super r, ? extends r> cVar = f67450f;
        return cVar != null ? (r) a(cVar, qVar, rVar) : rVar;
    }

    public static <T> g.d.c<? super T> l(e<T> eVar, g.d.c<? super T> cVar) {
        c<? super e, ? super g.d.c, ? extends g.d.c> cVar2 = f67447c;
        return cVar2 != null ? (g.d.c) a(cVar2, eVar, cVar) : cVar;
    }

    public static void m(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
