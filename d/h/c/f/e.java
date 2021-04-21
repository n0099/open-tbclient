package d.h.c.f;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.math.RoundingMode;
/* loaded from: classes6.dex */
public final class e {
    public static void a(boolean z, double d2, RoundingMode roundingMode) {
        if (z) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d2 + " and rounding mode " + roundingMode);
    }

    public static void b(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public static int c(String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    public static void d(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
