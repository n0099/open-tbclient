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
    static volatile rx.functions.b<Throwable> nHK;
    static volatile rx.functions.f<d.a, d.a> nJK;
    static volatile rx.functions.f<h.a, h.a> nJL;
    static volatile rx.functions.f<b.a, b.a> nJM;
    static volatile rx.functions.g<rx.d, d.a, d.a> nJN;
    static volatile rx.functions.g<rx.h, h.a, h.a> nJO;
    static volatile rx.functions.g<rx.b, b.a, b.a> nJP;
    static volatile rx.functions.f<rx.g, rx.g> nJQ;
    static volatile rx.functions.f<rx.g, rx.g> nJR;
    static volatile rx.functions.f<rx.g, rx.g> nJS;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> nJT;
    static volatile rx.functions.f<k, k> nJU;
    static volatile rx.functions.f<k, k> nJV;
    static volatile rx.functions.e<? extends ScheduledExecutorService> nJW;
    static volatile rx.functions.f<Throwable, Throwable> nJX;
    static volatile rx.functions.f<Throwable, Throwable> nJY;
    static volatile rx.functions.f<Throwable, Throwable> nJZ;
    static volatile rx.functions.f<d.b, d.b> nKa;
    static volatile rx.functions.f<d.b, d.b> nKb;
    static volatile rx.functions.f<b.InterfaceC0894b, b.InterfaceC0894b> nKc;

    static {
        init();
    }

    static void init() {
        nHK = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dQq().dQr().H(th);
            }
        };
        nJN = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a o(rx.d dVar, d.a aVar) {
                return f.dQq().dQs().c(dVar, aVar);
            }
        };
        nJU = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dQq().dQs().e(kVar);
            }
        };
        nJO = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a o(rx.h hVar, h.a aVar) {
                h dQt = f.dQq().dQt();
                return dQt == i.dQD() ? aVar : new t(dQt.a(hVar, new w(aVar)));
            }
        };
        nJV = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dQq().dQt().e(kVar);
            }
        };
        nJP = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a o(rx.b bVar, b.a aVar) {
                return f.dQq().dQu().a(bVar, aVar);
            }
        };
        nJT = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dQq().dQv().d(aVar);
            }
        };
        nJX = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dQq().dQs().aa(th);
            }
        };
        nKa = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dQq().dQs().e(bVar);
            }
        };
        nJY = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dQq().dQt().aa(th);
            }
        };
        nKb = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dQq().dQt().e(bVar);
            }
        };
        nJZ = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dQq().dQu().aa(th);
            }
        };
        nKc = new rx.functions.f<b.InterfaceC0894b, b.InterfaceC0894b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0894b call(b.InterfaceC0894b interfaceC0894b) {
                return f.dQq().dQu().a(interfaceC0894b);
            }
        };
        dQn();
    }

    static void dQn() {
        nJK = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dQq().dQs().b(aVar);
            }
        };
        nJL = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dQq().dQt().b(aVar);
            }
        };
        nJM = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dQq().dQu().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = nHK;
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
        rx.functions.f<d.a, d.a> fVar = nJK;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = nJL;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = nJM;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nJQ;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nJR;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nJS;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = nJT;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = nJN;
        return gVar != null ? gVar.o(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = nJU;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nJX;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = nKa;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = nJO;
        return gVar != null ? gVar.o(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = nJV;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nJY;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = nKb;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = nJP;
        return gVar != null ? gVar.o(bVar, aVar) : aVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nJZ;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dQo() {
        return nJW;
    }
}
