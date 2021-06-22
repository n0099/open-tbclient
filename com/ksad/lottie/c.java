package com.ksad.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.L;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31954a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f31957d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f31958e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31955b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31956c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f31959f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f31960g = 0;

    public static void a(String str) {
        if (f31954a) {
            Log.d(L.TAG, str);
        }
    }

    public static void b(String str) {
        if (f31955b.contains(str)) {
            return;
        }
        Log.w(L.TAG, str);
        f31955b.add(str);
    }

    public static void c(String str) {
        if (f31956c) {
            int i2 = f31959f;
            if (i2 == 20) {
                f31960g++;
                return;
            }
            f31957d[i2] = str;
            f31958e[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f31959f++;
        }
    }

    public static float d(String str) {
        int i2 = f31960g;
        if (i2 > 0) {
            f31960g = i2 - 1;
            return 0.0f;
        } else if (f31956c) {
            int i3 = f31959f - 1;
            f31959f = i3;
            if (i3 != -1) {
                if (str.equals(f31957d[i3])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f31958e[f31959f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f31957d[f31959f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
