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
    static final Object iJr = new Object();
    final long iEw;
    final long iEx;
    final rx.g scheduler;
    final int size;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ck(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.iEw = j;
        this.iEx = j2;
        this.unit = timeUnit;
        this.size = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        if (this.iEw == this.iEx) {
            b bVar = new b(jVar, createWorker);
            bVar.add(createWorker);
            bVar.cdp();
            return bVar;
        }
        c cVar = new c(jVar, createWorker);
        cVar.add(createWorker);
        cVar.cdr();
        cVar.cdq();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<T> {
        static final d<Object> iJS = new d<>(null, null, 0);
        final int count;
        final rx.e<T> iJt;
        final rx.d<T> iJu;

        public d(rx.e<T> eVar, rx.d<T> dVar, int i) {
            this.iJt = eVar;
            this.iJu = dVar;
            this.count = i;
        }

        public d<T> cec() {
            return new d<>(this.iJt, this.iJu, this.count + 1);
        }

        public d<T> a(rx.e<T> eVar, rx.d<T> dVar) {
            return new d<>(eVar, dVar, 0);
        }

        public d<T> ced() {
            return cee();
        }

        public static <T> d<T> cee() {
            return (d<T>) iJS;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean emitting;
        final g.a iJL;
        List<Object> iJv;
        final Object guard = new Object();
        volatile d<T> iJM = d.cee();

        public b(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            this.child = new rx.b.f(jVar);
            this.iJL = aVar;
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ck.b.1
                @Override // rx.functions.a
                public void call() {
                    if (b.this.iJM.iJt == null) {
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
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(t);
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
                                    list = this.iJv;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iJv = null;
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
                    } while (eD(list));
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
        boolean eD(List<Object> list) {
            if (list == null) {
                return true;
            }
            for (Object obj : list) {
                if (obj == ck.iJr) {
                    if (!cdZ()) {
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

        boolean cdZ() {
            rx.e<T> eVar = this.iJM.iJt;
            if (eVar != null) {
                eVar.onCompleted();
            }
            if (this.child.isUnsubscribed()) {
                this.iJM = this.iJM.ced();
                unsubscribe();
                return false;
            }
            UnicastSubject cfm = UnicastSubject.cfm();
            this.iJM = this.iJM.a(cfm, cfm);
            this.child.onNext(cfm);
            return true;
        }

        boolean bn(T t) {
            d<T> cec;
            d<T> dVar = this.iJM;
            if (dVar.iJt == null) {
                if (!cdZ()) {
                    return false;
                }
                dVar = this.iJM;
            }
            dVar.iJt.onNext(t);
            if (dVar.count == ck.this.size - 1) {
                dVar.iJt.onCompleted();
                cec = dVar.ced();
            } else {
                cec = dVar.cec();
            }
            this.iJM = cec;
            return true;
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.iJv = Collections.singletonList(NotificationLite.M(th));
                    return;
                }
                this.iJv = null;
                this.emitting = true;
                error(th);
            }
        }

        void error(Throwable th) {
            rx.e<T> eVar = this.iJM.iJt;
            this.iJM = this.iJM.ced();
            if (eVar != null) {
                eVar.onError(th);
            }
            this.child.onError(th);
            unsubscribe();
        }

        void complete() {
            rx.e<T> eVar = this.iJM.iJt;
            this.iJM = this.iJM.ced();
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
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(NotificationLite.cdh());
                    return;
                }
                List<Object> list = this.iJv;
                this.iJv = null;
                this.emitting = true;
                try {
                    eD(list);
                    complete();
                } catch (Throwable th) {
                    error(th);
                }
            }
        }

        void cdp() {
            this.iJL.a(new rx.functions.a() { // from class: rx.internal.operators.ck.b.2
                @Override // rx.functions.a
                public void call() {
                    b.this.cea();
                }
            }, 0L, ck.this.iEw, ck.this.unit);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
        void cea() {
            List<Object> list;
            boolean z = true;
            boolean z2 = false;
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.iJv == null) {
                        this.iJv = new ArrayList();
                    }
                    this.iJv.add(ck.iJr);
                    return;
                }
                this.emitting = true;
                try {
                    if (!cdZ()) {
                        synchronized (this.guard) {
                            this.emitting = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.guard) {
                                try {
                                    list = this.iJv;
                                    if (list == null) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.iJv = null;
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
                    } while (eD(list));
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
        final rx.e<T> iJt;
        final rx.d<T> iJu;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iJt = new rx.b.e(eVar);
            this.iJu = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final Object guard;
        final List<a<T>> iEs;
        final g.a iJL;

        public c(rx.j<? super rx.d<T>> jVar, g.a aVar) {
            super(jVar);
            this.child = jVar;
            this.iJL = aVar;
            this.guard = new Object();
            this.iEs = new LinkedList();
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    ArrayList<a> arrayList = new ArrayList(this.iEs);
                    Iterator<a<T>> it = this.iEs.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i = next.count + 1;
                        next.count = i;
                        if (i == ck.this.size) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.iJt.onNext(t);
                        if (aVar.count == ck.this.size) {
                            aVar.iJt.onCompleted();
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
                    ArrayList<a> arrayList = new ArrayList(this.iEs);
                    this.iEs.clear();
                    for (a aVar : arrayList) {
                        aVar.iJt.onError(th);
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
                    ArrayList<a> arrayList = new ArrayList(this.iEs);
                    this.iEs.clear();
                    for (a aVar : arrayList) {
                        aVar.iJt.onCompleted();
                    }
                    this.child.onCompleted();
                }
            }
        }

        void cdq() {
            this.iJL.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.1
                @Override // rx.functions.a
                public void call() {
                    c.this.cdr();
                }
            }, ck.this.iEx, ck.this.iEx, ck.this.unit);
        }

        void cdr() {
            final a<T> ceb = ceb();
            synchronized (this.guard) {
                if (!this.done) {
                    this.iEs.add(ceb);
                    try {
                        this.child.onNext(ceb.iJu);
                        this.iJL.a(new rx.functions.a() { // from class: rx.internal.operators.ck.c.2
                            @Override // rx.functions.a
                            public void call() {
                                c.this.a(ceb);
                            }
                        }, ck.this.iEw, ck.this.unit);
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
                    Iterator<a<T>> it = this.iEs.iterator();
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
                        aVar.iJt.onCompleted();
                    }
                }
            }
        }

        a<T> ceb() {
            UnicastSubject cfm = UnicastSubject.cfm();
            return new a<>(cfm, cfm);
        }
    }
}
