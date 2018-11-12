package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.d;
import rx.g;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public final class bc<T> implements d.b<T, rx.d<T>> {
    final rx.functions.g<Integer, Throwable, Boolean> iAg;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bc(rx.functions.g<Integer, Throwable, Boolean> gVar) {
        this.iAg = gVar;
    }

    public rx.j<? super rx.d<T>> call(rx.j<? super T> jVar) {
        g.a createWorker = Schedulers.trampoline().createWorker();
        jVar.add(createWorker);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        jVar.setProducer(aVar);
        return new a(jVar, this.iAg, createWorker, dVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<rx.d<T>> {
        final rx.j<? super T> child;
        final rx.functions.g<Integer, Throwable, Boolean> iAg;
        final rx.subscriptions.d iAh;
        final rx.internal.producers.a iAi;
        final AtomicInteger iAj = new AtomicInteger();
        final g.a ixp;

        public a(rx.j<? super T> jVar, rx.functions.g<Integer, Throwable, Boolean> gVar, g.a aVar, rx.subscriptions.d dVar, rx.internal.producers.a aVar2) {
            this.child = jVar;
            this.iAg = gVar;
            this.ixp = aVar;
            this.iAh = dVar;
            this.iAi = aVar2;
        }

        @Override // rx.e
        public void onCompleted() {
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: h */
        public void onNext(final rx.d<T> dVar) {
            this.ixp.a(new rx.functions.a() { // from class: rx.internal.operators.bc.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.iAj.incrementAndGet();
                    rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.bc.a.1.1
                        boolean done;

                        @Override // rx.e
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                a.this.child.onCompleted();
                            }
                        }

                        @Override // rx.e
                        public void onError(Throwable th) {
                            if (!this.done) {
                                this.done = true;
                                if (a.this.iAg.j(Integer.valueOf(a.this.iAj.get()), th).booleanValue() && !a.this.ixp.isUnsubscribed()) {
                                    a.this.ixp.a(this);
                                } else {
                                    a.this.child.onError(th);
                                }
                            }
                        }

                        @Override // rx.e
                        public void onNext(T t) {
                            if (!this.done) {
                                a.this.child.onNext(t);
                                a.this.iAi.dE(1L);
                            }
                        }

                        @Override // rx.j
                        public void setProducer(rx.f fVar) {
                            a.this.iAi.setProducer(fVar);
                        }
                    };
                    a.this.iAh.g(jVar);
                    dVar.unsafeSubscribe(jVar);
                }
            });
        }
    }
}
