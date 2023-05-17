package kotlin.reflect.jvm.internal.impl.utils;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes10.dex */
public final class NumberWithRadix {
    public final String number;
    public final int radix;

    public final String component1() {
        return this.number;
    }

    public final int component2() {
        return this.radix;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof NumberWithRadix) {
                NumberWithRadix numberWithRadix = (NumberWithRadix) obj;
                return Intrinsics.areEqual(this.number, numberWithRadix.number) && this.radix == numberWithRadix.radix;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.number;
        return ((str != null ? str.hashCode() : 0) * 31) + this.radix;
    }

    public String toString() {
        return "NumberWithRadix(number=" + this.number + ", radix=" + this.radix + SmallTailInfo.EMOTION_SUFFIX;
    }

    public NumberWithRadix(String str, int i) {
        this.number = str;
        this.radix = i;
    }
}
