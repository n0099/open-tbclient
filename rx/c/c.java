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
    static volatile rx.functions.b<Throwable> kqV;
    static volatile rx.functions.f<d.a, d.a> ktD;
    static volatile rx.functions.f<h.a, h.a> ktE;
    static volatile rx.functions.f<b.a, b.a> ktF;
    static volatile rx.functions.g<rx.d, d.a, d.a> ktG;
    static volatile rx.functions.g<rx.h, h.a, h.a> ktH;
    static volatile rx.functions.g<rx.b, b.a, b.a> ktI;
    static volatile rx.functions.f<rx.g, rx.g> ktJ;
    static volatile rx.functions.f<rx.g, rx.g> ktK;
    static volatile rx.functions.f<rx.g, rx.g> ktL;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> ktM;
    static volatile rx.functions.f<k, k> ktN;
    static volatile rx.functions.f<k, k> ktO;
    static volatile rx.functions.e<? extends ScheduledExecutorService> ktP;
    static volatile rx.functions.f<Throwable, Throwable> ktQ;
    static volatile rx.functions.f<Throwable, Throwable> ktR;
    static volatile rx.functions.f<Throwable, Throwable> ktS;
    static volatile rx.functions.f<d.b, d.b> ktT;
    static volatile rx.functions.f<d.b, d.b> ktU;
    static volatile rx.functions.f<b.InterfaceC0500b, b.InterfaceC0500b> ktV;

    static {
        init();
    }

    static void init() {
        kqV = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cMz().cMA().C(th);
            }
        };
        ktG = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cMz().cMB().c(dVar, aVar);
            }
        };
        ktN = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cMz().cMB().e(kVar);
            }
        };
        ktH = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cMC = f.cMz().cMC();
                return cMC == i.cMM() ? aVar : new q(cMC.a(hVar, new t(aVar)));
            }
        };
        ktO = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.cMz().cMC().e(kVar);
            }
        };
        ktI = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cMz().cMD().a(bVar, aVar);
            }
        };
        ktM = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cMz().cME().d(aVar);
            }
        };
        ktQ = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cMz().cMB().S(th);
            }
        };
        ktT = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cMz().cMB().e(bVar);
            }
        };
        ktR = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cMz().cMC().S(th);
            }
        };
        ktU = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.cMz().cMC().e(bVar);
            }
        };
        ktS = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: X */
            public Throwable call(Throwable th) {
                return f.cMz().cMD().S(th);
            }
        };
        ktV = new rx.functions.f<b.InterfaceC0500b, b.InterfaceC0500b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0500b call(b.InterfaceC0500b interfaceC0500b) {
                return f.cMz().cMD().a(interfaceC0500b);
            }
        };
        cMw();
    }

    static void cMw() {
        ktD = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.cMz().cMB().b(aVar);
            }
        };
        ktE = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cMz().cMC().b(aVar);
            }
        };
        ktF = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cMz().cMD().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = kqV;
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
        rx.functions.f<d.a, d.a> fVar = ktD;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = ktE;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = ktF;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g g(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ktJ;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g h(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ktK;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ktL;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = ktM;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = ktG;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = ktN;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable U(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ktQ;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = ktT;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = ktH;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = ktO;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable V(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ktR;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = ktU;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = ktI;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ktS;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cMx() {
        return ktP;
    }
}
