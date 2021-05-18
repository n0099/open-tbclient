package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b'\u0018\u0000B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0004\u001a\u00020\u0001H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()D", "elapsedNow", "", "hasNotPassedNow", "()Z", "hasPassedNow", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "minus", "plus-LRDsOJo", "plus", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public abstract class TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    public abstract double mo1886elapsedNowUwyO8pc();

    public final boolean hasNotPassedNow() {
        return Duration.m1914isNegativeimpl(mo1886elapsedNowUwyO8pc());
    }

    public final boolean hasPassedNow() {
        return !Duration.m1914isNegativeimpl(mo1886elapsedNowUwyO8pc());
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public TimeMark m1943minusLRDsOJo(double d2) {
        return mo1887plusLRDsOJo(Duration.m1934unaryMinusUwyO8pc(d2));
    }

    /* renamed from: plus-LRDsOJo */
    public TimeMark mo1887plusLRDsOJo(double d2) {
        return new AdjustedTimeMark(this, d2, null);
    }
}
