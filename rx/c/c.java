package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.q;
import rx.internal.operators.t;
import rx.k;
/* loaded from: classes2.dex */
public final class c {
    static volatile rx.functions.b<Throwable> jZr;
    static volatile rx.functions.f<d.a, d.a> kbZ;
    static volatile rx.functions.f<h.a, h.a> kca;
    static volatile rx.functions.f<b.a, b.a> kcb;
    static volatile rx.functions.g<rx.d, d.a, d.a> kcc;
    static volatile rx.functions.g<rx.h, h.a, h.a> kcd;
    static volatile rx.functions.g<rx.b, b.a, b.a> kce;
    static volatile rx.functions.f<rx.g, rx.g> kcf;
    static volatile rx.functions.f<rx.g, rx.g> kcg;
    static volatile rx.functions.f<rx.g, rx.g> kch;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> kci;
    static volatile rx.functions.f<k, k> kcj;
    static volatile rx.functions.f<k, k> kck;
    static volatile rx.functions.e<? extends ScheduledExecutorService> kcl;
    static volatile rx.functions.f<Throwable, Throwable> kcm;
    static volatile rx.functions.f<Throwable, Throwable> kcn;
    static volatile rx.functions.f<Throwable, Throwable> kco;
    static volatile rx.functions.f<d.b, d.b> kcp;
    static volatile rx.functions.f<d.b, d.b> kcq;
    static volatile rx.functions.f<b.InterfaceC0384b, b.InterfaceC0384b> kcr;

    static {
        init();
    }

    static void init() {
        jZr = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cFa().cFb().D(th);
            }
        };
        kcc = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cFa().cFc().c(dVar, aVar);
            }
        };
        kcj = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cFa().cFc().e(kVar);
            }
        };
        kcd = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cFd = f.cFa().cFd();
                return cFd == i.cFn() ? aVar : new q(cFd.a(hVar, new t(aVar)));
            }
        };
        kck = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cFa().cFd().e(kVar);
            }
        };
        kce = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cFa().cFe().a(bVar, aVar);
            }
        };
        kci = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cFa().cFf().d(aVar);
            }
        };
        kcm = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Y */
            public Throwable call(Throwable th) {
                return f.cFa().cFc().T(th);
            }
        };
        kcp = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cFa().cFc().e(bVar);
            }
        };
        kcn = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Y */
            public Throwable call(Throwable th) {
                return f.cFa().cFd().T(th);
            }
        };
        kcq = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cFa().cFd().e(bVar);
            }
        };
        kco = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Y */
            public Throwable call(Throwable th) {
                return f.cFa().cFe().T(th);
            }
        };
        kcr = new rx.functions.f<b.InterfaceC0384b, b.InterfaceC0384b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0384b call(b.InterfaceC0384b interfaceC0384b) {
                return f.cFa().cFe().a(interfaceC0384b);
            }
        };
        cEX();
    }

    static void cEX() {
        kbZ = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cFa().cFc().b(aVar);
            }
        };
        kca = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cFa().cFd().b(aVar);
            }
        };
        kcb = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cFa().cFe().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = jZr;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                U(th2);
            }
        }
        U(th);
    }

    static void U(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = kbZ;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = kca;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = kcb;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kcf;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kcg;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kch;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = kci;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = kcc;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = kcj;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kcm;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kcp;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = kcd;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = kck;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kcn;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kcq;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = kce;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kco;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cEY() {
        return kcl;
    }
}
