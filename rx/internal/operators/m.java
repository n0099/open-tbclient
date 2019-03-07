package rx.internal.operators;

import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class m<T> implements d.a<T> {
    final rx.d<T> jVu;
    final rx.g scheduler;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public m(rx.d<T> dVar, rx.g gVar) {
        this.scheduler = gVar;
        this.jVu = dVar;
    }

    public void call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        createWorker.c(new AnonymousClass1(jVar, createWorker));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.m$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements rx.functions.a {
        final /* synthetic */ g.a jYx;
        final /* synthetic */ rx.j val$subscriber;

        AnonymousClass1(rx.j jVar, g.a aVar) {
            this.val$subscriber = jVar;
            this.jYx = aVar;
        }

        @Override // rx.functions.a
        public void call() {
            final Thread currentThread = Thread.currentThread();
            m.this.jVu.a((rx.j) new rx.j<T>(this.val$subscriber) { // from class: rx.internal.operators.m.1.1
                @Override // rx.e
                public void onNext(T t) {
                    AnonymousClass1.this.val$subscriber.onNext(t);
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    try {
                        AnonymousClass1.this.val$subscriber.onError(th);
                    } finally {
                        AnonymousClass1.this.jYx.unsubscribe();
                    }
                }

                @Override // rx.e
                public void onCompleted() {
                    try {
                        AnonymousClass1.this.val$subscriber.onCompleted();
                    } finally {
                        AnonymousClass1.this.jYx.unsubscribe();
                    }
                }

                @Override // rx.j
                public void setProducer(final rx.f fVar) {
                    AnonymousClass1.this.val$subscriber.setProducer(new rx.f() { // from class: rx.internal.operators.m.1.1.1
                        @Override // rx.f
                        public void request(final long j) {
                            if (currentThread == Thread.currentThread()) {
                                fVar.request(j);
                            } else {
                                AnonymousClass1.this.jYx.c(new rx.functions.a() { // from class: rx.internal.operators.m.1.1.1.1
                                    @Override // rx.functions.a
                                    public void call() {
                                        fVar.request(j);
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }
    }
}
