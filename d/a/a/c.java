package d.a.a;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41504a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41505b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String[] f41506c;

    /* renamed from: d  reason: collision with root package name */
    public static long[] f41507d;

    /* renamed from: e  reason: collision with root package name */
    public static int f41508e;

    /* renamed from: f  reason: collision with root package name */
    public static int f41509f;

    public static void a(String str) {
        if (f41505b) {
            int i = f41508e;
            if (i == 20) {
                f41509f++;
                return;
            }
            f41506c[i] = str;
            f41507d[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f41508e++;
        }
    }

    public static float b(String str) {
        int i = f41509f;
        if (i > 0) {
            f41509f = i - 1;
            return 0.0f;
        } else if (f41505b) {
            int i2 = f41508e - 1;
            f41508e = i2;
            if (i2 != -1) {
                if (str.equals(f41506c[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f41507d[f41508e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f41506c[f41508e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
