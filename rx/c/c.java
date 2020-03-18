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
    static volatile rx.functions.b<Throwable> nTa;
    static volatile rx.functions.f<d.a, d.a> nUZ;
    static volatile rx.functions.f<h.a, h.a> nVa;
    static volatile rx.functions.f<b.a, b.a> nVb;
    static volatile rx.functions.g<rx.d, d.a, d.a> nVc;
    static volatile rx.functions.g<rx.h, h.a, h.a> nVd;
    static volatile rx.functions.g<rx.b, b.a, b.a> nVe;
    static volatile rx.functions.f<rx.g, rx.g> nVf;
    static volatile rx.functions.f<rx.g, rx.g> nVg;
    static volatile rx.functions.f<rx.g, rx.g> nVh;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> nVi;
    static volatile rx.functions.f<k, k> nVj;
    static volatile rx.functions.f<k, k> nVk;
    static volatile rx.functions.e<? extends ScheduledExecutorService> nVl;
    static volatile rx.functions.f<Throwable, Throwable> nVm;
    static volatile rx.functions.f<Throwable, Throwable> nVn;
    static volatile rx.functions.f<Throwable, Throwable> nVo;
    static volatile rx.functions.f<d.b, d.b> nVp;
    static volatile rx.functions.f<d.b, d.b> nVq;
    static volatile rx.functions.f<b.InterfaceC0788b, b.InterfaceC0788b> nVr;

    static {
        init();
    }

    static void init() {
        nTa = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.dPz().dPA().D(th);
            }
        };
        nVc = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.dPz().dPB().c(dVar, aVar);
            }
        };
        nVj = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dPz().dPB().e(kVar);
            }
        };
        nVd = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h dPC = f.dPz().dPC();
                return dPC == i.dPM() ? aVar : new t(dPC.a(hVar, new w(aVar)));
            }
        };
        nVk = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.dPz().dPC().e(kVar);
            }
        };
        nVe = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.dPz().dPD().a(bVar, aVar);
            }
        };
        nVi = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.dPz().dPE().d(aVar);
            }
        };
        nVm = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.dPz().dPB().W(th);
            }
        };
        nVp = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dPz().dPB().e(bVar);
            }
        };
        nVn = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.dPz().dPC().W(th);
            }
        };
        nVq = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.dPz().dPC().e(bVar);
            }
        };
        nVo = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ab */
            public Throwable call(Throwable th) {
                return f.dPz().dPD().W(th);
            }
        };
        nVr = new rx.functions.f<b.InterfaceC0788b, b.InterfaceC0788b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC0788b call(b.InterfaceC0788b interfaceC0788b) {
                return f.dPz().dPD().a(interfaceC0788b);
            }
        };
        dPw();
    }

    static void dPw() {
        nUZ = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.dPz().dPB().b(aVar);
            }
        };
        nVa = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.dPz().dPC().b(aVar);
            }
        };
        nVb = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.dPz().dPD().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = nTa;
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
        rx.functions.f<d.a, d.a> fVar = nUZ;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = nVa;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = nVb;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nVf;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nVg;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = nVh;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = nVi;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = nVc;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = nVj;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Y(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nVm;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = nVp;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = nVd;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = nVk;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable Z(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nVn;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = nVq;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = nVe;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable aa(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = nVo;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> dPx() {
        return nVl;
    }
}
