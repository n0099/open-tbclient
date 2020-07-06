package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes6.dex */
public final class c {
    static volatile rx.functions.b<Throwable> oeK;
    static volatile rx.functions.f<d.a, d.a> ogL;
    static volatile rx.functions.f<h.a, h.a> ogM;
    static volatile rx.functions.f<b.a, b.a> ogN;
    static volatile rx.functions.g<rx.d, d.a, d.a> ogO;
    static volatile rx.functions.g<rx.h, h.a, h.a> ogP;
    static volatile rx.functions.g<rx.b, b.a, b.a> ogQ;
    static volatile rx.functions.f<rx.g, rx.g> ogR;
    static volatile rx.functions.f<rx.g, rx.g> ogS;
    static volatile rx.functions.f<rx.g, rx.g> ogT;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> ogU;
    static volatile rx.functions.f<k, k> ogV;
    static volatile rx.functions.f<k, k> ogW;
    static volatile rx.functions.e<? extends ScheduledExecutorService> ogX;
    static volatile rx.functions.f<Throwable, Throwable> ogY;
    static volatile rx.functions.f<Throwable, Throwable> ogZ;
    static volatile rx.functions.f<Throwable, Throwable> oha;
    static volatile rx.functions.f<d.b, d.b> ohb;
    static volatile rx.functions.f<d.b, d.b> ohc;
    static volatile rx.functions.f<b.InterfaceC0915b, b.InterfaceC0915b> ohd;

    static {
        init();
    }

    static void init() {
        oeK = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dVo().dVp().H(th);
            }
        };
        ogO = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.dVo().dVq().c(dVar, aVar);
            }
        };
        ogV = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dVo().dVq().e(kVar);
            }
        };
        ogP = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h dVr = f.dVo().dVr();
                return dVr == i.dVB() ? aVar : new t(dVr.a(hVar, new w(aVar)));
            }
        };
        ogW = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dVo().dVr().e(kVar);
            }
        };
        ogQ = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.dVo().dVs().a(bVar, aVar);
            }
        };
        ogU = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dVo().dVt().d(aVar);
            }
        };
        ogY = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dVo().dVq().aa(th);
            }
        };
        ohb = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dVo().dVq().e(bVar);
            }
        };
        ogZ = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dVo().dVr().aa(th);
            }
        };
        ohc = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dVo().dVr().e(bVar);
            }
        };
        oha = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dVo().dVs().aa(th);
            }
        };
        ohd = new rx.functions.f<b.InterfaceC0915b, b.InterfaceC0915b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0915b call(b.InterfaceC0915b interfaceC0915b) {
                return f.dVo().dVs().a(interfaceC0915b);
            }
        };
        dVl();
    }

    static void dVl() {
        ogL = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dVo().dVq().b(aVar);
            }
        };
        ogM = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dVo().dVr().b(aVar);
            }
        };
        ogN = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dVo().dVs().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = oeK;
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
        rx.functions.f<d.a, d.a> fVar = ogL;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = ogM;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = ogN;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ogR;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ogS;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = ogT;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = ogU;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = ogO;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = ogV;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ogY;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = ohb;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = ogP;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = ogW;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = ogZ;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = ohc;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = ogQ;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oha;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dVm() {
        return ogX;
    }
}
