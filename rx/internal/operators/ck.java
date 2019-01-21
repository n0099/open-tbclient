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
    static final Object iNJ = new Object();
    final long iIO;
    final long iIP;
    final rx.g scheduler;
    final int size;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ck(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.iIO = j;
        this.iIP = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        if (this.iIO == this.iIP) {
            b bVar = new b(jVar, createWorker);
            bVar.add(createWorker);
            bVar.ceN();
            return bVar;
        }
        c cVar = new c(jVar, createWorker);
        cVar.add(createWorker);
        cVar.ceP();
        cVar.ceO();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<T> {
        static final d<Object> iOk = new d<>(null, null, 0);
        final int count;
        final rx.e<T> iNL;
        final rx.d<T> iNM;

        public d(rx.e<T> eVar, rx.d<T> dVar, int i) {
            this.iNL = eVar;
            this.iNM = dVar;
            this.count = i;
        }

        public d<T> cfA() {
            return new d<>(this.iNL, this.iNM, this.count + 1);
        }

        public d<T> a(rx.e<T> eVar, rx.d<T> dVar) {
            return new d<>(eVar, dVar, 0);
        }

        public d<T> cfB() {
            return cfC();
        }

        public static <T> d<T> cfC() {
            return (d<T>) iOk;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        List<Object> iNN;
        final g.a iOd;
        final Object guard = new Object();
        volatile d<T> iOe = d.cfC();

        public b(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            this.child = new rx.b.f(jVar);
            this.iOd = aVar;
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ck.b.1
                @Override // rx.functions.a
                public void call() {
                    if (b.this.iOe.iNL == null) {
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
                    if (this.iNN == null) {
                        this.iNN = new ArrayList();
                    }
                    this.iNN.add(t);
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
                                    list = this.iNN;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iNN = null;
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
                    } while (eF(list));
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
        boolean eF(List<Object> list) {
            if (list == null) {
                return true;
            }
            for (Object obj : list) {
                if (obj == ck.iNJ) {
                    if (!cfx()) {
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

        boolean cfx() {
            rx.e<T> eVar = this.iOe.iNL;
            if (eVar != null) {
                eVar.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.iOe = this.iOe.cfB();
                unsubscribe();
                return false;
            }
            UnicastSubject cgK = UnicastSubject.cgK();
            this.iOe = this.iOe.a(cgK, cgK);
            this.child.onNext(cgK);
            return true;
        }

        boolean bn(T t) {
            d<T> cfA;
            d<T> dVar = this.iOe;
            if (dVar.iNL == null) {
                if (!cfx()) {
                    return false;
                }
                dVar = this.iOe;
            }
            dVar.iNL.onNext(t);
            if (dVar.count == ck.this.size - 1) {
                dVar.iNL.onCompleted();
                cfA = dVar.cfB();
            } else {
                cfA = dVar.cfA();
            }
            this.iOe = cfA;
            return true;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iNN = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iNN = null;
                this.emitting = true;
                error(th);
            }
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iOe.iNL;
            this.iOe = this.iOe.cfB();
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            rx.e<T> eVar = this.iOe.iNL;
            this.iOe = this.iOe.cfB();
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
                    if (this.iNN == null) {
                        this.iNN = new ArrayList();
                    }
                    this.iNN.add(NotificationLite.ceF());
                    return;
                }
                List<Object> list = this.iNN;
                this.iNN = null;
                this.emitting = true;
                try {
                    eF(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void ceN() {
            this.iOd.a(new rx.functions.a() { // from class: rx.internal.operators.ck.b.2
                @Override // rx.functions.a
                public void call() {
                    b.this.cfy();
                }
            }, 0L, ck.this.iIO, ck.this.unit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
        void cfy() {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iNN == null) {
                        this.iNN = new ArrayList();
                    }
                    this.iNN.add(ck.iNJ);
                    return;
                }
                this.emitting = true;
                try {
                    if (!cfx()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iNN;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iNN = null;
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
                    } while (eF(list));
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
        final rx.e<T> iNL;
        final rx.d<T> iNM;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iNL = new rx.b.e(eVar);
            this.iNM = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final Object guard;
        final List<a<T>> iIK;
        final g.a iOd;

        public c(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            super(jVar);
            this.child = jVar;
            this.iOd = aVar;
            this.guard = new Object();
            this.iIK = new LinkedList();
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList<a> arrayList = new ArrayList(this.iIK);
                    Iterator<a<T>> it = this.iIK.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == ck.this.size) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.iNL.onNext(t);
                        if (aVar.count == ck.this.size) {
                            aVar.iNL.onCompleted();
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
                    ArrayList<a> arrayList = new ArrayList(this.iIK);
                    this.iIK.clear();
                    for (a aVar : arrayList) {
                        aVar.iNL.onError(th);
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
                    ArrayList<a> arrayList = new ArrayList(this.iIK);
                    this.iIK.clear();
                    for (a aVar : arrayList) {
                        aVar.iNL.onCompleted();
                    }
                    this.child.onCompleted();
                }
            }
        }

        void ceO() {
            this.iOd.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.1
                @Override // rx.functions.a
                public void call() {
                    c.this.ceP();
                }
            }, ck.this.iIP, ck.this.iIP, ck.this.unit);
        }

        void ceP() {
            final a<T> cfz = cfz();
            synchronized (this.guard) {
                if (!this.done) {
                    this.iIK.add(cfz);
                    try {
                        this.child.onNext(cfz.iNM);
                        this.iOd.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.2
                            @Override // rx.functions.a
                            public void call() {
                                c.this.a(cfz);
                            }
                        }, ck.this.iIO, ck.this.unit);
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
                    Iterator<a<T>> it = this.iIK.iterator();
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
                        aVar.iNL.onCompleted();
                    }
                }
            }
        }

        a<T> cfz() {
            UnicastSubject cgK = UnicastSubject.cgK();
            return new a<>(cgK, cgK);
        }
    }
}
