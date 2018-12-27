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
    static volatile rx.functions.b<Throwable> iNw;
    static volatile rx.functions.f<d.a, d.a> iQA;
    static volatile rx.functions.f<h.a, h.a> iQB;
    static volatile rx.functions.f<b.a, b.a> iQC;
    static volatile rx.functions.g<rx.d, d.a, d.a> iQD;
    static volatile rx.functions.g<rx.h, h.a, h.a> iQE;
    static volatile rx.functions.g<rx.b, b.a, b.a> iQF;
    static volatile rx.functions.f<rx.g, rx.g> iQG;
    static volatile rx.functions.f<rx.g, rx.g> iQH;
    static volatile rx.functions.f<rx.g, rx.g> iQI;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> iQJ;
    static volatile rx.functions.f<k, k> iQK;
    static volatile rx.functions.f<k, k> iQL;
    static volatile rx.functions.e<? extends ScheduledExecutorService> iQM;
    static volatile rx.functions.f<Throwable, Throwable> iQN;
    static volatile rx.functions.f<Throwable, Throwable> iQO;
    static volatile rx.functions.f<Throwable, Throwable> iQP;
    static volatile rx.functions.f<d.b, d.b> iQQ;
    static volatile rx.functions.f<d.b, d.b> iQR;
    static volatile rx.functions.f<b.InterfaceC0407b, b.InterfaceC0407b> iQS;

    static {
        init();
    }

    static void init() {
        iNw = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cfH().cfI().C(th);
            }
        };
        iQD = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cfH().cfJ().c(dVar, aVar);
            }
        };
        iQK = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.cfH().cfJ().f(kVar);
            }
        };
        iQE = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cfK = f.cfH().cfK();
                return cfK == i.cfU() ? aVar : new cq(cfK.a(hVar, new ct(aVar)));
            }
        };
        iQL = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.cfH().cfK().f(kVar);
            }
        };
        iQF = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cfH().cfL().a(bVar, aVar);
            }
        };
        iQJ = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: h */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cfH().cfM().b(aVar);
            }
        };
        iQN = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cfH().cfJ().U(th);
            }
        };
        iQQ = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.cfH().cfJ().d(bVar);
            }
        };
        iQO = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cfH().cfK().U(th);
            }
        };
        iQR = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.cfH().cfK().d(bVar);
            }
        };
        iQP = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cfH().cfL().U(th);
            }
        };
        iQS = new rx.functions.f<b.InterfaceC0407b, b.InterfaceC0407b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0407b call(b.InterfaceC0407b interfaceC0407b) {
                return f.cfH().cfL().a(interfaceC0407b);
            }
        };
        cfE();
    }

    static void cfE() {
        iQA = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public d.a call(d.a aVar) {
                return f.cfH().cfJ().a(aVar);
            }
        };
        iQB = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cfH().cfK().b(aVar);
            }
        };
        iQC = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cfH().cfL().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = iNw;
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
        rx.functions.f<d.a, d.a> fVar = iQA;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = iQB;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = iQC;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g d(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iQG;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g e(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iQH;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g f(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iQI;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a g(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = iQJ;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = iQD;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = iQK;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iQN;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> a(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iQQ;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = iQE;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k d(k kVar) {
        rx.functions.f<k, k> fVar = iQL;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iQO;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iQR;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = iQF;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iQP;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cfF() {
        return iQM;
    }
}
