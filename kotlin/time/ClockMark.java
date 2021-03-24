package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b'\u0018\u0000B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0002\u001a\u00020\u0001H&ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/time/ClockMark;", "Lkotlin/time/Duration;", "elapsedNow", "()D", "", "hasNotPassedNow", "()Z", "hasPassedNow", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "minus", "plus-LRDsOJo", "plus", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public abstract class ClockMark {
    public abstract double elapsedNow();

    public final boolean hasNotPassedNow() {
        return Duration.m1571isNegativeimpl(elapsedNow());
    }

    public final boolean hasPassedNow() {
        return !Duration.m1571isNegativeimpl(elapsedNow());
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public ClockMark m1547minusLRDsOJo(double d2) {
        return mo1546plusLRDsOJo(Duration.m1591unaryMinusimpl(d2));
    }

    /* renamed from: plus-LRDsOJo */
    public ClockMark mo1546plusLRDsOJo(double d2) {
        return new AdjustedClockMark(this, d2, null);
    }
}
