package rx;
/* loaded from: classes2.dex */
public class b {
    static final b kvp = new b(new a() { // from class: rx.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: c */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.cRo());
            cVar.onCompleted();
        }
    }, false);
    static final b kvq = new b(new a() { // from class: rx.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: c */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.cRo());
        }
    }, false);
    private final a kvo;

    /* loaded from: classes2.dex */
    public interface a extends rx.functions.b<c> {
    }

    /* renamed from: rx.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0506b extends rx.functions.f<c, c> {
    }

    public static b a(a aVar) {
        bk(aVar);
        try {
            return new b(aVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.c.c.onError(th);
            throw F(th);
        }
    }

    static <T> T bk(T t) {
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
        this.kvo = rx.c.c.b(aVar);
    }

    protected b(a aVar, boolean z) {
        this.kvo = z ? rx.c.c.b(aVar) : aVar;
    }

    public final k cPh() {
        final rx.subscriptions.c cVar = new rx.subscriptions.c();
        a(new c() { // from class: rx.b.3
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
                cVar.f(kVar);
            }
        });
        return cVar;
    }

    static void G(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final void a(c cVar) {
        bk(cVar);
        try {
            rx.c.c.b(this, this.kvo).call(cVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.exceptions.a.K(th);
            Throwable W = rx.c.c.W(th);
            rx.c.c.onError(W);
            throw F(W);
        }
    }

    public final void b(c cVar) {
        if (!(cVar instanceof rx.b.b)) {
            cVar = new rx.b.b(cVar);
        }
        a(cVar);
    }
}
