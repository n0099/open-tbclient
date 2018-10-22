package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class ck<T> implements d.b<rx.d<T>, T> {
    static final Object iAz = new Object();
    final long ivD;
    final long ivE;
    final rx.g scheduler;
    final int size;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ck(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.ivD = j;
        this.ivE = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        if (this.ivD == this.ivE) {
            b bVar = new b(jVar, createWorker);
            bVar.add(createWorker);
            bVar.cbP();
            return bVar;
        }
        c cVar = new c(jVar, createWorker);
        cVar.add(createWorker);
        cVar.cbR();
        cVar.cbQ();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<T> {
        static final d<Object> iBa = new d<>(null, null, 0);
        final int count;
        final rx.e<T> iAB;
        final rx.d<T> iAC;

        public d(rx.e<T> eVar, rx.d<T> dVar, int i) {
            this.iAB = eVar;
            this.iAC = dVar;
            this.count = i;
        }

        public d<T> ccC() {
            return new d<>(this.iAB, this.iAC, this.count + 1);
        }

        public d<T> a(rx.e<T> eVar, rx.d<T> dVar) {
            return new d<>(eVar, dVar, 0);
        }

        public d<T> ccD() {
            return ccE();
        }

        public static <T> d<T> ccE() {
            return (d<T>) iBa;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        List<Object> iAD;
        final g.a iAT;
        final Object guard = new Object();
        volatile d<T> iAU = d.ccE();

        public b(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            this.child = new rx.b.f(jVar);
            this.iAT = aVar;
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ck.b.1
                @Override // rx.functions.a
                public void call() {
                    if (b.this.iAU.iAB == null) {
                        b.this.unsubscribe();
                    }
                }
            }));
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [174=4] */
        @Override // rx.e
        public void onNext(T t) {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAD == null) {
                        this.iAD = new ArrayList();
                    }
                    this.iAD.add(t);
                    return;
                }
                this.emitting = true;
                try {
                    if (!bn(t)) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iAD;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iAD = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            z2 = z;
                            if (!z2) {
                                synchronized (this.guard) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } while (eB(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: rx.internal.operators.ck$b */
        /* JADX WARN: Multi-variable type inference failed */
        boolean eB(List<Object> list) {
            if (list == null) {
                return true;
            }
            for (Object obj : list) {
                if (obj == ck.iAz) {
                    if (!ccz()) {
                        return false;
                    }
                } else if (NotificationLite.ba(obj)) {
                    error(NotificationLite.bc(obj));
                    return true;
                } else if (NotificationLite.aZ(obj)) {
                    complete();
                    return true;
                } else if (!bn(obj)) {
                    return false;
                }
            }
            return true;
        }

        boolean ccz() {
            rx.e<T> eVar = this.iAU.iAB;
            if (eVar != null) {
                eVar.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.iAU = this.iAU.ccD();
                unsubscribe();
                return false;
            }
            UnicastSubject cdM = UnicastSubject.cdM();
            this.iAU = this.iAU.a(cdM, cdM);
            this.child.onNext(cdM);
            return true;
        }

        boolean bn(T t) {
            d<T> ccC;
            d<T> dVar = this.iAU;
            if (dVar.iAB == null) {
                if (!ccz()) {
                    return false;
                }
                dVar = this.iAU;
            }
            dVar.iAB.onNext(t);
            if (dVar.count == ck.this.size - 1) {
                dVar.iAB.onCompleted();
                ccC = dVar.ccD();
            } else {
                ccC = dVar.ccC();
            }
            this.iAU = ccC;
            return true;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iAD = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iAD = null;
                this.emitting = true;
                error(th);
            }
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iAU.iAB;
            this.iAU = this.iAU.ccD();
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            rx.e<T> eVar = this.iAU.iAB;
            this.iAU = this.iAU.ccD();
            if (eVar != null) {
                eVar.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAD == null) {
                        this.iAD = new ArrayList();
                    }
                    this.iAD.add(NotificationLite.cbH());
                    return;
                }
                List<Object> list = this.iAD;
                this.iAD = null;
                this.emitting = true;
                try {
                    eB(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void cbP() {
            this.iAT.a(new rx.functions.a() { // from class: rx.internal.operators.ck.b.2
                @Override // rx.functions.a
                public void call() {
                    b.this.ccA();
                }
            }, 0L, ck.this.ivD, ck.this.unit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
        void ccA() {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAD == null) {
                        this.iAD = new ArrayList();
                    }
                    this.iAD.add(ck.iAz);
                    return;
                }
                this.emitting = true;
                try {
                    if (!ccz()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iAD;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iAD = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            z2 = z;
                            if (!z2) {
                                synchronized (this.guard) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } while (eB(list));
                    synchronized (this.guard) {
                        this.emitting = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        int count;
        final rx.e<T> iAB;
        final rx.d<T> iAC;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iAB = new rx.b.e(eVar);
            this.iAC = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final Object guard;
        final g.a iAT;
        final List<a<T>> ivz;

        public c(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            super(jVar);
            this.child = jVar;
            this.iAT = aVar;
            this.guard = new Object();
            this.ivz = new LinkedList();
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList<a> arrayList = new ArrayList(this.ivz);
                    Iterator<a<T>> it = this.ivz.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == ck.this.size) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.iAB.onNext(t);
                        if (aVar.count == ck.this.size) {
                            aVar.iAB.onCompleted();
                        }
                    }
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    ArrayList<a> arrayList = new ArrayList(this.ivz);
                    this.ivz.clear();
                    for (a aVar : arrayList) {
                        aVar.iAB.onError(th);
                    }
                    this.child.onError(th);
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            synchronized (this.guard) {
                if (!this.done) {
                    this.done = true;
                    ArrayList<a> arrayList = new ArrayList(this.ivz);
                    this.ivz.clear();
                    for (a aVar : arrayList) {
                        aVar.iAB.onCompleted();
                    }
                    this.child.onCompleted();
                }
            }
        }

        void cbQ() {
            this.iAT.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.1
                @Override // rx.functions.a
                public void call() {
                    c.this.cbR();
                }
            }, ck.this.ivE, ck.this.ivE, ck.this.unit);
        }

        void cbR() {
            final a<T> ccB = ccB();
            synchronized (this.guard) {
                if (!this.done) {
                    this.ivz.add(ccB);
                    try {
                        this.child.onNext(ccB.iAC);
                        this.iAT.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.2
                            @Override // rx.functions.a
                            public void call() {
                                c.this.a(ccB);
                            }
                        }, ck.this.ivD, ck.this.unit);
                    } catch (Throwable th) {
                        onError(th);
                    }
                }
            }
        }

        void a(a<T> aVar) {
            boolean z;
            synchronized (this.guard) {
                if (!this.done) {
                    Iterator<a<T>> it = this.ivz.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next() == aVar) {
                            z = true;
                            it.remove();
                            break;
                        }
                    }
                    if (z) {
                        aVar.iAB.onCompleted();
                    }
                }
            }
        }

        a<T> ccB() {
            UnicastSubject cdM = UnicastSubject.cdM();
            return new a<>(cdM, cdM);
        }
    }
}
