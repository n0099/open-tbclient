package d.a.z.i;

import android.os.Build;
/* loaded from: classes2.dex */
public class f {
    public static int a() {
        return "arm64-v8a".equalsIgnoreCase(Build.CPU_ABI) ? 2 : 1;
    }
}
