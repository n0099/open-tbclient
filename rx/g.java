package rx;

import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.SchedulerWhen;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public abstract class g {
    static final long iFk = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public abstract a createWorker();

    /* loaded from: classes2.dex */
    public static abstract class a implements k {
        public abstract k a(rx.functions.a aVar);

        public abstract k a(rx.functions.a aVar, long j, TimeUnit timeUnit);

        public k a(final rx.functions.a aVar, long j, long j2, TimeUnit timeUnit) {
            final long nanos = timeUnit.toNanos(j2);
            final long nanos2 = TimeUnit.MILLISECONDS.toNanos(now());
            final long nanos3 = nanos2 + timeUnit.toNanos(j);
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            final SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
            sequentialSubscription.replace(a(new rx.functions.a() { // from class: rx.g.a.1
                long count;
                long iFl;
                long iFm;

                {
                    this.iFl = nanos2;
                    this.iFm = nanos3;
                }

                @Override // rx.functions.a
                public void call() {
                    long j3;
                    aVar.call();
                    if (!sequentialSubscription2.isUnsubscribed()) {
                        long nanos4 = TimeUnit.MILLISECONDS.toNanos(a.this.now());
                        if (g.iFk + nanos4 < this.iFl || nanos4 >= this.iFl + nanos + g.iFk) {
                            j3 = nanos + nanos4;
                            long j4 = nanos;
                            long j5 = this.count + 1;
                            this.count = j5;
                            this.iFm = j3 - (j4 * j5);
                        } else {
                            long j6 = this.iFm;
                            long j7 = this.count + 1;
                            this.count = j7;
                            j3 = j6 + (j7 * nanos);
                        }
                        this.iFl = nanos4;
                        sequentialSubscription2.replace(a.this.a(this, j3 - nanos4, TimeUnit.NANOSECONDS));
                    }
                }
            }, j, timeUnit));
            return sequentialSubscription2;
        }

        public long now() {
            return System.currentTimeMillis();
        }
    }

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends g & k> S when(rx.functions.f<d<d<b>>, b> fVar) {
        return new SchedulerWhen(fVar, this);
    }
}
