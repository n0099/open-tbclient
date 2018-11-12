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
    static volatile rx.functions.b<Throwable> iDe;
    static volatile rx.functions.f<d.b, d.b> iGA;
    static volatile rx.functions.f<b.InterfaceC0393b, b.InterfaceC0393b> iGB;
    static volatile rx.functions.f<d.a, d.a> iGj;
    static volatile rx.functions.f<h.a, h.a> iGk;
    static volatile rx.functions.f<b.a, b.a> iGl;
    static volatile rx.functions.g<rx.d, d.a, d.a> iGm;
    static volatile rx.functions.g<rx.h, h.a, h.a> iGn;
    static volatile rx.functions.g<rx.b, b.a, b.a> iGo;
    static volatile rx.functions.f<rx.g, rx.g> iGp;
    static volatile rx.functions.f<rx.g, rx.g> iGq;
    static volatile rx.functions.f<rx.g, rx.g> iGr;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> iGs;
    static volatile rx.functions.f<k, k> iGt;
    static volatile rx.functions.f<k, k> iGu;
    static volatile rx.functions.e<? extends ScheduledExecutorService> iGv;
    static volatile rx.functions.f<Throwable, Throwable> iGw;
    static volatile rx.functions.f<Throwable, Throwable> iGx;
    static volatile rx.functions.f<Throwable, Throwable> iGy;
    static volatile rx.functions.f<d.b, d.b> iGz;

    static {
        init();
    }

    static void init() {
        iDe = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.ccO().ccP().C(th);
            }
        };
        iGm = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a j(rx.d dVar, d.a aVar) {
                return f.ccO().ccQ().c(dVar, aVar);
            }
        };
        iGt = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.ccO().ccQ().f(kVar);
            }
        };
        iGn = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a j(rx.h hVar, h.a aVar) {
                h ccR = f.ccO().ccR();
                return ccR == i.cdb() ? aVar : new cq(ccR.a(hVar, new ct(aVar)));
            }
        };
        iGu = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: e */
            public k call(k kVar) {
                return f.ccO().ccR().f(kVar);
            }
        };
        iGo = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a j(rx.b bVar, b.a aVar) {
                return f.ccO().ccS().a(bVar, aVar);
            }
        };
        iGs = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: h */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.ccO().ccT().b(aVar);
            }
        };
        iGw = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.ccO().ccQ().U(th);
            }
        };
        iGz = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.ccO().ccQ().d(bVar);
            }
        };
        iGx = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.ccO().ccR().U(th);
            }
        };
        iGA = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.b call(d.b bVar) {
                return f.ccO().ccR().d(bVar);
            }
        };
        iGy = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Z */
            public Throwable call(Throwable th) {
                return f.ccO().ccS().U(th);
            }
        };
        iGB = new rx.functions.f<b.InterfaceC0393b, b.InterfaceC0393b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0393b call(b.InterfaceC0393b interfaceC0393b) {
                return f.ccO().ccS().a(interfaceC0393b);
            }
        };
        ccL();
    }

    static void ccL() {
        iGj = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public d.a call(d.a aVar) {
                return f.ccO().ccQ().a(aVar);
            }
        };
        iGk = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.ccO().ccR().b(aVar);
            }
        };
        iGl = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.ccO().ccS().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = iDe;
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
        rx.functions.f<d.a, d.a> fVar = iGj;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = iGk;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = iGl;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g d(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iGp;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g e(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iGq;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g f(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = iGr;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a g(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = iGs;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = iGm;
        return gVar != null ? gVar.j(dVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = iGt;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable W(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iGw;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> a(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iGz;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = iGn;
        return gVar != null ? gVar.j(hVar, aVar) : aVar;
    }

    public static k d(k kVar) {
        rx.functions.f<k, k> fVar = iGu;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iGx;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = iGA;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = iGo;
        return gVar != null ? gVar.j(bVar, aVar) : aVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = iGy;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> ccM() {
        return iGv;
    }
}
