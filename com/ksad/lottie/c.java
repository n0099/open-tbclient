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
    public static boolean f31617a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f31620d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f31621e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31618b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31619c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f31622f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f31623g = 0;

    public static void a(String str) {
        if (f31617a) {
            Log.d("LOTTIE", str);
        }
    }

    public static void b(String str) {
        if (f31618b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f31618b.add(str);
    }

    public static void c(String str) {
        if (f31619c) {
            int i = f31622f;
            if (i == 20) {
                f31623g++;
                return;
            }
            f31620d[i] = str;
            f31621e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f31622f++;
        }
    }

    public static float d(String str) {
        int i = f31623g;
        if (i > 0) {
            f31623g = i - 1;
            return 0.0f;
        } else if (f31619c) {
            int i2 = f31622f - 1;
            f31622f = i2;
            if (i2 != -1) {
                if (str.equals(f31620d[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f31621e[f31622f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f31620d[f31622f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
