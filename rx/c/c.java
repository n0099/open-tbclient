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
    static volatile rx.functions.b<Throwable> iBt;
    static volatile rx.functions.f<b.a, b.a> iEA;
    static volatile rx.functions.g<rx.d, d.a, d.a> iEB;
    static volatile rx.functions.g<rx.h, h.a, h.a> iEC;
    static volatile rx.functions.g<rx.b, b.a, b.a> iED;
    static volatile rx.functions.f<rx.g, rx.g> iEE;
    static volatile rx.functions.f<rx.g, rx.g> iEF;
    static volatile rx.functions.f<rx.g, rx.g> iEG;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> iEH;
    static volatile rx.functions.f<k, k> iEI;
    static volatile rx.functions.f<k, k> iEJ;
    static volatile rx.functions.e<? extends ScheduledExecutorService> iEK;
    static volatile rx.functions.f<Throwable, Throwable> iEL;
    static volatile rx.functions.f<Throwable, Throwable> iEM;
    static volatile rx.functions.f<Throwable, Throwable> iEN;
    static volatile rx.functions.f<d.b, d.b> iEO;
    static volatile rx.functions.f<d.b, d.b> iEP;
    static volatile rx.functions.f<b.InterfaceC0365b, b.InterfaceC0365b> iEQ;
    static volatile rx.functions.f<d.a, d.a> iEy;
    static volatile rx.functions.f<h.a, h.a> iEz;

    static {
        init();
    }

    static void init() {
        iBt = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.cdr().cds().C(th);
            }
        };
        iEB = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.cdr().cdt().c(dVar, aVar);
            }
        };
        iEI = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.cdr().cdt().f(kVar);
            }
        };
        iEC = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h cdu = f.cdr().cdu();
                return cdu == i.cdE() ? aVar : new cq(cdu.a(hVar, new ct(aVar)));
            }
        };
        iEJ = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.cdr().cdu().f(kVar);
            }
        };
        iED = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.cdr().cdv().a(bVar, aVar);
            }
        };
        iEH = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: h */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.cdr().cdw().b(aVar);
            }
        };
        iEL = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cdr().cdt().U(th);
            }
        };
        iEO = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.cdr().cdt().d(bVar);
            }
        };
        iEM = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cdr().cdu().U(th);
            }
        };
        iEP = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.cdr().cdu().d(bVar);
            }
        };
        iEN = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.cdr().cdv().U(th);
            }
        };
        iEQ = new rx.functions.f<b.InterfaceC0365b, b.InterfaceC0365b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0365b call(b.InterfaceC0365b interfaceC0365b) {
                return f.cdr().cdv().a(interfaceC0365b);
            }
        };
        cdo();
    }

    static void cdo() {
        iEy = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public d.a call(d.a aVar) {
                return f.cdr().cdt().a(aVar);
            }
        };
        iEz = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.cdr().cdu().b(aVar);
            }
        };
        iEA = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.cdr().cdv().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = iBt;
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
        rx.functions.f<d.a, d.a> fVar = iEy;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = iEz;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = iEA;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g d(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iEE;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g e(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iEF;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g f(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iEG;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a g(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = iEH;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = iEB;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = iEI;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iEL;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> a(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iEO;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = iEC;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k d(k kVar) {
        rx.functions.f<k, k> fVar = iEJ;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iEM;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iEP;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = iED;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iEN;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> cdp() {
        return iEK;
    }
}
