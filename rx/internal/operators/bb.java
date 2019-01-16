package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bb<T> implements d.b<T, T> {
    final rx.functions.f<? super Throwable, ? extends rx.d<? extends T>> iKQ;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bb<T> b(final rx.functions.f<? super Throwable, ? extends T> fVar) {
        return new bb<>(new rx.functions.f<Throwable, rx.d<? extends T>>() { // from class: rx.internal.operators.bb.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Q */
            public rx.d<? extends T> call(Throwable th) {
                return rx.d.just(rx.functions.f.this.call(th));
            }
        });
    }

    public static <T> bb<T> i(final rx.d<? extends T> dVar) {
        return new bb<>(new rx.functions.f<Throwable, rx.d<? extends T>>() { // from class: rx.internal.operators.bb.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Q */
            public rx.d<? extends T> call(Throwable th) {
                return rx.d.this;
            }
        });
    }

    public static <T> bb<T> j(final rx.d<? extends T> dVar) {
        return new bb<>(new rx.functions.f<Throwable, rx.d<? extends T>>() { // from class: rx.internal.operators.bb.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: Q */
            public rx.d<? extends T> call(Throwable th) {
                return th instanceof Exception ? rx.d.this : rx.d.error(th);
            }
        });
    }

    public bb(rx.functions.f<? super Throwable, ? extends rx.d<? extends T>> fVar) {
        this.iKQ = fVar;
    }

    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        final rx.internal.producers.a aVar = new rx.internal.producers.a();
        final rx.subscriptions.d dVar = new rx.subscriptions.d();
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.bb.4
            private boolean done;
            long produced;

            @Override // rx.e
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    jVar.onCompleted();
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                if (this.done) {
                    rx.exceptions.a.J(th);
                    rx.c.c.onError(th);
                    return;
                }
                this.done = true;
                try {
                    unsubscribe();
                    rx.j<T> jVar3 = new rx.j<T>() { // from class: rx.internal.operators.bb.4.1
                        @Override // rx.e
                        public void onNext(T t) {
                            jVar.onNext(t);
                        }

                        @Override // rx.e
                        public void onError(Throwable th2) {
                            jVar.onError(th2);
                        }

                        @Override // rx.e
                        public void onCompleted() {
                            jVar.onCompleted();
                        }

                        @Override // rx.j
                        public void setProducer(rx.f fVar) {
                            aVar.setProducer(fVar);
                        }
                    };
                    dVar.g(jVar3);
                    long j = this.produced;
                    if (j != 0) {
                        aVar.dQ(j);
                    }
                    bb.this.iKQ.call(th).unsafeSubscribe(jVar3);
                } catch (Throwable th2) {
                    rx.exceptions.a.a(th2, jVar);
                }
            }

            @Override // rx.e
            public void onNext(T t) {
                if (!this.done) {
                    this.produced++;
                    jVar.onNext(t);
                }
            }

            @Override // rx.j
            public void setProducer(rx.f fVar) {
                aVar.setProducer(fVar);
            }
        };
        dVar.g(jVar2);
        jVar.add(dVar);
        jVar.setProducer(aVar);
        return jVar2;
    }
}
