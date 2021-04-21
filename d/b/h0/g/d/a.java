package d.b.h0.g.d;

import android.text.TextUtils;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48749a = k.f45772a;

    public boolean a() {
        d.b.h0.a.w0.a.N().getSwitch("game_bdtls_switcher", false);
        if (f48749a) {
            d.b.h0.a.c0.c.g("BDTLS", "isBdtlsSwitch=false");
        }
        return false;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("ma/game/od/get_user_cloud_storage") || str.contains("ma/game/od/set_user_cloud_storage"));
    }
}
