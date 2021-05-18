package d.a.i0.a.u.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.a2.e;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.j2.k;
import d.a.i0.a.p.b.a.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<JSONObject>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f44644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44646g;

        public a(b bVar, h hVar, CallbackHandler callbackHandler, String str) {
            this.f44644e = hVar;
            this.f44645f = callbackHandler;
            this.f44646g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<JSONObject> iVar) {
            JSONObject wrapCallbackParams;
            if (iVar.c() && b.s(iVar.f41562a)) {
                JSONObject optJSONObject = iVar.f41562a.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                    k.N("checkSession", "success");
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                    k.O("checkSession", "fail", "session key expired");
                }
            } else {
                wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(iVar.b());
                this.f44644e.g(this.f44645f, wrapCallbackParams.toString());
                k.O("checkSession", "fail", "result failed");
            }
            this.f44645f.handleSchemeDispatchCallback(this.f44646g, wrapCallbackParams.toString());
        }
    }

    public b(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public static boolean s(JSONObject jSONObject) {
        return jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0");
    }

    public d.a.i0.a.u.h.b r(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-CheckSession", "start check session");
        }
        k.N("checkSession", "create");
        h j = d.a.i0.a.c1.b.j();
        CallbackHandler h2 = a().h();
        e Q = e.Q();
        if (Q == null) {
            j.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            k.O("checkSession", "fail", "empty swanApp");
            return new d.a.i0.a.u.h.b(1001, "empty swanApp");
        }
        String D = Q.D();
        if (TextUtils.isEmpty(D)) {
            j.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
            k.O("checkSession", "fail", "empty app key");
            return new d.a.i0.a.u.h.b(1001, "empty app key");
        }
        JSONObject m = d.a.i0.a.u.c.d.m(str);
        if (m == null) {
            j.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            k.O("checkSession", "fail", "empty joParams");
            return new d.a.i0.a.u.h.b(201, "empty joParams");
        }
        String optString = m.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            j.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            k.O("checkSession", "fail", "empty cb");
            return new d.a.i0.a.u.h.b(201, "empty cb");
        }
        Context i2 = i();
        if (!Q.j().e(i2)) {
            j.g(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            k.O("checkSession", "fail", "account not login");
            return new d.a.i0.a.u.h.b(10004, "user not logged in");
        }
        k.N("checkSession", "checkSession");
        d.a.i0.a.e2.c.j.c g2 = d.a.i0.a.a2.d.g().y().a().b().g(i2, D);
        g2.r("checkSession");
        g2.p(new a(this, j, h2, optString));
        g2.a();
        return new d.a.i0.a.u.h.b(0);
    }
}
