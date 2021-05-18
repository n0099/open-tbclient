package d.a.i0.c.a;

import android.text.TextUtils;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46273a = k.f43025a;

    public boolean a() {
        d.a.i0.a.c1.a.Z().getSwitch("game_bdtls_switcher", false);
        if (f46273a) {
            d.a.i0.a.e0.d.g("BDTLS", "isBdtlsSwitch=false");
        }
        return false;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("ma/game/od/get_user_cloud_storage") || str.contains("ma/game/od/set_user_cloud_storage"));
    }
}
