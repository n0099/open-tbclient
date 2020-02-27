package io.reactivex.a.a;

import io.reactivex.c.h;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes6.dex */
public final class a {
    private static volatile h<Callable<v>, v> nvM;
    private static volatile h<v, v> nvN;

    public static v d(Callable<v> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<Callable<v>, v> hVar = nvM;
        return hVar == null ? e(callable) : a(hVar, callable);
    }

    public static v e(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<v, v> hVar = nvN;
        return hVar == null ? vVar : (v) a(hVar, vVar);
    }

    static v e(Callable<v> callable) {
        try {
            v call = callable.call();
            if (call == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
            return call;
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.t(th);
        }
    }

    static v a(h<Callable<v>, v> hVar, Callable<v> callable) {
        v vVar = (v) a((h<Callable<v>, Object>) hVar, callable);
        if (vVar == null) {
            throw new NullPointerException("Scheduler Callable returned null");
        }
        return vVar;
    }

    static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw io.reactivex.exceptions.a.t(th);
        }
    }
}
