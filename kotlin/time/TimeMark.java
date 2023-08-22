package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lkotlin/time/TimeMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalTime
/* loaded from: classes2.dex */
public abstract class TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    public abstract long mo2139elapsedNowUwyO8pc();

    public final boolean hasNotPassedNow() {
        return Duration.m2179isNegativeimpl(mo2139elapsedNowUwyO8pc());
    }

    public final boolean hasPassedNow() {
        return !Duration.m2179isNegativeimpl(mo2139elapsedNowUwyO8pc());
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public TimeMark m2275minusLRDsOJo(long j) {
        return mo2140plusLRDsOJo(Duration.m2198unaryMinusUwyO8pc(j));
    }

    /* renamed from: plus-LRDsOJo */
    public TimeMark mo2140plusLRDsOJo(long j) {
        return new AdjustedTimeMark(this, j, null);
    }
}
