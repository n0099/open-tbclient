package kotlinx.coroutines.internal;

import com.baidu.android.common.others.IStringUtil;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringNumberConversionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0004\u0010\t\u001a3\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\n2\b\b\u0002\u0010\b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"", "propertyName", "", "defaultValue", "systemProp", "(Ljava/lang/String;Z)Z", "", "minValue", "maxValue", "(Ljava/lang/String;III)I", "", "(Ljava/lang/String;JJJ)J", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes9.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int systemProp(String str, int i, int i2, int i3) {
        return (int) SystemPropsKt.systemProp(str, i, i2, i3);
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp != null) {
            Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(systemProp);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                if (j2 <= longValue && j3 >= longValue) {
                    return longValue;
                }
                throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + IStringUtil.TOP_PATH + j3 + ", but is '" + longValue + '\'').toString());
            }
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
        }
        return j;
    }

    public static final boolean systemProp(String str, boolean z) {
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp != null) {
            return Boolean.parseBoolean(systemProp);
        }
        return z;
    }

    public static /* synthetic */ int systemProp$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i, i2, i3);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j, j4, j3);
    }
}
