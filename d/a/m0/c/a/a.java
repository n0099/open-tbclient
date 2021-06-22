package d.a.m0.c.a;

import android.text.TextUtils;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50231a = k.f46983a;

    public boolean a() {
        d.a.m0.a.c1.a.Z().getSwitch("game_bdtls_switcher", false);
        if (f50231a) {
            d.a.m0.a.e0.d.g("BDTLS", "isBdtlsSwitch=false");
        }
        return false;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("ma/game/od/get_user_cloud_storage") || str.contains("ma/game/od/set_user_cloud_storage"));
    }
}
