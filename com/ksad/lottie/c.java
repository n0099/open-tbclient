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
    public static boolean f31327a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f31330d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f31331e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31328b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31329c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f31332f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f31333g = 0;

    public static void a(String str) {
        if (f31327a) {
            Log.d("LOTTIE", str);
        }
    }

    public static void b(String str) {
        if (f31328b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f31328b.add(str);
    }

    public static void c(String str) {
        if (f31329c) {
            int i = f31332f;
            if (i == 20) {
                f31333g++;
                return;
            }
            f31330d[i] = str;
            f31331e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f31332f++;
        }
    }

    public static float d(String str) {
        int i = f31333g;
        if (i > 0) {
            f31333g = i - 1;
            return 0.0f;
        } else if (f31329c) {
            int i2 = f31332f - 1;
            f31332f = i2;
            if (i2 != -1) {
                if (str.equals(f31330d[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f31331e[f31332f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f31330d[f31332f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
