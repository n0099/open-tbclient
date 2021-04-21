package d.b.h0.g.j0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.webkit.sdk.CookieManager;
import d.b.h0.a.k;
import d.b.h0.a.v1.c.e;
import d.b.h0.g.e.d.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48957a = k.f45772a;

    /* renamed from: d.b.h0.g.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1001a implements d.b.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48959f;

        public C1001a(c cVar, String str) {
            this.f48958e = cVar;
            this.f48959f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            if (eVar == null || eVar.f47492d || eVar.j != 1) {
                a.c(this.f48958e, "system deny");
            } else {
                a.e(this.f48958e, this.f48959f);
            }
        }
    }

    public static void c(c cVar, String str) {
        d.b.h0.g.e.d.b bVar = new d.b.h0.g.e.d.b();
        bVar.errMsg = str;
        d.b.h0.g.i0.b.a(cVar, false, bVar);
    }

    public static void d(JsObject jsObject) {
        c F = c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            c(F, "internal error");
            return;
        }
        String C = F.C("domain", "baidu.com");
        if (f48957a) {
            Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + C);
        }
        O.R().e("mapp_uuap_info", new C1001a(F, C));
    }

    public static void e(c cVar, String str) {
        b bVar = new b();
        String cookie = CookieManager.getInstance().getCookie(str);
        if (!TextUtils.isEmpty(cookie)) {
            Map<String, String> f2 = f(cookie);
            bVar.uuap_p_token = f2.get("UUAP_P_TOKEN");
            bVar.uuap_p_token_offline = f2.get("UUAP_P_TOKEN_OFFLINE");
            bVar.uuap_s_token = f2.get("UUAP_S_TOKEN");
        }
        d.b.h0.g.i0.b.a(cVar, true, bVar);
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(";")) {
            if (str2 != null && str2.contains("=")) {
                int indexOf = str2.indexOf("=");
                hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(), str2.substring(indexOf + 1));
            }
        }
        return hashMap;
    }
}
