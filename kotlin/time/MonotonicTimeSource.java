package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "", "read", "()J", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes10.dex */
public final class MonotonicTimeSource extends AbstractLongTimeSource implements TimeSource {
    public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();

    public MonotonicTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public long read() {
        return System.nanoTime();
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
