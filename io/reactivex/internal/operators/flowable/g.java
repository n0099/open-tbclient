package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public final class g {
    public static <T, R> boolean a(org.a.b<T> bVar, org.a.c<? super R> cVar, h<? super T, ? extends org.a.b<? extends R>> hVar) {
        if (bVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) bVar).call();
                if (obj == 0) {
                    EmptySubscription.complete(cVar);
                    return true;
                }
                try {
                    org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.l(hVar.apply(obj), "The mapper returned a null Publisher");
                    if (bVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) bVar2).call();
                            if (call == null) {
                                EmptySubscription.complete(cVar);
                                return true;
                            }
                            cVar.onSubscribe(new ScalarSubscription(cVar, call));
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.J(th);
                            EmptySubscription.error(th, cVar);
                            return true;
                        }
                    } else {
                        bVar2.subscribe(cVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.J(th2);
                    EmptySubscription.error(th2, cVar);
                    return true;
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.J(th3);
                EmptySubscription.error(th3, cVar);
                return true;
            }
        }
        return false;
    }
}
