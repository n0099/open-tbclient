package kotlin.time;

import com.baidu.android.common.others.IStringUtil;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@ExperimentalTime
/* loaded from: classes8.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    public long reading;

    public TestTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m2068overflowLRDsOJo(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m2032toStringimpl(j) + IStringUtil.EXTENSION_SEPARATOR);
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m2069plusAssignLRDsOJo(long j) {
        long j2;
        long m2029toLongimpl = Duration.m2029toLongimpl(j, getUnit());
        if (m2029toLongimpl != Long.MIN_VALUE && m2029toLongimpl != Long.MAX_VALUE) {
            long j3 = this.reading;
            j2 = j3 + m2029toLongimpl;
            if ((m2029toLongimpl ^ j3) >= 0 && (j3 ^ j2) < 0) {
                m2068overflowLRDsOJo(j);
            }
        } else {
            double m2026toDoubleimpl = this.reading + Duration.m2026toDoubleimpl(j, getUnit());
            if (m2026toDoubleimpl > Long.MAX_VALUE || m2026toDoubleimpl < Long.MIN_VALUE) {
                m2068overflowLRDsOJo(j);
            }
            j2 = (long) m2026toDoubleimpl;
        }
        this.reading = j2;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public long read() {
        return this.reading;
    }
}
