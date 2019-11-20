package rx;

import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.SchedulerWhen;
/* loaded from: classes2.dex */
public abstract class g {
    static final long kxH = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public abstract a createWorker();

    /* loaded from: classes2.dex */
    public static abstract class a implements k {
        public abstract k a(rx.functions.a aVar, long j, TimeUnit timeUnit);

        public abstract k c(rx.functions.a aVar);

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
