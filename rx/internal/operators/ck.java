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
    static final Object iCj = new Object();
    final long ixn;
    final long ixo;
    final rx.g scheduler;
    final int size;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ck(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.ixn = j;
        this.ixo = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        if (this.ixn == this.ixo) {
            b bVar = new b(jVar, createWorker);
            bVar.add(createWorker);
            bVar.cbm();
            return bVar;
        }
        c cVar = new c(jVar, createWorker);
        cVar.add(createWorker);
        cVar.cbo();
        cVar.cbn();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<T> {
        static final d<Object> iCK = new d<>(null, null, 0);
        final int count;
        final rx.e<T> iCl;
        final rx.d<T> iCm;

        public d(rx.e<T> eVar, rx.d<T> dVar, int i) {
            this.iCl = eVar;
            this.iCm = dVar;
            this.count = i;
        }

        public d<T> cbZ() {
            return new d<>(this.iCl, this.iCm, this.count + 1);
        }

        public d<T> a(rx.e<T> eVar, rx.d<T> dVar) {
            return new d<>(eVar, dVar, 0);
        }

        public d<T> cca() {
            return ccb();
        }

        public static <T> d<T> ccb() {
            return (d<T>) iCK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        final g.a iCD;
        List<Object> iCn;
        final Object guard = new Object();
        volatile d<T> iCE = d.ccb();

        public b(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            this.child = new rx.b.f(jVar);
            this.iCD = aVar;
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ck.b.1
                @Override // rx.functions.a
                public void call() {
                    if (b.this.iCE.iCl == null) {
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
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    this.iCn.add(t);
                    return;
                }
                this.emitting = true;
                try {
                    if (!bm(t)) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iCn;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iCn = null;
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
                    } while (ez(list));
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
        boolean ez(List<Object> list) {
            if (list == null) {
                return true;
            }
            for (Object obj : list) {
                if (obj == ck.iCj) {
                    if (!cbW()) {
                        return false;
                    }
                } else if (NotificationLite.aZ(obj)) {
                    error(NotificationLite.bb(obj));
                    return true;
                } else if (NotificationLite.aY(obj)) {
                    complete();
                    return true;
                } else if (!bm(obj)) {
                    return false;
                }
            }
            return true;
        }

        boolean cbW() {
            rx.e<T> eVar = this.iCE.iCl;
            if (eVar != null) {
                eVar.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.iCE = this.iCE.cca();
                unsubscribe();
                return false;
            }
            UnicastSubject cdj = UnicastSubject.cdj();
            this.iCE = this.iCE.a(cdj, cdj);
            this.child.onNext(cdj);
            return true;
        }

        boolean bm(T t) {
            d<T> cbZ;
            d<T> dVar = this.iCE;
            if (dVar.iCl == null) {
                if (!cbW()) {
                    return false;
                }
                dVar = this.iCE;
            }
            dVar.iCl.onNext(t);
            if (dVar.count == ck.this.size - 1) {
                dVar.iCl.onCompleted();
                cbZ = dVar.cca();
            } else {
                cbZ = dVar.cbZ();
            }
            this.iCE = cbZ;
            return true;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iCn = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iCn = null;
                this.emitting = true;
                error(th);
            }
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iCE.iCl;
            this.iCE = this.iCE.cca();
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            rx.e<T> eVar = this.iCE.iCl;
            this.iCE = this.iCE.cca();
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
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    this.iCn.add(NotificationLite.cbe());
                    return;
                }
                List<Object> list = this.iCn;
                this.iCn = null;
                this.emitting = true;
                try {
                    ez(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void cbm() {
            this.iCD.a(new rx.functions.a() { // from class: rx.internal.operators.ck.b.2
                @Override // rx.functions.a
                public void call() {
                    b.this.cbX();
                }
            }, 0L, ck.this.ixn, ck.this.unit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
        void cbX() {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iCn == null) {
                        this.iCn = new ArrayList();
                    }
                    this.iCn.add(ck.iCj);
                    return;
                }
                this.emitting = true;
                try {
                    if (!cbW()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iCn;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iCn = null;
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
                    } while (ez(list));
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
        final rx.e<T> iCl;
        final rx.d<T> iCm;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iCl = new rx.b.e(eVar);
            this.iCm = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final Object guard;
        final g.a iCD;
        final List<a<T>> ixj;

        public c(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            super(jVar);
            this.child = jVar;
            this.iCD = aVar;
            this.guard = new Object();
            this.ixj = new LinkedList();
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList<a> arrayList = new ArrayList(this.ixj);
                    Iterator<a<T>> it = this.ixj.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == ck.this.size) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.iCl.onNext(t);
                        if (aVar.count == ck.this.size) {
                            aVar.iCl.onCompleted();
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
                    ArrayList<a> arrayList = new ArrayList(this.ixj);
                    this.ixj.clear();
                    for (a aVar : arrayList) {
                        aVar.iCl.onError(th);
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
                    ArrayList<a> arrayList = new ArrayList(this.ixj);
                    this.ixj.clear();
                    for (a aVar : arrayList) {
                        aVar.iCl.onCompleted();
                    }
                    this.child.onCompleted();
                }
            }
        }

        void cbn() {
            this.iCD.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.1
                @Override // rx.functions.a
                public void call() {
                    c.this.cbo();
                }
            }, ck.this.ixo, ck.this.ixo, ck.this.unit);
        }

        void cbo() {
            final a<T> cbY = cbY();
            synchronized (this.guard) {
                if (!this.done) {
                    this.ixj.add(cbY);
                    try {
                        this.child.onNext(cbY.iCm);
                        this.iCD.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.2
                            @Override // rx.functions.a
                            public void call() {
                                c.this.a(cbY);
                            }
                        }, ck.this.ixn, ck.this.unit);
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
                    Iterator<a<T>> it = this.ixj.iterator();
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
                        aVar.iCl.onCompleted();
                    }
                }
            }
        }

        a<T> cbY() {
            UnicastSubject cdj = UnicastSubject.cdj();
            return new a<>(cdj, cdj);
        }
    }
}
