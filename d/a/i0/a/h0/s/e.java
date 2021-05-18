package d.a.i0.a.h0.s;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42395c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42396d;

    /* renamed from: a  reason: collision with root package name */
    public String f42397a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42398b = false;

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_sailor_init_delay", false);
        f42396d = false;
    }

    public static boolean a() {
        if (f42395c) {
            Log.d("SwanSailorUpdateModel", "isSailorOptABSwitchOn:" + f42396d);
        }
        return f42396d;
    }

    @NonNull
    public String toString() {
        return "SwanSailorUpdateModel{scene='" + this.f42397a + "'}";
    }
}
