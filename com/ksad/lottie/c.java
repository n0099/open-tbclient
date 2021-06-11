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
    public static boolean f31856a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f31859d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f31860e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f31857b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31858c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f31861f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f31862g = 0;

    public static void a(String str) {
        if (f31856a) {
            Log.d(L.TAG, str);
        }
    }

    public static void b(String str) {
        if (f31857b.contains(str)) {
            return;
        }
        Log.w(L.TAG, str);
        f31857b.add(str);
    }

    public static void c(String str) {
        if (f31858c) {
            int i2 = f31861f;
            if (i2 == 20) {
                f31862g++;
                return;
            }
            f31859d[i2] = str;
            f31860e[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f31861f++;
        }
    }

    public static float d(String str) {
        int i2 = f31862g;
        if (i2 > 0) {
            f31862g = i2 - 1;
            return 0.0f;
        } else if (f31858c) {
            int i3 = f31861f - 1;
            f31861f = i3;
            if (i3 != -1) {
                if (str.equals(f31859d[i3])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f31860e[f31861f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f31859d[f31861f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
