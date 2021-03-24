package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001:\u0001\u0010B\u0013\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\u00060\bj\u0002`\t8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractLongClock;", "Lkotlin/time/Clock;", "Lkotlin/time/ClockMark;", "markNow", "()Lkotlin/time/ClockMark;", "", "read", "()J", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "Ljava/util/concurrent/TimeUnit;", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "<init>", "(Ljava/util/concurrent/TimeUnit;)V", "LongClockMark", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public abstract class AbstractLongClock implements Clock {
    public final TimeUnit unit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlin/time/AbstractLongClock$LongClockMark;", "Lkotlin/time/ClockMark;", "Lkotlin/time/Duration;", "elapsedNow", "()D", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "plus", "Lkotlin/time/AbstractLongClock;", "clock", "Lkotlin/time/AbstractLongClock;", "offset", "D", "", "startedAt", "J", "<init>", "(JLkotlin/time/AbstractLongClock;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class LongClockMark extends ClockMark {
        public final AbstractLongClock clock;
        public final double offset;
        public final long startedAt;

        public LongClockMark(long j, AbstractLongClock abstractLongClock, double d2) {
            this.startedAt = j;
            this.clock = abstractLongClock;
            this.offset = d2;
        }

        @Override // kotlin.time.ClockMark
        public double elapsedNow() {
            return Duration.m1573minusLRDsOJo(DurationKt.toDuration(this.clock.read() - this.startedAt, this.clock.getUnit()), this.offset);
        }

        @Override // kotlin.time.ClockMark
        /* renamed from: plus-LRDsOJo */
        public ClockMark mo1546plusLRDsOJo(double d2) {
            return new LongClockMark(this.startedAt, this.clock, Duration.m1574plusLRDsOJo(this.offset, d2), null);
        }

        public /* synthetic */ LongClockMark(long j, AbstractLongClock abstractLongClock, double d2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongClock, d2);
        }
    }

    public AbstractLongClock(TimeUnit timeUnit) {
        this.unit = timeUnit;
    }

    public final TimeUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.Clock
    public ClockMark markNow() {
        return new LongClockMark(read(), this, Duration.Companion.getZERO(), null);
    }

    public abstract long read();
}
