package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.cq;
import rx.internal.operators.ct;
import rx.k;
/* loaded from: classes2.dex */
public final class c {
    static volatile rx.functions.b<Throwable> iOD;
    static volatile rx.functions.f<d.a, d.a> iRH;
    static volatile rx.functions.f<h.a, h.a> iRI;
    static volatile rx.functions.f<b.a, b.a> iRJ;
    static volatile rx.functions.g<rx.d, d.a, d.a> iRK;
    static volatile rx.functions.g<rx.h, h.a, h.a> iRL;
    static volatile rx.functions.g<rx.b, b.a, b.a> iRM;
    static volatile rx.functions.f<rx.g, rx.g> iRN;
    static volatile rx.functions.f<rx.g, rx.g> iRO;
    static volatile rx.functions.f<rx.g, rx.g> iRP;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> iRQ;
    static volatile rx.functions.f<k, k> iRR;
    static volatile rx.functions.f<k, k> iRS;
    static volatile rx.functions.e<? extends ScheduledExecutorService> iRT;
    static volatile rx.functions.f<Throwable, Throwable> iRU;
    static volatile rx.functions.f<Throwable, Throwable> iRV;
    static volatile rx.functions.f<Throwable, Throwable> iRW;
    static volatile rx.functions.f<d.b, d.b> iRX;
    static volatile rx.functions.f<d.b, d.b> iRY;
    static volatile rx.functions.f<b.InterfaceC0406b, b.InterfaceC0406b> iRZ;

    static {
        init();
    }

    static void init() {
        iOD = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cgp().cgq().C(th);
            }
        };
        iRK = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cgp().cgr().c(dVar, aVar);
            }
        };
        iRR = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.cgp().cgr().f(kVar);
            }
        };
        iRL = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cgs = f.cgp().cgs();
                return cgs == i.cgC() ? aVar : new cq(cgs.a(hVar, new ct(aVar)));
            }
        };
        iRS = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.cgp().cgs().f(kVar);
            }
        };
        iRM = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cgp().cgt().a(bVar, aVar);
            }
        };
        iRQ = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: h */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cgp().cgu().b(aVar);
            }
        };
        iRU = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cgp().cgr().U(th);
            }
        };
        iRX = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.cgp().cgr().d(bVar);
            }
        };
        iRV = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cgp().cgs().U(th);
            }
        };
        iRY = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.cgp().cgs().d(bVar);
            }
        };
        iRW = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cgp().cgt().U(th);
            }
        };
        iRZ = new rx.functions.f<b.InterfaceC0406b, b.InterfaceC0406b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0406b call(b.InterfaceC0406b interfaceC0406b) {
                return f.cgp().cgt().a(interfaceC0406b);
            }
        };
        cgm();
    }

    static void cgm() {
        iRH = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public d.a call(d.a aVar) {
                return f.cgp().cgr().a(aVar);
            }
        };
        iRI = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cgp().cgs().b(aVar);
            }
        };
        iRJ = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cgp().cgt().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = iOD;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                V(th2);
            }
        }
        V(th);
    }

    static void V(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> a(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = iRH;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = iRI;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = iRJ;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g d(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iRN;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g e(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iRO;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g f(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iRP;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a g(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = iRQ;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = iRK;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = iRR;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iRU;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> a(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iRX;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = iRL;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k d(k kVar) {
        rx.functions.f<k, k> fVar = iRS;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iRV;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iRY;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = iRM;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iRW;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cgn() {
        return iRT;
    }
}
