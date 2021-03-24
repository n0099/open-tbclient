package d.b.g0.g.i0;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class e {
    public static int a(float f2) {
        return (int) ((f2 * AppRuntime.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(float f2) {
        return f2 / AppRuntime.getAppContext().getResources().getDisplayMetrics().density;
    }
}
