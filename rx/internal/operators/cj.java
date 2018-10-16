package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class cj<T, U, V> implements d.b<rx.d<T>, T> {
    final rx.d<? extends U> iAL;
    final rx.functions.f<? super U, ? extends rx.d<? extends V>> iAM;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cj(rx.d<? extends U> dVar, rx.functions.f<? super U, ? extends rx.d<? extends V>> fVar) {
        this.iAL = dVar;
        this.iAM = fVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<T>> jVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        jVar.add(bVar);
        final b bVar2 = new b(jVar, bVar);
        rx.j<U> jVar2 = new rx.j<U>() { // from class: rx.internal.operators.cj.1
            @Override // rx.j
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.e
            public void onNext(U u) {
                bVar2.bm(u);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                bVar2.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                bVar2.onCompleted();
            }
        };
        bVar.add(bVar2);
        bVar.add(jVar2);
        this.iAL.unsafeSubscribe(jVar2);
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        final rx.e<T> iAA;
        final rx.d<T> iAB;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iAA = new rx.b.e(eVar);
            this.iAB = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final rx.subscriptions.b iAP;
        final Object guard = new Object();
        final List<a<T>> ivy = new LinkedList();

        public b(rx.j<? super rx.d<T>> jVar, rx.subscriptions.b bVar) {
            this.child = new rx.b.f(jVar);
            this.iAP = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    for (a aVar : new ArrayList(this.ivy)) {
                        aVar.iAA.onNext(t);
                    }
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            try {
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
            } finally {
                this.iAP.unsubscribe();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
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
            } finally {
                this.iAP.unsubscribe();
            }
        }

        void bm(U u) {
            final a<T> ccy = ccy();
            synchronized (this.guard) {
                if (!this.done) {
                    this.ivy.add(ccy);
                    this.child.onNext(ccy.iAB);
                    try {
                        rx.d<? extends V> call = cj.this.iAM.call(u);
                        rx.j<V> jVar = new rx.j<V>() { // from class: rx.internal.operators.cj.b.1
                            boolean itq = true;

                            @Override // rx.e
                            public void onNext(V v) {
                                onCompleted();
                            }

                            @Override // rx.e
                            public void onError(Throwable th) {
                                b.this.onError(th);
                            }

                            @Override // rx.e
                            public void onCompleted() {
                                if (this.itq) {
                                    this.itq = false;
                                    b.this.a(ccy);
                                    b.this.iAP.b(this);
                                }
                            }
                        };
                        this.iAP.add(jVar);
                        call.unsafeSubscribe(jVar);
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

        a<T> ccy() {
            UnicastSubject cdM = UnicastSubject.cdM();
            return new a<>(cdM, cdM);
        }
    }
}
