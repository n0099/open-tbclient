package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes6.dex */
public final class OnSubscribeDetach<T> implements d.a<T> {
    final rx.d<T> obl;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super T> jVar) {
        b bVar = new b(jVar);
        a aVar = new a(bVar);
        jVar.add(aVar);
        jVar.setProducer(aVar);
        this.obl.a((rx.j) bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b<T> extends rx.j<T> {
        final AtomicReference<rx.j<? super T>> actual;
        final AtomicReference<rx.f> obL = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        public b(rx.j<? super T> jVar) {
            this.actual = new AtomicReference<>(jVar);
        }

        @Override // rx.e
        public void onNext(T t) {
            rx.j<? super T> jVar = this.actual.get();
            if (jVar != null) {
                jVar.onNext(t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.obL.lazySet(TerminatedProducer.INSTANCE);
            rx.j<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th);
            } else {
                rx.c.c.onError(th);
            }
        }

        @Override // rx.e
        public void onCompleted() {
            this.obL.lazySet(TerminatedProducer.INSTANCE);
            rx.j<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        void gA(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            rx.f fVar = this.obL.get();
            if (fVar != null) {
                fVar.request(j);
                return;
            }
            rx.internal.operators.a.e(this.requested, j);
            rx.f fVar2 = this.obL.get();
            if (fVar2 != null && fVar2 != TerminatedProducer.INSTANCE) {
                fVar2.request(this.requested.getAndSet(0L));
            }
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            if (this.obL.compareAndSet(null, fVar)) {
                fVar.request(this.requested.getAndSet(0L));
            } else if (this.obL.get() != TerminatedProducer.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }

        void dUw() {
            this.obL.lazySet(TerminatedProducer.INSTANCE);
            this.actual.lazySet(null);
            unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> implements rx.f, rx.k {
        final b<T> obK;

        public a(b<T> bVar) {
            this.obK = bVar;
        }

        @Override // rx.f
        public void request(long j) {
            this.obK.gA(j);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.obK.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.obK.dUw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum TerminatedProducer implements rx.f {
        INSTANCE;

        @Override // rx.f
        public void request(long j) {
        }
    }
}
