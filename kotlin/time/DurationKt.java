package kotlin.time;

import com.google.android.material.badge.BadgeDrawable;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0003ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a \u0010D\u001a\u00020\u0007*\u00020\b2\n\u0010E\u001a\u00060Fj\u0002`GH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a \u0010D\u001a\u00020\u0007*\u00020\u00052\n\u0010E\u001a\u00060Fj\u0002`GH\u0007ø\u0001\u0000¢\u0006\u0002\u0010I\u001a \u0010D\u001a\u00020\u0007*\u00020\u00012\n\u0010E\u001a\u00060Fj\u0002`GH\u0007ø\u0001\u0000¢\u0006\u0002\u0010J\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)J", "(ILjava/util/concurrent/TimeUnit;)J", "(JLjava/util/concurrent/TimeUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.unaryMinus-UwyO8pc(long):long] */
    public static final /* synthetic */ long access$durationOf(long j2, int i2) {
        return durationOf(j2, i2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.<clinit>():void, kotlin.time.Duration.addValuesMixedRanges-UwyO8pc(long, long, long):long, kotlin.time.Duration.div-UwyO8pc(long, int):long, kotlin.time.Duration.times-UwyO8pc(long, int):long] */
    public static final /* synthetic */ long access$durationOfMillis(long j2) {
        return durationOfMillis(j2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.plus-LRDsOJo(long, long):long] */
    public static final /* synthetic */ long access$durationOfMillisNormalized(long j2) {
        return durationOfMillisNormalized(j2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.addValuesMixedRanges-UwyO8pc(long, long, long):long, kotlin.time.Duration.div-UwyO8pc(long, int):long, kotlin.time.Duration.times-UwyO8pc(long, int):long] */
    public static final /* synthetic */ long access$durationOfNanos(long j2) {
        return durationOfNanos(j2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.plus-LRDsOJo(long, long):long, kotlin.time.Duration.times-UwyO8pc(long, int):long] */
    public static final /* synthetic */ long access$durationOfNanosNormalized(long j2) {
        return durationOfNanosNormalized(j2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.addValuesMixedRanges-UwyO8pc(long, long, long):long, kotlin.time.Duration.div-UwyO8pc(long, int):long, kotlin.time.Duration.getInWholeNanoseconds-impl(long):long, kotlin.time.Duration.getNanosecondsComponent-impl(long):int, kotlin.time.Duration.times-UwyO8pc(long, int):long] */
    public static final /* synthetic */ long access$millisToNanos(long j2) {
        return millisToNanos(j2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.addValuesMixedRanges-UwyO8pc(long, long, long):long, kotlin.time.Duration.times-UwyO8pc(long, int):long] */
    public static final /* synthetic */ long access$nanosToMillis(long j2) {
        return nanosToMillis(j2);
    }

    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.Companion.parse-UwyO8pc(java.lang.String):long, kotlin.time.Duration.Companion.parseIsoString-UwyO8pc(java.lang.String):long, kotlin.time.Duration.Companion.parseIsoStringOrNull-FghU774(java.lang.String):kotlin.time.Duration, kotlin.time.Duration.Companion.parseOrNull-FghU774(java.lang.String):kotlin.time.Duration] */
    public static final /* synthetic */ long access$parseDuration(String str, boolean z) {
        return parseDuration(str, z);
    }

    @ExperimentalTime
    public static final long durationOf(long j2, int i2) {
        return Duration.m1999constructorimpl((j2 << 1) + i2);
    }

    @ExperimentalTime
    public static final long durationOfMillis(long j2) {
        return Duration.m1999constructorimpl((j2 << 1) + 1);
    }

    @ExperimentalTime
    public static final long durationOfMillisNormalized(long j2) {
        if (-4611686018426L <= j2 && MAX_NANOS_IN_MILLIS >= j2) {
            return durationOfNanos(millisToNanos(j2));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(j2, -4611686018427387903L, 4611686018427387903L));
    }

    @ExperimentalTime
    public static final long durationOfNanos(long j2) {
        return Duration.m1999constructorimpl(j2 << 1);
    }

    @ExperimentalTime
    public static final long durationOfNanosNormalized(long j2) {
        if (-4611686018426999999L <= j2 && MAX_NANOS >= j2) {
            return durationOfNanos(j2);
        }
        return durationOfMillis(nanosToMillis(j2));
    }

    public static final long getDays(int i2) {
        return toDuration(i2, TimeUnit.DAYS);
    }

    @Deprecated(message = "Use Duration.days() function instead.", replaceWith = @ReplaceWith(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.days() function instead.", replaceWith = @ReplaceWith(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.days() function instead.", replaceWith = @ReplaceWith(expression = "Duration.days(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j2) {
    }

    public static final long getHours(int i2) {
        return toDuration(i2, TimeUnit.HOURS);
    }

    @Deprecated(message = "Use Duration.hours() function instead.", replaceWith = @ReplaceWith(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.hours() function instead.", replaceWith = @ReplaceWith(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.hours() function instead.", replaceWith = @ReplaceWith(expression = "Duration.hours(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j2) {
    }

    public static final long getMicroseconds(int i2) {
        return toDuration(i2, TimeUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use Duration.microseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.microseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.microseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.microseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j2) {
    }

    public static final long getMilliseconds(int i2) {
        return toDuration(i2, TimeUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use Duration.milliseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.milliseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.milliseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.milliseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j2) {
    }

    public static final long getMinutes(int i2) {
        return toDuration(i2, TimeUnit.MINUTES);
    }

    @Deprecated(message = "Use Duration.minutes() function instead.", replaceWith = @ReplaceWith(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.minutes() function instead.", replaceWith = @ReplaceWith(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.minutes() function instead.", replaceWith = @ReplaceWith(expression = "Duration.minutes(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j2) {
    }

    public static final long getNanoseconds(int i2) {
        return toDuration(i2, TimeUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use Duration.nanoseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.nanoseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.nanoseconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.nanoseconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j2) {
    }

    public static final long getSeconds(int i2) {
        return toDuration(i2, TimeUnit.SECONDS);
    }

    @Deprecated(message = "Use Duration.seconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d2) {
    }

    @Deprecated(message = "Use Duration.seconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i2) {
    }

    @Deprecated(message = "Use Duration.seconds() function instead.", replaceWith = @ReplaceWith(expression = "Duration.seconds(this)", imports = {"kotlin.time.Duration"}))
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j2) {
    }

    public static final long millisToNanos(long j2) {
        return j2 * 1000000;
    }

    public static final long nanosToMillis(long j2) {
        return j2 / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:266:0x0094 A[LOOP:1: B:254:0x006a->B:266:0x0094, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x00a5 A[EDGE_INSN: B:417:0x00a5->B:268:0x00a5 ?: BREAK  , SYNTHETIC] */
    @ExperimentalTime
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long parseDuration(String str, boolean z) {
        boolean z2;
        int i2;
        String str2;
        long m2035plusLRDsOJo;
        int i3;
        boolean z3;
        long m2035plusLRDsOJo2;
        boolean z4;
        String str3 = str;
        int length = str.length();
        if (length != 0) {
            long m2059getZEROUwyO8pc = Duration.Companion.m2059getZEROUwyO8pc();
            char charAt = str3.charAt(0);
            int i4 = (charAt == '+' || charAt == '-') ? 1 : 0;
            boolean z5 = i4 > 0;
            boolean z6 = z5 && StringsKt__StringsKt.startsWith$default((CharSequence) str3, (char) SignatureImpl.SEP, false, 2, (Object) null);
            if (length > i4) {
                char c2 = '0';
                char c3 = '9';
                if (str3.charAt(i4) == 'P') {
                    int i5 = i4 + 1;
                    if (i5 == length) {
                        throw new IllegalArgumentException();
                    }
                    boolean z7 = false;
                    TimeUnit timeUnit = null;
                    while (i5 < length) {
                        if (str3.charAt(i5) != 'T') {
                            int i6 = i5;
                            while (true) {
                                if (i6 >= str.length()) {
                                    i3 = length;
                                    z3 = z6;
                                    break;
                                }
                                char charAt2 = str3.charAt(i6);
                                if (c2 > charAt2 || c3 < charAt2) {
                                    i3 = length;
                                    z3 = z6;
                                    if (!StringsKt__StringsKt.contains$default((CharSequence) "+-.", charAt2, false, 2, (Object) null)) {
                                        z4 = false;
                                        if (z4) {
                                            break;
                                        }
                                        i6++;
                                        z6 = z3;
                                        length = i3;
                                        c3 = '9';
                                        c2 = '0';
                                    }
                                } else {
                                    i3 = length;
                                    z3 = z6;
                                }
                                z4 = true;
                                if (z4) {
                                }
                            }
                            if (str3 != null) {
                                String substring = str3.substring(i5, i6);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (!(substring.length() == 0)) {
                                    int length2 = i5 + substring.length();
                                    if (length2 >= 0 && length2 <= StringsKt__StringsKt.getLastIndex(str)) {
                                        char charAt3 = str3.charAt(length2);
                                        i5 = length2 + 1;
                                        TimeUnit durationUnitByIsoChar = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(charAt3, z7);
                                        if (timeUnit != null && timeUnit.compareTo(durationUnitByIsoChar) <= 0) {
                                            throw new IllegalArgumentException("Unexpected order of duration components");
                                        }
                                        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) substring, '.', 0, false, 6, (Object) null);
                                        if (durationUnitByIsoChar != TimeUnit.SECONDS || indexOf$default <= 0) {
                                            m2035plusLRDsOJo2 = Duration.m2035plusLRDsOJo(m2059getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring), durationUnitByIsoChar));
                                        } else if (substring != null) {
                                            String substring2 = substring.substring(0, indexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                            long m2035plusLRDsOJo3 = Duration.m2035plusLRDsOJo(m2059getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring2), durationUnitByIsoChar));
                                            if (substring == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                            }
                                            String substring3 = substring.substring(indexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.String).substring(startIndex)");
                                            m2035plusLRDsOJo2 = Duration.m2035plusLRDsOJo(m2035plusLRDsOJo3, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        m2059getZEROUwyO8pc = m2035plusLRDsOJo2;
                                        str3 = str;
                                        timeUnit = durationUnitByIsoChar;
                                        z6 = z3;
                                        length = i3;
                                        c3 = '9';
                                        c2 = '0';
                                    } else {
                                        throw new IllegalArgumentException("Missing unit for value " + substring);
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else if (z7 || (i5 = i5 + 1) == length) {
                            throw new IllegalArgumentException();
                        } else {
                            z7 = true;
                        }
                    }
                    z2 = z6;
                } else {
                    z2 = z6;
                    if (!z) {
                        String str4 = "(this as java.lang.String).substring(startIndex)";
                        if (StringsKt__StringsJVMKt.regionMatches(str, i4, "Infinity", 0, Math.max(length - i4, 8), true)) {
                            m2059getZEROUwyO8pc = Duration.Companion.m2057getINFINITEUwyO8pc();
                        } else {
                            boolean z8 = !z5;
                            if (z5 && str.charAt(i4) == '(' && StringsKt___StringsKt.last(str) == ')') {
                                i4++;
                                i2 = length - 1;
                                if (i4 == i2) {
                                    throw new IllegalArgumentException("No components");
                                }
                                z8 = true;
                            } else {
                                i2 = length;
                            }
                            boolean z9 = false;
                            TimeUnit timeUnit2 = null;
                            while (i4 < i2) {
                                if (z9 && z8) {
                                    while (i4 < str.length()) {
                                        if (!(str.charAt(i4) == ' ')) {
                                            break;
                                        }
                                        i4++;
                                    }
                                }
                                int i7 = i4;
                                while (i7 < str.length()) {
                                    char charAt4 = str.charAt(i7);
                                    if (!(('0' <= charAt4 && '9' >= charAt4) || charAt4 == '.')) {
                                        break;
                                    }
                                    i7++;
                                }
                                if (str != null) {
                                    String substring4 = str.substring(i4, i7);
                                    Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (!(substring4.length() == 0)) {
                                        int length3 = i4 + substring4.length();
                                        int i8 = length3;
                                        while (i8 < str.length()) {
                                            char charAt5 = str.charAt(i8);
                                            if (!('a' <= charAt5 && 'z' >= charAt5)) {
                                                break;
                                            }
                                            i8++;
                                        }
                                        if (str != null) {
                                            String substring5 = str.substring(length3, i8);
                                            Intrinsics.checkNotNullExpressionValue(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                            i4 = length3 + substring5.length();
                                            TimeUnit durationUnitByShortName = DurationUnitKt__DurationUnitKt.durationUnitByShortName(substring5);
                                            if (timeUnit2 != null && timeUnit2.compareTo(durationUnitByShortName) <= 0) {
                                                throw new IllegalArgumentException("Unexpected order of duration components");
                                            }
                                            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) substring4, '.', 0, false, 6, (Object) null);
                                            if (indexOf$default2 <= 0) {
                                                str2 = str4;
                                                m2035plusLRDsOJo = Duration.m2035plusLRDsOJo(m2059getZEROUwyO8pc, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                                            } else if (substring4 != null) {
                                                String substring6 = substring4.substring(0, indexOf$default2);
                                                Intrinsics.checkNotNullExpressionValue(substring6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                str2 = str4;
                                                long m2035plusLRDsOJo4 = Duration.m2035plusLRDsOJo(m2059getZEROUwyO8pc, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                                                if (substring4 != null) {
                                                    String substring7 = substring4.substring(indexOf$default2);
                                                    Intrinsics.checkNotNullExpressionValue(substring7, str2);
                                                    m2035plusLRDsOJo = Duration.m2035plusLRDsOJo(m2035plusLRDsOJo4, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                                                    if (i4 < i2) {
                                                        throw new IllegalArgumentException("Fractional component must be last");
                                                    }
                                                } else {
                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                }
                                            } else {
                                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                            }
                                            m2059getZEROUwyO8pc = m2035plusLRDsOJo;
                                            timeUnit2 = durationUnitByShortName;
                                            str4 = str2;
                                            z9 = true;
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                    } else {
                                        throw new IllegalArgumentException();
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                return z2 ? Duration.m2051unaryMinusUwyO8pc(m2059getZEROUwyO8pc) : m2059getZEROUwyO8pc;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    public static final long parseOverLongIsoComponent(String str) {
        boolean z;
        boolean z2;
        int length = str.length();
        int i2 = (length <= 0 || !StringsKt__StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i2 > 16) {
            IntRange intRange = new IntRange(i2, StringsKt__StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator<Integer> it = intRange.iterator();
                while (it.hasNext()) {
                    char charAt = str.charAt(((IntIterator) it).nextInt());
                    if ('0' <= charAt && '9' >= charAt) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null)) {
            str = StringsKt___StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final int skipWhile(String str, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 < str.length() && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        return i2;
    }

    public static final String substringWhile(String str, int i2, Function1<? super Character, Boolean> function1) {
        int i3 = i2;
        while (i3 < str.length() && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        if (str != null) {
            String substring = str.substring(i2, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: times-kIfJnKk */
    public static final long m2082timeskIfJnKk(double d2, long j2) {
        return Duration.m2036timesUwyO8pc(j2, d2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: times-mvk6XK0 */
    public static final long m2083timesmvk6XK0(int i2, long j2) {
        return Duration.m2037timesUwyO8pc(j2, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long toDuration(int i2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(TimeUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i2, unit, TimeUnit.NANOSECONDS));
        }
        return toDuration(i2, unit);
    }

    public static final long getDays(long j2) {
        return toDuration(j2, TimeUnit.DAYS);
    }

    public static final long getHours(long j2) {
        return toDuration(j2, TimeUnit.HOURS);
    }

    public static final long getMicroseconds(long j2) {
        return toDuration(j2, TimeUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(long j2) {
        return toDuration(j2, TimeUnit.MILLISECONDS);
    }

    public static final long getMinutes(long j2) {
        return toDuration(j2, TimeUnit.MINUTES);
    }

    public static final long getNanoseconds(long j2) {
        return toDuration(j2, TimeUnit.NANOSECONDS);
    }

    public static final long getSeconds(long j2) {
        return toDuration(j2, TimeUnit.SECONDS);
    }

    public static final long getDays(double d2) {
        return toDuration(d2, TimeUnit.DAYS);
    }

    public static final long getHours(double d2) {
        return toDuration(d2, TimeUnit.HOURS);
    }

    public static final long getMicroseconds(double d2) {
        return toDuration(d2, TimeUnit.MICROSECONDS);
    }

    public static final long getMilliseconds(double d2) {
        return toDuration(d2, TimeUnit.MILLISECONDS);
    }

    public static final long getMinutes(double d2) {
        return toDuration(d2, TimeUnit.MINUTES);
    }

    public static final long getNanoseconds(double d2) {
        return toDuration(d2, TimeUnit.NANOSECONDS);
    }

    public static final long getSeconds(double d2) {
        return toDuration(d2, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long toDuration(long j2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, TimeUnit.NANOSECONDS, unit);
        if ((-convertDurationUnitOverflow) <= j2 && convertDurationUnitOverflow >= j2) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j2, unit, TimeUnit.NANOSECONDS));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j2, unit, TimeUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final long toDuration(double d2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, unit, TimeUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = MathKt__MathJVMKt.roundToLong(convertDurationUnit);
            if (-4611686018426999999L <= roundToLong && MAX_NANOS >= roundToLong) {
                return durationOfNanos(roundToLong);
            }
            return durationOfMillisNormalized(MathKt__MathJVMKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, unit, TimeUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }
}
