package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.s;
import rx.internal.operators.v;
import rx.k;
/* loaded from: classes5.dex */
public final class c {
    static volatile rx.functions.b<Throwable> qCi;
    static volatile rx.functions.f<d.a, d.a> qEh;
    static volatile rx.functions.f<h.a, h.a> qEi;
    static volatile rx.functions.f<b.a, b.a> qEj;
    static volatile rx.functions.g<rx.d, d.a, d.a> qEk;
    static volatile rx.functions.g<rx.h, h.a, h.a> qEl;
    static volatile rx.functions.g<rx.b, b.a, b.a> qEm;
    static volatile rx.functions.f<rx.g, rx.g> qEn;
    static volatile rx.functions.f<rx.g, rx.g> qEo;
    static volatile rx.functions.f<rx.g, rx.g> qEp;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> qEq;
    static volatile rx.functions.f<k, k> qEr;
    static volatile rx.functions.f<k, k> qEs;
    static volatile rx.functions.e<? extends ScheduledExecutorService> qEt;
    static volatile rx.functions.f<Throwable, Throwable> qEu;
    static volatile rx.functions.f<Throwable, Throwable> qEv;
    static volatile rx.functions.f<Throwable, Throwable> qEw;
    static volatile rx.functions.f<d.b, d.b> qEx;
    static volatile rx.functions.f<d.b, d.b> qEy;
    static volatile rx.functions.f<b.InterfaceC1316b, b.InterfaceC1316b> qEz;

    static {
        init();
    }

    static void init() {
        qCi = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eNR().eNS().D(th);
            }
        };
        qEk = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.eNR().eNT().c(dVar, aVar);
            }
        };
        qEr = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eNR().eNT().e(kVar);
            }
        };
        qEl = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h eNU = f.eNR().eNU();
                return eNU == i.eOe() ? aVar : new s(eNU.a(hVar, new v(aVar)));
            }
        };
        qEs = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eNR().eNU().e(kVar);
            }
        };
        qEm = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.eNR().eNV().a(bVar, aVar);
            }
        };
        qEq = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eNR().eNW().d(aVar);
            }
        };
        qEu = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.eNR().eNT().aa(th);
            }
        };
        qEx = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eNR().eNT().e(bVar);
            }
        };
        qEv = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.eNR().eNU().aa(th);
            }
        };
        qEy = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eNR().eNU().e(bVar);
            }
        };
        qEw = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.eNR().eNV().aa(th);
            }
        };
        qEz = new rx.functions.f<b.InterfaceC1316b, b.InterfaceC1316b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1316b call(b.InterfaceC1316b interfaceC1316b) {
                return f.eNR().eNV().a(interfaceC1316b);
            }
        };
        eNO();
    }

    static void eNO() {
        qEh = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eNR().eNT().b(aVar);
            }
        };
        qEi = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eNR().eNU().b(aVar);
            }
        };
        qEj = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eNR().eNV().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = qCi;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                ab(th2);
            }
        }
        ab(th);
    }

    static void ab(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = qEh;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = qEi;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = qEj;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qEn;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qEo;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qEp;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = qEq;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = qEk;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = qEr;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qEu;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qEx;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = qEl;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = qEs;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qEv;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qEy;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = qEm;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qEw;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eNP() {
        return qEt;
    }
}
