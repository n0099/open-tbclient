package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.d;
import rx.subjects.UnicastSubject;
/* loaded from: classes2.dex */
public final class cj<T, U, V> implements d.b<rx.d<T>, T> {
    final rx.d<? extends U> iCw;
    final rx.functions.f<? super U, ? extends rx.d<? extends V>> iCx;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cj(rx.d<? extends U> dVar, rx.functions.f<? super U, ? extends rx.d<? extends V>> fVar) {
        this.iCw = dVar;
        this.iCx = fVar;
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
                bVar2.bl(u);
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
        this.iCw.unsafeSubscribe(jVar2);
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> {
        final rx.e<T> iCl;
        final rx.d<T> iCm;

        public a(rx.e<T> eVar, rx.d<T> dVar) {
            this.iCl = new rx.b.e(eVar);
            this.iCm = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends rx.j<T> {
        final rx.j<? super rx.d<T>> child;
        boolean done;
        final rx.subscriptions.b iCA;
        final Object guard = new Object();
        final List<a<T>> ixj = new LinkedList();

        public b(rx.j<? super rx.d<T>> jVar, rx.subscriptions.b bVar) {
            this.child = new rx.b.f(jVar);
            this.iCA = bVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this.guard) {
                if (!this.done) {
                    for (a aVar : new ArrayList(this.ixj)) {
                        aVar.iCl.onNext(t);
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
                        ArrayList<a> arrayList = new ArrayList(this.ixj);
                        this.ixj.clear();
                        for (a aVar : arrayList) {
                            aVar.iCl.onError(th);
                        }
                        this.child.onError(th);
                    }
                }
            } finally {
                this.iCA.unsubscribe();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
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
            } finally {
                this.iCA.unsubscribe();
            }
        }

        void bl(U u) {
            final a<T> cbV = cbV();
            synchronized (this.guard) {
                if (!this.done) {
                    this.ixj.add(cbV);
                    this.child.onNext(cbV.iCm);
                    try {
                        rx.d<? extends V> call = cj.this.iCx.call(u);
                        rx.j<V> jVar = new rx.j<V>() { // from class: rx.internal.operators.cj.b.1
                            boolean ivb = true;

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
                                if (this.ivb) {
                                    this.ivb = false;
                                    b.this.a(cbV);
                                    b.this.iCA.b(this);
                                }
                            }
                        };
                        this.iCA.add(jVar);
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

        a<T> cbV() {
            UnicastSubject cdj = UnicastSubject.cdj();
            return new a<>(cdj, cdj);
        }
    }
}
