package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public final class br<T> implements d.b<T, T> {
    final int limit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public br(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("limit >= 0 required but it was " + i);
        }
        this.limit = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.br$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends rx.j<T> {
        boolean completed;
        int count;
        final /* synthetic */ rx.j itz;

        AnonymousClass1(rx.j jVar) {
            this.itz = jVar;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.completed) {
                this.completed = true;
                this.itz.onCompleted();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.completed) {
                this.completed = true;
                try {
                    this.itz.onError(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (isUnsubscribed()) {
                return;
            }
            int i = this.count;
            this.count = i + 1;
            if (i < br.this.limit) {
                boolean z = this.count == br.this.limit;
                this.itz.onNext(t);
                if (z && !this.completed) {
                    this.completed = true;
                    try {
                        this.itz.onCompleted();
                    } finally {
                        unsubscribe();
                    }
                }
            }
        }

        @Override // rx.j
        public void setProducer(final rx.f fVar) {
            this.itz.setProducer(new rx.f() { // from class: rx.internal.operators.br.1.1
                final AtomicLong requested = new AtomicLong(0);

                @Override // rx.f
                public void request(long j) {
                    long j2;
                    long min;
                    if (j > 0 && !AnonymousClass1.this.completed) {
                        do {
                            j2 = this.requested.get();
                            min = Math.min(j, br.this.limit - j2);
                            if (min == 0) {
                                return;
                            }
                        } while (!this.requested.compareAndSet(j2, j2 + min));
                        fVar.request(min);
                    }
                }
            });
        }
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(jVar);
        if (this.limit == 0) {
            jVar.onCompleted();
            anonymousClass1.unsubscribe();
        }
        jVar.add(anonymousClass1);
        return anonymousClass1;
    }
}
