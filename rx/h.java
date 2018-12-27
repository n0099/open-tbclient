package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.internal.operators.co;
import rx.internal.operators.cp;
import rx.internal.operators.cs;
import rx.internal.operators.ct;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class h<T> {
    final a<T> iEm;

    /* loaded from: classes2.dex */
    public interface a<T> extends rx.functions.b<i<? super T>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(a<T> aVar) {
        this.iEm = rx.c.c.b(aVar);
    }

    public static <T> h<T> a(a<T> aVar) {
        return new h<>(aVar);
    }

    private static <T> d<T> a(h<T> hVar) {
        return d.create(new ct(hVar.iEm));
    }

    public static <T> h<T> aW(T t) {
        return rx.internal.util.i.bq(t);
    }

    public final h<T> a(g gVar) {
        if (this instanceof rx.internal.util.i) {
            return ((rx.internal.util.i) this).c(gVar);
        }
        if (gVar == null) {
            throw new NullPointerException("scheduler is null");
        }
        return a((a) new cs(this.iEm, gVar));
    }

    public final k subscribe() {
        return subscribe(Actions.cdR(), Actions.cdS());
    }

    public final k subscribe(final rx.functions.b<? super T> bVar, final rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        return a(new i<T>() { // from class: rx.h.1
            @Override // rx.i
            public final void onError(Throwable th) {
                try {
                    bVar2.call(th);
                } finally {
                    unsubscribe();
                }
            }

            @Override // rx.i
            public final void onSuccess(T t) {
                try {
                    bVar.call(t);
                } finally {
                    unsubscribe();
                }
            }
        });
    }

    public final k a(i<? super T> iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("te is null");
        }
        try {
            rx.c.c.a(this, this.iEm).call(iVar);
            return rx.c.c.d(iVar);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            try {
                iVar.onError(rx.c.c.X(th));
                return rx.subscriptions.e.cgj();
            } catch (Throwable th2) {
                rx.exceptions.a.J(th2);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.c.c.X(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final d<T> cdJ() {
        return a(this);
    }

    public final h<T> a(final rx.functions.b<Throwable> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onError is null");
        }
        return a((a) new cp(this, Actions.cdR(), new rx.functions.b<Throwable>() { // from class: rx.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                bVar.call(th);
            }
        }));
    }

    public final h<T> b(rx.functions.b<? super T> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess is null");
        }
        return a((a) new cp(this, bVar, Actions.cdR()));
    }

    public final h<T> a(long j, TimeUnit timeUnit, g gVar) {
        return a((a) new co(this.iEm, j, timeUnit, gVar));
    }

    public final h<T> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, Schedulers.computation());
    }
}
