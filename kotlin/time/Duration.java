package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.EventLoop_commonKt;
import org.aspectj.runtime.reflect.SignatureImpl;
@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¤\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¤\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010QJ\u001b\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002¢\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002¢\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U¢\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U¢\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U¢\u0006\u0004\bg\u0010]J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bi\u0010jJ\u001b\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bl\u0010jJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bn\u0010PJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t¢\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t¢\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u0018\u0010\u0098\u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0099\u0001\u0010\u0005JK\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\b0\u009c\u0001j\u0003`\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010 \u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010¡\u0001\u001a\u00020UH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006¥\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", TtmlNode.TAG_DIV, "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration> {
    public final long rawValue;
    public static final Companion Companion = new Companion(null);
    public static final long ZERO = m2148constructorimpl(0);
    public static final long INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
    public static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m2146boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2152equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m2202unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2153equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getUnitDiscriminator-impl  reason: not valid java name */
    public static final int m2174getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final long m2175getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2176hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    public static final boolean m2178isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    public static final boolean m2179isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m2181isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m2182isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object obj) {
        return m2152equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m2176hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2202unboximpl() {
        return this.rawValue;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0011J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0014J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0011J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0014J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0017J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0011J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0014J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u0010\u0011J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u0010\u0014J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u0010\u0017J\u001b\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u00108J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b<J\u001b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b>J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010\u0011J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010\u0014J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010\u0017R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R%\u0010\f\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\f\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R%\u0010\f\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R%\u0010\u0018\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R%\u0010\u001b\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R%\u0010\u001e\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R%\u0010!\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R%\u0010!\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R%\u0010!\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R%\u0010$\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R%\u0010$\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R%\u0010$\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R%\u0010'\u001a\u00020\u0004*\u00020\r8Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R%\u0010'\u001a\u00020\u0004*\u00020\u00128Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R%\u0010'\u001a\u00020\u0004*\u00020\u00158Æ\u0002X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2206getDaysUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2207getDaysUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2208getDaysUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2212getHoursUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2213getHoursUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2214getHoursUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2218getMicrosecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2219getMicrosecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2220getMicrosecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2224getMillisecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2225getMillisecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2226getMillisecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2230getMinutesUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2231getMinutesUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2232getMinutesUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2236getNanosecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2237getNanosecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2238getNanosecondsUwyO8pc$annotations(long j) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2242getSecondsUwyO8pc$annotations(double d) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2243getSecondsUwyO8pc$annotations(int i) {
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m2244getSecondsUwyO8pc$annotations(long j) {
        }

        public Companion() {
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m2248getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m2249getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m2250getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m2203getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m2209getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m2215getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m2221getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m2227getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m2233getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m2239getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m2245daysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m2251hoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m2254microsecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m2257millisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m2260minutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m2263nanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m2266parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m2267parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m2268parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m2146boximpl(DurationKt.access$parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m2269parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m2146boximpl(DurationKt.access$parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m2270secondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m2204getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m2210getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m2216getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m2222getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m2228getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m2234getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m2240getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m2246daysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m2252hoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m2255microsecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m2258millisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m2261minutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m2264nanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m2271secondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m2205getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m2211getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m2217getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m2223getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m2229getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m2235getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m2241getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m2247daysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m2253hoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m2256microsecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m2259millisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m2262minutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m2265nanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m2272secondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        @ExperimentalTime
        public final double convert(double d, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, sourceUnit, targetUnit);
        }
    }

    public String toString() {
        return m2197toStringimpl(this.rawValue);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.box-impl(long):kotlin.time.Duration] */
    public /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m2154getAbsoluteValueUwyO8pc(long j) {
        if (m2181isNegativeimpl(j)) {
            return m2200unaryMinusUwyO8pc(j);
        }
        return j;
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m2155getHoursComponentimpl(long j) {
        if (m2180isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2164getInWholeHoursimpl(j) % 24);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m2156getInDaysimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m2157getInHoursimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m2158getInMicrosecondsimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m2159getInMillisecondsimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m2160getInMinutesimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m2161getInNanosecondsimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.NANOSECONDS);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m2162getInSecondsimpl(long j) {
        return m2191toDoubleimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m2163getInWholeDaysimpl(long j) {
        return m2194toLongimpl(j, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m2164getInWholeHoursimpl(long j) {
        return m2194toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m2165getInWholeMicrosecondsimpl(long j) {
        return m2194toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m2166getInWholeMillisecondsimpl(long j) {
        if (m2178isInMillisimpl(j) && m2177isFiniteimpl(j)) {
            return m2175getValueimpl(j);
        }
        return m2194toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m2167getInWholeMinutesimpl(long j) {
        return m2194toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m2168getInWholeNanosecondsimpl(long j) {
        long m2175getValueimpl = m2175getValueimpl(j);
        if (!m2179isInNanosimpl(j)) {
            if (m2175getValueimpl > EventLoop_commonKt.MAX_MS) {
                return Long.MAX_VALUE;
            }
            if (m2175getValueimpl < -9223372036854L) {
                return Long.MIN_VALUE;
            }
            return DurationKt.access$millisToNanos(m2175getValueimpl);
        }
        return m2175getValueimpl;
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m2169getInWholeSecondsimpl(long j) {
        return m2194toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m2170getMinutesComponentimpl(long j) {
        if (m2180isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2167getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m2171getNanosecondsComponentimpl(long j) {
        long m2175getValueimpl;
        if (m2180isInfiniteimpl(j)) {
            return 0;
        }
        if (m2178isInMillisimpl(j)) {
            m2175getValueimpl = DurationKt.access$millisToNanos(m2175getValueimpl(j) % 1000);
        } else {
            m2175getValueimpl = m2175getValueimpl(j) % 1000000000;
        }
        return (int) m2175getValueimpl;
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m2172getSecondsComponentimpl(long j) {
        if (m2180isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2169getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    public static final DurationUnit m2173getStorageUnitimpl(long j) {
        if (m2179isInNanosimpl(j)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m2177isFiniteimpl(long j) {
        return !m2180isInfiniteimpl(j);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m2180isInfiniteimpl(long j) {
        if (j != INFINITE && j != NEG_INFINITE) {
            return false;
        }
        return true;
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @ExperimentalTime
    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m2195toLongMillisecondsimpl(long j) {
        return m2166getInWholeMillisecondsimpl(j);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @ExperimentalTime
    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m2196toLongNanosecondsimpl(long j) {
        return m2168getInWholeNanosecondsimpl(j);
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m2200unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-m2175getValueimpl(j), ((int) j) & 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m2201compareToLRDsOJo(duration.m2202unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m2201compareToLRDsOJo(long j) {
        return m2147compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    public static final long m2144addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j3);
        long j4 = j2 + access$nanosToMillis;
        boolean z = false;
        if (-4611686018426L <= j4 && j4 < 4611686018427L) {
            z = true;
        }
        if (z) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j4) + (j3 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    public static final void m2145appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        boolean z2;
        sb.append(i);
        if (i2 != 0) {
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            String padStart = StringsKt__StringsKt.padStart(String.valueOf(i2), i3, (char) TransactionIdCreater.FILL_BYTE);
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) padStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i6 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m2147compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 >= 0 && (((int) j3) & 1) != 0) {
            int i = (((int) j) & 1) - (((int) j2) & 1);
            if (m2181isNegativeimpl(j)) {
                return -i;
            }
            return i;
        }
        return Intrinsics.compare(j, j2);
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m2149divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt___ComparisonsJvmKt.maxOf(m2173getStorageUnitimpl(j), m2173getStorageUnitimpl(j2));
        return m2191toDoubleimpl(j, durationUnit) / m2191toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m2150divUwyO8pc(long j, double d) {
        boolean z;
        int roundToInt = MathKt__MathJVMKt.roundToInt(d);
        if (roundToInt == d) {
            z = true;
        } else {
            z = false;
        }
        if (z && roundToInt != 0) {
            return m2151divUwyO8pc(j, roundToInt);
        }
        DurationUnit m2173getStorageUnitimpl = m2173getStorageUnitimpl(j);
        return DurationKt.toDuration(m2191toDoubleimpl(j, m2173getStorageUnitimpl) / d, m2173getStorageUnitimpl);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m2183minusLRDsOJo(long j, long j2) {
        return m2184plusLRDsOJo(j, m2200unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m2185timesUwyO8pc(long j, double d) {
        boolean z;
        int roundToInt = MathKt__MathJVMKt.roundToInt(d);
        if (roundToInt == d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return m2186timesUwyO8pc(j, roundToInt);
        }
        DurationUnit m2173getStorageUnitimpl = m2173getStorageUnitimpl(j);
        return DurationKt.toDuration(m2191toDoubleimpl(j, m2173getStorageUnitimpl) * d, m2173getStorageUnitimpl);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2187toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m2169getInWholeSecondsimpl(j)), Integer.valueOf(m2171getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m2191toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2175getValueimpl(j), m2173getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m2192toIntimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt___RangesKt.coerceIn(m2194toLongimpl(j, unit), -2147483648L, 2147483647L);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m2194toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2175getValueimpl(j), m2173getStorageUnitimpl(j), unit);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2148constructorimpl(long j) {
        boolean z;
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            boolean z2 = true;
            if (m2179isInNanosimpl(j)) {
                long m2175getValueimpl = m2175getValueimpl(j);
                if (!((-4611686018426999999L > m2175getValueimpl || m2175getValueimpl >= 4611686018427000000L) ? false : false)) {
                    throw new AssertionError(m2175getValueimpl(j) + " ns is out of nanoseconds range");
                }
            } else {
                long m2175getValueimpl2 = m2175getValueimpl(j);
                if (-4611686018427387903L <= m2175getValueimpl2 && m2175getValueimpl2 < 4611686018427387904L) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    long m2175getValueimpl3 = m2175getValueimpl(j);
                    if ((-4611686018426L > m2175getValueimpl3 || m2175getValueimpl3 >= 4611686018427L) ? false : false) {
                        throw new AssertionError(m2175getValueimpl(j) + " ms is denormalized");
                    }
                } else {
                    throw new AssertionError(m2175getValueimpl(j) + " ms is out of milliseconds range");
                }
            }
        }
        return j;
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m2151divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m2182isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m2181isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m2179isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanos(m2175getValueimpl(j) / i);
        } else {
            if (m2180isInfiniteimpl(j)) {
                return m2186timesUwyO8pc(j, MathKt__MathJVMKt.getSign(i));
            }
            long j2 = i;
            long m2175getValueimpl = m2175getValueimpl(j) / j2;
            boolean z = false;
            if (-4611686018426L <= m2175getValueimpl && m2175getValueimpl < 4611686018427L) {
                z = true;
            }
            if (z) {
                return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m2175getValueimpl) + (DurationKt.access$millisToNanos(m2175getValueimpl(j) - (m2175getValueimpl * j2)) / j2));
            }
            return DurationKt.access$durationOfMillis(m2175getValueimpl);
        }
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m2184plusLRDsOJo(long j, long j2) {
        if (m2180isInfiniteimpl(j)) {
            if (!m2177isFiniteimpl(j2) && (j2 ^ j) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j;
        } else if (m2180isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long m2175getValueimpl = m2175getValueimpl(j) + m2175getValueimpl(j2);
                if (m2179isInNanosimpl(j)) {
                    return DurationKt.access$durationOfNanosNormalized(m2175getValueimpl);
                }
                return DurationKt.access$durationOfMillisNormalized(m2175getValueimpl);
            } else if (m2178isInMillisimpl(j)) {
                return m2144addValuesMixedRangesUwyO8pc(j, m2175getValueimpl(j), m2175getValueimpl(j2));
            } else {
                return m2144addValuesMixedRangesUwyO8pc(j, m2175getValueimpl(j2), m2175getValueimpl(j));
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m2186timesUwyO8pc(long j, int i) {
        if (m2180isInfiniteimpl(j)) {
            if (i != 0) {
                if (i <= 0) {
                    return m2200unaryMinusUwyO8pc(j);
                }
                return j;
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return ZERO;
        } else {
            long m2175getValueimpl = m2175getValueimpl(j);
            long j2 = i;
            long j3 = m2175getValueimpl * j2;
            if (m2179isInNanosimpl(j)) {
                boolean z = false;
                if (m2175getValueimpl <= 2147483647L && -2147483647L <= m2175getValueimpl) {
                    z = true;
                }
                if (z) {
                    return DurationKt.access$durationOfNanos(j3);
                }
                if (j3 / j2 == m2175getValueimpl) {
                    return DurationKt.access$durationOfNanosNormalized(j3);
                }
                long access$nanosToMillis = DurationKt.access$nanosToMillis(m2175getValueimpl);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m2175getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 == access$nanosToMillis && (access$nanosToMillis2 ^ j4) >= 0) {
                    return DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
                }
                if (MathKt__MathJVMKt.getSign(m2175getValueimpl) * MathKt__MathJVMKt.getSign(i) > 0) {
                    return INFINITE;
                }
                return NEG_INFINITE;
            } else if (j3 / j2 == m2175getValueimpl) {
                return DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else {
                if (MathKt__MathJVMKt.getSign(m2175getValueimpl) * MathKt__MathJVMKt.getSign(i) > 0) {
                    return INFINITE;
                }
                return NEG_INFINITE;
            }
        }
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2188toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m2167getInWholeMinutesimpl(j)), Integer.valueOf(m2172getSecondsComponentimpl(j)), Integer.valueOf(m2171getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2189toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m2164getInWholeHoursimpl(j)), Integer.valueOf(m2170getMinutesComponentimpl(j)), Integer.valueOf(m2172getSecondsComponentimpl(j)), Integer.valueOf(m2171getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2190toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m2163getInWholeDaysimpl(j)), Integer.valueOf(m2155getHoursComponentimpl(j)), Integer.valueOf(m2170getMinutesComponentimpl(j)), Integer.valueOf(m2172getSecondsComponentimpl(j)), Integer.valueOf(m2171getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m2193toIsoStringimpl(long j) {
        boolean z;
        boolean z2;
        StringBuilder sb = new StringBuilder();
        if (m2181isNegativeimpl(j)) {
            sb.append(SignatureImpl.SEP);
        }
        sb.append("PT");
        long m2154getAbsoluteValueUwyO8pc = m2154getAbsoluteValueUwyO8pc(j);
        long m2164getInWholeHoursimpl = m2164getInWholeHoursimpl(m2154getAbsoluteValueUwyO8pc);
        int m2170getMinutesComponentimpl = m2170getMinutesComponentimpl(m2154getAbsoluteValueUwyO8pc);
        int m2172getSecondsComponentimpl = m2172getSecondsComponentimpl(m2154getAbsoluteValueUwyO8pc);
        int m2171getNanosecondsComponentimpl = m2171getNanosecondsComponentimpl(m2154getAbsoluteValueUwyO8pc);
        if (m2180isInfiniteimpl(j)) {
            m2164getInWholeHoursimpl = 9999999999999L;
        }
        boolean z3 = true;
        if (m2164getInWholeHoursimpl != 0) {
            z = true;
        } else {
            z = false;
        }
        if (m2172getSecondsComponentimpl == 0 && m2171getNanosecondsComponentimpl == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (m2170getMinutesComponentimpl == 0 && (!z2 || !z)) {
            z3 = false;
        }
        if (z) {
            sb.append(m2164getInWholeHoursimpl);
            sb.append('H');
        }
        if (z3) {
            sb.append(m2170getMinutesComponentimpl);
            sb.append('M');
        }
        if (z2 || (!z && !z3)) {
            m2145appendFractionalimpl(j, sb, m2172getSecondsComponentimpl, m2171getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2197toStringimpl(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m2181isNegativeimpl = m2181isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m2181isNegativeimpl) {
            sb.append(SignatureImpl.SEP);
        }
        long m2154getAbsoluteValueUwyO8pc = m2154getAbsoluteValueUwyO8pc(j);
        long m2163getInWholeDaysimpl = m2163getInWholeDaysimpl(m2154getAbsoluteValueUwyO8pc);
        int m2155getHoursComponentimpl = m2155getHoursComponentimpl(m2154getAbsoluteValueUwyO8pc);
        int m2170getMinutesComponentimpl = m2170getMinutesComponentimpl(m2154getAbsoluteValueUwyO8pc);
        int m2172getSecondsComponentimpl = m2172getSecondsComponentimpl(m2154getAbsoluteValueUwyO8pc);
        int m2171getNanosecondsComponentimpl = m2171getNanosecondsComponentimpl(m2154getAbsoluteValueUwyO8pc);
        int i = 0;
        if (m2163getInWholeDaysimpl != 0) {
            z = true;
        } else {
            z = false;
        }
        if (m2155getHoursComponentimpl != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (m2170getMinutesComponentimpl != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (m2172getSecondsComponentimpl == 0 && m2171getNanosecondsComponentimpl == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z) {
            sb.append(m2163getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            sb.append(m2155getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            sb.append(m2170getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            if (m2172getSecondsComponentimpl == 0 && !z && !z2 && !z3) {
                if (m2171getNanosecondsComponentimpl >= 1000000) {
                    m2145appendFractionalimpl(j, sb, m2171getNanosecondsComponentimpl / 1000000, m2171getNanosecondsComponentimpl % 1000000, 6, "ms", false);
                } else if (m2171getNanosecondsComponentimpl >= 1000) {
                    m2145appendFractionalimpl(j, sb, m2171getNanosecondsComponentimpl / 1000, m2171getNanosecondsComponentimpl % 1000, 3, "us", false);
                } else {
                    sb.append(m2171getNanosecondsComponentimpl);
                    sb.append(NotificationStyle.NOTIFICATION_STYLE);
                }
            } else {
                m2145appendFractionalimpl(j, sb, m2172getSecondsComponentimpl, m2171getNanosecondsComponentimpl, 9, "s", false);
            }
            i = i4;
        }
        if (m2181isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m2198toStringimpl(long j, DurationUnit unit, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            double m2191toDoubleimpl = m2191toDoubleimpl(j, unit);
            if (Double.isInfinite(m2191toDoubleimpl)) {
                return String.valueOf(m2191toDoubleimpl);
            }
            return DurationJvmKt.formatToExactDecimals(m2191toDoubleimpl, RangesKt___RangesKt.coerceAtMost(i, 12)) + DurationUnitKt__DurationUnitKt.shortName(unit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m2199toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m2198toStringimpl(j, durationUnit, i);
    }
}
