package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u0001:\u0001\u0010B\u0013\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\u00060\bj\u0002`\t8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "Lkotlin/time/TimeMark;", "markNow", "()Lkotlin/time/TimeMark;", "", "read", "()J", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "Ljava/util/concurrent/TimeUnit;", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "<init>", "(Ljava/util/concurrent/TimeUnit;)V", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes8.dex */
public abstract class AbstractLongTimeSource implements TimeSource {
    public final TimeUnit unit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()D", "elapsedNow", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "offset", "D", "", "startedAt", "J", "Lkotlin/time/AbstractLongTimeSource;", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class LongTimeMark extends TimeMark {
        public final double offset;
        public final long startedAt;
        public final AbstractLongTimeSource timeSource;

        public LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, double d2) {
            this.startedAt = j;
            this.timeSource = abstractLongTimeSource;
            this.offset = d2;
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public double mo1886elapsedNowUwyO8pc() {
            return Duration.m1916minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public TimeMark mo1887plusLRDsOJo(double d2) {
            return new LongTimeMark(this.startedAt, this.timeSource, Duration.m1917plusLRDsOJo(this.offset, d2), null);
        }

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, double d2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, d2);
        }
    }

    public AbstractLongTimeSource(TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }

    public final TimeUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource
    public TimeMark markNow() {
        return new LongTimeMark(read(), this, Duration.Companion.m1938getZEROUwyO8pc(), null);
    }

    public abstract long read();
}
