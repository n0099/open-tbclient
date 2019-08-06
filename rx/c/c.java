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
    static volatile rx.functions.f<b.InterfaceC0506b, b.InterfaceC0506b> kCA;
    static volatile rx.functions.f<d.a, d.a> kCi;
    static volatile rx.functions.f<h.a, h.a> kCj;
    static volatile rx.functions.f<b.a, b.a> kCk;
    static volatile rx.functions.g<rx.d, d.a, d.a> kCl;
    static volatile rx.functions.g<rx.h, h.a, h.a> kCm;
    static volatile rx.functions.g<rx.b, b.a, b.a> kCn;
    static volatile rx.functions.f<rx.g, rx.g> kCo;
    static volatile rx.functions.f<rx.g, rx.g> kCp;
    static volatile rx.functions.f<rx.g, rx.g> kCq;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> kCr;
    static volatile rx.functions.f<k, k> kCs;
    static volatile rx.functions.f<k, k> kCt;
    static volatile rx.functions.e<? extends ScheduledExecutorService> kCu;
    static volatile rx.functions.f<Throwable, Throwable> kCv;
    static volatile rx.functions.f<Throwable, Throwable> kCw;
    static volatile rx.functions.f<Throwable, Throwable> kCx;
    static volatile rx.functions.f<d.b, d.b> kCy;
    static volatile rx.functions.f<d.b, d.b> kCz;
    static volatile rx.functions.b<Throwable> kzA;

    static {
        init();
    }

    static void init() {
        kzA = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cQK().cQL().C(th);
            }
        };
        kCl = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cQK().cQM().c(dVar, aVar);
            }
        };
        kCs = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cQK().cQM().e(kVar);
            }
        };
        kCm = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cQN = f.cQK().cQN();
                return cQN == i.cQX() ? aVar : new q(cQN.a(hVar, new t(aVar)));
            }
        };
        kCt = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cQK().cQN().e(kVar);
            }
        };
        kCn = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cQK().cQO().a(bVar, aVar);
            }
        };
        kCr = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cQK().cQP().d(aVar);
            }
        };
        kCv = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cQK().cQM().S(th);
            }
        };
        kCy = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cQK().cQM().e(bVar);
            }
        };
        kCw = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cQK().cQN().S(th);
            }
        };
        kCz = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cQK().cQN().e(bVar);
            }
        };
        kCx = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cQK().cQO().S(th);
            }
        };
        kCA = new rx.functions.f<b.InterfaceC0506b, b.InterfaceC0506b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0506b call(b.InterfaceC0506b interfaceC0506b) {
                return f.cQK().cQO().a(interfaceC0506b);
            }
        };
        cQH();
    }

    static void cQH() {
        kCi = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cQK().cQM().b(aVar);
            }
        };
        kCj = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cQK().cQN().b(aVar);
            }
        };
        kCk = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cQK().cQO().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = kzA;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                T(th2);
            }
        }
        T(th);
    }

    static void T(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = kCi;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = kCj;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = kCk;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kCo;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kCp;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kCq;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = kCr;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = kCl;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = kCs;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable U(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kCv;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kCy;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = kCm;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = kCt;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kCw;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kCz;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = kCn;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kCx;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cQI() {
        return kCu;
    }
}
