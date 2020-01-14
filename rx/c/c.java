package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes5.dex */
public final class c {
    static volatile rx.functions.b<Throwable> nQl;
    static volatile rx.functions.f<Throwable, Throwable> nSA;
    static volatile rx.functions.f<d.b, d.b> nSB;
    static volatile rx.functions.f<d.b, d.b> nSC;
    static volatile rx.functions.f<b.InterfaceC0779b, b.InterfaceC0779b> nSD;
    static volatile rx.functions.f<d.a, d.a> nSl;
    static volatile rx.functions.f<h.a, h.a> nSm;
    static volatile rx.functions.f<b.a, b.a> nSn;
    static volatile rx.functions.g<rx.d, d.a, d.a> nSo;
    static volatile rx.functions.g<rx.h, h.a, h.a> nSp;
    static volatile rx.functions.g<rx.b, b.a, b.a> nSq;
    static volatile rx.functions.f<rx.g, rx.g> nSr;
    static volatile rx.functions.f<rx.g, rx.g> nSs;
    static volatile rx.functions.f<rx.g, rx.g> nSt;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> nSu;
    static volatile rx.functions.f<k, k> nSv;
    static volatile rx.functions.f<k, k> nSw;
    static volatile rx.functions.e<? extends ScheduledExecutorService> nSx;
    static volatile rx.functions.f<Throwable, Throwable> nSy;
    static volatile rx.functions.f<Throwable, Throwable> nSz;

    static {
        init();
    }

    static void init() {
        nQl = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dNJ().dNK().E(th);
            }
        };
        nSo = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.dNJ().dNL().c(dVar, aVar);
            }
        };
        nSv = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dNJ().dNL().e(kVar);
            }
        };
        nSp = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h dNM = f.dNJ().dNM();
                return dNM == i.dNW() ? aVar : new t(dNM.a(hVar, new w(aVar)));
            }
        };
        nSw = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dNJ().dNM().e(kVar);
            }
        };
        nSq = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.dNJ().dNN().a(bVar, aVar);
            }
        };
        nSu = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dNJ().dNO().d(aVar);
            }
        };
        nSy = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ac */
            public Throwable call(Throwable th) {
                return f.dNJ().dNL().X(th);
            }
        };
        nSB = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dNJ().dNL().e(bVar);
            }
        };
        nSz = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ac */
            public Throwable call(Throwable th) {
                return f.dNJ().dNM().X(th);
            }
        };
        nSC = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dNJ().dNM().e(bVar);
            }
        };
        nSA = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ac */
            public Throwable call(Throwable th) {
                return f.dNJ().dNN().X(th);
            }
        };
        nSD = new rx.functions.f<b.InterfaceC0779b, b.InterfaceC0779b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0779b call(b.InterfaceC0779b interfaceC0779b) {
                return f.dNJ().dNN().a(interfaceC0779b);
            }
        };
        dNG();
    }

    static void dNG() {
        nSl = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dNJ().dNL().b(aVar);
            }
        };
        nSm = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dNJ().dNM().b(aVar);
            }
        };
        nSn = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dNJ().dNN().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = nQl;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                Y(th2);
            }
        }
        Y(th);
    }

    static void Y(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = nSl;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = nSm;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = nSn;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nSr;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nSs;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nSt;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = nSu;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = nSo;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = nSv;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Z(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nSy;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = nSB;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = nSp;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = nSw;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nSz;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = nSC;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = nSq;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ab(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nSA;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dNH() {
        return nSx;
    }
}
