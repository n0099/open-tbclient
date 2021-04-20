package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001:\u0001\u0010B\u0013\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\u00060\bj\u0002`\t8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractDoubleClock;", "Lkotlin/time/Clock;", "Lkotlin/time/ClockMark;", "markNow", "()Lkotlin/time/ClockMark;", "", "read", "()D", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "Ljava/util/concurrent/TimeUnit;", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "<init>", "(Ljava/util/concurrent/TimeUnit;)V", "DoubleClockMark", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public abstract class AbstractDoubleClock implements Clock {
    public final TimeUnit unit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/time/AbstractDoubleClock$DoubleClockMark;", "Lkotlin/time/ClockMark;", "Lkotlin/time/Duration;", "elapsedNow", "()D", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "plus", "Lkotlin/time/AbstractDoubleClock;", "clock", "Lkotlin/time/AbstractDoubleClock;", "offset", "D", "", "startedAt", "<init>", "(DLkotlin/time/AbstractDoubleClock;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class DoubleClockMark extends ClockMark {
        public final AbstractDoubleClock clock;
        public final double offset;
        public final double startedAt;

        public DoubleClockMark(double d2, AbstractDoubleClock abstractDoubleClock, double d3) {
            this.startedAt = d2;
            this.clock = abstractDoubleClock;
            this.offset = d3;
        }

        @Override // kotlin.time.ClockMark
        public double elapsedNow() {
            return Duration.m1577minusLRDsOJo(DurationKt.toDuration(this.clock.read() - this.startedAt, this.clock.getUnit()), this.offset);
        }

        @Override // kotlin.time.ClockMark
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public ClockMark mo1550plusLRDsOJo(double d2) {
            return new DoubleClockMark(this.startedAt, this.clock, Duration.m1578plusLRDsOJo(this.offset, d2), null);
        }

        public /* synthetic */ DoubleClockMark(double d2, AbstractDoubleClock abstractDoubleClock, double d3, DefaultConstructorMarker defaultConstructorMarker) {
            this(d2, abstractDoubleClock, d3);
        }
    }

    public AbstractDoubleClock(TimeUnit timeUnit) {
        this.unit = timeUnit;
    }

    public final TimeUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.Clock
    public ClockMark markNow() {
        return new DoubleClockMark(read(), this, Duration.Companion.getZERO(), null);
    }

    public abstract double read();
}
