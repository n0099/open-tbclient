package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/time/AdjustedClockMark;", "Lkotlin/time/ClockMark;", "Lkotlin/time/Duration;", "elapsedNow", "()D", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "plus", "adjustment", "D", "getAdjustment", "mark", "Lkotlin/time/ClockMark;", "getMark", "()Lkotlin/time/ClockMark;", "<init>", "(Lkotlin/time/ClockMark;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public final class AdjustedClockMark extends ClockMark {
    public final double adjustment;
    public final ClockMark mark;

    public AdjustedClockMark(ClockMark clockMark, double d2) {
        this.mark = clockMark;
        this.adjustment = d2;
    }

    @Override // kotlin.time.ClockMark
    public double elapsedNow() {
        return Duration.m1577minusLRDsOJo(this.mark.elapsedNow(), this.adjustment);
    }

    public final double getAdjustment() {
        return this.adjustment;
    }

    public final ClockMark getMark() {
        return this.mark;
    }

    @Override // kotlin.time.ClockMark
    /* renamed from: plus-LRDsOJo */
    public ClockMark mo1550plusLRDsOJo(double d2) {
        return new AdjustedClockMark(this.mark, Duration.m1578plusLRDsOJo(this.adjustment, d2), null);
    }

    public /* synthetic */ AdjustedClockMark(ClockMark clockMark, double d2, DefaultConstructorMarker defaultConstructorMarker) {
        this(clockMark, d2);
    }
}
