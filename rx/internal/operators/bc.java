package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.d;
import rx.g;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public final class bc<T> implements d.b<T, rx.d<T>> {
    final rx.functions.g<Integer, Throwable, Boolean> iyw;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bc(rx.functions.g<Integer, Throwable, Boolean> gVar) {
        this.iyw = gVar;
    }

    public rx.j<? super rx.d<T>> call(rx.j<? super T> jVar) {
        g.a createWorker = Schedulers.trampoline().createWorker();
        jVar.add(createWorker);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        jVar.setProducer(aVar);
        return new a(jVar, this.iyw, createWorker, dVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<rx.d<T>> {
        final rx.j<? super T> child;
        final g.a ivF;
        final rx.functions.g<Integer, Throwable, Boolean> iyw;
        final rx.subscriptions.d iyx;
        final rx.internal.producers.a iyy;
        final AtomicInteger iyz = new AtomicInteger();

        public a(rx.j<? super T> jVar, rx.functions.g<Integer, Throwable, Boolean> gVar, g.a aVar, rx.subscriptions.d dVar, rx.internal.producers.a aVar2) {
            this.child = jVar;
            this.iyw = gVar;
            this.ivF = aVar;
            this.iyx = dVar;
            this.iyy = aVar2;
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
            this.ivF.a(new rx.functions.a() { // from class: rx.internal.operators.bc.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.iyz.incrementAndGet();
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
                                if (a.this.iyw.j(Integer.valueOf(a.this.iyz.get()), th).booleanValue() && !a.this.ivF.isUnsubscribed()) {
                                    a.this.ivF.a(this);
                                } else {
                                    a.this.child.onError(th);
                                }
                            }
                        }

                        @Override // rx.e
                        public void onNext(T t) {
                            if (!this.done) {
                                a.this.child.onNext(t);
                                a.this.iyy.dJ(1L);
                            }
                        }

                        @Override // rx.j
                        public void setProducer(rx.f fVar) {
                            a.this.iyy.setProducer(fVar);
                        }
                    };
                    a.this.iyx.g(jVar);
                    dVar.unsafeSubscribe(jVar);
                }
            });
        }
    }
}
