package kotlin.concurrent;

import com.yy.gslbsdk.db.DelayTB;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u001aT\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aV\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0011\u001a!\u0010\u0012\u001a\u00020\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aT\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000f\u001aV\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u001a.\u0010\u0014\u001a\u00020\t2\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a:\u0010\u0017\u001a\u00020\t*\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aB\u0010\u0017\u001a\u00020\t*\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0019\u001a:\u0010\u0017\u001a\u00020\t*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u001b\u001aB\u0010\u0017\u001a\u00020\t*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u001c\u001aB\u0010\u001d\u001a\u00020\t*\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019\u001aB\u0010\u001d\u001a\u00020\t*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0019\b\u0004\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"", "name", "", "daemon", "Ljava/util/Date;", "startAt", "", "period", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "action", "Ljava/util/Timer;", "fixedRateTimer", "(Ljava/lang/String;ZLjava/util/Date;JLkotlin/Function1;)Ljava/util/Timer;", "initialDelay", "(Ljava/lang/String;ZJJLkotlin/Function1;)Ljava/util/Timer;", "timer", "(Ljava/lang/String;Z)Ljava/util/Timer;", "timerTask", "(Lkotlin/Function1;)Ljava/util/TimerTask;", "time", "schedule", "(Ljava/util/Timer;Ljava/util/Date;Lkotlin/Function1;)Ljava/util/TimerTask;", "(Ljava/util/Timer;Ljava/util/Date;JLkotlin/Function1;)Ljava/util/TimerTask;", DelayTB.DELAY, "(Ljava/util/Timer;JLkotlin/Function1;)Ljava/util/TimerTask;", "(Ljava/util/Timer;JJLkotlin/Function1;)Ljava/util/TimerTask;", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "TimersKt")
/* loaded from: classes9.dex */
public final class TimersKt {
    @InlineOnly
    public static final Timer fixedRateTimer(String str, boolean z, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), j, j2);
        return timer;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, long j, long j2, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), j, j2);
        return timer;
    }

    @InlineOnly
    public static final TimerTask schedule(Timer timer, long j, Function1<? super TimerTask, Unit> function1) {
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, j);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    public static final TimerTask scheduleAtFixedRate(Timer timer, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.scheduleAtFixedRate(timersKt$timerTask$1, j, j2);
        return timersKt$timerTask$1;
    }

    @PublishedApi
    public static final Timer timer(String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    public static /* synthetic */ Timer timer$default(String str, boolean z, long j, long j2, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        Timer timer = timer(str, z);
        timer.schedule(new TimersKt$timerTask$1(function1), j, j2);
        return timer;
    }

    @InlineOnly
    public static final TimerTask timerTask(Function1<? super TimerTask, Unit> function1) {
        return new TimersKt$timerTask$1(function1);
    }

    @InlineOnly
    public static final Timer timer(String str, boolean z, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        Timer timer = timer(str, z);
        timer.schedule(new TimersKt$timerTask$1(function1), j, j2);
        return timer;
    }

    @InlineOnly
    public static final Timer fixedRateTimer(String str, boolean z, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), date, j);
        return timer;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, Date date, long j, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), date, j);
        return timer;
    }

    @InlineOnly
    public static final TimerTask schedule(Timer timer, Date date, Function1<? super TimerTask, Unit> function1) {
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, date);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    public static final TimerTask scheduleAtFixedRate(Timer timer, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.scheduleAtFixedRate(timersKt$timerTask$1, date, j);
        return timersKt$timerTask$1;
    }

    public static /* synthetic */ Timer timer$default(String str, boolean z, Date date, long j, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Timer timer = timer(str, z);
        timer.schedule(new TimersKt$timerTask$1(function1), date, j);
        return timer;
    }

    @InlineOnly
    public static final Timer timer(String str, boolean z, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        Timer timer = timer(str, z);
        timer.schedule(new TimersKt$timerTask$1(function1), date, j);
        return timer;
    }

    @InlineOnly
    public static final TimerTask schedule(Timer timer, long j, long j2, Function1<? super TimerTask, Unit> function1) {
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, j, j2);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    public static final TimerTask schedule(Timer timer, Date date, long j, Function1<? super TimerTask, Unit> function1) {
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, date, j);
        return timersKt$timerTask$1;
    }
}
