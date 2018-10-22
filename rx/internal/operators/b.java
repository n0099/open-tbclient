package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class b<T, R> extends rx.j<T> {
    protected final rx.j<? super R> actual;
    protected boolean hasValue;
    final AtomicInteger isZ = new AtomicInteger();
    protected R value;

    public b(rx.j<? super R> jVar) {
        this.actual = jVar;
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete() {
        this.actual.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete(R r) {
        rx.j<? super R> jVar = this.actual;
        do {
            int i = this.isZ.get();
            if (i != 2 && i != 3 && !jVar.isUnsubscribed()) {
                if (i == 1) {
                    jVar.onNext(r);
                    if (!jVar.isUnsubscribed()) {
                        jVar.onCompleted();
                    }
                    this.isZ.lazySet(3);
                    return;
                }
                this.value = r;
            } else {
                return;
            }
        } while (!this.isZ.compareAndSet(0, 2));
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: R, ? super R */
    final void dz(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
        if (j != 0) {
            rx.j<? super R> jVar = this.actual;
            do {
                int i = this.isZ.get();
                if (i != 1 && i != 3 && !jVar.isUnsubscribed()) {
                    if (i == 2) {
                        if (this.isZ.compareAndSet(2, 3)) {
                            jVar.onNext((R) this.value);
                            if (!jVar.isUnsubscribed()) {
                                jVar.onCompleted();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.isZ.compareAndSet(0, 1));
        }
    }

    @Override // rx.j
    public final void setProducer(rx.f fVar) {
        fVar.request(Long.MAX_VALUE);
    }

    public final void c(rx.d<? extends T> dVar) {
        cbG();
        dVar.unsafeSubscribe(this);
    }

    final void cbG() {
        rx.j<? super R> jVar = this.actual;
        jVar.add(this);
        jVar.setProducer(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a implements rx.f {
        final b<?, ?> ita;

        public a(b<?, ?> bVar) {
            this.ita = bVar;
        }

        @Override // rx.f
        public void request(long j) {
            this.ita.dz(j);
        }
    }
}
