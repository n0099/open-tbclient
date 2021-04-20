package d.a.a;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41409a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41410b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String[] f41411c;

    /* renamed from: d  reason: collision with root package name */
    public static long[] f41412d;

    /* renamed from: e  reason: collision with root package name */
    public static int f41413e;

    /* renamed from: f  reason: collision with root package name */
    public static int f41414f;

    public static void a(String str) {
        if (f41410b) {
            int i = f41413e;
            if (i == 20) {
                f41414f++;
                return;
            }
            f41411c[i] = str;
            f41412d[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f41413e++;
        }
    }

    public static float b(String str) {
        int i = f41414f;
        if (i > 0) {
            f41414f = i - 1;
            return 0.0f;
        } else if (f41410b) {
            int i2 = f41413e - 1;
            f41413e = i2;
            if (i2 != -1) {
                if (str.equals(f41411c[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f41412d[f41413e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f41411c[f41413e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
