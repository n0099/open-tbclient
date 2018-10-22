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
    final long ivD;
    final long ivE;
    final rx.g scheduler;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ah(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.ivD = j;
        this.ivE = j2;
        this.unit = timeUnit;
        this.count = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        rx.b.f fVar = new rx.b.f(jVar);
        if (this.ivD == this.ivE) {
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
        final g.a ivF;
        final List<List<T>> ivz = new LinkedList();

        public b(rx.j<? super List<T>> jVar, g.a aVar) {
            this.child = jVar;
            this.ivF = aVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            LinkedList<List> linkedList = null;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.ivz.iterator();
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
                    this.ivz.clear();
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
                        LinkedList<List> linkedList = new LinkedList(this.ivz);
                        this.ivz.clear();
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
            this.ivF.a(new rx.functions.a() { // from class: rx.internal.operators.ah.b.1
                @Override // rx.functions.a
                public void call() {
                    b.this.cbR();
                }
            }, ah.this.ivE, ah.this.ivE, ah.this.unit);
        }

        void cbR() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.ivz.add(arrayList);
                    this.ivF.a(new rx.functions.a() { // from class: rx.internal.operators.ah.b.2
                        @Override // rx.functions.a
                        public void call() {
                            b.this.ez(arrayList);
                        }
                    }, ah.this.ivD, ah.this.unit);
                }
            }
        }

        void ez(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.ivz.iterator();
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
        final g.a ivF;
        List<T> ivr = new ArrayList();

        public a(rx.j<? super List<T>> jVar, g.a aVar) {
            this.child = jVar;
            this.ivF = aVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            List<T> list = null;
            synchronized (this) {
                if (!this.done) {
                    this.ivr.add(t);
                    if (this.ivr.size() == ah.this.count) {
                        list = this.ivr;
                        this.ivr = new ArrayList();
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
                    this.ivr = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
                this.ivF.unsubscribe();
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.ivr;
                        this.ivr = null;
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
            this.ivF.a(new rx.functions.a() { // from class: rx.internal.operators.ah.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.emit();
                }
            }, ah.this.ivD, ah.this.ivD, ah.this.unit);
        }

        void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.ivr;
                    this.ivr = new ArrayList();
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
