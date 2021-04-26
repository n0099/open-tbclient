package d.a.h0.a.p.b;

import android.content.Context;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public class f extends d.a.h0.a.w0.c.a {
    @Override // d.a.h0.a.p.c.r
    public String B() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/game/od/set_user_cloud_storage", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String C() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/exchange/list", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public String D() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/subscribe/v1/relation/get", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String E() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/game/od/get_user_info", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String F() {
        return null;
    }

    @Override // d.a.h0.a.p.c.r
    public String G() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/subscribe/v1/relation/receive", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String H() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/game/od/get_user_cloud_storage", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public long I() {
        return 0L;
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest J(Context context, Map<String, String> map) {
        return R("ma/accredit_v1", map);
    }

    @Override // d.a.h0.a.p.c.r
    public String O() {
        return null;
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest P(Context context, Map<String, String> map) {
        return R("ma/user/openid", map);
    }

    public final HttpRequest R(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(S());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : d.a.h0.a.b0.b.b().f41266d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        d.a.h0.k.d.a aVar = new d.a.h0.k.d.a();
        aVar.f47107b = "POST";
        aVar.f47106a = d.a.h0.a.b0.c.u(build.toString());
        aVar.f47109d = d.a.h0.a.v1.c.c.b(map);
        aVar.f47111f = true;
        aVar.f47112g = true;
        aVar.f47113h = false;
        HttpRequestBuilder a2 = d.a.h0.k.e.b.a(aVar);
        d.a.h0.k.e.a.f().s(a2, aVar);
        return a2.build();
    }

    public final String S() {
        return BaseUrlManager.ONLINE_URL;
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest a(Context context, Map<String, String> map) {
        return R("ma/user/checksessionkey", map);
    }

    @Override // d.a.h0.a.p.c.r
    public String b() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/update", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String c() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/minigame/get_game_tencent_ads", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest e(Context context, Map<String, String> map) {
        return R("ma/user/swanid", map);
    }

    @Override // d.a.h0.a.p.c.r
    public String f() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/msgame/adblock", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public String g() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String h() {
        return d.a.h0.a.w0.a.k().f();
    }

    @Override // d.a.h0.a.p.c.r
    public boolean isDebug() {
        return false;
    }

    @Override // d.a.h0.a.p.c.r
    public String k() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/exchange/transfer_report", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public String m() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/user/addiction/polling", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest n(Context context, Map<String, String> map) {
        return R("ma/accredit_data", map);
    }

    @Override // d.a.h0.a.p.c.r
    public String p() {
        return d.a.h0.a.b0.c.u(String.format("%s/api/user/rechargecheck", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public String q() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/game/od/get_friend_cloud_storage", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest s(Context context, Map<String, String> map) {
        return R("ma/login", map);
    }

    @Override // d.a.h0.a.p.c.r
    public String t() {
        return d.a.h0.a.b0.c.u(String.format("%s/user/gamehistory/upload", d.a.h0.a.b0.a.a()));
    }

    @Override // d.a.h0.a.p.c.r
    public HttpRequest u(Context context, Map<String, String> map) {
        return R("ma/open/data", map);
    }

    @Override // d.a.h0.a.p.c.r
    public String v() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/reset", S()));
    }

    @Override // d.a.h0.a.p.c.r
    public String w() {
        return d.a.h0.a.b0.c.u(String.format("%s/ma/game/od/remove_user_cloud_storage", S()));
    }
}
