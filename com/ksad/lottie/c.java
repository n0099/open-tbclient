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
    public static boolean f31712a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f31715d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f31716e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31713b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31714c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f31717f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f31718g = 0;

    public static void a(String str) {
        if (f31712a) {
            Log.d("LOTTIE", str);
        }
    }

    public static void b(String str) {
        if (f31713b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f31713b.add(str);
    }

    public static void c(String str) {
        if (f31714c) {
            int i = f31717f;
            if (i == 20) {
                f31718g++;
                return;
            }
            f31715d[i] = str;
            f31716e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f31717f++;
        }
    }

    public static float d(String str) {
        int i = f31718g;
        if (i > 0) {
            f31718g = i - 1;
            return 0.0f;
        } else if (f31714c) {
            int i2 = f31717f - 1;
            f31717f = i2;
            if (i2 != -1) {
                if (str.equals(f31715d[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f31716e[f31717f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f31715d[f31717f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
