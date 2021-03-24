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
    public static final int m1487differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int m940uintRemainderJ1ME1BU = UnsignedKt.m940uintRemainderJ1ME1BU(i, i3);
        int m940uintRemainderJ1ME1BU2 = UnsignedKt.m940uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = UnsignedKt.uintCompare(m940uintRemainderJ1ME1BU, m940uintRemainderJ1ME1BU2);
        int m713constructorimpl = UInt.m713constructorimpl(m940uintRemainderJ1ME1BU - m940uintRemainderJ1ME1BU2);
        return uintCompare >= 0 ? m713constructorimpl : UInt.m713constructorimpl(m713constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    public static final long m1488differenceModulosambcqE(long j, long j2, long j3) {
        long m942ulongRemaindereb3DHEI = UnsignedKt.m942ulongRemaindereb3DHEI(j, j3);
        long m942ulongRemaindereb3DHEI2 = UnsignedKt.m942ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = UnsignedKt.ulongCompare(m942ulongRemaindereb3DHEI, m942ulongRemaindereb3DHEI2);
        long m782constructorimpl = ULong.m782constructorimpl(m942ulongRemaindereb3DHEI - m942ulongRemaindereb3DHEI2);
        return ulongCompare >= 0 ? m782constructorimpl : ULong.m782constructorimpl(m782constructorimpl + j3);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m1489getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        if (j3 > 0) {
            return UnsignedKt.ulongCompare(j, j2) >= 0 ? j2 : ULong.m782constructorimpl(j2 - m1488differenceModulosambcqE(j2, j, ULong.m782constructorimpl(j3)));
        } else if (j3 < 0) {
            return UnsignedKt.ulongCompare(j, j2) <= 0 ? j2 : ULong.m782constructorimpl(j2 + m1488differenceModulosambcqE(j, j2, ULong.m782constructorimpl(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m1490getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            return UnsignedKt.uintCompare(i, i2) >= 0 ? i2 : UInt.m713constructorimpl(i2 - m1487differenceModuloWZ9TVnA(i2, i, UInt.m713constructorimpl(i3)));
        } else if (i3 < 0) {
            return UnsignedKt.uintCompare(i, i2) <= 0 ? i2 : UInt.m713constructorimpl(i2 + m1487differenceModuloWZ9TVnA(i, i2, UInt.m713constructorimpl(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
