package kotlin.internal;

import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", ShaderParams.VALUE_TYPE_STEP, "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    public static final int m1902differenceModuloWZ9TVnA(int i2, int i3, int i4) {
        int m1062uintRemainderJ1ME1BU = UnsignedKt.m1062uintRemainderJ1ME1BU(i2, i4);
        int m1062uintRemainderJ1ME1BU2 = UnsignedKt.m1062uintRemainderJ1ME1BU(i3, i4);
        int uintCompare = UnsignedKt.uintCompare(m1062uintRemainderJ1ME1BU, m1062uintRemainderJ1ME1BU2);
        int m808constructorimpl = UInt.m808constructorimpl(m1062uintRemainderJ1ME1BU - m1062uintRemainderJ1ME1BU2);
        return uintCompare >= 0 ? m808constructorimpl : UInt.m808constructorimpl(m808constructorimpl + i4);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    public static final long m1903differenceModulosambcqE(long j2, long j3, long j4) {
        long m1064ulongRemaindereb3DHEI = UnsignedKt.m1064ulongRemaindereb3DHEI(j2, j4);
        long m1064ulongRemaindereb3DHEI2 = UnsignedKt.m1064ulongRemaindereb3DHEI(j3, j4);
        int ulongCompare = UnsignedKt.ulongCompare(m1064ulongRemaindereb3DHEI, m1064ulongRemaindereb3DHEI2);
        long m886constructorimpl = ULong.m886constructorimpl(m1064ulongRemaindereb3DHEI - m1064ulongRemaindereb3DHEI2);
        return ulongCompare >= 0 ? m886constructorimpl : ULong.m886constructorimpl(m886constructorimpl + j4);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m1904getProgressionLastElement7ftBX0g(long j2, long j3, long j4) {
        int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i2 > 0) {
            return UnsignedKt.ulongCompare(j2, j3) >= 0 ? j3 : ULong.m886constructorimpl(j3 - m1903differenceModulosambcqE(j3, j2, ULong.m886constructorimpl(j4)));
        } else if (i2 < 0) {
            return UnsignedKt.ulongCompare(j2, j3) <= 0 ? j3 : ULong.m886constructorimpl(j3 + m1903differenceModulosambcqE(j2, j3, ULong.m886constructorimpl(-j4)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m1905getProgressionLastElementNkh28Cs(int i2, int i3, int i4) {
        if (i4 > 0) {
            return UnsignedKt.uintCompare(i2, i3) >= 0 ? i3 : UInt.m808constructorimpl(i3 - m1902differenceModuloWZ9TVnA(i3, i2, UInt.m808constructorimpl(i4)));
        } else if (i4 < 0) {
            return UnsignedKt.uintCompare(i2, i3) <= 0 ? i3 : UInt.m808constructorimpl(i3 + m1902differenceModuloWZ9TVnA(i2, i3, UInt.m808constructorimpl(-i4)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
