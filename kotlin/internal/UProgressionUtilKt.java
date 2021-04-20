package kotlin.internal;

import com.baidu.down.request.task.ProgressInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0005\u001a*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "differenceModulo", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", IntentConfig.START, ProgressInfo.JSON_KEY_END, "", "step", "getProgressionLastElement-Nkh28Cs", "getProgressionLastElement", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    public static final int m1491differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int m944uintRemainderJ1ME1BU = UnsignedKt.m944uintRemainderJ1ME1BU(i, i3);
        int m944uintRemainderJ1ME1BU2 = UnsignedKt.m944uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = UnsignedKt.uintCompare(m944uintRemainderJ1ME1BU, m944uintRemainderJ1ME1BU2);
        int m717constructorimpl = UInt.m717constructorimpl(m944uintRemainderJ1ME1BU - m944uintRemainderJ1ME1BU2);
        return uintCompare >= 0 ? m717constructorimpl : UInt.m717constructorimpl(m717constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    public static final long m1492differenceModulosambcqE(long j, long j2, long j3) {
        long m946ulongRemaindereb3DHEI = UnsignedKt.m946ulongRemaindereb3DHEI(j, j3);
        long m946ulongRemaindereb3DHEI2 = UnsignedKt.m946ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = UnsignedKt.ulongCompare(m946ulongRemaindereb3DHEI, m946ulongRemaindereb3DHEI2);
        long m786constructorimpl = ULong.m786constructorimpl(m946ulongRemaindereb3DHEI - m946ulongRemaindereb3DHEI2);
        return ulongCompare >= 0 ? m786constructorimpl : ULong.m786constructorimpl(m786constructorimpl + j3);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m1493getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            return UnsignedKt.ulongCompare(j, j2) >= 0 ? j2 : ULong.m786constructorimpl(j2 - m1492differenceModulosambcqE(j2, j, ULong.m786constructorimpl(j3)));
        } else if (i < 0) {
            return UnsignedKt.ulongCompare(j, j2) <= 0 ? j2 : ULong.m786constructorimpl(j2 + m1492differenceModulosambcqE(j, j2, ULong.m786constructorimpl(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m1494getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return UnsignedKt.uintCompare(i, i2) >= 0 ? i2 : UInt.m717constructorimpl(i2 - m1491differenceModuloWZ9TVnA(i2, i, UInt.m717constructorimpl(i3)));
        } else if (i3 < 0) {
            return UnsignedKt.uintCompare(i, i2) <= 0 ? i2 : UInt.m717constructorimpl(i2 + m1491differenceModuloWZ9TVnA(i, i2, UInt.m717constructorimpl(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
