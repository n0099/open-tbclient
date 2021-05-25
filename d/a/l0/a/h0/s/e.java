package d.a.l0.a.h0.s;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42569c = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42570d;

    /* renamed from: a  reason: collision with root package name */
    public String f42571a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42572b = false;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_sailor_init_delay", false);
        f42570d = false;
    }

    public static boolean a() {
        if (f42569c) {
            Log.d("SwanSailorUpdateModel", "isSailorOptABSwitchOn:" + f42570d);
        }
        return f42570d;
    }

    @NonNull
    public String toString() {
        return "SwanSailorUpdateModel{scene='" + this.f42571a + "'}";
    }
}
