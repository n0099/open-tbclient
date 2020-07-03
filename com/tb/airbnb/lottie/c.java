package com.tb.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private static String[] zX;
    private static long[] zY;
    public static boolean DBG = false;
    private static final Set<String> zV = new HashSet();
    private static boolean zW = false;
    private static int zZ = 0;
    private static int Aa = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!zV.contains(str)) {
            Log.w("LOTTIE", str);
            zV.add(str);
        }
    }

    public static void beginSection(String str) {
        if (zW) {
            if (zZ == 20) {
                Aa++;
                return;
            }
            zX[zZ] = str;
            zY[zZ] = System.nanoTime();
            TraceCompat.beginSection(str);
            zZ++;
        }
    }

    public static float aW(String str) {
        if (Aa > 0) {
            Aa--;
            return 0.0f;
        } else if (zW) {
            zZ--;
            if (zZ == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(zX[zZ])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + zX[zZ] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - zY[zZ])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
