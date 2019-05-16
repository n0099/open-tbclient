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
    static volatile rx.functions.b<Throwable> kqR;
    static volatile rx.functions.f<h.a, h.a> ktA;
    static volatile rx.functions.f<b.a, b.a> ktB;
    static volatile rx.functions.g<rx.d, d.a, d.a> ktC;
    static volatile rx.functions.g<rx.h, h.a, h.a> ktD;
    static volatile rx.functions.g<rx.b, b.a, b.a> ktE;
    static volatile rx.functions.f<rx.g, rx.g> ktF;
    static volatile rx.functions.f<rx.g, rx.g> ktG;
    static volatile rx.functions.f<rx.g, rx.g> ktH;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> ktI;
    static volatile rx.functions.f<k, k> ktJ;
    static volatile rx.functions.f<k, k> ktK;
    static volatile rx.functions.e<? extends ScheduledExecutorService> ktL;
    static volatile rx.functions.f<Throwable, Throwable> ktM;
    static volatile rx.functions.f<Throwable, Throwable> ktN;
    static volatile rx.functions.f<Throwable, Throwable> ktO;
    static volatile rx.functions.f<d.b, d.b> ktP;
    static volatile rx.functions.f<d.b, d.b> ktQ;
    static volatile rx.functions.f<b.InterfaceC0500b, b.InterfaceC0500b> ktR;
    static volatile rx.functions.f<d.a, d.a> ktz;

    static {
        init();
    }

    static void init() {
        kqR = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cMy().cMz().C(th);
            }
        };
        ktC = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cMy().cMA().c(dVar, aVar);
            }
        };
        ktJ = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cMy().cMA().e(kVar);
            }
        };
        ktD = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cMB = f.cMy().cMB();
                return cMB == i.cML() ? aVar : new q(cMB.a(hVar, new t(aVar)));
            }
        };
        ktK = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cMy().cMB().e(kVar);
            }
        };
        ktE = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cMy().cMC().a(bVar, aVar);
            }
        };
        ktI = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cMy().cMD().d(aVar);
            }
        };
        ktM = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cMy().cMA().S(th);
            }
        };
        ktP = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cMy().cMA().e(bVar);
            }
        };
        ktN = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cMy().cMB().S(th);
            }
        };
        ktQ = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cMy().cMB().e(bVar);
            }
        };
        ktO = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cMy().cMC().S(th);
            }
        };
        ktR = new rx.functions.f<b.InterfaceC0500b, b.InterfaceC0500b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0500b call(b.InterfaceC0500b interfaceC0500b) {
                return f.cMy().cMC().a(interfaceC0500b);
            }
        };
        cMv();
    }

    static void cMv() {
        ktz = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cMy().cMA().b(aVar);
            }
        };
        ktA = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cMy().cMB().b(aVar);
            }
        };
        ktB = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cMy().cMC().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = kqR;
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
        rx.functions.f<d.a, d.a> fVar = ktz;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = ktA;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = ktB;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ktF;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ktG;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ktH;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = ktI;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = ktC;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = ktJ;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable U(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ktM;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = ktP;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = ktD;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = ktK;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ktN;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = ktQ;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = ktE;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ktO;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cMw() {
        return ktL;
    }
}
