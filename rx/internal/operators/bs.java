package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public final class bs<T> implements d.b<T, T> {
    final int count;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bs(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("count cannot be negative");
        }
        this.count = i;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final a aVar = new a(jVar, this.count);
        jVar.add(aVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.bs.1
            @Override // rx.f
            public void request(long j) {
                aVar.dC(j);
            }
        });
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.f<Object, T> {
        final rx.j<? super T> actual;
        final int count;
        final AtomicLong requested = new AtomicLong();
        final ArrayDeque<Object> iEn = new ArrayDeque<>();

        public a(rx.j<? super T> jVar, int i) {
            this.actual = jVar;
            this.count = i;
        }

        @Override // rx.e
        public void onNext(T t) {
            if (this.iEn.size() == this.count) {
                this.iEn.poll();
            }
            this.iEn.offer(NotificationLite.aY(t));
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iEn.clear();
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            rx.internal.operators.a.a(this.requested, this.iEn, this.actual, this);
        }

        @Override // rx.functions.f
        public T call(Object obj) {
            return (T) NotificationLite.bb(obj);
        }

        void dC(long j) {
            if (j > 0) {
                rx.internal.operators.a.a(this.requested, j, this.iEn, this.actual, this);
            }
        }
    }
}
