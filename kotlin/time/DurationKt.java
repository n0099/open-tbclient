package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\"\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\f\u001a\u00020\u0001*\u00020\u00002\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\f\u001a\u00020\u0001*\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000e\u001a\"\u0010\f\u001a\u00020\u0001*\u00020\u000f2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0010\"\u001d\u0010\u0015\u001a\u00020\t8Â\u0002@\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"#\u0010\u001a\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"#\u0010\u001a\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u0016\u0010\u001b\"#\u0010\u001a\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u0016\u0010\u001d\"#\u0010!\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u0019\u001a\u0004\b\u001f\u0010\u0017\"#\u0010!\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u001c\u001a\u0004\b\u001f\u0010\u001b\"#\u0010!\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u001e\u001a\u0004\b\u001f\u0010\u001d\"#\u0010$\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u0019\u001a\u0004\b\"\u0010\u0017\"#\u0010$\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u001c\u001a\u0004\b\"\u0010\u001b\"#\u0010$\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001d\"#\u0010'\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b&\u0010\u0019\u001a\u0004\b%\u0010\u0017\"#\u0010'\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b&\u0010\u001c\u001a\u0004\b%\u0010\u001b\"#\u0010'\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b&\u0010\u001e\u001a\u0004\b%\u0010\u001d\"#\u0010*\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b)\u0010\u0019\u001a\u0004\b(\u0010\u0017\"#\u0010*\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b)\u0010\u001c\u001a\u0004\b(\u0010\u001b\"#\u0010*\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b)\u0010\u001e\u001a\u0004\b(\u0010\u001d\"#\u0010-\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b,\u0010\u0019\u001a\u0004\b+\u0010\u0017\"#\u0010-\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b,\u0010\u001c\u001a\u0004\b+\u0010\u001b\"#\u0010-\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b,\u0010\u001e\u001a\u0004\b+\u0010\u001d\"#\u00100\u001a\u00020\u0001*\u00020\u00008F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b/\u0010\u0019\u001a\u0004\b.\u0010\u0017\"#\u00100\u001a\u00020\u0001*\u00020\u00068F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b/\u0010\u001c\u001a\u0004\b.\u0010\u001b\"#\u00100\u001a\u00020\u0001*\u00020\u000f8F@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b/\u0010\u001e\u001a\u0004\b.\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"", "Lkotlin/time/Duration;", "duration", "times-kIfJnKk", "(DD)D", "times", "", "times-mvk6XK0", "(ID)D", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "toDuration", "(DLjava/util/concurrent/TimeUnit;)D", "(ILjava/util/concurrent/TimeUnit;)D", "", "(JLjava/util/concurrent/TimeUnit;)D", "getStorageUnit", "()Ljava/util/concurrent/TimeUnit;", "getStorageUnit$annotations", "()V", "storageUnit", "getDays", "(D)D", "getDays$annotations", "(D)V", "days", "(I)D", "(I)V", "(J)D", "(J)V", "getHours", "getHours$annotations", "hours", "getMicroseconds", "getMicroseconds$annotations", "microseconds", "getMilliseconds", "getMilliseconds$annotations", "milliseconds", "getMinutes", "getMinutes$annotations", "minutes", "getNanoseconds", "getNanoseconds$annotations", "nanoseconds", "getSeconds", "getSeconds$annotations", "seconds", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class DurationKt {
    public static final double getDays(int i2) {
        return toDuration(i2, TimeUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static final double getHours(int i2) {
        return toDuration(i2, TimeUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static final double getMicroseconds(int i2) {
        return toDuration(i2, TimeUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static final double getMilliseconds(int i2) {
        return toDuration(i2, TimeUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static final double getMinutes(int i2) {
        return toDuration(i2, TimeUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static final double getNanoseconds(int i2) {
        return toDuration(i2, TimeUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static final double getSeconds(int i2) {
        return toDuration(i2, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    public static final TimeUnit getStorageUnit() {
        return TimeUnit.NANOSECONDS;
    }

    public static /* synthetic */ void getStorageUnit$annotations() {
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: times-kIfJnKk  reason: not valid java name */
    public static final double m1953timeskIfJnKk(double d2, double d3) {
        return Duration.m1933timesUwyO8pc(d3, d2);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: times-mvk6XK0  reason: not valid java name */
    public static final double m1954timesmvk6XK0(int i2, double d2) {
        return Duration.m1934timesUwyO8pc(d2, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(int i2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return toDuration(i2, unit);
    }

    public static final double getDays(long j) {
        return toDuration(j, TimeUnit.DAYS);
    }

    public static final double getHours(long j) {
        return toDuration(j, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(long j) {
        return toDuration(j, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(long j) {
        return toDuration(j, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(long j) {
        return toDuration(j, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(long j) {
        return toDuration(j, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(long j) {
        return toDuration(j, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return toDuration(j, unit);
    }

    public static final double getDays(double d2) {
        return toDuration(d2, TimeUnit.DAYS);
    }

    public static final double getHours(double d2) {
        return toDuration(d2, TimeUnit.HOURS);
    }

    public static final double getMicroseconds(double d2) {
        return toDuration(d2, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(double d2) {
        return toDuration(d2, TimeUnit.MILLISECONDS);
    }

    public static final double getMinutes(double d2) {
        return toDuration(d2, TimeUnit.MINUTES);
    }

    public static final double getNanoseconds(double d2) {
        return toDuration(d2, TimeUnit.NANOSECONDS);
    }

    public static final double getSeconds(double d2) {
        return toDuration(d2, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final double toDuration(double d2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return Duration.m1907constructorimpl(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, unit, TimeUnit.NANOSECONDS));
    }
}
