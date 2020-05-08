package rx;

import rx.g;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes6.dex */
public class b {
    static final b niD = new b(new a() { // from class: rx.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.dIZ());
            cVar.onCompleted();
        }
    }, false);
    static final b niE = new b(new a() { // from class: rx.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: a */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.dIZ());
        }
    }, false);
    private final a niC;

    /* loaded from: classes6.dex */
    public interface a extends rx.functions.b<c> {
    }

    /* renamed from: rx.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0832b extends rx.functions.f<c, c> {
    }

    public static b l(Iterable<? extends b> iterable) {
        bJ(iterable);
        return a(new CompletableOnSubscribeConcatIterable(iterable));
    }

    public static b a(a aVar) {
        bJ(aVar);
        try {
            return new b(aVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.c.c.onError(th);
            throw J(th);
        }
    }

    static <T> T bJ(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    static NullPointerException J(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    protected b(a aVar) {
        this.niC = rx.c.c.b(aVar);
    }

    protected b(a aVar, boolean z) {
        this.niC = z ? rx.c.c.b(aVar) : aVar;
    }

    public final b a(final g gVar) {
        bJ(gVar);
        return a(new a() { // from class: rx.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(final c cVar) {
                final rx.internal.util.i iVar = new rx.internal.util.i();
                final g.a createWorker = gVar.createWorker();
                iVar.add(createWorker);
                cVar.onSubscribe(iVar);
                b.this.b(new c() { // from class: rx.b.3.1
                    @Override // rx.c
                    public void onCompleted() {
                        createWorker.c(new rx.functions.a() { // from class: rx.b.3.1.1
                            @Override // rx.functions.a
                            public void call() {
                                try {
                                    cVar.onCompleted();
                                } finally {
                                    iVar.unsubscribe();
                                }
                            }
                        });
                    }

                    @Override // rx.c
                    public void onError(final Throwable th) {
                        createWorker.c(new rx.functions.a() { // from class: rx.b.3.1.2
                            @Override // rx.functions.a
                            public void call() {
                                try {
                                    cVar.onError(th);
                                } finally {
                                    iVar.unsubscribe();
                                }
                            }
                        });
                    }

                    @Override // rx.c
                    public void onSubscribe(k kVar) {
                        iVar.add(kVar);
                    }
                });
            }
        });
    }

    public final k dHi() {
        final rx.subscriptions.c cVar = new rx.subscriptions.c();
        b(new c() { // from class: rx.b.4
            @Override // rx.c
            public void onCompleted() {
                cVar.unsubscribe();
            }

            @Override // rx.c
            public void onError(Throwable th) {
                rx.c.c.onError(th);
                cVar.unsubscribe();
                b.T(th);
            }

            @Override // rx.c
            public void onSubscribe(k kVar) {
                cVar.f(kVar);
            }
        });
        return cVar;
    }

    static void T(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final void b(c cVar) {
        bJ(cVar);
        try {
            rx.c.c.b(this, this.niC).call(cVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            Throwable ae = rx.c.c.ae(th);
            rx.c.c.onError(ae);
            throw J(ae);
        }
    }

    public final void c(c cVar) {
        if (!(cVar instanceof rx.b.b)) {
            cVar = new rx.b.b(cVar);
        }
        b(cVar);
    }

    public final b b(final g gVar) {
        bJ(gVar);
        return a(new a() { // from class: rx.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(final c cVar) {
                final g.a createWorker = gVar.createWorker();
                createWorker.c(new rx.functions.a() { // from class: rx.b.5.1
                    @Override // rx.functions.a
                    public void call() {
                        try {
                            b.this.b(cVar);
                        } finally {
                            createWorker.unsubscribe();
                        }
                    }
                });
            }
        });
    }
}
