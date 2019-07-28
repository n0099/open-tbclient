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
    static volatile rx.functions.f<d.a, d.a> kBc;
    static volatile rx.functions.f<h.a, h.a> kBd;
    static volatile rx.functions.f<b.a, b.a> kBe;
    static volatile rx.functions.g<rx.d, d.a, d.a> kBf;
    static volatile rx.functions.g<rx.h, h.a, h.a> kBg;
    static volatile rx.functions.g<rx.b, b.a, b.a> kBh;
    static volatile rx.functions.f<rx.g, rx.g> kBi;
    static volatile rx.functions.f<rx.g, rx.g> kBj;
    static volatile rx.functions.f<rx.g, rx.g> kBk;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> kBl;
    static volatile rx.functions.f<k, k> kBm;
    static volatile rx.functions.f<k, k> kBn;
    static volatile rx.functions.e<? extends ScheduledExecutorService> kBo;
    static volatile rx.functions.f<Throwable, Throwable> kBp;
    static volatile rx.functions.f<Throwable, Throwable> kBq;
    static volatile rx.functions.f<Throwable, Throwable> kBr;
    static volatile rx.functions.f<d.b, d.b> kBs;
    static volatile rx.functions.f<d.b, d.b> kBt;
    static volatile rx.functions.f<b.InterfaceC0506b, b.InterfaceC0506b> kBu;
    static volatile rx.functions.b<Throwable> kyu;

    static {
        init();
    }

    static void init() {
        kyu = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cQp().cQq().C(th);
            }
        };
        kBf = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cQp().cQr().c(dVar, aVar);
            }
        };
        kBm = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cQp().cQr().e(kVar);
            }
        };
        kBg = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cQs = f.cQp().cQs();
                return cQs == i.cQC() ? aVar : new q(cQs.a(hVar, new t(aVar)));
            }
        };
        kBn = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cQp().cQs().e(kVar);
            }
        };
        kBh = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cQp().cQt().a(bVar, aVar);
            }
        };
        kBl = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cQp().cQu().d(aVar);
            }
        };
        kBp = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cQp().cQr().S(th);
            }
        };
        kBs = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cQp().cQr().e(bVar);
            }
        };
        kBq = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cQp().cQs().S(th);
            }
        };
        kBt = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cQp().cQs().e(bVar);
            }
        };
        kBr = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cQp().cQt().S(th);
            }
        };
        kBu = new rx.functions.f<b.InterfaceC0506b, b.InterfaceC0506b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0506b call(b.InterfaceC0506b interfaceC0506b) {
                return f.cQp().cQt().a(interfaceC0506b);
            }
        };
        cQm();
    }

    static void cQm() {
        kBc = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cQp().cQr().b(aVar);
            }
        };
        kBd = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cQp().cQs().b(aVar);
            }
        };
        kBe = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cQp().cQt().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = kyu;
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
        rx.functions.f<d.a, d.a> fVar = kBc;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = kBd;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = kBe;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kBi;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kBj;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kBk;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = kBl;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = kBf;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = kBm;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable U(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kBp;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kBs;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = kBg;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = kBn;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kBq;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kBt;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = kBh;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kBr;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cQn() {
        return kBo;
    }
}
