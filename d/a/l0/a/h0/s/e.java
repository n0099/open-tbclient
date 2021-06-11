package d.a.l0.a.h0.s;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46245c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46246d;

    /* renamed from: a  reason: collision with root package name */
    public String f46247a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46248b = false;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_sailor_init_delay", false);
        f46246d = false;
    }

    public static boolean a() {
        if (f46245c) {
            Log.d("SwanSailorUpdateModel", "isSailorOptABSwitchOn:" + f46246d);
        }
        return f46246d;
    }

    @NonNull
    public String toString() {
        return "SwanSailorUpdateModel{scene='" + this.f46247a + "'}";
    }
}
