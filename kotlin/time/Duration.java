package kotlin.time;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
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
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 ¬\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¬\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\\2\b\u0010Q\u001a\u0004\u0018\u00010]HÖ\u0003¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\tHÖ\u0001¢\u0006\u0004\ba\u0010\rJ\r\u0010b\u001a\u00020\\¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002¢\u0006\u0004\bh\u0010dJ\r\u0010i\u001a\u00020\\¢\u0006\u0004\bj\u0010dJ\r\u0010k\u001a\u00020\\¢\u0006\u0004\bl\u0010dJ\r\u0010m\u001a\u00020\\¢\u0006\u0004\bn\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010qJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010WJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010XJ \u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2v\u0010x\u001ar\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0yH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u008c\u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2b\u0010x\u001a^\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0083\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0084\u0001Jw\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2M\u0010x\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0085\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0086\u0001Jb\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w28\u0010x\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0087\u0001H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0088\u0001J\u001e\u0010\u0089\u0001\u001a\u00020\u000f2\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001e\u0010\u008e\u0001\u001a\u00020\t2\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00030\u0092\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001e\u0010\u0095\u0001\u001a\u00020\u00032\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0099\u0001\u0010\u0005J\u0011\u0010\u009a\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u009b\u0001\u0010\u0005J\u0013\u0010\u009c\u0001\u001a\u00030\u0092\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u0094\u0001J*\u0010\u009c\u0001\u001a\u00030\u0092\u00012\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u00012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\t¢\u0006\u0006\b\u009d\u0001\u0010\u009f\u0001J\u0018\u0010 \u0001\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¡\u0001\u0010\u0005JK\u0010¢\u0001\u001a\u00030£\u0001*\b0¤\u0001j\u0003`¥\u00012\u0007\u0010¦\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\t2\b\u0010\u008a\u0001\u001a\u00030\u0092\u00012\u0007\u0010©\u0001\u001a\u00020\\H\u0002¢\u0006\u0006\bª\u0001\u0010«\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0015\u0010G\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", ImageViewerConfig.FROM_OTHER, "compareTo-LRDsOJo", "(JJ)I", TtmlNode.TAG_DIV, "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@JvmInline
@ExperimentalTime
/* loaded from: classes8.dex */
public final class Duration implements Comparable<Duration> {
    public final long rawValue;
    public static final Companion Companion = new Companion(null);
    public static final long ZERO = m1984constructorimpl(0);
    public static final long INFINITE = DurationKt.access$durationOfMillis(4611686018427387903L);
    public static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010'J\u001d\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b+J\u001d\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0015J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00060"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public final double convert(double d, TimeUnit sourceUnit, TimeUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, sourceUnit, targetUnit);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m2040daysUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.DAYS);
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m2042getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m2043getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m2044getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m2046hoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m2049microsecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m2052millisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m2055minutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m2058nanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m2060parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m2061parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m2062parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1982boximpl(DurationKt.access$parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m2063parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1982boximpl(DurationKt.access$parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m2065secondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.SECONDS);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m2041daysUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m2047hoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m2050microsecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m2053millisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m2056minutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m2059nanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m2066secondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m2039daysUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m2045hoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m2048microsecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m2051millisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m2054minutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m2057nanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m2064secondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.SECONDS);
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.box-impl(long):kotlin.time.Duration] */
    public /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    public static final long m1980addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j3);
        long j4 = j2 + access$nanosToMillis;
        if (-4611686018426L <= j4 && DurationKt.MAX_NANOS_IN_MILLIS >= j4) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j4) + (j3 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    public static final void m1981appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            String padStart = StringsKt__StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (padStart.charAt(length) != '0') {
                    i4 = length;
                    break;
                }
                length--;
            }
            int i5 = i4 + 1;
            if (!z && i5 < 3) {
                sb.append((CharSequence) padStart, 0, i5);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i5 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m1982boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1984constructorimpl(long j) {
        if (m2015isInNanosimpl(j)) {
            long m2011getValueimpl = m2011getValueimpl(j);
            if (-4611686018426999999L > m2011getValueimpl || DurationKt.MAX_NANOS < m2011getValueimpl) {
                throw new AssertionError(m2011getValueimpl(j) + " ns is out of nanoseconds range");
            }
        } else {
            long m2011getValueimpl2 = m2011getValueimpl(j);
            if (-4611686018427387903L <= m2011getValueimpl2 && 4611686018427387903L >= m2011getValueimpl2) {
                long m2011getValueimpl3 = m2011getValueimpl(j);
                if (-4611686018426L <= m2011getValueimpl3 && DurationKt.MAX_NANOS_IN_MILLIS >= m2011getValueimpl3) {
                    throw new AssertionError(m2011getValueimpl(j) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(m2011getValueimpl(j) + " ms is out of milliseconds range");
            }
        }
        return j;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m1985divLRDsOJo(long j, long j2) {
        TimeUnit timeUnit = (TimeUnit) ComparisonsKt___ComparisonsJvmKt.maxOf(m2009getStorageUnitimpl(j), m2009getStorageUnitimpl(j2));
        return m2027toDoubleimpl(j, timeUnit) / m2027toDoubleimpl(j2, timeUnit);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m1987divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m2018isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m2017isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m2015isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanos(m2011getValueimpl(j) / i);
        } else {
            if (m2016isInfiniteimpl(j)) {
                return m2022timesUwyO8pc(j, MathKt__MathJVMKt.getSign(i));
            }
            long j2 = i;
            long m2011getValueimpl = m2011getValueimpl(j) / j2;
            if (-4611686018426L <= m2011getValueimpl && DurationKt.MAX_NANOS_IN_MILLIS >= m2011getValueimpl) {
                return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m2011getValueimpl) + (DurationKt.access$millisToNanos(m2011getValueimpl(j) - (m2011getValueimpl * j2)) / j2));
            }
            return DurationKt.access$durationOfMillis(m2011getValueimpl);
        }
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1988equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m2038unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1989equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m1990getAbsoluteValueUwyO8pc(long j) {
        return m2017isNegativeimpl(j) ? m2036unaryMinusUwyO8pc(j) : j;
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m1991getHoursComponentimpl(long j) {
        if (m2016isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2000getInWholeHoursimpl(j) % 24);
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    public static /* synthetic */ void getInDays$annotations() {
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m1992getInDaysimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.DAYS);
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    public static /* synthetic */ void getInHours$annotations() {
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m1993getInHoursimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.HOURS);
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m1994getInMicrosecondsimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m1995getInMillisecondsimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m1996getInMinutesimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.MINUTES);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m1997getInNanosecondsimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m1998getInSecondsimpl(long j) {
        return m2027toDoubleimpl(j, TimeUnit.SECONDS);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeDays$annotations() {
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m1999getInWholeDaysimpl(long j) {
        return m2030toLongimpl(j, TimeUnit.DAYS);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeHours$annotations() {
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m2000getInWholeHoursimpl(long j) {
        return m2030toLongimpl(j, TimeUnit.HOURS);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeMicroseconds$annotations() {
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m2001getInWholeMicrosecondsimpl(long j) {
        return m2030toLongimpl(j, TimeUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeMilliseconds$annotations() {
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m2002getInWholeMillisecondsimpl(long j) {
        return (m2014isInMillisimpl(j) && m2013isFiniteimpl(j)) ? m2011getValueimpl(j) : m2030toLongimpl(j, TimeUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeMinutes$annotations() {
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m2003getInWholeMinutesimpl(long j) {
        return m2030toLongimpl(j, TimeUnit.MINUTES);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeNanoseconds$annotations() {
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m2004getInWholeNanosecondsimpl(long j) {
        long m2011getValueimpl = m2011getValueimpl(j);
        if (m2015isInNanosimpl(j)) {
            return m2011getValueimpl;
        }
        if (m2011getValueimpl > EventLoop_commonKt.MAX_MS) {
            return Long.MAX_VALUE;
        }
        if (m2011getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.access$millisToNanos(m2011getValueimpl);
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void getInWholeSeconds$annotations() {
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m2005getInWholeSecondsimpl(long j) {
        return m2030toLongimpl(j, TimeUnit.SECONDS);
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m2006getMinutesComponentimpl(long j) {
        if (m2016isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2003getInWholeMinutesimpl(j) % 60);
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m2007getNanosecondsComponentimpl(long j) {
        if (m2016isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2014isInMillisimpl(j) ? DurationKt.access$millisToNanos(m2011getValueimpl(j) % 1000) : m2011getValueimpl(j) % 1000000000);
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m2008getSecondsComponentimpl(long j) {
        if (m2016isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2005getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    public static final TimeUnit m2009getStorageUnitimpl(long j) {
        return m2015isInNanosimpl(j) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    /* renamed from: getUnitDiscriminator-impl  reason: not valid java name */
    public static final int m2010getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final long m2011getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2012hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m2013isFiniteimpl(long j) {
        return !m2016isInfiniteimpl(j);
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    public static final boolean m2014isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    public static final boolean m2015isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m2016isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m2017isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m2018isPositiveimpl(long j) {
        return j > 0;
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m2019minusLRDsOJo(long j, long j2) {
        return m2020plusLRDsOJo(j, m2036unaryMinusUwyO8pc(j2));
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m2020plusLRDsOJo(long j, long j2) {
        if (m2016isInfiniteimpl(j)) {
            if (m2013isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m2016isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long m2011getValueimpl = m2011getValueimpl(j) + m2011getValueimpl(j2);
                if (m2015isInNanosimpl(j)) {
                    return DurationKt.access$durationOfNanosNormalized(m2011getValueimpl);
                }
                return DurationKt.access$durationOfMillisNormalized(m2011getValueimpl);
            } else if (m2014isInMillisimpl(j)) {
                return m1980addValuesMixedRangesUwyO8pc(j, m2011getValueimpl(j), m2011getValueimpl(j2));
            } else {
                return m1980addValuesMixedRangesUwyO8pc(j, m2011getValueimpl(j2), m2011getValueimpl(j));
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m2022timesUwyO8pc(long j, int i) {
        if (m2016isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m2036unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return ZERO;
        } else {
            long m2011getValueimpl = m2011getValueimpl(j);
            long j2 = i;
            long j3 = m2011getValueimpl * j2;
            if (!m2015isInNanosimpl(j)) {
                if (j3 / j2 == m2011getValueimpl) {
                    return DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, 4611686018427387903L)));
                }
                return MathKt__MathJVMKt.getSign(m2011getValueimpl) * MathKt__MathJVMKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
            } else if (-2147483647L <= m2011getValueimpl && 2147483647L >= m2011getValueimpl) {
                return DurationKt.access$durationOfNanos(j3);
            } else {
                if (j3 / j2 == m2011getValueimpl) {
                    return DurationKt.access$durationOfNanosNormalized(j3);
                }
                long access$nanosToMillis = DurationKt.access$nanosToMillis(m2011getValueimpl);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m2011getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                    return MathKt__MathJVMKt.getSign(m2011getValueimpl) * MathKt__MathJVMKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
                }
                return DurationKt.access$durationOfMillis(RangesKt___RangesKt.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
            }
        }
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2026toComponentsimpl(long j, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m2028toIntimpl(j, TimeUnit.DAYS)), Integer.valueOf(m1991getHoursComponentimpl(j)), Integer.valueOf(m2006getMinutesComponentimpl(j)), Integer.valueOf(m2008getSecondsComponentimpl(j)), Integer.valueOf(m2007getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m2027toDoubleimpl(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2011getValueimpl(j), m2009getStorageUnitimpl(j), unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m2028toIntimpl(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt___RangesKt.coerceIn(m2030toLongimpl(j, unit), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m2029toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m2017isNegativeimpl(j)) {
            sb.append(SignatureImpl.SEP);
        }
        sb.append("PT");
        long m1990getAbsoluteValueUwyO8pc = m1990getAbsoluteValueUwyO8pc(j);
        m2028toIntimpl(m1990getAbsoluteValueUwyO8pc, TimeUnit.HOURS);
        int m2006getMinutesComponentimpl = m2006getMinutesComponentimpl(m1990getAbsoluteValueUwyO8pc);
        int m2008getSecondsComponentimpl = m2008getSecondsComponentimpl(m1990getAbsoluteValueUwyO8pc);
        int m2007getNanosecondsComponentimpl = m2007getNanosecondsComponentimpl(m1990getAbsoluteValueUwyO8pc);
        long m2000getInWholeHoursimpl = m2000getInWholeHoursimpl(m1990getAbsoluteValueUwyO8pc);
        if (m2016isInfiniteimpl(j)) {
            m2000getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = true;
        boolean z2 = m2000getInWholeHoursimpl != 0;
        boolean z3 = (m2008getSecondsComponentimpl == 0 && m2007getNanosecondsComponentimpl == 0) ? false : true;
        if (m2006getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m2000getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m2006getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m1981appendFractionalimpl(j, sb, m2008getSecondsComponentimpl, m2007getNanosecondsComponentimpl, 9, "S", true);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m2030toLongimpl(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2011getValueimpl(j), m2009getStorageUnitimpl(j), unit);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m2031toLongMillisecondsimpl(long j) {
        return m2002getInWholeMillisecondsimpl(j);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m2032toLongNanosecondsimpl(long j) {
        return m2004getInWholeNanosecondsimpl(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2033toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m2017isNegativeimpl = m2017isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m2017isNegativeimpl) {
            sb.append(SignatureImpl.SEP);
        }
        long m1990getAbsoluteValueUwyO8pc = m1990getAbsoluteValueUwyO8pc(j);
        m2028toIntimpl(m1990getAbsoluteValueUwyO8pc, TimeUnit.DAYS);
        int m1991getHoursComponentimpl = m1991getHoursComponentimpl(m1990getAbsoluteValueUwyO8pc);
        int m2006getMinutesComponentimpl = m2006getMinutesComponentimpl(m1990getAbsoluteValueUwyO8pc);
        int m2008getSecondsComponentimpl = m2008getSecondsComponentimpl(m1990getAbsoluteValueUwyO8pc);
        int m2007getNanosecondsComponentimpl = m2007getNanosecondsComponentimpl(m1990getAbsoluteValueUwyO8pc);
        long m1999getInWholeDaysimpl = m1999getInWholeDaysimpl(m1990getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m1999getInWholeDaysimpl != 0;
        boolean z2 = m1991getHoursComponentimpl != 0;
        boolean z3 = m2006getMinutesComponentimpl != 0;
        boolean z4 = (m2008getSecondsComponentimpl == 0 && m2007getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m1999getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            sb.append(m1991getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            sb.append(m2006getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
            if (m2008getSecondsComponentimpl != 0 || z || z2 || z3) {
                m1981appendFractionalimpl(m1990getAbsoluteValueUwyO8pc, sb, m2008getSecondsComponentimpl, m2007getNanosecondsComponentimpl, 9, "s", false);
            } else if (m2007getNanosecondsComponentimpl >= 1000000) {
                m1981appendFractionalimpl(m1990getAbsoluteValueUwyO8pc, sb, m2007getNanosecondsComponentimpl / 1000000, m2007getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m2007getNanosecondsComponentimpl >= 1000) {
                m1981appendFractionalimpl(m1990getAbsoluteValueUwyO8pc, sb, m2007getNanosecondsComponentimpl / 1000, m2007getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m2007getNanosecondsComponentimpl);
                sb.append(NotificationStyle.NOTIFICATION_STYLE);
            }
            i = i4;
        }
        if (m2017isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m2035toStringimpl$default(long j, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m2034toStringimpl(j, timeUnit, i);
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m2036unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-m2011getValueimpl(j), ((int) j) & 1);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m2037compareToLRDsOJo(duration.m2038unboximpl());
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m2037compareToLRDsOJo(long j) {
        return m1983compareToLRDsOJo(this.rawValue, j);
    }

    public boolean equals(Object obj) {
        return m1988equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m2012hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m2033toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2038unboximpl() {
        return this.rawValue;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m1983compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return (j > j2 ? 1 : (j == j2 ? 0 : -1));
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m2017isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2025toComponentsimpl(long j, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m2028toIntimpl(j, TimeUnit.HOURS)), Integer.valueOf(m2006getMinutesComponentimpl(j)), Integer.valueOf(m2008getSecondsComponentimpl(j)), Integer.valueOf(m2007getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2024toComponentsimpl(long j, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m2028toIntimpl(j, TimeUnit.MINUTES)), Integer.valueOf(m2008getSecondsComponentimpl(j)), Integer.valueOf(m2007getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m2023toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m2005getInWholeSecondsimpl(j)), Integer.valueOf(m2007getNanosecondsComponentimpl(j)));
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m1986divUwyO8pc(long j, double d) {
        int roundToInt = MathKt__MathJVMKt.roundToInt(d);
        if (roundToInt == d && roundToInt != 0) {
            return m1987divUwyO8pc(j, roundToInt);
        }
        TimeUnit m2009getStorageUnitimpl = m2009getStorageUnitimpl(j);
        return DurationKt.toDuration(m2027toDoubleimpl(j, m2009getStorageUnitimpl) / d, m2009getStorageUnitimpl);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m2021timesUwyO8pc(long j, double d) {
        int roundToInt = MathKt__MathJVMKt.roundToInt(d);
        if (roundToInt == d) {
            return m2022timesUwyO8pc(j, roundToInt);
        }
        TimeUnit m2009getStorageUnitimpl = m2009getStorageUnitimpl(j);
        return DurationKt.toDuration(m2027toDoubleimpl(j, m2009getStorageUnitimpl) * d, m2009getStorageUnitimpl);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m2034toStringimpl(long j, TimeUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i >= 0) {
            double m2027toDoubleimpl = m2027toDoubleimpl(j, unit);
            if (Double.isInfinite(m2027toDoubleimpl)) {
                return String.valueOf(m2027toDoubleimpl);
            }
            return FormatToDecimalsKt.formatToExactDecimals(m2027toDoubleimpl, RangesKt___RangesKt.coerceAtMost(i, 12)) + DurationUnitKt__DurationUnitKt.shortName(unit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }
}
