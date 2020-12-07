package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes12.dex */
public final class c {
    static volatile rx.functions.b<Throwable> pSV;
    static volatile rx.functions.f<d.a, d.a> pUV;
    static volatile rx.functions.f<h.a, h.a> pUW;
    static volatile rx.functions.f<b.a, b.a> pUX;
    static volatile rx.functions.g<rx.d, d.a, d.a> pUY;
    static volatile rx.functions.g<rx.h, h.a, h.a> pUZ;
    static volatile rx.functions.g<rx.b, b.a, b.a> pVa;
    static volatile rx.functions.f<rx.g, rx.g> pVb;
    static volatile rx.functions.f<rx.g, rx.g> pVc;
    static volatile rx.functions.f<rx.g, rx.g> pVd;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> pVe;
    static volatile rx.functions.f<k, k> pVf;
    static volatile rx.functions.f<k, k> pVg;
    static volatile rx.functions.e<? extends ScheduledExecutorService> pVh;
    static volatile rx.functions.f<Throwable, Throwable> pVi;
    static volatile rx.functions.f<Throwable, Throwable> pVj;
    static volatile rx.functions.f<Throwable, Throwable> pVk;
    static volatile rx.functions.f<d.b, d.b> pVl;
    static volatile rx.functions.f<d.b, d.b> pVm;
    static volatile rx.functions.f<b.InterfaceC1062b, b.InterfaceC1062b> pVn;

    static {
        init();
    }

    static void init() {
        pSV = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eGw().eGx().F(th);
            }
        };
        pUY = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.eGw().eGy().c(dVar, aVar);
            }
        };
        pVf = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eGw().eGy().e(kVar);
            }
        };
        pUZ = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h eGz = f.eGw().eGz();
                return eGz == i.eGJ() ? aVar : new t(eGz.a(hVar, new w(aVar)));
            }
        };
        pVg = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eGw().eGz().e(kVar);
            }
        };
        pVa = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.eGw().eGA().a(bVar, aVar);
            }
        };
        pVe = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eGw().eGB().d(aVar);
            }
        };
        pVi = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.eGw().eGy().W(th);
            }
        };
        pVl = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eGw().eGy().e(bVar);
            }
        };
        pVj = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.eGw().eGz().W(th);
            }
        };
        pVm = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eGw().eGz().e(bVar);
            }
        };
        pVk = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.eGw().eGA().W(th);
            }
        };
        pVn = new rx.functions.f<b.InterfaceC1062b, b.InterfaceC1062b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1062b call(b.InterfaceC1062b interfaceC1062b) {
                return f.eGw().eGA().a(interfaceC1062b);
            }
        };
        eGt();
    }

    static void eGt() {
        pUV = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eGw().eGy().b(aVar);
            }
        };
        pUW = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eGw().eGz().b(aVar);
            }
        };
        pUX = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eGw().eGA().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = pSV;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                X(th2);
            }
        }
        X(th);
    }

    static void X(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = pUV;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = pUW;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = pUX;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = pVb;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = pVc;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = pVd;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = pVe;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = pUY;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = pVf;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = pVi;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = pVl;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = pUZ;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = pVg;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Z(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = pVj;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = pVm;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = pVa;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = pVk;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eGu() {
        return pVh;
    }
}
