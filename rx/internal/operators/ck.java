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
    static final Object iAy = new Object();
    final long ivC;
    final long ivD;
    final rx.g scheduler;
    final int size;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ck(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.ivC = j;
        this.ivD = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        if (this.ivC == this.ivD) {
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
        static final d<Object> iAZ = new d<>(null, null, 0);
        final int count;
        final rx.e<T> iAA;
        final rx.d<T> iAB;

        public d(rx.e<T> eVar, rx.d<T> dVar, int i) {
            this.iAA = eVar;
            this.iAB = dVar;
            this.count = i;
        }

        public d<T> ccC() {
            return new d<>(this.iAA, this.iAB, this.count + 1);
        }

        public d<T> a(rx.e<T> eVar, rx.d<T> dVar) {
            return new d<>(eVar, dVar, 0);
        }

        public d<T> ccD() {
            return ccE();
        }

        public static <T> d<T> ccE() {
            return (d<T>) iAZ;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        List<Object> iAC;
        final g.a iAS;
        final Object guard = new Object();
        volatile d<T> iAT = d.ccE();

        public b(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            this.child = new rx.b.f(jVar);
            this.iAS = aVar;
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ck.b.1
                @Override // rx.functions.a
                public void call() {
                    if (b.this.iAT.iAA == null) {
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
                    if (this.iAC == null) {
                        this.iAC = new ArrayList();
                    }
                    this.iAC.add(t);
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
                                    list = this.iAC;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iAC = null;
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
                if (obj == ck.iAy) {
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
            rx.e<T> eVar = this.iAT.iAA;
            if (eVar != null) {
                eVar.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.iAT = this.iAT.ccD();
                unsubscribe();
                return false;
            }
            UnicastSubject cdM = UnicastSubject.cdM();
            this.iAT = this.iAT.a(cdM, cdM);
            this.child.onNext(cdM);
            return true;
        }

        boolean bn(T t) {
            d<T> ccC;
            d<T> dVar = this.iAT;
            if (dVar.iAA == null) {
                if (!ccz()) {
                    return false;
                }
                dVar = this.iAT;
            }
            dVar.iAA.onNext(t);
            if (dVar.count == ck.this.size - 1) {
                dVar.iAA.onCompleted();
                ccC = dVar.ccD();
            } else {
                ccC = dVar.ccC();
            }
            this.iAT = ccC;
            return true;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iAC = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iAC = null;
                this.emitting = true;
                error(th);
            }
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iAT.iAA;
            this.iAT = this.iAT.ccD();
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            rx.e<T> eVar = this.iAT.iAA;
            this.iAT = this.iAT.ccD();
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
                    if (this.iAC == null) {
                        this.iAC = new ArrayList();
                    }
                    this.iAC.add(NotificationLite.cbH());
                    return;
                }
                List<Object> list = this.iAC;
                this.iAC = null;
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
            this.iAS.a(new rx.functions.a() { // from class: rx.internal.operators.ck.b.2
                @Override // rx.functions.a
                public void call() {
                    b.this.ccA();
                }
            }, 0L, ck.this.ivC, ck.this.unit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
        void ccA() {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iAC == null) {
                        this.iAC = new ArrayList();
                    }
                    this.iAC.add(ck.iAy);
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
                                    list = this.iAC;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iAC = null;
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
        final rx.e<T> iAA;
        final rx.d<T> iAB;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iAA = new rx.b.e(eVar);
            this.iAB = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final Object guard;
        final g.a iAS;
        final List<a<T>> ivy;

        public c(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            super(jVar);
            this.child = jVar;
            this.iAS = aVar;
            this.guard = new Object();
            this.ivy = new LinkedList();
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList<a> arrayList = new ArrayList(this.ivy);
                    Iterator<a<T>> it = this.ivy.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == ck.this.size) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.iAA.onNext(t);
                        if (aVar.count == ck.this.size) {
                            aVar.iAA.onCompleted();
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
                    ArrayList<a> arrayList = new ArrayList(this.ivy);
                    this.ivy.clear();
                    for (a aVar : arrayList) {
                        aVar.iAA.onError(th);
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
                    ArrayList<a> arrayList = new ArrayList(this.ivy);
                    this.ivy.clear();
                    for (a aVar : arrayList) {
                        aVar.iAA.onCompleted();
                    }
                    this.child.onCompleted();
                }
            }
        }

        void cbQ() {
            this.iAS.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.1
                @Override // rx.functions.a
                public void call() {
                    c.this.cbR();
                }
            }, ck.this.ivD, ck.this.ivD, ck.this.unit);
        }

        void cbR() {
            final a<T> ccB = ccB();
            synchronized (this.guard) {
                if (!this.done) {
                    this.ivy.add(ccB);
                    try {
                        this.child.onNext(ccB.iAB);
                        this.iAS.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.2
                            @Override // rx.functions.a
                            public void call() {
                                c.this.a(ccB);
                            }
                        }, ck.this.ivC, ck.this.unit);
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
                    Iterator<a<T>> it = this.ivy.iterator();
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
                        aVar.iAA.onCompleted();
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
