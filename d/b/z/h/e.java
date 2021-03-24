package d.b.z.h;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static int a() {
        return "arm64-v8a".equalsIgnoreCase(Build.CPU_ABI) ? 2 : 1;
    }
}
