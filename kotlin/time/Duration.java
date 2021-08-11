package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b4\b\u0087@\u0018\u0000 v2\u00020\u0001:\u0001vB\u0014\b\u0000\u0012\u0006\u0010!\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bu\u0010TJ\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\fJ\u001b\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u0015J\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\nJ\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\nJ\u0017\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u001e\u0010%\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\nJ\u001e\u0010%\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\fJ\u009d\u0001\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2u\u0010/\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u00000'H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00101J\u0088\u0001\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2`\u0010/\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000003H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00104Js\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000005H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00106J^\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&26\u0010/\u001a2\u0012\u0013\u0012\u001108¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000007H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b0\u00109J\u0019\u0010?\u001a\u00020\u00072\n\u0010<\u001a\u00060:j\u0002`;¢\u0006\u0004\b=\u0010>J\u0019\u0010B\u001a\u00020\u00032\n\u0010<\u001a\u00060:j\u0002`;¢\u0006\u0004\b@\u0010AJ\r\u0010F\u001a\u00020C¢\u0006\u0004\bD\u0010EJ\u0019\u0010I\u001a\u0002082\n\u0010<\u001a\u00060:j\u0002`;¢\u0006\u0004\bG\u0010HJ\r\u0010L\u001a\u000208¢\u0006\u0004\bJ\u0010KJ\r\u0010N\u001a\u000208¢\u0006\u0004\bM\u0010KJ\u000f\u0010P\u001a\u00020CH\u0016¢\u0006\u0004\bO\u0010EJ#\u0010P\u001a\u00020C2\n\u0010<\u001a\u00060:j\u0002`;2\b\b\u0002\u0010Q\u001a\u00020\u0003¢\u0006\u0004\bO\u0010RJ\u0016\u0010U\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010TR\u0019\u0010W\u001a\u00020\u00008F@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bV\u0010TR\u001c\u0010\\\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR\u0013\u0010^\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b]\u0010TR\u0013\u0010`\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b_\u0010TR\u0013\u0010b\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\ba\u0010TR\u0013\u0010d\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bc\u0010TR\u0013\u0010f\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\be\u0010TR\u0013\u0010h\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bg\u0010TR\u0013\u0010j\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bi\u0010TR\u001c\u0010m\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bl\u0010[\u001a\u0004\bk\u0010YR\u001c\u0010p\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bo\u0010[\u001a\u0004\bn\u0010YR\u001c\u0010s\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\br\u0010[\u001a\u0004\bq\u0010YR\u0016\u0010!\u001a\u00020\u00078\u0000@\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b!\u0010tø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006w"}, d2 = {"Lkotlin/time/Duration;", "Ljava/lang/Comparable;", "other", "", "compareTo-LRDsOJo", "(DD)I", "compareTo", "", "scale", "div-UwyO8pc", "(DD)D", "div", "(DI)D", "div-LRDsOJo", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "isFinite-impl", "(D)Z", "isFinite", "isInfinite-impl", "isInfinite", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "minus-LRDsOJo", "minus", "plus-LRDsOJo", "plus", "value", "precision-impl", "precision", "times-UwyO8pc", "times", "T", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toDouble", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toInt", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toIsoString", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLong", "toLongMilliseconds-impl", "(D)J", "toLongMilliseconds", "toLongNanoseconds-impl", "toLongNanoseconds", "toString-impl", "toString", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus-UwyO8pc", "(D)D", "unaryMinus", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "(D)I", "getHoursComponent$annotations", "()V", "hoursComponent", "getInDays-impl", "inDays", "getInHours-impl", "inHours", "getInMicroseconds-impl", "inMicroseconds", "getInMilliseconds-impl", "inMilliseconds", "getInMinutes-impl", "inMinutes", "getInNanoseconds-impl", "inNanoseconds", "getInSeconds-impl", "inSeconds", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "D", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration> {
    public final double value;
    public static final Companion Companion = new Companion(null);
    public static final double ZERO = m1910constructorimpl(0.0d);
    public static final double INFINITE = m1910constructorimpl(Double.POSITIVE_INFINITY);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\u00020\t8\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u000e\u001a\u00020\t8\u0006@\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0012"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "value", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)D", "Lkotlin/time/Duration;", "INFINITE", "D", "getINFINITE-UwyO8pc", "()D", "ZERO", "getZERO-UwyO8pc", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public final double convert(double d2, TimeUnit sourceUnit, TimeUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, sourceUnit, targetUnit);
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final double m1954getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final double m1955getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.box-impl(double):kotlin.time.Duration] */
    public /* synthetic */ Duration(double d2) {
        this.value = d2;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m1908boximpl(double d2) {
        return new Duration(d2);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static double m1910constructorimpl(double d2) {
        return d2;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m1911divLRDsOJo(double d2, double d3) {
        return d2 / d3;
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final double m1913divUwyO8pc(double d2, int i2) {
        return m1910constructorimpl(d2 / i2);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1914equalsimpl(double d2, Object obj) {
        return (obj instanceof Duration) && Double.compare(d2, ((Duration) obj).m1953unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1915equalsimpl0(double d2, double d3) {
        return Double.compare(d2, d3) == 0;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final double m1916getAbsoluteValueUwyO8pc(double d2) {
        return m1931isNegativeimpl(d2) ? m1951unaryMinusUwyO8pc(d2) : d2;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m1917getHoursComponentimpl(double d2) {
        return (int) (m1919getInHoursimpl(d2) % 24);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m1918getInDaysimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m1919getInHoursimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.HOURS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m1920getInMicrosecondsimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m1921getInMillisecondsimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m1922getInMinutesimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.MINUTES);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m1923getInNanosecondsimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m1924getInSecondsimpl(double d2) {
        return m1942toDoubleimpl(d2, TimeUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m1925getMinutesComponentimpl(double d2) {
        return (int) (m1922getInMinutesimpl(d2) % 60);
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m1926getNanosecondsComponentimpl(double d2) {
        return (int) (m1923getInNanosecondsimpl(d2) % 1.0E9d);
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m1927getSecondsComponentimpl(double d2) {
        return (int) (m1924getInSecondsimpl(d2) % 60);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1928hashCodeimpl(double d2) {
        long doubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m1929isFiniteimpl(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m1930isInfiniteimpl(double d2) {
        return Double.isInfinite(d2);
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m1931isNegativeimpl(double d2) {
        return d2 < ((double) 0);
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m1932isPositiveimpl(double d2) {
        return d2 > ((double) 0);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final double m1933minusLRDsOJo(double d2, double d3) {
        return m1910constructorimpl(d2 - d3);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final double m1934plusLRDsOJo(double d2, double d3) {
        return m1910constructorimpl(d2 + d3);
    }

    /* renamed from: precision-impl  reason: not valid java name */
    public static final int m1935precisionimpl(double d2, double d3) {
        if (d3 < 1) {
            return 3;
        }
        if (d3 < 10) {
            return 2;
        }
        return d3 < ((double) 100) ? 1 : 0;
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final double m1937timesUwyO8pc(double d2, int i2) {
        return m1910constructorimpl(d2 * i2);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1941toComponentsimpl(double d2, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf((int) m1918getInDaysimpl(d2)), Integer.valueOf(m1917getHoursComponentimpl(d2)), Integer.valueOf(m1925getMinutesComponentimpl(d2)), Integer.valueOf(m1927getSecondsComponentimpl(d2)), Integer.valueOf(m1926getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m1942toDoubleimpl(double d2, TimeUnit unit) {
        TimeUnit storageUnit;
        Intrinsics.checkNotNullParameter(unit, "unit");
        storageUnit = DurationKt.getStorageUnit();
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, storageUnit, unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m1943toIntimpl(double d2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) m1942toDoubleimpl(d2, unit);
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m1944toIsoStringimpl(double d2) {
        StringBuilder sb = new StringBuilder();
        if (m1931isNegativeimpl(d2)) {
            sb.append(SignatureImpl.SEP);
        }
        sb.append("PT");
        double m1916getAbsoluteValueUwyO8pc = m1916getAbsoluteValueUwyO8pc(d2);
        int m1919getInHoursimpl = (int) m1919getInHoursimpl(m1916getAbsoluteValueUwyO8pc);
        int m1925getMinutesComponentimpl = m1925getMinutesComponentimpl(m1916getAbsoluteValueUwyO8pc);
        int m1927getSecondsComponentimpl = m1927getSecondsComponentimpl(m1916getAbsoluteValueUwyO8pc);
        int m1926getNanosecondsComponentimpl = m1926getNanosecondsComponentimpl(m1916getAbsoluteValueUwyO8pc);
        boolean z = true;
        boolean z2 = m1919getInHoursimpl != 0;
        boolean z3 = (m1927getSecondsComponentimpl == 0 && m1926getNanosecondsComponentimpl == 0) ? false : true;
        if (m1925getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m1919getInHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m1925getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(m1927getSecondsComponentimpl);
            if (m1926getNanosecondsComponentimpl != 0) {
                sb.append('.');
                String padStart = StringsKt__StringsKt.padStart(String.valueOf(m1926getNanosecondsComponentimpl), 9, '0');
                if (m1926getNanosecondsComponentimpl % 1000000 == 0) {
                    sb.append((CharSequence) padStart, 0, 3);
                    Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                } else if (m1926getNanosecondsComponentimpl % 1000 == 0) {
                    sb.append((CharSequence) padStart, 0, 6);
                    Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(padStart);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m1945toLongimpl(double d2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (long) m1942toDoubleimpl(d2, unit);
    }

    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m1946toLongMillisecondsimpl(double d2) {
        return m1945toLongimpl(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m1947toLongNanosecondsimpl(double d2) {
        return m1945toLongimpl(d2, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* renamed from: toString-impl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1948toStringimpl(double d2) {
        TimeUnit timeUnit;
        int i2;
        String formatToExactDecimals;
        if (m1930isInfiniteimpl(d2)) {
            return String.valueOf(d2);
        }
        if (d2 == 0.0d) {
            return "0s";
        }
        double m1923getInNanosecondsimpl = m1923getInNanosecondsimpl(m1916getAbsoluteValueUwyO8pc(d2));
        boolean z = false;
        if (m1923getInNanosecondsimpl < 1.0E-6d) {
            timeUnit = TimeUnit.SECONDS;
        } else {
            if (m1923getInNanosecondsimpl < 1) {
                timeUnit = TimeUnit.NANOSECONDS;
                i2 = 7;
            } else {
                if (m1923getInNanosecondsimpl < 1000.0d) {
                    timeUnit = TimeUnit.NANOSECONDS;
                } else if (m1923getInNanosecondsimpl < 1000000.0d) {
                    timeUnit = TimeUnit.MICROSECONDS;
                } else if (m1923getInNanosecondsimpl < 1.0E9d) {
                    timeUnit = TimeUnit.MILLISECONDS;
                } else if (m1923getInNanosecondsimpl < 1.0E12d) {
                    timeUnit = TimeUnit.SECONDS;
                } else if (m1923getInNanosecondsimpl < 6.0E13d) {
                    timeUnit = TimeUnit.MINUTES;
                } else if (m1923getInNanosecondsimpl < 3.6E15d) {
                    timeUnit = TimeUnit.HOURS;
                } else if (m1923getInNanosecondsimpl < 8.64E20d) {
                    timeUnit = TimeUnit.DAYS;
                } else {
                    timeUnit = TimeUnit.DAYS;
                }
                i2 = 0;
            }
            double m1942toDoubleimpl = m1942toDoubleimpl(d2, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (!z) {
                formatToExactDecimals = FormatToDecimalsKt.formatScientific(m1942toDoubleimpl);
            } else if (i2 > 0) {
                formatToExactDecimals = FormatToDecimalsKt.formatUpToDecimals(m1942toDoubleimpl, i2);
            } else {
                formatToExactDecimals = FormatToDecimalsKt.formatToExactDecimals(m1942toDoubleimpl, m1935precisionimpl(d2, Math.abs(m1942toDoubleimpl)));
            }
            sb.append(formatToExactDecimals);
            sb.append(DurationUnitKt__DurationUnitKt.shortName(timeUnit));
            return sb.toString();
        }
        i2 = 0;
        z = true;
        double m1942toDoubleimpl2 = m1942toDoubleimpl(d2, timeUnit);
        StringBuilder sb2 = new StringBuilder();
        if (!z) {
        }
        sb2.append(formatToExactDecimals);
        sb2.append(DurationUnitKt__DurationUnitKt.shortName(timeUnit));
        return sb2.toString();
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m1950toStringimpl$default(double d2, TimeUnit timeUnit, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m1949toStringimpl(d2, timeUnit, i2);
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final double m1951unaryMinusUwyO8pc(double d2) {
        return m1910constructorimpl(-d2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1952compareToLRDsOJo(duration.m1953unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m1952compareToLRDsOJo(double d2) {
        return m1909compareToLRDsOJo(this.value, d2);
    }

    public boolean equals(Object obj) {
        return m1914equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1928hashCodeimpl(this.value);
    }

    public String toString() {
        return m1948toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ double m1953unboximpl() {
        return this.value;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m1909compareToLRDsOJo(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final double m1912divUwyO8pc(double d2, double d3) {
        return m1910constructorimpl(d2 / d3);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final double m1936timesUwyO8pc(double d2, double d3) {
        return m1910constructorimpl(d2 * d3);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1940toComponentsimpl(double d2, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf((int) m1919getInHoursimpl(d2)), Integer.valueOf(m1925getMinutesComponentimpl(d2)), Integer.valueOf(m1927getSecondsComponentimpl(d2)), Integer.valueOf(m1926getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1939toComponentsimpl(double d2, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf((int) m1922getInMinutesimpl(d2)), Integer.valueOf(m1927getSecondsComponentimpl(d2)), Integer.valueOf(m1926getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1938toComponentsimpl(double d2, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf((long) m1924getInSecondsimpl(d2)), Integer.valueOf(m1926getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m1949toStringimpl(double d2, TimeUnit unit, int i2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i2 >= 0) {
            if (m1930isInfiniteimpl(d2)) {
                return String.valueOf(d2);
            }
            double m1942toDoubleimpl = m1942toDoubleimpl(d2, unit);
            StringBuilder sb = new StringBuilder();
            sb.append(Math.abs(m1942toDoubleimpl) < 1.0E14d ? FormatToDecimalsKt.formatToExactDecimals(m1942toDoubleimpl, RangesKt___RangesKt.coerceAtMost(i2, 12)) : FormatToDecimalsKt.formatScientific(m1942toDoubleimpl));
            sb.append(DurationUnitKt__DurationUnitKt.shortName(unit));
            return sb.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i2).toString());
    }
}
