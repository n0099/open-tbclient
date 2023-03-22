package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin._Assertions;
/* loaded from: classes9.dex */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] strArr) {
        int i;
        boolean z = false;
        int i2 = 0;
        for (String str : strArr) {
            i2 += str.length();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (String str2 : strArr) {
            int length = str2.length() - 1;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    i = i3 + 1;
                    bArr[i3] = (byte) str2.charAt(i4);
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    i3 = i;
                }
                i3 = i;
            }
        }
        if (i3 == i2) {
            z = true;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Should have reached the end");
        }
        return bArr;
    }
}
