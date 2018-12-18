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
    static volatile rx.functions.b<Throwable> iKm;
    static volatile rx.functions.f<k, k> iNA;
    static volatile rx.functions.f<k, k> iNB;
    static volatile rx.functions.e<? extends ScheduledExecutorService> iNC;
    static volatile rx.functions.f<Throwable, Throwable> iND;
    static volatile rx.functions.f<Throwable, Throwable> iNE;
    static volatile rx.functions.f<Throwable, Throwable> iNF;
    static volatile rx.functions.f<d.b, d.b> iNG;
    static volatile rx.functions.f<d.b, d.b> iNH;
    static volatile rx.functions.f<b.InterfaceC0407b, b.InterfaceC0407b> iNI;
    static volatile rx.functions.f<d.a, d.a> iNq;
    static volatile rx.functions.f<h.a, h.a> iNr;
    static volatile rx.functions.f<b.a, b.a> iNs;
    static volatile rx.functions.g<rx.d, d.a, d.a> iNt;
    static volatile rx.functions.g<rx.h, h.a, h.a> iNu;
    static volatile rx.functions.g<rx.b, b.a, b.a> iNv;
    static volatile rx.functions.f<rx.g, rx.g> iNw;
    static volatile rx.functions.f<rx.g, rx.g> iNx;
    static volatile rx.functions.f<rx.g, rx.g> iNy;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> iNz;

    static {
        init();
    }

    static void init() {
        iKm = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.ceQ().ceR().C(th);
            }
        };
        iNt = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.ceQ().ceS().c(dVar, aVar);
            }
        };
        iNA = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.ceQ().ceS().f(kVar);
            }
        };
        iNu = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h ceT = f.ceQ().ceT();
                return ceT == i.cfd() ? aVar : new cq(ceT.a(hVar, new ct(aVar)));
            }
        };
        iNB = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.ceQ().ceT().f(kVar);
            }
        };
        iNv = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.ceQ().ceU().a(bVar, aVar);
            }
        };
        iNz = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: h */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.ceQ().ceV().b(aVar);
            }
        };
        iND = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.ceQ().ceS().U(th);
            }
        };
        iNG = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.ceQ().ceS().d(bVar);
            }
        };
        iNE = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.ceQ().ceT().U(th);
            }
        };
        iNH = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.ceQ().ceT().d(bVar);
            }
        };
        iNF = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.ceQ().ceU().U(th);
            }
        };
        iNI = new rx.functions.f<b.InterfaceC0407b, b.InterfaceC0407b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0407b call(b.InterfaceC0407b interfaceC0407b) {
                return f.ceQ().ceU().a(interfaceC0407b);
            }
        };
        ceN();
    }

    static void ceN() {
        iNq = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public d.a call(d.a aVar) {
                return f.ceQ().ceS().a(aVar);
            }
        };
        iNr = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.ceQ().ceT().b(aVar);
            }
        };
        iNs = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.ceQ().ceU().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = iKm;
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
        rx.functions.f<d.a, d.a> fVar = iNq;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = iNr;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = iNs;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g d(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iNw;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g e(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iNx;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g f(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iNy;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a g(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = iNz;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = iNt;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = iNA;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iND;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> a(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iNG;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = iNu;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k d(k kVar) {
        rx.functions.f<k, k> fVar = iNB;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iNE;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iNH;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = iNv;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iNF;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> ceO() {
        return iNC;
    }
}
