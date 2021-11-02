package kotlin.internal;

import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tbadk.browser.SearchJsBridge;
import kotlin.Metadata;
import kotlin.PublishedApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u001a'\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\u0007\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u000b\u0010\u0005\u001a'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"", "a", "b", "c", "differenceModulo", "(III)I", "", "(JJJ)J", "start", "end", ShaderParams.VALUE_TYPE_STEP, "getProgressionLastElement", SearchJsBridge.COOKIE_MOD, "(II)I", "(JJ)J", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ProgressionUtilKt {
    public static final int differenceModulo(int i2, int i3, int i4) {
        return mod(mod(i2, i4) - mod(i3, i4), i4);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - differenceModulo(i3, i2, i4);
        } else if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + differenceModulo(i2, i3, -i4);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final int mod(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    public static final long differenceModulo(long j, long j2, long j3) {
        return mod(mod(j, j3) - mod(j2, j3), j3);
    }

    public static final long mod(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    @PublishedApi
    public static final long getProgressionLastElement(long j, long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i2 > 0) {
            return j >= j2 ? j2 : j2 - differenceModulo(j2, j, j3);
        } else if (i2 < 0) {
            return j <= j2 ? j2 : j2 + differenceModulo(j, j2, -j3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
