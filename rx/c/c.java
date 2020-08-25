package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes5.dex */
public final class c {
    static volatile rx.functions.b<Throwable> oHq;
    static volatile rx.functions.f<k, k> oJA;
    static volatile rx.functions.f<k, k> oJB;
    static volatile rx.functions.e<? extends ScheduledExecutorService> oJC;
    static volatile rx.functions.f<Throwable, Throwable> oJD;
    static volatile rx.functions.f<Throwable, Throwable> oJE;
    static volatile rx.functions.f<Throwable, Throwable> oJF;
    static volatile rx.functions.f<d.b, d.b> oJG;
    static volatile rx.functions.f<d.b, d.b> oJH;
    static volatile rx.functions.f<b.InterfaceC0988b, b.InterfaceC0988b> oJI;
    static volatile rx.functions.f<d.a, d.a> oJq;
    static volatile rx.functions.f<h.a, h.a> oJr;
    static volatile rx.functions.f<b.a, b.a> oJs;
    static volatile rx.functions.g<rx.d, d.a, d.a> oJt;
    static volatile rx.functions.g<rx.h, h.a, h.a> oJu;
    static volatile rx.functions.g<rx.b, b.a, b.a> oJv;
    static volatile rx.functions.f<rx.g, rx.g> oJw;
    static volatile rx.functions.f<rx.g, rx.g> oJx;
    static volatile rx.functions.f<rx.g, rx.g> oJy;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> oJz;

    static {
        init();
    }

    static void init() {
        oHq = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.ekP().ekQ().F(th);
            }
        };
        oJt = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.ekP().ekR().c(dVar, aVar);
            }
        };
        oJA = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.ekP().ekR().e(kVar);
            }
        };
        oJu = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h ekS = f.ekP().ekS();
                return ekS == i.elc() ? aVar : new t(ekS.a(hVar, new w(aVar)));
            }
        };
        oJB = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.ekP().ekS().e(kVar);
            }
        };
        oJv = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.ekP().ekT().a(bVar, aVar);
            }
        };
        oJz = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.ekP().ekU().d(aVar);
            }
        };
        oJD = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.ekP().ekR().Y(th);
            }
        };
        oJG = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.ekP().ekR().e(bVar);
            }
        };
        oJE = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.ekP().ekS().Y(th);
            }
        };
        oJH = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.ekP().ekS().e(bVar);
            }
        };
        oJF = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.ekP().ekT().Y(th);
            }
        };
        oJI = new rx.functions.f<b.InterfaceC0988b, b.InterfaceC0988b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0988b call(b.InterfaceC0988b interfaceC0988b) {
                return f.ekP().ekT().a(interfaceC0988b);
            }
        };
        ekM();
    }

    static void ekM() {
        oJq = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.ekP().ekR().b(aVar);
            }
        };
        oJr = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.ekP().ekS().b(aVar);
            }
        };
        oJs = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.ekP().ekT().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = oHq;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                Z(th2);
            }
        }
        Z(th);
    }

    static void Z(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = oJq;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = oJr;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = oJs;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = oJw;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = oJx;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = oJy;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = oJz;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = oJt;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = oJA;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oJD;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = oJG;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = oJu;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = oJB;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ab(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oJE;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = oJH;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = oJv;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oJF;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> ekN() {
        return oJC;
    }
}
