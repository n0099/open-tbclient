package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.t;
import rx.internal.operators.w;
import rx.k;
/* loaded from: classes4.dex */
public final class c {
    static volatile rx.functions.b<Throwable> nhi;
    static volatile rx.functions.f<d.b, d.b> njA;
    static volatile rx.functions.f<b.InterfaceC0725b, b.InterfaceC0725b> njB;
    static volatile rx.functions.f<d.a, d.a> njj;
    static volatile rx.functions.f<h.a, h.a> njk;
    static volatile rx.functions.f<b.a, b.a> njl;
    static volatile rx.functions.g<rx.d, d.a, d.a> njm;
    static volatile rx.functions.g<rx.h, h.a, h.a> njn;
    static volatile rx.functions.g<rx.b, b.a, b.a> njo;
    static volatile rx.functions.f<rx.g, rx.g> njp;
    static volatile rx.functions.f<rx.g, rx.g> njq;
    static volatile rx.functions.f<rx.g, rx.g> njr;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> njs;
    static volatile rx.functions.f<k, k> njt;
    static volatile rx.functions.f<k, k> nju;
    static volatile rx.functions.e<? extends ScheduledExecutorService> njv;
    static volatile rx.functions.f<Throwable, Throwable> njw;
    static volatile rx.functions.f<Throwable, Throwable> njx;
    static volatile rx.functions.f<Throwable, Throwable> njy;
    static volatile rx.functions.f<d.b, d.b> njz;

    static {
        init();
    }

    static void init() {
        nhi = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dHg().dHh().E(th);
            }
        };
        njm = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a m(rx.d dVar, d.a aVar) {
                return f.dHg().dHi().c(dVar, aVar);
            }
        };
        njt = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dHg().dHi().e(kVar);
            }
        };
        njn = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a m(rx.h hVar, h.a aVar) {
                h dHj = f.dHg().dHj();
                return dHj == i.dHt() ? aVar : new t(dHj.a(hVar, new w(aVar)));
            }
        };
        nju = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dHg().dHj().e(kVar);
            }
        };
        njo = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a m(rx.b bVar, b.a aVar) {
                return f.dHg().dHk().a(bVar, aVar);
            }
        };
        njs = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dHg().dHl().d(aVar);
            }
        };
        njw = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: aa */
            public Throwable call(Throwable th) {
                return f.dHg().dHi().V(th);
            }
        };
        njz = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dHg().dHi().e(bVar);
            }
        };
        njx = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: aa */
            public Throwable call(Throwable th) {
                return f.dHg().dHj().V(th);
            }
        };
        njA = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dHg().dHj().e(bVar);
            }
        };
        njy = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: aa */
            public Throwable call(Throwable th) {
                return f.dHg().dHk().V(th);
            }
        };
        njB = new rx.functions.f<b.InterfaceC0725b, b.InterfaceC0725b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0725b call(b.InterfaceC0725b interfaceC0725b) {
                return f.dHg().dHk().a(interfaceC0725b);
            }
        };
        dHd();
    }

    static void dHd() {
        njj = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dHg().dHi().b(aVar);
            }
        };
        njk = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dHg().dHj().b(aVar);
            }
        };
        njl = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dHg().dHk().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = nhi;
        if (bVar != null) {
            try {
                bVar.call(th);
                return;
            } catch (Throwable th2) {
                System.err.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                W(th2);
            }
        }
        W(th);
    }

    static void W(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> d.a<T> b(d.a<T> aVar) {
        rx.functions.f<d.a, d.a> fVar = njj;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = njk;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = njl;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = njp;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = njq;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = njr;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = njs;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = njm;
        return gVar != null ? gVar.m(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = njt;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable X(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = njw;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = njz;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = njn;
        return gVar != null ? gVar.m(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = nju;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = njx;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = njA;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = njo;
        return gVar != null ? gVar.m(bVar, aVar) : aVar;
    }

    public static Throwable Z(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = njy;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dHe() {
        return njv;
    }
}
