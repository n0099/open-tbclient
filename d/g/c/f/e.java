package d.g.c.f;

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

    public static void b(boolean z, String str, int i2, int i3) {
        if (z) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public static int c(String str, int i2) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " (" + i2 + ") must be > 0");
    }

    public static void d(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
