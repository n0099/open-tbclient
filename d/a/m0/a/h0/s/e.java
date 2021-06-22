package d.a.m0.a.h0.s;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46353c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46354d;

    /* renamed from: a  reason: collision with root package name */
    public String f46355a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46356b = false;

    static {
        d.a.m0.a.c1.a.Z().getSwitch("swan_sailor_init_delay", false);
        f46354d = false;
    }

    public static boolean a() {
        if (f46353c) {
            Log.d("SwanSailorUpdateModel", "isSailorOptABSwitchOn:" + f46354d);
        }
        return f46354d;
    }

    @NonNull
    public String toString() {
        return "SwanSailorUpdateModel{scene='" + this.f46355a + "'}";
    }
}
