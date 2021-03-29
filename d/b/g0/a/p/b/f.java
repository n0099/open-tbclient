package d.b.g0.a.p.b;

import android.content.Context;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public class f extends d.b.g0.a.w0.c.a {
    @Override // d.b.g0.a.p.c.r
    public String A() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/user/addiction/polling", d.b.g0.a.b0.a.a()));
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest B(Context context, Map<String, String> map) {
        return R("ma/accredit_data", map);
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest C(Context context, Map<String, String> map) {
        return R("ma/accredit_v1", map);
    }

    @Override // d.b.g0.a.p.c.r
    public String G() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/user/rechargecheck", d.b.g0.a.b0.a.a()));
    }

    @Override // d.b.g0.a.p.c.r
    public String I() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/game/od/get_friend_cloud_storage", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String L() {
        return null;
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest M(Context context, Map<String, String> map) {
        return R("ma/login", map);
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest N(Context context, Map<String, String> map) {
        return R("ma/user/openid", map);
    }

    @Override // d.b.g0.a.p.c.r
    public String P() {
        return d.b.g0.a.b0.c.u(String.format("%s/user/gamehistory/upload", d.b.g0.a.b0.a.a()));
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest Q(Context context, Map<String, String> map) {
        return R("ma/open/data", map);
    }

    public final HttpRequest R(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(S());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : d.b.g0.a.b0.b.b().f43275d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a();
        aVar.f48880b = "POST";
        aVar.f48879a = d.b.g0.a.b0.c.u(build.toString());
        aVar.f48882d = d.b.g0.a.v1.c.c.b(map);
        aVar.f48884f = true;
        aVar.f48885g = true;
        aVar.f48886h = false;
        HttpRequestBuilder a2 = d.b.g0.k.e.b.a(aVar);
        d.b.g0.k.e.a.f().s(a2, aVar);
        return a2.build();
    }

    public final String S() {
        return BaseUrlManager.ONLINE_URL;
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest a(Context context, Map<String, String> map) {
        return R("ma/user/checksessionkey", map);
    }

    @Override // d.b.g0.a.p.c.r
    public String b() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/update", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String c() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/reset", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String d() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/game/od/remove_user_cloud_storage", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String f() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/minigame/get_game_tencent_ads", d.b.g0.a.b0.a.a()));
    }

    @Override // d.b.g0.a.p.c.r
    public boolean isDebug() {
        return false;
    }

    @Override // d.b.g0.a.p.c.r
    public String k() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/game/od/set_user_cloud_storage", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String l() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/exchange/list", d.b.g0.a.b0.a.a()));
    }

    @Override // d.b.g0.a.p.c.r
    public String m() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/subscribe/v1/relation/get", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String n() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/game/od/get_user_info", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public HttpRequest o(Context context, Map<String, String> map) {
        return R("ma/user/swanid", map);
    }

    @Override // d.b.g0.a.p.c.r
    public String p() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/msgame/adblock", d.b.g0.a.b0.a.a()));
    }

    @Override // d.b.g0.a.p.c.r
    public String q() {
        return null;
    }

    @Override // d.b.g0.a.p.c.r
    public String r() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String s() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/subscribe/v1/relation/receive", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public String t() {
        return d.b.g0.a.w0.a.k().g();
    }

    @Override // d.b.g0.a.p.c.r
    public String v() {
        return d.b.g0.a.b0.c.u(String.format("%s/ma/game/od/get_user_cloud_storage", S()));
    }

    @Override // d.b.g0.a.p.c.r
    public long w() {
        return 0L;
    }

    @Override // d.b.g0.a.p.c.r
    public String y() {
        return d.b.g0.a.b0.c.u(String.format("%s/api/exchange/transfer_report", d.b.g0.a.b0.a.a()));
    }
}
