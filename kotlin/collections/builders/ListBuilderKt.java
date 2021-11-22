package kotlin.collections.builders;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\u0010\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0019\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a1\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"E", "", "size", "", "arrayOfUninitializedElements", "(I)[Ljava/lang/Object;", "T", "newSize", "copyOfUninitializedElements", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "index", "", "resetAt", "([Ljava/lang/Object;I)V", "fromIndex", "toIndex", "resetRange", "([Ljava/lang/Object;II)V", "offset", CloudStabilityUBCUtils.KEY_LENGTH, "", "other", "", "subarrayContentEquals", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "", "subarrayContentToString", "([Ljava/lang/Object;II)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ListBuilderKt {
    public static final <E> E[] arrayOfUninitializedElements(int i2) {
        if (i2 >= 0) {
            return (E[]) new Object[i2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] copyOfUninitializedElements(T[] copyOfUninitializedElements, int i2) {
        Intrinsics.checkNotNullParameter(copyOfUninitializedElements, "$this$copyOfUninitializedElements");
        T[] tArr = (T[]) Arrays.copyOf(copyOfUninitializedElements, i2);
        Intrinsics.checkNotNullExpressionValue(tArr, "java.util.Arrays.copyOf(this, newSize)");
        if (tArr != null) {
            return tArr;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final <E> void resetAt(E[] resetAt, int i2) {
        Intrinsics.checkNotNullParameter(resetAt, "$this$resetAt");
        resetAt[i2] = null;
    }

    public static final <E> void resetRange(E[] resetRange, int i2, int i3) {
        Intrinsics.checkNotNullParameter(resetRange, "$this$resetRange");
        while (i2 < i3) {
            resetAt(resetRange, i2);
            i2++;
        }
    }

    public static final <T> boolean subarrayContentEquals(T[] tArr, int i2, int i3, List<?> list) {
        if (i3 != list.size()) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (true ^ Intrinsics.areEqual(tArr[i2 + i4], list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public static final <T> int subarrayContentHashCode(T[] tArr, int i2, int i3) {
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            T t = tArr[i2 + i5];
            i4 = (i4 * 31) + (t != null ? t.hashCode() : 0);
        }
        return i4;
    }

    public static final <T> String subarrayContentToString(T[] tArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append(PreferencesUtil.LEFT_MOUNT);
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(tArr[i2 + i4]);
        }
        sb.append(PreferencesUtil.RIGHT_MOUNT);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
