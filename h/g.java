package h;

import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.SchedulerWhen;
/* loaded from: classes8.dex */
public abstract class g {

    /* loaded from: classes8.dex */
    public static abstract class a implements k {
        public long a() {
            return System.currentTimeMillis();
        }

        public abstract k b(h.n.a aVar);

        public abstract k c(h.n.a aVar, long j, TimeUnit timeUnit);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15L).longValue());
    }

    public abstract a createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends g & k> S when(h.n.f<d<d<b>>, b> fVar) {
        return new SchedulerWhen(fVar, this);
    }
}
