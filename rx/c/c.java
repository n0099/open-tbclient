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
    static volatile rx.functions.b<Throwable> qwg;
    static volatile rx.functions.f<d.a, d.a> qyf;
    static volatile rx.functions.f<h.a, h.a> qyg;
    static volatile rx.functions.f<b.a, b.a> qyh;
    static volatile rx.functions.g<rx.d, d.a, d.a> qyi;
    static volatile rx.functions.g<rx.h, h.a, h.a> qyj;
    static volatile rx.functions.g<rx.b, b.a, b.a> qyk;
    static volatile rx.functions.f<rx.g, rx.g> qyl;
    static volatile rx.functions.f<rx.g, rx.g> qym;
    static volatile rx.functions.f<rx.g, rx.g> qyn;
    static volatile rx.functions.f<rx.functions.a, rx.functions.a> qyo;
    static volatile rx.functions.f<k, k> qyp;
    static volatile rx.functions.f<k, k> qyq;
    static volatile rx.functions.e<? extends ScheduledExecutorService> qyr;
    static volatile rx.functions.f<Throwable, Throwable> qys;
    static volatile rx.functions.f<Throwable, Throwable> qyt;
    static volatile rx.functions.f<Throwable, Throwable> qyu;
    static volatile rx.functions.f<d.b, d.b> qyv;
    static volatile rx.functions.f<d.b, d.b> qyw;
    static volatile rx.functions.f<b.InterfaceC1321b, b.InterfaceC1321b> qyx;

    static {
        init();
    }

    static void init() {
        qwg = new rx.functions.b<Throwable>() { // from class: rx.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(Throwable th) {
                f.ePj().ePk().E(th);
            }
        };
        qyi = new rx.functions.g<rx.d, d.a, d.a>() { // from class: rx.c.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public d.a n(rx.d dVar, d.a aVar) {
                return f.ePj().ePl().c(dVar, aVar);
            }
        };
        qyp = new rx.functions.f<k, k>() { // from class: rx.c.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.ePj().ePl().e(kVar);
            }
        };
        qyj = new rx.functions.g<rx.h, h.a, h.a>() { // from class: rx.c.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: b */
            public h.a n(rx.h hVar, h.a aVar) {
                h ePm = f.ePj().ePm();
                return ePm == i.ePw() ? aVar : new s(ePm.a(hVar, new v(aVar)));
            }
        };
        qyq = new rx.functions.f<k, k>() { // from class: rx.c.c.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public k call(k kVar) {
                return f.ePj().ePm().e(kVar);
            }
        };
        qyk = new rx.functions.g<rx.b, b.a, b.a>() { // from class: rx.c.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: c */
            public b.a n(rx.b bVar, b.a aVar) {
                return f.ePj().ePn().a(bVar, aVar);
            }
        };
        qyo = new rx.functions.f<rx.functions.a, rx.functions.a>() { // from class: rx.c.c.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: j */
            public rx.functions.a call(rx.functions.a aVar) {
                return f.ePj().ePo().d(aVar);
            }
        };
        qys = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.ePj().ePl().ab(th);
            }
        };
        qyv = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.ePj().ePl().e(bVar);
            }
        };
        qyt = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.ePj().ePm().ab(th);
            }
        };
        qyw = new rx.functions.f<d.b, d.b>() { // from class: rx.c.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: d */
            public d.b call(d.b bVar) {
                return f.ePj().ePm().e(bVar);
            }
        };
        qyu = new rx.functions.f<Throwable, Throwable>() { // from class: rx.c.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: ag */
            public Throwable call(Throwable th) {
                return f.ePj().ePn().ab(th);
            }
        };
        qyx = new rx.functions.f<b.InterfaceC1321b, b.InterfaceC1321b>() { // from class: rx.c.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: b */
            public b.InterfaceC1321b call(b.InterfaceC1321b interfaceC1321b) {
                return f.ePj().ePn().a(interfaceC1321b);
            }
        };
        ePg();
    }

    static void ePg() {
        qyf = new rx.functions.f<d.a, d.a>() { // from class: rx.c.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public d.a call(d.a aVar) {
                return f.ePj().ePl().b(aVar);
            }
        };
        qyg = new rx.functions.f<h.a, h.a>() { // from class: rx.c.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public h.a call(h.a aVar) {
                return f.ePj().ePm().b(aVar);
            }
        };
        qyh = new rx.functions.f<b.a, b.a>() { // from class: rx.c.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: c */
            public b.a call(b.a aVar) {
                return f.ePj().ePn().b(aVar);
            }
        };
    }

    public static void onError(Throwable th) {
        rx.functions.b<Throwable> bVar = qwg;
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
        rx.functions.f<d.a, d.a> fVar = qyf;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> h.a<T> b(h.a<T> aVar) {
        rx.functions.f<h.a, h.a> fVar = qyg;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static b.a b(b.a aVar) {
        rx.functions.f<b.a, b.a> fVar = qyh;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static rx.g i(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qyl;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g j(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qym;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.g k(rx.g gVar) {
        rx.functions.f<rx.g, rx.g> fVar = qyn;
        return fVar != null ? fVar.call(gVar) : gVar;
    }

    public static rx.functions.a i(rx.functions.a aVar) {
        rx.functions.f<rx.functions.a, rx.functions.a> fVar = qyo;
        return fVar != null ? fVar.call(aVar) : aVar;
    }

    public static <T> d.a<T> a(rx.d<T> dVar, d.a<T> aVar) {
        rx.functions.g<rx.d, d.a, d.a> gVar = qyi;
        return gVar != null ? gVar.n(dVar, aVar) : aVar;
    }

    public static k b(k kVar) {
        rx.functions.f<k, k> fVar = qyp;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ad(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qys;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> b(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qyv;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> h.a<T> a(rx.h<T> hVar, h.a<T> aVar) {
        rx.functions.g<rx.h, h.a, h.a> gVar = qyj;
        return gVar != null ? gVar.n(hVar, aVar) : aVar;
    }

    public static k c(k kVar) {
        rx.functions.f<k, k> fVar = qyq;
        return fVar != null ? fVar.call(kVar) : kVar;
    }

    public static Throwable ae(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qyt;
        return fVar != null ? fVar.call(th) : th;
    }

    public static <T, R> d.b<R, T> c(d.b<R, T> bVar) {
        rx.functions.f<d.b, d.b> fVar = qyw;
        return fVar != null ? fVar.call(bVar) : bVar;
    }

    public static <T> b.a b(rx.b bVar, b.a aVar) {
        rx.functions.g<rx.b, b.a, b.a> gVar = qyk;
        return gVar != null ? gVar.n(bVar, aVar) : aVar;
    }

    public static Throwable af(Throwable th) {
        rx.functions.f<Throwable, Throwable> fVar = qyu;
        return fVar != null ? fVar.call(th) : th;
    }

    public static rx.functions.e<? extends ScheduledExecutorService> ePh() {
        return qyr;
    }
}
