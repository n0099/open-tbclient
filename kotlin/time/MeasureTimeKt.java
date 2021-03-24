package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteHelper;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u000b\u001a;\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/Function0;", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/time/Duration;", "measureTime", "(Lkotlin/jvm/functions/Function0;)D", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/time/TimedValue;", "measureTimedValue", "(Lkotlin/Function0;)Lkotlin/time/TimedValue;", "Lkotlin/time/Clock;", "(Lkotlin/time/Clock;Lkotlin/jvm/functions/Function0;)D", "(Lkotlin/time/Clock;Lkotlin/Function0;)Lkotlin/time/TimedValue;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class MeasureTimeKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(Function0<Unit> function0) {
        ClockMark markNow = MonoClock.INSTANCE.markNow();
        function0.invoke();
        return markNow.elapsedNow();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> function0) {
        return new TimedValue<>(function0.invoke(), MonoClock.INSTANCE.markNow().elapsedNow(), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double measureTime(Clock clock, Function0<Unit> function0) {
        ClockMark markNow = clock.markNow();
        function0.invoke();
        return markNow.elapsedNow();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final <T> TimedValue<T> measureTimedValue(Clock clock, Function0<? extends T> function0) {
        return new TimedValue<>(function0.invoke(), clock.markNow().elapsedNow(), null);
    }
}
