package d.a.h0.a.e0;

import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.a.h0.a.z1.h;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41886a;

        public a(String str) {
            this.f41886a = str;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            d.c(this.f41886a, null, i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "offline" : "bad" : FrsActivityConfig.GOOD);
        }
    }

    public static void a(String str) {
        SwanAppNetworkUtils.b(new a(str));
    }

    public static void b(String str, String str2) {
        c(str, null, str2);
    }

    public static void c(String str, @Nullable String str2, String str3) {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45411a = "swan";
        eVar.f45412b = str;
        if (str2 == null) {
            str2 = "";
        }
        eVar.f45414d = str2;
        eVar.a("appid", d.a.h0.a.r1.d.e().getAppId());
        eVar.a(DpStatConstants.KEY_NETWORK_STATUS, str3);
        eVar.a("isShow", c.b() ? "1" : "0");
        h.u("1619", eVar);
    }
}
