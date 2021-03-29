package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b4\b\u0087@\u0018\u0000 v2\u00020\u0001:\u0001vB\u0014\b\u0000\u0012\u0006\u0010!\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bu\u0010TJ\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fJ\u001b\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u0015J\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\nJ\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\nJ\u0017\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010\nJ\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010\fJ\u008d\u0001\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2u\u0010/\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u00000'H\u0086\b¢\u0006\u0004\b0\u00101Jx\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2`\u0010/\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000003H\u0086\b¢\u0006\u0004\b0\u00104Jc\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2K\u0010/\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000005H\u0086\b¢\u0006\u0004\b0\u00106JN\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010&26\u0010/\u001a2\u0012\u0013\u0012\u001108¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u000007H\u0086\b¢\u0006\u0004\b0\u00109J\u0019\u0010?\u001a\u00020\u00072\n\u0010<\u001a\u00060:j\u0002`;¢\u0006\u0004\b=\u0010>J\u0019\u0010B\u001a\u00020\u00032\n\u0010<\u001a\u00060:j\u0002`;¢\u0006\u0004\b@\u0010AJ\r\u0010F\u001a\u00020C¢\u0006\u0004\bD\u0010EJ\u0019\u0010I\u001a\u0002082\n\u0010<\u001a\u00060:j\u0002`;¢\u0006\u0004\bG\u0010HJ\r\u0010L\u001a\u000208¢\u0006\u0004\bJ\u0010KJ\r\u0010N\u001a\u000208¢\u0006\u0004\bM\u0010KJ\u000f\u0010P\u001a\u00020CH\u0016¢\u0006\u0004\bO\u0010EJ#\u0010P\u001a\u00020C2\n\u0010<\u001a\u00060:j\u0002`;2\b\b\u0002\u0010Q\u001a\u00020\u0003¢\u0006\u0004\bO\u0010RJ\u0013\u0010U\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00008F@\u0006ø\u0001\u0000¢\u0006\u0006\u001a\u0004\bV\u0010TR\u001c\u0010\\\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR\u0013\u0010^\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b]\u0010TR\u0013\u0010`\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b_\u0010TR\u0013\u0010b\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\ba\u0010TR\u0013\u0010d\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bc\u0010TR\u0013\u0010f\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\be\u0010TR\u0013\u0010h\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bg\u0010TR\u0013\u0010j\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bi\u0010TR\u001c\u0010m\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bl\u0010[\u001a\u0004\bk\u0010YR\u001c\u0010p\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bo\u0010[\u001a\u0004\bn\u0010YR\u001c\u0010s\u001a\u00020\u00038@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\br\u0010[\u001a\u0004\bq\u0010YR\u0016\u0010!\u001a\u00020\u00078\u0000@\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b!\u0010tø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006w"}, d2 = {"Lkotlin/time/Duration;", "Ljava/lang/Comparable;", "other", "", "compareTo-LRDsOJo", "(DD)I", "compareTo", "", "scale", "div-impl", "(DD)D", "div", "(DI)D", "div-LRDsOJo", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "isFinite-impl", "(D)Z", "isFinite", "isInfinite-impl", "isInfinite", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "minus-LRDsOJo", "minus", "plus-LRDsOJo", "plus", "value", "precision-impl", "precision", "times-impl", "times", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toDouble", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toInt", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toIsoString", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLong", "toLongMilliseconds-impl", "(D)J", "toLongMilliseconds", "toLongNanoseconds-impl", "toLongNanoseconds", "toString-impl", "toString", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus-impl", "(D)D", "unaryMinus", "getAbsoluteValue-impl", "absoluteValue", "getHoursComponent-impl", "(D)I", "hoursComponent$annotations", "()V", "hoursComponent", "getInDays-impl", "inDays", "getInHours-impl", "inHours", "getInMicroseconds-impl", "inMicroseconds", "getInMilliseconds-impl", "inMilliseconds", "getInMinutes-impl", "inMinutes", "getInNanoseconds-impl", "inNanoseconds", "getInSeconds-impl", "inSeconds", "getMinutesComponent-impl", "minutesComponent$annotations", "minutesComponent", "getNanosecondsComponent-impl", "nanosecondsComponent$annotations", "nanosecondsComponent", "getSecondsComponent-impl", "secondsComponent$annotations", "secondsComponent", "D", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public final class Duration implements Comparable<Duration> {
    public final double value;
    public static final Companion Companion = new Companion(null);
    public static final double ZERO = m1550constructorimpl(0.0d);
    public static final double INFINITE = m1550constructorimpl(DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\t8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "value", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)D", "Lkotlin/time/Duration;", "INFINITE", "D", "getINFINITE", "()D", "ZERO", "getZERO", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public final double convert(double d2, TimeUnit timeUnit, TimeUnit timeUnit2) {
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, timeUnit, timeUnit2);
        }

        public final double getINFINITE() {
            return Duration.INFINITE;
        }

        public final double getZERO() {
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
    public static final /* synthetic */ Duration m1548boximpl(double d2) {
        return new Duration(d2);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static double m1550constructorimpl(double d2) {
        return d2;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m1551divLRDsOJo(double d2, double d3) {
        return d2 / d3;
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final double m1553divimpl(double d2, int i) {
        return m1550constructorimpl(d2 / i);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1554equalsimpl(double d2, Object obj) {
        return (obj instanceof Duration) && Double.compare(d2, ((Duration) obj).m1593unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1555equalsimpl0(double d2, double d3) {
        throw null;
    }

    /* renamed from: getAbsoluteValue-impl  reason: not valid java name */
    public static final double m1556getAbsoluteValueimpl(double d2) {
        return m1571isNegativeimpl(d2) ? m1591unaryMinusimpl(d2) : d2;
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m1557getHoursComponentimpl(double d2) {
        return (int) (m1559getInHoursimpl(d2) % 24);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m1558getInDaysimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m1559getInHoursimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.HOURS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m1560getInMicrosecondsimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m1561getInMillisecondsimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m1562getInMinutesimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.MINUTES);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m1563getInNanosecondsimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m1564getInSecondsimpl(double d2) {
        return m1582toDoubleimpl(d2, TimeUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m1565getMinutesComponentimpl(double d2) {
        return (int) (m1562getInMinutesimpl(d2) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m1566getNanosecondsComponentimpl(double d2) {
        return (int) (m1563getInNanosecondsimpl(d2) % 1.0E9d);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m1567getSecondsComponentimpl(double d2) {
        return (int) (m1564getInSecondsimpl(d2) % 60);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1568hashCodeimpl(double d2) {
        long doubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    @PublishedApi
    public static /* synthetic */ void hoursComponent$annotations() {
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m1569isFiniteimpl(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m1570isInfiniteimpl(double d2) {
        return Double.isInfinite(d2);
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m1571isNegativeimpl(double d2) {
        return d2 < ((double) 0);
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m1572isPositiveimpl(double d2) {
        return d2 > ((double) 0);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final double m1573minusLRDsOJo(double d2, double d3) {
        return m1550constructorimpl(d2 - d3);
    }

    @PublishedApi
    public static /* synthetic */ void minutesComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void nanosecondsComponent$annotations() {
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final double m1574plusLRDsOJo(double d2, double d3) {
        return m1550constructorimpl(d2 + d3);
    }

    /* renamed from: precision-impl  reason: not valid java name */
    public static final int m1575precisionimpl(double d2, double d3) {
        if (d3 < 1) {
            return 3;
        }
        if (d3 < 10) {
            return 2;
        }
        return d3 < ((double) 100) ? 1 : 0;
    }

    @PublishedApi
    public static /* synthetic */ void secondsComponent$annotations() {
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final double m1577timesimpl(double d2, int i) {
        return m1550constructorimpl(d2 * i);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1581toComponentsimpl(double d2, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        return function5.invoke(Integer.valueOf((int) m1558getInDaysimpl(d2)), Integer.valueOf(m1557getHoursComponentimpl(d2)), Integer.valueOf(m1565getMinutesComponentimpl(d2)), Integer.valueOf(m1567getSecondsComponentimpl(d2)), Integer.valueOf(m1566getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m1582toDoubleimpl(double d2, TimeUnit timeUnit) {
        TimeUnit storageUnit;
        storageUnit = DurationKt.getStorageUnit();
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, storageUnit, timeUnit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m1583toIntimpl(double d2, TimeUnit timeUnit) {
        return (int) m1582toDoubleimpl(d2, timeUnit);
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m1584toIsoStringimpl(double d2) {
        StringBuilder sb = new StringBuilder();
        if (m1571isNegativeimpl(d2)) {
            sb.append('-');
        }
        sb.append("PT");
        double m1556getAbsoluteValueimpl = m1556getAbsoluteValueimpl(d2);
        int m1559getInHoursimpl = (int) m1559getInHoursimpl(m1556getAbsoluteValueimpl);
        int m1565getMinutesComponentimpl = m1565getMinutesComponentimpl(m1556getAbsoluteValueimpl);
        int m1567getSecondsComponentimpl = m1567getSecondsComponentimpl(m1556getAbsoluteValueimpl);
        int m1566getNanosecondsComponentimpl = m1566getNanosecondsComponentimpl(m1556getAbsoluteValueimpl);
        boolean z = true;
        boolean z2 = m1559getInHoursimpl != 0;
        boolean z3 = (m1567getSecondsComponentimpl == 0 && m1566getNanosecondsComponentimpl == 0) ? false : true;
        if (m1565getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m1559getInHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m1565getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(m1567getSecondsComponentimpl);
            if (m1566getNanosecondsComponentimpl != 0) {
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                String padStart = StringsKt__StringsKt.padStart(String.valueOf(m1566getNanosecondsComponentimpl), 9, '0');
                if (m1566getNanosecondsComponentimpl % 1000000 == 0) {
                    sb.append((CharSequence) padStart, 0, 3);
                } else if (m1566getNanosecondsComponentimpl % 1000 == 0) {
                    sb.append((CharSequence) padStart, 0, 6);
                } else {
                    sb.append(padStart);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m1585toLongimpl(double d2, TimeUnit timeUnit) {
        return (long) m1582toDoubleimpl(d2, timeUnit);
    }

    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m1586toLongMillisecondsimpl(double d2) {
        return m1585toLongimpl(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m1587toLongNanosecondsimpl(double d2) {
        return m1585toLongimpl(d2, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* renamed from: toString-impl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1588toStringimpl(double d2) {
        TimeUnit timeUnit;
        int i;
        String formatToExactDecimals;
        if (m1570isInfiniteimpl(d2)) {
            return String.valueOf(d2);
        }
        if (d2 == 0.0d) {
            return "0s";
        }
        double m1563getInNanosecondsimpl = m1563getInNanosecondsimpl(m1556getAbsoluteValueimpl(d2));
        boolean z = false;
        if (m1563getInNanosecondsimpl < 1.0E-6d) {
            timeUnit = TimeUnit.SECONDS;
        } else {
            if (m1563getInNanosecondsimpl < 1) {
                timeUnit = TimeUnit.NANOSECONDS;
                i = 7;
            } else {
                if (m1563getInNanosecondsimpl < 1000.0d) {
                    timeUnit = TimeUnit.NANOSECONDS;
                } else if (m1563getInNanosecondsimpl < 1000000.0d) {
                    timeUnit = TimeUnit.MICROSECONDS;
                } else if (m1563getInNanosecondsimpl < 1.0E9d) {
                    timeUnit = TimeUnit.MILLISECONDS;
                } else if (m1563getInNanosecondsimpl < 1.0E12d) {
                    timeUnit = TimeUnit.SECONDS;
                } else if (m1563getInNanosecondsimpl < 6.0E13d) {
                    timeUnit = TimeUnit.MINUTES;
                } else if (m1563getInNanosecondsimpl < 3.6E15d) {
                    timeUnit = TimeUnit.HOURS;
                } else if (m1563getInNanosecondsimpl < 8.64E20d) {
                    timeUnit = TimeUnit.DAYS;
                } else {
                    timeUnit = TimeUnit.DAYS;
                }
                i = 0;
            }
            double m1582toDoubleimpl = m1582toDoubleimpl(d2, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (!z) {
                formatToExactDecimals = FormatToDecimalsKt.formatScientific(m1582toDoubleimpl);
            } else if (i > 0) {
                formatToExactDecimals = FormatToDecimalsKt.formatUpToDecimals(m1582toDoubleimpl, i);
            } else {
                formatToExactDecimals = FormatToDecimalsKt.formatToExactDecimals(m1582toDoubleimpl, m1575precisionimpl(d2, Math.abs(m1582toDoubleimpl)));
            }
            sb.append(formatToExactDecimals);
            sb.append(DurationUnitKt__DurationUnitKt.shortName(timeUnit));
            return sb.toString();
        }
        i = 0;
        z = true;
        double m1582toDoubleimpl2 = m1582toDoubleimpl(d2, timeUnit);
        StringBuilder sb2 = new StringBuilder();
        if (!z) {
        }
        sb2.append(formatToExactDecimals);
        sb2.append(DurationUnitKt__DurationUnitKt.shortName(timeUnit));
        return sb2.toString();
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m1590toStringimpl$default(double d2, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1589toStringimpl(d2, timeUnit, i);
    }

    /* renamed from: unaryMinus-impl  reason: not valid java name */
    public static final double m1591unaryMinusimpl(double d2) {
        return m1550constructorimpl(-d2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1592compareToLRDsOJo(duration.m1593unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m1592compareToLRDsOJo(double d2) {
        return m1549compareToLRDsOJo(this.value, d2);
    }

    public boolean equals(Object obj) {
        return m1554equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1568hashCodeimpl(this.value);
    }

    public String toString() {
        return m1588toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ double m1593unboximpl() {
        return this.value;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m1549compareToLRDsOJo(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final double m1552divimpl(double d2, double d3) {
        return m1550constructorimpl(d2 / d3);
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final double m1576timesimpl(double d2, double d3) {
        return m1550constructorimpl(d2 * d3);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1580toComponentsimpl(double d2, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        return function4.invoke(Integer.valueOf((int) m1559getInHoursimpl(d2)), Integer.valueOf(m1565getMinutesComponentimpl(d2)), Integer.valueOf(m1567getSecondsComponentimpl(d2)), Integer.valueOf(m1566getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1579toComponentsimpl(double d2, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> function3) {
        return function3.invoke(Integer.valueOf((int) m1562getInMinutesimpl(d2)), Integer.valueOf(m1567getSecondsComponentimpl(d2)), Integer.valueOf(m1566getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1578toComponentsimpl(double d2, Function2<? super Long, ? super Integer, ? extends T> function2) {
        return function2.invoke(Long.valueOf((long) m1564getInSecondsimpl(d2)), Integer.valueOf(m1566getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m1589toStringimpl(double d2, TimeUnit timeUnit, int i) {
        if (i >= 0) {
            if (m1570isInfiniteimpl(d2)) {
                return String.valueOf(d2);
            }
            double m1582toDoubleimpl = m1582toDoubleimpl(d2, timeUnit);
            StringBuilder sb = new StringBuilder();
            sb.append(Math.abs(m1582toDoubleimpl) < 1.0E14d ? FormatToDecimalsKt.formatToExactDecimals(m1582toDoubleimpl, RangesKt___RangesKt.coerceAtMost(i, 12)) : FormatToDecimalsKt.formatScientific(m1582toDoubleimpl));
            sb.append(DurationUnitKt__DurationUnitKt.shortName(timeUnit));
            return sb.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }
}
