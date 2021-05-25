package d.a.l0.h.n0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.webkit.sdk.CookieManager;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.f;
import d.a.l0.a.k;
import d.a.l0.h.m0.c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47504a = k.f43199a;

    /* renamed from: d.a.l0.h.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1035a implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f47505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47506f;

        public C1035a(d.a.l0.a.y.b.a aVar, String str) {
            this.f47505e = aVar;
            this.f47506f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            if (fVar == null || fVar.f41697d || fVar.j != 1) {
                a.c(this.f47505e, "system deny");
            } else {
                a.e(this.f47505e, this.f47506f);
            }
        }
    }

    public static void c(d.a.l0.a.y.b.a aVar, String str) {
        d.a.l0.h.d.c.b bVar = new d.a.l0.h.d.c.b();
        bVar.errMsg = str;
        c.a(aVar, false, bVar);
    }

    public static void d(JsObject jsObject) {
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        e Q = e.Q();
        if (Q == null) {
            c(G, "internal error");
            return;
        }
        String D = G.D("domain", "baidu.com");
        if (f47504a) {
            Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + D);
        }
        Q.T().e("mapp_uuap_info", new C1035a(G, D));
    }

    public static void e(d.a.l0.a.y.b.a aVar, String str) {
        b bVar = new b();
        String cookie = CookieManager.getInstance().getCookie(str);
        if (!TextUtils.isEmpty(cookie)) {
            Map<String, String> f2 = f(cookie);
            bVar.uuap_p_token = f2.get("UUAP_P_TOKEN");
            bVar.uuap_p_token_offline = f2.get("UUAP_P_TOKEN_OFFLINE");
            bVar.uuap_s_token = f2.get("UUAP_S_TOKEN");
        }
        c.a(aVar, true, bVar);
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(";")) {
            if (str2 != null && str2.contains("=")) {
                int indexOf = str2.indexOf("=");
                hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
            }
        }
        return hashMap;
    }
}
