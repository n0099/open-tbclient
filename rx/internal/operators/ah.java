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
    final long iEw;
    final long iEx;
    final rx.g scheduler;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ah(long j, long j2, TimeUnit timeUnit, int i, rx.g gVar) {
        this.iEw = j;
        this.iEx = j2;
        this.unit = timeUnit;
        this.count = i;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        rx.b.f fVar = new rx.b.f(jVar);
        if (this.iEw == this.iEx) {
            a aVar = new a(fVar, createWorker);
            aVar.add(createWorker);
            jVar.add(aVar);
            aVar.cdo();
            return aVar;
        }
        b bVar = new b(fVar, createWorker);
        bVar.add(createWorker);
        jVar.add(bVar);
        bVar.cdq();
        bVar.cdp();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super List<T>> child;
        boolean done;
        final List<List<T>> iEs = new LinkedList();
        final g.a iEy;

        public b(rx.j<? super List<T>> jVar, g.a aVar) {
            this.child = jVar;
            this.iEy = aVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            LinkedList<List> linkedList = null;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.iEs.iterator();
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
                    this.iEs.clear();
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
                        LinkedList<List> linkedList = new LinkedList(this.iEs);
                        this.iEs.clear();
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

        void cdp() {
            this.iEy.a(new rx.functions.a() { // from class: rx.internal.operators.ah.b.1
                @Override // rx.functions.a
                public void call() {
                    b.this.cdq();
                }
            }, ah.this.iEx, ah.this.iEx, ah.this.unit);
        }

        void cdq() {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.iEs.add(arrayList);
                    this.iEy.a(new rx.functions.a() { // from class: rx.internal.operators.ah.b.2
                        @Override // rx.functions.a
                        public void call() {
                            b.this.eB(arrayList);
                        }
                    }, ah.this.iEw, ah.this.unit);
                }
            }
        }

        void eB(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.iEs.iterator();
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
        List<T> iEk = new ArrayList();
        final g.a iEy;

        public a(rx.j<? super List<T>> jVar, g.a aVar) {
            this.child = jVar;
            this.iEy = aVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            List<T> list = null;
            synchronized (this) {
                if (!this.done) {
                    this.iEk.add(t);
                    if (this.iEk.size() == ah.this.count) {
                        list = this.iEk;
                        this.iEk = new ArrayList();
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
                    this.iEk = null;
                    this.child.onError(th);
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
                this.iEy.unsubscribe();
                synchronized (this) {
                    if (!this.done) {
                        this.done = true;
                        List<T> list = this.iEk;
                        this.iEk = null;
                        this.child.onNext(list);
                        this.child.onCompleted();
                        unsubscribe();
                    }
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this.child);
            }
        }

        void cdo() {
            this.iEy.a(new rx.functions.a() { // from class: rx.internal.operators.ah.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.emit();
                }
            }, ah.this.iEw, ah.this.iEw, ah.this.unit);
        }

        void emit() {
            synchronized (this) {
                if (!this.done) {
                    List<T> list = this.iEk;
                    this.iEk = new ArrayList();
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
