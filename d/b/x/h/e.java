package d.b.x.h;

import android.os.Build;
/* loaded from: classes2.dex */
public class e {
    public static int a() {
        return "arm64-v8a".equalsIgnoreCase(Build.CPU_ABI) ? 2 : 1;
    }
}
