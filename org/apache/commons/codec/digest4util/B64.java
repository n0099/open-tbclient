package org.apache.commons.codec.digest4util;

import androidx.core.view.ViewCompat;
import java.util.Random;
/* loaded from: classes7.dex */
public class B64 {
    public static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void b64from24bit(byte b2, byte b3, byte b4, int i, StringBuilder sb) {
        int i2 = ((b2 << 16) & ViewCompat.MEASURED_SIZE_MASK) | ((b3 << 8) & 65535) | (b4 & 255);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append(B64T.charAt(i2 & 63));
            i2 >>= 6;
            i = i3;
        }
    }

    public static String getRandomSalt(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(B64T.charAt(new Random().nextInt(64)));
        }
        return sb.toString();
    }
}
