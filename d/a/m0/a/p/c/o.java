package d.a.m0.a.p.c;

import android.content.Context;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public class o extends d.a.m0.a.c1.d.a {
    @Override // d.a.m0.a.p.d.a0
    public String A() {
        return null;
    }

    @Override // d.a.m0.a.p.d.a0
    public long B() {
        return 0L;
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest C(Context context, Map<String, String> map) {
        return M("ma/accredit_v1", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public String I() {
        return d.a.m0.a.d0.c.w(String.format("%s/ma/grs/brand/applist", N()), true);
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest J(Context context, Map<String, String> map) {
        return M("ma/user/openid", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public String L() {
        return String.format("%s/ma/ai", N());
    }

    public final HttpRequest M(String str, Map<String, String> map) {
        HttpUrl parse = HttpUrl.parse(N());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
        for (Map.Entry<String, String> entry : d.a.m0.a.d0.b.b().f45092d.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl build = addPathSegments.build();
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a();
        aVar.f51752b = "POST";
        aVar.f51751a = d.a.m0.a.d0.c.w(build.toString(), true);
        aVar.f51754d = d.a.m0.a.e2.c.d.b(map);
        aVar.f51756f = true;
        aVar.f51757g = true;
        aVar.f51758h = false;
        HttpRequestBuilder a2 = d.a.m0.m.e.b.a(aVar);
        d.a.m0.m.e.a.g().t(a2, aVar);
        return a2.build();
    }

    public final String N() {
        return d.a.m0.a.d0.c.f45093a;
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest a(Context context, Map<String, String> map) {
        return M("ma/user/checksessionkey", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public String b() {
        return d.a.m0.a.d0.c.w(String.format("%s/ma/update", N()), true);
    }

    @Override // d.a.m0.a.p.d.a0
    public String c() {
        return d.a.m0.a.d0.c.v(String.format("%s/ma/history/sync", N()));
    }

    @Override // d.a.m0.a.p.d.a0
    public String e() {
        return String.format("%s/ma/component/comment/bos_auth", "https://ossapi.baidu.com");
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest g(Context context, Map<String, String> map) {
        return M("ma/user/swanid", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public String i() {
        return d.a.m0.a.c1.a.m().a();
    }

    @Override // d.a.m0.a.p.d.a0
    public boolean isDebug() {
        return false;
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest o(Context context, Map<String, String> map) {
        return M("ma/accredit_data", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest r(Context context, Map<String, String> map) {
        return M("ma/login", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public HttpRequest s(Context context, Map<String, String> map) {
        return M("ma/open/data", map);
    }

    @Override // d.a.m0.a.p.d.a0
    public String t() {
        return d.a.m0.a.d0.c.v(String.format("%s/ma/reset", N()));
    }

    @Override // d.a.m0.a.p.d.a0
    public String z() {
        return d.a.m0.a.d0.c.v(String.format("%s/api/subscribe/v1/relation/get", d.a.m0.a.d0.a.c()));
    }
}
