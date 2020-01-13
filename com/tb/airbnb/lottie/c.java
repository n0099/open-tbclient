package com.tb.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class c {
    private static String[] dL;
    private static long[] dM;
    public static boolean DBG = false;
    private static final Set<String> dJ = new HashSet();
    private static boolean dK = false;
    private static int dN = 0;
    private static int dO = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!dJ.contains(str)) {
            Log.w("LOTTIE", str);
            dJ.add(str);
        }
    }

    public static void beginSection(String str) {
        if (dK) {
            if (dN == 20) {
                dO++;
                return;
            }
            dL[dN] = str;
            dM[dN] = System.nanoTime();
            TraceCompat.beginSection(str);
            dN++;
        }
    }

    public static float F(String str) {
        if (dO > 0) {
            dO--;
            return 0.0f;
        } else if (dK) {
            dN--;
            if (dN == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(dL[dN])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + dL[dN] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - dM[dN])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
