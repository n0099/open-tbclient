package com.ksad.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31328a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f31331d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f31332e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31329b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31330c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f31333f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f31334g = 0;

    public static void a(String str) {
        if (f31328a) {
            Log.d("LOTTIE", str);
        }
    }

    public static void b(String str) {
        if (f31329b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f31329b.add(str);
    }

    public static void c(String str) {
        if (f31330c) {
            int i = f31333f;
            if (i == 20) {
                f31334g++;
                return;
            }
            f31331d[i] = str;
            f31332e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f31333f++;
        }
    }

    public static float d(String str) {
        int i = f31334g;
        if (i > 0) {
            f31334g = i - 1;
            return 0.0f;
        } else if (f31330c) {
            int i2 = f31333f - 1;
            f31333f = i2;
            if (i2 != -1) {
                if (str.equals(f31331d[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f31332e[f31333f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f31331d[f31333f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
