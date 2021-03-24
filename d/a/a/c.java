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
    public static boolean f41119a = false;

    /* renamed from: d  reason: collision with root package name */
    public static String[] f41122d;

    /* renamed from: e  reason: collision with root package name */
    public static long[] f41123e;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f41120b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41121c = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f41124f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f41125g = 0;

    public static void a(String str) {
        if (f41121c) {
            int i = f41124f;
            if (i == 20) {
                f41125g++;
                return;
            }
            f41122d[i] = str;
            f41123e[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f41124f++;
        }
    }

    public static void b(String str) {
        if (f41119a) {
            Log.d("LOTTIE", str);
        }
    }

    public static float c(String str) {
        int i = f41125g;
        if (i > 0) {
            f41125g = i - 1;
            return 0.0f;
        } else if (f41121c) {
            int i2 = f41124f - 1;
            f41124f = i2;
            if (i2 != -1) {
                if (str.equals(f41122d[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f41123e[f41124f])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f41122d[f41124f] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }

    public static void d(String str) {
        if (f41120b.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        f41120b.add(str);
    }
}
