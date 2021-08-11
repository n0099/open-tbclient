package kotlin.time;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a:\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u0004\u001a\u00020\u0003*\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u000b\u001a>\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/time/Duration;", "measureTime", "(Lkotlin/jvm/functions/Function0;)D", "T", "Lkotlin/time/TimedValue;", "measureTimedValue", "(Lkotlin/Function0;)Lkotlin/time/TimedValue;", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)D", "(Lkotlin/time/TimeSource;Lkotlin/Function0;)Lkotlin/time/TimedValue;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MeasureTimeKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TimeMark markNow = TimeSource.Monotonic.INSTANCE.markNow();
        block.invoke();
        return markNow.mo1903elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.invoke(), TimeSource.Monotonic.INSTANCE.markNow().mo1903elapsedNowUwyO8pc(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(TimeSource measureTime, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(measureTime, "$this$measureTime");
        Intrinsics.checkNotNullParameter(block, "block");
        TimeMark markNow = measureTime.markNow();
        block.invoke();
        return markNow.mo1903elapsedNowUwyO8pc();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(TimeSource measureTimedValue, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(measureTimedValue, "$this$measureTimedValue");
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.invoke(), measureTimedValue.markNow().mo1903elapsedNowUwyO8pc(), null);
    }
}
