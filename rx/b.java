package rx;
/* loaded from: classes2.dex */
public class b {
    static final b iDT = new b(new a() { // from class: rx.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: c */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.cgk());
            cVar.onCompleted();
        }
    }, false);
    static final b iDU = new b(new a() { // from class: rx.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: c */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.cgk());
        }
    }, false);
    private final a iDS;

    /* loaded from: classes2.dex */
    public interface a extends rx.functions.b<c> {
    }

    /* renamed from: rx.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0407b extends rx.functions.f<c, c> {
    }

    public static b a(a aVar) {
        requireNonNull(aVar);
        try {
            return new b(aVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.c.c.onError(th);
            throw F(th);
        }
    }

    public static b a(final d<?> dVar) {
        requireNonNull(dVar);
        return a(new a() { // from class: rx.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: c */
            public void call(final c cVar) {
                j<Object> jVar = new j<Object>() { // from class: rx.b.2.1
                    @Override // rx.e
                    public void onCompleted() {
                        cVar.onCompleted();
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        cVar.onError(th);
                    }

                    @Override // rx.e
                    public void onNext(Object obj) {
                    }
                };
                cVar.onSubscribe(jVar);
                d.this.unsafeSubscribe(jVar);
            }
        });
    }

    static <T> T requireNonNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    static NullPointerException F(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    protected b(a aVar) {
        this.iDS = rx.c.c.b(aVar);
    }

    protected b(a aVar, boolean z) {
        this.iDS = z ? rx.c.c.b(aVar) : aVar;
    }

    public final k subscribe() {
        final rx.subscriptions.c cVar = new rx.subscriptions.c();
        a(new c() { // from class: rx.b.4
            @Override // rx.c
            public void onCompleted() {
                cVar.unsubscribe();
            }

            @Override // rx.c
            public void onError(Throwable th) {
                rx.c.c.onError(th);
                cVar.unsubscribe();
                b.G(th);
            }

            @Override // rx.c
            public void onSubscribe(k kVar) {
                cVar.g(kVar);
            }
        });
        return cVar;
    }

    static void G(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final void a(c cVar) {
        requireNonNull(cVar);
        try {
            rx.c.c.b(this, this.iDS).call(cVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            Throwable Y = rx.c.c.Y(th);
            rx.c.c.onError(Y);
            throw F(Y);
        }
    }

    public final void b(c cVar) {
        if (!(cVar instanceof rx.b.c)) {
            cVar = new rx.b.c(cVar);
        }
        a(cVar);
    }
}
