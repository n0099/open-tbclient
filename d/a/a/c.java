package d.a.a;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41120a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f41123d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f41124e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f41121b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41122c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f41125f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f41126g = 0;

    public static void a(String str) {
        if (f41122c) {
            int i = f41125f;
            if (i == 20) {
                f41126g++;
                return;
            }
            f41123d[i] = str;
            f41124e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f41125f++;
        }
    }

    public static void b(String str) {
        if (f41120a) {
            Log.d("LOTTIE", str);
        }
    }

    public static float c(String str) {
        int i = f41126g;
        if (i > 0) {
            f41126g = i - 1;
            return 0.0f;
        } else if (f41122c) {
            int i2 = f41125f - 1;
            f41125f = i2;
            if (i2 != -1) {
                if (str.equals(f41123d[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f41124e[f41125f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f41123d[f41125f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }

    public static void d(String str) {
        if (f41121b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f41121b.add(str);
    }
}
