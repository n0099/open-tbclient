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
    static volatile rx.functions.b<Throwable> kCA;
    static volatile rx.functions.f<d.a, d.a> kFh;
    static volatile rx.functions.f<h.a, h.a> kFi;
    static volatile rx.functions.f<b.a, b.a> kFj;
    static volatile rx.functions.g<rx.d, d.a, d.a> kFk;
    static volatile rx.functions.g<rx.h, h.a, h.a> kFl;
    static volatile rx.functions.g<rx.b, b.a, b.a> kFm;
    static volatile rx.functions.f<rx.g, rx.g> kFn;
    static volatile rx.functions.f<rx.g, rx.g> kFo;
    static volatile rx.functions.f<rx.g, rx.g> kFp;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> kFq;
    static volatile rx.functions.f<k, k> kFr;
    static volatile rx.functions.f<k, k> kFs;
    static volatile rx.functions.e<? extends ScheduledExecutorService> kFt;
    static volatile rx.functions.f<Throwable, Throwable> kFu;
    static volatile rx.functions.f<Throwable, Throwable> kFv;
    static volatile rx.functions.f<Throwable, Throwable> kFw;
    static volatile rx.functions.f<d.b, d.b> kFx;
    static volatile rx.functions.f<d.b, d.b> kFy;
    static volatile rx.functions.f<b.InterfaceC0613b, b.InterfaceC0613b> kFz;

    static {
        init();
    }

    static void init() {
        kCA = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cPB().cPC().B(th);
            }
        };
        kFk = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a h(rx.d dVar, d.a aVar) {
                return f.cPB().cPD().c(dVar, aVar);
            }
        };
        kFr = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cPB().cPD().e(kVar);
            }
        };
        kFl = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a h(rx.h hVar, h.a aVar) {
                h cPE = f.cPB().cPE();
                return cPE == i.cPO() ? aVar : new q(cPE.a(hVar, new t(aVar)));
            }
        };
        kFs = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cPB().cPE().e(kVar);
            }
        };
        kFm = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a h(rx.b bVar, b.a aVar) {
                return f.cPB().cPF().a(bVar, aVar);
            }
        };
        kFq = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cPB().cPG().d(aVar);
            }
        };
        kFu = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: W */
            public Throwable call(Throwable th) {
                return f.cPB().cPD().R(th);
            }
        };
        kFx = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cPB().cPD().e(bVar);
            }
        };
        kFv = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: W */
            public Throwable call(Throwable th) {
                return f.cPB().cPE().R(th);
            }
        };
        kFy = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cPB().cPE().e(bVar);
            }
        };
        kFw = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: W */
            public Throwable call(Throwable th) {
                return f.cPB().cPF().R(th);
            }
        };
        kFz = new rx.functions.f<b.InterfaceC0613b, b.InterfaceC0613b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0613b call(b.InterfaceC0613b interfaceC0613b) {
                return f.cPB().cPF().a(interfaceC0613b);
            }
        };
        cPy();
    }

    static void cPy() {
        kFh = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cPB().cPD().b(aVar);
            }
        };
        kFi = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cPB().cPE().b(aVar);
            }
        };
        kFj = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cPB().cPF().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = kCA;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                S(th2);
            }
        }
        S(th);
    }

    static void S(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = kFh;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = kFi;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = kFj;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kFn;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kFo;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kFp;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = kFq;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = kFk;
        return gVar != null ? gVar.h(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = kFr;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable T(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kFu;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kFx;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = kFl;
        return gVar != null ? gVar.h(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = kFs;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable U(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kFv;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kFy;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = kFm;
        return gVar != null ? gVar.h(bVar, aVar) : aVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kFw;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cPz() {
        return kFt;
    }
}
