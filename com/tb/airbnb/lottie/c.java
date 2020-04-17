package com.tb.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {
    private static String[] zx;
    private static long[] zy;
    public static boolean DBG = false;
    private static final Set<String> zv = new HashSet();
    private static boolean zw = false;
    private static int zz = 0;
    private static int zA = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!zv.contains(str)) {
            Log.w("LOTTIE", str);
            zv.add(str);
        }
    }

    public static void beginSection(String str) {
        if (zw) {
            if (zz == 20) {
                zA++;
                return;
            }
            zx[zz] = str;
            zy[zz] = System.nanoTime();
            TraceCompat.beginSection(str);
            zz++;
        }
    }

    public static float aV(String str) {
        if (zA > 0) {
            zA--;
            return 0.0f;
        } else if (zw) {
            zz--;
            if (zz == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(zx[zz])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + zx[zz] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - zy[zz])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
