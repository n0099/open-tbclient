package kotlin.text;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\bH\u0087\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "other", "", "ignoreCase", "equals", "(CCZ)Z", "isSurrogate", "(C)Z", "", "plus", "(CLjava/lang/String;)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/CharsKt")
/* loaded from: classes10.dex */
public class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final boolean equals(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }

    public static /* synthetic */ boolean equals$default(char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return equals(c2, c3, z);
    }

    public static final boolean isSurrogate(char c2) {
        return 55296 <= c2 && 57343 >= c2;
    }

    @InlineOnly
    public static final String plus(char c2, String str) {
        return String.valueOf(c2) + str;
    }
}
