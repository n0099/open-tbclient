package kotlin.time;

import com.baidu.android.common.others.IStringUtil;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlin/time/TestClock;", "Lkotlin/time/AbstractLongClock;", "Lkotlin/time/Duration;", "duration", "", "overflow-LRDsOJo", "(D)V", "overflow", "plusAssign-LRDsOJo", "plusAssign", "", "read", "()J", "reading", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public final class TestClock extends AbstractLongClock {
    public long reading;

    public TestClock() {
        super(TimeUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m1596overflowLRDsOJo(double d2) {
        throw new IllegalStateException("TestClock will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m1588toStringimpl(d2) + IStringUtil.EXTENSION_SEPARATOR);
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m1597plusAssignLRDsOJo(double d2) {
        long j;
        double m1582toDoubleimpl = Duration.m1582toDoubleimpl(d2, getUnit());
        long j2 = (long) m1582toDoubleimpl;
        if (j2 != Long.MIN_VALUE && j2 != Long.MAX_VALUE) {
            long j3 = this.reading;
            j = j3 + j2;
            if ((j2 ^ j3) >= 0 && (j3 ^ j) < 0) {
                m1596overflowLRDsOJo(d2);
            }
        } else {
            double d3 = this.reading + m1582toDoubleimpl;
            if (d3 > Long.MAX_VALUE || d3 < Long.MIN_VALUE) {
                m1596overflowLRDsOJo(d2);
            }
            j = (long) d3;
        }
        this.reading = j;
    }

    @Override // kotlin.time.AbstractLongClock
    public long read() {
        return this.reading;
    }
}
