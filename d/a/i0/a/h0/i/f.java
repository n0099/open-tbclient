package d.a.i0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.a.i0.a.j2.k;
/* loaded from: classes2.dex */
public class f {

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41996a;

        public a(String str) {
            this.f41996a = str;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            f.b(this.f41996a, i2);
        }
    }

    public static void a(String str) {
        SwanAppNetworkUtils.b(new a(str));
    }

    public static void b(String str, int i2) {
        d(str, i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "offline" : "bad" : FrsActivityConfig.GOOD);
    }

    public static void c(String str, g gVar) {
        f(str, gVar.e(), gVar.g(), gVar.f41998b, gVar.f41999c.size(), gVar.f42000d.size(), gVar.a());
    }

    public static void d(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, @Nullable String str3) {
        f(str, str2, str3, 0, 0, 0, 0L);
    }

    public static void f(String str, String str2, @Nullable String str3, int i2, int i3, int i4, long j) {
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43011a = "swan";
        eVar.f43012b = str;
        eVar.a("appid", d.a.i0.a.a2.d.g().getAppId());
        eVar.a(DpStatConstants.KEY_NETWORK_STATUS, str2);
        if (!TextUtils.isEmpty(str3)) {
            eVar.a("request", str3);
            eVar.a("request_total", String.valueOf(i2));
            eVar.a("request_fail", String.valueOf(i3));
            eVar.a("request_slow", String.valueOf(i4));
            eVar.a("error_duration", String.valueOf(j));
        }
        eVar.a("jserror", i.g() ? "1" : "0");
        eVar.a("isShow", e.b() ? "1" : "0");
        k.u("1619", eVar);
    }
}
