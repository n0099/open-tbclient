package kotlin.time;

import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007*\\\b\u0007\u0010\u0019\"\u00020\b2\u00020\bB\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bB\u0002\b\fB<\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\"\b\u0010\u0012\u001e\b\u000bB\u001a\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\b\u0016\u0012\u0006\b\n0\u00178\u0018*\\\b\u0007\u0010\u001d\"\u00020\u00002\u00020\u0000B\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bB\u0002\b\fB<\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\"\b\u0010\u0012\u001e\b\u000bB\u001a\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u001b\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\n\b\u0016\u0012\u0006\b\n0\u00178\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlin/time/TimeMark;", "other", "", "compareTo", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)I", "Lkotlin/time/Duration;", "minus", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)D", "Lkotlin/time/TimeSource;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", "message", "Use TimeSource interface instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlin.time.TimeSource", "expression", "TimeSource", ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, "Lkotlin/DeprecationLevel;", "ERROR", "Clock", "Use TimeMark class instead.", "kotlin.time.TimeMark", "TimeMark", "ClockMark", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TimeSourceKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use TimeSource interface instead.", replaceWith = @ReplaceWith(expression = "TimeSource", imports = {"kotlin.time.TimeSource"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void Clock$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use TimeMark class instead.", replaceWith = @ReplaceWith(expression = "TimeMark", imports = {"kotlin.time.TimeMark"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void ClockMark$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    public static final int compareTo(TimeMark compareTo, TimeMark timeMark) {
        Intrinsics.checkNotNullParameter(compareTo, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    @ExperimentalTime
    public static final double minus(TimeMark minus, TimeMark timeMark) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        throw new Error("Operation is disallowed.");
    }
}
