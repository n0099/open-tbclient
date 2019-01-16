package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes2.dex */
public final class bt<T> implements d.b<T, T> {
    final int count;
    final long iMR;
    final rx.g scheduler;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bt(long j, TimeUnit timeUnit, rx.g gVar) {
        this.iMR = timeUnit.toMillis(j);
        this.scheduler = gVar;
        this.count = -1;
    }

    public bt(int i, long j, TimeUnit timeUnit, rx.g gVar) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("count could not be negative");
        }
        this.iMR = timeUnit.toMillis(j);
        this.scheduler = gVar;
        this.count = i;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final a aVar = new a(jVar, this.count, this.iMR, this.scheduler);
        jVar.add(aVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.bt.1
            @Override // rx.f
            public void request(long j) {
                aVar.dH(j);
            }
        });
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.f<Object, T> {
        final rx.j<? super T> actual;
        final int count;
        final long iMR;
        final rx.g scheduler;
        final AtomicLong requested = new AtomicLong();
        final ArrayDeque<Object> iIE = new ArrayDeque<>();
        final ArrayDeque<Long> iMU = new ArrayDeque<>();

        public a(rx.j<? super T> jVar, int i, long j, rx.g gVar) {
            this.actual = jVar;
            this.count = i;
            this.iMR = j;
            this.scheduler = gVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            if (this.count != 0) {
                long now = this.scheduler.now();
                if (this.iIE.size() == this.count) {
                    this.iIE.poll();
                    this.iMU.poll();
                }
                dO(now);
                this.iIE.offer(NotificationLite.aY(t));
                this.iMU.offer(Long.valueOf(now));
            }
        }

        protected void dO(long j) {
            long j2 = j - this.iMR;
            while (true) {
                Long peek = this.iMU.peek();
                if (peek != null && peek.longValue() < j2) {
                    this.iIE.poll();
                    this.iMU.poll();
                } else {
                    return;
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iIE.clear();
            this.iMU.clear();
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            dO(this.scheduler.now());
            this.iMU.clear();
            rx.internal.operators.a.a(this.requested, this.iIE, this.actual, this);
        }

        @Override // rx.functions.f
        public T call(Object obj) {
            return (T) NotificationLite.bb(obj);
        }

        void dH(long j) {
            rx.internal.operators.a.a(this.requested, j, this.iIE, this.actual, this);
        }
    }
}
