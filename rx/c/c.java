package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes16.dex */
public final class c {
    static volatile rx.functions.b<Throwable> qhq;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> qjA;
    static volatile rx.functions.f<k, k> qjB;
    static volatile rx.functions.f<k, k> qjC;
    static volatile rx.functions.e<? extends ScheduledExecutorService> qjD;
    static volatile rx.functions.f<Throwable, Throwable> qjE;
    static volatile rx.functions.f<Throwable, Throwable> qjF;
    static volatile rx.functions.f<Throwable, Throwable> qjG;
    static volatile rx.functions.f<d.b, d.b> qjH;
    static volatile rx.functions.f<d.b, d.b> qjI;
    static volatile rx.functions.f<b.InterfaceC1095b, b.InterfaceC1095b> qjJ;
    static volatile rx.functions.f<d.a, d.a> qjr;
    static volatile rx.functions.f<h.a, h.a> qjs;
    static volatile rx.functions.f<b.a, b.a> qjt;
    static volatile rx.functions.g<rx.d, d.a, d.a> qju;
    static volatile rx.functions.g<rx.h, h.a, h.a> qjv;
    static volatile rx.functions.g<rx.b, b.a, b.a> qjw;
    static volatile rx.functions.f<rx.g, rx.g> qjx;
    static volatile rx.functions.f<rx.g, rx.g> qjy;
    static volatile rx.functions.f<rx.g, rx.g> qjz;

    static {
        init();
    }

    static void init() {
        qhq = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eGu().eGv().F(th);
            }
        };
        qju = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.eGu().eGw().c(dVar, aVar);
            }
        };
        qjB = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eGu().eGw().e(kVar);
            }
        };
        qjv = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h eGx = f.eGu().eGx();
                return eGx == i.eGH() ? aVar : new t(eGx.a(hVar, new w(aVar)));
            }
        };
        qjC = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eGu().eGx().e(kVar);
            }
        };
        qjw = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.eGu().eGy().a(bVar, aVar);
            }
        };
        qjA = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eGu().eGz().d(aVar);
            }
        };
        qjE = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.eGu().eGw().Y(th);
            }
        };
        qjH = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eGu().eGw().e(bVar);
            }
        };
        qjF = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.eGu().eGx().Y(th);
            }
        };
        qjI = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eGu().eGx().e(bVar);
            }
        };
        qjG = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.eGu().eGy().Y(th);
            }
        };
        qjJ = new rx.functions.f<b.InterfaceC1095b, b.InterfaceC1095b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1095b call(b.InterfaceC1095b interfaceC1095b) {
                return f.eGu().eGy().a(interfaceC1095b);
            }
        };
        eGr();
    }

    static void eGr() {
        qjr = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eGu().eGw().b(aVar);
            }
        };
        qjs = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eGu().eGx().b(aVar);
            }
        };
        qjt = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eGu().eGy().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = qhq;
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
        rx.functions.f<d.a, d.a> fVar = qjr;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = qjs;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = qjt;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qjx;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qjy;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qjz;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = qjA;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = qju;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = qjB;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qjE;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qjH;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = qjv;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = qjC;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ab(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qjF;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qjI;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = qjw;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qjG;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eGs() {
        return qjD;
    }
}
