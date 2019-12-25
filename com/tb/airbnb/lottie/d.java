package com.tb.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] dM;
    private static long[] dN;
    private static boolean dL = false;
    private static int dO = 0;
    private static int dP = 0;

    public static void beginSection(String str) {
        if (dL) {
            if (dO == 20) {
                dP++;
                return;
            }
            dM[dO] = str;
            dN[dO] = System.nanoTime();
            TraceCompat.beginSection(str);
            dO++;
        }
    }

    public static float F(String str) {
        if (dP > 0) {
            dP--;
            return 0.0f;
        } else if (dL) {
            dO--;
            if (dO == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(dM[dO])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + dM[dO] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - dN[dO])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
