package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()D", "elapsedNow", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "adjustment", "D", "getAdjustment-UwyO8pc", "mark", "Lkotlin/time/TimeMark;", "getMark", "()Lkotlin/time/TimeMark;", "<init>", "(Lkotlin/time/TimeMark;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes2.dex */
public final class AdjustedTimeMark extends TimeMark {
    public final double adjustment;
    public final TimeMark mark;

    public AdjustedTimeMark(TimeMark timeMark, double d2) {
        this.mark = timeMark;
        this.adjustment = d2;
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public double mo1903elapsedNowUwyO8pc() {
        return Duration.m1933minusLRDsOJo(this.mark.mo1903elapsedNowUwyO8pc(), this.adjustment);
    }

    /* renamed from: getAdjustment-UwyO8pc  reason: not valid java name */
    public final double m1905getAdjustmentUwyO8pc() {
        return this.adjustment;
    }

    public final TimeMark getMark() {
        return this.mark;
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: plus-LRDsOJo */
    public TimeMark mo1904plusLRDsOJo(double d2) {
        return new AdjustedTimeMark(this.mark, Duration.m1934plusLRDsOJo(this.adjustment, d2), null);
    }

    public /* synthetic */ AdjustedTimeMark(TimeMark timeMark, double d2, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, d2);
    }
}
