package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes7.dex */
public final class c {
    static volatile rx.functions.b<Throwable> oRn;
    static volatile rx.functions.f<Throwable, Throwable> oTA;
    static volatile rx.functions.f<Throwable, Throwable> oTB;
    static volatile rx.functions.f<Throwable, Throwable> oTC;
    static volatile rx.functions.f<d.b, d.b> oTD;
    static volatile rx.functions.f<d.b, d.b> oTE;
    static volatile rx.functions.f<b.InterfaceC0985b, b.InterfaceC0985b> oTF;
    static volatile rx.functions.f<d.a, d.a> oTn;
    static volatile rx.functions.f<h.a, h.a> oTo;
    static volatile rx.functions.f<b.a, b.a> oTp;
    static volatile rx.functions.g<rx.d, d.a, d.a> oTq;
    static volatile rx.functions.g<rx.h, h.a, h.a> oTr;
    static volatile rx.functions.g<rx.b, b.a, b.a> oTs;
    static volatile rx.functions.f<rx.g, rx.g> oTt;
    static volatile rx.functions.f<rx.g, rx.g> oTu;
    static volatile rx.functions.f<rx.g, rx.g> oTv;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> oTw;
    static volatile rx.functions.f<k, k> oTx;
    static volatile rx.functions.f<k, k> oTy;
    static volatile rx.functions.e<? extends ScheduledExecutorService> oTz;

    static {
        init();
    }

    static void init() {
        oRn = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eoW().eoX().F(th);
            }
        };
        oTq = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.eoW().eoY().c(dVar, aVar);
            }
        };
        oTx = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eoW().eoY().e(kVar);
            }
        };
        oTr = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h eoZ = f.eoW().eoZ();
                return eoZ == i.epj() ? aVar : new t(eoZ.a(hVar, new w(aVar)));
            }
        };
        oTy = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eoW().eoZ().e(kVar);
            }
        };
        oTs = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.eoW().epa().a(bVar, aVar);
            }
        };
        oTw = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eoW().epb().d(aVar);
            }
        };
        oTA = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.eoW().eoY().Y(th);
            }
        };
        oTD = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eoW().eoY().e(bVar);
            }
        };
        oTB = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.eoW().eoZ().Y(th);
            }
        };
        oTE = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eoW().eoZ().e(bVar);
            }
        };
        oTC = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ad */
            public Throwable call(Throwable th) {
                return f.eoW().epa().Y(th);
            }
        };
        oTF = new rx.functions.f<b.InterfaceC0985b, b.InterfaceC0985b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0985b call(b.InterfaceC0985b interfaceC0985b) {
                return f.eoW().epa().a(interfaceC0985b);
            }
        };
        eoT();
    }

    static void eoT() {
        oTn = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eoW().eoY().b(aVar);
            }
        };
        oTo = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eoW().eoZ().b(aVar);
            }
        };
        oTp = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eoW().epa().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = oRn;
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
        rx.functions.f<d.a, d.a> fVar = oTn;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = oTo;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = oTp;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = oTt;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = oTu;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = oTv;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = oTw;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = oTq;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = oTx;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oTA;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = oTD;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = oTr;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = oTy;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ab(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oTB;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = oTE;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = oTs;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = oTC;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eoU() {
        return oTz;
    }
}
