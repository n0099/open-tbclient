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
    static volatile rx.functions.b<Throwable> pSX;
    static volatile rx.functions.f<d.a, d.a> pUX;
    static volatile rx.functions.f<h.a, h.a> pUY;
    static volatile rx.functions.f<b.a, b.a> pUZ;
    static volatile rx.functions.g<rx.d, d.a, d.a> pVa;
    static volatile rx.functions.g<rx.h, h.a, h.a> pVb;
    static volatile rx.functions.g<rx.b, b.a, b.a> pVc;
    static volatile rx.functions.f<rx.g, rx.g> pVd;
    static volatile rx.functions.f<rx.g, rx.g> pVe;
    static volatile rx.functions.f<rx.g, rx.g> pVf;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> pVg;
    static volatile rx.functions.f<k, k> pVh;
    static volatile rx.functions.f<k, k> pVi;
    static volatile rx.functions.e<? extends ScheduledExecutorService> pVj;
    static volatile rx.functions.f<Throwable, Throwable> pVk;
    static volatile rx.functions.f<Throwable, Throwable> pVl;
    static volatile rx.functions.f<Throwable, Throwable> pVm;
    static volatile rx.functions.f<d.b, d.b> pVn;
    static volatile rx.functions.f<d.b, d.b> pVo;
    static volatile rx.functions.f<b.InterfaceC1062b, b.InterfaceC1062b> pVp;

    static {
        init();
    }

    static void init() {
        pSX = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eGx().eGy().F(th);
            }
        };
        pVa = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.eGx().eGz().c(dVar, aVar);
            }
        };
        pVh = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eGx().eGz().e(kVar);
            }
        };
        pVb = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h eGA = f.eGx().eGA();
                return eGA == i.eGK() ? aVar : new t(eGA.a(hVar, new w(aVar)));
            }
        };
        pVi = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eGx().eGA().e(kVar);
            }
        };
        pVc = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.eGx().eGB().a(bVar, aVar);
            }
        };
        pVg = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eGx().eGC().d(aVar);
            }
        };
        pVk = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.eGx().eGz().W(th);
            }
        };
        pVn = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eGx().eGz().e(bVar);
            }
        };
        pVl = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.eGx().eGA().W(th);
            }
        };
        pVo = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eGx().eGA().e(bVar);
            }
        };
        pVm = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.eGx().eGB().W(th);
            }
        };
        pVp = new rx.functions.f<b.InterfaceC1062b, b.InterfaceC1062b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1062b call(b.InterfaceC1062b interfaceC1062b) {
                return f.eGx().eGB().a(interfaceC1062b);
            }
        };
        eGu();
    }

    static void eGu() {
        pUX = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eGx().eGz().b(aVar);
            }
        };
        pUY = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eGx().eGA().b(aVar);
            }
        };
        pUZ = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eGx().eGB().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = pSX;
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
        rx.functions.f<d.a, d.a> fVar = pUX;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = pUY;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = pUZ;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = pVd;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = pVe;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = pVf;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = pVg;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = pVa;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = pVh;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = pVk;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = pVn;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = pVb;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = pVi;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Z(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = pVl;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = pVo;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = pVc;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = pVm;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eGv() {
        return pVj;
    }
}
