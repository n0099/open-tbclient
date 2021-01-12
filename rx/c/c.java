package rx.c;

import java.util.concurrent.ScheduledExecutorService;
import rx.b;
import rx.d;
import rx.h;
import rx.internal.operators.s;
import rx.internal.operators.v;
import rx.k;
/* loaded from: classes14.dex */
public final class c {
    static volatile rx.functions.b<Throwable> qrE;
    static volatile rx.functions.f<d.a, d.a> qtD;
    static volatile rx.functions.f<h.a, h.a> qtE;
    static volatile rx.functions.f<b.a, b.a> qtF;
    static volatile rx.functions.g<rx.d, d.a, d.a> qtG;
    static volatile rx.functions.g<rx.h, h.a, h.a> qtH;
    static volatile rx.functions.g<rx.b, b.a, b.a> qtI;
    static volatile rx.functions.f<rx.g, rx.g> qtJ;
    static volatile rx.functions.f<rx.g, rx.g> qtK;
    static volatile rx.functions.f<rx.g, rx.g> qtL;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> qtM;
    static volatile rx.functions.f<k, k> qtN;
    static volatile rx.functions.f<k, k> qtO;
    static volatile rx.functions.e<? extends ScheduledExecutorService> qtP;
    static volatile rx.functions.f<Throwable, Throwable> qtQ;
    static volatile rx.functions.f<Throwable, Throwable> qtR;
    static volatile rx.functions.f<Throwable, Throwable> qtS;
    static volatile rx.functions.f<d.b, d.b> qtT;
    static volatile rx.functions.f<d.b, d.b> qtU;
    static volatile rx.functions.f<b.InterfaceC1304b, b.InterfaceC1304b> qtV;

    static {
        init();
    }

    static void init() {
        qrE = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.eLt().eLu().E(th);
            }
        };
        qtG = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.eLt().eLv().c(dVar, aVar);
            }
        };
        qtN = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eLt().eLv().e(kVar);
            }
        };
        qtH = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h eLw = f.eLt().eLw();
                return eLw == i.eLG() ? aVar : new s(eLw.a(hVar, new v(aVar)));
            }
        };
        qtO = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.eLt().eLw().e(kVar);
            }
        };
        qtI = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.eLt().eLx().a(bVar, aVar);
            }
        };
        qtM = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.eLt().eLy().d(aVar);
            }
        };
        qtQ = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.eLt().eLv().ab(th);
            }
        };
        qtT = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eLt().eLv().e(bVar);
            }
        };
        qtR = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.eLt().eLw().ab(th);
            }
        };
        qtU = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.eLt().eLw().e(bVar);
            }
        };
        qtS = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.eLt().eLx().ab(th);
            }
        };
        qtV = new rx.functions.f<b.InterfaceC1304b, b.InterfaceC1304b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1304b call(b.InterfaceC1304b interfaceC1304b) {
                return f.eLt().eLx().a(interfaceC1304b);
            }
        };
        eLq();
    }

    static void eLq() {
        qtD = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.eLt().eLv().b(aVar);
            }
        };
        qtE = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.eLt().eLw().b(aVar);
            }
        };
        qtF = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.eLt().eLx().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = qrE;
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
        rx.functions.f<d.a, d.a> fVar = qtD;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = qtE;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = qtF;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qtJ;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qtK;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qtL;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = qtM;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = qtG;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = qtN;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qtQ;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qtT;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = qtH;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = qtO;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qtR;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qtU;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = qtI;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable af(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qtS;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> eLr() {
        return qtP;
    }
}
