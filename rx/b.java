package rx;
/* loaded from: classes2.dex */
public class b {
    static final b kyq = new b(new a() { // from class: rx.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: c */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.cQf());
            cVar.onCompleted();
        }
    }, false);
    static final b kyr = new b(new a() { // from class: rx.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        /* renamed from: c */
        public void call(c cVar) {
            cVar.onSubscribe(rx.subscriptions.e.cQf());
        }
    }, false);
    private final a kyp;

    /* loaded from: classes2.dex */
    public interface a extends rx.functions.b<c> {
    }

    /* renamed from: rx.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0613b extends rx.functions.f<c, c> {
    }

    public static b a(a aVar) {
        bf(aVar);
        try {
            return new b(aVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.c.c.onError(th);
            throw E(th);
        }
    }

    static <T> T bf(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    static NullPointerException E(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    protected b(a aVar) {
        this.kyp = rx.c.c.b(aVar);
    }

    protected b(a aVar, boolean z) {
        this.kyp = z ? rx.c.c.b(aVar) : aVar;
    }

    public final k cOa() {
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
                b.F(th);
            }

            @Override // rx.c
            public void onSubscribe(k kVar) {
                cVar.f(kVar);
            }
        });
        return cVar;
    }

    static void F(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public final void a(c cVar) {
        bf(cVar);
        try {
            rx.c.c.b(this, this.kyp).call(cVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            Throwable V = rx.c.c.V(th);
            rx.c.c.onError(V);
            throw E(V);
        }
    }

    public final void b(c cVar) {
        if (!(cVar instanceof rx.b.b)) {
            cVar = new rx.b.b(cVar);
        }
        a(cVar);
    }
}
