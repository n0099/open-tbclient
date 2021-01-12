package com.ksad.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class c {
    private static String[] d;
    private static long[] e;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7967a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f7968b = new HashSet();
    private static boolean c = false;
    private static int f = 0;
    private static int g = 0;

    public static void a(String str) {
        if (f7967a) {
            Log.d("LOTTIE", str);
        }
    }

    public static void b(String str) {
        if (f7968b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f7968b.add(str);
    }

    public static void c(String str) {
        if (c) {
            if (f == 20) {
                g++;
                return;
            }
            d[f] = str;
            e[f] = System.nanoTime();
            TraceCompat.beginSection(str);
            f++;
        }
    }

    public static float d(String str) {
        if (g > 0) {
            g--;
            return 0.0f;
        } else if (c) {
            f--;
            if (f == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (str.equals(d[f])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - e[f])) / 1000000.0f;
            }
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + d[f] + ".");
        } else {
            return 0.0f;
        }
    }
}
