package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.s;
import rx.internal.operators.v;
import rx.k;
/* loaded from: classes15.dex */
public final class c {
    static volatile rx.functions.b<Throwable> quy;
    static volatile rx.functions.g<rx.d, d.a, d.a> qwA;
    static volatile rx.functions.g<rx.h, h.a, h.a> qwB;
    static volatile rx.functions.g<rx.b, b.a, b.a> qwC;
    static volatile rx.functions.f<rx.g, rx.g> qwD;
    static volatile rx.functions.f<rx.g, rx.g> qwE;
    static volatile rx.functions.f<rx.g, rx.g> qwF;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> qwG;
    static volatile rx.functions.f<k, k> qwH;
    static volatile rx.functions.f<k, k> qwI;
    static volatile rx.functions.e<? extends ScheduledExecutorService> qwJ;
    static volatile rx.functions.f<Throwable, Throwable> qwK;
    static volatile rx.functions.f<Throwable, Throwable> qwL;
    static volatile rx.functions.f<Throwable, Throwable> qwM;
    static volatile rx.functions.f<d.b, d.b> qwN;
    static volatile rx.functions.f<d.b, d.b> qwO;
    static volatile rx.functions.f<b.InterfaceC1280b, b.InterfaceC1280b> qwP;
    static volatile rx.functions.f<d.a, d.a> qwx;
    static volatile rx.functions.f<h.a, h.a> qwy;
    static volatile rx.functions.f<b.a, b.a> qwz;

    static {
        init();
    }

    static void init() {
        quy = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eOF().eOG().E(th);
            }
        };
        qwA = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.eOF().eOH().c(dVar, aVar);
            }
        };
        qwH = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eOF().eOH().e(kVar);
            }
        };
        qwB = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h eOI = f.eOF().eOI();
                return eOI == i.eOS() ? aVar : new s(eOI.a(hVar, new v(aVar)));
            }
        };
        qwI = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eOF().eOI().e(kVar);
            }
        };
        qwC = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.eOF().eOJ().a(bVar, aVar);
            }
        };
        qwG = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eOF().eOK().d(aVar);
            }
        };
        qwK = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.eOF().eOH().ab(th);
            }
        };
        qwN = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eOF().eOH().e(bVar);
            }
        };
        qwL = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.eOF().eOI().ab(th);
            }
        };
        qwO = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eOF().eOI().e(bVar);
            }
        };
        qwM = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.eOF().eOJ().ab(th);
            }
        };
        qwP = new rx.functions.f<b.InterfaceC1280b, b.InterfaceC1280b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1280b call(b.InterfaceC1280b interfaceC1280b) {
                return f.eOF().eOJ().a(interfaceC1280b);
            }
        };
        eOC();
    }

    static void eOC() {
        qwx = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eOF().eOH().b(aVar);
            }
        };
        qwy = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eOF().eOI().b(aVar);
            }
        };
        qwz = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eOF().eOJ().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = quy;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                ac(th2);
            }
        }
        ac(th);
    }

    static void ac(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = qwx;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = qwy;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = qwz;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qwD;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qwE;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qwF;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = qwG;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = qwA;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = qwH;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qwK;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qwN;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = qwB;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = qwI;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qwL;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qwO;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = qwC;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable af(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qwM;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eOD() {
        return qwJ;
    }
}
