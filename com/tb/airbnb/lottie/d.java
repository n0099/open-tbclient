package com.tb.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes17.dex */
public class d {
    private static String[] AZ;
    private static long[] Ba;
    public static boolean DBG = false;
    private static final Set<String> AX = new HashSet();
    private static boolean AY = false;
    private static int Bb = 0;
    private static int Bc = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!AX.contains(str)) {
            Log.w("LOTTIE", str);
            AX.add(str);
        }
    }

    public static void beginSection(String str) {
        if (AY) {
            if (Bb == 20) {
                Bc++;
                return;
            }
            AZ[Bb] = str;
            Ba[Bb] = System.nanoTime();
            TraceCompat.beginSection(str);
            Bb++;
        }
    }

    public static float bb(String str) {
        if (Bc > 0) {
            Bc--;
            return 0.0f;
        } else if (AY) {
            Bb--;
            if (Bb == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(AZ[Bb])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + AZ[Bb] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - Ba[Bb])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
