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
    static volatile rx.functions.b<Throwable> jYC;
    static volatile rx.functions.f<d.b, d.b> kbA;
    static volatile rx.functions.f<d.b, d.b> kbB;
    static volatile rx.functions.f<b.InterfaceC0479b, b.InterfaceC0479b> kbC;
    static volatile rx.functions.f<d.a, d.a> kbk;
    static volatile rx.functions.f<h.a, h.a> kbl;
    static volatile rx.functions.f<b.a, b.a> kbm;
    static volatile rx.functions.g<rx.d, d.a, d.a> kbn;
    static volatile rx.functions.g<rx.h, h.a, h.a> kbo;
    static volatile rx.functions.g<rx.b, b.a, b.a> kbp;
    static volatile rx.functions.f<rx.g, rx.g> kbq;
    static volatile rx.functions.f<rx.g, rx.g> kbr;
    static volatile rx.functions.f<rx.g, rx.g> kbs;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> kbt;
    static volatile rx.functions.f<k, k> kbu;
    static volatile rx.functions.f<k, k> kbv;
    static volatile rx.functions.e<? extends ScheduledExecutorService> kbw;
    static volatile rx.functions.f<Throwable, Throwable> kbx;
    static volatile rx.functions.f<Throwable, Throwable> kby;
    static volatile rx.functions.f<Throwable, Throwable> kbz;

    static {
        init();
    }

    static void init() {
        jYC = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cES().cET().D(th);
            }
        };
        kbn = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cES().cEU().c(dVar, aVar);
            }
        };
        kbu = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cES().cEU().e(kVar);
            }
        };
        kbo = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cEV = f.cES().cEV();
                return cEV == i.cFf() ? aVar : new q(cEV.a(hVar, new t(aVar)));
            }
        };
        kbv = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cES().cEV().e(kVar);
            }
        };
        kbp = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cES().cEW().a(bVar, aVar);
            }
        };
        kbt = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cES().cEX().d(aVar);
            }
        };
        kbx = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Y */
            public Throwable call(Throwable th) {
                return f.cES().cEU().T(th);
            }
        };
        kbA = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cES().cEU().e(bVar);
            }
        };
        kby = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Y */
            public Throwable call(Throwable th) {
                return f.cES().cEV().T(th);
            }
        };
        kbB = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cES().cEV().e(bVar);
            }
        };
        kbz = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Y */
            public Throwable call(Throwable th) {
                return f.cES().cEW().T(th);
            }
        };
        kbC = new rx.functions.f<b.InterfaceC0479b, b.InterfaceC0479b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0479b call(b.InterfaceC0479b interfaceC0479b) {
                return f.cES().cEW().a(interfaceC0479b);
            }
        };
        cEP();
    }

    static void cEP() {
        kbk = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cES().cEU().b(aVar);
            }
        };
        kbl = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cES().cEV().b(aVar);
            }
        };
        kbm = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cES().cEW().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = jYC;
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
        rx.functions.f<d.a, d.a> fVar = kbk;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = kbl;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = kbm;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kbq;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kbr;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kbs;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = kbt;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = kbn;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = kbu;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kbx;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kbA;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = kbo;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = kbv;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kby;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kbB;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = kbp;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kbz;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cEQ() {
        return kbw;
    }
}
