package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\\\b\u0007\u0010\u0011\"\u00020\u00002\u00020\u0000B\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B<\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010*\\\b\u0007\u0010\u0016\"\u00020\u00122\u00020\u0012B\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B<\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u0014\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010*\\\b\u0007\u0010\u001b\"\u00020\u00172\u00020\u0017B\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B<\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0018\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u0019\u0012\b\b\f\u0012\u0004\b\b(\u001a\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010*\\\b\u0007\u0010 \"\u00020\u001c2\u00020\u001cB\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003B\u0002\b\u0004B<\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001d\u0012\"\b\b\u0012\u001e\b\u000bB\u001a\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\b(\u001e\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010¨\u0006!"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", "message", "Use AbstractDoubleTimeSource instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlin.time.AbstractDoubleTimeSource", "expression", "AbstractDoubleTimeSource", "level", "Lkotlin/DeprecationLevel;", "ERROR", "AbstractDoubleClock", "Lkotlin/time/AbstractLongTimeSource;", "Use AbstractLongTimeSource instead.", "kotlin.time.AbstractLongTimeSource", "AbstractLongTimeSource", "AbstractLongClock", "Lkotlin/time/TimeSource$Monotonic;", "Use TimeSource.Monotonic instead.", "kotlin.time.TimeSource", "TimeSource.Monotonic", "MonoClock", "Lkotlin/time/TestTimeSource;", "Use TestTimeSource instead.", "kotlin.time.TestTimeSource", "TestTimeSource", "TestClock", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class TimeSourcesKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use AbstractDoubleTimeSource instead.", replaceWith = @ReplaceWith(expression = "AbstractDoubleTimeSource", imports = {"kotlin.time.AbstractDoubleTimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void AbstractDoubleClock$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use AbstractLongTimeSource instead.", replaceWith = @ReplaceWith(expression = "AbstractLongTimeSource", imports = {"kotlin.time.AbstractLongTimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void AbstractLongClock$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use TimeSource.Monotonic instead.", replaceWith = @ReplaceWith(expression = "TimeSource.Monotonic", imports = {"kotlin.time.TimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void MonoClock$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use TestTimeSource instead.", replaceWith = @ReplaceWith(expression = "TestTimeSource", imports = {"kotlin.time.TestTimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void TestClock$annotations() {
    }
}
