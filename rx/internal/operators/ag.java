package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.d;
/* loaded from: classes2.dex */
public final class ag<T, TOpening, TClosing> implements d.b<List<T>, T> {
    final rx.d<? extends TOpening> ivv;
    final rx.functions.f<? super TOpening, ? extends rx.d<? extends TClosing>> ivw;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ag(rx.d<? extends TOpening> dVar, rx.functions.f<? super TOpening, ? extends rx.d<? extends TClosing>> fVar) {
        this.ivv = dVar;
        this.ivw = fVar;
    }

    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        final a aVar = new a(new rx.b.f(jVar));
        rx.j<TOpening> jVar2 = new rx.j<TOpening>() { // from class: rx.internal.operators.ag.1
            @Override // rx.e
            public void onNext(TOpening topening) {
                aVar.bf(topening);
            }

            @Override // rx.e
            public void onError(Throwable th) {
                aVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                aVar.onCompleted();
            }
        };
        jVar.add(jVar2);
        jVar.add(aVar);
        this.ivv.unsafeSubscribe(jVar2);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends rx.j<T> {
        final rx.j<? super List<T>> child;
        boolean done;
        final List<List<T>> ivz = new LinkedList();
        final rx.subscriptions.b ivA = new rx.subscriptions.b();

        public a(rx.j<? super List<T>> jVar) {
            this.child = jVar;
            add(this.ivA);
        }

        @Override // rx.e
        public void onNext(T t) {
            synchronized (this) {
                for (List<T> list : this.ivz) {
                    list.add(t);
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

        void bf(TOpening topening) {
            final ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.done) {
                    this.ivz.add(arrayList);
                    try {
                        rx.d<? extends TClosing> call = ag.this.ivw.call(topening);
                        rx.j<TClosing> jVar = new rx.j<TClosing>() { // from class: rx.internal.operators.ag.a.1
                            @Override // rx.e
                            public void onNext(TClosing tclosing) {
                                a.this.ivA.b(this);
                                a.this.ey(arrayList);
                            }

                            @Override // rx.e
                            public void onError(Throwable th) {
                                a.this.onError(th);
                            }

                            @Override // rx.e
                            public void onCompleted() {
                                a.this.ivA.b(this);
                                a.this.ey(arrayList);
                            }
                        };
                        this.ivA.add(jVar);
                        call.unsafeSubscribe(jVar);
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, this);
                    }
                }
            }
        }

        void ey(List<T> list) {
            boolean z;
            synchronized (this) {
                if (!this.done) {
                    Iterator<List<T>> it = this.ivz.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (it.next() == list) {
                            z = true;
                            it.remove();
                            break;
                        }
                    }
                    if (z) {
                        this.child.onNext(list);
                    }
                }
            }
        }
    }
}
