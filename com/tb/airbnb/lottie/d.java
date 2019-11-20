package com.tb.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import com.baidu.android.imsdk.internal.DefaultConfig;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {
    private static String[] cB;
    private static long[] cC;
    private static boolean cA = false;
    private static int cD = 0;
    private static int cE = 0;

    public static void beginSection(String str) {
        if (cA) {
            if (cD == 20) {
                cE++;
                return;
            }
            cB[cD] = str;
            cC[cD] = System.nanoTime();
            TraceCompat.beginSection(str);
            cD++;
        }
    }

    public static float D(String str) {
        if (cE > 0) {
            cE--;
            return 0.0f;
        } else if (cA) {
            cD--;
            if (cD == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(cB[cD])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + cB[cD] + DefaultConfig.TOKEN_SEPARATOR);
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - cC[cD])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
