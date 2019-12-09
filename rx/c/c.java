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
    static volatile rx.functions.b<Throwable> kBJ;
    static volatile rx.functions.f<k, k> kEA;
    static volatile rx.functions.f<k, k> kEB;
    static volatile rx.functions.e<? extends ScheduledExecutorService> kEC;
    static volatile rx.functions.f<Throwable, Throwable> kED;
    static volatile rx.functions.f<Throwable, Throwable> kEE;
    static volatile rx.functions.f<Throwable, Throwable> kEF;
    static volatile rx.functions.f<d.b, d.b> kEG;
    static volatile rx.functions.f<d.b, d.b> kEH;
    static volatile rx.functions.f<b.InterfaceC0596b, b.InterfaceC0596b> kEI;
    static volatile rx.functions.f<d.a, d.a> kEq;
    static volatile rx.functions.f<h.a, h.a> kEr;
    static volatile rx.functions.f<b.a, b.a> kEs;
    static volatile rx.functions.g<rx.d, d.a, d.a> kEt;
    static volatile rx.functions.g<rx.h, h.a, h.a> kEu;
    static volatile rx.functions.g<rx.b, b.a, b.a> kEv;
    static volatile rx.functions.f<rx.g, rx.g> kEw;
    static volatile rx.functions.f<rx.g, rx.g> kEx;
    static volatile rx.functions.f<rx.g, rx.g> kEy;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> kEz;

    static {
        init();
    }

    static void init() {
        kBJ = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cPz().cPA().C(th);
            }
        };
        kEt = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a h(rx.d dVar, d.a aVar) {
                return f.cPz().cPB().c(dVar, aVar);
            }
        };
        kEA = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cPz().cPB().e(kVar);
            }
        };
        kEu = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a h(rx.h hVar, h.a aVar) {
                h cPC = f.cPz().cPC();
                return cPC == i.cPM() ? aVar : new q(cPC.a(hVar, new t(aVar)));
            }
        };
        kEB = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cPz().cPC().e(kVar);
            }
        };
        kEv = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a h(rx.b bVar, b.a aVar) {
                return f.cPz().cPD().a(bVar, aVar);
            }
        };
        kEz = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cPz().cPE().d(aVar);
            }
        };
        kED = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cPz().cPB().S(th);
            }
        };
        kEG = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cPz().cPB().e(bVar);
            }
        };
        kEE = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cPz().cPC().S(th);
            }
        };
        kEH = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cPz().cPC().e(bVar);
            }
        };
        kEF = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cPz().cPD().S(th);
            }
        };
        kEI = new rx.functions.f<b.InterfaceC0596b, b.InterfaceC0596b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0596b call(b.InterfaceC0596b interfaceC0596b) {
                return f.cPz().cPD().a(interfaceC0596b);
            }
        };
        cPw();
    }

    static void cPw() {
        kEq = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cPz().cPB().b(aVar);
            }
        };
        kEr = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cPz().cPC().b(aVar);
            }
        };
        kEs = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cPz().cPD().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = kBJ;
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
        rx.functions.f<d.a, d.a> fVar = kEq;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = kEr;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = kEs;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kEw;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kEx;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = kEy;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = kEz;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = kEt;
        return gVar != null ? gVar.h(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = kEA;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable U(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kED;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kEG;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = kEu;
        return gVar != null ? gVar.h(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = kEB;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kEE;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = kEH;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = kEv;
        return gVar != null ? gVar.h(bVar, aVar) : aVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = kEF;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cPx() {
        return kEC;
    }
}
