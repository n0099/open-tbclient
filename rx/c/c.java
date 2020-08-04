package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes6.dex */
public final class c {
    static volatile rx.functions.b<Throwable> onv;
    static volatile rx.functions.g<rx.h, h.a, h.a> opA;
    static volatile rx.functions.g<rx.b, b.a, b.a> opB;
    static volatile rx.functions.f<rx.g, rx.g> opC;
    static volatile rx.functions.f<rx.g, rx.g> opD;
    static volatile rx.functions.f<rx.g, rx.g> opE;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> opF;
    static volatile rx.functions.f<k, k> opG;
    static volatile rx.functions.f<k, k> opH;
    static volatile rx.functions.e<? extends ScheduledExecutorService> opI;
    static volatile rx.functions.f<Throwable, Throwable> opJ;
    static volatile rx.functions.f<Throwable, Throwable> opK;
    static volatile rx.functions.f<Throwable, Throwable> opL;
    static volatile rx.functions.f<d.b, d.b> opM;
    static volatile rx.functions.f<d.b, d.b> opN;
    static volatile rx.functions.f<b.InterfaceC0930b, b.InterfaceC0930b> opO;
    static volatile rx.functions.f<d.a, d.a> opw;
    static volatile rx.functions.f<h.a, h.a> opx;
    static volatile rx.functions.f<b.a, b.a> opy;
    static volatile rx.functions.g<rx.d, d.a, d.a> opz;

    static {
        init();
    }

    static void init() {
        onv = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dYL().dYM().G(th);
            }
        };
        opz = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.dYL().dYN().c(dVar, aVar);
            }
        };
        opG = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dYL().dYN().e(kVar);
            }
        };
        opA = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h dYO = f.dYL().dYO();
                return dYO == i.dYY() ? aVar : new t(dYO.a(hVar, new w(aVar)));
            }
        };
        opH = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dYL().dYO().e(kVar);
            }
        };
        opB = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.dYL().dYP().a(bVar, aVar);
            }
        };
        opF = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dYL().dYQ().d(aVar);
            }
        };
        opJ = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ae */
            public Throwable call(Throwable th) {
                return f.dYL().dYN().Z(th);
            }
        };
        opM = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dYL().dYN().e(bVar);
            }
        };
        opK = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ae */
            public Throwable call(Throwable th) {
                return f.dYL().dYO().Z(th);
            }
        };
        opN = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dYL().dYO().e(bVar);
            }
        };
        opL = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ae */
            public Throwable call(Throwable th) {
                return f.dYL().dYP().Z(th);
            }
        };
        opO = new rx.functions.f<b.InterfaceC0930b, b.InterfaceC0930b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0930b call(b.InterfaceC0930b interfaceC0930b) {
                return f.dYL().dYP().a(interfaceC0930b);
            }
        };
        dYI();
    }

    static void dYI() {
        opw = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dYL().dYN().b(aVar);
            }
        };
        opx = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dYL().dYO().b(aVar);
            }
        };
        opy = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dYL().dYP().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = onv;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                aa(th2);
            }
        }
        aa(th);
    }

    static void aa(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = opw;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = opx;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = opy;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = opC;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = opD;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = opE;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = opF;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = opz;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = opG;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ab(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = opJ;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = opM;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = opA;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = opH;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = opK;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = opN;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = opB;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = opL;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dYJ() {
        return opI;
    }
}
