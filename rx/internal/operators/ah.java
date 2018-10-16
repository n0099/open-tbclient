package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class ah<T> implements d.b<List<T>, T> {
    final int count;
    final long ivC;
    final long ivD;
    final rx.g scheduler;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ah(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.ivC = j;
        this.ivD = j2;
        this.unit = timeUnit;
        this.count = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        rx.b.f fVar = new rx.b.f(jVar);
        if (this.ivC == this.ivD) {
            a aVar = new a(fVar, createWorker);
            aVar.add(createWorker);
            jVar.add(aVar);
            aVar.cbP();
            return aVar;
        }
        b bVar = new b(fVar, createWorker);
        bVar.add(createWorker);
        jVar.add(bVar);
        bVar.cbR();
        bVar.cbQ();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super List<T>> child;
        boolean done;
        final g.a ivE;
        final List<List<T>> ivy = new LinkedList();

        public b(rx.j<? super List<T>> jVar, g.a aVar) {
            this.child = jVar;
            this.ivE = aVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            LinkedList<List> linkedList = null;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.ivy.iterator();
                    while (it.hasNext()) {
                        List<T> next = it.next();
                        next.add(t);
                        if (next.size() == ah.this.count) {
                            it.remove();
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(next);
                        }
                        linkedList = linkedList;
                    }
                    if (linkedList != null) {
                        for (List list : linkedList) {
                            this.child.onNext(list);
                        }
                    }
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.ivy.clear();
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        LinkedList<List> linkedList = new LinkedList(this.ivy);
                        this.ivy.clear();
                        for (List list : linkedList) {
                            this.child.onNext(list);
                        }
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.child);
            }
        }

        void cbQ() {
            this.ivE.a(new rx.functions.a() { // from class: rx.internal.operators.ah.b.1
                @Override // rx.functions.a
                public void call() {
                    b.this.cbR();
                }
            }, ah.this.ivD, ah.this.ivD, ah.this.unit);
        }

        void cbR() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.ivy.add(arrayList);
                    this.ivE.a(new rx.functions.a() { // from class: rx.internal.operators.ah.b.2
                        @Override // rx.functions.a
                        public void call() {
                            b.this.ez(arrayList);
                        }
                    }, ah.this.ivC, ah.this.unit);
                }
            }
        }

        void ez(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.ivy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next() == list) {
                            it.remove();
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        try {
                            this.child.onNext(list);
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, this);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends rx.j<T> {
        final rx.j<? super List<T>> child;
        boolean done;
        final g.a ivE;
        List<T> ivq = new ArrayList();

        public a(rx.j<? super List<T>> jVar, g.a aVar) {
            this.child = jVar;
            this.ivE = aVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            List<T> list = null;
            synchronized (this) {
                if (!this.done) {
                    this.ivq.add(t);
                    if (this.ivq.size() == ah.this.count) {
                        list = this.ivq;
                        this.ivq = new ArrayList();
                    }
                    if (list != null) {
                        this.child.onNext(list);
                    }
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    this.ivq = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
                this.ivE.unsubscribe();
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.ivq;
                        this.ivq = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.child);
            }
        }

        void cbP() {
            this.ivE.a(new rx.functions.a() { // from class: rx.internal.operators.ah.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.emit();
                }
            }, ah.this.ivC, ah.this.ivC, ah.this.unit);
        }

        void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.ivq;
                    this.ivq = new ArrayList();
                    try {
                        this.child.onNext(list);
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, this);
                    }
                }
            }
        }
    }
}
