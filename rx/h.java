package rx;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.functions.Actions;
import rx.g;
import rx.internal.operators.o;
import rx.internal.operators.p;
import rx.internal.operators.s;
import rx.internal.operators.t;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class h<T> {
    final a<T> jUz;

    /* loaded from: classes2.dex */
    public interface a<T> extends rx.functions.b<i<? super T>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(a<T> aVar) {
        this.jUz = rx.c.c.b(aVar);
    }

    public static <T> h<T> a(a<T> aVar) {
        return new h<>(aVar);
    }

    private static <T> d<T> a(h<T> hVar) {
        return d.a((d.a) new t(hVar.jUz));
    }

    public static <T> h<T> bk(T t) {
        return rx.internal.util.h.bx(t);
    }

    public final h<T> c(g gVar) {
        if (this instanceof rx.internal.util.h) {
            return ((rx.internal.util.h) this).f(gVar);
        }
        if (gVar == null) {
            throw new NullPointerException("scheduler is null");
        }
        return a(new s(this.jUz, gVar));
    }

    public final k cDr() {
        return a(Actions.cDM(), Actions.cDN());
    }

    public final k a(final rx.functions.b<? super T> bVar, final rx.functions.b<Throwable> bVar2) {
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
            rx.c.c.a(this, this.jUz).call(iVar);
            return rx.c.c.c(iVar);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            try {
                iVar.onError(rx.c.c.W(th));
                return rx.subscriptions.e.cFu();
            } catch (Throwable th2) {
                rx.exceptions.a.L(th2);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.c.c.W(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final h<T> d(final g gVar) {
        return this instanceof rx.internal.util.h ? ((rx.internal.util.h) this).f(gVar) : a(new a<T>() { // from class: rx.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: b */
            public void call(final i<? super T> iVar) {
                final g.a createWorker = gVar.createWorker();
                iVar.add(createWorker);
                createWorker.c(new rx.functions.a() { // from class: rx.h.2.1
                    @Override // rx.functions.a
                    public void call() {
                        i<T> iVar2 = new i<T>() { // from class: rx.h.2.1.1
                            @Override // rx.i
                            public void onSuccess(T t) {
                                try {
                                    iVar.onSuccess(t);
                                } finally {
                                    createWorker.unsubscribe();
                                }
                            }

                            @Override // rx.i
                            public void onError(Throwable th) {
                                try {
                                    iVar.onError(th);
                                } finally {
                                    createWorker.unsubscribe();
                                }
                            }
                        };
                        iVar.add(iVar2);
                        h.this.a(iVar2);
                    }
                });
            }
        });
    }

    public final d<T> cDE() {
        return a(this);
    }

    public final h<T> d(final rx.functions.b<Throwable> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onError is null");
        }
        return a(new p(this, Actions.cDM(), new rx.functions.b<Throwable>() { // from class: rx.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                bVar.call(th);
            }
        }));
    }

    public final h<T> e(rx.functions.b<? super T> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess is null");
        }
        return a(new p(this, bVar, Actions.cDM()));
    }

    public final h<T> b(long j, TimeUnit timeUnit, g gVar) {
        return a(new o(this.jUz, j, timeUnit, gVar));
    }

    public final h<T> a(long j, TimeUnit timeUnit) {
        return b(j, timeUnit, Schedulers.computation());
    }
}
