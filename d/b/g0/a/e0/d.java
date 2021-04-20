package d.b.g0.a.e0;

import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.b.g0.a.z1.h;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44261a;

        public a(String str) {
            this.f44261a = str;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            d.c(this.f44261a, null, i != 1 ? i != 2 ? i != 3 ? "unknown" : "offline" : "bad" : FrsActivityConfig.GOOD);
        }
    }

    public static void a(String str) {
        SwanAppNetworkUtils.b(new a(str));
    }

    public static void b(String str, String str2) {
        c(str, null, str2);
    }

    public static void c(String str, @Nullable String str2, String str3) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47643a = "swan";
        eVar.f47644b = str;
        if (str2 == null) {
            str2 = "";
        }
        eVar.f47646d = str2;
        eVar.a("appid", d.b.g0.a.r1.d.e().getAppId());
        eVar.a(DpStatConstants.KEY_NETWORK_STATUS, str3);
        eVar.a("isShow", c.b() ? "1" : "0");
        h.u("1619", eVar);
    }
}
