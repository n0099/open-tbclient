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
    static volatile rx.functions.b<Throwable> nmK;
    static volatile rx.functions.f<d.a, d.a> noM;
    static volatile rx.functions.f<h.a, h.a> noN;
    static volatile rx.functions.f<b.a, b.a> noO;
    static volatile rx.functions.g<rx.d, d.a, d.a> noP;
    static volatile rx.functions.g<rx.h, h.a, h.a> noQ;
    static volatile rx.functions.g<rx.b, b.a, b.a> noR;
    static volatile rx.functions.f<rx.g, rx.g> noS;
    static volatile rx.functions.f<rx.g, rx.g> noT;
    static volatile rx.functions.f<rx.g, rx.g> noU;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> noV;
    static volatile rx.functions.f<k, k> noW;
    static volatile rx.functions.f<k, k> noX;
    static volatile rx.functions.e<? extends ScheduledExecutorService> noY;
    static volatile rx.functions.f<Throwable, Throwable> noZ;
    static volatile rx.functions.f<Throwable, Throwable> npa;
    static volatile rx.functions.f<Throwable, Throwable> npb;
    static volatile rx.functions.f<d.b, d.b> npc;
    static volatile rx.functions.f<d.b, d.b> npd;
    static volatile rx.functions.f<b.InterfaceC0832b, b.InterfaceC0832b> npe;

    static {
        init();
    }

    static void init() {
        nmK = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dIw().dIx().H(th);
            }
        };
        noP = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.dIw().dIy().c(dVar, aVar);
            }
        };
        noW = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dIw().dIy().e(kVar);
            }
        };
        noQ = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h dIz = f.dIw().dIz();
                return dIz == i.dIJ() ? aVar : new t(dIz.a(hVar, new w(aVar)));
            }
        };
        noX = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dIw().dIz().e(kVar);
            }
        };
        noR = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.dIw().dIA().a(bVar, aVar);
            }
        };
        noV = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dIw().dIB().d(aVar);
            }
        };
        noZ = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dIw().dIy().aa(th);
            }
        };
        npc = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dIw().dIy().e(bVar);
            }
        };
        npa = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dIw().dIz().aa(th);
            }
        };
        npd = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dIw().dIz().e(bVar);
            }
        };
        npb = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: af */
            public Throwable call(Throwable th) {
                return f.dIw().dIA().aa(th);
            }
        };
        npe = new rx.functions.f<b.InterfaceC0832b, b.InterfaceC0832b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0832b call(b.InterfaceC0832b interfaceC0832b) {
                return f.dIw().dIA().a(interfaceC0832b);
            }
        };
        dIt();
    }

    static void dIt() {
        noM = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dIw().dIy().b(aVar);
            }
        };
        noN = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dIw().dIz().b(aVar);
            }
        };
        noO = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dIw().dIA().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = nmK;
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
        rx.functions.f<d.a, d.a> fVar = noM;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = noN;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = noO;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = noS;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = noT;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = noU;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = noV;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = noP;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = noW;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ac(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = noZ;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = npc;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = noQ;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = noX;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = npa;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = npd;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = noR;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = npb;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dIu() {
        return noY;
    }
}
